package com.temp.pos.views.longterm;

import com.temp.pos.models.longterm.LTCItemButtonMenuResult;
import com.temp.pos.models.longterm.LTCItemButtonMenuResultsModel;
import com.temp.pos.models.longterm.LocationConfig;
import com.temp.pos.models.longterm.LocationConfigModel;
import com.temp.pos.models.longterm.LocationIndividual;
import com.temp.pos.services.LTCClient;
import com.temp.pos.utils.LongTerm.VendorDataCache;
import com.temp.pos.utils.TimeZoneUtils;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class LTSaleTranFrame extends JFrame {

    private static final Logger logger = LoggerFactory.getLogger(LTSaleTranFrame.class);
    private JPanel departmentPanel, categoryPanel, saleItemsPanel, billingItemPanel;
    private LTCItemButtonMenuResultsModel menuResults;
    private String UserId = "";
    private LocationConfigModel locationConfigModel;
    private JButton activeDepartmentButton;
    private JButton activeCategoryButton;
    private static final int BUTTON_HEIGHT = 65;

    private JLabel associateLabel, emailLabel, facilityLabel, currencyLabel;
    private JTable billingTable;
    private DefaultTableModel billingModel;
    private Map<Integer, Integer> itemQuantities = new HashMap<>();

    // MODERN COLOR PALETTE (Tailwind/Material 3)
    private static final Color BG_PRIMARY = new Color(249, 250, 251);      // slate-50
    private static final Color BG_SECONDARY = new Color(248, 250, 252);    // slate-100  
    private static final Color BG_CARD = new Color(255, 255, 255);         // white
    private static final Color BG_HEADER = new Color(15, 23, 42);          // slate-900
    private static final Color TEXT_PRIMARY = new Color(17, 24, 39);       // slate-800
    private static final Color TEXT_SECONDARY = new Color(71, 85, 105);    // slate-500
    private static final Color TEXT_MUTED = new Color(148, 163, 184);      // slate-400
    private static final Color ACCENT_SUCCESS = new Color(5, 150, 105);    // emerald-600
    private static final Color ACCENT_DANGER = new Color(239, 68, 68);     // rose-500
    private static final Color BORDER_SUBTLE = new Color(226, 232, 240);   // slate-200
    private static final Color BORDER_HAIRLINE = new Color(241, 245, 249); // slate-100

    // FIXED HEIGHT BUTTON
    private static class FixedHeightButton extends JButton {

        public FixedHeightButton(String text) {
            super(text);
            setMargin(new Insets(5, 10, 5, 10));
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(Integer.MAX_VALUE, BUTTON_HEIGHT);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            return new Dimension(size.width, BUTTON_HEIGHT);
        }

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(100, BUTTON_HEIGHT);
        }
    }

    public LTSaleTranFrame(String userId) {
        UserId = userId;
        setTitle("Concession POS - LT Sale Transaction");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        Font buttonFont = new Font("Arial", Font.BOLD, 22);
        Font smallButtonFont = new Font("Arial", Font.BOLD, 16);
        Font billingFont = new Font("Arial", Font.BOLD, 18);
        Font footerFont = new Font("Arial", Font.BOLD, 18);

        JPanel topContainer = new JPanel();
        topContainer.setLayout(new BoxLayout(topContainer, BoxLayout.Y_AXIS));

        // Header Panel - MODERN DARK
        JPanel headerPanel = createModernHeaderPanel(buttonFont);
        topContainer.add(headerPanel);

        // Department Panel
        JPanel departmentContainer = createLabeledPanel("Departments", buttonFont);
        departmentPanel = new JPanel(new GridLayout(0, 4, 8, 8));
        departmentPanel.setBackground(new Color(190, 190, 190));
        departmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        departmentContainer.add(departmentPanel, BorderLayout.CENTER);
        topContainer.add(departmentContainer);

        // Category Panel
        JPanel categoryContainer = createLabeledPanel("Sales Category", buttonFont);
        categoryPanel = new JPanel(new GridLayout(0, 4, 8, 8));
        categoryPanel.setBackground(new Color(200, 200, 200));
        categoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        categoryContainer.add(categoryPanel, BorderLayout.CENTER);
        topContainer.add(categoryContainer);

        add(topContainer, BorderLayout.NORTH);

        // Bottom Container
        JPanel bottomContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 0;

        // Sale Items Panel
        JPanel saleItemsContainer = createLabeledPanel("Sale Item", buttonFont);
        saleItemsPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        saleItemsPanel.setBackground(new Color(210, 210, 210));
        saleItemsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel fixedSalePanel = new JPanel(new BorderLayout());
        fixedSalePanel.add(saleItemsPanel, BorderLayout.NORTH);
        fixedSalePanel.setPreferredSize(new Dimension(0, 200));
        fixedSalePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        saleItemsContainer.add(fixedSalePanel, BorderLayout.CENTER);
        gbc.gridx = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        bottomContainer.add(saleItemsContainer, gbc);

        // === BILLING TABLE (Perfect Grid) ===
        billingModel = new DefaultTableModel(new Object[][]{},
                new String[]{"Item Description", "Qty", "Unit Price", "Total"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        billingTable = new JTable(billingModel);
        billingTable.setRowHeight(34);
        billingTable.setShowGrid(false);
        billingTable.setIntercellSpacing(new Dimension(0, 0));
        billingTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        billingTable.getTableHeader().setBackground(new Color(243, 244, 246));
        billingTable.getTableHeader().setForeground(new Color(51, 65, 85));
        billingTable.setFont(new Font("Arial", Font.PLAIN, 14));

        // Column widths (35% | 10% | 25% | 30%)
        TableColumnModel tcm = billingTable.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(35);
        tcm.getColumn(1).setPreferredWidth(10);
        tcm.getColumn(2).setPreferredWidth(25);
        tcm.getColumn(3).setPreferredWidth(30);

        // Custom renderers
        tcm.getColumn(0).setCellRenderer(new DescriptionRenderer());
        tcm.getColumn(1).setCellRenderer(new QtyButtonRenderer());
        tcm.getColumn(2).setCellRenderer(new RightAlignRenderer());
        tcm.getColumn(3).setCellRenderer(new RightAlignRenderer());

        // Scroll pane
        JScrollPane billingScrollPane = new JScrollPane(billingTable);
        billingScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_SUBTLE, 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        billingScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        billingScrollPane.setBackground(BG_PRIMARY);
        billingScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_SUBTLE, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        billingScrollPane.getVerticalScrollBar().setUnitIncrement(10);
        billingScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.gridx = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        bottomContainer.add(billingScrollPane, gbc);

        add(bottomContainer, BorderLayout.CENTER);

        // TALLER FOOTER BAR
        JPanel footerBar = createModernFooterBar(footerFont);
        add(footerBar, BorderLayout.SOUTH);

        // Load data
        loadData(userId, billingFont, smallButtonFont);

        setVisible(true);
        populatePanels(buttonFont);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JPanel createModernHeaderPanel(Font buttonFont) {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 8));
        headerPanel.setBackground(BG_HEADER);
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        headerPanel.setOpaque(true);

        associateLabel = new JLabel("Associate: Loading...");
        associateLabel.setFont(buttonFont);
        associateLabel.setForeground(Color.WHITE);

        emailLabel = new JLabel("Email: Loading...");
        emailLabel.setFont(buttonFont);
        emailLabel.setForeground(Color.WHITE);

        facilityLabel = new JLabel("Facility: Loading...");
        facilityLabel.setFont(buttonFont);
        facilityLabel.setForeground(Color.WHITE);

        currencyLabel = new JLabel("Currency: Loading...");
        currencyLabel.setFont(buttonFont);
        currencyLabel.setForeground(Color.WHITE);

        headerPanel.add(facilityLabel);
        headerPanel.add(currencyLabel);
        headerPanel.add(associateLabel);
        headerPanel.add(emailLabel);

        return headerPanel;
    }

    private JPanel createLabeledPanel(String labelText, Font buttonFont) {
        JPanel container = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel label = new JLabel(labelText);
        label.setFont(buttonFont.deriveFont(Font.BOLD, 26));
        label.setForeground(TEXT_PRIMARY);
        labelPanel.setBackground(BG_PRIMARY);
        labelPanel.setBorder(BorderFactory.createLineBorder(BORDER_SUBTLE, 1));
        labelPanel.add(label);
        container.add(labelPanel, BorderLayout.NORTH);
        return container;
    }

    private void loadData(String userId, Font billingFont, Font smallButtonFont) {
        try {
            locationConfigModel = VendorDataCache.getInstance().getLocationConfig(userId);
            LocationConfig cfg = locationConfigModel.getConfigs().get(0);
            menuResults = new LTCClient().getMenuItem(userId, cfg.getLocationUID(), cfg.getContractUID(), 0, 0, 0, 0, 1);

            if (locationConfigModel.getIndividuals() != null && !locationConfigModel.getIndividuals().isEmpty()) {
                LocationIndividual individual = locationConfigModel.getIndividuals().get(0);
                associateLabel.setText("Associate: " + individual.getAssociateName());
                emailLabel.setText("Email: " + individual.getEmailAddress());
            }
            facilityLabel.setText("Facility: " + (cfg.getFacilityName() != null ? cfg.getFacilityName() : "Kathlyrn Barber Shop"));
            currencyLabel.setText("Currency: " + cfg.getDefaultCurrency());

            updateBillingItemPanel(billingFont, smallButtonFont);
        } catch (Exception e) {
            logger.error("Error loading data: {}", e.getMessage(), e);
            associateLabel.setText("Associate: Error");
            facilityLabel.setText("Facility: Error");
            currencyLabel.setText("Currency: EUR");
        }
    }

    private void populatePanels(Font buttonFont) {
        int frameWidth = getWidth();
        int uniformButtonWidth = Math.max(180, (frameWidth - 50) / 4);

        populateDepartmentPanel(buttonFont, uniformButtonWidth);
    }

    private void populateDepartmentPanel(Font buttonFont, int uniformButtonWidth) {
        departmentPanel.removeAll();
        activeDepartmentButton = null;

        if (menuResults == null || menuResults.getItemButtonMenuResults() == null) {
            return;
        }

        Map<Integer, Integer> deptOrders = new HashMap<>();
        Map<Integer, String> deptNames = new HashMap<>();

        for (LTCItemButtonMenuResult result : menuResults.getItemButtonMenuResults()) {
            int deptUID = result.getDepartmentUID();
            deptOrders.compute(deptUID, (k, v) -> v == null ? result.getDisplayOrder() : Math.min(v, result.getDisplayOrder()));
            deptNames.putIfAbsent(deptUID, result.getDepartmentName());
        }

        List<Map.Entry<Integer, Integer>> sortedDepts = new ArrayList<>(deptOrders.entrySet());
        sortedDepts.sort(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : sortedDepts) {
            FixedHeightButton btn = new FixedHeightButton(deptNames.get(entry.getKey()));
            btn.setFont(buttonFont);
            btn.setBackground(new Color(220, 220, 220));
            btn.addActionListener(e -> {
                if (activeDepartmentButton != null) {
                    activeDepartmentButton.setBackground(new Color(220, 220, 220));
                }
                btn.setBackground(new Color(100, 150, 255));
                activeDepartmentButton = btn;
                populateCategoryPanel(entry.getKey(), buttonFont, uniformButtonWidth);
            });
            departmentPanel.add(btn);
        }

        departmentPanel.revalidate();
        departmentPanel.repaint();

        if (!sortedDepts.isEmpty()) {
            Component[] components = departmentPanel.getComponents();
            if (components.length > 0) {
                ((FixedHeightButton) components[0]).doClick();
            }
        }
    }

    private void populateCategoryPanel(int deptUID, Font buttonFont, int uniformButtonWidth) {
        categoryPanel.removeAll();
        activeCategoryButton = null;

        List<LTCItemButtonMenuResult> deptItems = menuResults.getItemButtonMenuResults().stream()
                .filter(r -> r.getDepartmentUID() == deptUID)
                .collect(Collectors.toList());

        Map<Integer, Integer> catOrders = new HashMap<>();
        Map<Integer, String> catNames = new HashMap<>();

        for (LTCItemButtonMenuResult item : deptItems) {
            int catID = item.getSalesCategoryID();
            catOrders.compute(catID, (k, v) -> v == null ? item.getDisplayOrder() : Math.min(v, item.getDisplayOrder()));
            catNames.putIfAbsent(catID, item.getSalesCategoryDescription());
        }

        List<Map.Entry<Integer, Integer>> sortedCats = new ArrayList<>(catOrders.entrySet());
        sortedCats.sort(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : sortedCats) {
            FixedHeightButton btn = new FixedHeightButton(catNames.get(entry.getKey()));
            btn.setFont(buttonFont);
            btn.setBackground(new Color(220, 220, 220));
            btn.addActionListener(e -> {
                if (activeCategoryButton != null) {
                    activeCategoryButton.setBackground(new Color(220, 220, 220));
                }
                btn.setBackground(new Color(100, 150, 255));
                activeCategoryButton = btn;
                populateSaleItemsPanel(deptUID, entry.getKey(), buttonFont);
            });
            categoryPanel.add(btn);
        }

        categoryPanel.revalidate();
        categoryPanel.repaint();

        if (!sortedCats.isEmpty()) {
            Component[] components = categoryPanel.getComponents();
            if (components.length > 0) {
                ((FixedHeightButton) components[0]).doClick();
            }
        }
    }

    private void populateSaleItemsPanel(int deptUID, int catID, Font buttonFont) {
        saleItemsPanel.removeAll();

        List<LTCItemButtonMenuResult> items = menuResults.getItemButtonMenuResults().stream()
                .filter(r -> r.getDepartmentUID() == deptUID && r.getSalesCategoryID() == catID)
                .sorted(Comparator.comparingInt(LTCItemButtonMenuResult::getDisplayOrderItem))
                .collect(Collectors.toList());

        for (LTCItemButtonMenuResult item : items) {
            FixedHeightButton btn = new FixedHeightButton(item.getSalesItemDescription());
            btn.setFont(buttonFont);
            btn.setBackground(new Color(230, 230, 230));
            btn.addActionListener(e -> handleSaleItemClick(item));
            saleItemsPanel.add(btn);
        }

        saleItemsPanel.revalidate();
        saleItemsPanel.repaint();
    }

    private void handleSaleItemClick(LTCItemButtonMenuResult item) {
        int itemId = item.getSalesItemID();
        itemQuantities.put(itemId, itemQuantities.getOrDefault(itemId, 0) + 1);
        updateBillingItemPanel(new Font("Arial", Font.BOLD, 18), new Font("Arial", Font.BOLD, 16));
        logger.info("Added: {} (ID: {}, Qty: {})", item.getSalesItemDescription(), itemId, itemQuantities.get(itemId));
    }

    private void updateBillingItemPanel(Font billingFont, Font smallButtonFont) {
        billingModel.setRowCount(0); // Clear

        double grandTotal = 0;
        for (Map.Entry<Integer, Integer> entry : itemQuantities.entrySet()) {
            int itemId = entry.getKey();
            int qty = entry.getValue();
            if (qty <= 0) {
                continue;
            }

            LTCItemButtonMenuResult item = menuResults.getItemButtonMenuResults().stream()
                    .filter(r -> r.getSalesItemID() == itemId).findFirst().orElse(null);
            if (item == null) {
                continue;
            }

            double unitPrice = item.getPrice();
            double rowTotal = qty * unitPrice;
            grandTotal += rowTotal;

            billingModel.addRow(new Object[]{
                item.getSalesItemDescription(),
                new Object[]{itemId, qty}, // For QtyButtonRenderer
                String.format("€%.2f", unitPrice),
                String.format("€%.2f", rowTotal)
            });
        }

        // Update total label (you can add a footer row later)
        // Or keep external total label
        refreshTotalLabel(grandTotal);
    }

    private void refreshTotalLabel(double total) {
        // You'll need a JLabel in footer or below table
        // Example: totalLabel.setText(String.format("€%.2f", total));
    }

    public void refreshBillingTable() {
        updateBillingItemPanel(null, null);
    }

    /* ------------------- DESCRIPTION CELL ------------------- */
    static class DescriptionRenderer extends DefaultTableCellRenderer {

        public DescriptionRenderer() {
            setHorizontalAlignment(LEFT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            setFont(new Font("Arial", Font.PLAIN, 14));
            setForeground(TEXT_PRIMARY);
            setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
            return this;
        }
    }

    /* ------------------- QTY BUTTON CELL ------------------- */
    static class QtyButtonRenderer extends JPanel implements TableCellRenderer {

        private final JButton minus = new JButton("−");
        private final JTextField qty = new JTextField(2);
        private final JButton plus = new JButton("+");

        public QtyButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));
            setOpaque(true);

            minus.setPreferredSize(new Dimension(24, 24));
            minus.setMargin(new Insets(0, 0, 0, 0));
            minus.setBackground(ACCENT_DANGER);
            minus.setForeground(Color.WHITE);
            minus.setFocusPainted(false);

            qty.setPreferredSize(new Dimension(28, 24));
            qty.setHorizontalAlignment(JTextField.CENTER);
            qty.setFont(new Font("Arial", Font.BOLD, 14));
            qty.setEditable(false);
            qty.setBackground(BG_CARD);
            qty.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_HAIRLINE, 1),
                    BorderFactory.createEmptyBorder(1, 3, 1, 3)));

            plus.setPreferredSize(new Dimension(24, 24));
            plus.setMargin(new Insets(0, 0, 0, 0));
            plus.setBackground(ACCENT_SUCCESS);
            plus.setForeground(Color.WHITE);
            plus.setFocusPainted(false);

            add(minus);
            add(qty);
            add(plus);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            // value = [itemId, qty]
            Object[] data = (Object[]) value;
            int itemId = (Integer) data[0];
            int currentQty = (Integer) data[1];

            qty.setText(String.valueOf(currentQty));
            setBackground(row % 2 == 0 ? BG_CARD : BG_SECONDARY);

            // Attach actions
            minus.removeActionListener(minus.getActionListeners().length > 0 ? minus.getActionListeners()[0] : null);
            plus.removeActionListener(plus.getActionListeners().length > 0 ? plus.getActionListeners()[0] : null);

            minus.addActionListener(e -> {
                LTSaleTranFrame frame = (LTSaleTranFrame) SwingUtilities.getWindowAncestor(this);
                int newQty = frame.itemQuantities.getOrDefault(itemId, 0) - 1;
                if (newQty <= 0) {
                    frame.itemQuantities.remove(itemId);
                } else {
                    frame.itemQuantities.put(itemId, newQty);
                }
                frame.refreshBillingTable();
            });

            plus.addActionListener(e -> {
                LTSaleTranFrame frame = (LTSaleTranFrame) SwingUtilities.getWindowAncestor(this);
                LTCItemButtonMenuResult item = frame.menuResults.getItemButtonMenuResults().stream()
                        .filter(r -> r.getSalesItemID() == itemId).findFirst().orElse(null);
                if (item != null) {
                    frame.handleSaleItemClick(item);
                }
            });

            return this;
        }
    }

    /* ------------------- RIGHT-ALIGN CELL ------------------- */
    static class RightAlignRenderer extends DefaultTableCellRenderer {

        public RightAlignRenderer() {
            setHorizontalAlignment(RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            setFont(new Font("Arial", col == 2 ? Font.BOLD : Font.BOLD, 14));
            setForeground(col == 2 ? TEXT_SECONDARY : ACCENT_SUCCESS);
            setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 16));
            return this;
        }
    }

    private JPanel createModernFooterBar(Font footerFont) {

        JPanel footerBar = new JPanel(new GridLayout(1, 4, 12, 0));
        footerBar.setBackground(BG_HEADER);
        footerBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, ACCENT_SUCCESS),
                BorderFactory.createEmptyBorder(18, 20, 18, 20)
        ));
        footerBar.setOpaque(true);

        // === BUTTON DEFINITIONS WITH HOVER ===
        JButton customerBtn = createHoverButton("Customer", new Color(59, 130, 246), new Color(100, 149, 237)); // Blue
        JButton checkoutBtn = createHoverButton("Checkout", ACCENT_SUCCESS, ACCENT_SUCCESS.brighter());
        JButton ticketLookupBtn = createHoverButton("Ticket Lookup", new Color(251, 191, 36), new Color(255, 204, 77));  // Amber
        JButton cancelBtn = createHoverButton("Cancel", ACCENT_DANGER, ACCENT_DANGER.brighter());

        // === SET FONT & ACTION ===
        customerBtn.setFont(footerFont);
        checkoutBtn.setFont(footerFont);
        ticketLookupBtn.setFont(footerFont);
        cancelBtn.setFont(footerFont);

        customerBtn.addActionListener(e -> logger.info("Customer button clicked"));
        checkoutBtn.addActionListener(e -> {
            double total = itemQuantities.entrySet().stream()
                    .filter(entry -> entry.getValue() > 0)
                    .mapToDouble(entry -> {
                        LTCItemButtonMenuResult itm = menuResults.getItemButtonMenuResults().stream()
                                .filter(r -> r.getSalesItemID() == entry.getKey())
                                .findFirst().orElse(null);
                        return itm != null ? entry.getValue() * itm.getPrice() : 0;
                    }).sum();
            logger.info("Checkout clicked – Total: €{:.2f}", total);
        });
        ticketLookupBtn.addActionListener(e -> logger.info("Ticket Lookup clicked"));
        cancelBtn.addActionListener(e -> {
            logger.info("Cancel clicked");
            int result = JOptionPane.showConfirmDialog(this,
                    "Clear all items and start new transaction?",
                    "Confirm Cancel", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                itemQuantities.clear();
                updateBillingItemPanel(new Font("Arial", Font.BOLD, 18), new Font("Arial", Font.BOLD, 16));
            }
        });

        footerBar.add(customerBtn);
        footerBar.add(checkoutBtn);
        footerBar.add(ticketLookupBtn);
        footerBar.add(cancelBtn);

        return footerBar;
    }

    private void styleFooterButton(JButton button, Font font, Color bgColor, Color textColor) {

        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setMargin(new Insets(12, 20, 12, 20)); // 50% taller buttons

        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(bgColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }

    private JButton createHoverButton(String text, Color baseColor, Color hoverColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setForeground(Color.WHITE);
        btn.setBackground(baseColor);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setMargin(new Insets(12, 24, 12, 24));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(baseColor);
            }
        });

        return btn;
    }
}

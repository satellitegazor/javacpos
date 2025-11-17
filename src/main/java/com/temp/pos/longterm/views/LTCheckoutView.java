// src/main/java/com/temp/pos/views/longterm/LTCheckout.java
package com.temp.pos.longterm.views;

import com.temp.pos.longterm.controllers.LTSaleController;
import com.temp.pos.longterm.models.SaleState;
import com.temp.pos.longterm.models.SalesTransactionCheckoutItem;
import com.temp.pos.longterm.models.TicketTender;
import com.temp.pos.longterm.models.Vendor;
import com.temp.pos.services.LTCClient;
import com.temp.pos.utils.LongTerm.VendorDataCache;
import com.temp.pos.utils.SVGIcon;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LTCheckoutView extends JPanel {

    private LTSaleController controller;
    private LTCClient ltcClient;
    private JTable itemsTable;
    private DefaultTableModel tableModel;
    private JFrame _parent;
    private JLabel totalLabel;

    public LTCheckoutView(JFrame parent) {
        _parent = parent;
    }

    public LTCheckoutView(LTSaleController controller, LTCClient ltcClient) {
        this.controller = controller;
        this.ltcClient = ltcClient;

        setLayout(new BorderLayout());

        createNavbar();
        createItemsTablePanel();
        createMainPanel();
        createFooter();
    }

    private void createItemsTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Header + Total
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("Checkout Items");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        header.add(title, BorderLayout.WEST);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBackground(Color.WHITE);
        JLabel totalTxt = new JLabel("Total: ");
        totalTxt.setFont(new Font("Arial", Font.BOLD, 28));
        totalLabel = new JLabel("€0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 36));
        totalLabel.setForeground(new Color(25, 135, 84));
        totalPanel.add(totalTxt);
        totalPanel.add(totalLabel);
        header.add(totalPanel, BorderLayout.EAST);

        panel.add(header, BorderLayout.NORTH);

        // Table
        String[] columns = {
                "Item Description", "Serviced By", "Qty", "Unit Price", "Discount", "Exch. Coupon", "Sales Tax", "Line Total"
        };
        tableModel = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };

        itemsTable = new JTable(tableModel);
        itemsTable.setFont(new Font("Arial", Font.PLAIN, 16));
        itemsTable.setRowHeight(40);
        itemsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        itemsTable.getTableHeader().setBackground(new Color(230, 230, 230));

        // Column widths & alignment
        itemsTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        itemsTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        itemsTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        itemsTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        itemsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        itemsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        itemsTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        itemsTable.getColumnModel().getColumn(7).setPreferredWidth(120);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        itemsTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        itemsTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        itemsTable.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        itemsTable.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        itemsTable.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        itemsTable.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

        JScrollPane scroll = new JScrollPane(itemsTable);
        scroll.setPreferredSize(new Dimension(800, 400));
        panel.add(scroll, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    private void createNavbar() {
        JPanel nav = new JPanel(new BorderLayout());
        nav.setBackground(new Color(248, 249, 250));
        nav.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)));

        JLabel brand = new JLabel("Concession POS - Europe", SwingConstants.LEFT);
        brand.setFont(new Font("Arial", Font.BOLD, 20));
        brand.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 0));
        nav.add(brand, BorderLayout.WEST);

        JLabel signIn = new JLabel("Application Sign-in");
        signIn.setFont(new Font("Arial", Font.PLAIN, 14));
        signIn.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 24));
        nav.add(signIn, BorderLayout.EAST);

        add(nav, BorderLayout.NORTH);
    }

    private void createMainPanel() {
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.WHITE);

        // Total Display
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBackground(Color.WHITE);
        totalPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));

        JLabel lbl = new JLabel("Total: ");
        lbl.setFont(new Font("Arial", Font.BOLD, 28));
        totalLabel = new JLabel("€0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 36));
        totalLabel.setForeground(new Color(25, 135, 84));

        totalPanel.add(lbl);
        totalPanel.add(totalLabel);
        main.add(totalPanel, BorderLayout.NORTH);

        // Payment Buttons Grid
        JPanel grid = new JPanel(new GridLayout(2, 3, 20, 20));
        grid.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        grid.setBackground(Color.WHITE);

        grid.add(createPaymentButton("Cash", "cash.svg", "CASH"));
        grid.add(createPaymentButton("Credit Card", "credit-card.svg", "CREDIT"));
        grid.add(createPaymentButton("Debit Card", "debit-card.svg", "DEBIT"));
        grid.add(createPaymentButton("Eagle Cash", "eagle-cash.svg", "EAGLE_CASH"));
        grid.add(createPaymentButton("Split Pay", "split-pay.svg", "SPLIT"));

        main.add(grid, BorderLayout.CENTER);
        add(main, BorderLayout.CENTER);

        updateTotal();
    }

    private JButton createPaymentButton(String text, String iconName, String tenderType) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 123, 255));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setPreferredSize(new Dimension(240, 140));
        btn.setIcon(SVGIcon.load(iconName, 48, 48));
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setMargin(new Insets(12, 12, 12, 12));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(0, 105, 217));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(0, 123, 255));
            }
        });

        btn.addActionListener(e -> {
            if ("SPLIT".equals(tenderType)) {
                JOptionPane.showMessageDialog(this, "Split Pay coming soon!");
            } else {
                processPayment(tenderType);
            }
        });

        return btn;
    }

    private void processPayment(String tenderType) {
        double total = controller.getCurrentState().getTotal();
        if (total == 0) {
            JOptionPane.showMessageDialog(this, "No items in sale.");
            return;
        }

        TicketTender tender = new TicketTender();
        tender.setTenderType(tenderType);
        tender.setAmount(total);

        // In real app: send to backend via ltcClient
        //controller.completeSale(tender);

        JOptionPane.showMessageDialog(this,
                "Payment of €" + String.format("%.2f", total) + " processed with " + tenderType,
                "Payment Complete", JOptionPane.INFORMATION_MESSAGE);

        //dispose();
    }

    private void updateTotal() {
        double total = controller.getCurrentState().getTotal();
        totalLabel.setText("€" + String.format("%.2f", total));
    }

    private void createFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 12));
        footer.setBackground(new Color(248, 249, 250));
        footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(226, 232, 240)));

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(new Color(108, 117, 125));
        cancel.setForeground(Color.WHITE);
        cancel.setPreferredSize(new Dimension(140, 44));
        //cancel.addActionListener(e -> dispose());

        footer.add(cancel);
        add(footer, BorderLayout.SOUTH);
    }

    private void updateItemsAndTotal() {
        tableModel.setRowCount(0);
        SaleState state = controller.getCurrentState();
        List<SalesTransactionCheckoutItem> items = state.getTicket().getItems();

        double grandTotal = 0;
        for (SalesTransactionCheckoutItem item : items) {
            double lineTotal = item.getLineTotal();
            grandTotal += lineTotal;

            VendorDataCache dataCache = VendorDataCache.getInstance();
            String servicedBy = dataCache.getLocationAssociates(item.getServicedBy()).getAssociateName();

            tableModel.addRow(new Object[]{
                    item.getSalesItemDescription(),
                    servicedBy,
                    String.format("%.0f", item.getQuantity()),
                    String.format("€%.2f", item.getUnitPrice()),
                    item.getDiscountAmount() > 0 ? String.format("€%.2f", item.getDiscountAmount()) : "",
                    "", // Exch. Coupon
                    String.format("€%.2f", item.getTaxAmount()),
                    String.format("€%.2f", lineTotal)
            });
        }

        totalLabel.setText("€" + String.format("%.2f", grandTotal));
    }
}
package com.temp.pos.views;

import com.temp.pos.longterm.models.LTCCustomer;
import com.temp.pos.longterm.controllers.SaleController;
import com.temp.pos.services.CommonClient; // <-- NEW

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerSearchDialog extends JDialog {
    private static final Logger logger = LoggerFactory.getLogger(CustomerSearchDialog.class);
    private final CommonClient commonClient;
    private final JTextField txtPhone;
    private final JTextField txtFirstName;
    private final JTextField txtLastName;
    private final JPanel resultsPanel;
    private final JButton searchBtn;
    private LTCCustomer selectedCustomer;
    private SaleController _controller;

    public CustomerSearchDialog(Frame owner, CommonClient commonClient, SaleController controller) {
        super(owner, "Customer Lookup", true);
        this.commonClient = commonClient;
        setSize(520, 620);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());
        _controller = controller;

        // === HEADER ===
        JLabel title = new JLabel("Customer Lookup", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(new EmptyBorder(12, 0, 8, 0));
        add(title, BorderLayout.NORTH);

        // === SEARCH FORM ===
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(new EmptyBorder(16, 24, 16, 24));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 0, 6, 0);

        gbc.gridx = 0; gbc.weightx = 0.3;
        form.add(new JLabel("Telephone"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        txtPhone = new JTextField();
        form.add(txtPhone, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("First Name"), gbc);
        gbc.gridx = 1;
        txtFirstName = new JTextField();
        form.add(txtFirstName, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Last Name"), gbc);
        gbc.gridx = 1;
        txtLastName = new JTextField();
        form.add(txtLastName, gbc);

        add(form, BorderLayout.NORTH);

        // === RESULTS PANEL ===
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBorder(new EmptyBorder(8, 8, 8, 8));

        JScrollPane scroll = new JScrollPane(resultsPanel);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));
        add(scroll, BorderLayout.CENTER);

        // === FOOTER ===
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
        footer.setBorder(new EmptyBorder(8, 0, 12, 0));

        searchBtn = createFooterButton("Search", new Color(13, 110, 253));
        JButton cancelBtn = createFooterButton("Cancel", new Color(108, 117, 125));
        JButton newCustBtn = createFooterButton("New Customer", new Color(25, 135, 84));

        searchBtn.addActionListener(e -> performSearchAsync());
        cancelBtn.addActionListener(e -> dispose());
        newCustBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "New Customer form not implemented.");
        });

        footer.add(searchBtn);
        footer.add(cancelBtn);
        footer.add(newCustBtn);
        add(footer, BorderLayout.SOUTH);

        showEmptyResults();
    }

    private JButton createFooterButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(130, 38));
        Color hover = bg.brighter();
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { btn.setBackground(hover); }
            public void mouseExited(java.awt.event.MouseEvent evt) { btn.setBackground(bg); }
        });
        return btn;
    }

    // === ASYNC SEARCH USING CommonClient ===
    private void performSearchAsync() {

        String first = txtFirstName.getText().trim();
        String last = txtLastName.getText().trim();
        String phone = txtPhone.getText().trim();

        if (phone.isEmpty() && first.isEmpty() && last.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter at least one search field.");
            return;
        }

        searchBtn.setEnabled(false);
        searchBtn.setText("Searching...");
        showLoading();

        CompletableFuture.supplyAsync(() -> {
            try {
                return commonClient.getCustomerLookup(first, last, phone);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }).thenAcceptAsync(results -> {
            logger.info("Customer count: " + results.size());
            SwingUtilities.invokeLater(() -> {
                searchBtn.setEnabled(true);
                searchBtn.setText("Search");
                displayResults(results);
            });
        }, SwingUtilities::invokeLater).exceptionally(ex -> {
            SwingUtilities.invokeLater(() -> {
                searchBtn.setEnabled(true);
                searchBtn.setText("Search");
                JOptionPane.showMessageDialog(this,
                    "Search failed: " + ex.getCause().getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
                showEmptyResults();
            });
            return null;
        });
    }

    private void showLoading() {
        resultsPanel.removeAll();
        JLabel loading = new JLabel("Searching customers...", SwingConstants.CENTER);
        loading.setFont(new Font("Arial", Font.ITALIC, 14));
        loading.setForeground(new Color(108, 117, 125));
        loading.setBorder(new EmptyBorder(60, 0, 60, 0));
        resultsPanel.add(loading);
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    private void displayResults(List<LTCCustomer> customers) {
        resultsPanel.removeAll();
        if (customers.isEmpty()) {
            JLabel lbl = new JLabel("No customers found.");
            lbl.setForeground(new Color(108, 117, 125));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            lbl.setBorder(new EmptyBorder(40, 0, 40, 0));
            resultsPanel.add(lbl);
        } else {
            for (LTCCustomer cust : customers) {
                
                String display = String.format("%s (ID: %d)%s",
                    cust.getCustomerName(),
                    cust.getCustomerId(),
                    cust.IsTaxExempt() ? " [Tax Exempt]" : ""
                );
                JButton btn = new JButton(display);
                btn.setFont(new Font("Arial", Font.PLAIN, 15));
                btn.setHorizontalAlignment(SwingConstants.LEFT);
                btn.setPreferredSize(new Dimension(Integer.MAX_VALUE, 44));
                btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
                btn.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(226, 232, 240)),
                    new EmptyBorder(0, 12, 0, 12)
                ));
                btn.setBackground(Color.WHITE);
                btn.setFocusPainted(false);

                btn.addActionListener(e -> {
                    selectedCustomer = cust;
                    _controller.assignCustomer(selectedCustomer);
                    dispose();
                });

                resultsPanel.add(btn);
            }
        }
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    private void showEmptyResults() {
        resultsPanel.removeAll();
        JLabel lbl = new JLabel("Enter search criteria and click Search.");
        lbl.setForeground(new Color(108, 117, 125));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setBorder(new EmptyBorder(60, 0, 60, 0));
        resultsPanel.add(lbl);
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    public LTCCustomer getSelectedCustomer() {
        return selectedCustomer;
    }

    // === STATIC LAUNCHER ===
    public static LTCCustomer showDialog(Frame owner, CommonClient client, SaleController controller) {
        CustomerSearchDialog dialog = new CustomerSearchDialog(owner, client, controller);
        dialog.setVisible(true);
        return dialog.getSelectedCustomer();
    }
}
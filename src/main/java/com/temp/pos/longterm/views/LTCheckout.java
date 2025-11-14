// src/main/java/com/temp/pos/views/longterm/LTCheckout.java
package com.temp.pos.longterm.views;

import com.temp.pos.longterm.controllers.LTSaleController;
import com.temp.pos.longterm.models.TicketTender;
import com.temp.pos.services.LTCClient;
import com.temp.pos.utils.SVGIcon;

import javax.swing.*;
import java.awt.*;

public class LTCheckout extends JFrame {
    private final LTSaleController controller;
    private final LTCClient ltcClient;

    private JLabel totalLabel;

    public LTCheckout(LTSaleController controller, LTCClient ltcClient) {
        this.controller = controller;
        this.ltcClient = ltcClient;

        setTitle("Concession POS - Checkout");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        createNavbar();
        createMainPanel();
        createFooter();


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
        cancel.addActionListener(e -> dispose());

        footer.add(cancel);
        add(footer, BorderLayout.SOUTH);
    }
}
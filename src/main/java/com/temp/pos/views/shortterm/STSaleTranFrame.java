package com.temp.pos.views.shortterm;

import javax.swing.*;

import com.temp.pos.views.shortterm.STLogonFrame;

import java.awt.*;
import java.awt.event.ActionListener;

public class STSaleTranFrame extends JFrame {
    public STSaleTranFrame() {
        setTitle("Concession POS - ST Module Sales Transaction");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setUndecorated(true); // Remove window borders
        setLayout(new BorderLayout(20, 20));

        // Set larger font for all components
        Font largeFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.BOLD, 28);

        // Header panel with Logout
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        JLabel logoutLabel = new JLabel("Logout");
        logoutLabel.setFont(largeFont);
        headerPanel.add(logoutLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));

        // Barber Service selection
        JPanel servicePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        JComboBox<String> serviceComboBox = new JComboBox<>(new String[]{"Barber Service", "High Volume", "Shave", "Low Volume"});
        serviceComboBox.setFont(largeFont);
        serviceComboBox.setPreferredSize(new Dimension(300, 40));
        servicePanel.add(serviceComboBox);
        mainPanel.add(servicePanel, BorderLayout.NORTH);

        // Sale items table
        String[] columns = {"Sale Item", "Serviced By", "Unit Price", "Total Price"};
        Object[][] data = {
            {"Style Cut", "DEBRA WILLIAMS", "€13.76", "13.76"},
            {"Style Cut", "MAJOR CHANGER", "€13.76", "13.76"},
            {"Style Cut", "RACHELL SANDERS", "€13.76", "13.76"},
            {"Style Cut", "SARAH LEAKS", "€13.76", "13.76"},
            {"Style Cut", "William Dalrymple", "€13.76", "13.76"}
        };
        JTable table = new JTable(data, columns);
        table.setFont(largeFont);
        table.setRowHeight(40); // Larger row height for touch
        table.getTableHeader().setFont(largeFont);
        // Adjust column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton customerButton = new JButton("Customer");
        JButton checkoutButton = new JButton("Checkout");
        JButton saveTicketButton = new JButton("Save Ticket");
        JButton cancelButton = new JButton("Cancel");
        JButton ticketLookupButton = new JButton("Ticket Look-Up");

        // Set button sizes and fonts
        for (JButton button : new JButton[]{customerButton, checkoutButton, saveTicketButton, cancelButton, ticketLookupButton}) {
            button.setFont(buttonFont);
            button.setPreferredSize(new Dimension(200, 60));
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);

        // Button actions (placeholders for functionality)
        customerButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Customer button clicked."));
        checkoutButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Checkout button clicked."));
        saveTicketButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Save Ticket button clicked."));
        cancelButton.addActionListener(e -> {
            // Return to STLogonFrame
            SwingUtilities.invokeLater(() -> {
                STLogonFrame logonFrame = new STLogonFrame();
                logonFrame.setVisible(true);
                dispose();
            });
        });
        ticketLookupButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Ticket Look-Up button clicked."));
    }
}
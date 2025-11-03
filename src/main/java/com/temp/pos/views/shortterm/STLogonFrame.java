package com.temp.pos.views.shortterm;

import com.temp.pos.BaseLogonFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STLogonFrame extends JFrame implements BaseLogonFrame {
    private JTextField vendorNumberField;
    private JComboBox<String> eventComboBox;
    private JPasswordField pinField;
    private JLabel statusLabel;

    public STLogonFrame(String vendorNumber, String pin) {
        setTitle("Concession POS - ST Module Sign-in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        setUndecorated(true); // Remove window borders
        setLayout(new BorderLayout(20, 20));

        // Set larger font for all components
        Font largeFont = new Font("Arial", Font.BOLD, 24);
        Font buttonFont = new Font("Arial", Font.BOLD, 28);

        // Header panel with Logout and Login labels
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        JLabel logoutLabel = new JLabel("Logout");
        logoutLabel.setFont(largeFont);
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(largeFont);
        headerPanel.add(logoutLabel);
        headerPanel.add(loginLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main panel for input fields
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Increased spacing for touch
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Exchange label
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel exchangeLabel = new JLabel("Exchange");
        exchangeLabel.setFont(largeFont);
        mainPanel.add(exchangeLabel, gbc);

        // Vendor Number
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel vendorLabel = new JLabel("Vendor Number");
        vendorLabel.setFont(largeFont);
        mainPanel.add(vendorLabel, gbc);
        gbc.gridx = 1;
        vendorNumberField = new JTextField(vendorNumber, 20);
        vendorNumberField.setFont(largeFont);
        vendorNumberField.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(vendorNumberField, gbc);

        // Event
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel eventLabel = new JLabel("Event");
        eventLabel.setFont(largeFont);
        mainPanel.add(eventLabel, gbc);
        gbc.gridx = 1;
        eventComboBox = new JComboBox<>(new String[]{
            "Spring Festival (2025-06-01 - 2025-06-07)",
            "Summer Expo (2025-07-01 - 2025-07-31)",
            "Autumn Fair (2025-09-15 - 2025-09-22)",
            "Winter Market (2025-12-01 - 2025-12-15)"
        });
        eventComboBox.setFont(largeFont);
        eventComboBox.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(eventComboBox, gbc);

        // PIN
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel pinLabel = new JLabel("PIN");
        pinLabel.setFont(largeFont);
        mainPanel.add(pinLabel, gbc);
        gbc.gridx = 1;
        pinField = new JPasswordField(pin, 20);
        pinField.setFont(largeFont);
        pinField.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(pinField, gbc);

        // Logon button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton logonButton = new JButton("Logon");
        logonButton.setFont(buttonFont);
        logonButton.setPreferredSize(new Dimension(200, 60));
        mainPanel.add(logonButton, gbc);

        // Status label
        gbc.gridx = 0;
        gbc.gridy = 5;
        statusLabel = new JLabel("");
        statusLabel.setFont(largeFont);
        statusLabel.setForeground(Color.RED);
        mainPanel.add(statusLabel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Logon button action
        logonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPin = new String(pinField.getPassword());
                String inputVendorNumber = vendorNumberField.getText();
                String event = (String) eventComboBox.getSelectedItem();

                if (inputPin.equals("1234") && !inputVendorNumber.isEmpty() && event != null) {
                    statusLabel.setForeground(Color.GREEN);
                    statusLabel.setText("Success! Your message has been sent successfully.");
                    SwingUtilities.invokeLater(() -> {
                        JFrame saleTranFrame = getSaleTranFrame();
                        saleTranFrame.setVisible(true);
                        dispose();
                    });
                } else {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Error! Unable to login. Please verify the credentials entered.");
                }
            }
        });
    }

    public STLogonFrame() {
        this("", "");
    }

    @Override
    public JFrame getSaleTranFrame() {
        return new STSaleTranFrame();
    }
}
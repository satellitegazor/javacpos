package com.temp.pos.sbm;

import com.temp.pos.BaseLogonFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SBMLogonFrame extends JFrame implements BaseLogonFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JLabel statusLabel;

    public SBMLogonFrame(String userId, String password) {
        setTitle("Concession POS - SBM Module Sign-in");
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

        // User ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel userIdLabel = new JLabel("User ID");
        userIdLabel.setFont(largeFont);
        mainPanel.add(userIdLabel, gbc);
        gbc.gridx = 1;
        userIdField = new JTextField(userId, 20);
        userIdField.setFont(largeFont);
        userIdField.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(userIdField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(largeFont);
        mainPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(password, 20);
        passwordField.setFont(largeFont);
        passwordField.setPreferredSize(new Dimension(300, 40));
        mainPanel.add(passwordField, gbc);

        // Logon button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton logonButton = new JButton("Logon");
        logonButton.setFont(buttonFont);
        logonButton.setPreferredSize(new Dimension(200, 60));
        mainPanel.add(logonButton, gbc);

        // Status label
        gbc.gridx = 0;
        gbc.gridy = 3;
        statusLabel = new JLabel("");
        statusLabel.setFont(largeFont);
        statusLabel.setForeground(Color.RED);
        mainPanel.add(statusLabel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Logon button action
        logonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPassword = new String(passwordField.getPassword());
                String inputUserId = userIdField.getText();

                if (inputPassword.equals("1234") && !inputUserId.isEmpty()) {
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

    public SBMLogonFrame() {
        this("", "");
    }

    @Override
    public JFrame getSaleTranFrame() {
        return new IndexPage();
    }
}
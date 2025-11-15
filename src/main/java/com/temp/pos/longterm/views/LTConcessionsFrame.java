// src/main/java/com/temp/pos/views/Concessions.java
package com.temp.pos.longterm.views;

import com.temp.pos.longterm.controllers.LTSaleController;

import javax.swing.*;
import java.awt.*;

public class LTConcessionsFrame extends JFrame {
    //private final CardLayout cardLayout;
    //private final JPanel mainPanel;
    private JPanel contentPane;

    private LTLogonView logonPanel; // = new LTLogonView(this);
    private LTSaleTranView saleTranPanel; // = new LTSaleTranView(this);
    private LTSaleController saleController;

    public LTConcessionsFrame() {

        setTitle("Concession POS - Europe");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saleController = new LTSaleController();

        this.contentPane = new JPanel((new BorderLayout()));
        this.contentPane.setBackground(Color.white);
        add(this.contentPane);

        //this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }


    protected void onLoginSuccess(String UserId) {
        System.out.println("In onLoginSuccess");

        saleController.setUserId(UserId);
        showSale(UserId);
    }

    public void showLogon() {
        System.out.println("In showLogon");
//        cardLayout.show(mainPanel, "LOGON");
//        mainPanel.revalidate();
//        mainPanel.repaint();
        //logonPanel.requestFocusInWindow();
        if(saleTranPanel != null) {
            contentPane.remove(saleTranPanel);
            saleTranPanel = null;
        }

        logonPanel = new LTLogonView(this);
        contentPane.add(logonPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
        logonPanel.requestFocusInWindow();

    }

    public void showSale(String UserId) {
        System.out.println("In showSale");
        if (logonPanel != null) {
            contentPane.remove(logonPanel);
            logonPanel = null;
        }

        saleTranPanel = new LTSaleTranView(this);
        contentPane.add(saleTranPanel, BorderLayout.CENTER);
        saleController.setView(saleTranPanel);

        revalidate();
        repaint();
        saleTranPanel.requestFocusInWindow();

        if(saleTranPanel != null) {
            saleTranPanel.LoadData();
        }
    }


    private void onLogout() {
        showLogon();
    }

//    public static void main(String[] args) {
//        FlatIntelliJLaf.setup();
//        SwingUtilities.invokeLater(LTConcessionsFrame::new);
//    }
}
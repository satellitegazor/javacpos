// src/main/java/com/temp/pos/views/Concessions.java
package com.temp.pos.longterm.views;

import com.temp.pos.longterm.controllers.LTSaleController;

import javax.swing.*;
import java.awt.*;

public class LTConcessionsFrame extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;

    private LTLogonView logonPanel = new LTLogonView(this);
    private LTSaleTranView saleTranView = new LTSaleTranView();
    private LTSaleController saleController;

    public LTConcessionsFrame() {
        setTitle("Concession POS - Europe");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saleController = new LTSaleController(saleTranView);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(logonPanel, "LOGON");
        mainPanel.add(saleTranView, "SALETRAN");
        //add(container, BorderLayout.CENTER);
        this.setContentPane(mainPanel);
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
        cardLayout.show(mainPanel, "LOGON");
        mainPanel.revalidate();
        mainPanel.repaint();

        logonPanel.requestFocusInWindow();
    }

    public void showSale(String UserId) {
        System.out.println("In showSale");

//        SaleView view = new SaleView() {
//            @Override
//            public void updateBilling(SaleState state) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void updateItems(java.util.List<?> items) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void showMessage(String message) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void clearAll() {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//
//            @Override
//            public void setStatus(String status) {
//                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//            }
//        };
        if(saleTranView != null) {
            saleTranView.LoadData();
        }
        cardLayout.show(mainPanel, "SALETRAN");
        mainPanel.revalidate();
        mainPanel.repaint();
        //salePanel.requestFocusInWindow();
    }


    private void onLogout() {
        showLogon();
    }

//    public static void main(String[] args) {
//        FlatIntelliJLaf.setup();
//        SwingUtilities.invokeLater(LTConcessionsFrame::new);
//    }
}
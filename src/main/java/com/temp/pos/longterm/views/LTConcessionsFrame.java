// src/main/java/com/temp/pos/views/Concessions.java
package com.temp.pos.longterm.views;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.temp.pos.longterm.controllers.LTSaleController;
import com.temp.pos.longterm.models.SaleState;

import javax.swing.*;
import java.awt.*;

public class LTConcessionsFrame extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel cardPanel;

    private LTLogonView logonPanel = new LTLogonView(this);
    private LTSaleTranView saleTranView = new LTSaleTranView();
    private LTSaleController saleController;

    public LTConcessionsFrame() {
        setTitle("Concession POS - Europe");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saleController = new LTSaleController(saleTranView);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.add(logonPanel, "LOGON");
        cardPanel.add(saleTranView, "SALETRAN");
        add(cardPanel, BorderLayout.CENTER);

        showLogon();
        setVisible(true);
    }


    protected void onLoginSuccess(String UserId) {
        saleController.setUserId(UserId);
        showSale(UserId);
    }

    public void showLogon() {
        if (logonPanel != null) {
            cardPanel.remove(logonPanel);
        }

        //cardPanel.add(logonPanel, "LOGON");
        cardLayout.show(cardPanel, "LOGON");
        logonPanel.requestFocusInWindow();
    }

    public void showSale(String UserId) {
        if (saleTranView != null) {
            cardPanel.remove(saleTranView);
        }

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
        cardLayout.show(cardPanel, "SALETRAN");
        //salePanel.requestFocusInWindow();
    }


    private void onLogout() {
        if (saleTranView != null) {
            //salePanel.cleanup();
            saleTranView = null;
        }
        showLogon();
    }

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(LTConcessionsFrame::new);
    }
}
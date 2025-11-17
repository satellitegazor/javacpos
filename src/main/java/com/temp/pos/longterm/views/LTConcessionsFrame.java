// src/main/java/com/temp/pos/views/Concessions.java
package com.temp.pos.longterm.views;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.temp.pos.longterm.controllers.LTSaleController;
import com.temp.pos.longterm.models.SaleState;

import javax.swing.*;
import java.awt.*;

public class LTConcessionsFrame extends JFrame {

    private JPanel contentPane;

    private LTLogonView logonPanel;
    private LTSaleTranView salePanel;
    private LTCheckoutView checkoutPanel;
    private LTSaleController saleController;

    public LTConcessionsFrame() {
        setTitle("Concession POS");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.white);
        add(contentPane);

        showLogon();
        setVisible(true);
    }

    protected void onLoginSuccess(String UserId) {
        showSale(UserId);
    }

    public void showLogon() {

        if (salePanel != null) {
            contentPane.remove(salePanel);
            salePanel = null;
        }

        logonPanel = new LTLogonView(this);
        contentPane.add(logonPanel);
        revalidate();
        repaint();
        logonPanel.requestFocusInWindow();
    }

    public void showSale(String UserId) {

        if(logonPanel != null) {
            contentPane.remove(logonPanel);
            logonPanel = null;
        }
        saleController = new LTSaleController(UserId);
        salePanel = new LTSaleTranView(this);
        salePanel.setController(saleController);

        salePanel.LoadData();
        contentPane.add(salePanel);
        revalidate();
        repaint();
        salePanel.requestFocusInWindow();
    }

    public void showCheckoutView() {

        if(logonPanel != null) {
            contentPane.remove(logonPanel);
            logonPanel = null;
        }
        if (salePanel != null) {
            contentPane.remove(salePanel);
            salePanel = null;
        }
        checkoutPanel = new LTCheckoutView(this);
        contentPane.add(checkoutPanel);

        revalidate();
        repaint();
        checkoutPanel.requestFocusInWindow();
    }

    private void onLogout() {
        if (salePanel != null) {
            //salePanel.cleanup();
            salePanel = null;
        }
        showLogon();
    }

}
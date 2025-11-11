package com.temp.pos.longterm.views;

import com.temp.pos.longterm.models.SaleState;

public interface SaleView {
    void updateBilling(SaleState state);
    void updateItems(java.util.List<?> items);
    void showMessage(String message);
    void clearAll();
    void setStatus(String status);
}
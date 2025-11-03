package com.temp.pos.views.longterm;

import com.temp.pos.models.longterm.SaleState;

public interface SaleView {
    void updateBilling(SaleState state);
    void updateItems(java.util.List<?> items);
    void showMessage(String message);
    void clearAll();
    void setStatus(String status);
}
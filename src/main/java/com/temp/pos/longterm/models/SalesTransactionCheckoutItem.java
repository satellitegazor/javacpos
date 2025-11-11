package com.temp.pos.longterm.models;

public class SalesTransactionCheckoutItem {
    private int salesItemID;
    private String salesItemDescription;
    private int salesCategoryID;
    private int departmentUID;
    private double quantity;
    private double unitPrice;
    private double lineTotal;
    private double taxAmount;
    private double discountAmount;
    private String itemCode;
    private String barcode;
    private boolean taxExempt;
    private int displayOrder;

    // Constructor
    public SalesTransactionCheckoutItem() {}

    public SalesTransactionCheckoutItem(int salesItemID, String salesItemDescription, 
                                      double quantity, double unitPrice) {
        this.salesItemID = salesItemID;
        this.salesItemDescription = salesItemDescription;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineTotal = quantity * unitPrice;
    }

    // Getters & Setters
    public int getSalesItemID() { return salesItemID; }
    public void setSalesItemID(int salesItemID) { this.salesItemID = salesItemID; }

    public String getSalesItemDescription() { return salesItemDescription; }
    public void setSalesItemDescription(String salesItemDescription) { 
        this.salesItemDescription = salesItemDescription; 
    }

    public int getSalesCategoryID() { return salesCategoryID; }
    public void setSalesCategoryID(int salesCategoryID) { this.salesCategoryID = salesCategoryID; }

    public int getDepartmentUID() { return departmentUID; }
    public void setDepartmentUID(int departmentUID) { this.departmentUID = departmentUID; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { 
        this.quantity = quantity; 
        this.lineTotal = quantity * unitPrice; 
    }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { 
        this.unitPrice = unitPrice; 
        this.lineTotal = quantity * unitPrice; 
    }

    public double getLineTotal() { return lineTotal; }
    public void setLineTotal(double lineTotal) { this.lineTotal = lineTotal; }

    public double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(double taxAmount) { this.taxAmount = taxAmount; }

    public double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(double discountAmount) { this.discountAmount = discountAmount; }

    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }

    public boolean isTaxExempt() { return taxExempt; }
    public void setTaxExempt(boolean taxExempt) { this.taxExempt = taxExempt; }

    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
}
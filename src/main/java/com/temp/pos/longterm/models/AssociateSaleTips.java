package com.temp.pos.longterm.models;


public class AssociateSaleTips {
    private int individualUID;      // Associate ID
    private String associateName;   // Associate Name
    private double tipAmount;       // Tip for this associate
    private double tipPercentage;   // % of sale
    private int salesItemCount;     // Items serviced by this associate
    private double totalSaleAmount; // Total sale amount for this associate

    // Constructor
    public AssociateSaleTips() {}

    public AssociateSaleTips(int individualUID, String associateName, double tipAmount) {
        this.individualUID = individualUID;
        this.associateName = associateName;
        this.tipAmount = tipAmount;
        this.tipPercentage = 0.0;
        this.salesItemCount = 0;
        this.totalSaleAmount = 0.0;
    }

    // Getters & Setters
    public int getIndividualUID() { return individualUID; }
    public void setIndividualUID(int individualUID) { this.individualUID = individualUID; }

    public String getAssociateName() { return associateName; }
    public void setAssociateName(String associateName) { this.associateName = associateName; }

    public double getTipAmount() { return tipAmount; }
    public void setTipAmount(double tipAmount) { this.tipAmount = tipAmount; }

    public double getTipPercentage() { return tipPercentage; }
    public void setTipPercentage(double tipPercentage) { this.tipPercentage = tipPercentage; }

    public int getSalesItemCount() { return salesItemCount; }
    public void setSalesItemCount(int salesItemCount) { this.salesItemCount = salesItemCount; }

    public double getTotalSaleAmount() { return totalSaleAmount; }
    public void setTotalSaleAmount(double totalSaleAmount) { this.totalSaleAmount = totalSaleAmount; }
}
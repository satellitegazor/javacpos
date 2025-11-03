package com.temp.pos.models.shortterm;

public class ROVEODZReport {
    private String tenderTypeCode;
    private String tenderTypeDescription;
    private int displayOrder;
    private int nbrTrans;
    private int nbrTender;
    private double sales;
    private double refunds;
    private double salesTax;
    private int taxExemptedCount;
    private double couponTotal;
    private double vendorCoupons;
    private double exchangeCoupons;
    private double exchangeCouponsUSD;
    private double exchangeCouponsSalesTransCount;
    private double exchangeCouponsRefundTransCount;
    private double vendorCouponsSalesTransCount;
    private double vendorCouponsRefundTransCount;

    // Getters and Setters
    public String getTenderTypeCode() {
        return tenderTypeCode;
    }

    public void setTenderTypeCode(String tenderTypeCode) {
        this.tenderTypeCode = tenderTypeCode;
    }

    public String getTenderTypeDescription() {
        return tenderTypeDescription;
    }

    public void setTenderTypeDescription(String tenderTypeDescription) {
        this.tenderTypeDescription = tenderTypeDescription;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getNbrTrans() {
        return nbrTrans;
    }

    public void setNbrTrans(int nbrTrans) {
        this.nbrTrans = nbrTrans;
    }

    public int getNbrTender() {
        return nbrTender;
    }

    public void setNbrTender(int nbrTender) {
        this.nbrTender = nbrTender;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getRefunds() {
        return refunds;
    }

    public void setRefunds(double refunds) {
        this.refunds = refunds;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public int getTaxExemptedCount() {
        return taxExemptedCount;
    }

    public void setTaxExemptedCount(int taxExemptedCount) {
        this.taxExemptedCount = taxExemptedCount;
    }

    public double getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(double couponTotal) {
        this.couponTotal = couponTotal;
    }

    public double getVendorCoupons() {
        return vendorCoupons;
    }

    public void setVendorCoupons(double vendorCoupons) {
        this.vendorCoupons = vendorCoupons;
    }

    public double getExchangeCoupons() {
        return exchangeCoupons;
    }

    public void setExchangeCoupons(double exchangeCoupons) {
        this.exchangeCoupons = exchangeCoupons;
    }

    public double getExchangeCouponsUSD() {
        return exchangeCouponsUSD;
    }

    public void setExchangeCouponsUSD(double exchangeCouponsUSD) {
        this.exchangeCouponsUSD = exchangeCouponsUSD;
    }

    public double getExchangeCouponsSalesTransCount() {
        return exchangeCouponsSalesTransCount;
    }

    public void setExchangeCouponsSalesTransCount(double exchangeCouponsSalesTransCount) {
        this.exchangeCouponsSalesTransCount = exchangeCouponsSalesTransCount;
    }

    public double getExchangeCouponsRefundTransCount() {
        return exchangeCouponsRefundTransCount;
    }

    public void setExchangeCouponsRefundTransCount(double exchangeCouponsRefundTransCount) {
        this.exchangeCouponsRefundTransCount = exchangeCouponsRefundTransCount;
    }

    public double getVendorCouponsSalesTransCount() {
        return vendorCouponsSalesTransCount;
    }

    public void setVendorCouponsSalesTransCount(double vendorCouponsSalesTransCount) {
        this.vendorCouponsSalesTransCount = vendorCouponsSalesTransCount;
    }

    public double getVendorCouponsRefundTransCount() {
        return vendorCouponsRefundTransCount;
    }

    public void setVendorCouponsRefundTransCount(double vendorCouponsRefundTransCount) {
        this.vendorCouponsRefundTransCount = vendorCouponsRefundTransCount;
    }
}
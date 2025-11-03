package com.temp.pos.models.shortterm;

public class ROVDepartmentSummaryDetail {
    private int departmentUID;
    private int departmentTypeUID;
    private String deptName;
    private int nbrTrans;
    private double totalSales;
    private double totalSalesTax;
    private double totalEnvTax;
    private double totalExchCouponAmt;
    private double totalVndrCouponAmt;
    private double shippingHandling;
    private boolean isRefundType;

    // Getters and Setters
    public int getDepartmentUID() {
        return departmentUID;
    }

    public void setDepartmentUID(int departmentUID) {
        this.departmentUID = departmentUID;
    }

    public int getDepartmentTypeUID() {
        return departmentTypeUID;
    }

    public void setDepartmentTypeUID(int departmentTypeUID) {
        this.departmentTypeUID = departmentTypeUID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getNbrTrans() {
        return nbrTrans;
    }

    public void setNbrTrans(int nbrTrans) {
        this.nbrTrans = nbrTrans;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public void setTotalSalesTax(double totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

    public double getTotalEnvTax() {
        return totalEnvTax;
    }

    public void setTotalEnvTax(double totalEnvTax) {
        this.totalEnvTax = totalEnvTax;
    }

    public double getTotalExchCouponAmt() {
        return totalExchCouponAmt;
    }

    public void setTotalExchCouponAmt(double totalExchCouponAmt) {
        this.totalExchCouponAmt = totalExchCouponAmt;
    }

    public double getTotalVndrCouponAmt() {
        return totalVndrCouponAmt;
    }

    public void setTotalVndrCouponAmt(double totalVndrCouponAmt) {
        this.totalVndrCouponAmt = totalVndrCouponAmt;
    }

    public double getShippingHandling() {
        return shippingHandling;
    }

    public void setShippingHandling(double shippingHandling) {
        this.shippingHandling = shippingHandling;
    }

    public boolean isRefundType() {
        return isRefundType;
    }

    public void setRefundType(boolean refundType) {
        isRefundType = refundType;
    }
}
package com.temp.pos.models.shortterm;

import java.util.List;

import com.temp.pos.models.common.MobileBase;

public class ROVEODZReportResultsModel {
    private MobileBase results;
    private List<ROVEODZReport> reconcillationSummary;
    private List<ROVEODZReport> reconcillationSummaryFC;
    private List<ROVDepartmentSummaryDetail> departmentSummary;
    private List<ROVDepartmentSummaryDetail> departmentSummaryFC;
    private ROV_Event event;
    private int noSaleCount;
    private int cancelledCount;
    private double shippingHandling;
    private double shippingHandlingTax;
    private double fcShippingHandling;
    private double fcShippingHandlingTax;
    private int shippingTran;
    private int refundShippingTran;
    private int shippingTaxTran;
    private int totalSalesTrans;
    private int totalRefundTrans;
    private int salesTaxExemptedCount;
    private int refundTaxExemptedCount;
    private double deferredCount;
    private double deferredCountFC;
    private String associate;

    // Getters and Setters
    public MobileBase getResults() {
        return results;
    }

    public void setResults(MobileBase results) {
        this.results = results;
    }

    public List<ROVEODZReport> getReconcillationSummary() {
        return reconcillationSummary;
    }

    public void setReconcillationSummary(List<ROVEODZReport> reconcillationSummary) {
        this.reconcillationSummary = reconcillationSummary;
    }

    public List<ROVEODZReport> getReconcillationSummaryFC() {
        return reconcillationSummaryFC;
    }

    public void setReconcillationSummaryFC(List<ROVEODZReport> reconcillationSummaryFC) {
        this.reconcillationSummaryFC = reconcillationSummaryFC;
    }

    public List<ROVDepartmentSummaryDetail> getDepartmentSummary() {
        return departmentSummary;
    }

    public void setDepartmentSummary(List<ROVDepartmentSummaryDetail> departmentSummary) {
        this.departmentSummary = departmentSummary;
    }

    public List<ROVDepartmentSummaryDetail> getDepartmentSummaryFC() {
        return departmentSummaryFC;
    }

    public void setDepartmentSummaryFC(List<ROVDepartmentSummaryDetail> departmentSummaryFC) {
        this.departmentSummaryFC = departmentSummaryFC;
    }

    public ROV_Event getEvent() {
        return event;
    }

    public void setEvent(ROV_Event event) {
        this.event = event;
    }

    public int getNoSaleCount() {
        return noSaleCount;
    }

    public void setNoSaleCount(int noSaleCount) {
        this.noSaleCount = noSaleCount;
    }

    public int getCancelledCount() {
        return cancelledCount;
    }

    public void setCancelledCount(int cancelledCount) {
        this.cancelledCount = cancelledCount;
    }

    public double getShippingHandling() {
        return shippingHandling;
    }

    public void setShippingHandling(double shippingHandling) {
        this.shippingHandling = shippingHandling;
    }

    public double getShippingHandlingTax() {
        return shippingHandlingTax;
    }

    public void setShippingHandlingTax(double shippingHandlingTax) {
        this.shippingHandlingTax = shippingHandlingTax;
    }

    public double getFcShippingHandling() {
        return fcShippingHandling;
    }

    public void setFcShippingHandling(double fcShippingHandling) {
        this.fcShippingHandling = fcShippingHandling;
    }

    public double getFcShippingHandlingTax() {
        return fcShippingHandlingTax;
    }

    public void setFcShippingHandlingTax(double fcShippingHandlingTax) {
        this.fcShippingHandlingTax = fcShippingHandlingTax;
    }

    public int getShippingTran() {
        return shippingTran;
    }

    public void setShippingTran(int shippingTran) {
        this.shippingTran = shippingTran;
    }

    public int getRefundShippingTran() {
        return refundShippingTran;
    }

    public void setRefundShippingTran(int refundShippingTran) {
        this.refundShippingTran = refundShippingTran;
    }

    public int getShippingTaxTran() {
        return shippingTaxTran;
    }

    public void setShippingTaxTran(int shippingTaxTran) {
        this.shippingTaxTran = shippingTaxTran;
    }

    public int getTotalSalesTrans() {
        return totalSalesTrans;
    }

    public void setTotalSalesTrans(int totalSalesTrans) {
        this.totalSalesTrans = totalSalesTrans;
    }

    public int getTotalRefundTrans() {
        return totalRefundTrans;
    }

    public void setTotalRefundTrans(int totalRefundTrans) {
        this.totalRefundTrans = totalRefundTrans;
    }

    public int getSalesTaxExemptedCount() {
        return salesTaxExemptedCount;
    }

    public void setSalesTaxExemptedCount(int salesTaxExemptedCount) {
        this.salesTaxExemptedCount = salesTaxExemptedCount;
    }

    public int getRefundTaxExemptedCount() {
        return refundTaxExemptedCount;
    }

    public void setRefundTaxExemptedCount(int refundTaxExemptedCount) {
        this.refundTaxExemptedCount = refundTaxExemptedCount;
    }

    public double getDeferredCount() {
        return deferredCount;
    }

    public void setDeferredCount(double deferredCount) {
        this.deferredCount = deferredCount;
    }

    public double getDeferredCountFC() {
        return deferredCountFC;
    }

    public void setDeferredCountFC(double deferredCountFC) {
        this.deferredCountFC = deferredCountFC;
    }

    public String getAssociate() {
        return associate;
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }
}
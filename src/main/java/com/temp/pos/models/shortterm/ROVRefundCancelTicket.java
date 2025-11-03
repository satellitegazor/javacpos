package com.temp.pos.models.shortterm;

import com.temp.pos.models.common.CPOSDB;
import com.temp.pos.models.common.ExchCardTndr;

public class ROVRefundCancelTicket {
    private int tktNum;
    private int tranId;
    private int eventId;
    private int cancelTypeId;
    private String otherReason;
    private double refundAmt;
    private String refundTndrCode;
    private String tracking;
    private String cardEndingNbr;
    private int cliTimeVar;
    private CPOSDB dbVal;
    private double refundAmtFC;
    private boolean isVerifoneSwipe;
    private ExchCardTndr vmTndr;
    private String rrn;
    private String milstarPlanNum;

    // Getters and Setters
    public int getTktNum() {
        return tktNum;
    }

    public void setTktNum(int tktNum) {
        this.tktNum = tktNum;
    }

    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getCancelTypeId() {
        return cancelTypeId;
    }

    public void setCancelTypeId(int cancelTypeId) {
        this.cancelTypeId = cancelTypeId;
    }

    public String getOtherReason() {
        return otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public double getRefundAmt() {
        return refundAmt;
    }

    public void setRefundAmt(double refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getRefundTndrCode() {
        return refundTndrCode;
    }

    public void setRefundTndrCode(String refundTndrCode) {
        this.refundTndrCode = refundTndrCode;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getCardEndingNbr() {
        return cardEndingNbr;
    }

    public void setCardEndingNbr(String cardEndingNbr) {
        this.cardEndingNbr = cardEndingNbr;
    }

    public int getCliTimeVar() {
        return cliTimeVar;
    }

    public void setCliTimeVar(int cliTimeVar) {
        this.cliTimeVar = cliTimeVar;
    }

    public CPOSDB getDbVal() {
        return dbVal;
    }

    public void setDbVal(CPOSDB dbVal) {
        this.dbVal = dbVal;
    }

    public double getRefundAmtFC() {
        return refundAmtFC;
    }

    public void setRefundAmtFC(double refundAmtFC) {
        this.refundAmtFC = refundAmtFC;
    }

    public boolean isVerifoneSwipe() {
        return isVerifoneSwipe;
    }

    public void setVerifoneSwipe(boolean verifoneSwipe) {
        isVerifoneSwipe = verifoneSwipe;
    }

    public ExchCardTndr getVmTndr() {
        return vmTndr;
    }

    public void setVmTndr(ExchCardTndr vmTndr) {
        this.vmTndr = vmTndr;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getMilstarPlanNum() {
        return milstarPlanNum;
    }

    public void setMilstarPlanNum(String milstarPlanNum) {
        this.milstarPlanNum = milstarPlanNum;
    }
}
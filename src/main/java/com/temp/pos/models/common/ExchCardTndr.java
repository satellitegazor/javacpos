/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SatishTandle
 */
package com.temp.pos.models.common;
import java.math.BigDecimal;

public class ExchCardTndr {
    // Extra identifiers
    private int ticketTenderId;
    private int transactionId;
    // From SQL UDT
    private String rrn;
    private String transSeqNum;
    private String intrnSeqNum;
    private String troutd;
    private String ctroutd;
    private String lptoken;
    private String cardToken;
    private String paymentType;
    private String paymentMedia;
    private String ppcv;
    private String cardAbbrv;
    private String ebtType;
    private String acctNum;
    private String authCode;
    // money → BigDecimal
    private BigDecimal availableBalance;
    private BigDecimal approvedAmount;
    private BigDecimal origTransAmount;
    private BigDecimal diffAmountDue;
    private BigDecimal fsaAmount;
    private BigDecimal cashbackAmnt;
    private BigDecimal tipAmount;
    private BigDecimal fsAvailBalance;
    private BigDecimal cbAvailBalance;
    private String cardEntryMode;
    private int emvReversalType;
    private String cardholder;
    private Integer cardExpMonth;
    private Integer cardExpYear;
    private String avsCode;
    private String cvv2Code;
    private String merchDecl;
    private String merchRef;
    private String customerZip;
    private int preswiped;
    private String authRespCode;
    private String hostRespcode;
    private String responseCode;
    private String authnwid;
    private String authnwname;
    private String bankUserdata;
    private String embossedAcctNum;
    private String safNum;
    private String mid;
    private String tid;
    private String emvCvm;
    private String pinpadSerialNum;
    private String tabletSerialNum;
    private String responseXml;
    private String vfoneWebsrvVer;
    // Additional EMV fields
    private String emvTag4F;
    private String emvTag50;
    private String emvTag5F2A;
    private String emvTag5F34;
    private String emvTag82;
    private String emvTag8A;
    private String emvTag95;
    private String emvTag9A;
    private String emvTag9B;
    private String emvTag9C;
    private String emvTag9F02;
    private String emvTag9F03;
    private String emvTag9F07;
    private String emvTag9F0D;
    private String emvTag9F0E;
    private String emvTag9F0F;
    private String emvTag9F10;
    private String emvTag9F12;
    private String emvTag9F1A;
    private String emvTag9F26;
    private String emvTag9F27;
    private String emvTag9F34;
    private String emvTag9F36;
    private String emvTag9F37;
    private String emvMode;
    private String emvChipIndicator;
    private String tacDefault;
    private String tacDenial;
    private String tacOnline;
    private String emvTag84;
    private String emvTag9F21;
    private String emvTag9F08;
    private String emvTag9F09;
    private String emvTag9F33;
    private String emvTag9F35;

    // Getters and Setters
    public int getTicketTenderId() {
        return ticketTenderId;
    }

    public void setTicketTenderId(int ticketTenderId) {
        this.ticketTenderId = ticketTenderId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public String getTransSeqNum() {
        return transSeqNum;
    }

    public void setTransSeqNum(String transSeqNum) {
        this.transSeqNum = transSeqNum;
    }

    public String getIntrnSeqNum() {
        return intrnSeqNum;
    }

    public void setIntrnSeqNum(String intrnSeqNum) {
        this.intrnSeqNum = intrnSeqNum;
    }

    public String getTroutd() {
        return troutd;
    }

    public void setTroutd(String troutd) {
        this.troutd = troutd;
    }

    public String getCtroutd() {
        return ctroutd;
    }

    public void setCtroutd(String ctroutd) {
        this.ctroutd = ctroutd;
    }

    public String getLptoken() {
        return lptoken;
    }

    public void setLptoken(String lptoken) {
        this.lptoken = lptoken;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentMedia() {
        return paymentMedia;
    }

    public void setPaymentMedia(String paymentMedia) {
        this.paymentMedia = paymentMedia;
    }

    public String getPpcv() {
        return ppcv;
    }

    public void setPpcv(String ppcv) {
        this.ppcv = ppcv;
    }

    public String getCardAbbrv() {
        return cardAbbrv;
    }

    public void setCardAbbrv(String cardAbbrv) {
        this.cardAbbrv = cardAbbrv;
    }

    public String getEbtType() {
        return ebtType;
    }

    public void setEbtType(String ebtType) {
        this.ebtType = ebtType;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getOrigTransAmount() {
        return origTransAmount;
    }

    public void setOrigTransAmount(BigDecimal origTransAmount) {
        this.origTransAmount = origTransAmount;
    }

    public BigDecimal getDiffAmountDue() {
        return diffAmountDue;
    }

    public void setDiffAmountDue(BigDecimal diffAmountDue) {
        this.diffAmountDue = diffAmountDue;
    }

    public BigDecimal getFsaAmount() {
        return fsaAmount;
    }

    public void setFsaAmount(BigDecimal fsaAmount) {
        this.fsaAmount = fsaAmount;
    }

    public BigDecimal getCashbackAmnt() {
        return cashbackAmnt;
    }

    public void setCashbackAmnt(BigDecimal cashbackAmnt) {
        this.cashbackAmnt = cashbackAmnt;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(BigDecimal tipAmount) {
        this.tipAmount = tipAmount;
    }

    public BigDecimal getFsAvailBalance() {
        return fsAvailBalance;
    }

    public void setFsAvailBalance(BigDecimal fsAvailBalance) {
        this.fsAvailBalance = fsAvailBalance;
    }

    public BigDecimal getCbAvailBalance() {
        return cbAvailBalance;
    }

    public void setCbAvailBalance(BigDecimal cbAvailBalance) {
        this.cbAvailBalance = cbAvailBalance;
    }

    public String getCardEntryMode() {
        return cardEntryMode;
    }

    public void setCardEntryMode(String cardEntryMode) {
        this.cardEntryMode = cardEntryMode;
    }

    public int getEmvReversalType() {
        return emvReversalType;
    }

    public void setEmvReversalType(int emvReversalType) {
        this.emvReversalType = emvReversalType;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public Integer getCardExpMonth() {
        return cardExpMonth;
    }

    public void setCardExpMonth(Integer cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public Integer getCardExpYear() {
        return cardExpYear;
    }

    public void setCardExpYear(Integer cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public String getAvsCode() {
        return avsCode;
    }

    public void setAvsCode(String avsCode) {
        this.avsCode = avsCode;
    }

    public String getCvv2Code() {
        return cvv2Code;
    }

    public void setCvv2Code(String cvv2Code) {
        this.cvv2Code = cvv2Code;
    }

    public String getMerchDecl() {
        return merchDecl;
    }

    public void setMerchDecl(String merchDecl) {
        this.merchDecl = merchDecl;
    }

    public String getMerchRef() {
        return merchRef;
    }

    public void setMerchRef(String merchRef) {
        this.merchRef = merchRef;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public int getPreswiped() {
        return preswiped;
    }

    public void setPreswiped(int preswiped) {
        this.preswiped = preswiped;
    }

    public String getAuthRespCode() {
        return authRespCode;
    }

    public void setAuthRespCode(String authRespCode) {
        this.authRespCode = authRespCode;
    }

    public String getHostRespcode() {
        return hostRespcode;
    }

    public void setHostRespcode(String hostRespcode) {
        this.hostRespcode = hostRespcode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getAuthnwid() {
        return authnwid;
    }

    public void setAuthnwid(String authnwid) {
        this.authnwid = authnwid;
    }

    public String getAuthnwname() {
        return authnwname;
    }

    public void setAuthnwname(String authnwname) {
        this.authnwname = authnwname;
    }

    public String getBankUserdata() {
        return bankUserdata;
    }

    public void setBankUserdata(String bankUserdata) {
        this.bankUserdata = bankUserdata;
    }

    public String getEmbossedAcctNum() {
        return embossedAcctNum;
    }

    public void setEmbossedAcctNum(String embossedAcctNum) {
        this.embossedAcctNum = embossedAcctNum;
    }

    public String getSafNum() {
        return safNum;
    }

    public void setSafNum(String safNum) {
        this.safNum = safNum;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getEmvCvm() {
        return emvCvm;
    }

    public void setEmvCvm(String emvCvm) {
        this.emvCvm = emvCvm;
    }

    public String getPinpadSerialNum() {
        return pinpadSerialNum;
    }

    public void setPinpadSerialNum(String pinpadSerialNum) {
        this.pinpadSerialNum = pinpadSerialNum;
    }

    public String getTabletSerialNum() {
        return tabletSerialNum;
    }

    public void setTabletSerialNum(String tabletSerialNum) {
        this.tabletSerialNum = tabletSerialNum;
    }

    public String getResponseXml() {
        return responseXml;
    }

    public void setResponseXml(String responseXml) {
        this.responseXml = responseXml;
    }

    public String getVfoneWebsrvVer() {
        return vfoneWebsrvVer;
    }

    public void setVfoneWebsrvVer(String vfoneWebsrvVer) {
        this.vfoneWebsrvVer = vfoneWebsrvVer;
    }

    public String getEmvTag4F() {
        return emvTag4F;
    }

    public void setEmvTag4F(String emvTag4F) {
        this.emvTag4F = emvTag4F;
    }

    public String getEmvTag50() {
        return emvTag50;
    }

    public void setEmvTag50(String emvTag50) {
        this.emvTag50 = emvTag50;
    }

    public String getEmvTag5F2A() {
        return emvTag5F2A;
    }

    public void setEmvTag5F2A(String emvTag5F2A) {
        this.emvTag5F2A = emvTag5F2A;
    }

    public String getEmvTag5F34() {
        return emvTag5F34;
    }

    public void setEmvTag5F34(String emvTag5F34) {
        this.emvTag5F34 = emvTag5F34;
    }

    public String getEmvTag82() {
        return emvTag82;
    }

    public void setEmvTag82(String emvTag82) {
        this.emvTag82 = emvTag82;
    }

    public String getEmvTag8A() {
        return emvTag8A;
    }

    public void setEmvTag8A(String emvTag8A) {
        this.emvTag8A = emvTag8A;
    }

    public String getEmvTag95() {
        return emvTag95;
    }

    public void setEmvTag95(String emvTag95) {
        this.emvTag95 = emvTag95;
    }

    public String getEmvTag9A() {
        return emvTag9A;
    }

    public void setEmvTag9A(String emvTag9A) {
        this.emvTag9A = emvTag9A;
    }

    public String getEmvTag9B() {
        return emvTag9B;
    }

    public void setEmvTag9B(String emvTag9B) {
        this.emvTag9B = emvTag9B;
    }

    public String getEmvTag9C() {
        return emvTag9C;
    }

    public void setEmvTag9C(String emvTag9C) {
        this.emvTag9C = emvTag9C;
    }

    public String getEmvTag9F02() {
        return emvTag9F02;
    }

    public void setEmvTag9F02(String emvTag9F02) {
        this.emvTag9F02 = emvTag9F02;
    }

    public String getEmvTag9F03() {
        return emvTag9F03;
    }

    public void setEmvTag9F03(String emvTag9F03) {
        this.emvTag9F03 = emvTag9F03;
    }

    public String getEmvTag9F07() {
        return emvTag9F07;
    }

    public void setEmvTag9F07(String emvTag9F07) {
        this.emvTag9F07 = emvTag9F07;
    }

    public String getEmvTag9F0D() {
        return emvTag9F0D;
    }

    public void setEmvTag9F0D(String emvTag9F0D) {
        this.emvTag9F0D = emvTag9F0D;
    }

    public String getEmvTag9F0E() {
        return emvTag9F0E;
    }

    public void setEmvTag9F0E(String emvTag9F0E) {
        this.emvTag9F0E = emvTag9F0E;
    }

    public String getEmvTag9F0F() {
        return emvTag9F0F;
    }

    public void setEmvTag9F0F(String emvTag9F0F) {
        this.emvTag9F0F = emvTag9F0F;
    }

    public String getEmvTag9F10() {
        return emvTag9F10;
    }

    public void setEmvTag9F10(String emvTag9F10) {
        this.emvTag9F10 = emvTag9F10;
    }

    public String getEmvTag9F12() {
        return emvTag9F12;
    }

    public void setEmvTag9F12(String emvTag9F12) {
        this.emvTag9F12 = emvTag9F12;
    }

    public String getEmvTag9F1A() {
        return emvTag9F1A;
    }

    public void setEmvTag9F1A(String emvTag9F1A) {
        this.emvTag9F1A = emvTag9F1A;
    }

    public String getEmvTag9F26() {
        return emvTag9F26;
    }

    public void setEmvTag9F26(String emvTag9F26) {
        this.emvTag9F26 = emvTag9F26;
    }

    public String getEmvTag9F27() {
        return emvTag9F27;
    }

    public void setEmvTag9F27(String emvTag9F27) {
        this.emvTag9F27 = emvTag9F27;
    }

    public String getEmvTag9F34() {
        return emvTag9F34;
    }

    public void setEmvTag9F34(String emvTag9F34) {
        this.emvTag9F34 = emvTag9F34;
    }

    public String getEmvTag9F36() {
        return emvTag9F36;
    }

    public void setEmvTag9F36(String emvTag9F36) {
        this.emvTag9F36 = emvTag9F36;
    }

    public String getEmvTag9F37() {
        return emvTag9F37;
    }

    public void setEmvTag9F37(String emvTag9F37) {
        this.emvTag9F37 = emvTag9F37;
    }

    public String getEmvMode() {
        return emvMode;
    }

    public void setEmvMode(String emvMode) {
        this.emvMode = emvMode;
    }

    public String getEmvChipIndicator() {
        return emvChipIndicator;
    }

    public void setEmvChipIndicator(String emvChipIndicator) {
        this.emvChipIndicator = emvChipIndicator;
    }

    public String getTacDefault() {
        return tacDefault;
    }

    public void setTacDefault(String tacDefault) {
        this.tacDefault = tacDefault;
    }

    public String getTacDenial() {
        return tacDenial;
    }

    public void setTacDenial(String tacDenial) {
        this.tacDenial = tacDenial;
    }

    public String getTacOnline() {
        return tacOnline;
    }

    public void setTacOnline(String tacOnline) {
        this.tacOnline = tacOnline;
    }

    public String getEmvTag84() {
        return emvTag84;
    }

    public void setEmvTag84(String emvTag84) {
        this.emvTag84 = emvTag84;
    }

    public String getEmvTag9F21() {
        return emvTag9F21;
    }

    public void setEmvTag9F21(String emvTag9F21) {
        this.emvTag9F21 = emvTag9F21;
    }

    public String getEmvTag9F08() {
        return emvTag9F08;
    }

    public void setEmvTag9F08(String emvTag9F08) {
        this.emvTag9F08 = emvTag9F08;
    }

    public String getEmvTag9F09() {
        return emvTag9F09;
    }

    public void setEmvTag9F09(String emvTag9F09) {
        this.emvTag9F09 = emvTag9F09;
    }

    public String getEmvTag9F33() {
        return emvTag9F33;
    }

    public void setEmvTag9F33(String emvTag9F33) {
        this.emvTag9F33 = emvTag9F33;
    }

    public String getEmvTag9F35() {
        return emvTag9F35;
    }

    public void setEmvTag9F35(String emvTag9F35) {
        this.emvTag9F35 = emvTag9F35;
    }
}
package com.alipay.iap.android.wallet.acl.payment;

import java.util.Map;

/* loaded from: classes.dex */
public class PaymentRequest {
    public Map<String, String> extendedInfo;
    public PaymentAmount paymentAmount;
    public String paymentString;
    public PaymentType type;

    public PaymentRequest(PaymentType paymentType, String str, PaymentAmount paymentAmount, Map<String, String> map) {
        this.type = paymentType;
        this.paymentString = str;
        this.paymentAmount = paymentAmount;
        this.extendedInfo = map;
    }

    public PaymentAmount getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(PaymentAmount paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Map<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(Map<String, String> map) {
        this.extendedInfo = map;
    }

    public String getPaymentString() {
        return this.paymentString;
    }

    public void setPaymentString(String str) {
        this.paymentString = str;
    }

    public PaymentType getType() {
        return this.type;
    }

    public void setType(PaymentType paymentType) {
        this.type = paymentType;
    }
}

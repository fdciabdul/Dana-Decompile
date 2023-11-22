package id.dana.domain.sendmoney.model;

import id.dana.domain.model.cashier.Attributes;
import id.dana.domain.model.cashier.PayMethodRisk;

/* loaded from: classes4.dex */
public class SendMoneyConfirm {
    private Attributes attributes;
    private String cashierOrderId;
    private String fundAmount;
    private String fundOrderId;
    private String groupOrderId;
    private String orderId;
    private PayMethodRisk payMethodRiskResult;
    private String pubkey;
    private String riskPhoneNumber;

    public String getFundOrderId() {
        return this.fundOrderId;
    }

    public SendMoneyConfirm setFundOrderId(String str) {
        this.fundOrderId = str;
        return this;
    }

    public String getFundAmount() {
        return this.fundAmount;
    }

    public SendMoneyConfirm setFundAmount(String str) {
        this.fundAmount = str;
        return this;
    }

    public PayMethodRisk getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    public SendMoneyConfirm setPayMethodRiskResult(PayMethodRisk payMethodRisk) {
        this.payMethodRiskResult = payMethodRisk;
        return this;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public SendMoneyConfirm setAttributes(Attributes attributes) {
        this.attributes = attributes;
        return this;
    }

    public String getRiskPhoneNumber() {
        return this.riskPhoneNumber;
    }

    public SendMoneyConfirm setRiskPhoneNumber(String str) {
        this.riskPhoneNumber = str;
        return this;
    }

    public String getPubkey() {
        return this.pubkey;
    }

    public SendMoneyConfirm setPubkey(String str) {
        this.pubkey = str;
        return this;
    }

    public String getCashierOrderId() {
        return this.cashierOrderId;
    }

    public SendMoneyConfirm setCashierOrderId(String str) {
        this.cashierOrderId = str;
        return this;
    }

    public String getGroupOrderId() {
        return this.groupOrderId;
    }

    public SendMoneyConfirm setGroupOrderId(String str) {
        this.groupOrderId = str;
        return this;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}

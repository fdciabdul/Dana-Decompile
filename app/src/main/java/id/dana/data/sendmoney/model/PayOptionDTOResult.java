package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.payasset.source.network.result.PayMethodViewDTO;

/* loaded from: classes4.dex */
public class PayOptionDTOResult {
    private String payMethod;
    private PayMethodViewDTO payMethodView;
    private CurrencyAmountResult payerMaxAmount;
    private CurrencyAmountResult payerMinAmount;

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public CurrencyAmountResult getPayerMinAmount() {
        return this.payerMinAmount;
    }

    public void setPayerMinAmount(CurrencyAmountResult currencyAmountResult) {
        this.payerMinAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getPayerMaxAmount() {
        return this.payerMaxAmount;
    }

    public void setPayerMaxAmount(CurrencyAmountResult currencyAmountResult) {
        this.payerMaxAmount = currencyAmountResult;
    }

    public PayMethodViewDTO getPayMethodView() {
        return this.payMethodView;
    }

    public void setPayMethodView(PayMethodViewDTO payMethodViewDTO) {
        this.payMethodView = payMethodViewDTO;
    }
}

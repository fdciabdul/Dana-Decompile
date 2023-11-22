package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class PayMethodInfoResult {
    private String fundType;
    private String payMethod;
    private PayMethodViewResult payMethodView;
    private CurrencyAmountResult payeeMaxBalanceAmount;
    private CurrencyAmountResult payeeMaxMonthFundInAmount;
    private CurrencyAmountResult payeeMonthConsumedAmount;
    private CurrencyAmountResult payerMaxAmount;
    private CurrencyAmountResult payerMinAmount;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FundType {
        public static final String TRANSFER_B2B = "TRANSFER_B2B";
        public static final String TRANSFER_P2B = "TRANSFER_P2B";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PayMethod {
        public static final String BALANCE = "BALANCE";
        public static final String DEBIT_CARD = "DEBIT_CARD";
    }

    public PayMethodInfoResult() {
    }

    public PayMethodInfoResult(String str, String str2, PayMethodViewResult payMethodViewResult, CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, CurrencyAmountResult currencyAmountResult3, CurrencyAmountResult currencyAmountResult4, CurrencyAmountResult currencyAmountResult5) {
        this.fundType = str;
        this.payMethod = str2;
        this.payMethodView = payMethodViewResult;
        this.payerMaxAmount = currencyAmountResult;
        this.payerMinAmount = currencyAmountResult2;
        this.payeeMaxBalanceAmount = currencyAmountResult3;
        this.payeeMaxMonthFundInAmount = currencyAmountResult4;
        this.payeeMonthConsumedAmount = currencyAmountResult5;
    }

    public String getFundType() {
        return this.fundType;
    }

    public void setFundType(String str) {
        this.fundType = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public PayMethodViewResult getPayMethodView() {
        return this.payMethodView;
    }

    public void setPayMethodView(PayMethodViewResult payMethodViewResult) {
        this.payMethodView = payMethodViewResult;
    }

    public CurrencyAmountResult getPayerMaxAmount() {
        return this.payerMaxAmount;
    }

    public void setPayerMaxAmount(CurrencyAmountResult currencyAmountResult) {
        this.payerMaxAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getPayerMinAmount() {
        return this.payerMinAmount;
    }

    public void setPayerMinAmount(CurrencyAmountResult currencyAmountResult) {
        this.payerMinAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getPayeeMaxBalanceAmount() {
        return this.payeeMaxBalanceAmount;
    }

    public void setPayeeMaxBalanceAmount(CurrencyAmountResult currencyAmountResult) {
        this.payeeMaxBalanceAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getPayeeMaxMonthFundInAmount() {
        return this.payeeMaxMonthFundInAmount;
    }

    public void setPayeeMaxMonthFundInAmount(CurrencyAmountResult currencyAmountResult) {
        this.payeeMaxMonthFundInAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getPayeeMonthConsumedAmount() {
        return this.payeeMonthConsumedAmount;
    }

    public void setPayeeMonthConsumedAmount(CurrencyAmountResult currencyAmountResult) {
        this.payeeMonthConsumedAmount = currencyAmountResult;
    }
}

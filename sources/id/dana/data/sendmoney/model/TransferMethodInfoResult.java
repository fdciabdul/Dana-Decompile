package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TransferMethodInfoResult {
    private CurrencyAmountResult chargeAmount;
    private CurrencyAmountResult freeMinAmount;
    private long freeRemainingTimes;
    private long freeTimes;
    private final boolean nullObject;
    private List<PayMethodInfoResult> payMethodInfos;
    private CurrencyAmountResult payeeMaxBalanceAmount;
    private CurrencyAmountResult payeeMaxMonthFundInAmount;
    private CurrencyAmountResult payeeMonthConsumedAmount;
    private CurrencyAmountResult transferMaxAmount;
    private String transferMethod;
    private CurrencyAmountResult transferMinAmount;
    private List<WithdrawBizMethodViewResult> withdrawMethodViews;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TransferMethod {
        public static final String BALANCE = "BALANCE";
        public static final String BANK_TRANSFER = "BANK_TRANSFER";
        public static final String OTC = "OTC";
    }

    public TransferMethodInfoResult() {
        this.payMethodInfos = new ArrayList();
        this.nullObject = false;
    }

    public TransferMethodInfoResult(CurrencyAmountResult currencyAmountResult, CurrencyAmountResult currencyAmountResult2, long j, long j2, List<PayMethodInfoResult> list, String str, CurrencyAmountResult currencyAmountResult3, CurrencyAmountResult currencyAmountResult4, List<WithdrawBizMethodViewResult> list2, CurrencyAmountResult currencyAmountResult5, CurrencyAmountResult currencyAmountResult6, CurrencyAmountResult currencyAmountResult7) {
        new ArrayList();
        this.chargeAmount = currencyAmountResult;
        this.freeRemainingTimes = j;
        this.freeTimes = j2;
        this.payMethodInfos = list;
        this.transferMethod = str;
        this.withdrawMethodViews = list2;
        this.freeMinAmount = currencyAmountResult2;
        this.transferMaxAmount = currencyAmountResult3;
        this.transferMinAmount = currencyAmountResult4;
        this.payeeMaxBalanceAmount = currencyAmountResult5;
        this.payeeMaxMonthFundInAmount = currencyAmountResult6;
        this.payeeMonthConsumedAmount = currencyAmountResult7;
        this.nullObject = false;
    }

    private TransferMethodInfoResult(boolean z) {
        this.payMethodInfos = new ArrayList();
        this.nullObject = z;
    }

    public static TransferMethodInfoResult createNullObject() {
        return new TransferMethodInfoResult(true);
    }

    public CurrencyAmountResult getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(CurrencyAmountResult currencyAmountResult) {
        this.chargeAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getFreeMinAmount() {
        return this.freeMinAmount;
    }

    public void setFreeMinAmount(CurrencyAmountResult currencyAmountResult) {
        this.freeMinAmount = currencyAmountResult;
    }

    public long getFreeRemainingTimes() {
        return this.freeRemainingTimes;
    }

    public void setFreeRemainingTimes(long j) {
        this.freeRemainingTimes = j;
    }

    public long getFreeTimes() {
        return this.freeTimes;
    }

    public void setFreeTimes(long j) {
        this.freeTimes = j;
    }

    public List<PayMethodInfoResult> getPayMethodInfos() {
        return this.payMethodInfos;
    }

    public void setPayMethodInfos(List<PayMethodInfoResult> list) {
        this.payMethodInfos = list;
    }

    public String getTransferMethod() {
        return this.transferMethod;
    }

    public void setTransferMethod(String str) {
        this.transferMethod = str;
    }

    public List<WithdrawBizMethodViewResult> getWithdrawMethodViews() {
        return this.withdrawMethodViews;
    }

    public void setWithdrawMethodViews(List<WithdrawBizMethodViewResult> list) {
        this.withdrawMethodViews = list;
    }

    public boolean isNullObject() {
        return this.nullObject;
    }

    public CurrencyAmountResult getTransferMaxAmount() {
        return this.transferMaxAmount;
    }

    public void setTransferMaxAmount(CurrencyAmountResult currencyAmountResult) {
        this.transferMaxAmount = currencyAmountResult;
    }

    public CurrencyAmountResult getTransferMinAmount() {
        return this.transferMinAmount;
    }

    public void setTransferMinAmount(CurrencyAmountResult currencyAmountResult) {
        this.transferMinAmount = currencyAmountResult;
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

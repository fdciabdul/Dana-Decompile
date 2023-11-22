package id.dana.data.nearbyme.model;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.PromoLimitInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PromoInfoEntity {
    private String activityId;
    private long beginDate;
    private long endDate;
    private List<PromoLimitInfoEntity> limitRule;
    private CurrencyAmountResult maxAmount;
    private CurrencyAmountResult minTransactionAmount;
    private List<String> paymentMethods;
    private String prizeType;
    private String promoDescription;
    private String promoType;
    private String promoValue;

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public String getPrizeType() {
        return this.prizeType;
    }

    public void setPrizeType(String str) {
        this.prizeType = str;
    }

    public String getPromoDescription() {
        return this.promoDescription;
    }

    public void setPromoDescription(String str) {
        this.promoDescription = str;
    }

    public List<String> getPaymentMethods() {
        return this.paymentMethods;
    }

    public void setPaymentMethods(List<String> list) {
        this.paymentMethods = list;
    }

    public CurrencyAmountResult getMinTransactionAmount() {
        return this.minTransactionAmount;
    }

    public void setMinTransactionAmount(CurrencyAmountResult currencyAmountResult) {
        this.minTransactionAmount = currencyAmountResult;
    }

    public long getEndDate() {
        return this.endDate;
    }

    public void setEndDate(long j) {
        this.endDate = j;
    }

    public long getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(long j) {
        this.beginDate = j;
    }

    public String getPromoValue() {
        return this.promoValue;
    }

    public void setPromoValue(String str) {
        this.promoValue = str;
    }

    public CurrencyAmountResult getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(CurrencyAmountResult currencyAmountResult) {
        this.maxAmount = currencyAmountResult;
    }

    public List<PromoLimitInfoEntity> getLimitRule() {
        return this.limitRule;
    }

    public void setLimitRule(List<PromoLimitInfoEntity> list) {
        this.limitRule = list;
    }

    public String getPromoType() {
        return this.promoType;
    }

    public void setPromoType(String str) {
        this.promoType = str;
    }

    public PromoInfo toPromoInfo() {
        PromoInfo promoInfo = new PromoInfo();
        promoInfo.setActivityId(this.activityId);
        promoInfo.setBeginDate(this.beginDate);
        promoInfo.setEndDate(this.endDate);
        promoInfo.setLimitRule(transformPromoLimitInfoEntityToPromoLimitInfo(this.limitRule));
        promoInfo.setMaxAmount(this.maxAmount.toCurrencyAmount());
        promoInfo.setMinTransactionAmount(this.minTransactionAmount.toCurrencyAmount());
        promoInfo.setPaymentMethods(this.paymentMethods);
        promoInfo.setPrizeType(this.prizeType);
        promoInfo.setPromoDescription(this.promoDescription);
        promoInfo.setPromoType(this.promoType);
        promoInfo.setPromoValue(this.promoValue);
        return promoInfo;
    }

    private List<PromoLimitInfo> transformPromoLimitInfoEntityToPromoLimitInfo(List<PromoLimitInfoEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<PromoLimitInfoEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toPromoLimitInfo());
        }
        return arrayList;
    }
}

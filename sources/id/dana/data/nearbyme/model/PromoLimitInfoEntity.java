package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.PromoLimitInfo;

/* loaded from: classes4.dex */
public class PromoLimitInfoEntity {
    private String limitCount;
    private String limitRangeType;
    private String limitType;

    public String getLimitType() {
        return this.limitType;
    }

    public void setLimitType(String str) {
        this.limitType = str;
    }

    public String getLimitCount() {
        return this.limitCount;
    }

    public void setLimitCount(String str) {
        this.limitCount = str;
    }

    public String getLimitRangeType() {
        return this.limitRangeType;
    }

    public void setLimitRangeType(String str) {
        this.limitRangeType = str;
    }

    public PromoLimitInfo toPromoLimitInfo() {
        PromoLimitInfo promoLimitInfo = new PromoLimitInfo();
        promoLimitInfo.setLimitCount(this.limitCount);
        promoLimitInfo.setLimitRangeType(this.limitRangeType);
        promoLimitInfo.setLimitType(this.limitType);
        return promoLimitInfo;
    }
}

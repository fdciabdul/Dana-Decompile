package id.dana.data.nearbyme.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class NearbyPromoResult implements Serializable {
    private String merchantId;
    private List<PromoInfoEntity> promoInfos;
    private String shopId;

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String str) {
        this.shopId = str;
    }

    public List<PromoInfoEntity> getPromoInfos() {
        return this.promoInfos;
    }

    public void setPromoInfos(List<PromoInfoEntity> list) {
        this.promoInfos = list;
    }
}

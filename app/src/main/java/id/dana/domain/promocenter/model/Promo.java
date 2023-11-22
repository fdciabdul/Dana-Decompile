package id.dana.domain.promocenter.model;

import java.util.List;

/* loaded from: classes4.dex */
public class Promo {
    private String bannerUrl;
    private long expiryDate;

    /* renamed from: id  reason: collision with root package name */
    private String f8178id;
    private String merchantType;
    private String name;
    private List<PromoAction> promoActions;
    private String promoBannerVerticalImageUrl;
    private long promoIndexId;
    private int promoPriority;

    public String getId() {
        return this.f8178id;
    }

    public void setId(String str) {
        this.f8178id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(long j) {
        this.expiryDate = j;
    }

    public List<PromoAction> getPromoActions() {
        return this.promoActions;
    }

    public void setPromoActions(List<PromoAction> list) {
        this.promoActions = list;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public int getPromoPriority() {
        return this.promoPriority;
    }

    public void setPromoPriority(int i) {
        this.promoPriority = i;
    }

    public long getPromoIndexId() {
        return this.promoIndexId;
    }

    public void setPromoIndexId(long j) {
        this.promoIndexId = j;
    }

    public String getPromoBannerVerticalImageUrl() {
        return this.promoBannerVerticalImageUrl;
    }

    public void setPromoBannerVerticalImageUrl(String str) {
        this.promoBannerVerticalImageUrl = str;
    }

    public String getMerchantType() {
        return this.merchantType;
    }

    public void setMerchantType(String str) {
        this.merchantType = str;
    }
}

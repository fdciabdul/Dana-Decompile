package id.dana.domain.promocenter.model;

import java.util.List;

/* loaded from: classes4.dex */
public class PromoCategoryInfo {
    private List<PromoCategory> promoCategories;
    private long totalCategory;

    public long getTotalCategory() {
        return this.totalCategory;
    }

    public void setTotalCategory(long j) {
        this.totalCategory = j;
    }

    public List<PromoCategory> getPromoCategories() {
        return this.promoCategories;
    }

    public void setPromoCategories(List<PromoCategory> list) {
        this.promoCategories = list;
    }
}

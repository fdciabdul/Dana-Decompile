package id.dana.domain.promocenter.model;

import java.util.List;

/* loaded from: classes4.dex */
public class PromoResult {
    private boolean hasMore;
    private List<Promo> promoList;

    public List<Promo> getPromoList() {
        return this.promoList;
    }

    public void setPromoList(List<Promo> list) {
        this.promoList = list;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}

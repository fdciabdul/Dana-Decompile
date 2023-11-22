package id.dana.data.promocenter.repository.source.network.model;

import java.util.List;

/* loaded from: classes4.dex */
public class CategorizedPromo {
    private String categoryId;
    private boolean hasMore;
    private List<DisplayPromoResponse> listOfPromo;

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public List<DisplayPromoResponse> getListOfPromo() {
        return this.listOfPromo;
    }

    public void setListOfPromo(List<DisplayPromoResponse> list) {
        this.listOfPromo = list;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }
}

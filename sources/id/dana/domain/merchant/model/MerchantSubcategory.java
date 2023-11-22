package id.dana.domain.merchant.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MerchantSubcategory {
    List<String> categoryIds = new ArrayList();
    String mcc;
    String name;

    public String getMcc() {
        return this.mcc;
    }

    public void setMcc(String str) {
        this.mcc = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getCategoryIds() {
        return this.categoryIds;
    }

    public void setCategoryIds(List<String> list) {
        this.categoryIds = list;
    }
}

package id.dana.domain.splitbill.model;

import id.dana.domain.deeplink.model.DeepLink;

/* loaded from: classes4.dex */
public class SplitBillDeeplink extends DeepLink {
    private String splitBillId;

    public SplitBillDeeplink(String str, String str2) {
        super(str);
        this.splitBillId = str2;
    }

    public String getSplitBillId() {
        return this.splitBillId;
    }

    @Override // id.dana.domain.deeplink.model.DeepLink
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // id.dana.domain.deeplink.model.DeepLink
    public int hashCode() {
        return super.hashCode();
    }
}

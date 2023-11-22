package id.dana.core.ui.glide;

import id.dana.core.ui.glide.BaseImageAttacher;

/* loaded from: classes4.dex */
abstract class UrlImageAttacher extends BaseImageAttacher {
    private final String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UrlImageAttacher(String str, BaseImageAttacher.AdditionalData additionalData) {
        super(additionalData);
        this.getAuthRequestContext = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}

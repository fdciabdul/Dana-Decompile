package id.dana.domain.social.model;

import id.dana.data.config.source.amcs.result.BannerConfigResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/domain/social/model/ShareActivityConfig;", "", "", "bannerLimit", "I", "getBannerLimit", "()I", "setBannerLimit", "(I)V", "", "feedOnlineMerchantBanner", "Z", "getFeedOnlineMerchantBanner", "()Z", "setFeedOnlineMerchantBanner", "(Z)V", BannerConfigResult.PAYMENT_SUCCESS, "getPaymentSuccess", "setPaymentSuccess", "<init>", "(ZIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShareActivityConfig {
    public int bannerLimit;
    public boolean feedOnlineMerchantBanner;
    public boolean paymentSuccess;

    public ShareActivityConfig() {
        this(false, 0, false, 7, null);
    }

    public ShareActivityConfig(boolean z, int i, boolean z2) {
        this.feedOnlineMerchantBanner = z;
        this.bannerLimit = i;
        this.paymentSuccess = z2;
    }

    public /* synthetic */ ShareActivityConfig(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i, (i2 & 4) != 0 ? false : z2);
    }

    @JvmName(name = "getFeedOnlineMerchantBanner")
    public final boolean getFeedOnlineMerchantBanner() {
        return this.feedOnlineMerchantBanner;
    }

    @JvmName(name = "setFeedOnlineMerchantBanner")
    public final void setFeedOnlineMerchantBanner(boolean z) {
        this.feedOnlineMerchantBanner = z;
    }

    @JvmName(name = "getBannerLimit")
    public final int getBannerLimit() {
        return this.bannerLimit;
    }

    @JvmName(name = "setBannerLimit")
    public final void setBannerLimit(int i) {
        this.bannerLimit = i;
    }

    @JvmName(name = "getPaymentSuccess")
    public final boolean getPaymentSuccess() {
        return this.paymentSuccess;
    }

    @JvmName(name = "setPaymentSuccess")
    public final void setPaymentSuccess(boolean z) {
        this.paymentSuccess = z;
    }
}

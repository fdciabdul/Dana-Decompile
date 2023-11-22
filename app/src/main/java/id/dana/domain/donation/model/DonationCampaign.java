package id.dana.domain.donation.model;

import com.alibaba.griver.api.constants.GriverEvents;
import id.dana.danah5.share.ShareToFeedBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/domain/donation/model/DonationCampaign;", "", "", "aggregator", "Ljava/lang/String;", "getAggregator", "()Ljava/lang/String;", "setAggregator", "(Ljava/lang/String;)V", "backgroundImage", "getBackgroundImage", "setBackgroundImage", "fundRaiserName", "getFundRaiserName", "setFundRaiserName", "redirectType", "getRedirectType", "setRedirectType", "Lid/dana/domain/donation/model/RedirectValue;", ShareToFeedBridge.REDIRECT_VALUE, "Lid/dana/domain/donation/model/RedirectValue;", "getRedirectValue", "()Lid/dana/domain/donation/model/RedirectValue;", "setRedirectValue", "(Lid/dana/domain/donation/model/RedirectValue;)V", "title", "getTitle", GriverEvents.EVENT_SET_TITLE, "", "verified", "Z", "getVerified", "()Z", "setVerified", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/donation/model/RedirectValue;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DonationCampaign {
    private String aggregator;
    private String backgroundImage;
    private String fundRaiserName;
    private String redirectType;
    private RedirectValue redirectValue;
    private String title;
    private boolean verified;

    public DonationCampaign() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    public DonationCampaign(String str, String str2, boolean z, String str3, String str4, String str5, RedirectValue redirectValue) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(redirectValue, "");
        this.aggregator = str;
        this.fundRaiserName = str2;
        this.verified = z;
        this.backgroundImage = str3;
        this.redirectType = str4;
        this.title = str5;
        this.redirectValue = redirectValue;
    }

    @JvmName(name = "getAggregator")
    public final String getAggregator() {
        return this.aggregator;
    }

    @JvmName(name = "setAggregator")
    public final void setAggregator(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.aggregator = str;
    }

    @JvmName(name = "getFundRaiserName")
    public final String getFundRaiserName() {
        return this.fundRaiserName;
    }

    @JvmName(name = "setFundRaiserName")
    public final void setFundRaiserName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.fundRaiserName = str;
    }

    @JvmName(name = "getVerified")
    public final boolean getVerified() {
        return this.verified;
    }

    @JvmName(name = "setVerified")
    public final void setVerified(boolean z) {
        this.verified = z;
    }

    @JvmName(name = "getBackgroundImage")
    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    @JvmName(name = "setBackgroundImage")
    public final void setBackgroundImage(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.backgroundImage = str;
    }

    @JvmName(name = "getRedirectType")
    public final String getRedirectType() {
        return this.redirectType;
    }

    @JvmName(name = "setRedirectType")
    public final void setRedirectType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.redirectType = str;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
    }

    public /* synthetic */ DonationCampaign(String str, String str2, boolean z, String str3, String str4, String str5, RedirectValue redirectValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) == 0 ? str5 : "", (i & 64) != 0 ? new RedirectValue(null, null, false, null, 15, null) : redirectValue);
    }

    @JvmName(name = "getRedirectValue")
    public final RedirectValue getRedirectValue() {
        return this.redirectValue;
    }

    @JvmName(name = "setRedirectValue")
    public final void setRedirectValue(RedirectValue redirectValue) {
        Intrinsics.checkNotNullParameter(redirectValue, "");
        this.redirectValue = redirectValue;
    }
}

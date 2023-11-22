package id.dana.data.config.source.amcs.result;

import com.alibaba.griver.api.constants.GriverEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R\"\u0010\u0011\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001eR\"\u0010\u000f\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u001eR\"\u0010\u000e\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u001eR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010&R\"\u0010\u0010\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\u001eR\"\u0010\r\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\u001e"}, d2 = {"Lid/dana/data/config/source/amcs/result/DonationCampaignConfigResult;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "enable", "title", "description", "buttonTitle", "redirectUrl", "action", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/config/source/amcs/result/DonationCampaignConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "getButtonTitle", "setButtonTitle", "getDescription", "setDescription", "Z", "getEnable", "setEnable", "(Z)V", "getRedirectUrl", "setRedirectUrl", "getTitle", GriverEvents.EVENT_SET_TITLE, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DonationCampaignConfigResult {
    private String action;
    private String buttonTitle;
    private String description;
    private boolean enable;
    private String redirectUrl;
    private String title;

    public DonationCampaignConfigResult() {
        this(false, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DonationCampaignConfigResult copy$default(DonationCampaignConfigResult donationCampaignConfigResult, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = donationCampaignConfigResult.enable;
        }
        if ((i & 2) != 0) {
            str = donationCampaignConfigResult.title;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = donationCampaignConfigResult.description;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = donationCampaignConfigResult.buttonTitle;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = donationCampaignConfigResult.redirectUrl;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = donationCampaignConfigResult.action;
        }
        return donationCampaignConfigResult.copy(z, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4  reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final DonationCampaignConfigResult copy(boolean enable, String title, String description, String buttonTitle, String redirectUrl, String action) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(buttonTitle, "");
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        Intrinsics.checkNotNullParameter(action, "");
        return new DonationCampaignConfigResult(enable, title, description, buttonTitle, redirectUrl, action);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DonationCampaignConfigResult) {
            DonationCampaignConfigResult donationCampaignConfigResult = (DonationCampaignConfigResult) other;
            return this.enable == donationCampaignConfigResult.enable && Intrinsics.areEqual(this.title, donationCampaignConfigResult.title) && Intrinsics.areEqual(this.description, donationCampaignConfigResult.description) && Intrinsics.areEqual(this.buttonTitle, donationCampaignConfigResult.buttonTitle) && Intrinsics.areEqual(this.redirectUrl, donationCampaignConfigResult.redirectUrl) && Intrinsics.areEqual(this.action, donationCampaignConfigResult.action);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((r0 * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.buttonTitle.hashCode()) * 31) + this.redirectUrl.hashCode()) * 31) + this.action.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DonationCampaignConfigResult(enable=");
        sb.append(this.enable);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", buttonTitle=");
        sb.append(this.buttonTitle);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(')');
        return sb.toString();
    }

    public DonationCampaignConfigResult(boolean z, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.enable = z;
        this.title = str;
        this.description = str2;
        this.buttonTitle = str3;
        this.redirectUrl = str4;
        this.action = str5;
    }

    public /* synthetic */ DonationCampaignConfigResult(boolean z, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "Sedekah Jadi Berkah" : str, (i & 4) != 0 ? "Are you up for something challenging?" : str2, (i & 8) != 0 ? "Learn More" : str3, (i & 16) != 0 ? "https://dana.kitabisa.xyz" : str4, (i & 32) != 0 ? "GET" : str5);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.enable = z;
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

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }

    @JvmName(name = "getButtonTitle")
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @JvmName(name = "setButtonTitle")
    public final void setButtonTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.buttonTitle = str;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "setRedirectUrl")
    public final void setRedirectUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.redirectUrl = str;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.action = str;
    }
}

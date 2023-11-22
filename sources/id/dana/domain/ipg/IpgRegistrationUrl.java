package id.dana.domain.ipg;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004"}, d2 = {"Lid/dana/domain/ipg/IpgRegistrationUrl;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "redirectUrl", "needUserConsent", "userConsentConfigKey", "userConsentSyncKey", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/domain/ipg/IpgRegistrationUrl;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getNeedUserConsent", "Ljava/lang/String;", "getRedirectUrl", "setRedirectUrl", "(Ljava/lang/String;)V", "getUserConsentConfigKey", "getUserConsentSyncKey", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IpgRegistrationUrl {
    private final boolean needUserConsent;
    private String redirectUrl;
    private final String userConsentConfigKey;
    private final String userConsentSyncKey;

    public IpgRegistrationUrl() {
        this(null, false, null, null, 15, null);
    }

    public static /* synthetic */ IpgRegistrationUrl copy$default(IpgRegistrationUrl ipgRegistrationUrl, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipgRegistrationUrl.redirectUrl;
        }
        if ((i & 2) != 0) {
            z = ipgRegistrationUrl.needUserConsent;
        }
        if ((i & 4) != 0) {
            str2 = ipgRegistrationUrl.userConsentConfigKey;
        }
        if ((i & 8) != 0) {
            str3 = ipgRegistrationUrl.userConsentSyncKey;
        }
        return ipgRegistrationUrl.copy(str, z, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getNeedUserConsent() {
        return this.needUserConsent;
    }

    /* renamed from: component3  reason: from getter */
    public final String getUserConsentConfigKey() {
        return this.userConsentConfigKey;
    }

    /* renamed from: component4  reason: from getter */
    public final String getUserConsentSyncKey() {
        return this.userConsentSyncKey;
    }

    public final IpgRegistrationUrl copy(String redirectUrl, boolean needUserConsent, String userConsentConfigKey, String userConsentSyncKey) {
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        return new IpgRegistrationUrl(redirectUrl, needUserConsent, userConsentConfigKey, userConsentSyncKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IpgRegistrationUrl) {
            IpgRegistrationUrl ipgRegistrationUrl = (IpgRegistrationUrl) other;
            return Intrinsics.areEqual(this.redirectUrl, ipgRegistrationUrl.redirectUrl) && this.needUserConsent == ipgRegistrationUrl.needUserConsent && Intrinsics.areEqual(this.userConsentConfigKey, ipgRegistrationUrl.userConsentConfigKey) && Intrinsics.areEqual(this.userConsentSyncKey, ipgRegistrationUrl.userConsentSyncKey);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.redirectUrl.hashCode();
        boolean z = this.needUserConsent;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str = this.userConsentConfigKey;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.userConsentSyncKey;
        return (((((hashCode * 31) + i) * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IpgRegistrationUrl(redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", needUserConsent=");
        sb.append(this.needUserConsent);
        sb.append(", userConsentConfigKey=");
        sb.append(this.userConsentConfigKey);
        sb.append(", userConsentSyncKey=");
        sb.append(this.userConsentSyncKey);
        sb.append(')');
        return sb.toString();
    }

    public IpgRegistrationUrl(String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.redirectUrl = str;
        this.needUserConsent = z;
        this.userConsentConfigKey = str2;
        this.userConsentSyncKey = str3;
    }

    public /* synthetic */ IpgRegistrationUrl(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
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

    @JvmName(name = "getNeedUserConsent")
    public final boolean getNeedUserConsent() {
        return this.needUserConsent;
    }

    @JvmName(name = "getUserConsentConfigKey")
    public final String getUserConsentConfigKey() {
        return this.userConsentConfigKey;
    }

    @JvmName(name = "getUserConsentSyncKey")
    public final String getUserConsentSyncKey() {
        return this.userConsentSyncKey;
    }
}

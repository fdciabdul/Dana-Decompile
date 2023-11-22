package id.dana.data.ipg.repository.source.network.response;

import id.dana.network.base.BaseRpcResultAphome;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001fR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u001fR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010\u001f"}, d2 = {"Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "redirectUrl", "needUserConsent", "userConsentConfigKey", "userConsentSyncKey", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getNeedUserConsent", "setNeedUserConsent", "(Z)V", "Ljava/lang/String;", "getRedirectUrl", "setRedirectUrl", "(Ljava/lang/String;)V", "getUserConsentConfigKey", "setUserConsentConfigKey", "getUserConsentSyncKey", "setUserConsentSyncKey", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IpgRegistrationUrlResult extends BaseRpcResultAphome {
    private boolean needUserConsent;
    private String redirectUrl;
    private String userConsentConfigKey;
    private String userConsentSyncKey;

    public IpgRegistrationUrlResult() {
        this(null, false, null, null, 15, null);
    }

    public static /* synthetic */ IpgRegistrationUrlResult copy$default(IpgRegistrationUrlResult ipgRegistrationUrlResult, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipgRegistrationUrlResult.redirectUrl;
        }
        if ((i & 2) != 0) {
            z = ipgRegistrationUrlResult.needUserConsent;
        }
        if ((i & 4) != 0) {
            str2 = ipgRegistrationUrlResult.userConsentConfigKey;
        }
        if ((i & 8) != 0) {
            str3 = ipgRegistrationUrlResult.userConsentSyncKey;
        }
        return ipgRegistrationUrlResult.copy(str, z, str2, str3);
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

    public final IpgRegistrationUrlResult copy(String redirectUrl, boolean needUserConsent, String userConsentConfigKey, String userConsentSyncKey) {
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        return new IpgRegistrationUrlResult(redirectUrl, needUserConsent, userConsentConfigKey, userConsentSyncKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IpgRegistrationUrlResult) {
            IpgRegistrationUrlResult ipgRegistrationUrlResult = (IpgRegistrationUrlResult) other;
            return Intrinsics.areEqual(this.redirectUrl, ipgRegistrationUrlResult.redirectUrl) && this.needUserConsent == ipgRegistrationUrlResult.needUserConsent && Intrinsics.areEqual(this.userConsentConfigKey, ipgRegistrationUrlResult.userConsentConfigKey) && Intrinsics.areEqual(this.userConsentSyncKey, ipgRegistrationUrlResult.userConsentSyncKey);
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
        sb.append("IpgRegistrationUrlResult(redirectUrl=");
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

    public /* synthetic */ IpgRegistrationUrlResult(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
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

    @JvmName(name = "setNeedUserConsent")
    public final void setNeedUserConsent(boolean z) {
        this.needUserConsent = z;
    }

    @JvmName(name = "getUserConsentConfigKey")
    public final String getUserConsentConfigKey() {
        return this.userConsentConfigKey;
    }

    @JvmName(name = "setUserConsentConfigKey")
    public final void setUserConsentConfigKey(String str) {
        this.userConsentConfigKey = str;
    }

    @JvmName(name = "getUserConsentSyncKey")
    public final String getUserConsentSyncKey() {
        return this.userConsentSyncKey;
    }

    @JvmName(name = "setUserConsentSyncKey")
    public final void setUserConsentSyncKey(String str) {
        this.userConsentSyncKey = str;
    }

    public IpgRegistrationUrlResult(String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        this.redirectUrl = str;
        this.needUserConsent = z;
        this.userConsentConfigKey = str2;
        this.userConsentSyncKey = str3;
    }
}

package id.dana.domain.globalnetwork.model;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/domain/globalnetwork/model/Auth;", "", "", "appName", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthResult;", "authCallback", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "getAuthCallback", "()Lcom/alipay/iap/android/wallet/acl/base/Callback;", "setAuthCallback", "(Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "clientId", "getClientId", "setClientId", "getDisplayName", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "iconUrl", "getIconUrl", "setIconUrl", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "getScope", "setScope", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Auth {
    private String appName;
    private Callback<OAuthResult> authCallback;
    private String clientId;
    private String iconUrl;
    private String scope;

    public Auth() {
        this(null, null, null, null, null, 31, null);
    }

    public Auth(String str, String str2, String str3, String str4, Callback<OAuthResult> callback) {
        this.clientId = str;
        this.scope = str2;
        this.appName = str3;
        this.iconUrl = str4;
        this.authCallback = callback;
    }

    public /* synthetic */ Auth(String str, String str2, String str3, String str4, Callback callback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : callback);
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getScope")
    public final String getScope() {
        return this.scope;
    }

    @JvmName(name = "setScope")
    public final void setScope(String str) {
        this.scope = str;
    }

    @JvmName(name = "getAppName")
    public final String getAppName() {
        return this.appName;
    }

    @JvmName(name = "setAppName")
    public final void setAppName(String str) {
        this.appName = str;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "setIconUrl")
    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    @JvmName(name = "getAuthCallback")
    public final Callback<OAuthResult> getAuthCallback() {
        return this.authCallback;
    }

    @JvmName(name = "setAuthCallback")
    public final void setAuthCallback(Callback<OAuthResult> callback) {
        this.authCallback = callback;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        String str = this.appName;
        return str == null ? "Global Network" : str;
    }
}

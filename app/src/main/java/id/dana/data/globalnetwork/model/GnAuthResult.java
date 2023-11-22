package id.dana.data.globalnetwork.model;

import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001ABW\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011Jb\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0004R\u0013\u0010'\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b&\u0010\u0004R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0004R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\r\"\u0004\b0\u00101R\u0013\u00103\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b2\u0010\u0004R\u0016\u00106\u001a\u0004\u0018\u00010\u001f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R$\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u00107\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010:R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010;\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010>"}, d2 = {"Lid/dana/data/globalnetwork/model/GnAuthResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Set;", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;", "component3", "()Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;", "", "component4", "()Ljava/util/Map;", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthResult;", "component5", "()Lcom/alipay/iap/android/wallet/acl/base/Callback;", "clientId", "scopes", "oAuthCodeFlowType", "extendInfo", "callback", "copy", "(Ljava/lang/String;Ljava/util/Set;Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/Callback;)Lid/dana/data/globalnetwork/model/GnAuthResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "jsonText", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "Lorg/json/JSONObject;", "getJSON", "(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "", "hashCode", "()I", "toString", "getAppName", "appName", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "getCallback", "setCallback", "(Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "Ljava/lang/String;", "getClientId", "Ljava/util/Map;", "getExtendInfo", "setExtendInfo", "(Ljava/util/Map;)V", "getIconUrl", "iconUrl", "getLanguages", "()Lorg/json/JSONObject;", "languages", "Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;", "getOAuthCodeFlowType", "setOAuthCodeFlowType", "(Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;)V", "Ljava/util/Set;", "getScopes", "setScopes", "(Ljava/util/Set;)V", "<init>", "(Ljava/lang/String;Ljava/util/Set;Lcom/alipay/iap/android/wallet/acl/oauth/OAuthCodeFlowType;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GnAuthResult {
    private static final String BAHASA_CODE = "id_ID";
    private static final String ENGLISH_CODE = "en_US";
    public Callback<OAuthResult> callback;
    public String clientId;
    public Map<String, String> extendInfo;
    public OAuthCodeFlowType oAuthCodeFlowType;
    public Set<String> scopes;

    public /* synthetic */ GnAuthResult() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GnAuthResult(String str) {
        this(str, null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(str, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GnAuthResult(String str, Set<String> set) {
        this(str, set, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(str, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GnAuthResult(String str, Set<String> set, OAuthCodeFlowType oAuthCodeFlowType) {
        this(str, set, oAuthCodeFlowType, null, null, 24, null);
        Intrinsics.checkNotNullParameter(str, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GnAuthResult(String str, Set<String> set, OAuthCodeFlowType oAuthCodeFlowType, Map<String, String> map) {
        this(str, set, oAuthCodeFlowType, map, null, 16, null);
        Intrinsics.checkNotNullParameter(str, "");
    }

    public static /* synthetic */ GnAuthResult copy$default(GnAuthResult gnAuthResult, String str, Set set, OAuthCodeFlowType oAuthCodeFlowType, Map map, Callback callback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gnAuthResult.clientId;
        }
        Set<String> set2 = set;
        if ((i & 2) != 0) {
            set2 = gnAuthResult.scopes;
        }
        Set set3 = set2;
        if ((i & 4) != 0) {
            oAuthCodeFlowType = gnAuthResult.oAuthCodeFlowType;
        }
        OAuthCodeFlowType oAuthCodeFlowType2 = oAuthCodeFlowType;
        Map<String, String> map2 = map;
        if ((i & 8) != 0) {
            map2 = gnAuthResult.extendInfo;
        }
        Map map3 = map2;
        Callback<OAuthResult> callback2 = callback;
        if ((i & 16) != 0) {
            callback2 = gnAuthResult.callback;
        }
        return gnAuthResult.copy(str, set3, oAuthCodeFlowType2, map3, callback2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final Set<String> component2() {
        return this.scopes;
    }

    /* renamed from: component3  reason: from getter */
    public final OAuthCodeFlowType getOAuthCodeFlowType() {
        return this.oAuthCodeFlowType;
    }

    public final Map<String, String> component4() {
        return this.extendInfo;
    }

    public final Callback<OAuthResult> component5() {
        return this.callback;
    }

    public final GnAuthResult copy(String clientId, Set<String> scopes, OAuthCodeFlowType oAuthCodeFlowType, Map<String, String> extendInfo, Callback<OAuthResult> callback) {
        Intrinsics.checkNotNullParameter(clientId, "");
        return new GnAuthResult(clientId, scopes, oAuthCodeFlowType, extendInfo, callback);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GnAuthResult) {
            GnAuthResult gnAuthResult = (GnAuthResult) other;
            return Intrinsics.areEqual(this.clientId, gnAuthResult.clientId) && Intrinsics.areEqual(this.scopes, gnAuthResult.scopes) && this.oAuthCodeFlowType == gnAuthResult.oAuthCodeFlowType && Intrinsics.areEqual(this.extendInfo, gnAuthResult.extendInfo) && Intrinsics.areEqual(this.callback, gnAuthResult.callback);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.clientId.hashCode();
        Set<String> set = this.scopes;
        int hashCode2 = set == null ? 0 : set.hashCode();
        OAuthCodeFlowType oAuthCodeFlowType = this.oAuthCodeFlowType;
        int hashCode3 = oAuthCodeFlowType == null ? 0 : oAuthCodeFlowType.hashCode();
        Map<String, String> map = this.extendInfo;
        int hashCode4 = map == null ? 0 : map.hashCode();
        Callback<OAuthResult> callback = this.callback;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (callback != null ? callback.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GnAuthResult(clientId=");
        sb.append(this.clientId);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", oAuthCodeFlowType=");
        sb.append(this.oAuthCodeFlowType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", callback=");
        sb.append(this.callback);
        sb.append(')');
        return sb.toString();
    }

    public GnAuthResult(String str, Set<String> set, OAuthCodeFlowType oAuthCodeFlowType, Map<String, String> map, Callback<OAuthResult> callback) {
        Intrinsics.checkNotNullParameter(str, "");
        this.clientId = str;
        this.scopes = set;
        this.oAuthCodeFlowType = oAuthCodeFlowType;
        this.extendInfo = map;
        this.callback = callback;
    }

    public /* synthetic */ GnAuthResult(String str, Set set, OAuthCodeFlowType oAuthCodeFlowType, Map map, Callback callback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : set, (i & 4) != 0 ? null : oAuthCodeFlowType, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : callback);
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getScopes")
    public final Set<String> getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(Set<String> set) {
        this.scopes = set;
    }

    @JvmName(name = "getOAuthCodeFlowType")
    public final OAuthCodeFlowType getOAuthCodeFlowType() {
        return this.oAuthCodeFlowType;
    }

    @JvmName(name = "setOAuthCodeFlowType")
    public final void setOAuthCodeFlowType(OAuthCodeFlowType oAuthCodeFlowType) {
        this.oAuthCodeFlowType = oAuthCodeFlowType;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }

    @JvmName(name = "getCallback")
    public final Callback<OAuthResult> getCallback() {
        return this.callback;
    }

    @JvmName(name = "setCallback")
    public final void setCallback(Callback<OAuthResult> callback) {
        this.callback = callback;
    }

    @JvmName(name = "getLanguages")
    private final JSONObject getLanguages() {
        String str;
        Map<String, String> map = this.extendInfo;
        if (map == null || (str = map.get("languages")) == null) {
            return null;
        }
        String obj = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        if (StringsKt.endsWith$default(obj, "ID", false, 2, (Object) null)) {
            JSONObject json = getJSON(str, BAHASA_CODE);
            return json == null ? getJSON(str, ENGLISH_CODE) : json;
        }
        JSONObject json2 = getJSON(str, ENGLISH_CODE);
        return json2 == null ? getJSON(str, BAHASA_CODE) : json2;
    }

    private final JSONObject getJSON(String jsonText, String languageCode) {
        try {
            return new JSONObject(jsonText).getJSONObject(languageCode);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmName(name = "getAppName")
    public final String getAppName() {
        JSONObject languages = getLanguages();
        if (languages != null) {
            return languages.getString("description");
        }
        return null;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        JSONObject languages = getLanguages();
        if (languages != null) {
            return languages.getString("iconUrl");
        }
        return null;
    }
}

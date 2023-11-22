package id.dana.kyb.data.model;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u009e\u0001\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b)\u0010\u0007R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b+\u0010\u0007R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\u0005R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b.\u0010\u0007R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b/\u0010\u0007R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b1\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b3\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b5\u0010\u0010R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b6\u0010\u0005R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b7\u0010\u0007R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b8\u0010\u0007"}, d2 = {"Lid/dana/kyb/data/model/KybServiceRedirectValueResult;", "", "", "", "component1", "()Ljava/util/List;", "component10", "()Ljava/lang/String;", "Lid/dana/kyb/data/model/KybServiceRuleResult;", "component11", "component2", "component3", "component4", "component5", "", "component6", "()Z", "component7", "component8", "Lcom/alibaba/fastjson/JSONObject;", "component9", "()Lcom/alibaba/fastjson/JSONObject;", "additionalQuery", "clientId", "scopes", "agreed", "url", "openNewWindow", "apiName", "minVersion", "apiPayload", "action", "rules", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/util/List;)Lid/dana/kyb/data/model/KybServiceRedirectValueResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "Ljava/util/List;", "getAdditionalQuery", "getAgreed", "getApiName", "Lcom/alibaba/fastjson/JSONObject;", "getApiPayload", "getClientId", "getMinVersion", "Z", "getOpenNewWindow", "getRules", "getScopes", "getUrl", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceRedirectValueResult {
    private final String action;
    private final List<String> additionalQuery;
    private final String agreed;
    private final String apiName;
    private final JSONObject apiPayload;
    private final String clientId;
    private final String minVersion;
    private final boolean openNewWindow;
    private final List<KybServiceRuleResult> rules;
    private final String scopes;
    private final String url;

    public KybServiceRedirectValueResult() {
        this(null, null, null, null, null, false, null, null, null, null, null, 2047, null);
    }

    public final List<String> component1() {
        return this.additionalQuery;
    }

    /* renamed from: component10  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final List<KybServiceRuleResult> component11() {
        return this.rules;
    }

    /* renamed from: component2  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAgreed() {
        return this.agreed;
    }

    /* renamed from: component5  reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getOpenNewWindow() {
        return this.openNewWindow;
    }

    /* renamed from: component7  reason: from getter */
    public final String getApiName() {
        return this.apiName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getMinVersion() {
        return this.minVersion;
    }

    /* renamed from: component9  reason: from getter */
    public final JSONObject getApiPayload() {
        return this.apiPayload;
    }

    public final KybServiceRedirectValueResult copy(List<String> additionalQuery, String clientId, String scopes, String agreed, String url, boolean openNewWindow, String apiName, String minVersion, JSONObject apiPayload, String action, List<KybServiceRuleResult> rules) {
        return new KybServiceRedirectValueResult(additionalQuery, clientId, scopes, agreed, url, openNewWindow, apiName, minVersion, apiPayload, action, rules);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybServiceRedirectValueResult) {
            KybServiceRedirectValueResult kybServiceRedirectValueResult = (KybServiceRedirectValueResult) other;
            return Intrinsics.areEqual(this.additionalQuery, kybServiceRedirectValueResult.additionalQuery) && Intrinsics.areEqual(this.clientId, kybServiceRedirectValueResult.clientId) && Intrinsics.areEqual(this.scopes, kybServiceRedirectValueResult.scopes) && Intrinsics.areEqual(this.agreed, kybServiceRedirectValueResult.agreed) && Intrinsics.areEqual(this.url, kybServiceRedirectValueResult.url) && this.openNewWindow == kybServiceRedirectValueResult.openNewWindow && Intrinsics.areEqual(this.apiName, kybServiceRedirectValueResult.apiName) && Intrinsics.areEqual(this.minVersion, kybServiceRedirectValueResult.minVersion) && Intrinsics.areEqual(this.apiPayload, kybServiceRedirectValueResult.apiPayload) && Intrinsics.areEqual(this.action, kybServiceRedirectValueResult.action) && Intrinsics.areEqual(this.rules, kybServiceRedirectValueResult.rules);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        List<String> list = this.additionalQuery;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.clientId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.scopes;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.agreed;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.url;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        boolean z = this.openNewWindow;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str5 = this.apiName;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.minVersion;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        JSONObject jSONObject = this.apiPayload;
        int hashCode8 = jSONObject == null ? 0 : jSONObject.hashCode();
        String str7 = this.action;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        List<KybServiceRuleResult> list2 = this.rules;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceRedirectValueResult(additionalQuery=");
        sb.append(this.additionalQuery);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", agreed=");
        sb.append(this.agreed);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", openNewWindow=");
        sb.append(this.openNewWindow);
        sb.append(", apiName=");
        sb.append(this.apiName);
        sb.append(", minVersion=");
        sb.append(this.minVersion);
        sb.append(", apiPayload=");
        sb.append(this.apiPayload);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", rules=");
        sb.append(this.rules);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceRedirectValueResult(List<String> list, String str, String str2, String str3, String str4, boolean z, String str5, String str6, JSONObject jSONObject, String str7, List<KybServiceRuleResult> list2) {
        this.additionalQuery = list;
        this.clientId = str;
        this.scopes = str2;
        this.agreed = str3;
        this.url = str4;
        this.openNewWindow = z;
        this.apiName = str5;
        this.minVersion = str6;
        this.apiPayload = jSONObject;
        this.action = str7;
        this.rules = list2;
    }

    public /* synthetic */ KybServiceRedirectValueResult(List list, String str, String str2, String str3, String str4, boolean z, String str5, String str6, JSONObject jSONObject, String str7, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : jSONObject, (i & 512) != 0 ? null : str7, (i & 1024) == 0 ? list2 : null);
    }

    @JvmName(name = "getAdditionalQuery")
    public final List<String> getAdditionalQuery() {
        return this.additionalQuery;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "getAgreed")
    public final String getAgreed() {
        return this.agreed;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "getOpenNewWindow")
    public final boolean getOpenNewWindow() {
        return this.openNewWindow;
    }

    @JvmName(name = "getApiName")
    public final String getApiName() {
        return this.apiName;
    }

    @JvmName(name = "getMinVersion")
    public final String getMinVersion() {
        return this.minVersion;
    }

    @JvmName(name = "getApiPayload")
    public final JSONObject getApiPayload() {
        return this.apiPayload;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getRules")
    public final List<KybServiceRuleResult> getRules() {
        return this.rules;
    }
}

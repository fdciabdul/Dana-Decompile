package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/QueryOneklikRedirectUrlResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "component5", "accessToken", "redirectUrl", "success", "widgetApiKey", "widgetApiSecret", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lid/dana/cashier/data/repository/source/network/result/QueryOneklikRedirectUrlResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessToken", "getRedirectUrl", "Z", "getSuccess", "getWidgetApiKey", "getWidgetApiSecret", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QueryOneklikRedirectUrlResult {
    @SerializedName("accessToken")
    private final String accessToken;
    private final String redirectUrl;
    private final boolean success;
    private final String widgetApiKey;
    private final String widgetApiSecret;

    public static /* synthetic */ QueryOneklikRedirectUrlResult copy$default(QueryOneklikRedirectUrlResult queryOneklikRedirectUrlResult, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = queryOneklikRedirectUrlResult.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = queryOneklikRedirectUrlResult.redirectUrl;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = queryOneklikRedirectUrlResult.success;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = queryOneklikRedirectUrlResult.widgetApiKey;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = queryOneklikRedirectUrlResult.widgetApiSecret;
        }
        return queryOneklikRedirectUrlResult.copy(str, str5, z2, str6, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component4  reason: from getter */
    public final String getWidgetApiKey() {
        return this.widgetApiKey;
    }

    /* renamed from: component5  reason: from getter */
    public final String getWidgetApiSecret() {
        return this.widgetApiSecret;
    }

    public final QueryOneklikRedirectUrlResult copy(String accessToken, String redirectUrl, boolean success, String widgetApiKey, String widgetApiSecret) {
        Intrinsics.checkNotNullParameter(accessToken, "");
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        Intrinsics.checkNotNullParameter(widgetApiKey, "");
        Intrinsics.checkNotNullParameter(widgetApiSecret, "");
        return new QueryOneklikRedirectUrlResult(accessToken, redirectUrl, success, widgetApiKey, widgetApiSecret);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QueryOneklikRedirectUrlResult) {
            QueryOneklikRedirectUrlResult queryOneklikRedirectUrlResult = (QueryOneklikRedirectUrlResult) other;
            return Intrinsics.areEqual(this.accessToken, queryOneklikRedirectUrlResult.accessToken) && Intrinsics.areEqual(this.redirectUrl, queryOneklikRedirectUrlResult.redirectUrl) && this.success == queryOneklikRedirectUrlResult.success && Intrinsics.areEqual(this.widgetApiKey, queryOneklikRedirectUrlResult.widgetApiKey) && Intrinsics.areEqual(this.widgetApiSecret, queryOneklikRedirectUrlResult.widgetApiSecret);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.accessToken.hashCode();
        int hashCode2 = this.redirectUrl.hashCode();
        boolean z = this.success;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.widgetApiKey.hashCode()) * 31) + this.widgetApiSecret.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QueryOneklikRedirectUrlResult(accessToken=");
        sb.append(this.accessToken);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", widgetApiKey=");
        sb.append(this.widgetApiKey);
        sb.append(", widgetApiSecret=");
        sb.append(this.widgetApiSecret);
        sb.append(')');
        return sb.toString();
    }

    public QueryOneklikRedirectUrlResult(String str, String str2, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.accessToken = str;
        this.redirectUrl = str2;
        this.success = z;
        this.widgetApiKey = str3;
        this.widgetApiSecret = str4;
    }

    @JvmName(name = "getAccessToken")
    public final String getAccessToken() {
        return this.accessToken;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getWidgetApiKey")
    public final String getWidgetApiKey() {
        return this.widgetApiKey;
    }

    @JvmName(name = "getWidgetApiSecret")
    public final String getWidgetApiSecret() {
        return this.widgetApiSecret;
    }
}

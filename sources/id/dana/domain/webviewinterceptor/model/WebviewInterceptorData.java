package id.dana.domain.webviewinterceptor.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "key", "url", "redirectUrlAndroid", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/webviewinterceptor/model/WebviewInterceptorData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKey", "getRedirectUrlAndroid", "getUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WebviewInterceptorData {
    private final String key;
    private final String redirectUrlAndroid;
    private final String url;

    public static /* synthetic */ WebviewInterceptorData copy$default(WebviewInterceptorData webviewInterceptorData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webviewInterceptorData.key;
        }
        if ((i & 2) != 0) {
            str2 = webviewInterceptorData.url;
        }
        if ((i & 4) != 0) {
            str3 = webviewInterceptorData.redirectUrlAndroid;
        }
        return webviewInterceptorData.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRedirectUrlAndroid() {
        return this.redirectUrlAndroid;
    }

    public final WebviewInterceptorData copy(String key, String url, String redirectUrlAndroid) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(redirectUrlAndroid, "");
        return new WebviewInterceptorData(key, url, redirectUrlAndroid);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof WebviewInterceptorData) {
            WebviewInterceptorData webviewInterceptorData = (WebviewInterceptorData) other;
            return Intrinsics.areEqual(this.key, webviewInterceptorData.key) && Intrinsics.areEqual(this.url, webviewInterceptorData.url) && Intrinsics.areEqual(this.redirectUrlAndroid, webviewInterceptorData.redirectUrlAndroid);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.key.hashCode() * 31) + this.url.hashCode()) * 31) + this.redirectUrlAndroid.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WebviewInterceptorData(key=");
        sb.append(this.key);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", redirectUrlAndroid=");
        sb.append(this.redirectUrlAndroid);
        sb.append(')');
        return sb.toString();
    }

    public WebviewInterceptorData(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.key = str;
        this.url = str2;
        this.redirectUrlAndroid = str3;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "getRedirectUrlAndroid")
    public final String getRedirectUrlAndroid() {
        return this.redirectUrlAndroid;
    }
}

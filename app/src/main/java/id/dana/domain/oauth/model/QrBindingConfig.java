package id.dana.domain.oauth.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJT\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0013\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u000eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\bR&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000b"}, d2 = {"Lid/dana/domain/oauth/model/QrBindingConfig;", "", "", "component1", "()Z", "", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/util/Map;", "", "component4", "()J", "component5", "enable", "qrIdentifier", "redirectUrl", "initialRetryInterval", "maxRetryInterval", "copy", "(ZLjava/util/List;Ljava/util/Map;JJ)Lid/dana/domain/oauth/model/QrBindingConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Z", "getEnable", "J", "getInitialRetryInterval", "getMaxRetryInterval", "Ljava/util/List;", "getQrIdentifier", "Ljava/util/Map;", "getRedirectUrl", "<init>", "(ZLjava/util/List;Ljava/util/Map;JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QrBindingConfig {
    private final boolean enable;
    private final long initialRetryInterval;
    private final long maxRetryInterval;
    private final List<String> qrIdentifier;
    private final Map<String, String> redirectUrl;

    public static /* synthetic */ QrBindingConfig copy$default(QrBindingConfig qrBindingConfig, boolean z, List list, Map map, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = qrBindingConfig.enable;
        }
        List<String> list2 = list;
        if ((i & 2) != 0) {
            list2 = qrBindingConfig.qrIdentifier;
        }
        List list3 = list2;
        Map<String, String> map2 = map;
        if ((i & 4) != 0) {
            map2 = qrBindingConfig.redirectUrl;
        }
        Map map3 = map2;
        if ((i & 8) != 0) {
            j = qrBindingConfig.initialRetryInterval;
        }
        long j3 = j;
        if ((i & 16) != 0) {
            j2 = qrBindingConfig.maxRetryInterval;
        }
        return qrBindingConfig.copy(z, list3, map3, j3, j2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> component2() {
        return this.qrIdentifier;
    }

    public final Map<String, String> component3() {
        return this.redirectUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final long getInitialRetryInterval() {
        return this.initialRetryInterval;
    }

    /* renamed from: component5  reason: from getter */
    public final long getMaxRetryInterval() {
        return this.maxRetryInterval;
    }

    public final QrBindingConfig copy(boolean enable, List<String> qrIdentifier, Map<String, String> redirectUrl, long initialRetryInterval, long maxRetryInterval) {
        Intrinsics.checkNotNullParameter(qrIdentifier, "");
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        return new QrBindingConfig(enable, qrIdentifier, redirectUrl, initialRetryInterval, maxRetryInterval);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QrBindingConfig) {
            QrBindingConfig qrBindingConfig = (QrBindingConfig) other;
            return this.enable == qrBindingConfig.enable && Intrinsics.areEqual(this.qrIdentifier, qrBindingConfig.qrIdentifier) && Intrinsics.areEqual(this.redirectUrl, qrBindingConfig.redirectUrl) && this.initialRetryInterval == qrBindingConfig.initialRetryInterval && this.maxRetryInterval == qrBindingConfig.maxRetryInterval;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((r0 * 31) + this.qrIdentifier.hashCode()) * 31) + this.redirectUrl.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.initialRetryInterval)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.maxRetryInterval);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QrBindingConfig(enable=");
        sb.append(this.enable);
        sb.append(", qrIdentifier=");
        sb.append(this.qrIdentifier);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", initialRetryInterval=");
        sb.append(this.initialRetryInterval);
        sb.append(", maxRetryInterval=");
        sb.append(this.maxRetryInterval);
        sb.append(')');
        return sb.toString();
    }

    public QrBindingConfig(boolean z, List<String> list, Map<String, String> map, long j, long j2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.enable = z;
        this.qrIdentifier = list;
        this.redirectUrl = map;
        this.initialRetryInterval = j;
        this.maxRetryInterval = j2;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getQrIdentifier")
    public final List<String> getQrIdentifier() {
        return this.qrIdentifier;
    }

    @JvmName(name = "getRedirectUrl")
    public final Map<String, String> getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getInitialRetryInterval")
    public final long getInitialRetryInterval() {
        return this.initialRetryInterval;
    }

    @JvmName(name = "getMaxRetryInterval")
    public final long getMaxRetryInterval() {
        return this.maxRetryInterval;
    }
}

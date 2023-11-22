package id.dana.data.config.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\\\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0010\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\u000eR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\bR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000b"}, d2 = {"Lid/dana/data/config/model/QrBindingConfigResult;", "", "", "component1", "()Z", "", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/util/Map;", "", "component4", "()Ljava/lang/Long;", "component5", "enable", "qrIdentifier", "redirectUrl", "initialRetryInterval", "maxRetryInterval", "copy", "(ZLjava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;)Lid/dana/data/config/model/QrBindingConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Z", "getEnable", "Ljava/lang/Long;", "getInitialRetryInterval", "getMaxRetryInterval", "Ljava/util/List;", "getQrIdentifier", "Ljava/util/Map;", "getRedirectUrl", "<init>", "(ZLjava/util/List;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class QrBindingConfigResult {
    private final boolean enable;
    private final Long initialRetryInterval;
    private final Long maxRetryInterval;
    private final List<String> qrIdentifier;
    private final Map<String, String> redirectUrl;

    public QrBindingConfigResult() {
        this(false, null, null, null, null, 31, null);
    }

    public static /* synthetic */ QrBindingConfigResult copy$default(QrBindingConfigResult qrBindingConfigResult, boolean z, List list, Map map, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = qrBindingConfigResult.enable;
        }
        List<String> list2 = list;
        if ((i & 2) != 0) {
            list2 = qrBindingConfigResult.qrIdentifier;
        }
        List list3 = list2;
        Map<String, String> map2 = map;
        if ((i & 4) != 0) {
            map2 = qrBindingConfigResult.redirectUrl;
        }
        Map map3 = map2;
        if ((i & 8) != 0) {
            l = qrBindingConfigResult.initialRetryInterval;
        }
        Long l3 = l;
        if ((i & 16) != 0) {
            l2 = qrBindingConfigResult.maxRetryInterval;
        }
        return qrBindingConfigResult.copy(z, list3, map3, l3, l2);
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
    public final Long getInitialRetryInterval() {
        return this.initialRetryInterval;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getMaxRetryInterval() {
        return this.maxRetryInterval;
    }

    public final QrBindingConfigResult copy(boolean enable, List<String> qrIdentifier, Map<String, String> redirectUrl, Long initialRetryInterval, Long maxRetryInterval) {
        return new QrBindingConfigResult(enable, qrIdentifier, redirectUrl, initialRetryInterval, maxRetryInterval);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof QrBindingConfigResult) {
            QrBindingConfigResult qrBindingConfigResult = (QrBindingConfigResult) other;
            return this.enable == qrBindingConfigResult.enable && Intrinsics.areEqual(this.qrIdentifier, qrBindingConfigResult.qrIdentifier) && Intrinsics.areEqual(this.redirectUrl, qrBindingConfigResult.redirectUrl) && Intrinsics.areEqual(this.initialRetryInterval, qrBindingConfigResult.initialRetryInterval) && Intrinsics.areEqual(this.maxRetryInterval, qrBindingConfigResult.maxRetryInterval);
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
        List<String> list = this.qrIdentifier;
        int hashCode = list == null ? 0 : list.hashCode();
        Map<String, String> map = this.redirectUrl;
        int hashCode2 = map == null ? 0 : map.hashCode();
        Long l = this.initialRetryInterval;
        int hashCode3 = l == null ? 0 : l.hashCode();
        Long l2 = this.maxRetryInterval;
        return (((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QrBindingConfigResult(enable=");
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

    public QrBindingConfigResult(boolean z, List<String> list, Map<String, String> map, Long l, Long l2) {
        this.enable = z;
        this.qrIdentifier = list;
        this.redirectUrl = map;
        this.initialRetryInterval = l;
        this.maxRetryInterval = l2;
    }

    public /* synthetic */ QrBindingConfigResult(boolean z, List list, Map map, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : l, (i & 16) == 0 ? l2 : null);
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
    public final Long getInitialRetryInterval() {
        return this.initialRetryInterval;
    }

    @JvmName(name = "getMaxRetryInterval")
    public final Long getMaxRetryInterval() {
        return this.maxRetryInterval;
    }
}

package id.dana.domain.nearbyme.model;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007"}, d2 = {"Lid/dana/domain/nearbyme/model/NearbyAutoSearchConfig;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "enabled", "interval", GriverMonitorConstants.KEY_THRESHOLD, "copy", "(ZII)Lid/dana/domain/nearbyme/model/NearbyAutoSearchConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getEnabled", "I", "getInterval", "getThreshold", "<init>", "(ZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NearbyAutoSearchConfig {
    public boolean enabled;
    public int interval;
    public int threshold;

    public /* synthetic */ NearbyAutoSearchConfig() {
    }

    public static /* synthetic */ NearbyAutoSearchConfig copy$default(NearbyAutoSearchConfig nearbyAutoSearchConfig, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = nearbyAutoSearchConfig.enabled;
        }
        if ((i3 & 2) != 0) {
            i = nearbyAutoSearchConfig.interval;
        }
        if ((i3 & 4) != 0) {
            i2 = nearbyAutoSearchConfig.threshold;
        }
        return nearbyAutoSearchConfig.copy(z, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2  reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component3  reason: from getter */
    public final int getThreshold() {
        return this.threshold;
    }

    public final NearbyAutoSearchConfig copy(boolean enabled, int interval, int threshold) {
        return new NearbyAutoSearchConfig(enabled, interval, threshold);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof NearbyAutoSearchConfig) {
            NearbyAutoSearchConfig nearbyAutoSearchConfig = (NearbyAutoSearchConfig) other;
            return this.enabled == nearbyAutoSearchConfig.enabled && this.interval == nearbyAutoSearchConfig.interval && this.threshold == nearbyAutoSearchConfig.threshold;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.interval) * 31) + this.threshold;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NearbyAutoSearchConfig(enabled=");
        sb.append(this.enabled);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", threshold=");
        sb.append(this.threshold);
        sb.append(')');
        return sb.toString();
    }

    public NearbyAutoSearchConfig(boolean z, int i, int i2) {
        this.enabled = z;
        this.interval = i;
        this.threshold = i2;
    }

    @JvmName(name = "getEnabled")
    public final boolean getEnabled() {
        return this.enabled;
    }

    @JvmName(name = "getInterval")
    public final int getInterval() {
        return this.interval;
    }

    @JvmName(name = "getThreshold")
    public final int getThreshold() {
        return this.threshold;
    }
}

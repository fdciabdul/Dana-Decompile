package id.dana.data.config.source.amcs.result;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/data/config/source/amcs/result/GeofenceConfigResult;", "Ljava/io/Serializable;", "", "component1", "()Z", "", "component2", "()I", "component3", "enable", "cachedInterval", "maxRetry", "copy", "(ZII)Lid/dana/data/config/source/amcs/result/GeofenceConfigResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCachedInterval", "Z", "getEnable", "getMaxRetry", "<init>", "(ZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class GeofenceConfigResult implements Serializable {
    public int cachedInterval;
    public boolean enable;
    public int maxRetry;

    public GeofenceConfigResult() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ GeofenceConfigResult copy$default(GeofenceConfigResult geofenceConfigResult, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = geofenceConfigResult.enable;
        }
        if ((i3 & 2) != 0) {
            i = geofenceConfigResult.cachedInterval;
        }
        if ((i3 & 4) != 0) {
            i2 = geofenceConfigResult.maxRetry;
        }
        return geofenceConfigResult.copy(z, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final int getCachedInterval() {
        return this.cachedInterval;
    }

    /* renamed from: component3  reason: from getter */
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    public final GeofenceConfigResult copy(boolean enable, int cachedInterval, int maxRetry) {
        return new GeofenceConfigResult(enable, cachedInterval, maxRetry);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeofenceConfigResult) {
            GeofenceConfigResult geofenceConfigResult = (GeofenceConfigResult) other;
            return this.enable == geofenceConfigResult.enable && this.cachedInterval == geofenceConfigResult.cachedInterval && this.maxRetry == geofenceConfigResult.maxRetry;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.cachedInterval) * 31) + this.maxRetry;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofenceConfigResult(enable=");
        sb.append(this.enable);
        sb.append(", cachedInterval=");
        sb.append(this.cachedInterval);
        sb.append(", maxRetry=");
        sb.append(this.maxRetry);
        sb.append(')');
        return sb.toString();
    }

    public GeofenceConfigResult(boolean z, int i, int i2) {
        this.enable = z;
        this.cachedInterval = i;
        this.maxRetry = i2;
    }

    public /* synthetic */ GeofenceConfigResult(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getCachedInterval")
    public final int getCachedInterval() {
        return this.cachedInterval;
    }

    @JvmName(name = "getMaxRetry")
    public final int getMaxRetry() {
        return this.maxRetry;
    }
}

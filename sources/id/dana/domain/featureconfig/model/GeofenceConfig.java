package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\t\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/domain/featureconfig/model/GeofenceConfig;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "isFeatureEnable", "cachedInterval", "maxRetry", "copy", "(ZII)Lid/dana/domain/featureconfig/model/GeofenceConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCachedInterval", "Z", "getMaxRetry", "<init>", "(ZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeofenceConfig {
    private final int cachedInterval;
    private final boolean isFeatureEnable;
    private final int maxRetry;

    public static /* synthetic */ GeofenceConfig copy$default(GeofenceConfig geofenceConfig, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = geofenceConfig.isFeatureEnable;
        }
        if ((i3 & 2) != 0) {
            i = geofenceConfig.cachedInterval;
        }
        if ((i3 & 4) != 0) {
            i2 = geofenceConfig.maxRetry;
        }
        return geofenceConfig.copy(z, i, i2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsFeatureEnable() {
        return this.isFeatureEnable;
    }

    /* renamed from: component2  reason: from getter */
    public final int getCachedInterval() {
        return this.cachedInterval;
    }

    /* renamed from: component3  reason: from getter */
    public final int getMaxRetry() {
        return this.maxRetry;
    }

    public final GeofenceConfig copy(boolean isFeatureEnable, int cachedInterval, int maxRetry) {
        return new GeofenceConfig(isFeatureEnable, cachedInterval, maxRetry);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeofenceConfig) {
            GeofenceConfig geofenceConfig = (GeofenceConfig) other;
            return this.isFeatureEnable == geofenceConfig.isFeatureEnable && this.cachedInterval == geofenceConfig.cachedInterval && this.maxRetry == geofenceConfig.maxRetry;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.isFeatureEnable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.cachedInterval) * 31) + this.maxRetry;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofenceConfig(isFeatureEnable=");
        sb.append(this.isFeatureEnable);
        sb.append(", cachedInterval=");
        sb.append(this.cachedInterval);
        sb.append(", maxRetry=");
        sb.append(this.maxRetry);
        sb.append(')');
        return sb.toString();
    }

    public GeofenceConfig(boolean z, int i, int i2) {
        this.isFeatureEnable = z;
        this.cachedInterval = i;
        this.maxRetry = i2;
    }

    @JvmName(name = "isFeatureEnable")
    public final boolean isFeatureEnable() {
        return this.isFeatureEnable;
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

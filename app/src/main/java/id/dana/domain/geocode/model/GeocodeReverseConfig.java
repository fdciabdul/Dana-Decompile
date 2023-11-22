package id.dana.domain.geocode.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n"}, d2 = {"Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()Z", "distanceInMeters", "intervalInHours", "shouldCallHEREGeocodeAPI", "copy", "(Ljava/lang/String;JZ)Lid/dana/domain/geocode/model/GeocodeReverseConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDistanceInMeters", "J", "getIntervalInHours", "Z", "getShouldCallHEREGeocodeAPI", "<init>", "(Ljava/lang/String;JZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeocodeReverseConfig {
    private final String distanceInMeters;
    private final long intervalInHours;
    private final boolean shouldCallHEREGeocodeAPI;

    public GeocodeReverseConfig() {
        this(null, 0L, false, 7, null);
    }

    public static /* synthetic */ GeocodeReverseConfig copy$default(GeocodeReverseConfig geocodeReverseConfig, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geocodeReverseConfig.distanceInMeters;
        }
        if ((i & 2) != 0) {
            j = geocodeReverseConfig.intervalInHours;
        }
        if ((i & 4) != 0) {
            z = geocodeReverseConfig.shouldCallHEREGeocodeAPI;
        }
        return geocodeReverseConfig.copy(str, j, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDistanceInMeters() {
        return this.distanceInMeters;
    }

    /* renamed from: component2  reason: from getter */
    public final long getIntervalInHours() {
        return this.intervalInHours;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getShouldCallHEREGeocodeAPI() {
        return this.shouldCallHEREGeocodeAPI;
    }

    public final GeocodeReverseConfig copy(String distanceInMeters, long intervalInHours, boolean shouldCallHEREGeocodeAPI) {
        Intrinsics.checkNotNullParameter(distanceInMeters, "");
        return new GeocodeReverseConfig(distanceInMeters, intervalInHours, shouldCallHEREGeocodeAPI);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeocodeReverseConfig) {
            GeocodeReverseConfig geocodeReverseConfig = (GeocodeReverseConfig) other;
            return Intrinsics.areEqual(this.distanceInMeters, geocodeReverseConfig.distanceInMeters) && this.intervalInHours == geocodeReverseConfig.intervalInHours && this.shouldCallHEREGeocodeAPI == geocodeReverseConfig.shouldCallHEREGeocodeAPI;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.distanceInMeters.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.intervalInHours);
        boolean z = this.shouldCallHEREGeocodeAPI;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + m) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeocodeReverseConfig(distanceInMeters=");
        sb.append(this.distanceInMeters);
        sb.append(", intervalInHours=");
        sb.append(this.intervalInHours);
        sb.append(", shouldCallHEREGeocodeAPI=");
        sb.append(this.shouldCallHEREGeocodeAPI);
        sb.append(')');
        return sb.toString();
    }

    public GeocodeReverseConfig(String str, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.distanceInMeters = str;
        this.intervalInHours = j;
        this.shouldCallHEREGeocodeAPI = z;
    }

    public /* synthetic */ GeocodeReverseConfig(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getDistanceInMeters")
    public final String getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @JvmName(name = "getIntervalInHours")
    public final long getIntervalInHours() {
        return this.intervalInHours;
    }

    @JvmName(name = "getShouldCallHEREGeocodeAPI")
    public final boolean getShouldCallHEREGeocodeAPI() {
        return this.shouldCallHEREGeocodeAPI;
    }
}

package id.dana.data.geocode.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/data/geocode/model/GeocodeReverseConfigResult;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()Z", "distanceInMeters", "intervalInHours", "shouldCallHEREGeocodeAPI", "copy", "(Ljava/lang/String;JZ)Lid/dana/data/geocode/model/GeocodeReverseConfigResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDistanceInMeters", "setDistanceInMeters", "(Ljava/lang/String;)V", "J", "getIntervalInHours", "setIntervalInHours", "(J)V", "Z", "getShouldCallHEREGeocodeAPI", "setShouldCallHEREGeocodeAPI", "(Z)V", "<init>", "(Ljava/lang/String;JZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GeocodeReverseConfigResult implements Serializable {
    public String distanceInMeters;
    public long intervalInHours;
    public boolean shouldCallHEREGeocodeAPI;

    public GeocodeReverseConfigResult() {
        this(null, 0L, false, 7, null);
    }

    public static /* synthetic */ GeocodeReverseConfigResult copy$default(GeocodeReverseConfigResult geocodeReverseConfigResult, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geocodeReverseConfigResult.distanceInMeters;
        }
        if ((i & 2) != 0) {
            j = geocodeReverseConfigResult.intervalInHours;
        }
        if ((i & 4) != 0) {
            z = geocodeReverseConfigResult.shouldCallHEREGeocodeAPI;
        }
        return geocodeReverseConfigResult.copy(str, j, z);
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

    public final GeocodeReverseConfigResult copy(String distanceInMeters, long intervalInHours, boolean shouldCallHEREGeocodeAPI) {
        Intrinsics.checkNotNullParameter(distanceInMeters, "");
        return new GeocodeReverseConfigResult(distanceInMeters, intervalInHours, shouldCallHEREGeocodeAPI);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GeocodeReverseConfigResult) {
            GeocodeReverseConfigResult geocodeReverseConfigResult = (GeocodeReverseConfigResult) other;
            return Intrinsics.areEqual(this.distanceInMeters, geocodeReverseConfigResult.distanceInMeters) && this.intervalInHours == geocodeReverseConfigResult.intervalInHours && this.shouldCallHEREGeocodeAPI == geocodeReverseConfigResult.shouldCallHEREGeocodeAPI;
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
        sb.append("GeocodeReverseConfigResult(distanceInMeters=");
        sb.append(this.distanceInMeters);
        sb.append(", intervalInHours=");
        sb.append(this.intervalInHours);
        sb.append(", shouldCallHEREGeocodeAPI=");
        sb.append(this.shouldCallHEREGeocodeAPI);
        sb.append(')');
        return sb.toString();
    }

    public GeocodeReverseConfigResult(String str, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.distanceInMeters = str;
        this.intervalInHours = j;
        this.shouldCallHEREGeocodeAPI = z;
    }

    public /* synthetic */ GeocodeReverseConfigResult(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "500" : str, (i & 2) != 0 ? 24L : j, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getDistanceInMeters")
    public final String getDistanceInMeters() {
        return this.distanceInMeters;
    }

    @JvmName(name = "setDistanceInMeters")
    public final void setDistanceInMeters(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.distanceInMeters = str;
    }

    @JvmName(name = "getIntervalInHours")
    public final long getIntervalInHours() {
        return this.intervalInHours;
    }

    @JvmName(name = "setIntervalInHours")
    public final void setIntervalInHours(long j) {
        this.intervalInHours = j;
    }

    @JvmName(name = "getShouldCallHEREGeocodeAPI")
    public final boolean getShouldCallHEREGeocodeAPI() {
        return this.shouldCallHEREGeocodeAPI;
    }

    @JvmName(name = "setShouldCallHEREGeocodeAPI")
    public final void setShouldCallHEREGeocodeAPI(boolean z) {
        this.shouldCallHEREGeocodeAPI = z;
    }
}

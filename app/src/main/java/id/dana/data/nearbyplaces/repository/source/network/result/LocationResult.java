package id.dana.data.nearbyplaces.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;", "", "", "component1", "()D", "component2", "lat", "lng", "copy", "(DD)Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", SummaryActivity.DAYS, "getLat", "getLng", "<init>", "(DD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class LocationResult {
    @SerializedName("lat")
    private final double lat;
    private final double lng;

    public static /* synthetic */ LocationResult copy$default(LocationResult locationResult, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = locationResult.lat;
        }
        if ((i & 2) != 0) {
            d2 = locationResult.lng;
        }
        return locationResult.copy(d, d2);
    }

    /* renamed from: component1  reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    public final LocationResult copy(double lat, double lng) {
        return new LocationResult(lat, lng);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(locationResult.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lng), (Object) Double.valueOf(locationResult.lng));
        }
        return false;
    }

    public final int hashCode() {
        return (BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lat) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lng);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationResult(lat=");
        sb.append(this.lat);
        sb.append(", lng=");
        sb.append(this.lng);
        sb.append(')');
        return sb.toString();
    }

    public LocationResult(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    @JvmName(name = "getLat")
    public final double getLat() {
        return this.lat;
    }

    @JvmName(name = "getLng")
    public final double getLng() {
        return this.lng;
    }
}

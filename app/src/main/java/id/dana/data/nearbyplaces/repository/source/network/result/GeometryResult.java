package id.dana.data.nearbyplaces.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;", "component1", "()Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;", "location", "copy", "(Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;)Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;", "getLocation", "<init>", "(Lid/dana/data/nearbyplaces/repository/source/network/result/LocationResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class GeometryResult {
    @SerializedName("location")
    private final LocationResult location;

    public static /* synthetic */ GeometryResult copy$default(GeometryResult geometryResult, LocationResult locationResult, int i, Object obj) {
        if ((i & 1) != 0) {
            locationResult = geometryResult.location;
        }
        return geometryResult.copy(locationResult);
    }

    /* renamed from: component1  reason: from getter */
    public final LocationResult getLocation() {
        return this.location;
    }

    public final GeometryResult copy(LocationResult location) {
        Intrinsics.checkNotNullParameter(location, "");
        return new GeometryResult(location);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GeometryResult) && Intrinsics.areEqual(this.location, ((GeometryResult) other).location);
    }

    public final int hashCode() {
        return this.location.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeometryResult(location=");
        sb.append(this.location);
        sb.append(')');
        return sb.toString();
    }

    public GeometryResult(LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "");
        this.location = locationResult;
    }

    @JvmName(name = "getLocation")
    public final LocationResult getLocation() {
        return this.location;
    }
}

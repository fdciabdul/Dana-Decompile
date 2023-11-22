package id.dana.data.nearbyplaces.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;", "component1", "()Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;", "geometry", "copy", "(Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;)Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;", "getGeometry", "<init>", "(Lid/dana/data/nearbyplaces/repository/source/network/result/GeometryResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class PlaceComponentResult {
    @SerializedName("geometry")
    private final GeometryResult geometry;

    public static /* synthetic */ PlaceComponentResult copy$default(PlaceComponentResult placeComponentResult, GeometryResult geometryResult, int i, Object obj) {
        if ((i & 1) != 0) {
            geometryResult = placeComponentResult.geometry;
        }
        return placeComponentResult.copy(geometryResult);
    }

    /* renamed from: component1  reason: from getter */
    public final GeometryResult getGeometry() {
        return this.geometry;
    }

    public final PlaceComponentResult copy(GeometryResult geometry) {
        Intrinsics.checkNotNullParameter(geometry, "");
        return new PlaceComponentResult(geometry);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlaceComponentResult) && Intrinsics.areEqual(this.geometry, ((PlaceComponentResult) other).geometry);
    }

    public final int hashCode() {
        return this.geometry.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlaceComponentResult(geometry=");
        sb.append(this.geometry);
        sb.append(')');
        return sb.toString();
    }

    public PlaceComponentResult(GeometryResult geometryResult) {
        Intrinsics.checkNotNullParameter(geometryResult, "");
        this.geometry = geometryResult;
    }

    @JvmName(name = "getGeometry")
    public final GeometryResult getGeometry() {
        return this.geometry;
    }
}

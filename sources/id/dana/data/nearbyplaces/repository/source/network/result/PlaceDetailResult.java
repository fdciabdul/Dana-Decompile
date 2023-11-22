package id.dana.data.nearbyplaces.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceDetailResult;", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;", "component1", "()Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;", "", "component2", "()Ljava/lang/String;", "result", "status", "copy", "(Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;Ljava/lang/String;)Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceDetailResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;", "getResult", "Ljava/lang/String;", "getStatus", "<init>", "(Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceComponentResult;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class PlaceDetailResult {
    private final PlaceComponentResult result;
    @SerializedName("status")
    private final String status;

    public static /* synthetic */ PlaceDetailResult copy$default(PlaceDetailResult placeDetailResult, PlaceComponentResult placeComponentResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            placeComponentResult = placeDetailResult.result;
        }
        if ((i & 2) != 0) {
            str = placeDetailResult.status;
        }
        return placeDetailResult.copy(placeComponentResult, str);
    }

    /* renamed from: component1  reason: from getter */
    public final PlaceComponentResult getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final PlaceDetailResult copy(PlaceComponentResult result, String status) {
        Intrinsics.checkNotNullParameter(result, "");
        Intrinsics.checkNotNullParameter(status, "");
        return new PlaceDetailResult(result, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PlaceDetailResult) {
            PlaceDetailResult placeDetailResult = (PlaceDetailResult) other;
            return Intrinsics.areEqual(this.result, placeDetailResult.result) && Intrinsics.areEqual(this.status, placeDetailResult.status);
        }
        return false;
    }

    public final int hashCode() {
        return (this.result.hashCode() * 31) + this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlaceDetailResult(result=");
        sb.append(this.result);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public PlaceDetailResult(PlaceComponentResult placeComponentResult, String str) {
        Intrinsics.checkNotNullParameter(placeComponentResult, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.result = placeComponentResult;
        this.status = str;
    }

    @JvmName(name = "getResult")
    public final PlaceComponentResult getResult() {
        return this.result;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }
}

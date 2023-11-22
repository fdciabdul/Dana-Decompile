package id.dana.data.nearbyplaces.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001a\u0010\n\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceSearchListResult;", "", "", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "predictions", "status", "copy", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/data/nearbyplaces/repository/source/network/result/PlaceSearchListResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getPredictions", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class PlaceSearchListResult {
    private final List<PlacePredictionResult> predictions;
    @SerializedName("status")
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaceSearchListResult copy$default(PlaceSearchListResult placeSearchListResult, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = placeSearchListResult.predictions;
        }
        if ((i & 2) != 0) {
            str = placeSearchListResult.status;
        }
        return placeSearchListResult.copy(list, str);
    }

    public final List<PlacePredictionResult> component1() {
        return this.predictions;
    }

    /* renamed from: component2  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final PlaceSearchListResult copy(List<PlacePredictionResult> predictions, String status) {
        Intrinsics.checkNotNullParameter(predictions, "");
        Intrinsics.checkNotNullParameter(status, "");
        return new PlaceSearchListResult(predictions, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PlaceSearchListResult) {
            PlaceSearchListResult placeSearchListResult = (PlaceSearchListResult) other;
            return Intrinsics.areEqual(this.predictions, placeSearchListResult.predictions) && Intrinsics.areEqual(this.status, placeSearchListResult.status);
        }
        return false;
    }

    public final int hashCode() {
        return (this.predictions.hashCode() * 31) + this.status.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlaceSearchListResult(predictions=");
        sb.append(this.predictions);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public PlaceSearchListResult(List<PlacePredictionResult> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.predictions = list;
        this.status = str;
    }

    @JvmName(name = "getPredictions")
    public final List<PlacePredictionResult> getPredictions() {
        return this.predictions;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }
}

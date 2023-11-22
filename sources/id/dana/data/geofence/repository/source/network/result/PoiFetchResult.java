package id.dana.data.geofence.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.geofence.model.PoiInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2 = {"Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/geofence/model/PoiInfoEntity;", "component1", "()Ljava/util/List;", "pois", "copy", "(Ljava/util/List;)Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getPois", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PoiFetchResult extends BaseRpcResult {
    private final List<PoiInfoEntity> pois;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiFetchResult copy$default(PoiFetchResult poiFetchResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = poiFetchResult.pois;
        }
        return poiFetchResult.copy(list);
    }

    public final List<PoiInfoEntity> component1() {
        return this.pois;
    }

    public final PoiFetchResult copy(List<PoiInfoEntity> pois) {
        Intrinsics.checkNotNullParameter(pois, "");
        return new PoiFetchResult(pois);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PoiFetchResult) && Intrinsics.areEqual(this.pois, ((PoiFetchResult) other).pois);
    }

    public final int hashCode() {
        return this.pois.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiFetchResult(pois=");
        sb.append(this.pois);
        sb.append(')');
        return sb.toString();
    }

    public PoiFetchResult(List<PoiInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.pois = list;
    }

    @JvmName(name = "getPois")
    public final List<PoiInfoEntity> getPois() {
        return this.pois;
    }
}

package id.dana.data.geofence.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.geofence.model.PoiNotificationInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/geofence/repository/source/network/request/PoiNotificationRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Ljava/io/Serializable;", "", "Lid/dana/data/geofence/model/PoiNotificationInfo;", "pois", "Ljava/util/List;", "getPois", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PoiNotificationRequest extends BaseRpcRequest implements Serializable {
    private final List<PoiNotificationInfo> pois;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PoiNotificationRequest() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.geofence.repository.source.network.request.PoiNotificationRequest.<init>():void");
    }

    public PoiNotificationRequest(List<PoiNotificationInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.pois = list;
    }

    public /* synthetic */ PoiNotificationRequest(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPois")
    public final List<PoiNotificationInfo> getPois() {
        return this.pois;
    }
}

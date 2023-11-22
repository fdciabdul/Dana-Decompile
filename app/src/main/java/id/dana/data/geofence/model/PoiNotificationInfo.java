package id.dana.data.geofence.model;

import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/geofence/model/PoiNotificationInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "poiId", UrlParam.REQUEST_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/geofence/model/PoiNotificationInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPoiId", "getRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PoiNotificationInfo {
    private final String poiId;
    private final String requestId;

    public static /* synthetic */ PoiNotificationInfo copy$default(PoiNotificationInfo poiNotificationInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = poiNotificationInfo.poiId;
        }
        if ((i & 2) != 0) {
            str2 = poiNotificationInfo.requestId;
        }
        return poiNotificationInfo.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final PoiNotificationInfo copy(String poiId, String requestId) {
        Intrinsics.checkNotNullParameter(poiId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        return new PoiNotificationInfo(poiId, requestId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PoiNotificationInfo) {
            PoiNotificationInfo poiNotificationInfo = (PoiNotificationInfo) other;
            return Intrinsics.areEqual(this.poiId, poiNotificationInfo.poiId) && Intrinsics.areEqual(this.requestId, poiNotificationInfo.requestId);
        }
        return false;
    }

    public final int hashCode() {
        return (this.poiId.hashCode() * 31) + this.requestId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiNotificationInfo(poiId=");
        sb.append(this.poiId);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(')');
        return sb.toString();
    }

    public PoiNotificationInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.poiId = str;
        this.requestId = str2;
    }

    @JvmName(name = "getPoiId")
    public final String getPoiId() {
        return this.poiId;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }
}

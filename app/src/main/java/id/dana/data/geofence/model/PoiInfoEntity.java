package id.dana.data.geofence.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0017\u0010\u000e\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b"}, d2 = {"Lid/dana/data/geofence/model/PoiInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()D", "component3", "", "component4", "()I", "poiId", "longitude", "latitude", "radius", "copy", "(Ljava/lang/String;DDI)Lid/dana/data/geofence/model/PoiInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", SummaryActivity.DAYS, "getLatitude", "getLongitude", "Ljava/lang/String;", "getPoiId", "I", "getRadius", "<init>", "(Ljava/lang/String;DDI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PoiInfoEntity {
    private final double latitude;
    private final double longitude;
    private final String poiId;
    private final int radius;

    public PoiInfoEntity() {
        this(null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 15, null);
    }

    public static /* synthetic */ PoiInfoEntity copy$default(PoiInfoEntity poiInfoEntity, String str, double d, double d2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = poiInfoEntity.poiId;
        }
        if ((i2 & 2) != 0) {
            d = poiInfoEntity.longitude;
        }
        double d3 = d;
        if ((i2 & 4) != 0) {
            d2 = poiInfoEntity.latitude;
        }
        double d4 = d2;
        if ((i2 & 8) != 0) {
            i = poiInfoEntity.radius;
        }
        return poiInfoEntity.copy(str, d3, d4, i);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component3  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component4  reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    public final PoiInfoEntity copy(String poiId, double longitude, double latitude, int radius) {
        Intrinsics.checkNotNullParameter(poiId, "");
        return new PoiInfoEntity(poiId, longitude, latitude, radius);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PoiInfoEntity) {
            PoiInfoEntity poiInfoEntity = (PoiInfoEntity) other;
            return Intrinsics.areEqual(this.poiId, poiInfoEntity.poiId) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(poiInfoEntity.longitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(poiInfoEntity.latitude)) && this.radius == poiInfoEntity.radius;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.poiId.hashCode() * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude)) * 31) + this.radius;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiInfoEntity(poiId=");
        sb.append(this.poiId);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", radius=");
        sb.append(this.radius);
        sb.append(')');
        return sb.toString();
    }

    public PoiInfoEntity(String str, double d, double d2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.poiId = str;
        this.longitude = d;
        this.latitude = d2;
        this.radius = i;
    }

    public /* synthetic */ PoiInfoEntity(String str, double d, double d2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0.0d : d, (i2 & 4) == 0 ? d2 : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (i2 & 8) != 0 ? 100 : i);
    }

    @JvmName(name = "getPoiId")
    public final String getPoiId() {
        return this.poiId;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getRadius")
    public final int getRadius() {
        return this.radius;
    }
}

package id.dana.data.geofence.repository.source.persistence.entity;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0012\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010#R\"\u0010\u0011\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\n\"\u0004\b%\u0010#R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010)R\"\u0010\u0010\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010*\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010-"}, d2 = {"Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "", "component3", "()D", "component4", "", "component5", "()Ljava/lang/Long;", "poiId", "radius", "longitude", "latitude", "lastPoiNotified", "copy", "(Ljava/lang/String;IDDLjava/lang/Long;)Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/Long;", "getLastPoiNotified", "setLastPoiNotified", "(Ljava/lang/Long;)V", SummaryActivity.DAYS, "getLatitude", "setLatitude", "(D)V", "getLongitude", "setLongitude", "Ljava/lang/String;", "getPoiId", "setPoiId", "(Ljava/lang/String;)V", "I", "getRadius", "setRadius", "(I)V", "<init>", "(Ljava/lang/String;IDDLjava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RecentPoiEntity {
    private Long lastPoiNotified;
    private double latitude;
    private double longitude;
    private String poiId;
    private int radius;

    public RecentPoiEntity() {
        this(null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, 31, null);
    }

    public static /* synthetic */ RecentPoiEntity copy$default(RecentPoiEntity recentPoiEntity, String str, int i, double d, double d2, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recentPoiEntity.poiId;
        }
        if ((i2 & 2) != 0) {
            i = recentPoiEntity.radius;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            d = recentPoiEntity.longitude;
        }
        double d3 = d;
        if ((i2 & 8) != 0) {
            d2 = recentPoiEntity.latitude;
        }
        double d4 = d2;
        if ((i2 & 16) != 0) {
            l = recentPoiEntity.lastPoiNotified;
        }
        return recentPoiEntity.copy(str, i3, d3, d4, l);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: component2  reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    /* renamed from: component3  reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component4  reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getLastPoiNotified() {
        return this.lastPoiNotified;
    }

    public final RecentPoiEntity copy(@Nonnull String poiId, int radius, double longitude, double latitude, Long lastPoiNotified) {
        Intrinsics.checkNotNullParameter(poiId, "");
        return new RecentPoiEntity(poiId, radius, longitude, latitude, lastPoiNotified);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RecentPoiEntity) {
            RecentPoiEntity recentPoiEntity = (RecentPoiEntity) other;
            return Intrinsics.areEqual(this.poiId, recentPoiEntity.poiId) && this.radius == recentPoiEntity.radius && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(recentPoiEntity.longitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(recentPoiEntity.latitude)) && Intrinsics.areEqual(this.lastPoiNotified, recentPoiEntity.lastPoiNotified);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.poiId.hashCode();
        int i = this.radius;
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.longitude);
        int KClassImpl$Data$declaredNonStaticMembers$22 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.latitude);
        Long l = this.lastPoiNotified;
        return (((((((hashCode * 31) + i) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + KClassImpl$Data$declaredNonStaticMembers$22) * 31) + (l == null ? 0 : l.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecentPoiEntity(poiId=");
        sb.append(this.poiId);
        sb.append(", radius=");
        sb.append(this.radius);
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", lastPoiNotified=");
        sb.append(this.lastPoiNotified);
        sb.append(')');
        return sb.toString();
    }

    public RecentPoiEntity(@Nonnull String str, int i, double d, double d2, Long l) {
        Intrinsics.checkNotNullParameter(str, "");
        this.poiId = str;
        this.radius = i;
        this.longitude = d;
        this.latitude = d2;
        this.lastPoiNotified = l;
    }

    @JvmName(name = "getPoiId")
    public final String getPoiId() {
        return this.poiId;
    }

    @JvmName(name = "setPoiId")
    public final void setPoiId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.poiId = str;
    }

    @JvmName(name = "getRadius")
    public final int getRadius() {
        return this.radius;
    }

    @JvmName(name = "setRadius")
    public final void setRadius(int i) {
        this.radius = i;
    }

    @JvmName(name = "getLongitude")
    public final double getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "setLongitude")
    public final void setLongitude(double d) {
        this.longitude = d;
    }

    @JvmName(name = "getLatitude")
    public final double getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "setLatitude")
    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public /* synthetic */ RecentPoiEntity(String str, int i, double d, double d2, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0.0d : d, (i2 & 8) == 0 ? d2 : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (i2 & 16) != 0 ? 0L : l);
    }

    @JvmName(name = "getLastPoiNotified")
    public final Long getLastPoiNotified() {
        return this.lastPoiNotified;
    }

    @JvmName(name = "setLastPoiNotified")
    public final void setLastPoiNotified(Long l) {
        this.lastPoiNotified = l;
    }
}

package id.dana.data.promocenter.repository.source.local.model;

import android.location.Location;
import com.alipay.mobile.map.model.MapConstant;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;", "", "", "component1", "()D", "component2", "lat", MapConstant.EXTRA_LON, "copy", "(DD)Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/location/Location;", "toLocation", "()Landroid/location/Location;", "", "toString", "()Ljava/lang/String;", SummaryActivity.DAYS, "getLat", "getLon", "<init>", "(DD)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserCoordinateEntityData {
    private final double lat;
    private final double lon;

    public UserCoordinateEntityData() {
        this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 3, null);
    }

    public static /* synthetic */ UserCoordinateEntityData copy$default(UserCoordinateEntityData userCoordinateEntityData, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = userCoordinateEntityData.lat;
        }
        if ((i & 2) != 0) {
            d2 = userCoordinateEntityData.lon;
        }
        return userCoordinateEntityData.copy(d, d2);
    }

    /* renamed from: component1  reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: component2  reason: from getter */
    public final double getLon() {
        return this.lon;
    }

    public final UserCoordinateEntityData copy(double lat, double lon) {
        return new UserCoordinateEntityData(lat, lon);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserCoordinateEntityData) {
            UserCoordinateEntityData userCoordinateEntityData = (UserCoordinateEntityData) other;
            return Intrinsics.areEqual((Object) Double.valueOf(this.lat), (Object) Double.valueOf(userCoordinateEntityData.lat)) && Intrinsics.areEqual((Object) Double.valueOf(this.lon), (Object) Double.valueOf(userCoordinateEntityData.lon));
        }
        return false;
    }

    public final int hashCode() {
        return (BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lat) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lon);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserCoordinateEntityData(lat=");
        sb.append(this.lat);
        sb.append(", lon=");
        sb.append(this.lon);
        sb.append(')');
        return sb.toString();
    }

    public UserCoordinateEntityData(double d, double d2) {
        this.lat = d;
        this.lon = d2;
    }

    public /* synthetic */ UserCoordinateEntityData(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
    }

    @JvmName(name = "getLat")
    public final double getLat() {
        return this.lat;
    }

    @JvmName(name = "getLon")
    public final double getLon() {
        return this.lon;
    }

    public final Location toLocation() {
        Location location = new Location("");
        location.setLatitude(this.lat);
        location.setLongitude(this.lon);
        return location;
    }
}

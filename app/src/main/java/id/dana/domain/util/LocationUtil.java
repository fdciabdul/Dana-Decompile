package id.dana.domain.util;

import android.location.Location;
import com.alipay.mobile.map.model.MapConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/util/LocationUtil;", "", "", "lat1", "lon1", "lat2", "lon2", "", "getDistance", "(DDDD)F", "lat", MapConstant.EXTRA_LON, "Landroid/location/Location;", "latLonToLocation", "(DD)Landroid/location/Location;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocationUtil {
    public static final LocationUtil INSTANCE = new LocationUtil();

    private LocationUtil() {
    }

    @JvmStatic
    public static final Location latLonToLocation(double lat, double lon) {
        Location location = new Location("");
        location.setLatitude(lat);
        location.setLongitude(lon);
        return location;
    }

    @JvmStatic
    public static final float getDistance(double lat1, double lon1, double lat2, double lon2) {
        return latLonToLocation(lat1, lon1).distanceTo(latLonToLocation(lat2, lon2));
    }
}

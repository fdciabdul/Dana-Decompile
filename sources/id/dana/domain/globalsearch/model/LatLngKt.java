package id.dana.domain.globalsearch.model;

import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/location/Location;", "Lid/dana/domain/globalsearch/model/LatLng;", "toLatLng", "(Landroid/location/Location;)Lid/dana/domain/globalsearch/model/LatLng;", "toLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)Landroid/location/Location;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LatLngKt {
    public static final Location toLocation(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "");
        Location location = new Location("");
        location.setLatitude(latLng.getLatitude());
        location.setLongitude(latLng.getLongitude());
        return location;
    }

    public static final LatLng toLatLng(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        return new LatLng(location.getLatitude(), location.getLongitude());
    }
}

package id.dana.danah5.locationpicker;

import android.location.Location;
import id.dana.utils.LocationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/location/Location;", "", "isMonas", "(Landroid/location/Location;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MapPageActivityKt {
    public static final boolean isMonas(Location location) {
        Intrinsics.checkNotNullParameter(location, "");
        return Intrinsics.areEqual(location, LocationUtil.getAuthRequestContext());
    }
}

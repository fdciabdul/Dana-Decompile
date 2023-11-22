package id.dana.geofence;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/geofence/PointOfInterestEmptyException;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PointOfInterestEmptyException extends Throwable {
    public PointOfInterestEmptyException() {
        super("Point of interest must not be empty to get fencing request");
    }
}

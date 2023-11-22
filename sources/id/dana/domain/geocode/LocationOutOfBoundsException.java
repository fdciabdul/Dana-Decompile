package id.dana.domain.geocode;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/geocode/LocationOutOfBoundsException;", "Ljava/lang/Exception;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocationOutOfBoundsException extends Exception {
    public LocationOutOfBoundsException() {
        super("Location must be between -90 <= latitude <= 90 and -180 <= longitude <= 180");
    }
}
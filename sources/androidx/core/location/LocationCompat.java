package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class LocationCompat {
    private LocationCompat() {
    }

    public static boolean MyBillsEntityDataFactory(Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.getAuthRequestContext(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.getBoolean("mockLocation", false);
    }

    /* loaded from: classes6.dex */
    static class Api26Impl {
        private Api26Impl() {
        }
    }

    /* loaded from: classes3.dex */
    static class Api18Impl {
        private Api18Impl() {
        }

        static boolean getAuthRequestContext(Location location) {
            return location.isFromMockProvider();
        }
    }

    /* loaded from: classes6.dex */
    static class Api17Impl {
        private Api17Impl() {
        }
    }
}

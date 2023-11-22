package id.dana.util.device;

import android.os.Build;

/* loaded from: classes2.dex */
public final class OSUtil {
    private OSUtil() {
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean PlaceComponentResult() {
        return Build.VERSION.SDK_INT >= 24;
    }
}

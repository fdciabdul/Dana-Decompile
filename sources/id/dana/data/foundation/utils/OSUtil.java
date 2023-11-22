package id.dana.data.foundation.utils;

import android.os.Build;

/* loaded from: classes4.dex */
public class OSUtil {
    private OSUtil() {
    }

    public static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean MyBillsEntityDataFactory() {
        return Build.VERSION.SDK_INT < 22;
    }
}

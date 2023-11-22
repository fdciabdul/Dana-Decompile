package fsimpl;

import android.app.Activity;
import android.os.Build;

/* renamed from: fsimpl.et  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0349et {
    public static boolean a(Activity activity) {
        return Build.VERSION.SDK_INT >= 30 ? b(activity) : c(activity);
    }

    private static boolean b(Activity activity) {
        return (activity.getWindow().getDecorView().getWindowInsetsController().getSystemBarsAppearance() & 8) != 0;
    }

    private static boolean c(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 8192) != 0;
    }
}

package fsimpl;

import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class eD {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f7951a;

    public static DisplayMetrics a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        f7951a.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static void a(WindowManager windowManager) {
        synchronized (eD.class) {
            f7951a = windowManager;
        }
    }
}

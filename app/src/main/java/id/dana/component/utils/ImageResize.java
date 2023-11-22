package id.dana.component.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/* loaded from: classes4.dex */
public class ImageResize {
    public static int BuiltInFictitiousFunctionClassFactory(Activity activity, int i) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) Math.ceil(i * r0.density);
    }
}

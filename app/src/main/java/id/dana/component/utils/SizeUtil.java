package id.dana.component.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* loaded from: classes4.dex */
public class SizeUtil {
    public static int MyBillsEntityDataFactory() {
        return (int) (16.0f / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int PlaceComponentResult(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int MyBillsEntityDataFactory(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float getAuthRequestContext(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        return r0.heightPixels;
    }
}

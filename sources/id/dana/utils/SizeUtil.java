package id.dana.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: classes2.dex */
public class SizeUtil {
    public static int PlaceComponentResult(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getAuthRequestContext(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static float PlaceComponentResult(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        return r0.heightPixels;
    }
}

package id.dana.utils.showcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import id.dana.utils.OSUtil;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class Utils {
    public static void getAuthRequestContext(Context context, long j) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
        } else {
            vibrator.vibrate(j);
        }
    }

    public static void getAuthRequestContext(Activity activity) {
        Intent intent;
        if (MyBillsEntityDataFactory(activity)) {
            StringBuilder sb = new StringBuilder();
            sb.append("market://details?id=");
            sb.append(activity.getPackageName());
            intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(activity.getApplicationContext().getPackageName());
            intent = new Intent("android.intent.action.VIEW", Uri.parse(sb2.toString()));
        }
        activity.startActivity(intent);
    }

    private static boolean MyBillsEntityDataFactory(Activity activity) {
        Iterator<ResolveInfo> it = activity.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=")), 65536).iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.applicationInfo.packageName.equalsIgnoreCase("com.android.vending")) {
                return true;
            }
        }
        return false;
    }

    public static boolean getAuthRequestContext(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    public static void PlaceComponentResult(Context context) {
        context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public static int getAuthRequestContext(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.navigationBars()).bottom;
        }
        try {
            defaultDisplay = context.getDisplay();
        } catch (NoSuchMethodError unused) {
            defaultDisplay = windowManager.getDefaultDisplay();
        }
        Point point = new Point();
        Point point2 = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
        }
        if (point.x < point2.x) {
            return point2.x - point.x;
        }
        if (point.y < point2.y) {
            return point2.y - point.y;
        }
        return 0;
    }
}

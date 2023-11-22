package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class NavUtils {
    public static boolean getAuthRequestContext(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT < 16) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }
        return activity.shouldUpRecreateTask(intent);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.getAuthRequestContext(activity, intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public static Intent BuiltInFictitiousFunctionClassFactory(Activity activity) {
        Intent MyBillsEntityDataFactory;
        if (Build.VERSION.SDK_INT < 16 || (MyBillsEntityDataFactory = Api16Impl.MyBillsEntityDataFactory(activity)) == null) {
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(activity);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, KClassImpl$Data$declaredNonStaticMembers$2);
            try {
                if (PlaceComponentResult(activity, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("getParentActivityIntent: bad parentActivityName '");
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append("' in manifest");
                InstrumentInjector.log_e("NavUtils", sb.toString());
                return null;
            }
        }
        return MyBillsEntityDataFactory;
    }

    public static Intent BuiltInFictitiousFunctionClassFactory(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String PlaceComponentResult = PlaceComponentResult(context, componentName);
        if (PlaceComponentResult == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), PlaceComponentResult);
        if (PlaceComponentResult(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        try {
            return PlaceComponentResult(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String PlaceComponentResult(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i;
        String string;
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 29) {
            i = 269222528;
        } else {
            i = Build.VERSION.SDK_INT >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        if (Build.VERSION.SDK_INT < 16 || (str = activityInfo.parentActivityName) == null) {
            if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(string);
                return sb.toString();
            }
            return string;
        }
        return str;
    }

    private NavUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static boolean getAuthRequestContext(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        static Intent MyBillsEntityDataFactory(Activity activity) {
            return activity.getParentActivityIntent();
        }
    }
}

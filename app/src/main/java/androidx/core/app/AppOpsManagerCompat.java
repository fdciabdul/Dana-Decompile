package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* loaded from: classes.dex */
public final class AppOpsManagerCompat {
    private AppOpsManagerCompat() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getAuthRequestContext(str);
        }
        return null;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.PlaceComponentResult((AppOpsManager) Api23Impl.PlaceComponentResult(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static int BuiltInFictitiousFunctionClassFactory(Context context, int i, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager authRequestContext = Api29Impl.getAuthRequestContext(context);
            int MyBillsEntityDataFactory = Api29Impl.MyBillsEntityDataFactory(authRequestContext, str, Binder.getCallingUid(), str2);
            return MyBillsEntityDataFactory != 0 ? MyBillsEntityDataFactory : Api29Impl.MyBillsEntityDataFactory(authRequestContext, str, i, Api29Impl.PlaceComponentResult(context));
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2);
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static AppOpsManager getAuthRequestContext(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        static int MyBillsEntityDataFactory(AppOpsManager appOpsManager, String str, int i, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i, str2);
        }

        static String PlaceComponentResult(Context context) {
            return context.getOpPackageName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static String getAuthRequestContext(String str) {
            return AppOpsManager.permissionToOp(str);
        }

        static <T> T PlaceComponentResult(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static int PlaceComponentResult(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }
}

package id.dana.utils.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.richview.socialshare.AppPackageName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rJ'\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lid/dana/utils/android/AppUtil;", "", "()V", "WHATSAPP", "", "WHATSAPP_FOR_BUSINESS", "checkWhatsAppPackage", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "getAppNameInstalled", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "flags", "", "getFirstTimeInstall", "", "(Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/Long;", "isInstalled", "packageManager", "Landroid/content/pm/PackageManager;", "isPackageNameExist", "core-utils_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppUtil {
    public static final AppUtil MyBillsEntityDataFactory = new AppUtil();

    private AppUtil() {
    }

    @JvmStatic
    public static final boolean getAuthRequestContext(String str, PackageManager packageManager) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(packageManager, "");
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean getAuthRequestContext(Context context, String str) {
        return getErrorConfigVersion(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getErrorConfigVersion(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
            } else {
                context.getPackageManager().getApplicationInfo(str, 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static /* synthetic */ String PlaceComponentResult(Context context, String str) {
        return MyBillsEntityDataFactory(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String MyBillsEntityDataFactory(Context context, String str) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = context.getPackageManager().getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            }
            return packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static /* synthetic */ Long KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        return BuiltInFictitiousFunctionClassFactory(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Long BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = context.getPackageManager().getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            }
            return Long.valueOf(packageInfo.firstInstallTime);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(Context context) {
        if (context != null) {
            return IntentUtil.PlaceComponentResult(context, "com.whatsapp") || IntentUtil.PlaceComponentResult(context, AppPackageName.WHATSAPP_FOR_BUSINESS);
        }
        return false;
    }
}

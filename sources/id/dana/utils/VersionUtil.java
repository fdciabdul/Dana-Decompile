package id.dana.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes2.dex */
public class VersionUtil {
    private VersionUtil() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context) {
        return getAuthRequestContext(context, true);
    }

    public static String getAuthRequestContext(Context context, boolean z) {
        String str;
        String str2 = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str2 = String.valueOf(packageInfo.getLongVersionCode());
                } else {
                    str2 = String.valueOf(packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            str = "";
        }
        if (z || str2.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }
}

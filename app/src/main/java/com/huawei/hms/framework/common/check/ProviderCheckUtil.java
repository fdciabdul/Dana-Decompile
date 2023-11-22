package com.huawei.hms.framework.common.check;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes7.dex */
public class ProviderCheckUtil {
    private static String PlaceComponentResult = "ProviderCheckUtil";

    public static boolean isValid(Uri uri) {
        if (uri != null) {
            PackageManager packageManager = ContextHolder.getAppContext().getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
            if (resolveContentProvider != null) {
                ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
                if (applicationInfo != null) {
                    String str = applicationInfo.packageName;
                    String str2 = PlaceComponentResult;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Target provider service's package name is : ");
                    sb.append(str);
                    Logger.v(str2, sb.toString());
                    return str != null && packageManager.checkSignatures("com.huawei.hwid", str) == 0;
                }
                return false;
            }
            Logger.w(PlaceComponentResult, "Invalid param");
            return false;
        }
        return false;
    }
}

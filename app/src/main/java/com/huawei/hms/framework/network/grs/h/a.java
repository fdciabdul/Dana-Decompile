package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

/* loaded from: classes8.dex */
public class a {
    public static String PlaceComponentResult() {
        return "5.0.10.302";
    }

    private static String PlaceComponentResult(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.w("AgentUtil", "", e);
            return "";
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
        if (context == null) {
            Locale locale = Locale.ROOT;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/%s");
            return String.format(locale, sb.toString(), "5.0.10.302");
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String PlaceComponentResult = PlaceComponentResult(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale2 = Locale.ROOT;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("%s/%s (Linux; Android %s; %s) ");
        sb2.append(str);
        sb2.append("/%s %s");
        String obj = sb2.toString();
        Object[] objArr = new Object[6];
        objArr[0] = packageName;
        objArr[1] = PlaceComponentResult;
        objArr[2] = str3;
        objArr[3] = str4;
        objArr[4] = "5.0.10.302";
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        objArr[5] = str2;
        return String.format(locale2, obj, objArr);
    }
}

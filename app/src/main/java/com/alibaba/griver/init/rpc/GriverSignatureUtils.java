package com.alibaba.griver.init.rpc;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.android.common.utils.MiscUtils;

/* loaded from: classes3.dex */
public class GriverSignatureUtils {
    private GriverSignatureUtils() {
    }

    public static String getAuthCodeForSecurityGuard(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if ("PROD".equals(str2) && !TextUtils.isEmpty(str3) && TextUtils.equals(str3, a(context))) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2.toLowerCase());
            sb.append("_");
            sb.append("gp");
            return sb.toString();
        } else if ("PROD".equals(str2) || "PRE".equals(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("_");
            sb2.append(str2.toLowerCase());
            return sb2.toString();
        } else {
            return "";
        }
    }

    private static String a(Context context) {
        try {
            return MiscUtils.md5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSignMd5Str exception: ");
            sb.append(e);
            GriverLogger.e("GriverSignatureUtils", sb.toString());
            return null;
        }
    }
}

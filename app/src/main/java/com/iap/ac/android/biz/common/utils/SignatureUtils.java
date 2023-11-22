package com.iap.ac.android.biz.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.MiscUtils;

/* loaded from: classes8.dex */
public class SignatureUtils {
    public static String getAuthCodeForSecurityGuard(Context context, String str, String str2, String str3) {
        String str4;
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        if (commonConfig == null || (str4 = commonConfig.authCode) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if ("PROD".equals(str2) && !TextUtils.isEmpty(str3) && TextUtils.equals(str3, getSignMd5Str(context))) {
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
        return str4;
    }

    public static String getSignMd5Str(Context context) {
        try {
            return MiscUtils.md5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getSignMd5Str exception: ");
            sb.append(e);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }
}

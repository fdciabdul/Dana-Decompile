package com.iap.ac.android.rpc.utils;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.iap.ac.android.rpc.constant.BodyFields;

/* loaded from: classes3.dex */
public class RpcUtils {
    public static String formatForUrlEncode(String str, String str2, String str3, String str4, String str5) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("operationType", str);
        builder.appendQueryParameter("requestData", str2);
        builder.appendQueryParameter("ts", str3);
        if (!TextUtils.isEmpty(str5)) {
            builder.appendQueryParameter(BodyFields.SIGN_V2, str5);
        } else if (!TextUtils.isEmpty(str4)) {
            builder.appendQueryParameter("sign", str4);
        }
        String obj = builder.toString();
        return obj.startsWith("?") ? obj.substring(1) : obj;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rpc-");
        sb.append(str);
        return sb.toString();
    }
}

package com.iap.ac.android.instance.a;

import android.content.Context;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public class b {
    public static String a(Context context) {
        try {
            String string = context.getSharedPreferences("acInstanceInfo", 0).getString("iapInstanceId", "");
            StringBuilder sb = new StringBuilder();
            sb.append("Get instance id from sharedPreferences, instance id: ");
            sb.append(string);
            ACLog.d("com.iap.ac.android.instance.a.b", sb.toString());
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }
}

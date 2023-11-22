package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class FCMPushHelper {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        context.getSharedPreferences("mipush_extra", 0).edit().putString("fcm_sender_id", str).apply();
    }

    public static void MyBillsEntityDataFactory(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putBoolean("is_xmsf_sup_decrypt", ((long) com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2(context)) >= 50002000).apply();
    }
}

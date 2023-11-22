package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.dq;
import com.xiaomi.push.dv;
import com.xiaomi.push.ee;
import com.xiaomi.push.ej;

/* loaded from: classes8.dex */
public class m {
    public static dv BuiltInFictitiousFunctionClassFactory(dq dqVar) {
        byte[] m314a = dqVar.m314a();
        dv dvVar = new dv();
        try {
            ee.BuiltInFictitiousFunctionClassFactory(dvVar, m314a);
            return dvVar;
        } catch (ej unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] authRequestContext = getAuthRequestContext(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (authRequestContext != null) {
                ag.PlaceComponentResult(context, v.PlaceComponentResult(authRequestContext), authRequestContext);
            } else {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("notify fcm notification error ", th);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    private static byte[] getAuthRequestContext(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("secret is empty, return null");
            return null;
        }
        try {
            return com.xiaomi.channel.commonutils.android.b.BuiltInFictitiousFunctionClassFactory(com.xiaomi.push.aa.BuiltInFictitiousFunctionClassFactory(str), bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("dencryption error. ", e);
            return null;
        }
    }
}

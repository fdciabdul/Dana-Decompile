package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessaging;
import com.xiaomi.push.dq;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class g {
    private static HashMap<String, String> getAuthRequestContext = new HashMap<>();

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        d.MyBillsEntityDataFactory(context).PlaceComponentResult();
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        String str2;
        synchronized (g.class) {
            str2 = getAuthRequestContext.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        j.KClassImpl$Data$declaredNonStaticMembers$2();
        return true;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(dq dqVar, c cVar) {
        if (dqVar == null || dqVar.m308a() == null || dqVar.m308a().m278a() == null) {
            return false;
        }
        return (cVar == c.ASSEMBLE_PUSH_FCM ? FirebaseMessaging.INSTANCE_ID_SCOPE : "").equalsIgnoreCase(dqVar.m308a().m278a().get("assemble_push_type"));
    }

    private static boolean MyBillsEntityDataFactory(c cVar) {
        return cVar == c.ASSEMBLE_PUSH_FTOS || cVar == c.ASSEMBLE_PUSH_FCM;
    }

    private static String getAuthRequestContext(c cVar) {
        int i = i.getAuthRequestContext[cVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    public static void getAuthRequestContext(Context context) {
        d.MyBillsEntityDataFactory(context).BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r9 != 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> getAuthRequestContext(android.content.Context r13, com.xiaomi.mipush.sdk.c r14) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.getAuthRequestContext(android.content.Context, com.xiaomi.mipush.sdk.c):java.util.HashMap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String authRequestContext = getAuthRequestContext(c.ASSEMBLE_PUSH_HUAWEI);
        String authRequestContext2 = getAuthRequestContext(c.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(authRequestContext, "")) && TextUtils.isEmpty(sharedPreferences.getString(authRequestContext2, ""))) {
            z = true;
        }
        if (z) {
            ag BuiltInFictitiousFunctionClassFactory = ag.BuiltInFictitiousFunctionClassFactory(context);
            Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() || "com.xiaomi.xmsf".equals(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2() : BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            KClassImpl$Data$declaredNonStaticMembers$2.setAction("com.xiaomi.mipush.thirdparty");
            KClassImpl$Data$declaredNonStaticMembers$2.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", 2);
            KClassImpl$Data$declaredNonStaticMembers$2.putExtra("com.xiaomi.mipush.thirdparty_DESC", authRequestContext);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public static byte[] BuiltInFictitiousFunctionClassFactory(Context context, dq dqVar, c cVar) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(dqVar, cVar)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String authRequestContext = getAuthRequestContext(cVar);
            return com.xiaomi.push.ac.getAuthRequestContext(TextUtils.isEmpty(authRequestContext) ? null : sharedPreferences.getString(authRequestContext, ""));
        }
        return null;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, c cVar, String str) {
        com.xiaomi.push.o PlaceComponentResult = com.xiaomi.push.o.PlaceComponentResult(context);
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.schedule(new h(str, context, cVar), 0L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void PlaceComponentResult(Context context, c cVar, String str) {
        synchronized (g.class) {
            String authRequestContext = getAuthRequestContext(cVar);
            if (TextUtils.isEmpty(authRequestContext)) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            int i = 0;
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(authRequestContext, str).putString("last_check_token", a.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory.lookAheadTest);
            if (MyBillsEntityDataFactory(cVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append(getAuthRequestContext(cVar));
                sb.append("_version");
                String obj = sb.toString();
                Integer num = (Integer) com.xiaomi.push.z.MyBillsEntityDataFactory("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
                if (num != null) {
                    i = num.intValue();
                }
                edit.putInt(obj, i);
            }
            com.xiaomi.channel.commonutils.android.h.MyBillsEntityDataFactory(edit);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ASSEMBLE_PUSH : update sp file success!  ");
            sb2.append(str);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
    }
}

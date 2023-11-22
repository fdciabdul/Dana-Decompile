package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.cu;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dl;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.az;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class v {
    private static boolean BuiltInFictitiousFunctionClassFactory(dq dqVar) {
        return "com.xiaomi.xmsf".equals(dqVar.f229b) && dqVar.m308a() != null && dqVar.m308a().m278a() != null && dqVar.m308a().m278a().containsKey("miui_package_name");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(XMPushService xMPushService, com.xiaomi.push.bi biVar, az.b bVar) {
        try {
            PlaceComponentResult(xMPushService, biVar.KClassImpl$Data$declaredNonStaticMembers$2(bVar.isLayoutRequested), biVar.PlaceComponentResult());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return false;
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(dq dqVar) {
        if (dqVar.m308a() == null || dqVar.m308a().m278a() == null) {
            return false;
        }
        return "1".equals(dqVar.m308a().m278a().get("obslete_ads_message"));
    }

    public static dq MyBillsEntityDataFactory(Context context, dq dqVar) {
        return getAuthRequestContext(context, dqVar, null);
    }

    public static void MyBillsEntityDataFactory(Context context, boolean z, String str) {
        q KClassImpl$Data$declaredNonStaticMembers$2;
        if (z || (KClassImpl$Data$declaredNonStaticMembers$2 = r.KClassImpl$Data$declaredNonStaticMembers$2(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        r.MyBillsEntityDataFactory(context, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
    }

    public static dq PlaceComponentResult(byte[] bArr) {
        dq dqVar = new dq();
        try {
            ee.BuiltInFictitiousFunctionClassFactory(dqVar, bArr);
            return dqVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th);
            return null;
        }
    }

    private static boolean PlaceComponentResult(Context context, String str, byte[] bArr) {
        if (com.xiaomi.channel.commonutils.android.a.getAuthRequestContext(context, str)) {
            Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(str);
            try {
                if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                    return false;
                }
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("broadcast message arrived.");
                context.sendBroadcast(intent, ad.getAuthRequestContext(str));
                return true;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("meet error when broadcast message arrived. ");
                sb.append(e);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return false;
            }
        }
        return false;
    }

    private static boolean PlaceComponentResult(dq dqVar) {
        Map<String, String> m278a = dqVar.m308a().m278a();
        return m278a != null && m278a.containsKey("notify_effect");
    }

    public static dq getAuthRequestContext(Context context, dq dqVar, Map<String, String> map) {
        dl dlVar = new dl();
        dlVar.b(dqVar.m309a());
        di m308a = dqVar.m308a();
        if (m308a != null) {
            dlVar.a(m308a.m277a());
            dlVar.a(m308a.m275a());
            if (!TextUtils.isEmpty(m308a.m282b())) {
                dlVar.c(m308a.m282b());
            }
        }
        dlVar.a(ee.getAuthRequestContext(context, dqVar));
        dq BuiltInFictitiousFunctionClassFactory = ad.BuiltInFictitiousFunctionClassFactory(dqVar.b(), dqVar.m309a(), dlVar, cz.AckMessage);
        di m308a2 = dqVar.m308a();
        if (m308a2 != null) {
            m308a2 = bj.PlaceComponentResult(m308a2.m276a());
        }
        m308a2.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str : map.keySet()) {
                        m308a2.a(str, map.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        BuiltInFictitiousFunctionClassFactory.a(m308a2);
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static boolean getAuthRequestContext(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers;
        try {
            queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
        } catch (Exception unused) {
        }
        if (queryBroadcastReceivers != null) {
            if (!queryBroadcastReceivers.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean getAuthRequestContext(XMPushService xMPushService, String str, dq dqVar, di diVar) {
        boolean z = true;
        if (diVar != null && diVar.m278a() != null && diVar.m278a().containsKey("__check_alive") && diVar.m278a().containsKey("__awake")) {
            dt dtVar = new dt();
            dtVar.b(dqVar.m309a());
            dtVar.d(str);
            dtVar.c(df.AwakeSystemApp.f104a);
            dtVar.a(diVar.m277a());
            dtVar.f241a = new HashMap();
            boolean authRequestContext = com.xiaomi.channel.commonutils.android.a.getAuthRequestContext(xMPushService.getApplicationContext(), str);
            dtVar.f241a.put("app_running", Boolean.toString(authRequestContext));
            if (!authRequestContext) {
                boolean parseBoolean = Boolean.parseBoolean(diVar.m278a().get("__awake"));
                dtVar.f241a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ad.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService, ad.BuiltInFictitiousFunctionClassFactory(dqVar.b(), dqVar.m309a(), dtVar, cz.Notification));
            } catch (com.xiaomi.push.cd e) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:607:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x044c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void PlaceComponentResult(com.xiaomi.push.service.XMPushService r18, byte[] r19, long r20) {
        /*
            Method dump skipped, instructions count: 1270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.v.PlaceComponentResult(com.xiaomi.push.service.XMPushService, byte[], long):void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(XMPushService xMPushService, com.xiaomi.push.cj cjVar, az.b bVar) {
        byte[] KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(cjVar instanceof com.xiaomi.push.ci)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("not a mipush message");
            return;
        }
        com.xiaomi.push.ci ciVar = (com.xiaomi.push.ci) cjVar;
        com.xiaomi.push.cg KClassImpl$Data$declaredNonStaticMembers$22 = ciVar.KClassImpl$Data$declaredNonStaticMembers$2("s");
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = bh.KClassImpl$Data$declaredNonStaticMembers$2(bh.getAuthRequestContext(bVar.isLayoutRequested, ciVar.getAuthRequestContext()), com.xiaomi.push.aa.BuiltInFictitiousFunctionClassFactory(!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory) ? cu.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory) : KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory));
                PlaceComponentResult(xMPushService, KClassImpl$Data$declaredNonStaticMembers$2, cx.PlaceComponentResult(cjVar.MyBillsEntityDataFactory()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            }
        }
    }
}

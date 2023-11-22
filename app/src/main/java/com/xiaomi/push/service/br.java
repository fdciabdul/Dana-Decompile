package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class br {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, int i, String str2, Notification notification) {
        if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            getAuthRequestContext(context, str, i, str2, notification);
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        StringBuilder sb = new StringBuilder();
        sb.append("top notification' repeat is ");
        sb.append(parseBoolean);
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
        return parseBoolean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("n_top_update_");
        sb.append(i);
        sb.append("_");
        sb.append(str);
        return sb.toString();
    }

    private static Notification getAuthRequestContext(Notification notification, int i, String str, aq aqVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString(Constants.MessagePayloadKeys.MSGID_SERVER))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> MyBillsEntityDataFactory = aqVar.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory != null) {
            for (StatusBarNotification statusBarNotification : MyBillsEntityDataFactory) {
                Notification notification2 = statusBarNotification.getNotification();
                String string = notification2.extras.getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                if (i == statusBarNotification.getId() && str.equals(string)) {
                    return notification2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Context context, Map<String, String> map, com.xiaomi.push.ay ayVar, long j) {
        if (map == null || ayVar == null || !com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) || !BuiltInFictitiousFunctionClassFactory(map)) {
            return;
        }
        int max = Math.max(0, com.xiaomi.channel.commonutils.android.k.KClassImpl$Data$declaredNonStaticMembers$2(map.get("notification_top_period"), 0));
        int max2 = Math.max(0, com.xiaomi.channel.commonutils.android.k.KClassImpl$Data$declaredNonStaticMembers$2(map.get("notification_top_frequency"), 0));
        if (max <= 0 || max2 > max) {
            StringBuilder sb = new StringBuilder();
            sb.append("set top notification failed - period:");
            sb.append(max);
            sb.append(" frequency:");
            sb.append(max2);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            return;
        }
        ayVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (max2 > 0) {
            bundle.putInt("mipush_n_top_fre", max2);
        }
        bundle.putInt("mipush_n_top_prd", max);
        ayVar.MyBillsEntityDataFactory(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAuthRequestContext(Context context, String str, int i, String str2, Notification notification) {
        aq PlaceComponentResult;
        Notification authRequestContext;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (authRequestContext = getAuthRequestContext(notification, i, str2, (PlaceComponentResult = aq.PlaceComponentResult(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (authRequestContext.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.z.KClassImpl$Data$declaredNonStaticMembers$2((Object) authRequestContext, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = authRequestContext.extras.getLong("mipush_org_when", 0L);
        int i2 = authRequestContext.extras.getInt("mipush_n_top_fre", 0);
        int i3 = authRequestContext.extras.getInt("mipush_n_top_prd", 0);
        if (i3 <= 0 || i3 < i2) {
            return;
        }
        long j2 = (i3 * 1000) + j;
        int min = (j >= currentTimeMillis || currentTimeMillis >= j2) ? 0 : i2 > 0 ? (int) Math.min((j2 - currentTimeMillis) / 1000, i2) : i3;
        if (!z) {
            if (min > 0) {
                authRequestContext.when = currentTimeMillis;
                StringBuilder sb = new StringBuilder();
                sb.append("update top notification: ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i, authRequestContext);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, authRequestContext);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("update top notification to common: ");
                sb2.append(str2);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i, recoverBuilder.build());
            }
        }
        if (min > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("schedule top notification next update delay: ");
            sb3.append(min);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
            com.xiaomi.push.o.PlaceComponentResult(context).MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2(i, str2));
            com.xiaomi.push.o.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory(new bs(i, str2, context, str), min);
        }
    }
}

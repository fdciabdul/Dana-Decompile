package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.db;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class an {
    private static an MyBillsEntityDataFactory = new an();

    /* loaded from: classes8.dex */
    public class a {
        List<b> KClassImpl$Data$declaredNonStaticMembers$2;
        List<b> PlaceComponentResult;

        private a() {
            an.this = r1;
            this.PlaceComponentResult = new ArrayList();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        }

        public /* synthetic */ a(an anVar, byte b) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        Notification BuiltInFictitiousFunctionClassFactory;
        int PlaceComponentResult;

        public b(int i, Notification notification) {
            an.this = r1;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = notification;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("id:");
            sb.append(this.PlaceComponentResult);
            return sb.toString();
        }
    }

    private an() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("group show summary group is null");
                return;
            }
            int MyBillsEntityDataFactory2 = ar.MyBillsEntityDataFactory(context, str);
            if (MyBillsEntityDataFactory2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("group show summary not get icon from ");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return;
            }
            aq PlaceComponentResult = aq.PlaceComponentResult(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String authRequestContext = aq.getAuthRequestContext(notification.getChannelId(), "groupSummary");
                NotificationChannel KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
                if ("groupSummary".equals(authRequestContext) && KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    PlaceComponentResult.getAuthRequestContext(new NotificationChannel(authRequestContext, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, authRequestContext);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ar.PlaceComponentResult(defaults, true);
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, MyBillsEntityDataFactory2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!com.xiaomi.channel.commonutils.android.f.MyBillsEntityDataFactory() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ar.KClassImpl$Data$declaredNonStaticMembers$2(build, str);
            }
            int PlaceComponentResult2 = PlaceComponentResult(str, str2);
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, build);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("group show summary notify:");
            sb2.append(PlaceComponentResult2);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb2.toString());
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("group show summary error ");
            sb3.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Notification notification) {
        if (notification != null) {
            Object authRequestContext = com.xiaomi.push.z.getAuthRequestContext(notification, "isGroupSummary", (Object[]) null);
            if (authRequestContext instanceof Boolean) {
                return ((Boolean) authRequestContext).booleanValue();
            }
            return false;
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(Context context) {
        return at.MyBillsEntityDataFactory(context).MyBillsEntityDataFactory(db.NotificationAutoGroupSwitch.a());
    }

    public static int PlaceComponentResult(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupSummary");
        sb.append(str);
        sb.append(str2);
        return sb.toString().hashCode();
    }

    public static an PlaceComponentResult() {
        return MyBillsEntityDataFactory;
    }

    public static String getAuthRequestContext(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    public static List<StatusBarNotification> getAuthRequestContext(aq aqVar) {
        List<StatusBarNotification> MyBillsEntityDataFactory2 = aqVar != null ? aqVar.MyBillsEntityDataFactory() : null;
        if (MyBillsEntityDataFactory2 == null || MyBillsEntityDataFactory2.size() == 0) {
            return null;
        }
        return MyBillsEntityDataFactory2;
    }

    public static boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean getAuthRequestContext(Context context) {
        if (MyBillsEntityDataFactory(context)) {
            aq.getAuthRequestContext(context);
            return false;
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(notification.extras.getLong("push_src_group_time")), (notification == null || notification.extras == null) ? null : notification.extras.getString("push_src_group_name")));
    }
}

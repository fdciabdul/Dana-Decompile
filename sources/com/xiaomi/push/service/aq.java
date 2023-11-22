package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.db;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes8.dex */
public class aq {
    private static Context KClassImpl$Data$declaredNonStaticMembers$2;
    private static WeakHashMap<Integer, aq> PlaceComponentResult = new WeakHashMap<>();
    private static Object getAuthRequestContext;
    private static boolean moveToNextValue;
    String BuiltInFictitiousFunctionClassFactory;
    String MyBillsEntityDataFactory;

    private aq(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    private static int BuiltInFictitiousFunctionClassFactory(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public static Context BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private static Object BuiltInFictitiousFunctionClassFactory(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() && at.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(db.NotificationBelongToAppSwitch.a())) {
            return moveToNextValue;
        }
        return false;
    }

    public static aq PlaceComponentResult(Context context, String str) {
        PlaceComponentResult(context);
        int hashCode = str.hashCode();
        aq aqVar = PlaceComponentResult.get(Integer.valueOf(hashCode));
        if (aqVar == null) {
            aq aqVar2 = new aq(str);
            PlaceComponentResult.put(Integer.valueOf(hashCode), aqVar2);
            return aqVar2;
        }
        return aqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(String str, String str2) {
        return !KClassImpl$Data$declaredNonStaticMembers$2() ? str2 : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    public static boolean getAuthRequestContext(Context context) {
        PlaceComponentResult(context);
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificationManagerHelper{");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("}");
        return sb.toString();
    }

    public static String MyBillsEntityDataFactory(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String format = TextUtils.isEmpty("mipush|%s|%s") ? "" : String.format("mipush|%s|%s", str2, "");
        if (str.startsWith(format)) {
            return TextUtils.isEmpty("mipush_%s_%s") ? "" : String.format("mipush_%s_%s", str2, str.replace(format, ""));
        }
        return str;
    }

    private static void PlaceComponentResult(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Context applicationContext = context.getApplicationContext();
            KClassImpl$Data$declaredNonStaticMembers$2 = applicationContext;
            NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
            Boolean bool = (Boolean) com.xiaomi.push.z.getAuthRequestContext(notificationManager, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            StringBuilder sb = new StringBuilder();
            sb.append("fwk is support.init:");
            sb.append(bool);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NMHelper:");
            sb2.append(obj);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            moveToNextValue = booleanValue;
            if (booleanValue) {
                getAuthRequestContext = com.xiaomi.push.z.getAuthRequestContext(notificationManager, "getService", new Object[0]);
            }
        }
    }

    private static StatusBarNotification[] getAuthRequestContext() {
        if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2)) {
            try {
                Object authRequestContext = com.xiaomi.push.z.getAuthRequestContext(getAuthRequestContext, "getActiveNotifications", KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
                if (authRequestContext instanceof StatusBarNotification[]) {
                    return (StatusBarNotification[]) authRequestContext;
                }
                return null;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAllNotifications error ");
                sb.append(th);
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NMHelper:");
                sb2.append(obj);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                return null;
            }
        }
        return null;
    }

    public final NotificationChannel KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                List<NotificationChannel> PlaceComponentResult2 = PlaceComponentResult();
                if (PlaceComponentResult2 != null) {
                    for (NotificationChannel notificationChannel2 : PlaceComponentResult2) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = ((NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification")).getNotificationChannel(str);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNotificationChannel error");
            sb.append(e);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NMHelper:");
            sb2.append(obj);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
        return notificationChannel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<NotificationChannel> PlaceComponentResult() {
        String str;
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        List<NotificationChannel> list = null;
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str2);
                if (BuiltInFictitiousFunctionClassFactory != -1) {
                    Object obj = getAuthRequestContext;
                    Object[] objArr = {str2, Integer.valueOf(BuiltInFictitiousFunctionClassFactory), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    list = (List) KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.z.getAuthRequestContext(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = ((NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification")).getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String format = TextUtils.isEmpty(str) ? "" : String.format(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(format)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getNotificationChannels error ");
            sb.append(e);
            String obj2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NMHelper:");
            sb2.append(obj2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return list;
        }
    }

    public final void getAuthRequestContext(int i) {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                int KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.channel.commonutils.android.c.KClassImpl$Data$declaredNonStaticMembers$2();
                String packageName = KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.z.MyBillsEntityDataFactory(getAuthRequestContext, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22));
                } else {
                    com.xiaomi.push.z.MyBillsEntityDataFactory(getAuthRequestContext, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cancel succ:");
                sb.append(i);
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NMHelper:");
                sb2.append(obj);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                return;
            }
            ((NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification")).cancel(i);
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("cancel error");
            sb3.append(e);
            String obj2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("NMHelper:");
            sb4.append(obj2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb4.toString());
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Notification notification) {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        NotificationManager notificationManager = (NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification");
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    notificationManager.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            notificationManager.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(NotificationChannel notificationChannel) {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        try {
            if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
                ((NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification")).createNotificationChannel(notificationChannel);
                return;
            }
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                com.xiaomi.push.z.MyBillsEntityDataFactory(getAuthRequestContext, "createNotificationChannelsForPackage", str, Integer.valueOf(BuiltInFictitiousFunctionClassFactory), BuiltInFictitiousFunctionClassFactory(Arrays.asList(notificationChannel)));
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("createNotificationChannel error");
            sb.append(e);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NMHelper:");
            sb2.append(obj);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NotificationChannel notificationChannel, boolean z) {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        try {
            if (!z) {
                getAuthRequestContext(notificationChannel);
                return;
            }
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                com.xiaomi.push.z.MyBillsEntityDataFactory(getAuthRequestContext, "updateNotificationChannelForPackage", str, Integer.valueOf(BuiltInFictitiousFunctionClassFactory), notificationChannel);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateNotificationChannel error ");
            sb.append(e);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NMHelper:");
            sb2.append(obj);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
    }

    public final boolean PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = KClassImpl$Data$declaredNonStaticMembers$2() ? "mipush|%s|%s" : "mipush_%s_%s";
        return str.startsWith(TextUtils.isEmpty(str2) ? "" : String.format(str2, this.BuiltInFictitiousFunctionClassFactory, ""));
    }

    public final List<StatusBarNotification> MyBillsEntityDataFactory() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        NotificationManager notificationManager = (NotificationManager) KClassImpl$Data$declaredNonStaticMembers$2.getSystemService("notification");
        ArrayList arrayList = null;
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                int KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.channel.commonutils.android.c.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$22 != -1) {
                    return (List) KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.z.getAuthRequestContext(getAuthRequestContext, "getAppActiveNotifications", str, Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22)));
                }
                return null;
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? notificationManager.getActiveNotifications() : getAuthRequestContext();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (str.equals(ar.KClassImpl$Data$declaredNonStaticMembers$2(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                StringBuilder sb = new StringBuilder();
                sb.append("getActiveNotifications error ");
                sb.append(th);
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NMHelper:");
                sb2.append(obj);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

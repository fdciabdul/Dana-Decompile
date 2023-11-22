package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.push.service.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e {
    private static final int[] MyBillsEntityDataFactory = {1, 2, 4, 8, 16};
    private static final SparseArray<ar.a<String, String, String>> PlaceComponentResult = new f();
    private static final SparseArray<Integer> getAuthRequestContext = new g();

    e() {
    }

    private static void BuiltInFictitiousFunctionClassFactory(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.commit();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, String str2, int i) {
        Context context;
        context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
        boolean z = ar.MyBillsEntityDataFactory(context, str, str2, PlaceComponentResult.get(i)) == 1;
        StringBuilder sb = new StringBuilder();
        sb.append("ChannelPermissions.checkPermission:");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        sb.append(": <");
        sb.append(i);
        sb.append("=");
        sb.append(z);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, int i, int i2) {
        for (int i3 : MyBillsEntityDataFactory) {
            if ((getAuthRequestContext.get(i3).intValue() & i2) == 0) {
                KClassImpl$Data$declaredNonStaticMembers$2(str, str2, i3, (i & i3) > 0);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("ChannelPermissions.grantPermission:");
                sb.append(str);
                sb.append(":");
                sb.append(str2);
                sb.append(": <");
                sb.append(i3);
                sb.append("> :stoped by userLock");
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            }
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, int i, boolean z) {
        Context context;
        context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
        boolean MyBillsEntityDataFactory2 = ar.MyBillsEntityDataFactory(context, str, str2, PlaceComponentResult.get(i), z);
        StringBuilder sb = new StringBuilder();
        sb.append("ChannelPermissions.grantPermission:");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        sb.append(": <");
        sb.append(i);
        sb.append("=");
        sb.append(z);
        sb.append("> :");
        sb.append(MyBillsEntityDataFactory2);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int MyBillsEntityDataFactory(String str, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory(str, str2, 8) ? 8 : 0;
        if (BuiltInFictitiousFunctionClassFactory(str, str2, 16)) {
            i |= 16;
        }
        if (BuiltInFictitiousFunctionClassFactory(str, str2, 1)) {
            i |= 1;
        }
        if (BuiltInFictitiousFunctionClassFactory(str, str2, 2)) {
            i |= 2;
        }
        return BuiltInFictitiousFunctionClassFactory(str, str2, 4) ? i | 4 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Context context, String str) {
        List<NotificationChannel> PlaceComponentResult2;
        if (!com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) || TextUtils.isEmpty(str) || (PlaceComponentResult2 = aq.PlaceComponentResult(context, str).PlaceComponentResult()) == null) {
            return;
        }
        synchronized (e.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ch_permission_cache_file", 0);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = PlaceComponentResult2.iterator();
            while (it.hasNext()) {
                String str2 = (String) com.xiaomi.push.z.PlaceComponentResult(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && sharedPreferences.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                BuiltInFictitiousFunctionClassFactory(sharedPreferences, arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        if (!com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ChannelPC: can`t setup permission with permissionCode:");
                sb.append(String.valueOf(str3));
                sb.append(" channelId:");
                sb.append(String.valueOf(str2));
                sb.append(" targetPkg:");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return;
            }
            return;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = com.xiaomi.channel.commonutils.android.k.KClassImpl$Data$declaredNonStaticMembers$2(str3, 0);
        boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i, KClassImpl$Data$declaredNonStaticMembers$2);
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(str, str2, KClassImpl$Data$declaredNonStaticMembers$2, i2);
            if (BuiltInFictitiousFunctionClassFactory) {
                synchronized (e.class) {
                    context.getSharedPreferences("ch_permission_cache_file", 0).edit().putInt(str2, KClassImpl$Data$declaredNonStaticMembers$2).commit();
                }
                return;
            }
            return;
        }
        synchronized (e.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ch_permission_cache_file", 0);
            if (BuiltInFictitiousFunctionClassFactory || sharedPreferences.contains(str2)) {
                if (sharedPreferences.getInt(str2, 0) != KClassImpl$Data$declaredNonStaticMembers$2) {
                    KClassImpl$Data$declaredNonStaticMembers$2(str, str2, KClassImpl$Data$declaredNonStaticMembers$2, i2);
                }
                if (BuiltInFictitiousFunctionClassFactory) {
                    sharedPreferences.edit().putInt(str2, KClassImpl$Data$declaredNonStaticMembers$2).commit();
                } else {
                    BuiltInFictitiousFunctionClassFactory(sharedPreferences, new h(str2));
                }
            }
        }
    }
}

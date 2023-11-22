package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class d {
    private static List<a> MyBillsEntityDataFactory = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    static class a {
        public final Notification.Action[] BuiltInFictitiousFunctionClassFactory;
        public final String KClassImpl$Data$declaredNonStaticMembers$2;
        public final int MyBillsEntityDataFactory;
        public final long PlaceComponentResult;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.PlaceComponentResult = j;
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = actionArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void BuiltInFictitiousFunctionClassFactory(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context) || i <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        MyBillsEntityDataFactory.add(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ar.MyBillsEntityDataFactory(statusBarNotification.getNotification())));
        for (int size = MyBillsEntityDataFactory.size() - 1; size >= 0; size--) {
            a aVar = MyBillsEntityDataFactory.get(size);
            if (SystemClock.elapsedRealtime() - aVar.PlaceComponentResult > RangedBeacon.DEFAULT_MAX_TRACKING_AGE) {
                MyBillsEntityDataFactory.remove(aVar);
            }
        }
        if (MyBillsEntityDataFactory.size() > 10) {
            MyBillsEntityDataFactory.remove(0);
        }
    }
}

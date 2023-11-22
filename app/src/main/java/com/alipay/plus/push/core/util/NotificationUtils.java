package com.alipay.plus.push.core.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* loaded from: classes7.dex */
public class NotificationUtils {
    public static void showNotification(Context context, String str, String str2, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) context.getSystemService("notification")).notify(1, new NotificationCompat.Builder(context, "chat").getAuthRequestContext(str).MyBillsEntityDataFactory(str2).KClassImpl$Data$declaredNonStaticMembers$2(System.currentTimeMillis()).getAuthRequestContext(i).BuiltInFictitiousFunctionClassFactory(BitmapFactory.decodeResource(context.getResources(), i2)).BuiltInFictitiousFunctionClassFactory(true).BuiltInFictitiousFunctionClassFactory());
        }
    }

    public static void initNotification(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel(context, "chat", "chat", 4);
            createNotificationChannel(context, "subscribe", "subscribe", 3);
        }
    }

    private static void createNotificationChannel(Context context, String str, String str2, int i) {
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(new NotificationChannel(str, str2, i));
    }
}

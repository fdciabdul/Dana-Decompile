package com.xiaomi.channel.commonutils.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes8.dex */
public class g {
    private static volatile Handler BuiltInFictitiousFunctionClassFactory;
    private static final Object MyBillsEntityDataFactory = new Object();

    public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (broadcastReceiver != null) {
            return Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i) : context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
        return null;
    }

    public static Handler getAuthRequestContext() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (MyBillsEntityDataFactory) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    BuiltInFictitiousFunctionClassFactory = new Handler(handlerThread.getLooper());
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }
}

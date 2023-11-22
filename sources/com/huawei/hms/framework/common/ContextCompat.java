package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;

/* loaded from: classes7.dex */
public class ContextCompat {
    public static boolean checkSelfPermission(Context context, String str) {
        if (context == null || str == null) {
            Logger.w("ContextCompat", "param is null");
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
            return false;
        }
    }

    public static Context getProtectedStorageContext(Context context) {
        if (context != null) {
            return Build.VERSION.SDK_INT < 24 ? context : context.createDeviceProtectedStorageContext();
        }
        Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
        return null;
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context == null) {
            Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (context == null) {
            Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return null;
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", e);
            return null;
        }
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null) {
            Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "SystemServer error:", e);
        }
    }

    public static ComponentName startService(Context context, Intent intent) {
        if (context == null) {
            Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return null;
        }
        try {
            return context.startService(intent);
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "SystemServer error:", e);
            return null;
        }
    }

    public static Object getSystemService(Context context, String str) {
        if (context == null) {
            Logger.w("ContextCompat", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e) {
            Logger.e("ContextCompat", "SystemServer error:", e);
            return null;
        }
    }
}

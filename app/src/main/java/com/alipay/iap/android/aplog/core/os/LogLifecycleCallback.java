package com.alipay.iap.android.aplog.core.os;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.api.LogEventType;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.log.behavior.AliveReportLog;
import com.alipay.iap.android.aplog.log.behavior.AutoBehaviourLog;
import com.alipay.iap.android.aplog.util.ReflectUtil;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LogLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    private static long LAST_RECORD_TIME = 0;
    public static final String TAG = "LogLifecycleCallback";
    public static boolean isBackground;
    private static int sAlive;
    private static int sForeground;
    private static int sVisible;
    private HashMap<String, AutoBehaviourLog> currentLogs = new HashMap<>();
    public static final byte[] PlaceComponentResult = {111, -54, 77, -36, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 157;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public LogLifecycleCallback(Context context) {
        try {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.alipay.iap.android.aplog.core.os.LogLifecycleCallback.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        LogLifecycleCallback.this.setForeground(false);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(broadcastReceiver, intentFilter, 2);
            } else {
                context.registerReceiver(broadcastReceiver, intentFilter);
            }
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn("LoggingLifecycleCallback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForeground(boolean z) {
        try {
            ReflectUtil.invokeMethod("com.alipay.iap.android.aplog.core.logger.NativeCrashHandlerApi", "setForeground", new Class[]{Boolean.TYPE}, null, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().error(TAG, TextUtils.isEmpty(e.getMessage()) ? "reflect setForeground fail" : e.getMessage());
        }
    }

    public static boolean isOverAliveInterval() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - LAST_RECORD_TIME > LoggerFactory.getLogContext().getLogAliveInterval()) {
            LAST_RECORD_TIME = currentTimeMillis;
            return true;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        sAlive++;
        setForeground(true);
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getName());
        sb.append(" onActivityCreated ");
        traceLogger.debug(TAG, sb.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        sVisible++;
        setForeground(true);
        if (sVisible > 0) {
            isBackground = false;
            onAppInForeground(activity);
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getPackageName());
            sb.append(" go to foreground");
            traceLogger.debug(TAG, sb.toString());
        }
        if (activity == null || !shouldLog(activity.getClass().getName())) {
            return;
        }
        AutoBehaviourLog autoBehaviourLog = new AutoBehaviourLog(activity);
        autoBehaviourLog.setSeedID(activity.getClass().getName());
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("put activity: ");
        sb2.append(activity.getClass().getName());
        traceLogger2.debug(TAG, sb2.toString());
        this.currentLogs.put(activity.getClass().getName(), autoBehaviourLog);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        sForeground++;
        setForeground(true);
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getName());
        sb.append(" onActivityResumed ");
        traceLogger.debug(TAG, sb.toString());
        if (isOverAliveInterval()) {
            LoggerFactory.getLogContext().appendLog(new AliveReportLog());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        sForeground--;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        AutoBehaviourLog remove;
        sVisible--;
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getName());
        sb.append(" onActivityStopped ");
        traceLogger.debug(TAG, sb.toString());
        if (sVisible <= 0) {
            isBackground = true;
            onAppInBackground(activity);
            setForeground(false);
            LoggerFactory.getLogContext().notifyClientEvent(LogEventType.ENVENT_GOTOBACKGROUND, null);
            TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(activity.getPackageName());
            sb2.append(" go back to background ");
            traceLogger2.debug(TAG, sb2.toString());
        }
        if (activity == null || !shouldLog(activity.getClass().getName()) || (remove = this.currentLogs.remove(activity.getClass().getName())) == null) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(System.currentTimeMillis());
        remove.setEndTime(sb3.toString());
        TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("remove  activity: ");
        sb4.append(activity.getClass().getName());
        traceLogger3.debug(TAG, sb4.toString());
        LoggerFactory.getLogContext().appendLog(remove);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        int i = sAlive - 1;
        sAlive = i;
        if (i <= 0) {
            try {
                ReflectUtil.invokeMethod("com.alipay.iap.android.aplog.core.logger.NativeCrashHandlerApi", "onExit", null, null, null);
            } catch (Exception e) {
                LoggerFactory.getTraceLogger().error(TAG, TextUtils.isEmpty(e.getMessage()) ? "reflect onExit fail" : e.getMessage());
            }
        }
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getName());
        sb.append(" onActivityDestroyed ");
        traceLogger.debug(TAG, sb.toString());
    }

    private boolean shouldLog(String str) {
        if (LoggerFactory.getLogContext().getAutoLogActivities() == null || LoggerFactory.getLogContext().getAutoLogActivities().size() <= 0) {
            return false;
        }
        Iterator<String> it = LoggerFactory.getLogContext().getAutoLogActivities().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void onAppInBackground(Context context) {
        try {
            ReflectUtil.invokeMethod("com.alipay.iap.android.aplog.monitor.ANRBinder", "stopAnrWatch", null, null, null);
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().error(TAG, TextUtils.isEmpty(e.getMessage()) ? "stopAnrWatch error" : e.getMessage());
        }
        LoggerFactory.getLogContext().flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0064 -> B:20:0x0069). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onAppInForeground(android.content.Context r13) {
        /*
            r12 = this;
            com.alipay.iap.android.aplog.core.filter.StrategyManager r0 = com.alipay.iap.android.aplog.core.filter.StrategyManager.getInstance()
            boolean r0 = r0.isPerformanceLogEnable()
            if (r0 == 0) goto L71
            r0 = 1
            java.lang.Class[] r1 = new java.lang.Class[r0]
            byte[] r2 = com.alipay.iap.android.aplog.core.os.LogLifecycleCallback.PlaceComponentResult
            r3 = 23
            byte[] r3 = new byte[r3]
            r4 = 3
            r5 = 97
            r6 = 0
            if (r2 != 0) goto L21
            r5 = r3
            r7 = 3
            r8 = 97
            r9 = 0
            r3 = r2
            r2 = r1
            goto L69
        L21:
            r4 = r3
            r7 = 3
            r8 = 0
            r3 = r2
            r2 = r1
        L26:
            byte r9 = (byte) r5
            r4[r8] = r9
            int r7 = r7 + r0
            int r9 = r8 + 1
            r10 = 22
            if (r8 != r10) goto L64
            java.lang.String r3 = new java.lang.String
            r3.<init>(r4, r6)
            java.lang.Class r3 = java.lang.Class.forName(r3)
            r1[r6] = r3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r6] = r13
            java.lang.String r13 = "com.alipay.iap.android.aplog.monitor.ANRBinder"
            java.lang.String r1 = "startAnrWatch"
            r3 = 0
            com.alipay.iap.android.aplog.util.ReflectUtil.invokeMethod(r13, r1, r2, r3, r0)     // Catch: java.lang.Exception -> L48
            return
        L48:
            r13 = move-exception
            com.alipay.iap.android.aplog.core.logger.TraceLogger r0 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()
            java.lang.String r1 = r13.getMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L5a
            java.lang.String r13 = "startAnrWatch error"
            goto L5e
        L5a:
            java.lang.String r13 = r13.getMessage()
        L5e:
            java.lang.String r1 = "LogLifecycleCallback"
            r0.error(r1, r13)
            goto L71
        L64:
            r8 = r3[r7]
            r11 = r5
            r5 = r4
            r4 = r11
        L69:
            int r4 = r4 + r8
            int r4 = r4 + (-8)
            r8 = r9
            r11 = r5
            r5 = r4
            r4 = r11
            goto L26
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.os.LogLifecycleCallback.onAppInForeground(android.content.Context):void");
    }
}

package com.iap.ac.android.loglite.core;

import android.text.TextUtils;
import android.util.Log;
import com.iap.ac.android.loglite.log.CrashLog;
import com.iap.ac.android.loglite.storage.AnalyticsStorage;
import com.iap.ac.android.loglite.storage.AnalyticsStorageManager;
import com.iap.ac.android.loglite.storage.AsyncFileStorage;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CrashReporter implements Thread.UncaughtExceptionHandler {
    public static CrashReporter c;

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f7590a;
    public boolean b = false;

    public static void a() {
        synchronized (CrashReporter.class) {
            if (c == null) {
                c = new CrashReporter();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z;
        Set<String> set = AnalyticsContext.getInstance().i;
        if (!set.isEmpty()) {
            Iterator<String> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                String stackTraceString = Log.getStackTraceString(th);
                if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.contains(next)) {
                    String replaceAll = stackTraceString.replaceAll("\n", "###");
                    HashMap hashMap = new HashMap();
                    hashMap.put("stackTrace", replaceAll);
                    hashMap.put("threadName", thread.getName());
                    AnalyticsContext.getInstance().getStorageManager().a(new CrashLog("crash", hashMap), null);
                    break;
                }
            }
        }
        AnalyticsStorageManager storageManager = AnalyticsContext.getInstance().getStorageManager();
        int i = 0;
        while (true) {
            Iterator<AnalyticsStorage> it2 = storageManager.f7596a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                AnalyticsStorage next2 = it2.next();
                if ((next2 instanceof AsyncFileStorage) && !((AsyncFileStorage) next2).h.getQueue().isEmpty()) {
                    z = false;
                    break;
                }
            }
            if (z || i >= 10) {
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7590a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

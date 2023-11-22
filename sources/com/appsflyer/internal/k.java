package com.appsflyer.internal;

import android.net.TrafficStats;
import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {
    public static k valueOf;
    ScheduledExecutorService AFInAppEventParameterName;
    final ThreadFactory AFInAppEventType = new ThreadFactory() { // from class: com.appsflyer.internal.k.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.appsflyer.internal.k.1.5
                @Override // java.lang.Runnable
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };
    Executor AFKeystoreWrapper;
    ScheduledExecutorService values;

    public final Executor valueOf() {
        Executor executor = this.AFKeystoreWrapper;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.AFKeystoreWrapper).isTerminated() || ((ThreadPoolExecutor) this.AFKeystoreWrapper).isTerminating()))) {
            this.AFKeystoreWrapper = Executors.newFixedThreadPool(2, this.AFInAppEventType);
        }
        return this.AFKeystoreWrapper;
    }

    public final ScheduledThreadPoolExecutor AFInAppEventParameterName() {
        ScheduledExecutorService scheduledExecutorService = this.values;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.values.isTerminated()) {
            this.values = Executors.newScheduledThreadPool(2, this.AFInAppEventType);
        }
        return (ScheduledThreadPoolExecutor) this.values;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void AFKeystoreWrapper(ExecutorService executorService) {
        try {
            try {
                AFLogger.AFInAppEventParameterName("shut downing executor ...");
                executorService.shutdown();
                executorService.awaitTermination(10L, TimeUnit.SECONDS);
                if (!executorService.isTerminated()) {
                    AFLogger.AFInAppEventParameterName("killing non-finished tasks");
                }
                executorService.shutdownNow();
            } catch (InterruptedException unused) {
                AFLogger.AFInAppEventParameterName("InterruptedException!!!");
                if (!executorService.isTerminated()) {
                    AFLogger.AFInAppEventParameterName("killing non-finished tasks");
                }
                executorService.shutdownNow();
            }
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.AFInAppEventParameterName("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}

package com.alipay.iap.android.aplog.util;

import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import java.util.Timer;

/* loaded from: classes3.dex */
public class APMTimer {
    private static APMTimer INSTANCE = null;
    private static final String TAG = "APMTimer";
    private Timer mWorkTimer;

    public static APMTimer getInstance() {
        if (INSTANCE == null) {
            synchronized (APMTimer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new APMTimer();
                }
            }
        }
        return INSTANCE;
    }

    private APMTimer() {
    }

    /* loaded from: classes3.dex */
    class HandlerJob extends APMTimerJob {
        private Runnable mRunnable;

        public HandlerJob(Runnable runnable) {
            this.mRunnable = runnable;
            if (runnable != null) {
                setName(runnable.getClass().getSimpleName());
            }
        }

        @Override // com.alipay.iap.android.aplog.util.APMTimerJob
        protected void doJob() {
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void post(Runnable runnable) {
        register(new HandlerJob(runnable), 0L);
    }

    public void postDelayed(Runnable runnable, long j) {
        register(new HandlerJob(runnable), j);
    }

    public void start() {
        if (this.mWorkTimer == null) {
            synchronized (this) {
                if (this.mWorkTimer == null) {
                    LoggerFactory.getTraceLogger().info(TAG, "start");
                    try {
                        this.mWorkTimer = new Timer(TAG, true);
                    } catch (Throwable th) {
                        LoggerFactory.getTraceLogger().warn(TAG, th);
                    }
                }
            }
        }
    }

    public void stop() {
        if (this.mWorkTimer == null) {
            return;
        }
        LoggerFactory.getTraceLogger().error(TAG, new Exception("stop"));
        try {
            this.mWorkTimer.cancel();
            this.mWorkTimer = null;
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn(TAG, th);
        }
    }

    public void register(APMTimerJob aPMTimerJob, long j) {
        if (aPMTimerJob == null) {
            return;
        }
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("register: ");
        sb.append(aPMTimerJob.getName());
        sb.append(", delay: ");
        sb.append(j);
        traceLogger.info(TAG, sb.toString());
        start();
        try {
            this.mWorkTimer.schedule(aPMTimerJob, j);
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn(TAG, th);
        }
    }

    public void register(APMTimerJob aPMTimerJob, long j, long j2) {
        if (aPMTimerJob == null) {
            return;
        }
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("register: ");
        sb.append(aPMTimerJob.getName());
        sb.append(", delay: ");
        sb.append(j);
        sb.append(", period: ");
        sb.append(j2);
        traceLogger.info(TAG, sb.toString());
        start();
        try {
            this.mWorkTimer.schedule(aPMTimerJob, j, j2);
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn(TAG, th);
        }
    }

    public void unregister(APMTimerJob aPMTimerJob) {
        if (aPMTimerJob == null) {
            return;
        }
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("unregister: ");
        sb.append(aPMTimerJob.getName());
        traceLogger.info(TAG, sb.toString());
        try {
            aPMTimerJob.cancel();
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn(TAG, th);
        }
    }
}

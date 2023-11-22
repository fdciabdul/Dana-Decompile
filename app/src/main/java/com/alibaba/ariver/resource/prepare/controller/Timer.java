package com.alibaba.ariver.resource.prepare.controller;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class Timer {

    /* renamed from: a  reason: collision with root package name */
    private final TimeoutListener f6235a;
    private final TimerExecutor b;
    private TimeoutRunnable c;

    /* loaded from: classes6.dex */
    public interface TimeoutListener {
        void onTimeout(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Timer(TimeoutListener timeoutListener) {
        this(timeoutListener, new HandlerExecutor());
    }

    Timer(TimeoutListener timeoutListener, TimerExecutor timerExecutor) {
        this.c = null;
        this.f6235a = timeoutListener;
        this.b = timerExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postTimeout(long j) {
        long currentTimeMillis;
        synchronized (this) {
            TimeoutRunnable timeoutRunnable = this.c;
            if (timeoutRunnable == null) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                timeoutRunnable.b = true;
                currentTimeMillis = this.c.f6237a;
                this.b.removeCallbacks(this.c);
            }
            TimeoutRunnable timeoutRunnable2 = new TimeoutRunnable(currentTimeMillis);
            this.c = timeoutRunnable2;
            this.b.postDelayed(timeoutRunnable2, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidTimeout() {
        synchronized (this) {
            TimeoutRunnable timeoutRunnable = this.c;
            if (timeoutRunnable != null) {
                timeoutRunnable.b = true;
                this.b.removeCallbacks(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    class TimeoutRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private long f6237a;
        private boolean b;

        private TimeoutRunnable(long j) {
            this.b = false;
            this.f6237a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - this.f6237a;
            StringBuilder sb = new StringBuilder();
            sb.append("timer timeout on elapsed: ");
            sb.append(currentTimeMillis);
            RVLogger.d("AriverRes:Timer", sb.toString());
            if (this.b) {
                return;
            }
            if (Timer.this.f6235a != null) {
                Timer.this.f6235a.onTimeout(currentTimeMillis);
            }
            Timer.this.c = null;
        }
    }

    /* loaded from: classes6.dex */
    static class HandlerExecutor implements TimerExecutor {

        /* renamed from: a  reason: collision with root package name */
        private Handler f6236a = new Handler(Looper.getMainLooper());

        HandlerExecutor() {
        }

        @Override // com.alibaba.ariver.resource.prepare.controller.TimerExecutor
        public void postDelayed(Runnable runnable, long j) {
            this.f6236a.postDelayed(runnable, j);
        }

        @Override // com.alibaba.ariver.resource.prepare.controller.TimerExecutor
        public void removeCallbacks(Runnable runnable) {
            this.f6236a.removeCallbacks(runnable);
        }
    }
}

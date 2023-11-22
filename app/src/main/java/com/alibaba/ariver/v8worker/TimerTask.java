package com.alibaba.ariver.v8worker;

/* loaded from: classes6.dex */
public abstract class TimerTask implements Runnable {
    boolean cancelled;
    boolean fixedRate;
    final Object lock = new Object();
    long period;
    private long scheduledTime;
    long when;

    @Override // java.lang.Runnable
    public abstract void run();

    long getWhen() {
        long j;
        synchronized (this.lock) {
            j = this.when;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScheduledTime(long j) {
        synchronized (this.lock) {
            this.scheduledTime = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isScheduled() {
        boolean z;
        synchronized (this.lock) {
            if (this.when <= 0) {
                z = this.scheduledTime > 0;
            }
        }
        return z;
    }

    public boolean cancel() {
        boolean z;
        synchronized (this.lock) {
            z = !this.cancelled && this.when > 0;
            this.cancelled = true;
        }
        return z;
    }

    public long scheduledExecutionTime() {
        long j;
        synchronized (this.lock) {
            j = this.scheduledTime;
        }
        return j;
    }
}

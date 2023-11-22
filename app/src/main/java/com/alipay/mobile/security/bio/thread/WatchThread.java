package com.alipay.mobile.security.bio.thread;

/* loaded from: classes7.dex */
public abstract class WatchThread extends Thread {
    public static final ThreadGroup tg = new ThreadGroup("watch-thread");
    private boolean alive;
    private String status;

    protected abstract void task();

    public WatchThread(String str) {
        super(tg, str);
        this.alive = true;
        this.status = null;
        setDaemon(true);
    }

    public void kill() {
        this.alive = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.alive) {
            try {
                task();
            } catch (Throwable unused) {
            }
        }
    }

    protected void setStatus(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }
}

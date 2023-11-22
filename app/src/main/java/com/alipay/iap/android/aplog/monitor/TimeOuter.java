package com.alipay.iap.android.aplog.monitor;

import com.alipay.iap.android.aplog.monitor.tools.HandlerThreadFactory;

/* loaded from: classes6.dex */
public abstract class TimeOuter {

    /* renamed from: a  reason: collision with root package name */
    protected long f6929a;
    protected long b = 0;
    private Runnable c = new Runnable() { // from class: com.alipay.iap.android.aplog.monitor.TimeOuter.1
        @Override // java.lang.Runnable
        public void run() {
            TimeOuter.this.a();
        }
    };

    abstract void a();

    public TimeOuter(long j) {
        if (0 == j) {
            this.f6929a = 1000L;
        }
        this.f6929a = j;
    }

    public void b() {
        HandlerThreadFactory.a().removeCallbacks(this.c);
        HandlerThreadFactory.a().postDelayed(this.c, this.f6929a);
    }

    public void c() {
        HandlerThreadFactory.a().removeCallbacks(this.c);
    }
}

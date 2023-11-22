package com.alipay.iap.android.aplog.monitor.sampler;

import com.alipay.iap.android.aplog.monitor.tools.HandlerThreadFactory;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class AbstractSampler {
    long b;

    /* renamed from: a  reason: collision with root package name */
    SimpleDateFormat f6933a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private AtomicBoolean c = new AtomicBoolean(false);
    private Runnable d = new Runnable() { // from class: com.alipay.iap.android.aplog.monitor.sampler.AbstractSampler.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractSampler.this.c();
            if (AbstractSampler.this.c.get()) {
                HandlerThreadFactory.a().postDelayed(AbstractSampler.this.d, AbstractSampler.this.b);
            }
        }
    };

    abstract void c();

    public AbstractSampler(long j) {
        this.b = 0 == j ? 1000L : j;
    }

    public void a() {
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        HandlerThreadFactory.a().removeCallbacks(this.d);
        HandlerThreadFactory.a().postDelayed(this.d, this.b);
    }

    public void b() {
        if (this.c.get()) {
            this.c.set(false);
            HandlerThreadFactory.a().removeCallbacks(this.d);
        }
    }
}

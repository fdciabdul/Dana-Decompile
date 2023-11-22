package com.alipay.iap.android.aplog.monitor;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Printer;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.base.MainLooperLogger;
import com.alipay.iap.android.aplog.monitor.sampler.AllThreadsSampler;
import com.alipay.iap.android.aplog.monitor.sampler.CpuSampler;
import com.alipay.iap.android.aplog.monitor.sampler.MainStackSampler;
import com.alipay.iap.android.aplog.monitor.util.APMUtil;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class ANRMonitor implements Printer {
    static int g = -1;

    /* renamed from: a  reason: collision with root package name */
    String f6927a;
    final MainStackSampler c;
    final AllThreadsSampler d;
    final CpuSampler e;
    TimeOuter f;
    long b = 0;
    private boolean h = false;
    private boolean i = false;
    private long j = -1;
    private SharedPreferences k = null;
    private int l = -1;

    abstract void a(Map<String, String> map);

    abstract String b();

    abstract String c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(long j, long j2);

    private void h() {
        if (this.k == null) {
            this.k = APMUtil.a(LoggerFactory.getLogContext().getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (ANRMonitor.class) {
            try {
                h();
                if (this.l == -1) {
                    this.l = this.k.getInt(b(), 0);
                }
                this.l++;
                this.k.edit().putInt(b(), this.l).apply();
            } catch (Exception e) {
                LoggerFactory.getTraceLogger().error("ANRMonitor", e);
            }
        }
    }

    private int i() {
        int i;
        synchronized (ANRMonitor.class) {
            try {
                h();
                if (this.l == -1) {
                    this.l = this.k.getInt(b(), 0);
                }
                i = this.l;
            } catch (Exception e) {
                LoggerFactory.getTraceLogger().error("ANRMonitor", e);
                return 10;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            h();
            if (this.j == -1) {
                this.j = this.k.getLong(c(), -1L);
            }
            if (this.j == -1) {
                this.j = currentTimeMillis;
                this.k.edit().putLong(c(), this.j).apply();
            }
            if (Math.abs(currentTimeMillis - this.j) <= TimeUnit.DAYS.toMillis(1L)) {
                return i() < 10;
            }
            this.j = currentTimeMillis;
            this.k.edit().putLong(c(), this.j).apply();
            j();
            return true;
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().error("ANRMonitor", e);
            return false;
        }
    }

    private void j() {
        synchronized (ANRMonitor.class) {
            try {
                h();
                this.l = 0;
                this.k.edit().putInt(b(), this.l).apply();
            } catch (Exception e) {
                LoggerFactory.getTraceLogger().error("ANRMonitor", e);
            }
        }
    }

    public ANRMonitor(long j, String str) {
        this.f6927a = str;
        long j2 = j / 5;
        this.c = new MainStackSampler(j2);
        this.d = new AllThreadsSampler((j * 2) / 5);
        this.e = new CpuSampler(j2);
        LoggerFactory.getTraceLogger().info("ANRMonitor", "new ANRMonitor");
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.h) {
            if (TextUtils.isEmpty(str)) {
                if (this.i) {
                    this.i = false;
                    l();
                }
            } else if (str.startsWith(">>>")) {
                if (this.i) {
                    this.i = false;
                    l();
                }
                if (this.i) {
                    return;
                }
                TimeOuter timeOuter = this.f;
                long currentTimeMillis = System.currentTimeMillis();
                timeOuter.b = currentTimeMillis;
                this.b = currentTimeMillis;
                this.i = true;
                k();
            } else if (this.i) {
                this.i = false;
                l();
            }
        }
    }

    public void e() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", "start");
        if (!d()) {
            LoggerFactory.getTraceLogger().info("ANRMonitor", "already upload max");
        } else if (this.h) {
            LoggerFactory.getTraceLogger().info("ANRMonitor", "already started");
            MainLooperLogger.a().a(this);
        } else {
            this.h = true;
            MainLooperLogger.a().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(long j, long j2) {
        String c = this.c.c(j, j2);
        return TextUtils.isEmpty(c) ? "null" : c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return this.c.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j, long j2) {
        this.c.d(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", "stop");
        if (!this.h) {
            LoggerFactory.getTraceLogger().info("ANRMonitor", "already stopped");
            return;
        }
        this.h = false;
        MainLooperLogger.a().b(this);
        l();
        this.b = 0L;
        this.f.b = 0L;
        this.i = false;
    }

    private void k() {
        this.c.a();
        this.d.a();
        this.e.a();
        this.f.b();
    }

    private void l() {
        this.f.c();
        this.d.b();
        this.e.b();
        this.c.b();
    }
}

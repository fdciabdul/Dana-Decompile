package com.alipay.mobile.rome.syncsdk.service;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7234a = "f";
    private static volatile ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor(new j());
    private static volatile f c;
    private volatile ScheduledFuture<?> d;
    private volatile ScheduledFuture<?> e;
    private volatile ScheduledFuture<?> f;
    private volatile ScheduledFuture<?> g;
    private volatile ScheduledFuture<?> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ScheduledFuture a(f fVar) {
        fVar.g = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ScheduledFuture b(f fVar) {
        fVar.d = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ScheduledFuture c(f fVar) {
        fVar.e = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ScheduledFuture d(f fVar) {
        fVar.f = null;
        return null;
    }

    private f() {
    }

    public static f a() {
        f fVar;
        synchronized (f.class) {
            if (c == null) {
                c = new f();
            }
            fVar = c;
        }
        return fVar;
    }

    public final void a(int i) {
        synchronized (this) {
            String str = f7234a;
            StringBuilder sb = new StringBuilder("startDelayedConnectTimer [ delay=");
            sb.append(i);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
            i();
            if (this.g != null && !this.g.isDone() && !this.g.isCancelled()) {
                StringBuilder sb2 = new StringBuilder("already have a DelayedConnectTimer: [ delayedConnectFuture=");
                sb2.append(this.g);
                sb2.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.c(str, sb2.toString());
                return;
            }
            this.g = b.schedule(new g(this, (byte) 0), i, TimeUnit.SECONDS);
        }
    }

    private void e() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7234a, "stopDelayedConnectTimer: ");
            if (this.g != null && !this.g.isDone()) {
                this.g.cancel(true);
            }
        }
    }

    public final void b(int i) {
        synchronized (this) {
            String str = f7234a;
            StringBuilder sb = new StringBuilder("startHeartBeatTimer [ delay=");
            sb.append(i);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
            i();
            f();
            this.d = b.schedule(new i(this, (byte) 0), i, TimeUnit.SECONDS);
        }
    }

    private void f() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7234a, "stopHeartBeatTimer: ");
            if (this.d != null && !this.d.isDone()) {
                this.d.cancel(true);
            }
        }
    }

    public final void a(long j, int i) {
        synchronized (this) {
            a("typeHeartBeat", j, i);
        }
    }

    private void g() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7234a, "stopHeartBeatReplayCheckTimer: ");
            if (this.e != null && !this.e.isDone()) {
                this.e.cancel(true);
            }
        }
    }

    public final boolean b() {
        synchronized (this) {
            if (this.e != null) {
                if (!this.e.isDone()) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void b(long j, int i) {
        synchronized (this) {
            a("typeInit", j, i);
        }
    }

    private void h() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7234a, "stopInitReplayCheckTimer: ");
            if (this.f != null && !this.f.isDone()) {
                this.f.cancel(true);
            }
        }
    }

    private void a(String str, long j, int i) {
        synchronized (this) {
            String str2 = f7234a;
            StringBuilder sb = new StringBuilder("startReplayCheckTimer: [ type=");
            sb.append(str);
            sb.append(" ][ sendTimeMillis=");
            sb.append(j);
            sb.append(" ][ delay=");
            sb.append(i);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
            i();
            if ("typeHeartBeat".equals(str)) {
                g();
                this.e = b.schedule(new k(this, str, j, i), i, TimeUnit.SECONDS);
            } else if ("typeInit".equals(str)) {
                h();
                this.f = b.schedule(new k(this, str, j, i), i, TimeUnit.SECONDS);
            } else {
                com.alipay.mobile.rome.syncsdk.util.c.d(str2, "startReplayCheckTimer: [ unknown type ]");
            }
        }
    }

    public final void c() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7234a, "clearAllTimers: ");
            f();
            g();
            h();
            e();
            j();
        }
    }

    private static void i() {
        synchronized (f.class) {
            if (b == null || b.isTerminated() || b.isShutdown()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(f7234a, "checkExecutorService: newSingleThreadScheduledExecutor ");
                b = Executors.newSingleThreadScheduledExecutor(new j());
            }
        }
    }

    public final void a(long j) {
        synchronized (this) {
            String str = f7234a;
            StringBuilder sb = new StringBuilder("startFlowControlTimer: controlTime=");
            sb.append(j);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            com.alipay.mobile.rome.syncsdk.a.c.a(true);
            j();
            this.h = b.schedule(new h(this, (byte) 0), j, TimeUnit.SECONDS);
        }
    }

    public final void b(long j) {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.b.a a2 = com.alipay.mobile.rome.syncsdk.b.a.a();
            Context f = LongLinkService.a().f();
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toString(System.currentTimeMillis() + j));
            sb.append(",");
            sb.append(Long.toString(j));
            a2.a(f, "flow_control", sb.toString());
            a(j);
        }
    }

    private void j() {
        synchronized (this) {
            if (this.h != null && !this.h.isDone()) {
                this.h.cancel(true);
            }
        }
    }
}

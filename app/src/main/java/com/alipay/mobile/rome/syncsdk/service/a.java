package com.alipay.mobile.rome.syncsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.ConnectionEvent;
import com.alipay.mobile.rome.syncsdk.service.ConnStateFsm;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class a {
    private static final String b = "a";

    /* renamed from: a  reason: collision with root package name */
    public volatile Context f7222a;
    private volatile com.alipay.mobile.rome.syncsdk.transport.connection.a c;
    private volatile long d;
    private volatile long e;
    private volatile ConnStateFsm f;
    private volatile int g;
    private volatile e h;
    private volatile ExecutorService i;
    private volatile Future<?> j;
    private volatile Future<?> k;
    private volatile Future<?> l;
    private volatile Future<?> m;
    private volatile Future<?> n;

    /* renamed from: o  reason: collision with root package name */
    private volatile Future<?> f7223o;
    private d p;

    public a(Context context) {
        com.alipay.mobile.rome.syncsdk.util.c.b(b, "ConnManager");
        this.f7222a = context;
        this.f = new ConnStateFsm();
        this.g = com.alipay.mobile.rome.syncsdk.transport.b.b.b;
    }

    private boolean A() {
        String str = b;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "checkCanConnect");
        if (TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().h()) || TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().i())) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "checkCanConnect: [ isForceStopped=false host or port is null] ");
            return false;
        } else if (com.alipay.mobile.rome.syncsdk.a.c.a()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "checkCanConnect: [ isForceStopped=false ] ");
            return false;
        } else if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "checkCanConnect: [ isReconnEnable=false ] ");
            return false;
        } else if (com.alipay.mobile.rome.syncsdk.util.e.b(this.f7222a)) {
            return true;
        } else {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "checkCanConnect: [ isNetAvailable=false ] ");
            return false;
        }
    }

    public final void a() {
        synchronized (this) {
            this.f.a();
        }
    }

    public final ConnStateFsm.State b() {
        ConnStateFsm.State b2;
        synchronized (this) {
            b2 = this.f.b();
        }
        return b2;
    }

    public final void c() {
        synchronized (this) {
            String str = b;
            com.alipay.mobile.rome.syncsdk.util.c.a(str, "connect: ");
            if (A()) {
                if (this.j != null && !this.j.isDone() && (this.k == null || this.k.isDone())) {
                    StringBuilder sb = new StringBuilder("connect: [ already has a connect task ][ futureConnect=");
                    sb.append(this.j);
                    sb.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.c(str, sb.toString());
                    return;
                }
                this.j = a(new com.alipay.mobile.rome.syncsdk.service.a.c(this));
            }
        }
    }

    public final void d() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "connectOnRunned: ");
            this.j = null;
        }
    }

    public final void e() {
        synchronized (this) {
            String str = b;
            com.alipay.mobile.rome.syncsdk.util.c.a(str, "disconnect: ");
            f.a().c();
            if (this.j != null && !this.j.isDone()) {
                this.j.cancel(false);
            }
            if (this.l != null && !this.l.isDone()) {
                this.l.cancel(false);
            }
            if (this.m != null && !this.m.isDone()) {
                this.m.cancel(false);
            }
            if (this.n != null && !this.n.isDone()) {
                this.n.cancel(false);
            }
            if (this.f7223o != null && !this.f7223o.isDone()) {
                this.f7223o.cancel(false);
            }
            if (this.k != null && !this.k.isDone()) {
                StringBuilder sb = new StringBuilder("disconnect: [ already has a disconnect task ][ futureDisconnect=");
                sb.append(this.k);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.c(str, sb.toString());
                return;
            }
            a(new com.alipay.mobile.rome.syncsdk.service.a.b(this));
            this.k = a(new com.alipay.mobile.rome.syncsdk.service.a.d(this));
        }
    }

    public final void f() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "reconnect: ");
            e();
            if (A()) {
                this.j = a(new com.alipay.mobile.rome.syncsdk.service.a.c(this));
            }
        }
    }

    public final void g() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "sendRegisterPacket: ");
            if (p()) {
                this.l = a(new com.alipay.mobile.rome.syncsdk.service.a.f(this));
            }
        }
    }

    public final void h() {
        synchronized (this) {
            String str = b;
            com.alipay.mobile.rome.syncsdk.util.c.a(str, "sendHeartBeatPacket: ");
            if (p()) {
                if (f.a().b()) {
                    com.alipay.mobile.rome.syncsdk.util.c.c(str, "sendHeartBeatPacket: [ wait heartbeat reply ] ");
                    return;
                }
                if (this.n != null && !this.n.isDone()) {
                    this.n.cancel(false);
                }
                this.n = a(new com.alipay.mobile.rome.syncsdk.service.a.e(this));
            }
        }
    }

    public final void i() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "sendBindUerPacket");
            if (!p()) {
                if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    com.alipay.mobile.rome.syncsdk.a.c.e();
                }
                if (A()) {
                    c();
                    return;
                }
                return;
            }
            this.m = a(new com.alipay.mobile.rome.syncsdk.service.a.a(this));
        }
    }

    public final void j() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "sendUnBindUerPacket");
            if (!p()) {
                if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    com.alipay.mobile.rome.syncsdk.a.c.e();
                }
                if (A()) {
                    c();
                    return;
                }
                return;
            }
            this.f7223o = a(new com.alipay.mobile.rome.syncsdk.service.a.h(this));
        }
    }

    public final void a(byte[] bArr) {
        synchronized (this) {
            if (!p()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(b, "sendLinkSyncData [ isConnected=false ]");
                if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    com.alipay.mobile.rome.syncsdk.a.c.e();
                }
                if (A()) {
                    f.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
                    return;
                }
                return;
            }
            a(new com.alipay.mobile.rome.syncsdk.service.a.g(this, bArr));
        }
    }

    public final com.alipay.mobile.rome.syncsdk.transport.connection.a k() {
        com.alipay.mobile.rome.syncsdk.transport.connection.a aVar;
        synchronized (this) {
            aVar = this.c;
        }
        return aVar;
    }

    public final void a(com.alipay.mobile.rome.syncsdk.transport.connection.a aVar) {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.a(b, "setConnection");
            this.c = aVar;
        }
    }

    public final e l() {
        e eVar;
        synchronized (this) {
            eVar = this.h;
        }
        return eVar;
    }

    public final void a(e eVar) {
        synchronized (this) {
            this.h = eVar;
        }
    }

    public final int m() {
        int i;
        synchronized (this) {
            i = this.g;
        }
        return i;
    }

    public final long n() {
        long j;
        synchronized (this) {
            j = this.d;
        }
        return j;
    }

    public final void a(long j) {
        synchronized (this) {
            this.d = j;
        }
    }

    public final long o() {
        long j;
        synchronized (this) {
            j = this.e;
        }
        return j;
    }

    public final void b(long j) {
        synchronized (this) {
            this.e = j;
        }
    }

    public final boolean p() {
        boolean i;
        synchronized (this) {
            i = this.f.i();
            String str = b;
            StringBuilder sb = new StringBuilder("isConnected [ ");
            sb.append(i);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        }
        return i;
    }

    public final boolean q() {
        boolean j;
        synchronized (this) {
            j = this.f.j();
            String str = b;
            StringBuilder sb = new StringBuilder("isDeviceBinded [ ");
            sb.append(j);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        }
        return j;
    }

    public final boolean r() {
        boolean k;
        synchronized (this) {
            k = this.f.k();
            String str = b;
            StringBuilder sb = new StringBuilder("isUserBinded [ ");
            sb.append(k);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        }
        return k;
    }

    public final void s() {
        synchronized (this) {
            try {
                this.f.c();
                if (this.f.k()) {
                    com.alipay.mobile.rome.syncsdk.a.c.a("");
                }
            } catch (Exception e) {
                String str = b;
                StringBuilder sb = new StringBuilder("onRecvRegisterReply: [ Exception=");
                sb.append(e);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
                f.a().c();
                e();
                f.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
            }
        }
    }

    public final void c(long j) {
        synchronized (this) {
            this.f.d();
            com.alipay.mobile.rome.syncsdk.util.c.b(b, "[onConnecting] Notify connected event.");
            z().a(new ConnectionEvent(ConnectionEvent.Type.Connected, Long.valueOf(j)));
        }
    }

    public final void t() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.b(b, "[onConnecting] Notify connecting event.");
            z().a(new ConnectionEvent(ConnectionEvent.Type.Connecting));
        }
    }

    public final void a(String str) {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.b(b, "[onConnectFailed] Notify connect failed event.");
            z().a(new ConnectionEvent(ConnectionEvent.Type.ConnectFailed, str));
        }
    }

    public final void u() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.b(b, "[onConnecting] Notify disconnected event.");
            z().a(new ConnectionEvent(ConnectionEvent.Type.Disconnected));
        }
    }

    public final void v() {
        synchronized (this) {
            this.f.e();
        }
    }

    public final void w() {
        synchronized (this) {
            this.f.f();
        }
    }

    public final void x() {
        synchronized (this) {
            this.f.g();
        }
    }

    public final void y() {
        synchronized (this) {
            this.f.h();
        }
    }

    public final d z() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            d dVar2 = this.p;
            if (dVar2 != null) {
                return dVar2;
            }
            d dVar3 = new d();
            this.p = dVar3;
            return dVar3;
        }
    }

    private Future<?> a(Runnable runnable) {
        if (this.i == null || this.i.isTerminated() || this.i.isShutdown()) {
            this.i = Executors.newSingleThreadExecutor(new b(this));
        }
        return this.i.submit(runnable);
    }
}

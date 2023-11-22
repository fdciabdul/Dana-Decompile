package com.alipay.mobile.rome.syncsdk.service;

/* loaded from: classes3.dex */
public class ConnStateFsm {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7218a = "ConnStateFsm";
    private volatile State b = State.INIT;

    /* loaded from: classes3.dex */
    public enum State {
        INIT,
        CONNECTED,
        WAIT_DEVICE_BINDED,
        DEVICE_BINDED,
        WAIT_USER_BINDED,
        USER_BINDED,
        WAIT_REGISTERED,
        REGISTERED,
        WAIT_USER_UNBINDED
    }

    public final void a() {
        synchronized (this) {
            this.b = State.INIT;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("toInitState [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final State b() {
        State state;
        synchronized (this) {
            String str = f7218a;
            StringBuilder sb = new StringBuilder("getCurrState [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
            state = this.b;
        }
        return state;
    }

    public final void c() {
        synchronized (this) {
            int i = c.f7233a[this.b.ordinal()];
            if (i == 2) {
                this.b = State.DEVICE_BINDED;
            } else if (i == 3) {
                this.b = State.USER_BINDED;
            } else if (i == 4) {
                this.b = State.REGISTERED;
            } else if (i == 5) {
                this.b = State.DEVICE_BINDED;
            } else {
                String str = f7218a;
                StringBuilder sb = new StringBuilder("onRecvRegisterReply: [state error] [ currState=");
                sb.append(this.b);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
                throw new Exception("");
            }
            String str2 = f7218a;
            StringBuilder sb2 = new StringBuilder("onRecvRegisterReply [ currState=");
            sb2.append(this.b);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb2.toString());
        }
    }

    public final void d() {
        synchronized (this) {
            this.b = State.CONNECTED;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("onConnectSucceeded [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final void e() {
        synchronized (this) {
            this.b = State.WAIT_REGISTERED;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("onRegisterSended [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final void f() {
        synchronized (this) {
            this.b = State.WAIT_DEVICE_BINDED;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("onDeviceBindSended [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final void g() {
        synchronized (this) {
            this.b = State.WAIT_USER_BINDED;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("onUserBindSended [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final void h() {
        synchronized (this) {
            this.b = State.WAIT_USER_UNBINDED;
            String str = f7218a;
            StringBuilder sb = new StringBuilder("onUserUnBindSended [ currState=");
            sb.append(this.b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public final boolean i() {
        boolean z;
        synchronized (this) {
            z = this.b != State.INIT;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean j() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r0 = r6.b     // Catch: java.lang.Throwable -> L28
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r1 = com.alipay.mobile.rome.syncsdk.service.ConnStateFsm.State.DEVICE_BINDED     // Catch: java.lang.Throwable -> L28
            r2 = 0
            r3 = 1
            if (r0 != r1) goto Lb
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r1 = r6.b     // Catch: java.lang.Throwable -> L28
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r4 = com.alipay.mobile.rome.syncsdk.service.ConnStateFsm.State.WAIT_USER_BINDED     // Catch: java.lang.Throwable -> L28
            if (r1 == r4) goto L1b
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r1 = r6.b     // Catch: java.lang.Throwable -> L28
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r4 = com.alipay.mobile.rome.syncsdk.service.ConnStateFsm.State.USER_BINDED     // Catch: java.lang.Throwable -> L28
            if (r1 != r4) goto L19
            goto L1b
        L19:
            r1 = 0
            goto L1c
        L1b:
            r1 = 1
        L1c:
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r4 = r6.b     // Catch: java.lang.Throwable -> L28
            com.alipay.mobile.rome.syncsdk.service.ConnStateFsm$State r5 = com.alipay.mobile.rome.syncsdk.service.ConnStateFsm.State.REGISTERED     // Catch: java.lang.Throwable -> L28
            if (r4 == r5) goto L23
            goto L24
        L23:
            r2 = 1
        L24:
            monitor-exit(r6)
            r0 = r0 | r1
            r0 = r0 | r2
            return r0
        L28:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.service.ConnStateFsm.j():boolean");
    }

    public final boolean k() {
        boolean z;
        synchronized (this) {
            if (this.b != State.USER_BINDED) {
                z = this.b == State.REGISTERED;
            }
        }
        return z;
    }
}

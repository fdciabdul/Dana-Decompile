package com.iap.ac.config.lite.e;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.utils.NetworkUtils;
import com.iap.ac.android.common.utils.ProcessOwnerLifecycleWatcher;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.ICancelableTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a<T> implements ICancelableTask {
    private static final String l = com.iap.ac.config.lite.d.e.b("PollingScheduler");
    private static boolean m = true;
    protected final Handler c;
    public final ConfigCenterContext d;
    private ProcessOwnerLifecycleWatcher h;
    private NetworkUtils.NetworkStateListener i;
    private Handler j;

    /* renamed from: a  reason: collision with root package name */
    private f f7634a = f.WAITING;
    private volatile boolean b = false;
    private final List<g<T>> e = new ArrayList();
    public int f = 0;
    public int g = 0;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iap.ac.config.lite.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0140a implements Runnable {
        RunnableC0140a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements NetworkUtils.NetworkStateListener {
        c() {
        }

        @Override // com.iap.ac.android.common.utils.NetworkUtils.NetworkStateListener
        public void onNetworkChanged(int i, int i2) {
            if (i2 != 0) {
                ACLog.i(a.l, "onNetworkChanged to available, will try scheduleTask");
                a.this.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {112, 91, -28, 61, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int MyBillsEntityDataFactory = 82;

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7638a;

        /* renamed from: com.iap.ac.config.lite.e.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0141a implements ProcessOwnerLifecycleWatcher.LifecycleCallback {
            C0141a() {
            }

            @Override // com.iap.ac.android.common.utils.ProcessOwnerLifecycleWatcher.LifecycleCallback
            public void onAppToBackground() {
            }

            @Override // com.iap.ac.android.common.utils.ProcessOwnerLifecycleWatcher.LifecycleCallback
            public void onAppToForeground() {
                ACLog.i(a.l, "onAppToForeground, will try scheduleTask");
                a.this.k();
            }
        }

        d(Context context) {
            this.f7638a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void c(byte r7, short r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 7
                int r7 = r7 + 99
                byte[] r0 = com.iap.ac.config.lite.e.a.d.BuiltInFictitiousFunctionClassFactory
                int r9 = r9 * 12
                int r9 = 15 - r9
                int r8 = r8 * 3
                int r8 = r8 + 13
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L1a
                r7 = r8
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L36
            L1a:
                r3 = 0
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                int r9 = r9 + 1
                r1[r3] = r5
                if (r4 != r8) goto L2c
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2c:
                r3 = r0[r9]
                r6 = r9
                r9 = r7
                r7 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L36:
                int r8 = -r8
                int r9 = r9 + r8
                int r8 = r9 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.config.lite.e.a.d.c(byte, short, int, java.lang.Object[]):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = a.l;
            StringBuilder sb = new StringBuilder();
            sb.append("Add app-foreground observer from: ");
            try {
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                c(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                Object[] objArr2 = new Object[1];
                c(b3, b3, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                ACLog.d(str, sb.toString());
                a.this.h = ProcessOwnerLifecycleWatcher.INSTANCE;
                a.this.h.addLifecycleCallback(new C0141a());
                a.this.h.startWatcher(this.f7638a);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7640a;
        public static final byte[] PlaceComponentResult = {112, 91, -28, 61, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int BuiltInFictitiousFunctionClassFactory = 35;

        e(Context context) {
            this.f7640a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void c(byte r7, short r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 7
                int r8 = r8 + 99
                byte[] r0 = com.iap.ac.config.lite.e.a.e.PlaceComponentResult
                int r9 = r9 * 3
                int r9 = r9 + 13
                int r7 = r7 + 4
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L31
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r9) goto L27
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L27:
                int r7 = r7 + 1
                r3 = r0[r7]
                r6 = r10
                r10 = r9
                r9 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L31:
                int r9 = -r9
                int r8 = r8 + r9
                int r8 = r8 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.config.lite.e.a.e.c(byte, short, int, java.lang.Object[]):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = a.l;
            StringBuilder sb = new StringBuilder();
            sb.append("Remove app-foreground observer from: ");
            try {
                byte b = PlaceComponentResult[16];
                byte b2 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr = new Object[1];
                c(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = PlaceComponentResult[15];
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                c(b3, b4, b4, objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                ACLog.d(str, sb.toString());
                a.this.h.stopWatcher(this.f7640a);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum f {
        CANCELED,
        POLLING,
        WAITING
    }

    /* loaded from: classes3.dex */
    public static class g<P> {

        /* renamed from: a  reason: collision with root package name */
        private long f7641a;
        private P b;

        public g(P p, long j) {
            this.b = p;
            this.f7641a = j;
        }

        public String toString() {
            return String.format("%s - delay %s ms", this.b, Long.valueOf(this.f7641a));
        }
    }

    public a(ConfigCenterContext configCenterContext) {
        this.d = configCenterContext;
        HandlerThread handlerThread = new HandlerThread("ConfigPollingScheduler-Thread");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.j = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            if (this.b) {
                if (m()) {
                    i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        if (isCanceled()) {
            ACLog.w(l, "Scheduler already canceled. will skip doPollingTaskInternal.");
        } else if (this.g >= this.e.size()) {
            ACLog.w(l, "All tasks finished. will skip.");
        } else if (!m()) {
            String str = l;
            StringBuilder sb = new StringBuilder();
            sb.append("AppInBackground or NoNetwork now! will not polling. mCurrentTaskIndex = ");
            sb.append(this.g);
            ACLog.e(str, sb.toString());
        } else {
            f();
            g<T> gVar = this.e.get(this.g);
            if (a((a<T>) ((g) gVar).b)) {
                cancel();
                return;
            }
            int i = this.g + 1;
            this.g = i;
            if (i < this.e.size()) {
                a(((g) gVar).f7641a);
                return;
            }
            String str2 = l;
            ACLog.i(str2, "All tasks finished.");
            int i2 = this.f + 1;
            this.f = i2;
            if (i2 >= a()) {
                ACLog.e(str2, "** All retry turn finished, will not retry.");
                g();
                return;
            }
            long a2 = a(false);
            ACLog.i(str2, String.format("** Will schedule next retry. mPollingCount = %s, delay = %s", Integer.valueOf(this.f), Long.valueOf(a2)));
            this.g = 0;
            a(a2);
        }
    }

    private boolean m() {
        boolean z = true;
        if (m) {
            n();
            c(false);
            return true;
        }
        Context context = this.d.getContext();
        boolean a2 = com.iap.ac.config.lite.d.e.a(context);
        boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(context);
        ACLog.i(l, String.format("scheduleTask. appInForeground = %s, hasNetwork = %s", Boolean.valueOf(a2), Boolean.valueOf(isNetworkAvailable)));
        if (this.k) {
            z = isNetworkAvailable;
        } else if (!a2 || !isNetworkAvailable) {
            z = false;
        }
        c(!z);
        return z;
    }

    private static void n() {
        m = false;
    }

    private void o() {
        if (this.f7634a != f.CANCELED) {
            this.f7634a = f.POLLING;
        }
    }

    private void p() {
        Context context = this.d.getContext();
        if (!NetworkUtils.isNetworkAvailable(context)) {
            ACLog.d(l, "Add network observer");
            c cVar = new c();
            this.i = cVar;
            NetworkUtils.addNetworkStateListener(context, cVar);
        }
        if (com.iap.ac.config.lite.d.e.a(context)) {
            return;
        }
        if (this.j == null) {
            this.j = new Handler(Looper.getMainLooper());
        }
        this.j.post(new d(context));
    }

    private void q() {
        Context context = this.d.getContext();
        if (this.i != null) {
            ACLog.d(l, "Remove network observer");
            NetworkUtils.removeNetworkStateListener(context, this.i);
            this.i = null;
        }
        if (this.h != null) {
            if (this.j == null) {
                this.j = new Handler(Looper.getMainLooper());
            }
            this.j.post(new e(context));
            this.i = null;
        }
    }

    protected abstract int a();

    protected abstract long a(boolean z);

    protected abstract boolean a(T t);

    protected abstract String c();

    @Override // com.iap.ac.config.lite.common.ICancelableTask
    public void cancel() {
        if (this.f7634a == f.CANCELED) {
            return;
        }
        String str = l;
        StringBuilder sb = new StringBuilder();
        sb.append("Will stop scheduler. mCurrentTaskIndex = ");
        sb.append(this.g);
        ACLog.d(str, sb.toString());
        this.f7634a = f.CANCELED;
        this.c.removeCallbacksAndMessages(null);
        c(false);
        Looper looper = this.c.getLooper();
        if (looper != null) {
            looper.quit();
        }
    }

    public boolean d() {
        return this.f7634a == f.POLLING;
    }

    public void e() {
        ACLog.d(l, "ConfigPollingScheduler tasks: ");
        for (int i = 0; i < this.e.size(); i++) {
            ACLog.d(l, String.format("    %s %s", Integer.valueOf(i), this.e.get(i)));
        }
    }

    protected abstract void f();

    public abstract void g();

    public void h() {
        a(a(false));
    }

    public void i() {
        if (isCanceled()) {
            ACLog.w(l, "Scheduler already canceled. will skip scheduleTask.");
            return;
        }
        o();
        this.c.post(new RunnableC0140a());
    }

    @Override // com.iap.ac.config.lite.common.ICancelableTask
    public boolean isCanceled() {
        return this.f7634a == f.CANCELED;
    }

    private void c(boolean z) {
        synchronized (this) {
            if (this.b == z) {
                String str = l;
                StringBuilder sb = new StringBuilder();
                sb.append("switchObserveStatus need not switch: ");
                sb.append(z);
                InstrumentInjector.log_d(str, sb.toString());
                return;
            }
            String str2 = l;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switchObserveStatus to: ");
            sb2.append(z);
            InstrumentInjector.log_d(str2, sb2.toString());
            this.b = z;
            if (this.b) {
                p();
            } else {
                q();
            }
        }
    }

    public int b() {
        return this.f;
    }

    public void a(long j) {
        if (isCanceled()) {
            ACLog.w(l, "Scheduler already canceled. will skip scheduleTask.");
        } else if (j < 0) {
            ACLog.i(l, "delay is less than zero, will not schedule");
        } else {
            ACLog.i(l, String.format("Will retry refresh for task %s after %s ms, mCurrentTaskIndex = %s.", c(), Long.valueOf(j), Integer.valueOf(this.g)));
            o();
            this.c.postDelayed(new b(), j);
        }
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void a(g<T>... gVarArr) {
        if (gVarArr == null || gVarArr.length <= 0) {
            return;
        }
        this.e.clear();
        Collections.addAll(this.e, gVarArr);
    }
}

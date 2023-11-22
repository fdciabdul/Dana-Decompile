package com.alipay.iap.android.f2fpay.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;

/* loaded from: classes3.dex */
public class a {
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private Handler f6944a = new Handler(Looper.getMainLooper());
    private c b;

    /* loaded from: classes3.dex */
    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private a f6945a;

        private void a() {
            a aVar = this.f6945a;
            if (aVar == null) {
                return;
            }
            aVar.c(this);
            onScheduleFinish();
        }

        public void bindTimer(a aVar) {
            this.f6945a = aVar;
        }

        public abstract void call();

        public abstract int nextDelayMillSeconds();

        public void onScheduleFinish() {
        }

        public void reset() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c extends HandlerThread {

        /* renamed from: a  reason: collision with root package name */
        private Handler f6946a;

        private c() {
            super("TaskHandlerThread");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            synchronized (this) {
                if (this.f6946a == null) {
                    this.f6946a = new Handler(getLooper());
                }
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void a(b bVar) {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        cVar.a();
        this.b.f6946a.removeCallbacks(bVar);
        bVar.reset();
        StringBuilder sb = new StringBuilder();
        sb.append("cancel task:");
        sb.append(bVar);
        LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
    }

    public void a(b bVar, long j) {
        if (this.b == null) {
            b();
        }
        this.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append("schedule task:");
        sb.append(bVar);
        LoggerWrapper.i(F2FPayConstants.TAG, sb.toString());
        bVar.bindTimer(this);
        if (j > 0) {
            this.b.f6946a.postDelayed(bVar, j);
        } else {
            this.b.f6946a.post(bVar);
        }
    }

    public void a(Runnable runnable) {
        this.f6944a.post(runnable);
    }

    public void b() {
        if (this.b == null) {
            c cVar = new c();
            this.b = cVar;
            cVar.start();
        }
    }

    public void b(b bVar) {
        a(bVar, 0L);
    }

    public void c(b bVar) {
        a(bVar, bVar.nextDelayMillSeconds());
        bVar.onScheduleFinish();
    }
}

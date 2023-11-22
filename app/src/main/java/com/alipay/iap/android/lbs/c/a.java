package com.alipay.iap.android.lbs.c;

import android.os.Handler;
import android.os.Looper;
import com.alipay.iap.android.lbs.LBSLocationErrorCode;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f7000a = new Handler(Looper.getMainLooper());
    private long b;
    private RunnableC0059a c;

    /* renamed from: com.alipay.iap.android.lbs.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class RunnableC0059a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private com.alipay.iap.android.lbs.b.b f7001a;
        private boolean b = false;

        public RunnableC0059a(com.alipay.iap.android.lbs.b.b bVar) {
            this.f7001a = bVar;
        }

        public void a() {
            this.b = true;
        }

        public boolean b() {
            return this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alipay.iap.android.lbs.b.b bVar;
            if (b() || (bVar = this.f7001a) == null) {
                return;
            }
            bVar.a(LBSLocationErrorCode.LocationErrorTimeout);
            this.b = true;
        }
    }

    public a(long j, com.alipay.iap.android.lbs.b.b bVar) {
        this.b = j;
        this.c = new RunnableC0059a(bVar);
    }

    public void a() {
        long j = this.b;
        if (j > 0) {
            this.f7000a.postDelayed(this.c, j);
        }
    }

    public void b() {
        this.c.a();
    }
}

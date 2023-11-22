package com.iap.ac.android.bscanc.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.account.OAuthObserver;
import com.iap.ac.android.common.account.OAuthService;
import com.iap.ac.android.common.log.ACLog;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes8.dex */
public class b implements OAuthObserver {
    public static volatile b d;
    public static long e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<c> f7548a = new ConcurrentLinkedQueue<>();
    public a b;
    public String c;

    public b() {
        a aVar = new a();
        this.b = aVar;
        aVar.f7547a = -30000;
        aVar.b = 30000;
        a(System.currentTimeMillis());
        OAuthService.INSTANCE.registerOAuthEventObserver(this);
    }

    public static b b() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public void a(a aVar) {
        synchronized (this) {
            this.b = aVar;
        }
    }

    @Override // com.iap.ac.android.common.account.OAuthObserver
    public void onOAuthLogin() {
    }

    @Override // com.iap.ac.android.common.account.OAuthObserver
    public void onOAuthLogout() {
        ACLog.i(Constants.TAG, "PaymentCodeCache, onAuthLogout");
        a();
    }

    public String a(String str) {
        boolean z;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getValidPaymentCodeFromCache, The CodeCache code type is: ");
            sb.append(str);
            ACLog.i(Constants.TAG, sb.toString());
            if (!TextUtils.isEmpty(this.c)) {
                if (!this.c.equals(str)) {
                }
                while (!this.f7548a.isEmpty()) {
                    c poll = this.f7548a.poll();
                    long j = poll.b;
                    a aVar = this.b;
                    int i = aVar.b;
                    int i2 = aVar.f7547a;
                    long elapsedRealtime = SystemClock.elapsedRealtime() + e + 0 + i;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() + e + 0 + i2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("checkCodeValid, serverStartTime: ");
                    sb2.append(j);
                    sb2.append(",");
                    sb2.append(elapsedRealtime2);
                    sb2.append(", ");
                    sb2.append(elapsedRealtime);
                    ACLog.i(Constants.TAG, sb2.toString());
                    if (j <= elapsedRealtime2 || j >= elapsedRealtime) {
                        ACLog.i(Constants.TAG, "checkCodeValid, The payment code is not valid");
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return poll.f7549a;
                    }
                }
                a();
                return null;
            }
            a();
            return null;
        }
    }

    public void a(String str, ConcurrentLinkedQueue<c> concurrentLinkedQueue) {
        synchronized (this) {
            if (concurrentLinkedQueue != null) {
                if (concurrentLinkedQueue.size() > 0) {
                    this.c = str;
                    this.f7548a.addAll(concurrentLinkedQueue);
                    return;
                }
            }
            ACLog.e(Constants.TAG, "addPaymentCodeToCache error, paymentCodeEntityList is null");
        }
    }

    public void a() {
        synchronized (this) {
            this.f7548a.clear();
        }
    }

    public void a(long j) {
        e = j - SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("setServerTime, serverTime: ");
        sb.append(j);
        sb.append(", clientTime: ");
        sb.append(System.currentTimeMillis());
        ACLog.i(Constants.TAG, sb.toString());
    }
}

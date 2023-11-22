package com.iap.ac.android.loglite.b;

import com.iap.ac.android.loglite.api.AnalyticsHelper;
import com.iap.ac.android.loglite.b.c;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.a f7582a;

    public b(c.a aVar) {
        this.f7582a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(60000L);
        } catch (InterruptedException unused) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("discardCount", String.valueOf(this.f7582a.b));
        AnalyticsHelper.sendPerformanceLog("sendLogTooMuch", hashMap);
        synchronized (this.f7582a.c) {
            this.f7582a.b = 0L;
        }
    }
}

package com.iap.ac.android.loglite.storage;

import android.app.Application;
import android.text.TextUtils;
import com.iap.ac.android.loglite.log.LogEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AsyncFileStorage extends AnalyticsFileStorage {
    public ThreadPoolExecutor h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogEvent f7597a;
        public final /* synthetic */ String b;

        public a(LogEvent logEvent, String str) {
            this.f7597a = logEvent;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncFileStorage asyncFileStorage = AsyncFileStorage.this;
            if (asyncFileStorage instanceof com.iap.ac.android.loglite.b.a) {
                ((com.iap.ac.android.loglite.b.a) asyncFileStorage).f = this.f7597a.f();
            }
            AsyncFileStorage.this.a(this.f7597a.g(), this.f7597a.c(), this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncFileStorage.this.d();
        }
    }

    public AsyncFileStorage(Application application, String str) {
        super(application, str);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, e(), f());
        this.h = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsStorage
    public void a(LogEvent logEvent, String str) {
        int size = this.h.getQueue().size();
        if (!TextUtils.isEmpty("writeQueueSize")) {
            logEvent.d.put("writeQueueSize", String.valueOf(size));
        }
        this.h.execute(new a(logEvent, str));
    }

    public abstract BlockingQueue<Runnable> e();

    public abstract RejectedExecutionHandler f();

    @Override // com.iap.ac.android.loglite.storage.AnalyticsStorage
    public void a() {
        this.h.execute(new b());
    }
}

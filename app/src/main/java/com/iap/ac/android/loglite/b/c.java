package com.iap.ac.android.loglite.b;

import android.app.Application;
import com.iap.ac.android.loglite.storage.AsyncFileStorage;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class c extends AsyncFileStorage {

    /* loaded from: classes3.dex */
    public static class a extends ThreadPoolExecutor.DiscardOldestPolicy {

        /* renamed from: a  reason: collision with root package name */
        public long f7583a = 0;
        public long b = 0;
        public final Object c = new Object();

        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            synchronized (this.c) {
                this.b++;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f7583a > 60000) {
                    new Thread(new b(this)).start();
                    this.f7583a = currentTimeMillis;
                }
            }
        }
    }

    public c(Application application, String str) {
        super(application, str);
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public File a(String str, String str2) {
        return a(this.b, str, str2, this.f);
    }

    @Override // com.iap.ac.android.loglite.storage.AsyncFileStorage
    public BlockingQueue<Runnable> e() {
        return new LinkedBlockingQueue(1024);
    }

    @Override // com.iap.ac.android.loglite.storage.AsyncFileStorage
    public RejectedExecutionHandler f() {
        return new a();
    }
}

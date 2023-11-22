package com.iap.ac.android.loglite.b;

import android.app.Application;
import com.iap.ac.android.loglite.storage.AsyncFileStorage;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public class d extends AsyncFileStorage {
    public d(Application application, String str) {
        super(application, str);
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public File a(String str, String str2) {
        return a(this.c, str, str2, this.f);
    }

    @Override // com.iap.ac.android.loglite.storage.AsyncFileStorage
    public BlockingQueue<Runnable> e() {
        return new LinkedBlockingQueue(512);
    }

    @Override // com.iap.ac.android.loglite.storage.AsyncFileStorage
    public RejectedExecutionHandler f() {
        return new ThreadPoolExecutor.DiscardOldestPolicy();
    }
}

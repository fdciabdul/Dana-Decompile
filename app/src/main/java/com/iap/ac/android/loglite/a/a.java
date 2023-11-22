package com.iap.ac.android.loglite.a;

import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.storage.AnalyticsFileStorage;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsContext f7579a;

    public a(AnalyticsContext analyticsContext) {
        this.f7579a = analyticsContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000L);
        } catch (InterruptedException unused) {
        }
        this.f7579a.uploadLog(new File(this.f7579a.f7586a.getFilesDir(), AnalyticsFileStorage.g));
    }
}

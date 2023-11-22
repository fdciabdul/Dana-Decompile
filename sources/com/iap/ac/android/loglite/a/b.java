package com.iap.ac.android.loglite.a;

import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.storage.AnalyticsFileStorage;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import java.io.File;

/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsContext f7580a;

    public b(AnalyticsContext analyticsContext) {
        this.f7580a = analyticsContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            File file = new File(this.f7580a.f7586a.getFilesDir(), AnalyticsFileStorage.g);
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    new File(file, str).delete();
                }
            }
        } catch (Exception e) {
            LoggerWrapper.w("AnalyticsContext", e);
        }
    }
}

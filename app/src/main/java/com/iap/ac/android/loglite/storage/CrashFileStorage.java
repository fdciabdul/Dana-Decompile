package com.iap.ac.android.loglite.storage;

import android.app.Application;
import com.iap.ac.android.loglite.log.LogEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class CrashFileStorage extends AnalyticsFileStorage {
    public Map<String, File> h;

    public CrashFileStorage(Application application, String str) {
        super(application, str);
        this.h = new HashMap();
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsStorage
    public void a(LogEvent logEvent, String str) {
        a(logEvent.g(), logEvent.c(), str);
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsStorage
    public void a() {
        d();
    }

    @Override // com.iap.ac.android.loglite.storage.AnalyticsFileStorage
    public File a(String str, String str2) {
        return a(this.h, str, str2, "crash");
    }
}

package com.iap.ac.android.diagnoselog.api;

import android.app.Application;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.diagnoselog.a.a;
import com.iap.ac.android.diagnoselog.a.b;
import com.iap.ac.android.diagnoselog.a.c;
import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import java.util.Date;

/* loaded from: classes8.dex */
public class DiagnoseLogService {
    private static OnLogUploadListener onLogUploadListener;

    @Deprecated
    public static void flush() {
        DiagnoseLogContext b = DiagnoseLogContext.b();
        b.c.execute(new c(b));
    }

    public static void init(Application application) {
        init(application, null);
    }

    public static void setEnabled(boolean z) {
        DiagnoseLogContext.b().e = z;
    }

    public static void setOnLogUploadListener(OnLogUploadListener onLogUploadListener2) {
        onLogUploadListener = onLogUploadListener2;
    }

    public static void upload(String str) {
        DiagnoseLogContext b = DiagnoseLogContext.b();
        b.c.execute(new a(b, str));
    }

    public static void init(Application application, String str) {
        DiagnoseLogContext.j = new DiagnoseLogContext(application, str);
        ACConfig.addSectionConfigChangeListener("diagnose", DiagnoseLogContext.b());
    }

    public static void upload(Date date) {
        DiagnoseLogContext b = DiagnoseLogContext.b();
        b.c.execute(new b(b, date, onLogUploadListener));
    }
}

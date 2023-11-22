package com.iap.ac.android.diagnoselog.a;

import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage;

/* loaded from: classes8.dex */
public class c implements Runnable {
    public c(DiagnoseLogContext diagnoseLogContext) {
    }

    @Override // java.lang.Runnable
    public void run() {
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a();
    }
}

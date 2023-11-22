package com.iap.ac.android.diagnoselog.b;

import com.iap.ac.android.diagnoselog.core.UserDiagnosing;
import com.iap.ac.android.diagnoselog.upload.OSSUploader;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f7567a;
    public final /* synthetic */ UserDiagnosing.DiagnoseTask b;
    public final /* synthetic */ OSSUploader c;

    public a(OSSUploader oSSUploader, File file, UserDiagnosing.DiagnoseTask diagnoseTask) {
        this.c = oSSUploader;
        this.f7567a = file;
        this.b = diagnoseTask;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        while (i < 3) {
            if (this.c.a(this.f7567a, this.b, i == 2)) {
                return;
            }
            if (i <= 1) {
                try {
                    TimeUnit.SECONDS.sleep((i + 1) * 30);
                } catch (InterruptedException unused) {
                }
            }
            i++;
        }
    }
}

package com.uc.crashsdk;

import android.os.Handler;

/* loaded from: classes8.dex */
final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CrashLogFilesUploader f7730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(CrashLogFilesUploader crashLogFilesUploader) {
        this.f7730a = crashLogFilesUploader;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        try {
            CrashLogFilesUploader.a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        handler = this.f7730a.f7698a;
        handler.sendEmptyMessage(0);
    }
}

package com.uc.crashsdk;

import android.os.Handler;
import android.os.Message;
import android.os.Process;

/* loaded from: classes8.dex */
final class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CrashLogFilesUploader f7729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CrashLogFilesUploader crashLogFilesUploader) {
        this.f7729a = crashLogFilesUploader;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 0) {
            com.uc.crashsdk.a.c.b("Crash log upload service done, exiting");
            this.f7729a.stopSelf();
            Process.killProcess(Process.myPid());
        }
    }
}

package com.xiaomi.mipush.sdk;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class t implements Runnable {
    final /* synthetic */ Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Context context) {
        this.getAuthRequestContext = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MessageHandleService.c(this.getAuthRequestContext);
    }
}

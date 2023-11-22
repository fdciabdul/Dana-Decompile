package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ad implements Runnable {
    final /* synthetic */ Context MyBillsEntityDataFactory;
    final /* synthetic */ Intent getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Context context, Intent intent) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PushMessageHandler.b(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }
}

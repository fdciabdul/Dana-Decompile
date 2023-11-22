package com.alipay.mobile.rome.syncsdk.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class i implements ThreadFactory {
    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(byte b) {
        this();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("sync_receive:");
        sb.append(thread.getId());
        thread.setName(sb.toString());
        thread.setPriority(5);
        return thread;
    }
}

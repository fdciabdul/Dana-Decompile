package com.alipay.mobile.rome.syncsdk.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class h implements ThreadFactory {
    private h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(byte b) {
        this();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder sb = new StringBuilder("sync_dispatch:");
        sb.append(thread.getId());
        thread.setName(sb.toString());
        thread.setPriority(5);
        return thread;
    }
}

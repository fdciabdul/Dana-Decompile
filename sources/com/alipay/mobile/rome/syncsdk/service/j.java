package com.alipay.mobile.rome.syncsdk.service;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class j implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("longlink_timer");
        return thread;
    }
}

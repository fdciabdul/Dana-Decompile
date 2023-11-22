package com.alipay.mobile.rome.syncsdk.service;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f7232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f7232a = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "Link_task_executor");
        thread.setDaemon(true);
        return thread;
    }
}

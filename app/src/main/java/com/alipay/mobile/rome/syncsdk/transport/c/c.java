package com.alipay.mobile.rome.syncsdk.transport.c;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f7244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f7244a = bVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "longlink dispatcher");
    }
}

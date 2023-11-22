package fsimpl;

import java.util.concurrent.ThreadFactory;

/* renamed from: fsimpl.ew  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class ThreadFactoryC0352ew implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new eN(runnable, "fs-background-pool");
    }
}

package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
abstract class zaav implements Runnable {
    final /* synthetic */ zaaw zab;

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        zabi zabiVar;
        Lock lock2;
        Lock lock3;
        lock = this.zab.zab;
        lock.lock();
        try {
            try {
                if (Thread.interrupted()) {
                    lock2 = this.zab.zab;
                } else {
                    zaa();
                    lock2 = this.zab.zab;
                }
            } catch (RuntimeException e) {
                zabiVar = this.zab.zaa;
                zabiVar.zam(e);
                lock2 = this.zab.zab;
            }
            lock2.unlock();
        } catch (Throwable th) {
            lock3 = this.zab.zab;
            lock3.unlock();
            throw th;
        }
    }

    protected abstract void zaa();
}

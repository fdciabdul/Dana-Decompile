package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
abstract class zabg {
    private final zabf zaa;

    /* JADX INFO: Access modifiers changed from: protected */
    public zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    protected abstract void zaa();

    public final void zab(zabi zabiVar) {
        Lock lock;
        Lock lock2;
        zabf zabfVar;
        Lock lock3;
        lock = zabiVar.zai;
        lock.lock();
        try {
            zabfVar = zabiVar.zan;
            if (zabfVar != this.zaa) {
                lock3 = zabiVar.zai;
            } else {
                zaa();
                lock3 = zabiVar.zai;
            }
            lock3.unlock();
        } catch (Throwable th) {
            lock2 = zabiVar.zai;
            lock2.unlock();
            throw th;
        }
    }
}

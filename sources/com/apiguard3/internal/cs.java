package com.apiguard3.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes7.dex */
public final class cs<V> implements Future<V> {
    private static int valueOf = 1;
    private static int values;
    private volatile V AGState;
    private final CountDownLatch APIGuard = new CountDownLatch(1);
    private volatile boolean getSharedInstance = false;

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        int i = values;
        valueOf = (i + 119) % 128;
        valueOf = (i + 79) % 128;
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        int i = valueOf;
        values = (i + 13) % 128;
        values = (i + 101) % 128;
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z;
        synchronized (this) {
            int i = values + 81;
            valueOf = i % 128;
            if (!(i % 2 != 0)) {
                throw null;
            }
            z = this.getSharedInstance;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException {
        V v;
        this.APIGuard.await();
        synchronized (this) {
            v = this.AGState;
        }
        return v;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        V v;
        if ((!this.APIGuard.await(j, timeUnit)) != false) {
            throw new TimeoutException();
        }
        synchronized (this) {
            v = this.AGState;
        }
        return v;
    }

    public final void valueOf(V v) {
        synchronized (this) {
            valueOf = (values + 123) % 128;
            this.AGState = v;
            this.getSharedInstance = true;
            this.APIGuard.countDown();
            int i = valueOf + 45;
            values = i % 128;
            if (!(i % 2 == 0)) {
                throw new NullPointerException();
            }
        }
    }
}

package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
final class DisposeOnCancel implements Future<Object> {
    final Disposable MyBillsEntityDataFactory;

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisposeOnCancel(Disposable disposable) {
        this.MyBillsEntityDataFactory = disposable;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.MyBillsEntityDataFactory.dispose();
        return false;
    }
}

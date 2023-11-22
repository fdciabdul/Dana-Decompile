package io.reactivex.internal.observers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes9.dex */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {
    final AtomicReference<Disposable> KClassImpl$Data$declaredNonStaticMembers$2;
    T MyBillsEntityDataFactory;
    Throwable getAuthRequestContext;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
    }

    public FutureSingleObserver() {
        super(1);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Disposable disposable;
        do {
            disposable = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return false;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable, DisposableHelper.DISPOSED));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.getAuthRequestContext();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.getAuthRequestContext;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.getAuthRequestContext();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2(j, timeUnit));
            }
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.getAuthRequestContext;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        this.MyBillsEntityDataFactory = t;
        LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable, this);
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = th;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable, this));
        countDown();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return isDone();
    }
}

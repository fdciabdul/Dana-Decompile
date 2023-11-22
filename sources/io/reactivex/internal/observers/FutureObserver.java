package io.reactivex.internal.observers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {
    final AtomicReference<Disposable> BuiltInFictitiousFunctionClassFactory;
    T MyBillsEntityDataFactory;
    Throwable getAuthRequestContext;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
    }

    public FutureObserver() {
        super(1);
        this.BuiltInFictitiousFunctionClassFactory = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Disposable disposable;
        do {
            disposable = this.BuiltInFictitiousFunctionClassFactory.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return false;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, disposable, DisposableHelper.DISPOSED));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed(this.BuiltInFictitiousFunctionClassFactory.get());
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

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.BuiltInFictitiousFunctionClassFactory, disposable);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (this.MyBillsEntityDataFactory != null) {
            this.BuiltInFictitiousFunctionClassFactory.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.MyBillsEntityDataFactory = t;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        Disposable disposable;
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = th;
            do {
                disposable = this.BuiltInFictitiousFunctionClassFactory.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.PlaceComponentResult(th);
                    return;
                }
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, disposable, this));
            countDown();
            return;
        }
        RxJavaPlugins.PlaceComponentResult(th);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        Disposable disposable;
        if (this.MyBillsEntityDataFactory == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = this.BuiltInFictitiousFunctionClassFactory.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, disposable, this));
        countDown();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return isDone();
    }
}

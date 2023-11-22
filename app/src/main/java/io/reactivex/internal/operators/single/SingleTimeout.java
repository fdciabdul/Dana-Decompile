package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class SingleTimeout<T> extends Single<T> {
    final long BuiltInFictitiousFunctionClassFactory;
    final TimeUnit KClassImpl$Data$declaredNonStaticMembers$2;
    final SingleSource<T> MyBillsEntityDataFactory;
    final SingleSource<? extends T> PlaceComponentResult = null;
    final Scheduler getAuthRequestContext;

    public SingleTimeout(SingleSource<T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.MyBillsEntityDataFactory = singleSource;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = timeUnit;
        this.getAuthRequestContext = scheduler;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.getAuthRequestContext.scheduleDirect(timeoutMainObserver, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2));
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(timeoutMainObserver);
    }

    /* loaded from: classes6.dex */
    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;
        final SingleObserver<? super T> downstream;
        final TimeoutFallbackObserver<T> fallback;
        SingleSource<? extends T> other;
        final AtomicReference<Disposable> task = new AtomicReference<>();
        final long timeout;
        final TimeUnit unit;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            final SingleObserver<? super T> downstream;

            TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.downstream = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public final void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }

            @Override // io.reactivex.SingleObserver
            public final void onError(Throwable th) {
                this.downstream.onError(th);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit) {
            this.downstream = singleObserver;
            this.other = singleSource;
            this.timeout = j;
            this.unit = timeUnit;
            if (singleSource != null) {
                this.fallback = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.fallback = null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Disposable disposable = get();
            if (disposable == DisposableHelper.DISPOSED || !compareAndSet(disposable, DisposableHelper.DISPOSED)) {
                return;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            SingleSource<? extends T> singleSource = this.other;
            if (singleSource == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.timeout, this.unit)));
                return;
            }
            this.other = null;
            singleSource.MyBillsEntityDataFactory(this.fallback);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            Disposable disposable = get();
            if (disposable == DisposableHelper.DISPOSED || !compareAndSet(disposable, DisposableHelper.DISPOSED)) {
                return;
            }
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t);
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            Disposable disposable = get();
            if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, DisposableHelper.DISPOSED)) {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }
}

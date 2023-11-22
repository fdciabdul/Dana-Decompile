package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> BuiltInFictitiousFunctionClassFactory;
    final long KClassImpl$Data$declaredNonStaticMembers$2;
    final TimeUnit MyBillsEntityDataFactory;
    final Scheduler PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface TimeoutSupport {
        void onTimeout(long j);
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.MyBillsEntityDataFactory = timeUnit;
        this.PlaceComponentResult = scheduler;
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult.createWorker());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.startTimeout(0L);
            this.getAuthRequestContext.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.PlaceComponentResult.createWorker(), this.BuiltInFictitiousFunctionClassFactory);
        observer.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.startTimeout(0L);
        this.getAuthRequestContext.subscribe(timeoutFallbackObserver);
    }

    /* loaded from: classes6.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> downstream;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            long j = get();
            if (j != LongCompanionObject.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        final void startTimeout(long j) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public final void onTimeout(long j) {
            if (compareAndSet(j, LongCompanionObject.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class TimeoutTask implements Runnable {
        final TimeoutSupport KClassImpl$Data$declaredNonStaticMembers$2;
        final long getAuthRequestContext;

        TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.getAuthRequestContext = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onTimeout(this.getAuthRequestContext);
        }
    }

    /* loaded from: classes6.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> downstream;
        ObservableSource<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final Scheduler.Worker worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        TimeoutFallbackObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker;
            this.fallback = observableSource;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            long j = this.index.get();
            if (j != LongCompanionObject.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        final void startTimeout(long j) {
            this.task.replace(this.worker.schedule(new TimeoutTask(j, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.index.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.index.getAndSet(LongCompanionObject.MAX_VALUE) != LongCompanionObject.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public final void onTimeout(long j) {
            if (this.index.compareAndSet(j, LongCompanionObject.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                ObservableSource<? extends T> observableSource = this.fallback;
                this.fallback = null;
                observableSource.subscribe(new FallbackObserver(this.downstream, this));
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }
    }

    /* loaded from: classes6.dex */
    static final class FallbackObserver<T> implements Observer<T> {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        final AtomicReference<Disposable> PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.PlaceComponentResult = atomicReference;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.PlaceComponentResult, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<?> BuiltInFictitiousFunctionClassFactory;
    final boolean PlaceComponentResult;

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
        this.PlaceComponentResult = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.PlaceComponentResult) {
            this.getAuthRequestContext.subscribe(new SampleMainEmitLast(serializedObserver, this.BuiltInFictitiousFunctionClassFactory));
        } else {
            this.getAuthRequestContext.subscribe(new SampleMainNoLast(serializedObserver, this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    /* loaded from: classes9.dex */
    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        final ObservableSource<?> sampler;
        Disposable upstream;

        abstract void completion();

        abstract void run();

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.downstream = observer;
            this.sampler = observableSource;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new SamplerObserver(this));
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completion();
        }

        boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        public void error(Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> PlaceComponentResult;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.PlaceComponentResult = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.PlaceComponentResult.setOther(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            this.PlaceComponentResult.run();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.PlaceComponentResult.error(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.PlaceComponentResult.complete();
        }
    }

    /* loaded from: classes9.dex */
    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        final void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        final void run() {
            emit();
        }
    }

    /* loaded from: classes9.dex */
    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        final void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        final void run() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            do {
                boolean z = this.done;
                emit();
                if (z) {
                    this.downstream.onComplete();
                    return;
                }
            } while (this.wip.decrementAndGet() != 0);
        }
    }
}

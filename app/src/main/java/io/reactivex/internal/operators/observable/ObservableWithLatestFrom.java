package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final ObservableSource<? extends U> BuiltInFictitiousFunctionClassFactory;
    final BiFunction<? super T, ? super U, ? extends R> PlaceComponentResult;

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.PlaceComponentResult = biFunction;
        this.BuiltInFictitiousFunctionClassFactory = observableSource2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.PlaceComponentResult);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.getAuthRequestContext.subscribe(withLatestFromObserver);
    }

    /* loaded from: classes9.dex */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final Observer<? super R> downstream;
        final AtomicReference<Disposable> upstream = new AtomicReference<>();
        final AtomicReference<Disposable> other = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.downstream = observer;
            this.combiner = biFunction;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(ObjectHelper.PlaceComponentResult(this.combiner.apply(t, u), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public final boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }

        public final void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th);
        }
    }

    /* loaded from: classes9.dex */
    final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> BuiltInFictitiousFunctionClassFactory;

        @Override // io.reactivex.Observer
        public final void onComplete() {
        }

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.BuiltInFictitiousFunctionClassFactory = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory.setOther(disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            this.BuiltInFictitiousFunctionClassFactory.lazySet(u);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.otherError(th);
        }
    }
}

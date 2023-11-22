package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(PlaceComponentResult), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.getAuthRequestContext.subscribe(new SourceObserver(PlaceComponentResult, targetObserver));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class SourceObserver<T, R> implements Observer<T> {
        final PublishSubject<T> MyBillsEntityDataFactory;
        final AtomicReference<Disposable> PlaceComponentResult;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.MyBillsEntityDataFactory = publishSubject;
            this.PlaceComponentResult = atomicReference;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.PlaceComponentResult, disposable);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }
    }

    /* loaded from: classes9.dex */
    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        final Observer<? super R> downstream;
        Disposable upstream;

        TargetObserver(Observer<? super R> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}

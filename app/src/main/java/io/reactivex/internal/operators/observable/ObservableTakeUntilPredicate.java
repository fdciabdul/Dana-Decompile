package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableTakeUntilPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> BuiltInFictitiousFunctionClassFactory;

    public ObservableTakeUntilPredicate(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new TakeUntilPredicateObserver(observer, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class TakeUntilPredicateObserver<T> implements Observer<T>, Disposable {
        final Predicate<? super T> BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final Observer<? super T> getAuthRequestContext;

        TakeUntilPredicateObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.getAuthRequestContext = observer;
            this.BuiltInFictitiousFunctionClassFactory = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            this.getAuthRequestContext.onNext(t);
            try {
                if (this.BuiltInFictitiousFunctionClassFactory.test(t)) {
                    this.PlaceComponentResult = true;
                    this.MyBillsEntityDataFactory.dispose();
                    this.getAuthRequestContext.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (!this.PlaceComponentResult) {
                this.PlaceComponentResult = true;
                this.getAuthRequestContext.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.getAuthRequestContext.onComplete();
        }
    }
}

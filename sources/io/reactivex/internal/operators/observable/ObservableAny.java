package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes9.dex */
public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> PlaceComponentResult;

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.PlaceComponentResult = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Boolean> observer) {
        this.getAuthRequestContext.subscribe(new AnyObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class AnyObserver<T> implements Observer<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        Disposable MyBillsEntityDataFactory;
        final Observer<? super Boolean> PlaceComponentResult;
        final Predicate<? super T> getAuthRequestContext;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.PlaceComponentResult = observer;
            this.getAuthRequestContext = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    this.BuiltInFictitiousFunctionClassFactory = true;
                    this.MyBillsEntityDataFactory.dispose();
                    this.PlaceComponentResult.onNext(Boolean.TRUE);
                    this.PlaceComponentResult.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.MyBillsEntityDataFactory.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.PlaceComponentResult.onNext(Boolean.FALSE);
            this.PlaceComponentResult.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory.isDisposed();
        }
    }
}

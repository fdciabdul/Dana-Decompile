package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> MyBillsEntityDataFactory;

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.MyBillsEntityDataFactory = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new TakeWhileObserver(observer, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> BuiltInFictitiousFunctionClassFactory;
        final Predicate<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean PlaceComponentResult;
        Disposable getAuthRequestContext;

        TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            try {
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2.test(t)) {
                    this.PlaceComponentResult = true;
                    this.getAuthRequestContext.dispose();
                    this.BuiltInFictitiousFunctionClassFactory.onComplete();
                    return;
                }
                this.BuiltInFictitiousFunctionClassFactory.onNext(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes6.dex */
public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> MyBillsEntityDataFactory;

    public ObservableAll(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.MyBillsEntityDataFactory = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Boolean> observer) {
        this.getAuthRequestContext.subscribe(new AllObserver(observer, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class AllObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;

        AllObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.MyBillsEntityDataFactory = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                if (this.MyBillsEntityDataFactory.test(t)) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.PlaceComponentResult.dispose();
                this.BuiltInFictitiousFunctionClassFactory.onNext(Boolean.FALSE);
                this.BuiltInFictitiousFunctionClassFactory.onComplete();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.PlaceComponentResult.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory.onNext(Boolean.TRUE);
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }
    }
}

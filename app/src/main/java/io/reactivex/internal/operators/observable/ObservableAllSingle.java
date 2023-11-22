package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final Predicate<? super T> BuiltInFictitiousFunctionClassFactory;
    final ObservableSource<T> MyBillsEntityDataFactory;

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.MyBillsEntityDataFactory = observableSource;
        this.BuiltInFictitiousFunctionClassFactory = predicate;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.MyBillsEntityDataFactory.subscribe(new AllObserver(singleObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<Boolean> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAll(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class AllObserver<T> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        boolean MyBillsEntityDataFactory;
        final SingleObserver<? super Boolean> PlaceComponentResult;
        final Predicate<? super T> getAuthRequestContext;

        AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.PlaceComponentResult = singleObserver;
            this.getAuthRequestContext = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    return;
                }
                this.MyBillsEntityDataFactory = true;
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                this.PlaceComponentResult.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }
    }
}

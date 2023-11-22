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
public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;
    final Predicate<? super T> PlaceComponentResult;

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.PlaceComponentResult = predicate;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new AnyObserver(singleObserver, this.PlaceComponentResult));
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<Boolean> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableAny(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class AnyObserver<T> implements Observer<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        Disposable KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> MyBillsEntityDataFactory;
        final SingleObserver<? super Boolean> getAuthRequestContext;

        AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.getAuthRequestContext = singleObserver;
            this.MyBillsEntityDataFactory = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, disposable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = disposable;
                this.getAuthRequestContext.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            try {
                if (this.MyBillsEntityDataFactory.test(t)) {
                    this.BuiltInFictitiousFunctionClassFactory = true;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
                    this.getAuthRequestContext.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
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
            this.getAuthRequestContext.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.getAuthRequestContext.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {
    final ObservableSource<T> BuiltInFictitiousFunctionClassFactory;
    final Callable<U> PlaceComponentResult;

    public ObservableToListSingle(ObservableSource<T> observableSource, int i) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.PlaceComponentResult = Functions.getAuthRequestContext(i);
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.BuiltInFictitiousFunctionClassFactory = observableSource;
        this.PlaceComponentResult = callable;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super U> singleObserver) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<U> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableToList(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes6.dex */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        U KClassImpl$Data$declaredNonStaticMembers$2;
        final SingleObserver<? super U> MyBillsEntityDataFactory;

        ToListObserver(SingleObserver<? super U> singleObserver, U u) {
            this.MyBillsEntityDataFactory = singleObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.BuiltInFictitiousFunctionClassFactory, disposable)) {
                this.BuiltInFictitiousFunctionClassFactory = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U u = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.MyBillsEntityDataFactory.onSuccess(u);
        }
    }
}

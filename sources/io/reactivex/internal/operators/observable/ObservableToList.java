package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> KClassImpl$Data$declaredNonStaticMembers$2;

    public ObservableToList(ObservableSource<T> observableSource) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Functions.getAuthRequestContext(16);
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        try {
            this.getAuthRequestContext.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes6.dex */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> BuiltInFictitiousFunctionClassFactory;
        U KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable MyBillsEntityDataFactory;

        ToListObserver(Observer<? super U> observer, U u) {
            this.BuiltInFictitiousFunctionClassFactory = observer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.MyBillsEntityDataFactory, disposable)) {
                this.MyBillsEntityDataFactory = disposable;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
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
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(t);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U u = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.BuiltInFictitiousFunctionClassFactory.onNext(u);
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }
    }
}

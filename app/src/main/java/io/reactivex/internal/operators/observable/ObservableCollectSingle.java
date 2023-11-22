package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
    final Callable<? extends U> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiConsumer<? super U, ? super T> MyBillsEntityDataFactory;
    final ObservableSource<T> getAuthRequestContext;

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.getAuthRequestContext = observableSource;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
        this.MyBillsEntityDataFactory = biConsumer;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super U> singleObserver) {
        try {
            this.getAuthRequestContext.subscribe(new CollectObserver(singleObserver, ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.call(), "The initialSupplier returned a null value"), this.MyBillsEntityDataFactory));
        } catch (Throwable th) {
            EmptyDisposable.error(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<U> getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ObservableCollect(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super U> KClassImpl$Data$declaredNonStaticMembers$2;
        final U MyBillsEntityDataFactory;
        final BiConsumer<? super U, ? super T> PlaceComponentResult;
        Disposable getAuthRequestContext;

        CollectObserver(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.PlaceComponentResult = biConsumer;
            this.MyBillsEntityDataFactory = u;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.getAuthRequestContext, disposable)) {
                this.getAuthRequestContext = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
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
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            try {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((U) this.MyBillsEntityDataFactory, t);
            } catch (Throwable th) {
                this.getAuthRequestContext.dispose();
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
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess((U) this.MyBillsEntityDataFactory);
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends U> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiConsumer<? super U, ? super T> PlaceComponentResult;

    public ObservableCollect(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(observableSource);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callable;
        this.PlaceComponentResult = biConsumer;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        try {
            this.getAuthRequestContext.subscribe(new CollectObserver(observer, ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.call(), "The initialSupplier returned a null value"), this.PlaceComponentResult));
        } catch (Throwable th) {
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final BiConsumer<? super U, ? super T> BuiltInFictitiousFunctionClassFactory;
        final U KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super U> MyBillsEntityDataFactory;
        Disposable PlaceComponentResult;
        boolean getAuthRequestContext;

        CollectObserver(Observer<? super U> observer, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.MyBillsEntityDataFactory = observer;
            this.BuiltInFictitiousFunctionClassFactory = biConsumer;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = u;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.PlaceComponentResult, disposable)) {
                this.PlaceComponentResult = disposable;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((U) this.KClassImpl$Data$declaredNonStaticMembers$2, t);
            } catch (Throwable th) {
                this.PlaceComponentResult.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            this.MyBillsEntityDataFactory.onNext((U) this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.MyBillsEntityDataFactory.onComplete();
        }
    }
}

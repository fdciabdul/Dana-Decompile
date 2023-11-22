package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Callable<? extends Collection<? super K>> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, K> MyBillsEntityDataFactory;

    public ObservableDistinct(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.MyBillsEntityDataFactory = function;
        this.BuiltInFictitiousFunctionClassFactory = callable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        try {
            this.getAuthRequestContext.subscribe(new DistinctObserver(observer, this.MyBillsEntityDataFactory, (Collection) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, observer);
        }
    }

    /* loaded from: classes9.dex */
    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Function<? super T, K> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Collection<? super K> getErrorConfigVersion;

        DistinctObserver(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = function;
            this.getErrorConfigVersion = collection;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            if (this.BuiltInFictitiousFunctionClassFactory == 0) {
                try {
                    if (this.getErrorConfigVersion.add(ObjectHelper.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(t), "The keySelector returned a null key"))) {
                        this.MyBillsEntityDataFactory.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    MyBillsEntityDataFactory(th);
                    return;
                }
            }
            this.MyBillsEntityDataFactory.onNext(null);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.getErrorConfigVersion.clear();
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public final void onComplete() {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            this.getErrorConfigVersion.clear();
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll;
            do {
                poll = this.getAuthRequestContext.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.getErrorConfigVersion.add((Object) ObjectHelper.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.getErrorConfigVersion.clear();
            super.clear();
        }
    }
}

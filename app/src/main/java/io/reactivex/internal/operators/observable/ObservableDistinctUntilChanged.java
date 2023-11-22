package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super K, ? super K> MyBillsEntityDataFactory;
    final Function<? super T, K> PlaceComponentResult;

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.PlaceComponentResult = function;
        this.MyBillsEntityDataFactory = biPredicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DistinctUntilChangedObserver(observer, this.PlaceComponentResult, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final BiPredicate<? super K, ? super K> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Function<? super T, K> getErrorConfigVersion;
        K moveToNextValue;
        boolean scheduleImpl;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.getErrorConfigVersion = function;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = biPredicate;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            if (this.BuiltInFictitiousFunctionClassFactory != 0) {
                this.MyBillsEntityDataFactory.onNext(t);
                return;
            }
            try {
                K apply = this.getErrorConfigVersion.apply(t);
                if (this.scheduleImpl) {
                    boolean BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory((K) this.moveToNextValue, apply);
                    this.moveToNextValue = apply;
                    if (BuiltInFictitiousFunctionClassFactory) {
                        return;
                    }
                } else {
                    this.scheduleImpl = true;
                    this.moveToNextValue = apply;
                }
                this.MyBillsEntityDataFactory.onNext(t);
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            while (true) {
                T poll = this.getAuthRequestContext.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.getErrorConfigVersion.apply(poll);
                if (!this.scheduleImpl) {
                    this.scheduleImpl = true;
                    this.moveToNextValue = apply;
                    return poll;
                } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory((K) this.moveToNextValue, apply)) {
                    this.moveToNextValue = apply;
                    return poll;
                } else {
                    this.moveToNextValue = apply;
                }
            }
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> BuiltInFictitiousFunctionClassFactory;

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = function;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        this.getAuthRequestContext.subscribe(new MapObserver(observer, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> lookAheadTest;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.lookAheadTest = function;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            if (this.BuiltInFictitiousFunctionClassFactory != 0) {
                this.MyBillsEntityDataFactory.onNext(null);
                return;
            }
            try {
                this.MyBillsEntityDataFactory.onNext(ObjectHelper.PlaceComponentResult(this.lookAheadTest.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final U poll() throws Exception {
            T poll = this.getAuthRequestContext.poll();
            if (poll != null) {
                return (U) ObjectHelper.PlaceComponentResult(this.lookAheadTest.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}

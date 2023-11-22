package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> PlaceComponentResult;

    public ObservableDoAfterNext(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.PlaceComponentResult = consumer;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new DoAfterObserver(observer, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
        final Consumer<? super T> scheduleImpl;

        DoAfterObserver(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.scheduleImpl = consumer;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
            if (this.BuiltInFictitiousFunctionClassFactory == 0) {
                try {
                    this.scheduleImpl.accept(t);
                } catch (Throwable th) {
                    MyBillsEntityDataFactory(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll = this.getAuthRequestContext.poll();
            if (poll != null) {
                this.scheduleImpl.accept(poll);
            }
            return poll;
        }
    }
}

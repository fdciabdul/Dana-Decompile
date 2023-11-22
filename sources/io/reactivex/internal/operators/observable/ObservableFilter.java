package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes2.dex */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> BuiltInFictitiousFunctionClassFactory;

    public ObservableFilter(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.BuiltInFictitiousFunctionClassFactory = predicate;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.getAuthRequestContext.subscribe(new FilterObserver(observer, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes6.dex */
    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {
        final Predicate<? super T> lookAheadTest;

        FilterObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.lookAheadTest = predicate;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory == 0) {
                try {
                    if (this.lookAheadTest.test(t)) {
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
            } while (!this.lookAheadTest.test(poll));
            return poll;
        }
    }
}

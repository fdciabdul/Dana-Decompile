package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> KClassImpl$Data$declaredNonStaticMembers$2;

    public FlowableFromObservable(Observable<T> observable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = observable;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.subscribe(new SubscriberObserver(subscriber));
    }

    /* loaded from: classes6.dex */
    static final class SubscriberObserver<T> implements Observer<T>, Subscription {
        final Subscriber<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        Disposable PlaceComponentResult;

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = subscriber;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.PlaceComponentResult = disposable;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.PlaceComponentResult.dispose();
        }
    }
}

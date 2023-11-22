package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {
    private final T MyBillsEntityDataFactory;

    public FlowableJust(T t) {
        this.MyBillsEntityDataFactory = t;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.MyBillsEntityDataFactory));
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public final T call() {
        return this.MyBillsEntityDataFactory;
    }
}

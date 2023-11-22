package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {
    final CompletableSource MyBillsEntityDataFactory;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new SubscriberCompletableObserver(subscriber));
    }
}

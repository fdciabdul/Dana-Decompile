package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {
    final Publisher<? extends T> getAuthRequestContext;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.getAuthRequestContext = publisher;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.getAuthRequestContext.subscribe(subscriber);
    }
}

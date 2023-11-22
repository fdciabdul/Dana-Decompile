package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {
    final long BuiltInFictitiousFunctionClassFactory = 1;
    final Publisher<T> getAuthRequestContext;

    public FlowableTakePublisher(Publisher<T> publisher) {
        this.getAuthRequestContext = publisher;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.getAuthRequestContext.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.BuiltInFictitiousFunctionClassFactory));
    }
}

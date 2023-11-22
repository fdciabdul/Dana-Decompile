package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    final Publisher<T> BuiltInFictitiousFunctionClassFactory;
    final Function<? super T, ? extends U> MyBillsEntityDataFactory;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.BuiltInFictitiousFunctionClassFactory = publisher;
        this.MyBillsEntityDataFactory = function;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new FlowableMap.MapSubscriber(subscriber, this.MyBillsEntityDataFactory));
    }
}

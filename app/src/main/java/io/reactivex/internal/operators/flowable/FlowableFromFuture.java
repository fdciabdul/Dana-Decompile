package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {
    final long BuiltInFictitiousFunctionClassFactory = 0;
    final TimeUnit MyBillsEntityDataFactory = null;
    final Future<? extends T> getAuthRequestContext;

    public FlowableFromFuture(Future<? extends T> future) {
        this.getAuthRequestContext = future;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.MyBillsEntityDataFactory;
            T t = timeUnit != null ? this.getAuthRequestContext.get(this.BuiltInFictitiousFunctionClassFactory, timeUnit) : this.getAuthRequestContext.get();
            if (t == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(t);
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (deferredScalarSubscription.isCancelled()) {
                return;
            }
            subscriber.onError(th);
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {
    final Callable<? extends T> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.complete(ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            if (deferredScalarSubscription.isCancelled()) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                subscriber.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final T call() throws Exception {
        return (T) ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The callable returned a null value");
    }
}

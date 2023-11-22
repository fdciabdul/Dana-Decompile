package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes6.dex */
public final class FlowableScalarXMap {
    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean getAuthRequestContext(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (publisher instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) publisher).call();
                if (obj == 0) {
                    EmptySubscription.complete(subscriber);
                    return true;
                }
                try {
                    Publisher publisher2 = (Publisher) ObjectHelper.PlaceComponentResult(function.apply(obj), "The mapper returned a null Publisher");
                    if (publisher2 instanceof Callable) {
                        try {
                            Object call = ((Callable) publisher2).call();
                            if (call == null) {
                                EmptySubscription.complete(subscriber);
                                return true;
                            }
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                        } catch (Throwable th) {
                            Exceptions.MyBillsEntityDataFactory(th);
                            EmptySubscription.error(th, subscriber);
                            return true;
                        }
                    } else {
                        publisher2.subscribe(subscriber);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    EmptySubscription.error(th2, subscriber);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                EmptySubscription.error(th3, subscriber);
                return true;
            }
        }
        return false;
    }

    public static <T, U> Flowable<U> BuiltInFictitiousFunctionClassFactory(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.getAuthRequestContext(new ScalarXMapFlowable(t, function));
    }

    /* loaded from: classes6.dex */
    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> KClassImpl$Data$declaredNonStaticMembers$2;
        final T MyBillsEntityDataFactory;

        ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.MyBillsEntityDataFactory = t;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
        }

        @Override // io.reactivex.Flowable
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply((T) this.MyBillsEntityDataFactory), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                            return;
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                }
                publisher.subscribe(subscriber);
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final BiFunction<? super T, ? super U, ? extends V> MyBillsEntityDataFactory;
    final Iterable<U> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super V> subscriber) {
        try {
            Iterator it = (Iterator) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ZipIterableSubscriber(subscriber, it, this.MyBillsEntityDataFactory));
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.MyBillsEntityDataFactory(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }

    /* loaded from: classes9.dex */
    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final BiFunction<? super T, ? super U, ? extends V> KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final Subscriber<? super V> PlaceComponentResult;
        final Iterator<U> getAuthRequestContext;

        ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.PlaceComponentResult = subscriber;
            this.getAuthRequestContext = it;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.PlaceComponentResult.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            try {
                try {
                    this.PlaceComponentResult.onNext(ObjectHelper.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.apply(t, ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.getAuthRequestContext.hasNext()) {
                            return;
                        }
                        this.MyBillsEntityDataFactory = true;
                        this.BuiltInFictitiousFunctionClassFactory.cancel();
                        this.PlaceComponentResult.onComplete();
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        this.MyBillsEntityDataFactory = true;
                        this.BuiltInFictitiousFunctionClassFactory.cancel();
                        this.PlaceComponentResult.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    this.MyBillsEntityDataFactory = true;
                    this.BuiltInFictitiousFunctionClassFactory.cancel();
                    this.PlaceComponentResult.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.MyBillsEntityDataFactory(th3);
                this.MyBillsEntityDataFactory = true;
                this.BuiltInFictitiousFunctionClassFactory.cancel();
                this.PlaceComponentResult.onError(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.PlaceComponentResult.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.BuiltInFictitiousFunctionClassFactory.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
        }
    }
}

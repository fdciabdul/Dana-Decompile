package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ScanSubscriber(subscriber, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        T MyBillsEntityDataFactory;
        final BiFunction<T, T, T> PlaceComponentResult;
        Subscription getAuthRequestContext;

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.BuiltInFictitiousFunctionClassFactory = subscriber;
            this.PlaceComponentResult = biFunction;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            Subscriber<? super T> subscriber = this.BuiltInFictitiousFunctionClassFactory;
            T t2 = this.MyBillsEntityDataFactory;
            if (t2 == null) {
                this.MyBillsEntityDataFactory = t;
                subscriber.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t2, t), "The value returned by the accumulator is null");
                this.MyBillsEntityDataFactory = r4;
                subscriber.onNext(r4);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            this.getAuthRequestContext.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.getAuthRequestContext.cancel();
        }
    }
}

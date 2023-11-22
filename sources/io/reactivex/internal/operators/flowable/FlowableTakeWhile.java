package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new TakeWhileSubscriber(subscriber, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> MyBillsEntityDataFactory;
        final Subscriber<? super T> PlaceComponentResult;

        TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.PlaceComponentResult = subscriber;
            this.MyBillsEntityDataFactory = predicate;
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
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                if (!this.MyBillsEntityDataFactory.test(t)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    this.BuiltInFictitiousFunctionClassFactory.cancel();
                    this.PlaceComponentResult.onComplete();
                    return;
                }
                this.PlaceComponentResult.onNext(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.cancel();
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
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
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

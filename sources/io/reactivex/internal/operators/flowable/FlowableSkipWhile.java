package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new SkipWhileSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super T> MyBillsEntityDataFactory;
        final Predicate<? super T> getAuthRequestContext;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.MyBillsEntityDataFactory = subscriber;
            this.getAuthRequestContext = predicate;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                this.MyBillsEntityDataFactory.onNext(t);
                return;
            }
            try {
                if (this.getAuthRequestContext.test(t)) {
                    this.BuiltInFictitiousFunctionClassFactory.request(1L);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.MyBillsEntityDataFactory.onNext(t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.cancel();
                this.MyBillsEntityDataFactory.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
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

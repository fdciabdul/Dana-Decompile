package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.MyBillsEntityDataFactory));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FilterSubscriber(subscriber, this.MyBillsEntityDataFactory));
        }
    }

    /* loaded from: classes9.dex */
    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Predicate<? super T> KClassImpl$Data$declaredNonStaticMembers$2;

        FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.scheduleImpl.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.moveToNextValue) {
                return false;
            }
            if (this.getErrorConfigVersion != 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(null);
                return true;
            }
            try {
                boolean test = this.KClassImpl$Data$declaredNonStaticMembers$2.test(t);
                if (test) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                getAuthRequestContext(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return MyBillsEntityDataFactory(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.lookAheadTest;
            Predicate<? super T> predicate = this.KClassImpl$Data$declaredNonStaticMembers$2;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.getErrorConfigVersion == 2) {
                    queueSubscription.request(1L);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Predicate<? super T> PlaceComponentResult;

        FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(conditionalSubscriber);
            this.PlaceComponentResult = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.getErrorConfigVersion.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return false;
            }
            if (this.lookAheadTest != 0) {
                return this.moveToNextValue.tryOnNext(null);
            }
            try {
                return this.PlaceComponentResult.test(t) && this.moveToNextValue.tryOnNext(t);
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            QueueSubscription<T> queueSubscription = this.scheduleImpl;
            Predicate<? super T> predicate = this.PlaceComponentResult;
            while (true) {
                T poll = queueSubscription.poll();
                if (poll == null) {
                    return null;
                }
                if (predicate.test(poll)) {
                    return poll;
                }
                if (this.lookAheadTest == 2) {
                    queueSubscription.request(1L);
                }
            }
        }
    }
}

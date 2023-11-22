package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DoAfterSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes9.dex */
    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> getAuthRequestContext;

        DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            super(subscriber);
            this.getAuthRequestContext = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.moveToNextValue) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
            if (this.getErrorConfigVersion == 0) {
                try {
                    this.getAuthRequestContext.accept(t);
                } catch (Throwable th) {
                    getAuthRequestContext(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return MyBillsEntityDataFactory(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll = this.lookAheadTest.poll();
            if (poll != null) {
                this.getAuthRequestContext.accept(poll);
            }
            return poll;
        }
    }

    /* loaded from: classes9.dex */
    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> MyBillsEntityDataFactory;

        DoAfterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer) {
            super(conditionalSubscriber);
            this.MyBillsEntityDataFactory = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.moveToNextValue.onNext(t);
            if (this.lookAheadTest == 0) {
                try {
                    this.MyBillsEntityDataFactory.accept(t);
                } catch (Throwable th) {
                    MyBillsEntityDataFactory(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            boolean tryOnNext = this.moveToNextValue.tryOnNext(t);
            try {
                this.MyBillsEntityDataFactory.accept(t);
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
            }
            return tryOnNext;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll = this.scheduleImpl.poll();
            if (poll != null) {
                this.MyBillsEntityDataFactory.accept(poll);
            }
            return poll;
        }
    }
}

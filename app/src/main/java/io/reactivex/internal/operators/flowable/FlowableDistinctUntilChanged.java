package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiPredicate<? super K, ? super K> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DistinctUntilChangedSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
        }
    }

    /* loaded from: classes9.dex */
    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Function<? super T, K> BuiltInFictitiousFunctionClassFactory;
        K MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final BiPredicate<? super K, ? super K> getAuthRequestContext;

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.BuiltInFictitiousFunctionClassFactory = function;
            this.getAuthRequestContext = biPredicate;
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
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
                return true;
            }
            try {
                K apply = this.BuiltInFictitiousFunctionClassFactory.apply(t);
                if (this.PlaceComponentResult) {
                    boolean BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((K) this.MyBillsEntityDataFactory, apply);
                    this.MyBillsEntityDataFactory = apply;
                    if (BuiltInFictitiousFunctionClassFactory) {
                        return false;
                    }
                } else {
                    this.PlaceComponentResult = true;
                    this.MyBillsEntityDataFactory = apply;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
                return true;
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
            while (true) {
                T poll = this.lookAheadTest.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.BuiltInFictitiousFunctionClassFactory.apply(poll);
                if (!this.PlaceComponentResult) {
                    this.PlaceComponentResult = true;
                    this.MyBillsEntityDataFactory = apply;
                    return poll;
                } else if (!this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory((K) this.MyBillsEntityDataFactory, apply)) {
                    this.MyBillsEntityDataFactory = apply;
                    return poll;
                } else {
                    this.MyBillsEntityDataFactory = apply;
                    if (this.getErrorConfigVersion != 1) {
                        this.scheduleImpl.request(1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final BiPredicate<? super K, ? super K> KClassImpl$Data$declaredNonStaticMembers$2;
        K MyBillsEntityDataFactory;
        final Function<? super T, K> PlaceComponentResult;
        boolean getAuthRequestContext;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.PlaceComponentResult = function;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biPredicate;
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
                return this.moveToNextValue.tryOnNext(t);
            }
            try {
                K apply = this.PlaceComponentResult.apply(t);
                if (this.getAuthRequestContext) {
                    boolean BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((K) this.MyBillsEntityDataFactory, apply);
                    this.MyBillsEntityDataFactory = apply;
                    if (BuiltInFictitiousFunctionClassFactory) {
                        return false;
                    }
                } else {
                    this.getAuthRequestContext = true;
                    this.MyBillsEntityDataFactory = apply;
                }
                this.moveToNextValue.onNext(t);
                return true;
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
            while (true) {
                T poll = this.scheduleImpl.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.PlaceComponentResult.apply(poll);
                if (!this.getAuthRequestContext) {
                    this.getAuthRequestContext = true;
                    this.MyBillsEntityDataFactory = apply;
                    return poll;
                } else if (!this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((K) this.MyBillsEntityDataFactory, apply)) {
                    this.MyBillsEntityDataFactory = apply;
                    return poll;
                } else {
                    this.MyBillsEntityDataFactory = apply;
                    if (this.lookAheadTest != 1) {
                        this.getErrorConfigVersion.request(1L);
                    }
                }
            }
        }
    }
}

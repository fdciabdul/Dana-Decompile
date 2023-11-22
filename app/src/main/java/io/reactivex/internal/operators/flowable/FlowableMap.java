package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> KClassImpl$Data$declaredNonStaticMembers$2;

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new MapSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes9.dex */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.MyBillsEntityDataFactory = function;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.moveToNextValue) {
                return;
            }
            if (this.getErrorConfigVersion != 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(null);
                return;
            }
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                getAuthRequestContext(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return MyBillsEntityDataFactory(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final U poll() throws Exception {
            T poll = this.lookAheadTest.poll();
            if (poll != null) {
                return (U) ObjectHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* loaded from: classes9.dex */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> PlaceComponentResult;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.PlaceComponentResult = function;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            if (this.lookAheadTest != 0) {
                this.moveToNextValue.onNext(null);
                return;
            }
            try {
                this.moveToNextValue.onNext(ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                MyBillsEntityDataFactory(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public final boolean tryOnNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return false;
            }
            try {
                return this.moveToNextValue.tryOnNext(ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t), "The mapper function returned a null value."));
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
        public final U poll() throws Exception {
            T poll = this.scheduleImpl.poll();
            if (poll != null) {
                return (U) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}

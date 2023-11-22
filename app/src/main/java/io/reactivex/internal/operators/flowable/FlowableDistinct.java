package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> MyBillsEntityDataFactory;
    final Callable<? extends Collection<? super K>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new DistinctSubscriber(subscriber, this.MyBillsEntityDataFactory, (Collection) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    /* loaded from: classes9.dex */
    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {
        final Collection<? super K> PlaceComponentResult;
        final Function<? super T, K> getAuthRequestContext;

        DistinctSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, Collection<? super K> collection) {
            super(subscriber);
            this.getAuthRequestContext = function;
            this.PlaceComponentResult = collection;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.moveToNextValue) {
                return;
            }
            if (this.getErrorConfigVersion == 0) {
                try {
                    if (this.PlaceComponentResult.add(ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(t), "The keySelector returned a null key"))) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(t);
                        return;
                    } else {
                        this.scheduleImpl.request(1L);
                        return;
                    }
                } catch (Throwable th) {
                    getAuthRequestContext(th);
                    return;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(null);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.moveToNextValue) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.moveToNextValue = true;
            this.PlaceComponentResult.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.moveToNextValue) {
                return;
            }
            this.moveToNextValue = true;
            this.PlaceComponentResult.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.onComplete();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return MyBillsEntityDataFactory(i);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll;
            while (true) {
                poll = this.lookAheadTest.poll();
                if (poll == null || this.PlaceComponentResult.add((Object) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.apply(poll), "The keySelector returned a null key"))) {
                    break;
                } else if (this.getErrorConfigVersion == 2) {
                    this.scheduleImpl.request(1L);
                }
            }
            return poll;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.PlaceComponentResult.clear();
            super.clear();
        }
    }
}

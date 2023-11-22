package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {
    final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final BiFunction<T, T, T> PlaceComponentResult;

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableReduce(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult));
    }

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new ReduceSubscriber(maybeObserver, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        T BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final MaybeObserver<? super T> MyBillsEntityDataFactory;
        final BiFunction<T, T, T> PlaceComponentResult;
        Subscription getAuthRequestContext;

        ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.MyBillsEntityDataFactory = maybeObserver;
            this.PlaceComponentResult = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.cancel();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            T t2 = this.BuiltInFictitiousFunctionClassFactory;
            if (t2 == null) {
                this.BuiltInFictitiousFunctionClassFactory = t;
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory = (T) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(t2, t), "The reducer returned a null value");
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
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            T t = this.BuiltInFictitiousFunctionClassFactory;
            if (t != null) {
                this.MyBillsEntityDataFactory.onSuccess(t);
            } else {
                this.MyBillsEntityDataFactory.onComplete();
            }
        }
    }
}

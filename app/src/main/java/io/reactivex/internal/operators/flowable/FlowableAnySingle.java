package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Predicate<? super T> PlaceComponentResult;
    final Flowable<T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.getAuthRequestContext.getAuthRequestContext(new AnySubscriber(singleObserver, this.PlaceComponentResult));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableAny(this.getAuthRequestContext, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super Boolean> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> PlaceComponentResult;
        Subscription getAuthRequestContext;

        AnySubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
            this.PlaceComponentResult = predicate;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                if (this.PlaceComponentResult.test(t)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    this.getAuthRequestContext.cancel();
                    this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
                    this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.cancel();
                this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
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
            this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.getAuthRequestContext.cancel();
            this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.getAuthRequestContext == SubscriptionHelper.CANCELLED;
        }
    }
}

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
public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final Predicate<? super T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Boolean> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new AllSubscriber(singleObserver, this.getAuthRequestContext));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableAll(this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super Boolean> KClassImpl$Data$declaredNonStaticMembers$2;
        final Predicate<? super T> PlaceComponentResult;
        boolean getAuthRequestContext;

        AllSubscriber(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.PlaceComponentResult = predicate;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.getAuthRequestContext) {
                return;
            }
            try {
                if (this.PlaceComponentResult.test(t)) {
                    return;
                }
                this.getAuthRequestContext = true;
                this.BuiltInFictitiousFunctionClassFactory.cancel();
                this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.BuiltInFictitiousFunctionClassFactory.cancel();
                this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.getAuthRequestContext) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.getAuthRequestContext = true;
            this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.getAuthRequestContext) {
                return;
            }
            this.getAuthRequestContext = true;
            this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory.cancel();
            this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory == SubscriptionHelper.CANCELLED;
        }
    }
}

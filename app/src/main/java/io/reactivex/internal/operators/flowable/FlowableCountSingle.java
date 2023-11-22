package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {
    final Flowable<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super Long> singleObserver) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new CountSubscriber(singleObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<Long> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableCount(this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes9.dex */
    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        Subscription BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super Long> MyBillsEntityDataFactory;
        long getAuthRequestContext;

        CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.MyBillsEntityDataFactory = singleObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.BuiltInFictitiousFunctionClassFactory, subscription)) {
                this.BuiltInFictitiousFunctionClassFactory = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
            this.getAuthRequestContext++;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.BuiltInFictitiousFunctionClassFactory = SubscriptionHelper.CANCELLED;
            this.MyBillsEntityDataFactory.onSuccess(Long.valueOf(this.getAuthRequestContext));
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

package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> PlaceComponentResult;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.PlaceComponentResult.getAuthRequestContext(new IgnoreElementsSubscriber(completableObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableIgnoreElements(this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        Subscription MyBillsEntityDataFactory;
        final CompletableObserver getAuthRequestContext;

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
        }

        IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.getAuthRequestContext = completableObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.getAuthRequestContext.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.getAuthRequestContext.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory.cancel();
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory == SubscriptionHelper.CANCELLED;
        }
    }
}

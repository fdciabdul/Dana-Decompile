package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableLastMaybe<T> extends Maybe<T> {
    final Publisher<T> getAuthRequestContext;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.getAuthRequestContext.subscribe(new LastSubscriber(maybeObserver));
    }

    /* loaded from: classes9.dex */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        T KClassImpl$Data$declaredNonStaticMembers$2;
        Subscription MyBillsEntityDataFactory;
        final MaybeObserver<? super T> PlaceComponentResult;

        LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.PlaceComponentResult = maybeObserver;
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.PlaceComponentResult.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (t != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.PlaceComponentResult.onSuccess(t);
                return;
            }
            this.PlaceComponentResult.onComplete();
        }
    }
}

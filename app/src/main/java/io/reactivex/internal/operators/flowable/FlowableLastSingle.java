package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableLastSingle<T> extends Single<T> {
    final T KClassImpl$Data$declaredNonStaticMembers$2;
    final Publisher<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.MyBillsEntityDataFactory.subscribe(new LastSubscriber(singleObserver, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        T BuiltInFictitiousFunctionClassFactory;
        final T KClassImpl$Data$declaredNonStaticMembers$2;
        Subscription MyBillsEntityDataFactory;
        final SingleObserver<? super T> getAuthRequestContext;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.getAuthRequestContext = singleObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
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
                this.getAuthRequestContext.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.BuiltInFictitiousFunctionClassFactory = t;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            T t = this.BuiltInFictitiousFunctionClassFactory;
            if (t != null) {
                this.BuiltInFictitiousFunctionClassFactory = null;
                this.getAuthRequestContext.onSuccess(t);
                return;
            }
            T t2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (t2 != null) {
                this.getAuthRequestContext.onSuccess(t2);
            } else {
                this.getAuthRequestContext.onError(new NoSuchElementException());
            }
        }
    }
}

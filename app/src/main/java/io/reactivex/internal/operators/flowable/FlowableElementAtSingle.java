package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final T MyBillsEntityDataFactory;
    final Flowable<T> PlaceComponentResult;
    final long getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.PlaceComponentResult.getAuthRequestContext(new ElementAtSubscriber(singleObserver, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableElementAt(this.PlaceComponentResult, this.getAuthRequestContext, this.MyBillsEntityDataFactory, true));
    }

    /* loaded from: classes9.dex */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        long BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super T> KClassImpl$Data$declaredNonStaticMembers$2;
        final T MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final long getAuthRequestContext;
        Subscription scheduleImpl;

        ElementAtSubscriber(SingleObserver<? super T> singleObserver, long j, T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = singleObserver;
            this.getAuthRequestContext = j;
            this.MyBillsEntityDataFactory = t;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.scheduleImpl, subscription)) {
                this.scheduleImpl = subscription;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            long j = this.BuiltInFictitiousFunctionClassFactory;
            if (j == this.getAuthRequestContext) {
                this.PlaceComponentResult = true;
                this.scheduleImpl.cancel();
                this.scheduleImpl = SubscriptionHelper.CANCELLED;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = j + 1;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.PlaceComponentResult) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = true;
            this.scheduleImpl = SubscriptionHelper.CANCELLED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.scheduleImpl = SubscriptionHelper.CANCELLED;
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            T t = this.MyBillsEntityDataFactory;
            if (t != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSuccess(t);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.scheduleImpl.cancel();
            this.scheduleImpl = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.scheduleImpl == SubscriptionHelper.CANCELLED;
        }
    }
}

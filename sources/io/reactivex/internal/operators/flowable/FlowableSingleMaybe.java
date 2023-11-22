package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new SingleElementSubscriber(maybeObserver));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableSingle(this.KClassImpl$Data$declaredNonStaticMembers$2, null, false));
    }

    /* loaded from: classes9.dex */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        T KClassImpl$Data$declaredNonStaticMembers$2;
        Subscription MyBillsEntityDataFactory;
        final MaybeObserver<? super T> getAuthRequestContext;

        SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.getAuthRequestContext = maybeObserver;
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
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.BuiltInFictitiousFunctionClassFactory = true;
                this.MyBillsEntityDataFactory.cancel();
                this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
                this.getAuthRequestContext.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            if (t == null) {
                this.getAuthRequestContext.onComplete();
            } else {
                this.getAuthRequestContext.onSuccess(t);
            }
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

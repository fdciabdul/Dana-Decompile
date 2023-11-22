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

/* loaded from: classes6.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {
    final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final T MyBillsEntityDataFactory = null;

    public FlowableSingleSingle(Flowable<T> flowable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = flowable;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new SingleElementSubscriber(singleObserver, this.MyBillsEntityDataFactory));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableSingle(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, true));
    }

    /* loaded from: classes6.dex */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        final T KClassImpl$Data$declaredNonStaticMembers$2;
        T MyBillsEntityDataFactory;
        final SingleObserver<? super T> PlaceComponentResult;
        Subscription getAuthRequestContext;

        SingleElementSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.PlaceComponentResult = singleObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = t;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.PlaceComponentResult.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.MyBillsEntityDataFactory != null) {
                this.BuiltInFictitiousFunctionClassFactory = true;
                this.getAuthRequestContext.cancel();
                this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
                this.PlaceComponentResult.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.MyBillsEntityDataFactory = t;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
            this.PlaceComponentResult.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
            T t = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = null;
            if (t == null) {
                t = this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (t != null) {
                this.PlaceComponentResult.onSuccess(t);
            } else {
                this.PlaceComponentResult.onError(new NoSuchElementException());
            }
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

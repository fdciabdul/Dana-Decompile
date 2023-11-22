package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {
    final Callable<? extends U> BuiltInFictitiousFunctionClassFactory;
    final Flowable<T> MyBillsEntityDataFactory;
    final BiConsumer<? super U, ? super T> PlaceComponentResult;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super U> singleObserver) {
        try {
            this.MyBillsEntityDataFactory.getAuthRequestContext(new CollectSubscriber(singleObserver, ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.call(), "The initialSupplier returned a null value"), this.PlaceComponentResult));
        } catch (Throwable th) {
            EmptyDisposable.error(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<U> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableCollect(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult));
    }

    /* loaded from: classes9.dex */
    static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {
        final BiConsumer<? super U, ? super T> BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final U PlaceComponentResult;
        final SingleObserver<? super U> getAuthRequestContext;

        CollectSubscriber(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.getAuthRequestContext = singleObserver;
            this.BuiltInFictitiousFunctionClassFactory = biConsumer;
            this.PlaceComponentResult = u;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.getAuthRequestContext.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((U) this.PlaceComponentResult, t);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.MyBillsEntityDataFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
            this.getAuthRequestContext.onSuccess((U) this.PlaceComponentResult);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == SubscriptionHelper.CANCELLED;
        }
    }
}

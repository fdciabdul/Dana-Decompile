package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
    final Flowable<T> PlaceComponentResult;
    final Callable<U> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super U> singleObserver) {
        try {
            this.PlaceComponentResult.getAuthRequestContext(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.PlaceComponentResult(this.getAuthRequestContext.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<U> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableToList(this.PlaceComponentResult, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super U> BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        U getAuthRequestContext;

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
            this.getAuthRequestContext = u;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.getAuthRequestContext.add(t);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.getAuthRequestContext = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory.onSuccess(this.getAuthRequestContext);
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

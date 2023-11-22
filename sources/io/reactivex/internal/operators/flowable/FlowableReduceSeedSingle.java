package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableReduceSeedSingle<T, R> extends Single<R> {
    final R BuiltInFictitiousFunctionClassFactory;
    final BiFunction<R, ? super T, R> PlaceComponentResult;
    final Publisher<T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        this.getAuthRequestContext.subscribe(new ReduceSeedObserver(singleObserver, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory));
    }

    /* loaded from: classes9.dex */
    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super R> BuiltInFictitiousFunctionClassFactory;
        R KClassImpl$Data$declaredNonStaticMembers$2;
        final BiFunction<R, ? super T, R> PlaceComponentResult;
        Subscription getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.BuiltInFictitiousFunctionClassFactory = singleObserver;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = r;
            this.PlaceComponentResult = biFunction;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            R r = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (r != null) {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = (R) ObjectHelper.PlaceComponentResult(this.PlaceComponentResult.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    this.getAuthRequestContext.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
                this.BuiltInFictitiousFunctionClassFactory.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            R r = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (r != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.getAuthRequestContext = SubscriptionHelper.CANCELLED;
                this.BuiltInFictitiousFunctionClassFactory.onSuccess(r);
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

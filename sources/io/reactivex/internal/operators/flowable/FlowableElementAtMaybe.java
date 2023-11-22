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
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long BuiltInFictitiousFunctionClassFactory;
    final Flowable<T> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new ElementAtSubscriber(maybeObserver, this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public final Flowable<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.getAuthRequestContext(new FlowableElementAt(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, null, false));
    }

    /* loaded from: classes9.dex */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        Subscription MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        long getAuthRequestContext;

        ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j) {
            this.BuiltInFictitiousFunctionClassFactory = maybeObserver;
            this.PlaceComponentResult = j;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.MyBillsEntityDataFactory, subscription)) {
                this.MyBillsEntityDataFactory = subscription;
                this.BuiltInFictitiousFunctionClassFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            long j = this.getAuthRequestContext;
            if (j == this.PlaceComponentResult) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.MyBillsEntityDataFactory.cancel();
                this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
                this.BuiltInFictitiousFunctionClassFactory.onSuccess(t);
                return;
            }
            this.getAuthRequestContext = j + 1;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory = SubscriptionHelper.CANCELLED;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.BuiltInFictitiousFunctionClassFactory.onComplete();
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

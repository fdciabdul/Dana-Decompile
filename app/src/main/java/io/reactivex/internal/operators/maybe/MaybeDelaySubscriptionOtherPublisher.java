package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> BuiltInFictitiousFunctionClassFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super T> maybeObserver) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new OtherSubscriber(maybeObserver, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        final DelayMaybeObserver<T> MyBillsEntityDataFactory;
        MaybeSource<T> PlaceComponentResult;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.MyBillsEntityDataFactory = new DelayMaybeObserver<>(maybeObserver);
            this.PlaceComponentResult = maybeSource;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.MyBillsEntityDataFactory.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(Object obj) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != SubscriptionHelper.CANCELLED) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
                MaybeSource<T> maybeSource = this.PlaceComponentResult;
                this.PlaceComponentResult = null;
                maybeSource.PlaceComponentResult(this.MyBillsEntityDataFactory);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != SubscriptionHelper.CANCELLED) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
                this.MyBillsEntityDataFactory.downstream.onError(th);
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != SubscriptionHelper.CANCELLED) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
                MaybeSource<T> maybeSource = this.PlaceComponentResult;
                this.PlaceComponentResult = null;
                maybeSource.PlaceComponentResult(this.MyBillsEntityDataFactory);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.MyBillsEntityDataFactory.get());
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.MyBillsEntityDataFactory);
        }
    }

    /* loaded from: classes9.dex */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final MaybeObserver<? super T> downstream;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}

package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> getAuthRequestContext;

    @Override // io.reactivex.Completable
    public final void MyBillsEntityDataFactory(CompletableObserver completableObserver) {
        this.getAuthRequestContext.subscribe(new FromPublisherSubscriber(completableObserver));
    }

    /* loaded from: classes9.dex */
    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver BuiltInFictitiousFunctionClassFactory;
        Subscription MyBillsEntityDataFactory;

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
        }

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.BuiltInFictitiousFunctionClassFactory = completableObserver;
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
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
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

package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ObservableFromPublisher<T> extends Observable<T> {
    final Publisher<? extends T> BuiltInFictitiousFunctionClassFactory;

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.BuiltInFictitiousFunctionClassFactory = publisher;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(new PublisherSubscriber(observer));
    }

    /* loaded from: classes9.dex */
    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Observer<? super T> MyBillsEntityDataFactory;
        Subscription getAuthRequestContext;

        PublisherSubscriber(Observer<? super T> observer) {
            this.MyBillsEntityDataFactory = observer;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.MyBillsEntityDataFactory.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.MyBillsEntityDataFactory.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.MyBillsEntityDataFactory.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.getAuthRequestContext, subscription)) {
                this.getAuthRequestContext = subscription;
                this.MyBillsEntityDataFactory.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
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

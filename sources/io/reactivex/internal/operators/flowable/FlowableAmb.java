package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableAmb<T> extends Flowable<T> {
    final Publisher<? extends T>[] MyBillsEntityDataFactory;
    final Iterable<? extends Publisher<? extends T>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.MyBillsEntityDataFactory;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<? extends T> publisher : this.getAuthRequestContext) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    publisherArr[length] = publisher;
                    length++;
                }
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
        } else if (length == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            AmbCoordinator ambCoordinator = new AmbCoordinator(subscriber, length);
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = ambCoordinator.KClassImpl$Data$declaredNonStaticMembers$2;
            int length2 = ambInnerSubscriberArr.length;
            int i = 0;
            while (i < length2) {
                int i2 = i + 1;
                ambInnerSubscriberArr[i] = new AmbInnerSubscriber<>(ambCoordinator, i2, ambCoordinator.PlaceComponentResult);
                i = i2;
            }
            ambCoordinator.getAuthRequestContext.lazySet(0);
            ambCoordinator.PlaceComponentResult.onSubscribe(ambCoordinator);
            for (int i3 = 0; i3 < length2 && ambCoordinator.getAuthRequestContext.get() == 0; i3++) {
                publisherArr[i3].subscribe(ambInnerSubscriberArr[i3]);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class AmbCoordinator<T> implements Subscription {
        final AmbInnerSubscriber<T>[] KClassImpl$Data$declaredNonStaticMembers$2;
        final Subscriber<? super T> PlaceComponentResult;
        final AtomicInteger getAuthRequestContext = new AtomicInteger();

        AmbCoordinator(Subscriber<? super T> subscriber, int i) {
            this.PlaceComponentResult = subscriber;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new AmbInnerSubscriber[i];
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.getAuthRequestContext.get();
                if (i > 0) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2[i - 1].request(j);
                } else if (i == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public final boolean MyBillsEntityDataFactory(int i) {
            int i2 = 0;
            if (this.getAuthRequestContext.get() == 0 && this.getAuthRequestContext.compareAndSet(0, i)) {
                AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int length = ambInnerSubscriberArr.length;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    if (i3 != i) {
                        ambInnerSubscriberArr[i2].cancel();
                    }
                    i2 = i3;
                }
                return true;
            }
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.getAuthRequestContext.get() != -1) {
                this.getAuthRequestContext.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    ambInnerSubscriber.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        final Subscriber<? super T> downstream;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final AmbCoordinator<T> parent;
        boolean won;

        AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i, Subscriber<? super T> subscriber) {
            this.parent = ambCoordinator;
            this.index = i;
            this.downstream = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onNext(t);
            } else {
                get().cancel();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                get().cancel();
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.MyBillsEntityDataFactory(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            } else {
                get().cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}

package io.reactivex.processors;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {
    Throwable BuiltInFictitiousFunctionClassFactory;
    final AtomicReference<PublishSubscription<T>[]> KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>(MyBillsEntityDataFactory);
    static final PublishSubscription[] getAuthRequestContext = new PublishSubscription[0];
    static final PublishSubscription[] MyBillsEntityDataFactory = new PublishSubscription[0];

    PublishProcessor() {
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        PublishSubscription<T> publishSubscription = new PublishSubscription<>(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (BuiltInFictitiousFunctionClassFactory(publishSubscription)) {
            if (publishSubscription.isCancelled()) {
                KClassImpl$Data$declaredNonStaticMembers$2((PublishSubscription) publishSubscription);
                return;
            }
            return;
        }
        Throwable th = this.BuiltInFictitiousFunctionClassFactory;
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (publishSubscriptionArr == getAuthRequestContext) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[length + 1];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (publishSubscriptionArr == getAuthRequestContext || publishSubscriptionArr == MyBillsEntityDataFactory) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (publishSubscriptionArr[i] == publishSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = MyBillsEntityDataFactory;
            } else {
                PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i);
                System.arraycopy(publishSubscriptionArr, i + 1, publishSubscriptionArr3, i, (length - i) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get() == getAuthRequestContext) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription<T> publishSubscription : this.KClassImpl$Data$declaredNonStaticMembers$2.get()) {
            publishSubscription.onNext(t);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = getAuthRequestContext;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = th;
        for (PublishSubscription<T> publishSubscription : this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = getAuthRequestContext;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            return;
        }
        for (PublishSubscription<T> publishSubscription : this.KClassImpl$Data$declaredNonStaticMembers$2.getAndSet(publishSubscriptionArr2)) {
            publishSubscription.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final Subscriber<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.downstream = subscriber;
            this.parent = publishProcessor;
        }

        public final void onNext(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.downstream.onNext(t);
                BackpressureHelper.KClassImpl$Data$declaredNonStaticMembers$2(this, 1L);
                return;
            }
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        public final void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        public final void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.MyBillsEntityDataFactory(this, j);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.KClassImpl$Data$declaredNonStaticMembers$2((PublishSubscription) this);
            }
        }

        public final boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        final boolean isFull() {
            return get() == 0;
        }
    }
}

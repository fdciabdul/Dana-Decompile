package io.reactivex.processors;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    static final AsyncSubscription[] BuiltInFictitiousFunctionClassFactory = new AsyncSubscription[0];
    static final AsyncSubscription[] MyBillsEntityDataFactory = new AsyncSubscription[0];
    Throwable KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicReference<AsyncSubscription<T>[]> getAuthRequestContext = new AtomicReference<>(BuiltInFictitiousFunctionClassFactory);
    T lookAheadTest;

    AsyncProcessor() {
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.getAuthRequestContext.get() == MyBillsEntityDataFactory) {
            subscription.cancel();
        } else {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        ObjectHelper.PlaceComponentResult(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.getAuthRequestContext.get() == MyBillsEntityDataFactory) {
            return;
        }
        this.lookAheadTest = t;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.getAuthRequestContext.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = MyBillsEntityDataFactory;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.PlaceComponentResult(th);
            return;
        }
        this.lookAheadTest = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = th;
        for (AsyncSubscription<T> asyncSubscription : this.getAuthRequestContext.getAndSet(asyncSubscriptionArr2)) {
            asyncSubscription.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.getAuthRequestContext.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = MyBillsEntityDataFactory;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            return;
        }
        T t = this.lookAheadTest;
        AsyncSubscription<T>[] andSet = this.getAuthRequestContext.getAndSet(asyncSubscriptionArr2);
        int i = 0;
        if (t == null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].complete(t);
            i++;
        }
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        AsyncSubscription<T> asyncSubscription = new AsyncSubscription<>(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (BuiltInFictitiousFunctionClassFactory(asyncSubscription)) {
            if (asyncSubscription.isCancelled()) {
                MyBillsEntityDataFactory(asyncSubscription);
                return;
            }
            return;
        }
        Throwable th = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (th != null) {
            subscriber.onError(th);
            return;
        }
        T t = this.lookAheadTest;
        if (t != null) {
            asyncSubscription.complete(t);
        } else {
            asyncSubscription.onComplete();
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.getAuthRequestContext.get();
            if (asyncSubscriptionArr == MyBillsEntityDataFactory) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    final void MyBillsEntityDataFactory(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.getAuthRequestContext.get();
            int length = asyncSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (asyncSubscriptionArr[i] == asyncSubscription) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                asyncSubscriptionArr2 = BuiltInFictitiousFunctionClassFactory;
            } else {
                AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i);
                System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr3, i, (length - i) - 1);
                asyncSubscriptionArr2 = asyncSubscriptionArr3;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public final void cancel() {
            if (super.tryCancel()) {
                this.parent.MyBillsEntityDataFactory(this);
            }
        }

        final void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.downstream.onComplete();
        }

        final void onError(Throwable th) {
            if (isCancelled()) {
                RxJavaPlugins.PlaceComponentResult(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}

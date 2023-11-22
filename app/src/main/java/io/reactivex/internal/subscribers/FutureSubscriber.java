package io.reactivex.internal.subscribers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    final AtomicReference<Subscription> KClassImpl$Data$declaredNonStaticMembers$2;
    T MyBillsEntityDataFactory;
    Throwable PlaceComponentResult;

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Subscription subscription;
        do {
            subscription = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return false;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription, SubscriptionHelper.CANCELLED));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.getAuthRequestContext();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.PlaceComponentResult;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.getAuthRequestContext();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.KClassImpl$Data$declaredNonStaticMembers$2(j, timeUnit));
            }
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.PlaceComponentResult;
        if (th != null) {
            throw new ExecutionException(th);
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription, LongCompanionObject.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T t) {
        if (this.MyBillsEntityDataFactory != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.MyBillsEntityDataFactory = t;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.PlaceComponentResult = th;
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        Subscription subscription;
        if (this.MyBillsEntityDataFactory == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription, this));
        countDown();
    }
}

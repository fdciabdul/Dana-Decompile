package io.reactivex.internal.operators.parallel;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    final ParallelFlowable<List<T>> MyBillsEntityDataFactory;
    final Comparator<? super T> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.MyBillsEntityDataFactory.getAuthRequestContext(), this.getAuthRequestContext);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.MyBillsEntityDataFactory.getAuthRequestContext(sortedJoinSubscription.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final int[] indexes;
        final List<T>[] lists;
        final SortedJoinInnerSubscriber<T>[] subscribers;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator) {
            this.downstream = subscriber;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        final void cancelAll() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.cancel();
            }
        }

        final void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        final void innerError(Throwable th) {
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.error, null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        final void drain() {
            boolean z;
            T t;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = this.error.get();
                    if (th != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th);
                        return;
                    }
                    int i2 = -1;
                    int i3 = 0;
                    Object obj = (Object) null;
                    while (i3 < length) {
                        List<T> list = listArr[i3];
                        int i4 = iArr[i3];
                        if (list.size() != i4) {
                            if (obj == null) {
                                t = list.get(i4);
                            } else {
                                t = list.get(i4);
                                try {
                                    if (!(this.comparator.compare(obj, t) > 0)) {
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.MyBillsEntityDataFactory(th2);
                                    cancelAll();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.error, null, th2)) {
                                        RxJavaPlugins.PlaceComponentResult(th2);
                                    }
                                    subscriber.onError(this.error.get());
                                    return;
                                }
                            }
                            obj = (Object) t;
                            i2 = i3;
                        }
                        i3++;
                        obj = obj;
                    }
                    if (obj == null) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    }
                    subscriber.onNext(obj);
                    iArr[i2] = iArr[i2] + 1;
                    j2++;
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th3 = this.error.get();
                    if (th3 != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th3);
                        return;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            z = true;
                            break;
                        } else if (iArr[i5] != listArr[i5].size()) {
                            z = false;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (z) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0 && j != LongCompanionObject.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i6 = get();
                if (i6 == i && (i6 = addAndGet(-i)) == 0) {
                    return;
                }
                i = i6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((List) ((List) obj));
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        public final void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.parent.innerError(th);
        }

        final void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}

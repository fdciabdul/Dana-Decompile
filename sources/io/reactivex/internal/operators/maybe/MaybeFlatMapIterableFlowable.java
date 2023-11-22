package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final MaybeSource<T> MyBillsEntityDataFactory;
    final Function<? super T, ? extends Iterable<? extends R>> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.MyBillsEntityDataFactory.PlaceComponentResult(new FlatMapIterableObserver(subscriber, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final Subscriber<? super R> downstream;
        volatile Iterator<? extends R> it;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = subscriber;
            this.mapper = function;
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                    return;
                }
                this.it = it;
                drain();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        final void fastPath(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    subscriber.onNext((R) it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.MyBillsEntityDataFactory(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        final void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            Iterator<? extends R> it = this.it;
            if (this.outputFused && it != null) {
                subscriber.onNext(null);
                subscriber.onComplete();
                return;
            }
            int i = 1;
            while (true) {
                if (it != null) {
                    long j = this.requested.get();
                    if (j == LongCompanionObject.MAX_VALUE) {
                        fastPath(subscriber, it);
                        return;
                    }
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            subscriber.onNext((Object) ObjectHelper.PlaceComponentResult(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
                                    subscriber.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.MyBillsEntityDataFactory(th);
                                subscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.MyBillsEntityDataFactory(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.PlaceComponentResult(this.requested, j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (it == null) {
                    it = this.it;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.it = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it != null) {
                R r = (R) ObjectHelper.PlaceComponentResult(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = null;
                }
                return r;
            }
            return null;
        }
    }
}

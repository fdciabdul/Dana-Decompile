package io.reactivex.internal.operators.flowable;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super T, ? extends MaybeSource<? extends R>> MyBillsEntityDataFactory;
    final boolean getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new FlatMapMaybeSubscriber(subscriber, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* loaded from: classes9.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final int maxConcurrency;
        Subscription upstream;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable set = new CompositeDisposable();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> queue = new AtomicReference<>();

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(LongCompanionObject.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.PlaceComponentResult(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.getAuthRequestContext(innerObserver)) {
                    return;
                }
                maybeSource.PlaceComponentResult(innerObserver);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.requested, j);
                drain();
            }
        }

        final void innerSuccess(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            this.set.MyBillsEntityDataFactory(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    if (this.requested.get() != 0) {
                        this.downstream.onNext(r);
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.downstream.onError(terminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        BackpressureHelper.PlaceComponentResult(this.requested, 1L);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1L);
                        }
                    } else {
                        SpscLinkedArrayQueue<R> orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            SpscLinkedArrayQueue<R> orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        final SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.queue.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.BuiltInFictitiousFunctionClassFactory());
            } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(this.queue, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        final void innerError(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.MyBillsEntityDataFactory(innerObserver);
            if (this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
                this.active.decrementAndGet();
                drain();
                return;
            }
            RxJavaPlugins.PlaceComponentResult(th);
        }

        final void innerComplete(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.set.MyBillsEntityDataFactory(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.active.decrementAndGet() == 0;
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
                    if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
            drain();
        }

        final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        final void clear() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
        
            if (r9 != r5) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
        
            if (r15.cancelled == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
        
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0080, code lost:
        
            if (r15.delayErrors != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
        
            if (r15.errors.get() == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
        
            r1 = r15.errors.terminate();
            clear();
            r0.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0098, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
        
            if (r1.get() != 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
        
            r6 = r2.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
        
            if (r6 == null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ae, code lost:
        
            if (r6.isEmpty() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b0, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b1, code lost:
        
            if (r5 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b3, code lost:
        
            if (r11 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b5, code lost:
        
            r1 = r15.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00bb, code lost:
        
            if (r1 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00bd, code lost:
        
            r0.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c0, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00c1, code lost:
        
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c4, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00c7, code lost:
        
            if (r9 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00c9, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.PlaceComponentResult(r15.requested, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d3, code lost:
        
            if (r15.maxConcurrency == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d5, code lost:
        
            r15.upstream.request(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00da, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void drainLoop() {
            /*
                Method dump skipped, instructions count: 226
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.drainLoop():void");
        }

        /* loaded from: classes9.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onSuccess(R r) {
                FlatMapMaybeSubscriber.this.innerSuccess(this, r);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public final void onComplete() {
                FlatMapMaybeSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}

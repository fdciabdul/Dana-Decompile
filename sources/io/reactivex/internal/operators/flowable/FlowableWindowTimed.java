package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    final long getAuthRequestContext;
    final Scheduler getErrorConfigVersion;
    final long moveToNextValue;
    final TimeUnit scheduleImpl;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != this.moveToNextValue) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new WindowSkipSubscriber(serializedSubscriber, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.scheduleImpl, this.getErrorConfigVersion.createWorker(), this.MyBillsEntityDataFactory));
        } else if (this.getAuthRequestContext == LongCompanionObject.MAX_VALUE) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new WindowExactUnboundedSubscriber(serializedSubscriber, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.getErrorConfigVersion, this.MyBillsEntityDataFactory));
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new WindowExactBoundedSubscriber(serializedSubscriber, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.scheduleImpl, this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object getAuthRequestContext = new Object();
        final SequentialDisposable BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final Scheduler MyBillsEntityDataFactory;
        volatile boolean PlaceComponentResult;
        final long getErrorConfigVersion;
        UnicastProcessor<T> lookAheadTest;
        final TimeUnit moveToNextValue;
        Subscription scheduleImpl;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.BuiltInFictitiousFunctionClassFactory = new SequentialDisposable();
            this.getErrorConfigVersion = j;
            this.moveToNextValue = timeUnit;
            this.MyBillsEntityDataFactory = scheduler;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.scheduleImpl, subscription)) {
                this.scheduleImpl = subscription;
                this.lookAheadTest = UnicastProcessor.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
                Subscriber<? super V> subscriber = this.newProxyInstance;
                subscriber.onSubscribe(this);
                long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                if (j != 0) {
                    subscriber.onNext(this.lookAheadTest);
                    if (j != LongCompanionObject.MAX_VALUE) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                    }
                    if (this.GetContactSyncConfig) {
                        return;
                    }
                    SequentialDisposable sequentialDisposable = this.BuiltInFictitiousFunctionClassFactory;
                    Scheduler scheduler = this.MyBillsEntityDataFactory;
                    long j2 = this.getErrorConfigVersion;
                    if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j2, j2, this.moveToNextValue))) {
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.GetContactSyncConfig = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.PlaceComponentResult) {
                return;
            }
            if (moveToNextValue()) {
                this.lookAheadTest.onNext(t);
                if (this.isLayoutRequested.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.PrepareContext.offer(NotificationLite.next(t));
                if (!lookAheadTest()) {
                    return;
                }
            }
            MyBillsEntityDataFactory();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = th;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                MyBillsEntityDataFactory();
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                MyBillsEntityDataFactory();
            }
            this.newProxyInstance.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.GetContactSyncConfig = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.GetContactSyncConfig) {
                this.PlaceComponentResult = true;
            }
            this.PrepareContext.offer(getAuthRequestContext);
            if (lookAheadTest()) {
                MyBillsEntityDataFactory();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            r10.BuiltInFictitiousFunctionClassFactory.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.lookAheadTest = null;
            r0.clear();
            r0 = r10.NetworkUserEntityData$$ExternalSyntheticLambda8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void MyBillsEntityDataFactory() {
            /*
                r10 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.PrepareContext
                org.reactivestreams.Subscriber<? super V> r1 = r10.newProxyInstance
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.lookAheadTest
                r3 = 1
            L7:
                boolean r4 = r10.PlaceComponentResult
                boolean r5 = r10.NetworkUserEntityData$$ExternalSyntheticLambda1
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.getAuthRequestContext
                if (r6 != r5) goto L2e
            L18:
                r10.lookAheadTest = r7
                r0.clear()
                java.lang.Throwable r0 = r10.NetworkUserEntityData$$ExternalSyntheticLambda8
                if (r0 == 0) goto L25
                r2.onError(r0)
                goto L28
            L25:
                r2.onComplete()
            L28:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.BuiltInFictitiousFunctionClassFactory
                r0.dispose()
                return
            L2e:
                if (r6 != 0) goto L3a
                int r3 = -r3
                java.util.concurrent.atomic.AtomicInteger r4 = r10.isLayoutRequested
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto L7
                return
            L3a:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.getAuthRequestContext
                if (r6 != r5) goto L8e
                r2.onComplete()
                if (r4 != 0) goto L87
                int r2 = r10.KClassImpl$Data$declaredNonStaticMembers$2
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.MyBillsEntityDataFactory(r2)
                r10.lookAheadTest = r2
                java.util.concurrent.atomic.AtomicLong r4 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7
                long r4 = r4.get()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L6b
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                java.util.concurrent.atomic.AtomicLong r4 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7
                r5 = -1
                r4.addAndGet(r5)
                goto L7
            L6b:
                r10.lookAheadTest = r7
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.PrepareContext
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.scheduleImpl
                r0.cancel()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.BuiltInFictitiousFunctionClassFactory
                r0.dispose()
                return
            L87:
                org.reactivestreams.Subscription r4 = r10.scheduleImpl
                r4.cancel()
                goto L7
            L8e:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.MyBillsEntityDataFactory():void");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final long BuiltInFictitiousFunctionClassFactory;
        Subscription DatabaseTableConfigUtil;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        long MyBillsEntityDataFactory;
        final SequentialDisposable NetworkUserEntityData$$ExternalSyntheticLambda0;
        UnicastProcessor<T> NetworkUserEntityData$$ExternalSyntheticLambda2;
        final int PlaceComponentResult;
        long getAuthRequestContext;
        volatile boolean getErrorConfigVersion;
        final Scheduler.Worker initRecordTimeStamp;
        final Scheduler lookAheadTest;
        final long moveToNextValue;
        final TimeUnit scheduleImpl;

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SequentialDisposable();
            this.moveToNextValue = j;
            this.scheduleImpl = timeUnit;
            this.lookAheadTest = scheduler;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = j2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            if (z) {
                this.initRecordTimeStamp = scheduler.createWorker();
            } else {
                this.initRecordTimeStamp = null;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            Disposable schedulePeriodicallyDirect;
            if (SubscriptionHelper.validate(this.DatabaseTableConfigUtil, subscription)) {
                this.DatabaseTableConfigUtil = subscription;
                Subscriber<? super V> subscriber = this.newProxyInstance;
                subscriber.onSubscribe(this);
                if (this.GetContactSyncConfig) {
                    return;
                }
                UnicastProcessor<T> MyBillsEntityDataFactory = UnicastProcessor.MyBillsEntityDataFactory(this.PlaceComponentResult);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory;
                long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                if (j != 0) {
                    subscriber.onNext(MyBillsEntityDataFactory);
                    if (j != LongCompanionObject.MAX_VALUE) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                    }
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.MyBillsEntityDataFactory, this);
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        Scheduler.Worker worker = this.initRecordTimeStamp;
                        long j2 = this.moveToNextValue;
                        schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.scheduleImpl);
                    } else {
                        Scheduler scheduler = this.lookAheadTest;
                        long j3 = this.moveToNextValue;
                        schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j3, j3, this.scheduleImpl);
                    }
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.replace(schedulePeriodicallyDirect)) {
                        subscription.request(LongCompanionObject.MAX_VALUE);
                        return;
                    }
                    return;
                }
                this.GetContactSyncConfig = true;
                subscription.cancel();
                subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.getErrorConfigVersion) {
                return;
            }
            if (moveToNextValue()) {
                UnicastProcessor<T> unicastProcessor = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                unicastProcessor.onNext(t);
                long j = this.getAuthRequestContext + 1;
                if (j >= this.BuiltInFictitiousFunctionClassFactory) {
                    this.MyBillsEntityDataFactory++;
                    this.getAuthRequestContext = 0L;
                    unicastProcessor.onComplete();
                    long j2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                    if (j2 != 0) {
                        UnicastProcessor<T> MyBillsEntityDataFactory = UnicastProcessor.MyBillsEntityDataFactory(this.PlaceComponentResult);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory;
                        this.newProxyInstance.onNext(MyBillsEntityDataFactory);
                        if (j2 != LongCompanionObject.MAX_VALUE) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                        }
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
                            Scheduler.Worker worker = this.initRecordTimeStamp;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.MyBillsEntityDataFactory, this);
                            long j3 = this.moveToNextValue;
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.replace(worker.schedulePeriodically(consumerIndexHolder, j3, j3, this.scheduleImpl));
                        }
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                        this.DatabaseTableConfigUtil.cancel();
                        this.newProxyInstance.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
                        Scheduler.Worker worker2 = this.initRecordTimeStamp;
                        if (worker2 != null) {
                            worker2.dispose();
                            return;
                        }
                        return;
                    }
                } else {
                    this.getAuthRequestContext = j;
                }
                if (this.isLayoutRequested.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.PrepareContext.offer(NotificationLite.next(t));
                if (!lookAheadTest()) {
                    return;
                }
            }
            getAuthRequestContext();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = th;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                getAuthRequestContext();
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                getAuthRequestContext();
            }
            this.newProxyInstance.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.GetContactSyncConfig = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void getAuthRequestContext() {
            SimpleQueue simpleQueue = this.PrepareContext;
            Subscriber<? super V> subscriber = this.newProxyInstance;
            UnicastProcessor<T> unicastProcessor = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            int i = 1;
            while (!this.getErrorConfigVersion) {
                boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                    simpleQueue.clear();
                    Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (th != null) {
                        unicastProcessor.onError(th);
                    } else {
                        unicastProcessor.onComplete();
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
                    Scheduler.Worker worker = this.initRecordTimeStamp;
                    if (worker != null) {
                        worker.dispose();
                        return;
                    }
                    return;
                } else if (z2) {
                    i = this.isLayoutRequested.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    int i2 = i;
                    if (z3) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (!this.KClassImpl$Data$declaredNonStaticMembers$2 || this.MyBillsEntityDataFactory == consumerIndexHolder.KClassImpl$Data$declaredNonStaticMembers$2) {
                            unicastProcessor.onComplete();
                            this.getAuthRequestContext = 0L;
                            unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.MyBillsEntityDataFactory(this.PlaceComponentResult);
                            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = unicastProcessor;
                            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                            if (j != 0) {
                                subscriber.onNext(unicastProcessor);
                                if (j != LongCompanionObject.MAX_VALUE) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                                }
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                                this.PrepareContext.clear();
                                this.DatabaseTableConfigUtil.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
                                Scheduler.Worker worker2 = this.initRecordTimeStamp;
                                if (worker2 != null) {
                                    worker2.dispose();
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        unicastProcessor.onNext(NotificationLite.getValue(poll));
                        long j2 = this.getAuthRequestContext + 1;
                        if (j2 >= this.BuiltInFictitiousFunctionClassFactory) {
                            this.MyBillsEntityDataFactory++;
                            this.getAuthRequestContext = 0L;
                            unicastProcessor.onComplete();
                            long j3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                            if (j3 != 0) {
                                unicastProcessor = (UnicastProcessor<T>) UnicastProcessor.MyBillsEntityDataFactory(this.PlaceComponentResult);
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = unicastProcessor;
                                this.newProxyInstance.onNext(unicastProcessor);
                                if (j3 != LongCompanionObject.MAX_VALUE) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                                }
                                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
                                    Scheduler.Worker worker3 = this.initRecordTimeStamp;
                                    ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.MyBillsEntityDataFactory, this);
                                    long j4 = this.moveToNextValue;
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.replace(worker3.schedulePeriodically(consumerIndexHolder2, j4, j4, this.scheduleImpl));
                                }
                            } else {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                                this.DatabaseTableConfigUtil.cancel();
                                this.newProxyInstance.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
                                Scheduler.Worker worker4 = this.initRecordTimeStamp;
                                if (worker4 != null) {
                                    worker4.dispose();
                                    return;
                                }
                                return;
                            }
                        } else {
                            this.getAuthRequestContext = j2;
                        }
                    }
                    i = i2;
                }
            }
            this.DatabaseTableConfigUtil.cancel();
            simpleQueue.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
            Scheduler.Worker worker5 = this.initRecordTimeStamp;
            if (worker5 != null) {
                worker5.dispose();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            final WindowExactBoundedSubscriber<?> BuiltInFictitiousFunctionClassFactory;
            final long KClassImpl$Data$declaredNonStaticMembers$2;

            ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
                this.BuiltInFictitiousFunctionClassFactory = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.BuiltInFictitiousFunctionClassFactory;
                if (!windowExactBoundedSubscriber.GetContactSyncConfig) {
                    windowExactBoundedSubscriber.PrepareContext.offer(this);
                } else {
                    windowExactBoundedSubscriber.getErrorConfigVersion = true;
                }
                if (windowExactBoundedSubscriber.lookAheadTest()) {
                    windowExactBoundedSubscriber.getAuthRequestContext();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        final long BuiltInFictitiousFunctionClassFactory;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        final Scheduler.Worker NetworkUserEntityData$$ExternalSyntheticLambda0;
        final TimeUnit PlaceComponentResult;
        volatile boolean getAuthRequestContext;
        final List<UnicastProcessor<T>> getErrorConfigVersion;
        Subscription scheduleImpl;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.BuiltInFictitiousFunctionClassFactory = j2;
            this.PlaceComponentResult = timeUnit;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = worker;
            this.MyBillsEntityDataFactory = i;
            this.getErrorConfigVersion = new LinkedList();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.scheduleImpl, subscription)) {
                this.scheduleImpl = subscription;
                this.newProxyInstance.onSubscribe(this);
                if (this.GetContactSyncConfig) {
                    return;
                }
                long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                if (j != 0) {
                    UnicastProcessor<T> MyBillsEntityDataFactory = UnicastProcessor.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                    this.getErrorConfigVersion.add(MyBillsEntityDataFactory);
                    this.newProxyInstance.onNext(MyBillsEntityDataFactory);
                    if (j != LongCompanionObject.MAX_VALUE) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.schedule(new Completion(MyBillsEntityDataFactory), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                    Scheduler.Worker worker = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    long j2 = this.BuiltInFictitiousFunctionClassFactory;
                    worker.schedulePeriodically(this, j2, j2, this.PlaceComponentResult);
                    subscription.request(LongCompanionObject.MAX_VALUE);
                    return;
                }
                subscription.cancel();
                this.newProxyInstance.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (moveToNextValue()) {
                Iterator<UnicastProcessor<T>> it = this.getErrorConfigVersion.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (this.isLayoutRequested.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.PrepareContext.offer(t);
                if (!lookAheadTest()) {
                    return;
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = th;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
            this.newProxyInstance.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            if (lookAheadTest()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
            this.newProxyInstance.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.GetContactSyncConfig = true;
        }

        final void getAuthRequestContext(UnicastProcessor<T> unicastProcessor) {
            this.PrepareContext.offer(new SubjectWork(unicastProcessor, false));
            if (lookAheadTest()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2() {
            SimpleQueue simpleQueue = this.PrepareContext;
            Subscriber<? super V> subscriber = this.newProxyInstance;
            List<UnicastProcessor<T>> list = this.getErrorConfigVersion;
            int i = 1;
            while (!this.getAuthRequestContext) {
                boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                T t = (T) simpleQueue.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simpleQueue.clear();
                    Throwable th = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
                    return;
                } else if (z2) {
                    i = this.isLayoutRequested.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) t;
                    if (subjectWork.BuiltInFictitiousFunctionClassFactory) {
                        if (!this.GetContactSyncConfig) {
                            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                            if (j != 0) {
                                UnicastProcessor<T> MyBillsEntityDataFactory = UnicastProcessor.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                                list.add(MyBillsEntityDataFactory);
                                subscriber.onNext(MyBillsEntityDataFactory);
                                if (j != LongCompanionObject.MAX_VALUE) {
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda7.addAndGet(-1L);
                                }
                                this.NetworkUserEntityData$$ExternalSyntheticLambda0.schedule(new Completion(MyBillsEntityDataFactory), this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                            } else {
                                subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                            }
                        }
                    } else {
                        list.remove(subjectWork.MyBillsEntityDataFactory);
                        subjectWork.MyBillsEntityDataFactory.onComplete();
                        if (list.isEmpty() && this.GetContactSyncConfig) {
                            this.getAuthRequestContext = true;
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(t);
                    }
                }
            }
            this.scheduleImpl.cancel();
            simpleQueue.clear();
            list.clear();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        }

        @Override // java.lang.Runnable
        public final void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), true);
            if (!this.GetContactSyncConfig) {
                this.PrepareContext.offer(subjectWork);
            }
            if (lookAheadTest()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class SubjectWork<T> {
            final boolean BuiltInFictitiousFunctionClassFactory;
            final UnicastProcessor<T> MyBillsEntityDataFactory;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.MyBillsEntityDataFactory = unicastProcessor;
                this.BuiltInFictitiousFunctionClassFactory = z;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public final class Completion implements Runnable {
            private final UnicastProcessor<T> MyBillsEntityDataFactory;

            Completion(UnicastProcessor<T> unicastProcessor) {
                this.MyBillsEntityDataFactory = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WindowSkipSubscriber.this.getAuthRequestContext(this.MyBillsEntityDataFactory);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda7, j);
            }
        }
    }
}

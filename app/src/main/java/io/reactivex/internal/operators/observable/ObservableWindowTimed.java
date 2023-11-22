package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final Scheduler BuiltInFictitiousFunctionClassFactory;
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final long PlaceComponentResult;
    final long getErrorConfigVersion;
    final TimeUnit moveToNextValue;
    final long scheduleImpl;

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.getErrorConfigVersion = j;
        this.scheduleImpl = j2;
        this.moveToNextValue = timeUnit;
        this.BuiltInFictitiousFunctionClassFactory = scheduler;
        this.PlaceComponentResult = j3;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.getErrorConfigVersion != this.scheduleImpl) {
            this.getAuthRequestContext.subscribe(new WindowSkipObserver(serializedObserver, this.getErrorConfigVersion, this.scheduleImpl, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory.createWorker(), this.MyBillsEntityDataFactory));
        } else if (this.PlaceComponentResult == LongCompanionObject.MAX_VALUE) {
            this.getAuthRequestContext.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.getErrorConfigVersion, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory));
        } else {
            this.getAuthRequestContext.subscribe(new WindowExactBoundedObserver(serializedObserver, this.getErrorConfigVersion, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object getErrorConfigVersion = new Object();
        final TimeUnit DatabaseTableConfigUtil;
        UnicastSubject<T> GetContactSyncConfig;
        final int NetworkUserEntityData$$ExternalSyntheticLambda0;
        final long NetworkUserEntityData$$ExternalSyntheticLambda1;
        final SequentialDisposable NetworkUserEntityData$$ExternalSyntheticLambda2;
        Disposable initRecordTimeStamp;
        volatile boolean lookAheadTest;
        final Scheduler scheduleImpl;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(observer, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SequentialDisposable();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = j;
            this.DatabaseTableConfigUtil = timeUnit;
            this.scheduleImpl = scheduler;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.initRecordTimeStamp, disposable)) {
                this.initRecordTimeStamp = disposable;
                this.GetContactSyncConfig = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                observer.onSubscribe(this);
                observer.onNext(this.GetContactSyncConfig);
                if (this.PlaceComponentResult) {
                    return;
                }
                Scheduler scheduler = this.scheduleImpl;
                long j = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.DatabaseTableConfigUtil));
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.lookAheadTest) {
                return;
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                this.GetContactSyncConfig.onNext(t);
                if (this.moveToNextValue.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.getAuthRequestContext.offer(NotificationLite.next(t));
                if (!MyBillsEntityDataFactory()) {
                    return;
                }
            }
            scheduleImpl();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = th;
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                scheduleImpl();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                scheduleImpl();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.PlaceComponentResult) {
                this.lookAheadTest = true;
            }
            this.getAuthRequestContext.offer(getErrorConfigVersion);
            if (MyBillsEntityDataFactory()) {
                scheduleImpl();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        
            r7.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.GetContactSyncConfig = null;
            r0.clear();
            r0 = r7.BuiltInFictitiousFunctionClassFactory;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void scheduleImpl() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r7.getAuthRequestContext
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.KClassImpl$Data$declaredNonStaticMembers$2
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.GetContactSyncConfig
                r3 = 1
            L9:
                boolean r4 = r7.lookAheadTest
                boolean r5 = r7.MyBillsEntityDataFactory
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L30
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.getErrorConfigVersion
                if (r6 != r5) goto L30
            L19:
                r1 = 0
                r7.GetContactSyncConfig = r1
                r0.clear()
                java.lang.Throwable r0 = r7.BuiltInFictitiousFunctionClassFactory
                if (r0 == 0) goto L27
                r2.onError(r0)
                goto L2a
            L27:
                r2.onComplete()
            L2a:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r7.NetworkUserEntityData$$ExternalSyntheticLambda2
                r0.dispose()
                return
            L30:
                if (r6 != 0) goto L3c
                int r3 = -r3
                java.util.concurrent.atomic.AtomicInteger r4 = r7.moveToNextValue
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto L9
                return
            L3c:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.getErrorConfigVersion
                if (r6 != r5) goto L57
                r2.onComplete()
                if (r4 != 0) goto L51
                int r2 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(r2)
                r7.GetContactSyncConfig = r2
                r1.onNext(r2)
                goto L9
            L51:
                io.reactivex.disposables.Disposable r4 = r7.initRecordTimeStamp
                r4.dispose()
                goto L9
            L57:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.scheduleImpl():void");
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final Scheduler DatabaseTableConfigUtil;
        final boolean GetContactSyncConfig;
        long NetworkUserEntityData$$ExternalSyntheticLambda0;
        final SequentialDisposable NetworkUserEntityData$$ExternalSyntheticLambda1;
        volatile boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
        final Scheduler.Worker NetworkUserEntityData$$ExternalSyntheticLambda7;
        UnicastSubject<T> NetworkUserEntityData$$ExternalSyntheticLambda8;
        long getErrorConfigVersion;
        final long initRecordTimeStamp;
        final TimeUnit isLayoutRequested;
        final long lookAheadTest;
        Disposable newProxyInstance;
        final int scheduleImpl;

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SequentialDisposable();
            this.initRecordTimeStamp = j;
            this.isLayoutRequested = timeUnit;
            this.DatabaseTableConfigUtil = scheduler;
            this.scheduleImpl = i;
            this.lookAheadTest = j2;
            this.GetContactSyncConfig = z;
            if (z) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = scheduler.createWorker();
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            Disposable schedulePeriodicallyDirect;
            if (DisposableHelper.validate(this.newProxyInstance, disposable)) {
                this.newProxyInstance = disposable;
                Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
                observer.onSubscribe(this);
                if (this.PlaceComponentResult) {
                    return;
                }
                UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2 = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2;
                observer.onNext(KClassImpl$Data$declaredNonStaticMembers$2);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.getErrorConfigVersion, this);
                if (this.GetContactSyncConfig) {
                    Scheduler.Worker worker = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    long j = this.initRecordTimeStamp;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.isLayoutRequested);
                } else {
                    Scheduler scheduler = this.DatabaseTableConfigUtil;
                    long j2 = this.initRecordTimeStamp;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.isLayoutRequested);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.replace(schedulePeriodicallyDirect);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                return;
            }
            if (BuiltInFictitiousFunctionClassFactory()) {
                UnicastSubject<T> unicastSubject = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                unicastSubject.onNext(t);
                long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                if (j >= this.lookAheadTest) {
                    this.getErrorConfigVersion++;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2 = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = KClassImpl$Data$declaredNonStaticMembers$2;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(KClassImpl$Data$declaredNonStaticMembers$2);
                    if (this.GetContactSyncConfig) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
                        Scheduler.Worker worker = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.getErrorConfigVersion, this);
                        long j2 = this.initRecordTimeStamp;
                        DisposableHelper.replace(this.NetworkUserEntityData$$ExternalSyntheticLambda1, worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.isLayoutRequested));
                    }
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
                }
                if (this.moveToNextValue.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.getAuthRequestContext.offer(NotificationLite.next(t));
                if (!MyBillsEntityDataFactory()) {
                    return;
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = th;
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.getAuthRequestContext;
            Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            UnicastSubject<T> unicastSubject = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i = 1;
            while (!this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                boolean z = this.MyBillsEntityDataFactory;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                    mpscLinkedQueue.clear();
                    Throwable th = this.BuiltInFictitiousFunctionClassFactory;
                    if (th != null) {
                        unicastSubject.onError(th);
                    } else {
                        unicastSubject.onComplete();
                    }
                    DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    Scheduler.Worker worker = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    if (worker != null) {
                        worker.dispose();
                        return;
                    }
                    return;
                } else if (z2) {
                    i = this.moveToNextValue.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (!this.GetContactSyncConfig || this.getErrorConfigVersion == consumerIndexHolder.getAuthRequestContext) {
                        unicastSubject.onComplete();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                    if (j >= this.lookAheadTest) {
                        this.getErrorConfigVersion++;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = unicastSubject;
                        this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(unicastSubject);
                        if (this.GetContactSyncConfig) {
                            Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get();
                            disposable.dispose();
                            Scheduler.Worker worker2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.getErrorConfigVersion, this);
                            long j2 = this.initRecordTimeStamp;
                            Disposable schedulePeriodically = worker2.schedulePeriodically(consumerIndexHolder2, j2, j2, this.isLayoutRequested);
                            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
                    }
                }
            }
            this.newProxyInstance.dispose();
            mpscLinkedQueue.clear();
            DisposableHelper.dispose(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            Scheduler.Worker worker3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (worker3 != null) {
                worker3.dispose();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            final WindowExactBoundedObserver<?> BuiltInFictitiousFunctionClassFactory;
            final long getAuthRequestContext;

            ConsumerIndexHolder(long j, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.getAuthRequestContext = j;
                this.BuiltInFictitiousFunctionClassFactory = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.BuiltInFictitiousFunctionClassFactory;
                if (!windowExactBoundedObserver.PlaceComponentResult) {
                    windowExactBoundedObserver.getAuthRequestContext.offer(this);
                } else {
                    windowExactBoundedObserver.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                }
                if (windowExactBoundedObserver.MyBillsEntityDataFactory()) {
                    windowExactBoundedObserver.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final Scheduler.Worker GetContactSyncConfig;
        final long NetworkUserEntityData$$ExternalSyntheticLambda0;
        Disposable NetworkUserEntityData$$ExternalSyntheticLambda1;
        final TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda2;
        volatile boolean getErrorConfigVersion;
        final List<UnicastSubject<T>> initRecordTimeStamp;
        final int lookAheadTest;
        final long scheduleImpl;

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(observer, new MpscLinkedQueue());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
            this.scheduleImpl = j2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = timeUnit;
            this.GetContactSyncConfig = worker;
            this.lookAheadTest = i;
            this.initRecordTimeStamp = new LinkedList();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.NetworkUserEntityData$$ExternalSyntheticLambda1, disposable)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = disposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2.onSubscribe(this);
                if (this.PlaceComponentResult) {
                    return;
                }
                UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2 = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
                this.initRecordTimeStamp.add(KClassImpl$Data$declaredNonStaticMembers$2);
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(KClassImpl$Data$declaredNonStaticMembers$2);
                this.GetContactSyncConfig.schedule(new CompletionTask(KClassImpl$Data$declaredNonStaticMembers$2), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                Scheduler.Worker worker = this.GetContactSyncConfig;
                long j = this.scheduleImpl;
                worker.schedulePeriodically(this, j, j, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (BuiltInFictitiousFunctionClassFactory()) {
                Iterator<UnicastSubject<T>> it = this.initRecordTimeStamp.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (this.moveToNextValue.addAndGet(-1) == 0) {
                    return;
                }
            } else {
                this.getAuthRequestContext.offer(t);
                if (!MyBillsEntityDataFactory()) {
                    return;
                }
            }
            lookAheadTest();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory = th;
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                lookAheadTest();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.MyBillsEntityDataFactory = true;
            if (MyBillsEntityDataFactory()) {
                lookAheadTest();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(UnicastSubject<T> unicastSubject) {
            this.getAuthRequestContext.offer(new SubjectWork(unicastSubject, false));
            if (MyBillsEntityDataFactory()) {
                lookAheadTest();
            }
        }

        private void lookAheadTest() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.getAuthRequestContext;
            Observer<? super V> observer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<UnicastSubject<T>> list = this.initRecordTimeStamp;
            int i = 1;
            while (!this.getErrorConfigVersion) {
                boolean z = this.MyBillsEntityDataFactory;
                T t = (T) mpscLinkedQueue.poll();
                boolean z2 = t == null;
                boolean z3 = t instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.BuiltInFictitiousFunctionClassFactory;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.GetContactSyncConfig.dispose();
                    return;
                } else if (z2) {
                    i = this.moveToNextValue.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) t;
                    if (subjectWork.KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (!this.PlaceComponentResult) {
                            UnicastSubject<T> KClassImpl$Data$declaredNonStaticMembers$2 = UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
                            list.add(KClassImpl$Data$declaredNonStaticMembers$2);
                            observer.onNext(KClassImpl$Data$declaredNonStaticMembers$2);
                            this.GetContactSyncConfig.schedule(new CompletionTask(KClassImpl$Data$declaredNonStaticMembers$2), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        }
                    } else {
                        list.remove(subjectWork.PlaceComponentResult);
                        subjectWork.PlaceComponentResult.onComplete();
                        if (list.isEmpty() && this.PlaceComponentResult) {
                            this.getErrorConfigVersion = true;
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(t);
                    }
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.GetContactSyncConfig.dispose();
        }

        @Override // java.lang.Runnable
        public final void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest), true);
            if (!this.PlaceComponentResult) {
                this.getAuthRequestContext.offer(subjectWork);
            }
            if (MyBillsEntityDataFactory()) {
                lookAheadTest();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public static final class SubjectWork<T> {
            final boolean KClassImpl$Data$declaredNonStaticMembers$2;
            final UnicastSubject<T> PlaceComponentResult;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                this.PlaceComponentResult = unicastSubject;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public final class CompletionTask implements Runnable {
            private final UnicastSubject<T> PlaceComponentResult;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.PlaceComponentResult = unicastSubject;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WindowSkipObserver.this.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
            }
        }
    }
}

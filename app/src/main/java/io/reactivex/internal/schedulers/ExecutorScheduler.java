package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ExecutorScheduler extends Scheduler {
    static final Scheduler PlaceComponentResult = Schedulers.BuiltInFictitiousFunctionClassFactory();
    final boolean BuiltInFictitiousFunctionClassFactory = false;
    final Executor getAuthRequestContext;

    public ExecutorScheduler(Executor executor) {
        this.getAuthRequestContext = executor;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable) {
        Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
        try {
            if (this.getAuthRequestContext instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(KClassImpl$Data$declaredNonStaticMembers$2);
                scheduledDirectTask.setFuture(((ExecutorService) this.getAuthRequestContext).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.BuiltInFictitiousFunctionClassFactory) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(KClassImpl$Data$declaredNonStaticMembers$2, null);
                this.getAuthRequestContext.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(KClassImpl$Data$declaredNonStaticMembers$2);
                this.getAuthRequestContext.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.PlaceComponentResult(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
        if (this.getAuthRequestContext instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(KClassImpl$Data$declaredNonStaticMembers$2);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.getAuthRequestContext).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.PlaceComponentResult(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable delayedRunnable = new DelayedRunnable(KClassImpl$Data$declaredNonStaticMembers$2);
        delayedRunnable.timed.replace(PlaceComponentResult.scheduleDirect(new DelayedDispose(delayedRunnable), j, timeUnit));
        return delayedRunnable;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (this.getAuthRequestContext instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable));
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.getAuthRequestContext).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.PlaceComponentResult(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    /* loaded from: classes6.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        final boolean BuiltInFictitiousFunctionClassFactory;
        volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Executor MyBillsEntityDataFactory;
        final AtomicInteger NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicInteger();
        final CompositeDisposable getAuthRequestContext = new CompositeDisposable();
        final MpscLinkedQueue<Runnable> PlaceComponentResult = new MpscLinkedQueue<>();

        public ExecutorWorker(Executor executor, boolean z) {
            this.MyBillsEntityDataFactory = executor;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            Disposable booleanRunnable;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                booleanRunnable = new InterruptibleRunnable(KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
                this.getAuthRequestContext.getAuthRequestContext(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.PlaceComponentResult.offer(booleanRunnable);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndIncrement() == 0) {
                try {
                    this.MyBillsEntityDataFactory.execute(this);
                } catch (RejectedExecutionException e) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    this.PlaceComponentResult.clear();
                    RxJavaPlugins.PlaceComponentResult(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable)), this.getAuthRequestContext);
            this.getAuthRequestContext.getAuthRequestContext(scheduledRunnable);
            Executor executor = this.MyBillsEntityDataFactory;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    RxJavaPlugins.PlaceComponentResult(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.PlaceComponentResult.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.getAuthRequestContext.dispose();
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndIncrement() == 0) {
                this.PlaceComponentResult.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.PlaceComponentResult;
            int i = 1;
            while (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                do {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll != null) {
                        poll.run();
                    } else if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        i = this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } while (!this.KClassImpl$Data$declaredNonStaticMembers$2);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        /* loaded from: classes6.dex */
        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return get();
            }
        }

        /* loaded from: classes6.dex */
        final class SequentialDispose implements Runnable {
            private final Runnable BuiltInFictitiousFunctionClassFactory;
            private final SequentialDisposable MyBillsEntityDataFactory;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                ExecutorWorker.this = r1;
                this.MyBillsEntityDataFactory = sequentialDisposable;
                this.BuiltInFictitiousFunctionClassFactory = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.MyBillsEntityDataFactory.replace(ExecutorWorker.this.schedule(this.BuiltInFictitiousFunctionClassFactory));
            }
        }

        /* loaded from: classes6.dex */
        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final DisposableContainer tasks;
            volatile Thread thread;
            public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {107, 3, 14, 112, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
            public static final int getAuthRequestContext = 42;

            private static void a(int i, byte b, byte b2, Object[] objArr) {
                int i2 = (i * 12) + 4;
                int i3 = (b * 3) + 13;
                byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
                int i4 = (b2 * 7) + 99;
                byte[] bArr2 = new byte[i3];
                int i5 = -1;
                int i6 = i3 - 1;
                if (bArr == null) {
                    i2++;
                    i4 = i6 + i4 + 2;
                    i6 = i6;
                }
                while (true) {
                    i5++;
                    bArr2[i5] = (byte) i4;
                    if (i5 == i6) {
                        objArr[0] = new String(bArr2, 0);
                        return;
                    }
                    int i7 = i4;
                    int i8 = i6;
                    i2++;
                    i4 = i7 + bArr[i2] + 2;
                    i6 = i8;
                }
            }

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.run = runnable;
                this.tasks = disposableContainer;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (get() == 0) {
                    try {
                        byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        this.thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                        if (compareAndSet(0, 1)) {
                            try {
                                this.run.run();
                                this.thread = null;
                                if (compareAndSet(1, 2)) {
                                    cleanup();
                                    return;
                                }
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                                return;
                            } catch (Throwable th) {
                                this.thread = null;
                                if (compareAndSet(1, 2)) {
                                    cleanup();
                                } else {
                                    while (get() == 3) {
                                        Thread.yield();
                                    }
                                    Thread.interrupted();
                                }
                                throw th;
                            }
                        }
                        this.thread = null;
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause == null) {
                            throw th2;
                        }
                        throw cause;
                    }
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            final void cleanup() {
                DisposableContainer disposableContainer = this.tasks;
                if (disposableContainer != null) {
                    disposableContainer.MyBillsEntityDataFactory(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return get() >= 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get() == null;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public final Runnable getWrappedRunnable() {
            Runnable runnable = get();
            return runnable == null ? Functions.getErrorConfigVersion : runnable;
        }
    }

    /* loaded from: classes6.dex */
    final class DelayedDispose implements Runnable {
        private final DelayedRunnable BuiltInFictitiousFunctionClassFactory;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            ExecutorScheduler.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.BuiltInFictitiousFunctionClassFactory.direct.replace(ExecutorScheduler.this.scheduleDirect(this.BuiltInFictitiousFunctionClassFactory));
        }
    }
}

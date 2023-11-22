package io.reactivex;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    /* loaded from: classes.dex */
    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(now + timeUnit.toNanos(j), KClassImpl$Data$declaredNonStaticMembers$2, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long BuiltInFictitiousFunctionClassFactory;
            final long KClassImpl$Data$declaredNonStaticMembers$2;
            final Runnable MyBillsEntityDataFactory;
            final SequentialDisposable PlaceComponentResult;
            long getAuthRequestContext;
            long getErrorConfigVersion;

            PeriodicTask(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.MyBillsEntityDataFactory = runnable;
                this.PlaceComponentResult = sequentialDisposable;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = j3;
                this.BuiltInFictitiousFunctionClassFactory = j2;
                this.getErrorConfigVersion = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                long j;
                this.MyBillsEntityDataFactory.run();
                if (this.PlaceComponentResult.isDisposed()) {
                    return;
                }
                long now = Worker.this.now(TimeUnit.NANOSECONDS);
                long j2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                long j3 = this.BuiltInFictitiousFunctionClassFactory;
                if (j2 + now < j3 || now >= j3 + this.KClassImpl$Data$declaredNonStaticMembers$2 + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                    long j4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    long j5 = now + j4;
                    long j6 = this.getAuthRequestContext + 1;
                    this.getAuthRequestContext = j6;
                    this.getErrorConfigVersion = j5 - (j4 * j6);
                    j = j5;
                } else {
                    long j7 = this.getErrorConfigVersion;
                    long j8 = this.getAuthRequestContext + 1;
                    this.getAuthRequestContext = j8;
                    j = j7 + (j8 * this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                this.BuiltInFictitiousFunctionClassFactory = now;
                this.PlaceComponentResult.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Runnable MyBillsEntityDataFactory;
        final Worker getAuthRequestContext;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.MyBillsEntityDataFactory = runnable;
            this.getAuthRequestContext = worker;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            try {
                this.MyBillsEntityDataFactory.run();
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.getAuthRequestContext.dispose();
                throw ExceptionHelper.MyBillsEntityDataFactory(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.getAuthRequestContext.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        Thread BuiltInFictitiousFunctionClassFactory;
        final Worker KClassImpl$Data$declaredNonStaticMembers$2;
        final Runnable PlaceComponentResult;
        public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, 18, -76, 65, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int MyBillsEntityDataFactory = 65;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 12
                int r6 = 16 - r6
                int r8 = r8 * 7
                int r8 = 106 - r8
                byte[] r0 = io.reactivex.Scheduler.DisposeTask.getAuthRequestContext
                int r7 = r7 * 3
                int r7 = 16 - r7
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1d
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L36
            L1d:
                r3 = 0
            L1e:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L36:
                int r6 = -r6
                int r7 = r7 + 1
                int r8 = r8 + r6
                int r8 = r8 + 2
                r6 = r7
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Scheduler.DisposeTask.a(byte, short, byte, java.lang.Object[]):void");
        }

        DisposeTask(Runnable runnable, Worker worker) {
            this.PlaceComponentResult = runnable;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = worker;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                byte b = (byte) (getAuthRequestContext[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-getAuthRequestContext[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                this.BuiltInFictitiousFunctionClassFactory = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                try {
                    this.PlaceComponentResult.run();
                } finally {
                    dispose();
                    this.BuiltInFictitiousFunctionClassFactory = null;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Thread thread = this.BuiltInFictitiousFunctionClassFactory;
            try {
                byte b = (byte) (getAuthRequestContext[15] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-getAuthRequestContext[15]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                if (thread == cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                    Worker worker = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (worker instanceof NewThreadWorker) {
                        NewThreadWorker newThreadWorker = (NewThreadWorker) worker;
                        if (newThreadWorker.PlaceComponentResult) {
                            return;
                        }
                        newThreadWorker.PlaceComponentResult = true;
                        newThreadWorker.KClassImpl$Data$declaredNonStaticMembers$2.shutdown();
                        return;
                    }
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
        }
    }
}

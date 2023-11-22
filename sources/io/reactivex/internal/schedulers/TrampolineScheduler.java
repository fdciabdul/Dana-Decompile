package io.reactivex.internal.schedulers;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class TrampolineScheduler extends Scheduler {
    public static final byte[] getAuthRequestContext = {59, -103, 22, 57, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 163;
    private static final TrampolineScheduler PlaceComponentResult = new TrampolineScheduler();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.reactivex.internal.schedulers.TrampolineScheduler.getAuthRequestContext
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L18:
            r3 = 0
        L19:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.TrampolineScheduler.a(byte, byte, byte, java.lang.Object[]):void");
    }

    public static TrampolineScheduler MyBillsEntityDataFactory() {
        return PlaceComponentResult;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    TrampolineScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable) {
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable).run();
        } catch (InterruptedException e) {
            try {
                byte b = (byte) (getAuthRequestContext[15] - 1);
                Object[] objArr = new Object[1];
                a(b, b, getAuthRequestContext[22], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = getAuthRequestContext[15];
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (-b3), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                RxJavaPlugins.PlaceComponentResult(e);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes6.dex */
    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        volatile boolean BuiltInFictitiousFunctionClassFactory;
        final PriorityBlockingQueue<TimedRunnable> getAuthRequestContext = new PriorityBlockingQueue<>();
        private final AtomicInteger MyBillsEntityDataFactory = new AtomicInteger();
        final AtomicInteger KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicInteger();

        TrampolineWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            return getAuthRequestContext(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return getAuthRequestContext(new SleepingRunnable(runnable, this, now), now);
        }

        private Disposable getAuthRequestContext(Runnable runnable, long j) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.KClassImpl$Data$declaredNonStaticMembers$2.incrementAndGet());
            this.getAuthRequestContext.add(timedRunnable);
            if (this.MyBillsEntityDataFactory.getAndIncrement() == 0) {
                int i = 1;
                while (!this.BuiltInFictitiousFunctionClassFactory) {
                    TimedRunnable poll = this.getAuthRequestContext.poll();
                    if (poll != null) {
                        if (!poll.KClassImpl$Data$declaredNonStaticMembers$2) {
                            poll.MyBillsEntityDataFactory.run();
                        }
                    } else {
                        i = this.MyBillsEntityDataFactory.addAndGet(-i);
                        if (i == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    }
                }
                this.getAuthRequestContext.clear();
                return EmptyDisposable.INSTANCE;
            }
            return Disposables.getAuthRequestContext(new AppendToQueueTask(timedRunnable));
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.BuiltInFictitiousFunctionClassFactory = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public final class AppendToQueueTask implements Runnable {
            final TimedRunnable getAuthRequestContext;

            AppendToQueueTask(TimedRunnable timedRunnable) {
                this.getAuthRequestContext = timedRunnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                TrampolineWorker.this.getAuthRequestContext.remove(this.getAuthRequestContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long BuiltInFictitiousFunctionClassFactory;
        volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Runnable MyBillsEntityDataFactory;
        final int PlaceComponentResult;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(TimedRunnable timedRunnable) {
            TimedRunnable timedRunnable2 = timedRunnable;
            int BuiltInFictitiousFunctionClassFactory = ObjectHelper.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, timedRunnable2.BuiltInFictitiousFunctionClassFactory);
            return BuiltInFictitiousFunctionClassFactory == 0 ? ObjectHelper.getAuthRequestContext(this.PlaceComponentResult, timedRunnable2.PlaceComponentResult) : BuiltInFictitiousFunctionClassFactory;
        }

        TimedRunnable(Runnable runnable, Long l, int i) {
            this.MyBillsEntityDataFactory = runnable;
            this.BuiltInFictitiousFunctionClassFactory = l.longValue();
            this.PlaceComponentResult = i;
        }
    }

    /* loaded from: classes6.dex */
    static final class SleepingRunnable implements Runnable {
        private final Runnable KClassImpl$Data$declaredNonStaticMembers$2;
        private final long PlaceComponentResult;
        private final TrampolineWorker getAuthRequestContext;
        public static final byte[] MyBillsEntityDataFactory = {107, -117, Ascii.NAK, -50, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int BuiltInFictitiousFunctionClassFactory = 18;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 7
                int r7 = 106 - r7
                byte[] r0 = io.reactivex.internal.schedulers.TrampolineScheduler.SleepingRunnable.MyBillsEntityDataFactory
                int r8 = r8 * 3
                int r8 = 16 - r8
                int r6 = r6 + 4
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L18
                r7 = r6
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L35
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                int r6 = r6 + 1
                if (r3 != r8) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2a:
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L35:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.TrampolineScheduler.SleepingRunnable.a(byte, int, int, java.lang.Object[]):void");
        }

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
            this.getAuthRequestContext = trampolineWorker;
            this.PlaceComponentResult = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            long now = this.getAuthRequestContext.now(TimeUnit.MILLISECONDS);
            long j = this.PlaceComponentResult;
            if (j > now) {
                try {
                    Thread.sleep(j - now);
                } catch (InterruptedException e) {
                    try {
                        byte b = MyBillsEntityDataFactory[16];
                        byte b2 = (byte) (MyBillsEntityDataFactory[15] + 1);
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = MyBillsEntityDataFactory[15];
                        byte b4 = (byte) (-b3);
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                        RxJavaPlugins.PlaceComponentResult(e);
                        return;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
            }
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.run();
        }
    }
}

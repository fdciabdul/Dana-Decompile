package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public final class TestScheduler extends Scheduler {
    volatile long BuiltInFictitiousFunctionClassFactory;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    final Queue<TimedRunnable> MyBillsEntityDataFactory = new PriorityBlockingQueue(11);

    /* loaded from: classes9.dex */
    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final TestWorker BuiltInFictitiousFunctionClassFactory;
        final long KClassImpl$Data$declaredNonStaticMembers$2;
        final Runnable MyBillsEntityDataFactory;
        final long PlaceComponentResult;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(TimedRunnable timedRunnable) {
            TimedRunnable timedRunnable2 = timedRunnable;
            long j = this.PlaceComponentResult;
            long j2 = timedRunnable2.PlaceComponentResult;
            if (j == j2) {
                return ObjectHelper.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, timedRunnable2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return ObjectHelper.BuiltInFictitiousFunctionClassFactory(j, j2);
        }

        TimedRunnable(TestWorker testWorker, long j, Runnable runnable, long j2) {
            this.PlaceComponentResult = j;
            this.MyBillsEntityDataFactory = runnable;
            this.BuiltInFictitiousFunctionClassFactory = testWorker;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j2;
        }

        public final String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.PlaceComponentResult), this.MyBillsEntityDataFactory.toString());
        }
    }

    @Override // io.reactivex.Scheduler
    public final long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.BuiltInFictitiousFunctionClassFactory, TimeUnit.NANOSECONDS);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    /* loaded from: classes9.dex */
    final class TestWorker extends Scheduler.Worker {
        volatile boolean PlaceComponentResult;

        TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.PlaceComponentResult) {
                return EmptyDisposable.INSTANCE;
            }
            long j2 = TestScheduler.this.BuiltInFictitiousFunctionClassFactory;
            long nanos = timeUnit.toNanos(j);
            TestScheduler testScheduler = TestScheduler.this;
            long j3 = testScheduler.KClassImpl$Data$declaredNonStaticMembers$2;
            testScheduler.KClassImpl$Data$declaredNonStaticMembers$2 = 1 + j3;
            TimedRunnable timedRunnable = new TimedRunnable(this, j2 + nanos, runnable, j3);
            TestScheduler.this.MyBillsEntityDataFactory.add(timedRunnable);
            return Disposables.getAuthRequestContext(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            if (this.PlaceComponentResult) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j = testScheduler.KClassImpl$Data$declaredNonStaticMembers$2;
            testScheduler.KClassImpl$Data$declaredNonStaticMembers$2 = 1 + j;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j);
            TestScheduler.this.MyBillsEntityDataFactory.add(timedRunnable);
            return Disposables.getAuthRequestContext(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        public final long now(TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        /* loaded from: classes9.dex */
        final class QueueRemove implements Runnable {
            final TimedRunnable MyBillsEntityDataFactory;

            QueueRemove(TimedRunnable timedRunnable) {
                this.MyBillsEntityDataFactory = timedRunnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                TestScheduler.this.MyBillsEntityDataFactory.remove(this.MyBillsEntityDataFactory);
            }
        }
    }
}

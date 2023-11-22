package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class HandlerScheduler extends Scheduler {
    private final boolean BuiltInFictitiousFunctionClassFactory = false;
    private final Handler PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler) {
        this.PlaceComponentResult = handler;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.PlaceComponentResult, RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable));
            Message obtain = Message.obtain(this.PlaceComponentResult, scheduledRunnable);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                obtain.setAsynchronous(true);
            }
            this.PlaceComponentResult.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return scheduledRunnable;
        }
        throw new NullPointerException("run == null");
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new HandlerWorker(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
    }

    /* loaded from: classes.dex */
    static final class HandlerWorker extends Scheduler.Worker {
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Handler MyBillsEntityDataFactory;
        private volatile boolean PlaceComponentResult;

        HandlerWorker(Handler handler, boolean z) {
            this.MyBillsEntityDataFactory = handler;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit == null) {
                    throw new NullPointerException("unit == null");
                }
                if (this.PlaceComponentResult) {
                    return Disposables.BuiltInFictitiousFunctionClassFactory();
                }
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.MyBillsEntityDataFactory, RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable));
                Message obtain = Message.obtain(this.MyBillsEntityDataFactory, scheduledRunnable);
                obtain.obj = this;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    obtain.setAsynchronous(true);
                }
                this.MyBillsEntityDataFactory.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.PlaceComponentResult) {
                    this.MyBillsEntityDataFactory.removeCallbacks(scheduledRunnable);
                    return Disposables.BuiltInFictitiousFunctionClassFactory();
                }
                return scheduledRunnable;
            }
            throw new NullPointerException("run == null");
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult = true;
            this.MyBillsEntityDataFactory.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.PlaceComponentResult;
        }
    }

    /* loaded from: classes.dex */
    static final class ScheduledRunnable implements Runnable, Disposable {
        private volatile boolean MyBillsEntityDataFactory;
        private final Handler PlaceComponentResult;
        private final Runnable getAuthRequestContext;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.PlaceComponentResult = handler;
            this.getAuthRequestContext = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.getAuthRequestContext.run();
            } catch (Throwable th) {
                RxJavaPlugins.PlaceComponentResult(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.PlaceComponentResult.removeCallbacks(this);
            this.MyBillsEntityDataFactory = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory;
        }
    }
}

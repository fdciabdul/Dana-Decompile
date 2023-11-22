package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes6.dex */
public final class NewThreadScheduler extends Scheduler {
    private static final RxThreadFactory MyBillsEntityDataFactory = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory KClassImpl$Data$declaredNonStaticMembers$2;

    public NewThreadScheduler() {
        this(MyBillsEntityDataFactory);
    }

    private NewThreadScheduler(ThreadFactory threadFactory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = threadFactory;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}

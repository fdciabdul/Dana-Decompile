package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

/* loaded from: classes6.dex */
public interface SchedulerMultiWorkerSupport {

    /* loaded from: classes9.dex */
    public interface WorkerCallback {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i, Scheduler.Worker worker);
    }

    void PlaceComponentResult(int i, WorkerCallback workerCallback);
}

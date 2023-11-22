package androidx.work.impl.utils;

import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
public class WorkTimer {
    public static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("WorkTimer");
    public final Map<String, WorkTimerRunnable> BuiltInFictitiousFunctionClassFactory;
    public final Map<String, TimeLimitExceededListener> KClassImpl$Data$declaredNonStaticMembers$2;
    public final Object MyBillsEntityDataFactory;
    public final ScheduledExecutorService PlaceComponentResult;
    private final ThreadFactory lookAheadTest;

    /* loaded from: classes3.dex */
    public interface TimeLimitExceededListener {
        void getAuthRequestContext(String str);
    }

    public WorkTimer() {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.work.impl.utils.WorkTimer.1
            private int MyBillsEntityDataFactory = 0;

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("WorkManager-WorkTimer-thread-");
                sb.append(this.MyBillsEntityDataFactory);
                newThread.setName(sb.toString());
                this.MyBillsEntityDataFactory++;
                return newThread;
            }
        };
        this.lookAheadTest = threadFactory;
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
        this.MyBillsEntityDataFactory = new Object();
        this.PlaceComponentResult = Executors.newSingleThreadScheduledExecutor(threadFactory);
    }

    public final void getAuthRequestContext(String str) {
        synchronized (this.MyBillsEntityDataFactory) {
            if (this.BuiltInFictitiousFunctionClassFactory.remove(str) != null) {
                Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class WorkTimerRunnable implements Runnable {
        private final String BuiltInFictitiousFunctionClassFactory;
        private final WorkTimer KClassImpl$Data$declaredNonStaticMembers$2;

        public WorkTimerRunnable(WorkTimer workTimer, String str) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = workTimer;
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.remove(this.BuiltInFictitiousFunctionClassFactory) != null) {
                    TimeLimitExceededListener remove = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.remove(this.BuiltInFictitiousFunctionClassFactory);
                    if (remove != null) {
                        remove.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
                    }
                } else {
                    Logger.getAuthRequestContext().PlaceComponentResult("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.BuiltInFictitiousFunctionClassFactory), new Throwable[0]);
                }
            }
        }
    }
}

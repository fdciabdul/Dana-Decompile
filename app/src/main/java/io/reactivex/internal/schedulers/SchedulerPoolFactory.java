package io.reactivex.internal.schedulers;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import id.dana.sendmoney.summary.SummaryActivity;
import io.reactivex.functions.Function;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SchedulerPoolFactory {
    public static final boolean BuiltInFictitiousFunctionClassFactory;
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    static final AtomicReference<ScheduledExecutorService> getAuthRequestContext = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> MyBillsEntityDataFactory = new ConcurrentHashMap();

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        boolean authRequestContext = getAuthRequestContext("rx2.purge-enabled", systemPropertyAccessor);
        BuiltInFictitiousFunctionClassFactory = authRequestContext;
        KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(authRequestContext, "rx2.purge-period-seconds", systemPropertyAccessor);
        if (!BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = getAuthRequestContext;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                long j = KClassImpl$Data$declaredNonStaticMembers$2;
                newScheduledThreadPool.scheduleAtFixedRate(scheduledTask, j, j, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    private static int BuiltInFictitiousFunctionClassFactory(boolean z, String str, Function<String, String> function) {
        if (z) {
            try {
                String apply = function.apply(str);
                if (apply == null) {
                    return 1;
                }
                return Integer.parseInt(apply);
            } catch (Throwable unused) {
            }
        }
        return 1;
    }

    private static boolean getAuthRequestContext(String str, Function<String, String> function) {
        try {
            String apply = function.apply(str);
            if (apply == null) {
                return true;
            }
            return SummaryActivity.CHECKED.equals(apply);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    static final class SystemPropertyAccessor implements Function<String, String> {
        SystemPropertyAccessor() {
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    public static ScheduledExecutorService KClassImpl$Data$declaredNonStaticMembers$2(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (BuiltInFictitiousFunctionClassFactory && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            MyBillsEntityDataFactory.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }

    /* loaded from: classes6.dex */
    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.MyBillsEntityDataFactory.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.MyBillsEntityDataFactory.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }
}

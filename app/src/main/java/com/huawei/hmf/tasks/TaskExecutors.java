package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
public final class TaskExecutors {
    private static final TaskExecutors BuiltInFictitiousFunctionClassFactory = new TaskExecutors();
    private final Executor MyBillsEntityDataFactory;
    private final ExecutorService KClassImpl$Data$declaredNonStaticMembers$2 = a.MyBillsEntityDataFactory();
    private final Executor getAuthRequestContext = new ImmediateExecutor();

    /* loaded from: classes7.dex */
    static final class ImmediateExecutor implements Executor {
        ImmediateExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private TaskExecutors() {
        Executor executor;
        executor = a.MyBillsEntityDataFactory.PlaceComponentResult;
        this.MyBillsEntityDataFactory = executor;
    }

    public static Executor MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
    }
}

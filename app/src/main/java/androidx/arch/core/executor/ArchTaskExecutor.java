package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {
    private static volatile ArchTaskExecutor PlaceComponentResult;
    public TaskExecutor BuiltInFictitiousFunctionClassFactory;
    private TaskExecutor MyBillsEntityDataFactory;
    private static final Executor getAuthRequestContext = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
        }
    };
    private static final Executor KClassImpl$Data$declaredNonStaticMembers$2 = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(runnable);
        }
    };

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.MyBillsEntityDataFactory = defaultTaskExecutor;
        this.BuiltInFictitiousFunctionClassFactory = defaultTaskExecutor;
    }

    public static ArchTaskExecutor MyBillsEntityDataFactory() {
        if (PlaceComponentResult != null) {
            return PlaceComponentResult;
        }
        synchronized (ArchTaskExecutor.class) {
            if (PlaceComponentResult == null) {
                PlaceComponentResult = new ArchTaskExecutor();
            }
        }
        return PlaceComponentResult;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final void getAuthRequestContext(Runnable runnable) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
    }

    public static Executor getAuthRequestContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }
}

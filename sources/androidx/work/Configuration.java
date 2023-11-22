package androidx.work;

import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class Configuration {
    public final int BuiltInFictitiousFunctionClassFactory;
    private final boolean GetContactSyncConfig;
    public final InitializationExceptionHandler KClassImpl$Data$declaredNonStaticMembers$2;
    public final InputMergerFactory MyBillsEntityDataFactory;
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final WorkerFactory NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final String PlaceComponentResult;
    public final Executor getAuthRequestContext;
    public final int getErrorConfigVersion;
    public final int lookAheadTest;
    public final RunnableScheduler moveToNextValue;
    public final Executor scheduleImpl;

    /* loaded from: classes.dex */
    public static final class Builder {
        Executor KClassImpl$Data$declaredNonStaticMembers$2;
        String MyBillsEntityDataFactory;
        public WorkerFactory NetworkUserEntityData$$ExternalSyntheticLambda2;
        InitializationExceptionHandler PlaceComponentResult;
        InputMergerFactory getAuthRequestContext;
        Executor getErrorConfigVersion;
        RunnableScheduler moveToNextValue;
        public int BuiltInFictitiousFunctionClassFactory = 4;
        int scheduleImpl = 0;
        int lookAheadTest = Integer.MAX_VALUE;
        public int NetworkUserEntityData$$ExternalSyntheticLambda0 = 20;
    }

    /* loaded from: classes.dex */
    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        final boolean z = false;
        final boolean z2 = true;
        if (builder.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.getAuthRequestContext = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.Configuration.1
                private final AtomicInteger getAuthRequestContext = new AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    String str = z ? "WM.task-" : "androidx.work-";
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.getAuthRequestContext.incrementAndGet());
                    return new Thread(runnable, sb.toString());
                }
            });
        } else {
            this.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (builder.getErrorConfigVersion == null) {
            this.GetContactSyncConfig = true;
            this.scheduleImpl = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.Configuration.1
                private final AtomicInteger getAuthRequestContext = new AtomicInteger(0);

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    String str = z2 ? "WM.task-" : "androidx.work-";
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(this.getAuthRequestContext.incrementAndGet());
                    return new Thread(runnable, sb.toString());
                }
            });
        } else {
            this.GetContactSyncConfig = false;
            this.scheduleImpl = builder.getErrorConfigVersion;
        }
        if (builder.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = WorkerFactory.BuiltInFictitiousFunctionClassFactory();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        if (builder.getAuthRequestContext == null) {
            this.MyBillsEntityDataFactory = InputMergerFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            this.MyBillsEntityDataFactory = builder.getAuthRequestContext;
        }
        if (builder.moveToNextValue == null) {
            this.moveToNextValue = new DefaultRunnableScheduler();
        } else {
            this.moveToNextValue = builder.moveToNextValue;
        }
        this.BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.scheduleImpl;
        this.lookAheadTest = builder.lookAheadTest;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult;
        this.PlaceComponentResult = builder.MyBillsEntityDataFactory;
    }
}

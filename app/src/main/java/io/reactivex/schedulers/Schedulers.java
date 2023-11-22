package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Schedulers {
    static final Scheduler BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.getAuthRequestContext(new SingleTask());
    static final Scheduler PlaceComponentResult = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new ComputationTask());
    static final Scheduler KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.PlaceComponentResult(new IOTask());
    static final Scheduler MyBillsEntityDataFactory = TrampolineScheduler.MyBillsEntityDataFactory();
    static final Scheduler getAuthRequestContext = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new NewThreadTask());

    /* loaded from: classes2.dex */
    static final class SingleHolder {
        static final Scheduler KClassImpl$Data$declaredNonStaticMembers$2 = new SingleScheduler();

        SingleHolder() {
        }
    }

    /* loaded from: classes2.dex */
    static final class ComputationHolder {
        static final Scheduler BuiltInFictitiousFunctionClassFactory = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    /* loaded from: classes2.dex */
    static final class IoHolder {
        static final Scheduler BuiltInFictitiousFunctionClassFactory = new IoScheduler();

        IoHolder() {
        }
    }

    /* loaded from: classes2.dex */
    static final class NewThreadHolder {
        static final Scheduler MyBillsEntityDataFactory = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler KClassImpl$Data$declaredNonStaticMembers$2() {
        return RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
    }

    public static Scheduler MyBillsEntityDataFactory() {
        return RxJavaPlugins.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static Scheduler PlaceComponentResult() {
        return MyBillsEntityDataFactory;
    }

    public static Scheduler getAuthRequestContext() {
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext);
    }

    public static Scheduler BuiltInFictitiousFunctionClassFactory() {
        return RxJavaPlugins.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
    }

    public static Scheduler BuiltInFictitiousFunctionClassFactory(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* loaded from: classes2.dex */
    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return IoHolder.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes2.dex */
    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return NewThreadHolder.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes2.dex */
    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return SingleHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes2.dex */
    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        @Override // java.util.concurrent.Callable
        public final /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return ComputationHolder.BuiltInFictitiousFunctionClassFactory;
        }
    }
}

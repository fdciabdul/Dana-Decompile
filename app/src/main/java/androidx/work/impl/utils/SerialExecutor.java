package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class SerialExecutor implements Executor {
    private volatile Runnable BuiltInFictitiousFunctionClassFactory;
    private final ArrayDeque<Task> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayDeque<>();
    private final Object MyBillsEntityDataFactory = new Object();
    private final Executor PlaceComponentResult;

    public SerialExecutor(Executor executor) {
        this.PlaceComponentResult = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.MyBillsEntityDataFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(new Task(this, runnable));
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult();
            }
        }
    }

    final void PlaceComponentResult() {
        synchronized (this.MyBillsEntityDataFactory) {
            Task poll = this.KClassImpl$Data$declaredNonStaticMembers$2.poll();
            this.BuiltInFictitiousFunctionClassFactory = poll;
            if (poll != null) {
                this.PlaceComponentResult.execute(this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        synchronized (this.MyBillsEntityDataFactory) {
            z = !this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Task implements Runnable {
        final Runnable KClassImpl$Data$declaredNonStaticMembers$2;
        final SerialExecutor MyBillsEntityDataFactory;

        Task(SerialExecutor serialExecutor, Runnable runnable) {
            this.MyBillsEntityDataFactory = serialExecutor;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.run();
            } finally {
                this.MyBillsEntityDataFactory.PlaceComponentResult();
            }
        }
    }
}

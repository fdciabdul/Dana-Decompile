package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutor MyBillsEntityDataFactory;
    final Handler PlaceComponentResult = new Handler(Looper.getMainLooper());
    private final Executor BuiltInFictitiousFunctionClassFactory = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.PlaceComponentResult.post(runnable);
        }
    };

    public WorkManagerTaskExecutor(Executor executor) {
        this.MyBillsEntityDataFactory = new SerialExecutor(executor);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public final Executor BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public final void getAuthRequestContext(Runnable runnable) {
        this.MyBillsEntityDataFactory.execute(runnable);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public final SerialExecutor MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}

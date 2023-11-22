package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static volatile Executor BuiltInFictitiousFunctionClassFactory;
    public static final Executor KClassImpl$Data$declaredNonStaticMembers$2;
    private static InternalHandler getAuthRequestContext;
    private static final ThreadFactory lookAheadTest;
    private static final BlockingQueue<Runnable> moveToNextValue;
    private final FutureTask<Result> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final WorkerRunnable<Params, Result> scheduleImpl;
    private volatile Status getErrorConfigVersion = Status.PENDING;
    final AtomicBoolean MyBillsEntityDataFactory = new AtomicBoolean();
    final AtomicBoolean PlaceComponentResult = new AtomicBoolean();

    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2(Result result) {
    }

    protected abstract Result PlaceComponentResult(Params... paramsArr);

    protected void getAuthRequestContext(Result result) {
    }

    static {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.loader.content.ModernAsyncTask.1
            private final AtomicInteger getAuthRequestContext = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                StringBuilder sb = new StringBuilder();
                sb.append("ModernAsyncTask #");
                sb.append(this.getAuthRequestContext.getAndIncrement());
                return new Thread(runnable, sb.toString());
            }
        };
        lookAheadTest = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        moveToNextValue = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        KClassImpl$Data$declaredNonStaticMembers$2 = threadPoolExecutor;
        BuiltInFictitiousFunctionClassFactory = threadPoolExecutor;
    }

    static Handler BuiltInFictitiousFunctionClassFactory() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (getAuthRequestContext == null) {
                getAuthRequestContext = new InternalHandler();
            }
            internalHandler = getAuthRequestContext;
        }
        return internalHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModernAsyncTask() {
        WorkerRunnable<Params, Result> workerRunnable = new WorkerRunnable<Params, Result>() { // from class: androidx.loader.content.ModernAsyncTask.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                ModernAsyncTask.this.PlaceComponentResult.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.PlaceComponentResult(this.MyBillsEntityDataFactory);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.BuiltInFictitiousFunctionClassFactory().obtainMessage(1, new AsyncTaskResult(ModernAsyncTask.this, result)).sendToTarget();
                    return result;
                } finally {
                }
            }
        };
        this.scheduleImpl = workerRunnable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new FutureTask<Result>(workerRunnable) { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.util.concurrent.FutureTask
            protected void done() {
                try {
                    Result result = get();
                    ModernAsyncTask modernAsyncTask = ModernAsyncTask.this;
                    if (modernAsyncTask.PlaceComponentResult.get()) {
                        return;
                    }
                    ModernAsyncTask.BuiltInFictitiousFunctionClassFactory().obtainMessage(1, new AsyncTaskResult(modernAsyncTask, result)).sendToTarget();
                } catch (InterruptedException e) {
                    InstrumentInjector.log_w("AsyncTask", e);
                } catch (CancellationException unused) {
                    ModernAsyncTask modernAsyncTask2 = ModernAsyncTask.this;
                    if (modernAsyncTask2.PlaceComponentResult.get()) {
                        return;
                    }
                    ModernAsyncTask.BuiltInFictitiousFunctionClassFactory().obtainMessage(1, new AsyncTaskResult(modernAsyncTask2, null)).sendToTarget();
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.get();
    }

    public final boolean getAuthRequestContext(boolean z) {
        this.MyBillsEntityDataFactory.set(true);
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.cancel(false);
    }

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Status.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final ModernAsyncTask<Params, Progress, Result> getAuthRequestContext(Executor executor, Params... paramsArr) {
        if (this.getErrorConfigVersion != Status.PENDING) {
            int i = AnonymousClass4.PlaceComponentResult[this.getErrorConfigVersion.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
                throw new IllegalStateException("We should never reach this state");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.getErrorConfigVersion = Status.RUNNING;
        this.scheduleImpl.MyBillsEntityDataFactory = null;
        executor.execute(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        return this;
    }

    final void BuiltInFictitiousFunctionClassFactory(Result result) {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2(result);
        } else {
            getAuthRequestContext((ModernAsyncTask<Params, Progress, Result>) result);
        }
        this.getErrorConfigVersion = Status.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(asyncTaskResult.KClassImpl$Data$declaredNonStaticMembers$2[0]);
            } else if (i == 2) {
                ModernAsyncTask modernAsyncTask = asyncTaskResult.getAuthRequestContext;
                Data[] dataArr = asyncTaskResult.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
    }

    /* loaded from: classes3.dex */
    static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] MyBillsEntityDataFactory;

        WorkerRunnable() {
        }
    }

    /* loaded from: classes3.dex */
    static class AsyncTaskResult<Data> {
        final Data[] KClassImpl$Data$declaredNonStaticMembers$2;
        final ModernAsyncTask getAuthRequestContext;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.getAuthRequestContext = modernAsyncTask;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dataArr;
        }
    }
}

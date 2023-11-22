package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("Processor");
    private Configuration NetworkUserEntityData$$ExternalSyntheticLambda0;
    private WorkDatabase NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Context PlaceComponentResult;
    private List<Scheduler> getErrorConfigVersion;
    private TaskExecutor initRecordTimeStamp;
    private Map<String, WorkerWrapper> moveToNextValue = new HashMap();
    private Map<String, WorkerWrapper> scheduleImpl = new HashMap();
    private Set<String> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet();
    public final List<ExecutionListener> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private PowerManager.WakeLock lookAheadTest = null;
    public final Object getAuthRequestContext = new Object();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list) {
        this.PlaceComponentResult = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = configuration;
        this.initRecordTimeStamp = taskExecutor;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = workDatabase;
        this.getErrorConfigVersion = list;
    }

    public final boolean PlaceComponentResult(String str) {
        return MyBillsEntityDataFactory(str, null);
    }

    public final boolean MyBillsEntityDataFactory(String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.getAuthRequestContext) {
            if (BuiltInFictitiousFunctionClassFactory(str)) {
                Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            WorkerWrapper.Builder builder = new WorkerWrapper.Builder(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.initRecordTimeStamp, this, this.NetworkUserEntityData$$ExternalSyntheticLambda2, str);
            builder.BuiltInFictitiousFunctionClassFactory = this.getErrorConfigVersion;
            if (runtimeExtras != null) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = runtimeExtras;
            }
            WorkerWrapper workerWrapper = new WorkerWrapper(builder);
            SettableFuture<Boolean> settableFuture = workerWrapper.PlaceComponentResult;
            settableFuture.addListener(new FutureListener(this, str, settableFuture), this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory());
            this.moveToNextValue.put(str, workerWrapper);
            this.initRecordTimeStamp.MyBillsEntityDataFactory().execute(workerWrapper);
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.getAuthRequestContext) {
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(MyBillsEntityDataFactory, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            WorkerWrapper remove = this.moveToNextValue.remove(str);
            if (remove != null) {
                if (this.lookAheadTest == null) {
                    PowerManager.WakeLock authRequestContext = WakeLocks.getAuthRequestContext(this.PlaceComponentResult, "ProcessorForegroundLck");
                    this.lookAheadTest = authRequestContext;
                    authRequestContext.acquire();
                }
                this.scheduleImpl.put(str, remove);
                ContextCompat.PlaceComponentResult(this.PlaceComponentResult, SystemForegroundDispatcher.getAuthRequestContext(this.PlaceComponentResult, str, foregroundInfo));
            }
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (this.getAuthRequestContext) {
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, this.scheduleImpl.remove(str));
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean getErrorConfigVersion(String str) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (this.getAuthRequestContext) {
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Processor stopping background work %s", str), new Throwable[0]);
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, this.moveToNextValue.remove(str));
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean getAuthRequestContext(String str) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (this.getAuthRequestContext) {
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
            WorkerWrapper remove = this.scheduleImpl.remove(str);
            boolean z = remove != null;
            if (remove == null) {
                remove = this.moveToNextValue.remove(str);
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, remove);
            if (z) {
                getAuthRequestContext();
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public final void lookAheadTest(String str) {
        synchronized (this.getAuthRequestContext) {
            this.scheduleImpl.remove(str);
            getAuthRequestContext();
        }
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        boolean contains;
        synchronized (this.getAuthRequestContext) {
            contains = this.KClassImpl$Data$declaredNonStaticMembers$2.contains(str);
        }
        return contains;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        boolean z;
        synchronized (this.getAuthRequestContext) {
            if (!this.moveToNextValue.containsKey(str)) {
                z = this.scheduleImpl.containsKey(str);
            }
        }
        return z;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        boolean containsKey;
        synchronized (this.getAuthRequestContext) {
            containsKey = this.scheduleImpl.containsKey(str);
        }
        return containsKey;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ExecutionListener executionListener) {
        synchronized (this.getAuthRequestContext) {
            this.BuiltInFictitiousFunctionClassFactory.add(executionListener);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        synchronized (this.getAuthRequestContext) {
            this.moveToNextValue.remove(str);
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            Iterator<ExecutionListener> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                it.next().onExecuted(str, z);
            }
        }
    }

    private void getAuthRequestContext() {
        synchronized (this.getAuthRequestContext) {
            if ((!this.scheduleImpl.isEmpty()) == false) {
                try {
                    this.PlaceComponentResult.startService(SystemForegroundDispatcher.getAuthRequestContext(this.PlaceComponentResult));
                } catch (Throwable th) {
                    Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.lookAheadTest;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.lookAheadTest = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FutureListener implements Runnable {
        private ListenableFuture<Boolean> BuiltInFictitiousFunctionClassFactory;
        private ExecutionListener KClassImpl$Data$declaredNonStaticMembers$2;
        private String PlaceComponentResult;

        FutureListener(ExecutionListener executionListener, String str, ListenableFuture<Boolean> listenableFuture) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = executionListener;
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = this.BuiltInFictitiousFunctionClassFactory.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.onExecuted(this.PlaceComponentResult, z);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, WorkerWrapper workerWrapper) {
        boolean z;
        if (workerWrapper == null) {
            Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        workerWrapper.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        workerWrapper.MyBillsEntityDataFactory();
        ListenableFuture<ListenableWorker.Result> listenableFuture = workerWrapper.MyBillsEntityDataFactory;
        if (listenableFuture != null) {
            z = listenableFuture.isDone();
            workerWrapper.MyBillsEntityDataFactory.cancel(true);
        } else {
            z = false;
        }
        ListenableWorker listenableWorker = workerWrapper.getErrorConfigVersion;
        if (listenableWorker != null && !z) {
            listenableWorker.stop();
        } else {
            Logger.getAuthRequestContext().PlaceComponentResult(WorkerWrapper.getAuthRequestContext, String.format("WorkSpec %s is already done. Not interrupting.", workerWrapper.moveToNextValue), new Throwable[0]);
        }
        Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }
}

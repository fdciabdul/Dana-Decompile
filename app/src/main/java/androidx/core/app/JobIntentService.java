package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes3.dex */
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    final ArrayList<CompatWorkItem> mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    CompatJobEngine mJobImpl;
    static final Object sLock = new Object();
    static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer = new HashMap<>();
    boolean mInterruptIfStopped = false;
    boolean mStopped = false;
    boolean mDestroyed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface CompatJobEngine {
        IBinder BuiltInFictitiousFunctionClassFactory();

        GenericWorkItem MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface GenericWorkItem {
        Intent BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext();
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    protected abstract void onHandleWork(Intent intent);

    public boolean onStopCurrentWork() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class WorkEnqueuer {
        int BuiltInFictitiousFunctionClassFactory;
        final ComponentName KClassImpl$Data$declaredNonStaticMembers$2;
        boolean PlaceComponentResult;

        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        public void MyBillsEntityDataFactory() {
        }

        abstract void MyBillsEntityDataFactory(Intent intent);

        WorkEnqueuer(ComponentName componentName) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = componentName;
        }

        void MyBillsEntityDataFactory(int i) {
            if (!this.PlaceComponentResult) {
                this.PlaceComponentResult = true;
                this.BuiltInFictitiousFunctionClassFactory = i;
            } else if (this.BuiltInFictitiousFunctionClassFactory == i) {
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Given job ID ");
                sb.append(i);
                sb.append(" is different than previous ");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        boolean MyBillsEntityDataFactory;
        private final PowerManager.WakeLock NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean getAuthRequestContext;
        private final PowerManager.WakeLock moveToNextValue;
        private final Context scheduleImpl;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.scheduleImpl = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder sb = new StringBuilder();
            sb.append(componentName.getClassName());
            sb.append(":launch");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, sb.toString());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(componentName.getClassName());
            sb2.append(":run");
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, sb2.toString());
            this.moveToNextValue = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        final void MyBillsEntityDataFactory(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.scheduleImpl.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.MyBillsEntityDataFactory) {
                        this.MyBillsEntityDataFactory = true;
                        if (!this.getAuthRequestContext) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void MyBillsEntityDataFactory() {
            synchronized (this) {
                this.MyBillsEntityDataFactory = false;
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            synchronized (this) {
                if (!this.getAuthRequestContext) {
                    this.getAuthRequestContext = true;
                    this.moveToNextValue.acquire(600000L);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public final void BuiltInFictitiousFunctionClassFactory() {
            synchronized (this) {
                if (this.getAuthRequestContext) {
                    if (this.MyBillsEntityDataFactory) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.acquire(60000L);
                    }
                    this.getAuthRequestContext = false;
                    this.moveToNextValue.release();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        final JobIntentService BuiltInFictitiousFunctionClassFactory;
        JobParameters KClassImpl$Data$declaredNonStaticMembers$2;
        final Object getAuthRequestContext;

        /* loaded from: classes3.dex */
        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem BuiltInFictitiousFunctionClassFactory;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.BuiltInFictitiousFunctionClassFactory = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public final Intent BuiltInFictitiousFunctionClassFactory() {
                return this.BuiltInFictitiousFunctionClassFactory.getIntent();
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public final void getAuthRequestContext() {
                synchronized (JobServiceEngineImpl.this.getAuthRequestContext) {
                    if (JobServiceEngineImpl.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        JobServiceEngineImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.completeWork(this.BuiltInFictitiousFunctionClassFactory);
                    }
                }
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.getAuthRequestContext = new Object();
            this.BuiltInFictitiousFunctionClassFactory = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public final IBinder BuiltInFictitiousFunctionClassFactory() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jobParameters;
            this.BuiltInFictitiousFunctionClassFactory.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.BuiltInFictitiousFunctionClassFactory.doStopCurrentWork();
            synchronized (this.getAuthRequestContext) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            return doStopCurrentWork;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public final GenericWorkItem MyBillsEntityDataFactory() {
            synchronized (this.getAuthRequestContext) {
                JobParameters jobParameters = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (jobParameters == null) {
                    return null;
                }
                JobWorkItem dequeueWork = jobParameters.dequeueWork();
                if (dequeueWork != null) {
                    dequeueWork.getIntent().setExtrasClassLoader(this.BuiltInFictitiousFunctionClassFactory.getClassLoader());
                    return new WrapperWorkItem(dequeueWork);
                }
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobScheduler MyBillsEntityDataFactory;
        private final JobInfo getAuthRequestContext;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            MyBillsEntityDataFactory(i);
            this.getAuthRequestContext = new JobInfo.Builder(i, this.KClassImpl$Data$declaredNonStaticMembers$2).setOverrideDeadline(0L).build();
            this.MyBillsEntityDataFactory = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        final void MyBillsEntityDataFactory(Intent intent) {
            this.MyBillsEntityDataFactory.enqueue(this.getAuthRequestContext, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class CompatWorkItem implements GenericWorkItem {
        final Intent MyBillsEntityDataFactory;
        final int getAuthRequestContext;

        CompatWorkItem(Intent intent, int i) {
            this.MyBillsEntityDataFactory = intent;
            this.getAuthRequestContext = i;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public final Intent BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public final void getAuthRequestContext() {
            JobIntentService.this.stopSelf(this.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            while (true) {
                GenericWorkItem dequeueWork = JobIntentService.this.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                JobIntentService.this.onHandleWork(dequeueWork.BuiltInFictitiousFunctionClassFactory());
                dequeueWork.getAuthRequestContext();
            }
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onCancelled(Void r1) {
            JobIntentService.this.processorFinished();
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Void r1) {
            JobIntentService.this.processorFinished();
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new JobServiceEngineImpl(this);
            this.mCompatWorkEnqueuer = null;
            return;
        }
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mCompatQueue != null) {
            this.mCompatWorkEnqueuer.MyBillsEntityDataFactory();
            synchronized (this.mCompatQueue) {
                ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new CompatWorkItem(intent, i2));
                ensureProcessorRunningLocked(true);
            }
            return 3;
        }
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.BuiltInFictitiousFunctionClassFactory();
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public static void enqueueWork(Context context, Class<?> cls, int i, Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            WorkEnqueuer workEnqueuer = getWorkEnqueuer(context, componentName, true, i);
            workEnqueuer.MyBillsEntityDataFactory(i);
            workEnqueuer.MyBillsEntityDataFactory(intent);
        }
    }

    static WorkEnqueuer getWorkEnqueuer(Context context, ComponentName componentName, boolean z, int i) {
        WorkEnqueuer compatWorkEnqueuer;
        HashMap<ComponentName, WorkEnqueuer> hashMap = sClassWorkEnqueuer;
        WorkEnqueuer workEnqueuer = hashMap.get(componentName);
        if (workEnqueuer == null) {
            if (Build.VERSION.SDK_INT < 26) {
                compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
            } else if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            } else {
                compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i);
            }
            WorkEnqueuer workEnqueuer2 = compatWorkEnqueuer;
            hashMap.put(componentName, workEnqueuer2);
            return workEnqueuer2;
        }
        return workEnqueuer;
    }

    public void setInterruptIfStopped(boolean z) {
        this.mInterruptIfStopped = z;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    boolean doStopCurrentWork() {
        CommandProcessor commandProcessor = this.mCurProcessor;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean z) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.mCompatWorkEnqueuer;
            if (workEnqueuer != null && z) {
                workEnqueuer.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    void processorFinished() {
        ArrayList<CompatWorkItem> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                ArrayList<CompatWorkItem> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }
    }

    GenericWorkItem dequeueWork() {
        CompatJobEngine compatJobEngine = this.mJobImpl;
        if (compatJobEngine != null) {
            return compatJobEngine.MyBillsEntityDataFactory();
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() > 0) {
                return this.mCompatQueue.remove(0);
            }
            return null;
        }
    }
}

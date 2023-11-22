package androidx.core.app;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.SparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 22\u00020\u0001:\u00072345678B\t\b\u0016¢\u0006\u0004\b0\u0010\u0004B\u000f\u0012\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0018\u0010\r\u001a\u0006*\u00020\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001c8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u001d\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010\u001a\u001a\b\u0018\u00010,R\u00020-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Landroidx/core/app/DANAJobIntentService;", "Landroid/app/job/JobService;", "", "onCreate", "()V", "onDestroy", "Landroid/content/Intent;", "intent", "onHandleWork", "(Landroid/content/Intent;)V", "Landroid/os/Message;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/os/Message;)Z", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/app/job/JobParameters;", "params", "onStartJob", "(Landroid/app/job/JobParameters;)Z", "onStopJob", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Ljava/util/concurrent/Executor;", "PlaceComponentResult", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Landroid/os/Handler;", "Landroid/os/Handler;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "getAuthRequestContext", "Landroid/util/SparseArray;", "Landroidx/core/app/DANAJobIntentService$JobRunnable;", "moveToNextValue", "Landroid/util/SparseArray;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "lookAheadTest", "Landroid/os/PowerManager$WakeLock;", "<init>", "(Ljava/util/concurrent/Executor;)V", "Companion", "EnqueueCompat", "EnqueueCompatNew", "EnqueueCompatOld", "JobRunnable", "NewJobRunnable", "OldIntentRunnable"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DANAJobIntentService extends JobService {
    private static PowerManager.WakeLock KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Handler PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Executor executor;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private PowerManager.WakeLock BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final SparseArray<JobRunnable> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object getAuthRequestContext = new Object();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/core/app/DANAJobIntentService$EnqueueCompat;", "", "Landroid/content/Context;", "p0", "Landroid/content/ComponentName;", "p1", "", "p2", "Landroid/content/Intent;", "p3", "", "PlaceComponentResult", "(Landroid/content/Context;Landroid/content/ComponentName;ILandroid/content/Intent;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class EnqueueCompat {
        public abstract void PlaceComponentResult(Context p0, ComponentName p1, int p2, Intent p3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/core/app/DANAJobIntentService$JobRunnable;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class JobRunnable {
        final AtomicBoolean KClassImpl$Data$declaredNonStaticMembers$2 = new AtomicBoolean(false);
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

    public abstract void onHandleWork(Intent intent);

    public DANAJobIntentService(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "");
        this.executor = executor;
        this.MyBillsEntityDataFactory = DANAJobIntentService.class.getName();
        this.PlaceComponentResult = new Handler(new Handler.Callback() { // from class: androidx.core.app.DANAJobIntentService$$ExternalSyntheticLambda0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = DANAJobIntentService.this.MyBillsEntityDataFactory(message);
                return MyBillsEntityDataFactory;
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SparseArray<>();
    }

    @JvmName(name = "getExecutor")
    public final Executor getExecutor() {
        return this.executor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DANAJobIntentService() {
        /*
            r2 = this;
            java.util.concurrent.Executor r0 = android.os.AsyncTask.SERIAL_EXECUTOR
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.DANAJobIntentService.<init>():void");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 26) {
            Object systemService = getApplicationContext().getSystemService("power");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(":running");
            PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, sb.toString());
            newWakeLock.setReferenceCounted(false);
            this.BuiltInFictitiousFunctionClassFactory = newWakeLock;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        PowerManager.WakeLock wakeLock = this.BuiltInFictitiousFunctionClassFactory;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String str = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("onStartCommand ");
        sb.append(intent);
        sb.append(", ");
        sb.append(flags);
        sb.append(", ");
        sb.append(startId);
        InstrumentInjector.log_i(str, sb.toString());
        if (Build.VERSION.SDK_INT < 26) {
            synchronized (getAuthRequestContext) {
                PowerManager.WakeLock wakeLock = KClassImpl$Data$declaredNonStaticMembers$2;
                if (wakeLock != null && wakeLock.isHeld()) {
                    try {
                        wakeLock.release();
                    } catch (Exception e) {
                        DanaLog.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, e.getMessage());
                    }
                }
            }
            if (intent != null) {
                this.getAuthRequestContext++;
                PowerManager.WakeLock wakeLock2 = this.BuiltInFictitiousFunctionClassFactory;
                if (wakeLock2 != null) {
                    wakeLock2.acquire(60000L);
                }
                this.executor.execute(new OldIntentRunnable(this, this.PlaceComponentResult, intent, startId));
                return 3;
            }
            return 2;
        }
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        AtomicBoolean atomicBoolean;
        String str = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append("onStartJob ");
        sb.append(params);
        InstrumentInjector.log_i(str, sb.toString());
        if (params != null) {
            int jobId = params.getJobId();
            JobRunnable jobRunnable = this.KClassImpl$Data$declaredNonStaticMembers$2.get(jobId);
            if (jobRunnable != null && (atomicBoolean = jobRunnable.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                atomicBoolean.set(true);
            }
            NewJobRunnable newJobRunnable = Build.VERSION.SDK_INT >= 26 ? new NewJobRunnable(this, this.PlaceComponentResult, params) : null;
            if (newJobRunnable != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(jobId, newJobRunnable);
                this.executor.execute(newJobRunnable);
            }
            return true;
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        int jobId;
        JobRunnable jobRunnable;
        if (params == null || (jobRunnable = this.KClassImpl$Data$declaredNonStaticMembers$2.get((jobId = params.getJobId()))) == null) {
            return false;
        }
        jobRunnable.KClassImpl$Data$declaredNonStaticMembers$2.set(true);
        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(jobId);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean MyBillsEntityDataFactory(Message p0) {
        PowerManager.WakeLock wakeLock;
        int i = p0.what;
        if (i == 0) {
            Object obj = p0.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.core.app.DANAJobIntentService.OldIntentRunnable");
            }
            stopSelf(((OldIntentRunnable) obj).KClassImpl$Data$declaredNonStaticMembers$2);
            int i2 = this.getAuthRequestContext - 1;
            this.getAuthRequestContext = i2;
            if (i2 == 0 && (wakeLock = this.BuiltInFictitiousFunctionClassFactory) != null && wakeLock.isHeld()) {
                try {
                    wakeLock.release();
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, e.getMessage());
                }
            }
        } else if (i != 1) {
            return false;
        } else {
            Object obj2 = p0.obj;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.core.app.DANAJobIntentService.NewJobRunnable");
            }
            NewJobRunnable newJobRunnable = (NewJobRunnable) obj2;
            int jobId = newJobRunnable.PlaceComponentResult.getJobId();
            if (Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.get(jobId), newJobRunnable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(jobId);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/core/app/DANAJobIntentService$OldIntentRunnable;", "Ljava/lang/Runnable;", "", "run", "()V", "Landroid/os/Handler;", "PlaceComponentResult", "Landroid/os/Handler;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "Landroid/content/Intent;", "Landroidx/core/app/DANAJobIntentService;", "Landroidx/core/app/DANAJobIntentService;", "", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "<init>", "(Landroidx/core/app/DANAJobIntentService;Landroid/os/Handler;Landroid/content/Intent;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class OldIntentRunnable implements Runnable {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final DANAJobIntentService PlaceComponentResult;
        public final Intent MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final Handler BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        public OldIntentRunnable(DANAJobIntentService dANAJobIntentService, Handler handler, Intent intent, int i) {
            Intrinsics.checkNotNullParameter(dANAJobIntentService, "");
            Intrinsics.checkNotNullParameter(handler, "");
            Intrinsics.checkNotNullParameter(intent, "");
            this.PlaceComponentResult = dANAJobIntentService;
            this.BuiltInFictitiousFunctionClassFactory = handler;
            this.MyBillsEntityDataFactory = intent;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.PlaceComponentResult.onHandleWork(this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory.obtainMessage(0, this).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/core/app/DANAJobIntentService$NewJobRunnable;", "Landroidx/core/app/DANAJobIntentService$JobRunnable;", "Ljava/lang/Runnable;", "Landroid/app/job/JobWorkItem;", "BuiltInFictitiousFunctionClassFactory", "()Landroid/app/job/JobWorkItem;", "", "run", "()V", "Landroid/os/Handler;", "Landroid/os/Handler;", "MyBillsEntityDataFactory", "Landroid/app/job/JobParameters;", "PlaceComponentResult", "Landroid/app/job/JobParameters;", "Landroidx/core/app/DANAJobIntentService;", "getAuthRequestContext", "Landroidx/core/app/DANAJobIntentService;", "p0", "p1", "p2", "<init>", "(Landroidx/core/app/DANAJobIntentService;Landroid/os/Handler;Landroid/app/job/JobParameters;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NewJobRunnable extends JobRunnable implements Runnable {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Handler MyBillsEntityDataFactory;
        final JobParameters PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final DANAJobIntentService BuiltInFictitiousFunctionClassFactory;

        public NewJobRunnable(DANAJobIntentService dANAJobIntentService, Handler handler, JobParameters jobParameters) {
            Intrinsics.checkNotNullParameter(dANAJobIntentService, "");
            Intrinsics.checkNotNullParameter(handler, "");
            Intrinsics.checkNotNullParameter(jobParameters, "");
            this.BuiltInFictitiousFunctionClassFactory = dANAJobIntentService;
            this.MyBillsEntityDataFactory = handler;
            this.PlaceComponentResult = jobParameters;
        }

        private JobWorkItem BuiltInFictitiousFunctionClassFactory() {
            try {
                return this.PlaceComponentResult.dequeueWork();
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            JobWorkItem BuiltInFictitiousFunctionClassFactory;
            while (!this.KClassImpl$Data$declaredNonStaticMembers$2.get() && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory()) != null) {
                DANAJobIntentService dANAJobIntentService = this.BuiltInFictitiousFunctionClassFactory;
                Intent intent = BuiltInFictitiousFunctionClassFactory.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "");
                dANAJobIntentService.onHandleWork(intent);
                try {
                    this.PlaceComponentResult.completeWork(BuiltInFictitiousFunctionClassFactory);
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("JobIntentServiceX", e.getMessage());
                }
            }
            this.MyBillsEntityDataFactory.obtainMessage(1, this).sendToTarget();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/core/app/DANAJobIntentService$EnqueueCompatOld;", "Landroidx/core/app/DANAJobIntentService$EnqueueCompat;", "Landroid/content/Context;", "p0", "Landroid/content/ComponentName;", "p1", "", "p2", "Landroid/content/Intent;", "p3", "", "PlaceComponentResult", "(Landroid/content/Context;Landroid/content/ComponentName;ILandroid/content/Intent;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EnqueueCompatOld extends EnqueueCompat {
        @Override // androidx.core.app.DANAJobIntentService.EnqueueCompat
        public final void PlaceComponentResult(Context p0, ComponentName p1, int p2, Intent p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            synchronized (DANAJobIntentService.getAuthRequestContext) {
                PowerManager.WakeLock wakeLock = DANAJobIntentService.KClassImpl$Data$declaredNonStaticMembers$2;
                if (wakeLock == null) {
                    Object systemService = p0.getApplicationContext().getSystemService("power");
                    if (systemService == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(DANAJobIntentService.class.getName());
                    sb.append(":start");
                    wakeLock = ((PowerManager) systemService).newWakeLock(1, sb.toString());
                    Companion companion = DANAJobIntentService.INSTANCE;
                    DANAJobIntentService.KClassImpl$Data$declaredNonStaticMembers$2 = wakeLock;
                }
                if (wakeLock != null) {
                    wakeLock.acquire(15000L);
                    Unit unit = Unit.INSTANCE;
                }
            }
            Intent intent = new Intent(p3);
            intent.setComponent(p1);
            p0.startService(intent);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/core/app/DANAJobIntentService$EnqueueCompatNew;", "Landroidx/core/app/DANAJobIntentService$EnqueueCompat;", "Landroid/content/Context;", "p0", "Landroid/content/ComponentName;", "p1", "", "p2", "Landroid/content/Intent;", "p3", "", "PlaceComponentResult", "(Landroid/content/Context;Landroid/content/ComponentName;ILandroid/content/Intent;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EnqueueCompatNew extends EnqueueCompat {
        @Override // androidx.core.app.DANAJobIntentService.EnqueueCompat
        public final void PlaceComponentResult(Context p0, ComponentName p1, int p2, Intent p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Object systemService = p0.getApplicationContext().getSystemService("jobscheduler");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.job.JobScheduler");
            }
            JobInfo.Builder builder = new JobInfo.Builder(p2, p1);
            builder.setOverrideDeadline(0L);
            ((JobScheduler) systemService).enqueue(builder.build(), new JobWorkItem(p3));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0018\u00010\u0002R\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/core/app/DANAJobIntentService$Companion;", "", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/PowerManager$WakeLock;", "getAuthRequestContext", "Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

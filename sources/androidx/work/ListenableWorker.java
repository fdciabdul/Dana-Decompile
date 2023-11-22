package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public void onStopped() {
    }

    public abstract ListenableFuture<Result> startWork();

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public final UUID getId() {
        return this.mWorkerParams.MyBillsEntityDataFactory;
    }

    public final Data getInputData() {
        return this.mWorkerParams.BuiltInFictitiousFunctionClassFactory;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.getErrorConfigVersion;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.scheduleImpl.getAuthRequestContext;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.moveToNextValue;
    }

    public ListenableFuture<Void> setProgressAsync(Data data) {
        ProgressUpdater progressUpdater = this.mWorkerParams.KClassImpl$Data$declaredNonStaticMembers$2;
        getApplicationContext();
        return progressUpdater.getAuthRequestContext(getId(), data);
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        return this.mWorkerParams.getAuthRequestContext.getAuthRequestContext(getApplicationContext(), getId(), foregroundInfo);
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture PlaceComponentResult = SettableFuture.PlaceComponentResult();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((Throwable) new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return PlaceComponentResult;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public void setRunInForeground(boolean z) {
        this.mRunInForeground = z;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.PlaceComponentResult;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.lookAheadTest;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* loaded from: classes3.dex */
    public static abstract class Result {
        public static Result BuiltInFictitiousFunctionClassFactory() {
            return new Success();
        }

        public static Result BuiltInFictitiousFunctionClassFactory(Data data) {
            return new Success(data);
        }

        public static Result MyBillsEntityDataFactory() {
            return new Retry();
        }

        public static Result getAuthRequestContext() {
            return new Failure();
        }

        Result() {
        }

        /* loaded from: classes3.dex */
        public static final class Success extends Result {
            public final Data PlaceComponentResult;

            public Success() {
                this(Data.BuiltInFictitiousFunctionClassFactory);
            }

            public Success(Data data) {
                this.PlaceComponentResult = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.PlaceComponentResult.equals(((Success) obj).PlaceComponentResult);
            }

            public final int hashCode() {
                return this.PlaceComponentResult.hashCode() - 1876823561;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Success {mOutputData=");
                sb.append(this.PlaceComponentResult);
                sb.append('}');
                return sb.toString();
            }
        }

        /* loaded from: classes3.dex */
        public static final class Failure extends Result {
            public final Data getAuthRequestContext;

            public Failure() {
                this(Data.BuiltInFictitiousFunctionClassFactory);
            }

            private Failure(Data data) {
                this.getAuthRequestContext = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.getAuthRequestContext.equals(((Failure) obj).getAuthRequestContext);
            }

            public final int hashCode() {
                return this.getAuthRequestContext.hashCode() + 846803280;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Failure {mOutputData=");
                sb.append(this.getAuthRequestContext);
                sb.append('}');
                return sb.toString();
            }
        }

        /* loaded from: classes3.dex */
        public static final class Retry extends Result {
            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return "Retry";
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }
        }
    }
}

package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class WorkerParameters {
    public Data BuiltInFictitiousFunctionClassFactory;
    ProgressUpdater KClassImpl$Data$declaredNonStaticMembers$2;
    UUID MyBillsEntityDataFactory;
    WorkerFactory NetworkUserEntityData$$ExternalSyntheticLambda0;
    Executor PlaceComponentResult;
    public ForegroundUpdater getAuthRequestContext;
    Set<String> getErrorConfigVersion;
    TaskExecutor lookAheadTest;
    int moveToNextValue;
    RuntimeExtras scheduleImpl;

    /* loaded from: classes3.dex */
    public static class RuntimeExtras {
        public Network BuiltInFictitiousFunctionClassFactory;
        public List<String> getAuthRequestContext = Collections.emptyList();
        public List<Uri> KClassImpl$Data$declaredNonStaticMembers$2 = Collections.emptyList();
    }

    public WorkerParameters(UUID uuid, Data data, Collection<String> collection, RuntimeExtras runtimeExtras, int i, Executor executor, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.MyBillsEntityDataFactory = uuid;
        this.BuiltInFictitiousFunctionClassFactory = data;
        this.getErrorConfigVersion = new HashSet(collection);
        this.scheduleImpl = runtimeExtras;
        this.moveToNextValue = i;
        this.PlaceComponentResult = executor;
        this.lookAheadTest = taskExecutor;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = workerFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = progressUpdater;
        this.getAuthRequestContext = foregroundUpdater;
    }
}

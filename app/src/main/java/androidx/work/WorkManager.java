package androidx.work;

import android.content.Context;
import androidx.view.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* loaded from: classes.dex */
public abstract class WorkManager {
    public abstract LiveData<List<WorkInfo>> BuiltInFictitiousFunctionClassFactory(String str);

    public abstract Operation KClassImpl$Data$declaredNonStaticMembers$2(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public abstract Operation MyBillsEntityDataFactory(String str);

    public abstract Operation PlaceComponentResult(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract Operation PlaceComponentResult(List<? extends WorkRequest> list);

    public abstract ListenableFuture<List<WorkInfo>> PlaceComponentResult(String str);

    public abstract Operation getAuthRequestContext();

    public abstract Operation getAuthRequestContext(String str);

    public abstract WorkContinuation getAuthRequestContext(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract WorkContinuation getAuthRequestContext(List<OneTimeWorkRequest> list);

    public static WorkManager KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        return WorkManagerImpl.PlaceComponentResult(context);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, Configuration configuration) {
        WorkManagerImpl.MyBillsEntityDataFactory(context, configuration);
    }
}

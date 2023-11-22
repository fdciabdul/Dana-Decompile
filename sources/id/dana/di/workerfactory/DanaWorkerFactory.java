package id.dana.di.workerfactory;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public class DanaWorkerFactory extends WorkerFactory {
    private final Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public DanaWorkerFactory(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> map) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
    }

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker PlaceComponentResult(Context context, String str, WorkerParameters workerParameters) {
        Provider<ChildWorkerFactory> PlaceComponentResult = CollectionWorkerUtils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, str);
        if (PlaceComponentResult == null || PlaceComponentResult.get() == null) {
            return null;
        }
        return PlaceComponentResult.get().MyBillsEntityDataFactory(context, workerParameters);
    }
}

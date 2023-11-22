package androidx.work;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("DelegatingWkrFctry");
    private final List<WorkerFactory> MyBillsEntityDataFactory = new CopyOnWriteArrayList();

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker PlaceComponentResult(Context context, String str, WorkerParameters workerParameters) {
        Iterator<WorkerFactory> it = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            try {
                ListenableWorker PlaceComponentResult = it.next().PlaceComponentResult(context, str, workerParameters);
                if (PlaceComponentResult != null) {
                    return PlaceComponentResult;
                }
            } catch (Throwable th) {
                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, String.format("Unable to instantiate a ListenableWorker (%s)", str), th);
                throw th;
            }
        }
        return null;
    }
}

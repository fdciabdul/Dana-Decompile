package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes3.dex */
public class StartWorkRunnable implements Runnable {
    private WorkManagerImpl BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private WorkerParameters.RuntimeExtras PlaceComponentResult;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.BuiltInFictitiousFunctionClassFactory = workManagerImpl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
    }
}

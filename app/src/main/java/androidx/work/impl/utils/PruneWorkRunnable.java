package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes3.dex */
public class PruneWorkRunnable implements Runnable {
    public final OperationImpl BuiltInFictitiousFunctionClassFactory = new OperationImpl();
    private final WorkManagerImpl PlaceComponentResult;

    public PruneWorkRunnable(WorkManagerImpl workManagerImpl) {
        this.PlaceComponentResult = workManagerImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.PlaceComponentResult.lookAheadTest.getErrorConfigVersion().moveToNextValue();
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(Operation.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new Operation.State.FAILURE(th));
        }
    }
}

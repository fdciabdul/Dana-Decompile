package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class EnqueueRunnable implements Runnable {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("EnqueueRunnable");
    public final OperationImpl KClassImpl$Data$declaredNonStaticMembers$2 = new OperationImpl();
    private final WorkContinuationImpl MyBillsEntityDataFactory;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.MyBillsEntityDataFactory = workContinuationImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.MyBillsEntityDataFactory.PlaceComponentResult()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.MyBillsEntityDataFactory));
            }
            if (PlaceComponentResult()) {
                PackageManagerHelper.PlaceComponentResult(this.MyBillsEntityDataFactory.lookAheadTest.MyBillsEntityDataFactory, RescheduleReceiver.class, true);
                WorkManagerImpl workManagerImpl = this.MyBillsEntityDataFactory.lookAheadTest;
                Schedulers.PlaceComponentResult(workManagerImpl.getAuthRequestContext, workManagerImpl.lookAheadTest, workManagerImpl.BuiltInFictitiousFunctionClassFactory);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(Operation.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(new Operation.State.FAILURE(th));
        }
    }

    private boolean PlaceComponentResult() {
        WorkDatabase workDatabase = this.MyBillsEntityDataFactory.lookAheadTest.lookAheadTest;
        workDatabase.beginTransaction();
        try {
            boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            workDatabase.setTransactionSuccessful();
            return MyBillsEntityDataFactory;
        } finally {
            workDatabase.endTransaction();
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(WorkContinuationImpl workContinuationImpl) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(workContinuationImpl.lookAheadTest, workContinuationImpl.scheduleImpl, (String[]) WorkContinuationImpl.MyBillsEntityDataFactory(workContinuationImpl).toArray(new String[0]), workContinuationImpl.KClassImpl$Data$declaredNonStaticMembers$2, workContinuationImpl.getAuthRequestContext);
        workContinuationImpl.MyBillsEntityDataFactory = true;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01eb A[LOOP:5: B:126:0x01e5->B:128:0x01eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(androidx.work.impl.WorkManagerImpl r18, java.util.List<? extends androidx.work.WorkRequest> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.KClassImpl$Data$declaredNonStaticMembers$2(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(WorkSpec workSpec) {
        Constraints constraints = workSpec.MyBillsEntityDataFactory;
        String str = workSpec.newProxyInstance;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (constraints.BuiltInFictitiousFunctionClassFactory() || constraints.PlaceComponentResult()) {
            Data.Builder builder = new Data.Builder();
            builder.BuiltInFictitiousFunctionClassFactory(workSpec.moveToNextValue.MyBillsEntityDataFactory);
            builder.MyBillsEntityDataFactory.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            workSpec.newProxyInstance = ConstraintTrackingWorker.class.getName();
            Data data = new Data(builder.MyBillsEntityDataFactory);
            Data.getAuthRequestContext(data);
            workSpec.moveToNextValue = data;
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(WorkManagerImpl workManagerImpl, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<Scheduler> it = workManagerImpl.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean MyBillsEntityDataFactory(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> list = workContinuationImpl.BuiltInFictitiousFunctionClassFactory;
        boolean z = false;
        if (list != null) {
            boolean z2 = false;
            for (WorkContinuationImpl workContinuationImpl2 : list) {
                if (!workContinuationImpl2.getAuthRequestContext()) {
                    z2 |= MyBillsEntityDataFactory(workContinuationImpl2);
                } else {
                    Logger.getAuthRequestContext().getAuthRequestContext(PlaceComponentResult, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", workContinuationImpl2.PlaceComponentResult)), new Throwable[0]);
                }
            }
            z = z2;
        }
        return BuiltInFictitiousFunctionClassFactory(workContinuationImpl) | z;
    }
}

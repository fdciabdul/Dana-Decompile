package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("WorkConstraintsTracker");
    private final ConstraintController<?>[] BuiltInFictitiousFunctionClassFactory;
    private final Object PlaceComponentResult;
    private final WorkConstraintsCallback getAuthRequestContext;

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.getAuthRequestContext = workConstraintsCallback;
        this.BuiltInFictitiousFunctionClassFactory = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
        this.PlaceComponentResult = new Object();
    }

    public final void BuiltInFictitiousFunctionClassFactory(Iterable<WorkSpec> iterable) {
        synchronized (this.PlaceComponentResult) {
            for (ConstraintController<?> constraintController : this.BuiltInFictitiousFunctionClassFactory) {
                if (constraintController.getAuthRequestContext != null) {
                    constraintController.getAuthRequestContext = null;
                    constraintController.getAuthRequestContext(null, constraintController.MyBillsEntityDataFactory);
                }
            }
            for (ConstraintController<?> constraintController2 : this.BuiltInFictitiousFunctionClassFactory) {
                constraintController2.KClassImpl$Data$declaredNonStaticMembers$2(iterable);
            }
            for (ConstraintController<?> constraintController3 : this.BuiltInFictitiousFunctionClassFactory) {
                if (constraintController3.getAuthRequestContext != this) {
                    constraintController3.getAuthRequestContext = this;
                    constraintController3.getAuthRequestContext(this, constraintController3.MyBillsEntityDataFactory);
                }
            }
        }
    }

    public final void MyBillsEntityDataFactory() {
        synchronized (this.PlaceComponentResult) {
            for (ConstraintController<?> constraintController : this.BuiltInFictitiousFunctionClassFactory) {
                if (!constraintController.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    constraintController.KClassImpl$Data$declaredNonStaticMembers$2.clear();
                    constraintController.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(constraintController);
                }
            }
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this.PlaceComponentResult) {
            for (ConstraintController<?> constraintController : this.BuiltInFictitiousFunctionClassFactory) {
                if (constraintController.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
                    Logger.getAuthRequestContext().PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, String.format("Work %s constrained by %s", str, constraintController.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public final void MyBillsEntityDataFactory(List<String> list) {
        synchronized (this.PlaceComponentResult) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (BuiltInFictitiousFunctionClassFactory(str)) {
                    Logger.getAuthRequestContext().PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            WorkConstraintsCallback workConstraintsCallback = this.getAuthRequestContext;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.MyBillsEntityDataFactory(arrayList);
            }
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        synchronized (this.PlaceComponentResult) {
            WorkConstraintsCallback workConstraintsCallback = this.getAuthRequestContext;
            if (workConstraintsCallback != null) {
                workConstraintsCallback.PlaceComponentResult(list);
            }
        }
    }
}

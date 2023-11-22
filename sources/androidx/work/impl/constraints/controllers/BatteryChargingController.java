package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class BatteryChargingController extends ConstraintController<Boolean> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Boolean bool) {
        return MyBillsEntityDataFactory(bool);
    }

    public BatteryChargingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.KClassImpl$Data$declaredNonStaticMembers$2(context, taskExecutor).MyBillsEntityDataFactory);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final boolean BuiltInFictitiousFunctionClassFactory(WorkSpec workSpec) {
        return workSpec.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    private static boolean MyBillsEntityDataFactory(Boolean bool) {
        return !bool.booleanValue();
    }
}

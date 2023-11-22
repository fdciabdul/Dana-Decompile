package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(NetworkState networkState) {
        return getAuthRequestContext(networkState);
    }

    public NetworkUnmeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.KClassImpl$Data$declaredNonStaticMembers$2(context, taskExecutor).getAuthRequestContext);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final boolean BuiltInFictitiousFunctionClassFactory(WorkSpec workSpec) {
        return workSpec.MyBillsEntityDataFactory.MyBillsEntityDataFactory == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && workSpec.MyBillsEntityDataFactory.MyBillsEntityDataFactory == NetworkType.TEMPORARILY_UNMETERED);
    }

    private static boolean getAuthRequestContext(NetworkState networkState) {
        return !networkState.getAuthRequestContext() || networkState.BuiltInFictitiousFunctionClassFactory();
    }
}

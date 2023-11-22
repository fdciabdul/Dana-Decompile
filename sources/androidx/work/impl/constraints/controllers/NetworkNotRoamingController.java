package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class NetworkNotRoamingController extends ConstraintController<NetworkState> {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("NetworkNotRoamingCtrlr");

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(NetworkState networkState) {
        return getAuthRequestContext(networkState);
    }

    public NetworkNotRoamingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.KClassImpl$Data$declaredNonStaticMembers$2(context, taskExecutor).getAuthRequestContext);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    final boolean BuiltInFictitiousFunctionClassFactory(WorkSpec workSpec) {
        return workSpec.MyBillsEntityDataFactory.MyBillsEntityDataFactory == NetworkType.NOT_ROAMING;
    }

    private static boolean getAuthRequestContext(NetworkState networkState) {
        if (Build.VERSION.SDK_INT >= 24) {
            return (networkState.getAuthRequestContext() && networkState.MyBillsEntityDataFactory()) ? false : true;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !networkState.getAuthRequestContext();
    }
}

package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.Collections;

/* loaded from: classes6.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        WorkManager PlaceComponentResult;
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$2;
        if (intent == null) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, "Requesting diagnostics", new Throwable[0]);
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            KClassImpl$Data$declaredNonStaticMembers$2 = new OneTimeWorkRequest.Builder(DiagnosticsWorker.class).KClassImpl$Data$declaredNonStaticMembers$2();
            PlaceComponentResult.PlaceComponentResult(Collections.singletonList(KClassImpl$Data$declaredNonStaticMembers$2));
        } catch (IllegalStateException e) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, "WorkManager is not initialized", e);
        }
    }
}

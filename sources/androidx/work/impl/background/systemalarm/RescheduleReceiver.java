package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* loaded from: classes3.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.getAuthRequestContext().PlaceComponentResult(MyBillsEntityDataFactory, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                WorkManagerImpl.PlaceComponentResult(context).MyBillsEntityDataFactory(goAsync());
                return;
            } catch (IllegalStateException e) {
                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
                return;
            }
        }
        context.startService(CommandHandler.KClassImpl$Data$declaredNonStaticMembers$2(context));
    }
}

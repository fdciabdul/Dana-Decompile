package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.view.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

/* loaded from: classes3.dex */
public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("SystemAlarmService");
    private SystemAlarmDispatcher BuiltInFictitiousFunctionClassFactory;
    private boolean PlaceComponentResult;

    @Override // androidx.view.LifecycleService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // androidx.view.LifecycleService, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.view.LifecycleService, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.view.LifecycleService, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        PlaceComponentResult();
        this.PlaceComponentResult = false;
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.PlaceComponentResult = true;
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.PlaceComponentResult) {
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(getAuthRequestContext, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            PlaceComponentResult();
            this.PlaceComponentResult = false;
        }
        if (intent != null) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(intent, i2);
            return 3;
        }
        return 3;
    }

    @Override // androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.CommandsCompletedListener
    public void onAllCommandsCompleted() {
        this.PlaceComponentResult = true;
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, "All commands completed in dispatcher", new Throwable[0]);
        WakeLocks.PlaceComponentResult();
        stopSelf();
    }

    private void PlaceComponentResult() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.BuiltInFictitiousFunctionClassFactory = systemAlarmDispatcher;
        if (systemAlarmDispatcher.MyBillsEntityDataFactory != null) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(SystemAlarmDispatcher.getAuthRequestContext, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            systemAlarmDispatcher.MyBillsEntityDataFactory = this;
        }
    }
}

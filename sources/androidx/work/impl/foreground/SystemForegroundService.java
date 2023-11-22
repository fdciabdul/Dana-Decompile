package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.view.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import java.util.UUID;

/* loaded from: classes3.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("SystemFgService");
    private static SystemForegroundService PlaceComponentResult = null;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Handler getAuthRequestContext;
    SystemForegroundDispatcher mDispatcher;
    NotificationManager mNotificationManager;

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
        PlaceComponentResult = this;
        MyBillsEntityDataFactory();
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.getAuthRequestContext();
            MyBillsEntityDataFactory();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        if (intent != null) {
            final SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
            String action = intent.getAction();
            if (!"ACTION_START_FOREGROUND".equals(action)) {
                if ("ACTION_NOTIFY".equals(action)) {
                    systemForegroundDispatcher.getAuthRequestContext(intent);
                    return 3;
                } else if (!"ACTION_CANCEL_WORK".equals(action)) {
                    if ("ACTION_STOP_FOREGROUND".equals(action)) {
                        Logger.getAuthRequestContext().MyBillsEntityDataFactory(SystemForegroundDispatcher.BuiltInFictitiousFunctionClassFactory, "Stopping foreground service", new Throwable[0]);
                        SystemForegroundDispatcher.Callback callback = systemForegroundDispatcher.MyBillsEntityDataFactory;
                        if (callback != null) {
                            callback.stop();
                            return 3;
                        }
                        return 3;
                    }
                    return 3;
                } else {
                    Logger.getAuthRequestContext().MyBillsEntityDataFactory(SystemForegroundDispatcher.BuiltInFictitiousFunctionClassFactory, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                    String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
                    if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                        return 3;
                    }
                    WorkManagerImpl workManagerImpl = systemForegroundDispatcher.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    CancelWorkRunnable authRequestContext = CancelWorkRunnable.getAuthRequestContext(UUID.fromString(stringExtra), workManagerImpl);
                    workManagerImpl.getErrorConfigVersion.getAuthRequestContext(authRequestContext);
                    OperationImpl operationImpl = authRequestContext.getAuthRequestContext;
                    return 3;
                }
            }
            Logger.getAuthRequestContext().MyBillsEntityDataFactory(SystemForegroundDispatcher.BuiltInFictitiousFunctionClassFactory, String.format("Started foreground service %s", intent), new Throwable[0]);
            final String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
            final WorkDatabase workDatabase = systemForegroundDispatcher.NetworkUserEntityData$$ExternalSyntheticLambda0.lookAheadTest;
            systemForegroundDispatcher.moveToNextValue.getAuthRequestContext(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    WorkSpec moveToNextValue = workDatabase.getErrorConfigVersion().moveToNextValue(stringExtra2);
                    if (moveToNextValue == null || !moveToNextValue.BuiltInFictitiousFunctionClassFactory()) {
                        return;
                    }
                    synchronized (systemForegroundDispatcher.getErrorConfigVersion) {
                        systemForegroundDispatcher.scheduleImpl.put(stringExtra2, moveToNextValue);
                        systemForegroundDispatcher.lookAheadTest.add(moveToNextValue);
                        systemForegroundDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(systemForegroundDispatcher.lookAheadTest);
                    }
                }
            });
            systemForegroundDispatcher.getAuthRequestContext(intent);
            return 3;
        }
        return 3;
    }

    @Override // androidx.view.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.getAuthRequestContext();
    }

    private void MyBillsEntityDataFactory() {
        this.getAuthRequestContext = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.MyBillsEntityDataFactory != null) {
            Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(SystemForegroundDispatcher.BuiltInFictitiousFunctionClassFactory, "A callback already exists.", new Throwable[0]);
        } else {
            systemForegroundDispatcher.MyBillsEntityDataFactory = this;
        }
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        PlaceComponentResult = null;
        stopSelf();
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(final int i, final int i2, final Notification notification) {
        this.getAuthRequestContext.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.1
            {
                SystemForegroundService.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i, notification, i2);
                } else {
                    SystemForegroundService.this.startForeground(i, notification);
                }
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(final int i, final Notification notification) {
        this.getAuthRequestContext.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
            {
                SystemForegroundService.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.mNotificationManager.notify(i, notification);
            }
        });
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(final int i) {
        this.getAuthRequestContext.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
            {
                SystemForegroundService.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                SystemForegroundService.this.mNotificationManager.cancel(i);
            }
        });
    }

    public static SystemForegroundService getInstance() {
        return PlaceComponentResult;
    }
}

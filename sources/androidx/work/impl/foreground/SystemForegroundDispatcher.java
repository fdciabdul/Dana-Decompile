package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    static final String BuiltInFictitiousFunctionClassFactory = Logger.MyBillsEntityDataFactory("SystemFgDispatcher");
    final WorkConstraintsTracker KClassImpl$Data$declaredNonStaticMembers$2;
    Callback MyBillsEntityDataFactory;
    WorkManagerImpl NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Context NetworkUserEntityData$$ExternalSyntheticLambda2;
    final Map<String, ForegroundInfo> PlaceComponentResult;
    String getAuthRequestContext;
    final Object getErrorConfigVersion = new Object();
    final Set<WorkSpec> lookAheadTest;
    final TaskExecutor moveToNextValue;
    final Map<String, WorkSpec> scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Callback {
        void cancelNotification(int i);

        void notify(int i, Notification notification);

        void startForeground(int i, int i2, Notification notification);

        void stop();
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void MyBillsEntityDataFactory(List<String> list) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemForegroundDispatcher(Context context) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = context;
        WorkManagerImpl PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = PlaceComponentResult;
        TaskExecutor taskExecutor = PlaceComponentResult.getErrorConfigVersion;
        this.moveToNextValue = taskExecutor;
        this.getAuthRequestContext = null;
        this.PlaceComponentResult = new LinkedHashMap();
        this.lookAheadTest = new HashSet();
        this.scheduleImpl = new HashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WorkConstraintsTracker(this.NetworkUserEntityData$$ExternalSyntheticLambda2, taskExecutor, this);
        Processor processor = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (processor.getAuthRequestContext) {
            processor.BuiltInFictitiousFunctionClassFactory.add(this);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        Map.Entry<String, ForegroundInfo> entry;
        synchronized (this.getErrorConfigVersion) {
            WorkSpec remove = this.scheduleImpl.remove(str);
            if (remove != null ? this.lookAheadTest.remove(remove) : false) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest);
            }
        }
        ForegroundInfo remove2 = this.PlaceComponentResult.remove(str);
        if (str.equals(this.getAuthRequestContext) && this.PlaceComponentResult.size() > 0) {
            Iterator<Map.Entry<String, ForegroundInfo>> it = this.PlaceComponentResult.entrySet().iterator();
            Map.Entry<String, ForegroundInfo> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.getAuthRequestContext = entry.getKey();
            if (this.MyBillsEntityDataFactory != null) {
                ForegroundInfo value = entry.getValue();
                this.MyBillsEntityDataFactory.startForeground(value.MyBillsEntityDataFactory, value.PlaceComponentResult, value.BuiltInFictitiousFunctionClassFactory);
                this.MyBillsEntityDataFactory.cancelNotification(value.MyBillsEntityDataFactory);
            }
        }
        Callback callback = this.MyBillsEntityDataFactory;
        if (remove2 == null || callback == null) {
            return;
        }
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.MyBillsEntityDataFactory), str, Integer.valueOf(remove2.PlaceComponentResult)), new Throwable[0]);
        callback.cancelNotification(remove2.MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = null;
        synchronized (this.getErrorConfigVersion) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
        Processor processor = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (processor.getAuthRequestContext) {
            processor.BuiltInFictitiousFunctionClassFactory.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.MyBillsEntityDataFactory == null) {
            return;
        }
        this.PlaceComponentResult.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.getAuthRequestContext)) {
            this.getAuthRequestContext = stringExtra;
            this.MyBillsEntityDataFactory.startForeground(intExtra, intExtra2, notification);
            return;
        }
        this.MyBillsEntityDataFactory.notify(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator<Map.Entry<String, ForegroundInfo>> it = this.PlaceComponentResult.entrySet().iterator();
        while (it.hasNext()) {
            i |= it.next().getValue().PlaceComponentResult;
        }
        ForegroundInfo foregroundInfo = this.PlaceComponentResult.get(this.getAuthRequestContext);
        if (foregroundInfo != null) {
            this.MyBillsEntityDataFactory.startForeground(foregroundInfo.MyBillsEntityDataFactory, i, foregroundInfo.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void PlaceComponentResult(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        for (String str : list) {
            Logger.getAuthRequestContext().PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            WorkManagerImpl workManagerImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StopWorkRunnable(workManagerImpl, str, true));
        }
    }

    public static Intent getAuthRequestContext(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.MyBillsEntityDataFactory);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.PlaceComponentResult);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.BuiltInFictitiousFunctionClassFactory);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent BuiltInFictitiousFunctionClassFactory(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.MyBillsEntityDataFactory);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.PlaceComponentResult);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.BuiltInFictitiousFunctionClassFactory);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent getAuthRequestContext(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }
}

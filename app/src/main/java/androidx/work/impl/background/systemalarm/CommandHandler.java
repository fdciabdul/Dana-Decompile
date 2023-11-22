package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class CommandHandler implements ExecutionListener {
    static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("CommandHandler");
    final Context BuiltInFictitiousFunctionClassFactory;
    final Map<String, ExecutionListener> getAuthRequestContext = new HashMap();
    final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent getAuthRequestContext(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent MyBillsEntityDataFactory(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent MyBillsEntityDataFactory(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent MyBillsEntityDataFactory(Context context, String str, boolean z) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommandHandler(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            ExecutionListener remove = this.getAuthRequestContext.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            z = !this.getAuthRequestContext.isEmpty();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        int length = strArr.length;
        for (int i = 0; i <= 0; i++) {
            if (bundle.get(strArr[0]) == null) {
                return false;
            }
        }
        return true;
    }
}

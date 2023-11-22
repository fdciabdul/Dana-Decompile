package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsTracker;

/* loaded from: classes3.dex */
class ConstraintsCommandHandler {
    static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("ConstraintsCmdHandler");
    final Context BuiltInFictitiousFunctionClassFactory;
    final WorkConstraintsTracker KClassImpl$Data$declaredNonStaticMembers$2;
    final int PlaceComponentResult;
    final SystemAlarmDispatcher getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintsCommandHandler(Context context, int i, SystemAlarmDispatcher systemAlarmDispatcher) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = systemAlarmDispatcher;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WorkConstraintsTracker(context, systemAlarmDispatcher.moveToNextValue, null);
    }
}

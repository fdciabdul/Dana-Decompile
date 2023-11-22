package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return Collections.emptyList();
    }

    @Override // androidx.startup.Initializer
    public final /* synthetic */ WorkManager getAuthRequestContext(Context context) {
        WorkManager PlaceComponentResult;
        Logger.getAuthRequestContext().PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManager.BuiltInFictitiousFunctionClassFactory(context, new Configuration(new Configuration.Builder()));
        PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
        return PlaceComponentResult;
    }
}

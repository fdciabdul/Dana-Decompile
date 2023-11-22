package androidx.view;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.startup.Initializer
    public final /* synthetic */ LifecycleOwner getAuthRequestContext(Context context) {
        if (!AppInitializer.KClassImpl$Data$declaredNonStaticMembers$2(context).MyBillsEntityDataFactory(getClass())) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        LifecycleDispatcher.BuiltInFictitiousFunctionClassFactory(context);
        ProcessLifecycleOwner.PlaceComponentResult(context);
        return ProcessLifecycleOwner.PlaceComponentResult();
    }
}

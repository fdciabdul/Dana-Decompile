package id.dana.di.workerfactory;

import androidx.work.ListenableWorker;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaWorkerFactory_Factory implements Factory<DanaWorkerFactory> {
    private final Provider<Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>>> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaWorkerFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}

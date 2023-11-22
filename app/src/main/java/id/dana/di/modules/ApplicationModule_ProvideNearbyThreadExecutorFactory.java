package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.utils.concurrent.JobExecutor;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNearbyThreadExecutorFactory implements Factory<ThreadExecutor> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<JobExecutor> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideNearbyThreadExecutorFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideNearbyThreadExecutorFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        return new ApplicationModule_ProvideNearbyThreadExecutorFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ThreadExecutor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}

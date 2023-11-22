package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.utils.concurrent.JobExecutor;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideThreadExecutorFactory implements Factory<ThreadExecutor> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<JobExecutor> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideThreadExecutorFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideThreadExecutorFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        return new ApplicationModule_ProvideThreadExecutorFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ThreadExecutor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.utils.concurrent.JobExecutor;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePasskeyThreadExecutorFactory implements Factory<ThreadExecutor> {
    private final Provider<JobExecutor> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvidePasskeyThreadExecutorFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePasskeyThreadExecutorFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        return new ApplicationModule_ProvidePasskeyThreadExecutorFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ThreadExecutor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

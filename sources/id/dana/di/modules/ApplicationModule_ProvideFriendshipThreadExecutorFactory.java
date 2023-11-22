package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.utils.concurrent.JobExecutor;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFriendshipThreadExecutorFactory implements Factory<ThreadExecutor> {
    private final Provider<JobExecutor> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideFriendshipThreadExecutorFactory(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideFriendshipThreadExecutorFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<JobExecutor> provider) {
        return new ApplicationModule_ProvideFriendshipThreadExecutorFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ThreadExecutor) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

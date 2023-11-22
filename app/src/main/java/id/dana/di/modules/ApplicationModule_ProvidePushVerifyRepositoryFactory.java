package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.pushverify.PushVerifyEntityRepository;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePushVerifyRepositoryFactory implements Factory<PushVerifyRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PushVerifyEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvidePushVerifyRepositoryFactory(ApplicationModule applicationModule, Provider<PushVerifyEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvidePushVerifyRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<PushVerifyEntityRepository> provider) {
        return new ApplicationModule_ProvidePushVerifyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushVerifyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.referralconfig.ReferralConfigEntityRepository;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideReferralConfigRepositoryFactory implements Factory<ReferralConfigRepository> {
    private final Provider<ReferralConfigEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideReferralConfigRepositoryFactory(ApplicationModule applicationModule, Provider<ReferralConfigEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideReferralConfigRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<ReferralConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideReferralConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

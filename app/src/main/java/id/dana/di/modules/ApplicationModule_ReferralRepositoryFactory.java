package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.referral.ReferralEntityRepository;
import id.dana.domain.referral.ReferralRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ReferralRepositoryFactory implements Factory<ReferralRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ReferralEntityRepository> getAuthRequestContext;

    private ApplicationModule_ReferralRepositoryFactory(ApplicationModule applicationModule, Provider<ReferralEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ReferralRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<ReferralEntityRepository> provider) {
        return new ApplicationModule_ReferralRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ReferralRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}

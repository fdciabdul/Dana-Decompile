package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.kycamledd.repository.KycAmlEddEntityRepository;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideKycAmlEddRepositoryFactory implements Factory<KycAmlEddRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<KycAmlEddEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideKycAmlEddRepositoryFactory(ApplicationModule applicationModule, Provider<KycAmlEddEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideKycAmlEddRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<KycAmlEddEntityRepository> provider) {
        return new ApplicationModule_ProvideKycAmlEddRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycAmlEddRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}

package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.kycrenewal.repository.KycRenewalEntityRepository;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideKycRenewalRepositoryFactory implements Factory<KycRenewalRepository> {
    private final Provider<KycRenewalEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideKycRenewalRepositoryFactory(ApplicationModule applicationModule, Provider<KycRenewalEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideKycRenewalRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<KycRenewalEntityRepository> provider) {
        return new ApplicationModule_ProvideKycRenewalRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (KycRenewalRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}

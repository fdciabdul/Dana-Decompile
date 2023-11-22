package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMerchantManagementRepositoryFactory implements Factory<MerchantManagementRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<MerchantManagementEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideMerchantManagementRepositoryFactory(ApplicationModule applicationModule, Provider<MerchantManagementEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideMerchantManagementRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<MerchantManagementEntityRepository> provider) {
        return new ApplicationModule_ProvideMerchantManagementRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantManagementRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}

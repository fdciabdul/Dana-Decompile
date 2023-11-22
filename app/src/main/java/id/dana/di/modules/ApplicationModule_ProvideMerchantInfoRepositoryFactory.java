package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyme.repository.MerchantInfoEntityRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMerchantInfoRepositoryFactory implements Factory<MerchantInfoRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<MerchantInfoEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideMerchantInfoRepositoryFactory(ApplicationModule applicationModule, Provider<MerchantInfoEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideMerchantInfoRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<MerchantInfoEntityRepository> provider) {
        return new ApplicationModule_ProvideMerchantInfoRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantInfoRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}

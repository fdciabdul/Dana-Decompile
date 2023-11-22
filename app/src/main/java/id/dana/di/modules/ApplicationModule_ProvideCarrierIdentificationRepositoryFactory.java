package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.carrieridentification.CarrierIdentificationEntityRepository;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCarrierIdentificationRepositoryFactory implements Factory<CarrierIdentificationRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<CarrierIdentificationEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideCarrierIdentificationRepositoryFactory(ApplicationModule applicationModule, Provider<CarrierIdentificationEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideCarrierIdentificationRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<CarrierIdentificationEntityRepository> provider) {
        return new ApplicationModule_ProvideCarrierIdentificationRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CarrierIdentificationRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}

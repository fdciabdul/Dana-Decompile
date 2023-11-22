package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CarrierIdentificationVerifyModule_ProvidePresenter$app_productionReleaseFactory implements Factory<CarrierIdentificationVerifyContract.Presenter> {
    private final Provider<CarrierIdentificationVerifyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final CarrierIdentificationVerifyModule MyBillsEntityDataFactory;

    public static CarrierIdentificationVerifyContract.Presenter getAuthRequestContext(CarrierIdentificationVerifyModule carrierIdentificationVerifyModule, CarrierIdentificationVerifyPresenter carrierIdentificationVerifyPresenter) {
        return (CarrierIdentificationVerifyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyModule.KClassImpl$Data$declaredNonStaticMembers$2(carrierIdentificationVerifyPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CarrierIdentificationVerifyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

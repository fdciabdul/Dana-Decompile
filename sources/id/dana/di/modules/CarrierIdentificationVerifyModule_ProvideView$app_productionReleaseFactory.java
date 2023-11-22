package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;

/* loaded from: classes4.dex */
public final class CarrierIdentificationVerifyModule_ProvideView$app_productionReleaseFactory implements Factory<CarrierIdentificationVerifyContract.View> {
    private final CarrierIdentificationVerifyModule getAuthRequestContext;

    public static CarrierIdentificationVerifyContract.View KClassImpl$Data$declaredNonStaticMembers$2(CarrierIdentificationVerifyModule carrierIdentificationVerifyModule) {
        return (CarrierIdentificationVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(carrierIdentificationVerifyModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CarrierIdentificationVerifyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}

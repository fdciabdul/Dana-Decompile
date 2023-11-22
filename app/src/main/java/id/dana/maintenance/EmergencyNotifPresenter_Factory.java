package id.dana.maintenance;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.carrieridentification.interactor.CheckIpificationCoverage;
import id.dana.domain.maintenance.interactor.GetEmergencyNotifConfig;
import id.dana.domain.registration.interactor.CheckRegisteredPhoneNumber;
import id.dana.maintenance.EmergencyNotifContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class EmergencyNotifPresenter_Factory implements Factory<EmergencyNotifPresenter> {
    private final Provider<CheckRegisteredPhoneNumber> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckIpificationCoverage> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetEmergencyNotifConfig> MyBillsEntityDataFactory;
    private final Provider<EmergencyNotifContract.View> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new EmergencyNotifPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}

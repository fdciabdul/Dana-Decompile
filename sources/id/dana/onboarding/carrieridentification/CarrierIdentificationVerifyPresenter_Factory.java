package id.dana.onboarding.carrieridentification;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.domain.carrieridentification.interactor.CheckIpificationAuthCode;
import id.dana.domain.carrieridentification.interactor.VerifyIpificationAuthCode;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class CarrierIdentificationVerifyPresenter_Factory implements Factory<CarrierIdentificationVerifyPresenter> {
    private final Provider<CheckIpificationAuthCode> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<VerifyIpificationAuthCode> MyBillsEntityDataFactory;
    private final Provider<CarrierIdentificationVerifyContract.View> PlaceComponentResult;
    private final Provider<RegistrationTracker> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CarrierIdentificationVerifyPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}

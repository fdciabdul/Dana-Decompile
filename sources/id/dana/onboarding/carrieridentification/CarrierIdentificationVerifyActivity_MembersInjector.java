package id.dana.onboarding.carrieridentification;

import dagger.MembersInjector;
import id.dana.challenge.pin.LogoutContract;
import id.dana.onboarding.carrieridentification.CarrierIdentificationVerifyContract;

/* loaded from: classes5.dex */
public final class CarrierIdentificationVerifyActivity_MembersInjector implements MembersInjector<CarrierIdentificationVerifyActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, LogoutContract.Presenter presenter) {
        carrierIdentificationVerifyActivity.logoutPresenter = presenter;
    }

    public static void PlaceComponentResult(CarrierIdentificationVerifyActivity carrierIdentificationVerifyActivity, CarrierIdentificationVerifyContract.Presenter presenter) {
        carrierIdentificationVerifyActivity.carrierIdentificationVerifyPresenter = presenter;
    }
}

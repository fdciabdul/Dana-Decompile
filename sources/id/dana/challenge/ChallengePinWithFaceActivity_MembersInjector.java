package id.dana.challenge;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.challenge.pin.LogoutContract;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.dialog.RiskRejectDialog;
import id.dana.tracker.mixpanel.BiometricAnalyticTracker;

/* loaded from: classes4.dex */
public final class ChallengePinWithFaceActivity_MembersInjector implements MembersInjector<ChallengePinWithFaceActivity> {
    public static void MyBillsEntityDataFactory(ChallengePinWithFaceActivity challengePinWithFaceActivity, ChallengePinWithFaceContract.Presenter presenter) {
        challengePinWithFaceActivity.challengePinWithFacePresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ChallengePinWithFaceActivity challengePinWithFaceActivity, DynamicUrlWrapper dynamicUrlWrapper) {
        challengePinWithFaceActivity.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ChallengePinWithFaceActivity challengePinWithFaceActivity, LogoutContract.Presenter presenter) {
        challengePinWithFaceActivity.logoutPresenter = presenter;
    }

    public static void PlaceComponentResult(ChallengePinWithFaceActivity challengePinWithFaceActivity, AbstractPinContract.Presenter presenter) {
        challengePinWithFaceActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(ChallengePinWithFaceActivity challengePinWithFaceActivity, BiometricAnalyticTracker biometricAnalyticTracker) {
        challengePinWithFaceActivity.biometricAnalyticTracker = biometricAnalyticTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ChallengePinWithFaceActivity challengePinWithFaceActivity, DeviceInformationProvider deviceInformationProvider) {
        challengePinWithFaceActivity.deviceInformationProvider = deviceInformationProvider;
    }

    public static void getAuthRequestContext(ChallengePinWithFaceActivity challengePinWithFaceActivity, Lazy<RiskRejectDialog> lazy) {
        challengePinWithFaceActivity.riskRejectDialog = lazy;
    }
}

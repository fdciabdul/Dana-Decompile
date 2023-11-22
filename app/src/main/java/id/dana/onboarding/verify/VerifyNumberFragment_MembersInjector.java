package id.dana.onboarding.verify;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.challenge.pin.LogoutContract;
import id.dana.contract.permission.PermissionStateContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.dialog.RiskRejectDialog;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.toggle.locationpermission.LocationPermissionSubject;

/* loaded from: classes5.dex */
public final class VerifyNumberFragment_MembersInjector implements MembersInjector<VerifyNumberFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment verifyNumberFragment, Lazy<DynamicUrlWrapper> lazy) {
        verifyNumberFragment.dynamicUrlWrapper = lazy;
    }

    public static void getErrorConfigVersion(VerifyNumberFragment verifyNumberFragment, Lazy<PermissionStateContract.Presenter> lazy) {
        verifyNumberFragment.permissionStatePresenter = lazy;
    }

    public static void PlaceComponentResult(VerifyNumberFragment verifyNumberFragment, Lazy<LocationPermissionSubject> lazy) {
        verifyNumberFragment.locationPermissionSubject = lazy;
    }

    public static void scheduleImpl(VerifyNumberFragment verifyNumberFragment, Lazy<VerifyNumberContract.Presenter> lazy) {
        verifyNumberFragment.verifyPresenter = lazy;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberFragment verifyNumberFragment, Lazy<DeviceInformationProvider> lazy) {
        verifyNumberFragment.deviceInformationProvider = lazy;
    }

    public static void getAuthRequestContext(VerifyNumberFragment verifyNumberFragment, Lazy<LogoutContract.Presenter> lazy) {
        verifyNumberFragment.logoutPresenter = lazy;
    }

    public static void MyBillsEntityDataFactory(VerifyNumberFragment verifyNumberFragment, Lazy<BotProtectionChallenge> lazy) {
        verifyNumberFragment.botProtectionChallenge = lazy;
    }

    public static void moveToNextValue(VerifyNumberFragment verifyNumberFragment, Lazy<RiskRejectDialog> lazy) {
        verifyNumberFragment.riskRejectDialog = lazy;
    }
}

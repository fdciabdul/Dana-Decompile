package id.dana.onboarding.splash;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.challenge.pin.LogoutContract;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.toggle.locationpermission.LocationPermissionSubject;

/* loaded from: classes5.dex */
public final class LocalConfigSplashActivity_MembersInjector implements MembersInjector<LocalConfigSplashActivity> {
    public static void MyBillsEntityDataFactory(LocalConfigSplashActivity localConfigSplashActivity, Lazy<DeepLinkContract.Presenter> lazy) {
        localConfigSplashActivity.sessionDeepLinkPresenter = lazy;
    }

    public static void PlaceComponentResult(LocalConfigSplashActivity localConfigSplashActivity, Lazy<LocalConfigSplashContract.Presenter> lazy) {
        localConfigSplashActivity.splashPresenter = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(LocalConfigSplashActivity localConfigSplashActivity, Lazy<LogoutContract.Presenter> lazy) {
        localConfigSplashActivity.logoutPresenter = lazy;
    }

    public static void getAuthRequestContext(LocalConfigSplashActivity localConfigSplashActivity, LocationPermissionSubject locationPermissionSubject) {
        localConfigSplashActivity.locationPermissionSubject = locationPermissionSubject;
    }
}

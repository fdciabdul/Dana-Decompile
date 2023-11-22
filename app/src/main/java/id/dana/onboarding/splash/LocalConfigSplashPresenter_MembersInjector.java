package id.dana.onboarding.splash;

import android.content.Context;
import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.InitSecurePreferenceAccount;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.here.interactor.InitHereConfig;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import id.dana.utils.session.SessionManager;

/* loaded from: classes5.dex */
public final class LocalConfigSplashPresenter_MembersInjector implements MembersInjector<LocalConfigSplashPresenter> {
    public static void PlaceComponentResult(LocalConfigSplashPresenter localConfigSplashPresenter, Lazy<GetPhoneNumber> lazy, Lazy<RemoveDeepLinkPayload> lazy2, GetUserId getUserId, Lazy<CheckSession> lazy3, InitSecurePreferenceAccount initSecurePreferenceAccount, Lazy<SaveIsSessionChecked> lazy4) {
        localConfigSplashPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        localConfigSplashPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy2;
        localConfigSplashPresenter.getAuthRequestContext = lazy3;
        localConfigSplashPresenter.moveToNextValue = initSecurePreferenceAccount;
        localConfigSplashPresenter.MyBillsEntityDataFactory = getUserId;
        localConfigSplashPresenter.getErrorConfigVersion = lazy4;
    }

    public static void getAuthRequestContext(LocalConfigSplashPresenter localConfigSplashPresenter, StartupConfigEntityData startupConfigEntityData, Lazy<InitHereConfig> lazy) {
        localConfigSplashPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = startupConfigEntityData;
        localConfigSplashPresenter.scheduleImpl = lazy;
    }

    public static void PlaceComponentResult(LocalConfigSplashPresenter localConfigSplashPresenter, SessionManager sessionManager) {
        localConfigSplashPresenter.DatabaseTableConfigUtil = sessionManager;
    }

    public static void MyBillsEntityDataFactory(LocalConfigSplashPresenter localConfigSplashPresenter, Lazy<PinCertificates> lazy, Lazy<SSLPinningHotUpdate> lazy2) {
        localConfigSplashPresenter.lookAheadTest = lazy;
        localConfigSplashPresenter.initRecordTimeStamp = lazy2;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(LocalConfigSplashPresenter localConfigSplashPresenter, Lazy<DeviceInformationProvider> lazy, Context context) {
        localConfigSplashPresenter.PlaceComponentResult = lazy;
        localConfigSplashPresenter.BuiltInFictitiousFunctionClassFactory = context;
    }
}

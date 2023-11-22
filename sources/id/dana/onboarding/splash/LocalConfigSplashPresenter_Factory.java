package id.dana.onboarding.splash;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.InitSecurePreferenceAccount;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.interactor.IsAppFirstLaunch;
import id.dana.domain.here.interactor.InitHereConfig;
import id.dana.domain.login.interactor.CheckSession;
import id.dana.domain.login.interactor.NotifyPay;
import id.dana.domain.login.interactor.SaveIsSessionChecked;
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import id.dana.onboarding.splash.LocalConfigSplashContract;
import id.dana.utils.session.SessionManager;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LocalConfigSplashPresenter_Factory implements Factory<LocalConfigSplashPresenter> {
    private final Provider<CheckSession> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SSLPinningHotUpdate> DatabaseTableConfigUtil;
    private final Provider<StartupConfigEntityData> GetContactSyncConfig;
    private final Provider<GetPhoneNumber> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<InitHereConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveIsSessionChecked> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SessionManager> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<GetUserId> getAuthRequestContext;
    private final Provider<NotifyPay> getErrorConfigVersion;
    private final Provider<RemoveDeepLinkPayload> initRecordTimeStamp;
    private final Provider<PinCertificates> lookAheadTest;
    private final Provider<IsAppFirstLaunch> moveToNextValue;
    private final Provider<LocalConfigSplashContract.View> newProxyInstance;
    private final Provider<InitSecurePreferenceAccount> scheduleImpl;

    private LocalConfigSplashPresenter_Factory(Provider<LocalConfigSplashContract.View> provider, Provider<NotifyPay> provider2, Provider<IsAppFirstLaunch> provider3, Provider<PinCertificates> provider4, Provider<SSLPinningHotUpdate> provider5, Provider<GetPhoneNumber> provider6, Provider<RemoveDeepLinkPayload> provider7, Provider<GetUserId> provider8, Provider<CheckSession> provider9, Provider<InitSecurePreferenceAccount> provider10, Provider<SaveIsSessionChecked> provider11, Provider<StartupConfigEntityData> provider12, Provider<InitHereConfig> provider13, Provider<SessionManager> provider14, Provider<DeviceInformationProvider> provider15, Provider<Context> provider16) {
        this.newProxyInstance = provider;
        this.getErrorConfigVersion = provider2;
        this.moveToNextValue = provider3;
        this.lookAheadTest = provider4;
        this.DatabaseTableConfigUtil = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.initRecordTimeStamp = provider7;
        this.getAuthRequestContext = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
        this.scheduleImpl = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider11;
        this.GetContactSyncConfig = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider14;
        this.PlaceComponentResult = provider15;
        this.MyBillsEntityDataFactory = provider16;
    }

    public static LocalConfigSplashPresenter_Factory MyBillsEntityDataFactory(Provider<LocalConfigSplashContract.View> provider, Provider<NotifyPay> provider2, Provider<IsAppFirstLaunch> provider3, Provider<PinCertificates> provider4, Provider<SSLPinningHotUpdate> provider5, Provider<GetPhoneNumber> provider6, Provider<RemoveDeepLinkPayload> provider7, Provider<GetUserId> provider8, Provider<CheckSession> provider9, Provider<InitSecurePreferenceAccount> provider10, Provider<SaveIsSessionChecked> provider11, Provider<StartupConfigEntityData> provider12, Provider<InitHereConfig> provider13, Provider<SessionManager> provider14, Provider<DeviceInformationProvider> provider15, Provider<Context> provider16) {
        return new LocalConfigSplashPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        LocalConfigSplashPresenter localConfigSplashPresenter = new LocalConfigSplashPresenter(this.newProxyInstance.get(), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue));
        LocalConfigSplashPresenter_MembersInjector.MyBillsEntityDataFactory(localConfigSplashPresenter, DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil));
        LocalConfigSplashPresenter_MembersInjector.PlaceComponentResult(localConfigSplashPresenter, DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), this.getAuthRequestContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), this.scheduleImpl.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1));
        LocalConfigSplashPresenter_MembersInjector.getAuthRequestContext(localConfigSplashPresenter, this.GetContactSyncConfig.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        LocalConfigSplashPresenter_MembersInjector.PlaceComponentResult(localConfigSplashPresenter, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get());
        LocalConfigSplashPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(localConfigSplashPresenter, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), this.MyBillsEntityDataFactory.get());
        return localConfigSplashPresenter;
    }
}

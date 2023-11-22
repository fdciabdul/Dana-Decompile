package id.dana.data.login;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.clear.repository.ClearAccountEntityDataFactory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.deeplink.repository.source.DeepLinkEntityDataFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.login.source.LoginEntityDataFactory;
import id.dana.data.login.source.LoginMapper;
import id.dana.data.notificationcenter.repository.source.PushNotificationEntityDataFactory;
import id.dana.data.otp.OtpRetryManager;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.data.user.source.UserInfoEntityDataFactory;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LoginEntityRepository_Factory implements Factory<LoginEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<VerifyChallengeManager> challengeManagerProvider;
    private final Provider<ClearAccountEntityDataFactory> clearAccountEntityDataFactoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DeepLinkEntityDataFactory> deepLinkEntityDataFactoryProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<HomeWidgetRepository> homeWidgetRepositoryProvider;
    private final Provider<LoginEntityDataFactory> loginEntityDataFactoryProvider;
    private final Provider<LoginLogoutSubject> loginLogoutSubjectProvider;
    private final Provider<LoginMapper> loginMapperProvider;
    private final Provider<OtpRetryManager> otpRetryManagerProvider;
    private final Provider<PaylaterRepository> payLaterRepositoryProvider;
    private final Provider<PushNotificationEntityDataFactory> pushNotificationEntityDataFactoryProvider;
    private final Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private final Provider<RegistrationProcessManager> regManagerProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;
    private final Provider<TwilioSdkRepository> twilioSdkRepositoryProvider;
    private final Provider<UserInfoEntityDataFactory> userInfoEntityDataFactoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;
    private final Provider<VerifyTokenRepository> verifyTokenRepositoryProvider;

    public LoginEntityRepository_Factory(Provider<LoginEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<UserInfoEntityDataFactory> provider4, Provider<PushNotificationEntityDataFactory> provider5, Provider<DeepLinkEntityDataFactory> provider6, Provider<VerifyTokenRepository> provider7, Provider<DeviceInformationProvider> provider8, Provider<SecurityGuardFacade> provider9, Provider<RegistrationProcessManager> provider10, Provider<VerifyChallengeManager> provider11, Provider<OtpRetryManager> provider12, Provider<LoginMapper> provider13, Provider<PushNotificationRepository> provider14, Provider<Context> provider15, Provider<TwilioSdkRepository> provider16, Provider<LoginLogoutSubject> provider17, Provider<UserRepository> provider18, Provider<PaylaterRepository> provider19, Provider<ClearAccountEntityDataFactory> provider20, Provider<HomeWidgetRepository> provider21, Provider<SharedPrefStartupConfig> provider22, Provider<GeneralPreferencesDataFactory> provider23) {
        this.loginEntityDataFactoryProvider = provider;
        this.securityEntityDataFactoryProvider = provider2;
        this.accountEntityDataFactoryProvider = provider3;
        this.userInfoEntityDataFactoryProvider = provider4;
        this.pushNotificationEntityDataFactoryProvider = provider5;
        this.deepLinkEntityDataFactoryProvider = provider6;
        this.verifyTokenRepositoryProvider = provider7;
        this.deviceInformationProvider = provider8;
        this.securityGuardFacadeProvider = provider9;
        this.regManagerProvider = provider10;
        this.challengeManagerProvider = provider11;
        this.otpRetryManagerProvider = provider12;
        this.loginMapperProvider = provider13;
        this.pushNotificationRepositoryProvider = provider14;
        this.contextProvider = provider15;
        this.twilioSdkRepositoryProvider = provider16;
        this.loginLogoutSubjectProvider = provider17;
        this.userRepositoryProvider = provider18;
        this.payLaterRepositoryProvider = provider19;
        this.clearAccountEntityDataFactoryProvider = provider20;
        this.homeWidgetRepositoryProvider = provider21;
        this.sharedPrefStartupConfigProvider = provider22;
        this.generalPreferencesDataFactoryProvider = provider23;
    }

    @Override // javax.inject.Provider
    public final LoginEntityRepository get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.loginEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.accountEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.userInfoEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.pushNotificationEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.deepLinkEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.verifyTokenRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.deviceInformationProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityGuardFacadeProvider), DoubleCheck.MyBillsEntityDataFactory(this.regManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.challengeManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.otpRetryManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.loginMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.pushNotificationRepositoryProvider), this.contextProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.twilioSdkRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.loginLogoutSubjectProvider), DoubleCheck.MyBillsEntityDataFactory(this.userRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.payLaterRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.clearAccountEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.homeWidgetRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefStartupConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesDataFactoryProvider));
    }

    public static LoginEntityRepository_Factory create(Provider<LoginEntityDataFactory> provider, Provider<SecurityEntityDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<UserInfoEntityDataFactory> provider4, Provider<PushNotificationEntityDataFactory> provider5, Provider<DeepLinkEntityDataFactory> provider6, Provider<VerifyTokenRepository> provider7, Provider<DeviceInformationProvider> provider8, Provider<SecurityGuardFacade> provider9, Provider<RegistrationProcessManager> provider10, Provider<VerifyChallengeManager> provider11, Provider<OtpRetryManager> provider12, Provider<LoginMapper> provider13, Provider<PushNotificationRepository> provider14, Provider<Context> provider15, Provider<TwilioSdkRepository> provider16, Provider<LoginLogoutSubject> provider17, Provider<UserRepository> provider18, Provider<PaylaterRepository> provider19, Provider<ClearAccountEntityDataFactory> provider20, Provider<HomeWidgetRepository> provider21, Provider<SharedPrefStartupConfig> provider22, Provider<GeneralPreferencesDataFactory> provider23) {
        return new LoginEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    public static LoginEntityRepository newInstance(Lazy<LoginEntityDataFactory> lazy, Lazy<SecurityEntityDataFactory> lazy2, Lazy<AccountEntityDataFactory> lazy3, Lazy<UserInfoEntityDataFactory> lazy4, Lazy<PushNotificationEntityDataFactory> lazy5, Lazy<DeepLinkEntityDataFactory> lazy6, Lazy<VerifyTokenRepository> lazy7, Lazy<DeviceInformationProvider> lazy8, Lazy<SecurityGuardFacade> lazy9, Lazy<RegistrationProcessManager> lazy10, Lazy<VerifyChallengeManager> lazy11, Lazy<OtpRetryManager> lazy12, Lazy<LoginMapper> lazy13, Lazy<PushNotificationRepository> lazy14, Context context, Lazy<TwilioSdkRepository> lazy15, Lazy<LoginLogoutSubject> lazy16, Lazy<UserRepository> lazy17, Lazy<PaylaterRepository> lazy18, Lazy<ClearAccountEntityDataFactory> lazy19, Lazy<HomeWidgetRepository> lazy20, Lazy<SharedPrefStartupConfig> lazy21, Lazy<GeneralPreferencesDataFactory> lazy22) {
        return new LoginEntityRepository(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, context, lazy15, lazy16, lazy17, lazy18, lazy19, lazy20, lazy21, lazy22);
    }
}

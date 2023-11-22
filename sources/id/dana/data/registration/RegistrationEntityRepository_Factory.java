package id.dana.data.registration;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.avatar.repository.source.AvatarEntityDataFactory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.deeplink.repository.source.DeepLinkEntityDataFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.notificationcenter.repository.source.PushNotificationEntityDataFactory;
import id.dana.data.otp.repository.source.OtpEntityDataFactory;
import id.dana.data.registration.source.RegistrationEntityDataFactory;
import id.dana.data.registration.source.RegistrationMapper;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RegistrationEntityRepository_Factory implements Factory<RegistrationEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<AvatarEntityDataFactory> avatarEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DeepLinkEntityDataFactory> deepLinkEntityDataFactoryProvider;
    private final Provider<DeepLinkPayloadManager> deepLinkPayloadManagerProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<GeocodeEntityRepository> geocodeEntityRepositoryProvider;
    private final Provider<LoginLogoutSubject> loginLogoutSubjectProvider;
    private final Provider<OtpEntityDataFactory> otpEntityDataFactoryProvider;
    private final Provider<PushNotificationEntityDataFactory> pushNotificationEntityDataFactoryProvider;
    private final Provider<RegistrationProcessManager> regManagerProvider;
    private final Provider<RegistrationEntityDataFactory> registrationEntityDataFactoryProvider;
    private final Provider<RegistrationMapper> registrationMapperProvider;
    private final Provider<SecurityEntityDataFactory> securityEntityDataFactoryProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;
    private final Provider<SSLQuakeInterceptor> sslQuakeInterceptorProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public RegistrationEntityRepository_Factory(Provider<AccountEntityDataFactory> provider, Provider<AvatarEntityDataFactory> provider2, Provider<RegistrationProcessManager> provider3, Provider<DeepLinkPayloadManager> provider4, Provider<RegistrationEntityDataFactory> provider5, Provider<RegistrationMapper> provider6, Provider<SecurityEntityDataFactory> provider7, Provider<PushNotificationEntityDataFactory> provider8, Provider<GeneralPreferencesDataFactory> provider9, Provider<SecurityGuardFacade> provider10, Provider<DeviceInformationProvider> provider11, Provider<DeepLinkEntityDataFactory> provider12, Provider<GeocodeEntityRepository> provider13, Provider<LoginLogoutSubject> provider14, Provider<OtpEntityDataFactory> provider15, Provider<ConfigEntityDataFactory> provider16, Provider<UserRepository> provider17, Provider<SSLQuakeInterceptor> provider18) {
        this.accountEntityDataFactoryProvider = provider;
        this.avatarEntityDataFactoryProvider = provider2;
        this.regManagerProvider = provider3;
        this.deepLinkPayloadManagerProvider = provider4;
        this.registrationEntityDataFactoryProvider = provider5;
        this.registrationMapperProvider = provider6;
        this.securityEntityDataFactoryProvider = provider7;
        this.pushNotificationEntityDataFactoryProvider = provider8;
        this.generalPreferencesDataFactoryProvider = provider9;
        this.securityGuardFacadeProvider = provider10;
        this.deviceInformationProvider = provider11;
        this.deepLinkEntityDataFactoryProvider = provider12;
        this.geocodeEntityRepositoryProvider = provider13;
        this.loginLogoutSubjectProvider = provider14;
        this.otpEntityDataFactoryProvider = provider15;
        this.configEntityDataFactoryProvider = provider16;
        this.userRepositoryProvider = provider17;
        this.sslQuakeInterceptorProvider = provider18;
    }

    @Override // javax.inject.Provider
    public final RegistrationEntityRepository get() {
        RegistrationEntityRepository newInstance = newInstance(DoubleCheck.MyBillsEntityDataFactory(this.accountEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.avatarEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.regManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.deepLinkPayloadManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.registrationEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.registrationMapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.pushNotificationEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.securityGuardFacadeProvider), DoubleCheck.MyBillsEntityDataFactory(this.deviceInformationProvider), DoubleCheck.MyBillsEntityDataFactory(this.deepLinkEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.geocodeEntityRepositoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.loginLogoutSubjectProvider), DoubleCheck.MyBillsEntityDataFactory(this.otpEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.configEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.userRepositoryProvider));
        RegistrationEntityRepository_MembersInjector.injectInjectSslDependencies(newInstance, DoubleCheck.MyBillsEntityDataFactory(this.sslQuakeInterceptorProvider));
        return newInstance;
    }

    public static RegistrationEntityRepository_Factory create(Provider<AccountEntityDataFactory> provider, Provider<AvatarEntityDataFactory> provider2, Provider<RegistrationProcessManager> provider3, Provider<DeepLinkPayloadManager> provider4, Provider<RegistrationEntityDataFactory> provider5, Provider<RegistrationMapper> provider6, Provider<SecurityEntityDataFactory> provider7, Provider<PushNotificationEntityDataFactory> provider8, Provider<GeneralPreferencesDataFactory> provider9, Provider<SecurityGuardFacade> provider10, Provider<DeviceInformationProvider> provider11, Provider<DeepLinkEntityDataFactory> provider12, Provider<GeocodeEntityRepository> provider13, Provider<LoginLogoutSubject> provider14, Provider<OtpEntityDataFactory> provider15, Provider<ConfigEntityDataFactory> provider16, Provider<UserRepository> provider17, Provider<SSLQuakeInterceptor> provider18) {
        return new RegistrationEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    public static RegistrationEntityRepository newInstance(Lazy<AccountEntityDataFactory> lazy, Lazy<AvatarEntityDataFactory> lazy2, Lazy<RegistrationProcessManager> lazy3, Lazy<DeepLinkPayloadManager> lazy4, Lazy<RegistrationEntityDataFactory> lazy5, Lazy<RegistrationMapper> lazy6, Lazy<SecurityEntityDataFactory> lazy7, Lazy<PushNotificationEntityDataFactory> lazy8, Lazy<GeneralPreferencesDataFactory> lazy9, Lazy<SecurityGuardFacade> lazy10, Lazy<DeviceInformationProvider> lazy11, Lazy<DeepLinkEntityDataFactory> lazy12, Lazy<GeocodeEntityRepository> lazy13, Lazy<LoginLogoutSubject> lazy14, Lazy<OtpEntityDataFactory> lazy15, Lazy<ConfigEntityDataFactory> lazy16, Lazy<UserRepository> lazy17) {
        return new RegistrationEntityRepository(lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10, lazy11, lazy12, lazy13, lazy14, lazy15, lazy16, lazy17);
    }
}

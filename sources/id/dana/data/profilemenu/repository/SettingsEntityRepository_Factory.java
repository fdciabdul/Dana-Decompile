package id.dana.data.profilemenu.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.profilemenu.mapper.SettingsMapper;
import id.dana.data.profilemenu.repository.source.SettingsEntityDataFactory;
import id.dana.data.profilemenu.repository.source.local.SettingPreference;
import id.dana.data.profilemenu.repository.source.network.PaymentAuthenticationDataFactory;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SettingsEntityRepository_Factory implements Factory<SettingsEntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<PaymentAuthenticationDataFactory> paymentAuthenticationDataFactoryProvider;
    private final Provider<SettingPreference> settingPreferenceProvider;
    private final Provider<SettingsEntityDataFactory> settingsEntityDataFactoryProvider;
    private final Provider<SettingsMapper> settingsMapperProvider;
    private final Provider<UserConfigEntityRepository> userConfigEntityRepositoryProvider;
    private final Provider<VerifyTokenRepository> verifyTokenRepositoryProvider;

    public SettingsEntityRepository_Factory(Provider<SettingsEntityDataFactory> provider, Provider<PaymentAuthenticationDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<VerifyTokenRepository> provider4, Provider<SettingsMapper> provider5, Provider<UserConfigEntityRepository> provider6, Provider<SettingPreference> provider7) {
        this.settingsEntityDataFactoryProvider = provider;
        this.paymentAuthenticationDataFactoryProvider = provider2;
        this.accountEntityDataFactoryProvider = provider3;
        this.verifyTokenRepositoryProvider = provider4;
        this.settingsMapperProvider = provider5;
        this.userConfigEntityRepositoryProvider = provider6;
        this.settingPreferenceProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final SettingsEntityRepository get() {
        return newInstance(this.settingsEntityDataFactoryProvider.get(), this.paymentAuthenticationDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.verifyTokenRepositoryProvider.get(), this.settingsMapperProvider.get(), this.userConfigEntityRepositoryProvider.get(), this.settingPreferenceProvider.get());
    }

    public static SettingsEntityRepository_Factory create(Provider<SettingsEntityDataFactory> provider, Provider<PaymentAuthenticationDataFactory> provider2, Provider<AccountEntityDataFactory> provider3, Provider<VerifyTokenRepository> provider4, Provider<SettingsMapper> provider5, Provider<UserConfigEntityRepository> provider6, Provider<SettingPreference> provider7) {
        return new SettingsEntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SettingsEntityRepository newInstance(SettingsEntityDataFactory settingsEntityDataFactory, PaymentAuthenticationDataFactory paymentAuthenticationDataFactory, AccountEntityDataFactory accountEntityDataFactory, VerifyTokenRepository verifyTokenRepository, SettingsMapper settingsMapper, UserConfigEntityRepository userConfigEntityRepository, SettingPreference settingPreference) {
        return new SettingsEntityRepository(settingsEntityDataFactory, paymentAuthenticationDataFactory, accountEntityDataFactory, verifyTokenRepository, settingsMapper, userConfigEntityRepository, settingPreference);
    }
}

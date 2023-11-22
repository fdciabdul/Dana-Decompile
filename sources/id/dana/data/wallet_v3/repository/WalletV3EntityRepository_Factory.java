package id.dana.data.wallet_v3.repository;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.user.UserInfoMapper;
import id.dana.data.wallet_v3.repository.source.WalletV3EntityDataFactory;
import id.dana.data.wallet_v3.repository.source.local.WalletV3Preference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletV3EntityRepository_Factory implements Factory<WalletV3EntityRepository> {
    private final Provider<AccountEntityDataFactory> accountEntityDataFactoryProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<UserInfoMapper> userInfoMapperProvider;
    private final Provider<WalletConfigEntityRepository> walletConfigEntityRepositoryProvider;
    private final Provider<WalletV3EntityDataFactory> walletV3EntityDataFactoryProvider;
    private final Provider<WalletV3Preference> walletV3PreferenceProvider;

    public WalletV3EntityRepository_Factory(Provider<WalletV3EntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<UserInfoMapper> provider3, Provider<WalletV3Preference> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<WalletConfigEntityRepository> provider6) {
        this.walletV3EntityDataFactoryProvider = provider;
        this.accountEntityDataFactoryProvider = provider2;
        this.userInfoMapperProvider = provider3;
        this.walletV3PreferenceProvider = provider4;
        this.configEntityDataFactoryProvider = provider5;
        this.walletConfigEntityRepositoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final WalletV3EntityRepository get() {
        return newInstance(this.walletV3EntityDataFactoryProvider.get(), this.accountEntityDataFactoryProvider.get(), this.userInfoMapperProvider.get(), this.walletV3PreferenceProvider.get(), this.configEntityDataFactoryProvider.get(), this.walletConfigEntityRepositoryProvider.get());
    }

    public static WalletV3EntityRepository_Factory create(Provider<WalletV3EntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<UserInfoMapper> provider3, Provider<WalletV3Preference> provider4, Provider<ConfigEntityDataFactory> provider5, Provider<WalletConfigEntityRepository> provider6) {
        return new WalletV3EntityRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static WalletV3EntityRepository newInstance(WalletV3EntityDataFactory walletV3EntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, UserInfoMapper userInfoMapper, WalletV3Preference walletV3Preference, ConfigEntityDataFactory configEntityDataFactory, WalletConfigEntityRepository walletConfigEntityRepository) {
        return new WalletV3EntityRepository(walletV3EntityDataFactory, accountEntityDataFactory, userInfoMapper, walletV3Preference, configEntityDataFactory, walletConfigEntityRepository);
    }
}

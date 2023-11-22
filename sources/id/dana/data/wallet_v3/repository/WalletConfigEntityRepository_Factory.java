package id.dana.data.wallet_v3.repository;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.services.repository.source.ServicesEntityDataFactory;
import id.dana.data.wallet_v3.repository.source.network.WalletConfigEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletConfigEntityRepository_Factory implements Factory<WalletConfigEntityRepository> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<HomeInfoResultMapper> homeInfoResultMapperProvider;
    private final Provider<ServicesEntityDataFactory> servicesEntityDataFactoryProvider;
    private final Provider<WalletConfigEntityDataFactory> walletConfigEntityDataFactoryProvider;

    public WalletConfigEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<WalletConfigEntityDataFactory> provider2, Provider<ServicesEntityDataFactory> provider3, Provider<HomeInfoResultMapper> provider4) {
        this.configEntityDataFactoryProvider = provider;
        this.walletConfigEntityDataFactoryProvider = provider2;
        this.servicesEntityDataFactoryProvider = provider3;
        this.homeInfoResultMapperProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final WalletConfigEntityRepository get() {
        return newInstance(this.configEntityDataFactoryProvider.get(), this.walletConfigEntityDataFactoryProvider.get(), this.servicesEntityDataFactoryProvider.get(), this.homeInfoResultMapperProvider.get());
    }

    public static WalletConfigEntityRepository_Factory create(Provider<ConfigEntityDataFactory> provider, Provider<WalletConfigEntityDataFactory> provider2, Provider<ServicesEntityDataFactory> provider3, Provider<HomeInfoResultMapper> provider4) {
        return new WalletConfigEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static WalletConfigEntityRepository newInstance(ConfigEntityDataFactory configEntityDataFactory, WalletConfigEntityDataFactory walletConfigEntityDataFactory, ServicesEntityDataFactory servicesEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper) {
        return new WalletConfigEntityRepository(configEntityDataFactory, walletConfigEntityDataFactory, servicesEntityDataFactory, homeInfoResultMapper);
    }
}

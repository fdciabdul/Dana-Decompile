package id.dana.data.deeplink.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.mapper.BranchIoDeepLinkEntityMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkLinkApiEntityData_Factory implements Factory<NetworkLinkApiEntityData> {
    private final Provider<BranchApi> branchApiProvider;
    private final Provider<BranchIoDeepLinkEntityMapper> branchIoDeepLinkEntityMapperProvider;
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;

    public NetworkLinkApiEntityData_Factory(Provider<BranchApi> provider, Provider<ConfigEntityDataFactory> provider2, Provider<BranchIoDeepLinkEntityMapper> provider3) {
        this.branchApiProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.branchIoDeepLinkEntityMapperProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NetworkLinkApiEntityData get() {
        return newInstance(this.branchApiProvider.get(), this.configEntityDataFactoryProvider.get(), this.branchIoDeepLinkEntityMapperProvider.get());
    }

    public static NetworkLinkApiEntityData_Factory create(Provider<BranchApi> provider, Provider<ConfigEntityDataFactory> provider2, Provider<BranchIoDeepLinkEntityMapper> provider3) {
        return new NetworkLinkApiEntityData_Factory(provider, provider2, provider3);
    }

    public static NetworkLinkApiEntityData newInstance(BranchApi branchApi, ConfigEntityDataFactory configEntityDataFactory, BranchIoDeepLinkEntityMapper branchIoDeepLinkEntityMapper) {
        return new NetworkLinkApiEntityData(branchApi, configEntityDataFactory, branchIoDeepLinkEntityMapper);
    }
}

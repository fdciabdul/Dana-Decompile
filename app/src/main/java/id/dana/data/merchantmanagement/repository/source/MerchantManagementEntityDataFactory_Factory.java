package id.dana.data.merchantmanagement.repository.source;

import dagger.internal.Factory;
import id.dana.data.merchantmanagement.repository.source.mock.MockMerchantManagementEntityData;
import id.dana.data.merchantmanagement.repository.source.network.NetworkMerchantManagementEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantManagementEntityDataFactory_Factory implements Factory<MerchantManagementEntityDataFactory> {
    private final Provider<MockMerchantManagementEntityData> mockMerchantManagementEntityDataProvider;
    private final Provider<NetworkMerchantManagementEntityData> networkMerchantManagementEntityDataProvider;

    public MerchantManagementEntityDataFactory_Factory(Provider<NetworkMerchantManagementEntityData> provider, Provider<MockMerchantManagementEntityData> provider2) {
        this.networkMerchantManagementEntityDataProvider = provider;
        this.mockMerchantManagementEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MerchantManagementEntityDataFactory get() {
        return newInstance(this.networkMerchantManagementEntityDataProvider.get(), this.mockMerchantManagementEntityDataProvider.get());
    }

    public static MerchantManagementEntityDataFactory_Factory create(Provider<NetworkMerchantManagementEntityData> provider, Provider<MockMerchantManagementEntityData> provider2) {
        return new MerchantManagementEntityDataFactory_Factory(provider, provider2);
    }

    public static MerchantManagementEntityDataFactory newInstance(NetworkMerchantManagementEntityData networkMerchantManagementEntityData, MockMerchantManagementEntityData mockMerchantManagementEntityData) {
        return new MerchantManagementEntityDataFactory(networkMerchantManagementEntityData, mockMerchantManagementEntityData);
    }
}

package id.dana.data.merchant.repository.source.amcs;

import dagger.internal.Factory;
import id.dana.data.base.DanaContentApi;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkMerchantCategoriesEntityData_Factory implements Factory<NetworkMerchantCategoriesEntityData> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<DanaContentApi> danaContentApiProvider;
    private final Provider<Serializer> serializerProvider;

    public NetworkMerchantCategoriesEntityData_Factory(Provider<Serializer> provider, Provider<ConfigEntityDataFactory> provider2, Provider<DanaContentApi> provider3) {
        this.serializerProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
        this.danaContentApiProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final NetworkMerchantCategoriesEntityData get() {
        return newInstance(this.serializerProvider.get(), this.configEntityDataFactoryProvider.get(), this.danaContentApiProvider.get());
    }

    public static NetworkMerchantCategoriesEntityData_Factory create(Provider<Serializer> provider, Provider<ConfigEntityDataFactory> provider2, Provider<DanaContentApi> provider3) {
        return new NetworkMerchantCategoriesEntityData_Factory(provider, provider2, provider3);
    }

    public static NetworkMerchantCategoriesEntityData newInstance(Serializer serializer, ConfigEntityDataFactory configEntityDataFactory, DanaContentApi danaContentApi) {
        return new NetworkMerchantCategoriesEntityData(serializer, configEntityDataFactory, danaContentApi);
    }
}

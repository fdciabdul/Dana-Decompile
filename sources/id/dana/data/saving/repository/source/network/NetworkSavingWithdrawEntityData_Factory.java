package id.dana.data.saving.repository.source.network;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkSavingWithdrawEntityData_Factory implements Factory<NetworkSavingWithdrawEntityData> {
    private final Provider<ConfigEntityDataFactory> configEntityDataFactoryProvider;
    private final Provider<Serializer> serializerProvider;

    public NetworkSavingWithdrawEntityData_Factory(Provider<Serializer> provider, Provider<ConfigEntityDataFactory> provider2) {
        this.serializerProvider = provider;
        this.configEntityDataFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final NetworkSavingWithdrawEntityData get() {
        return newInstance(this.serializerProvider.get(), this.configEntityDataFactoryProvider.get());
    }

    public static NetworkSavingWithdrawEntityData_Factory create(Provider<Serializer> provider, Provider<ConfigEntityDataFactory> provider2) {
        return new NetworkSavingWithdrawEntityData_Factory(provider, provider2);
    }

    public static NetworkSavingWithdrawEntityData newInstance(Serializer serializer, ConfigEntityDataFactory configEntityDataFactory) {
        return new NetworkSavingWithdrawEntityData(serializer, configEntityDataFactory);
    }
}

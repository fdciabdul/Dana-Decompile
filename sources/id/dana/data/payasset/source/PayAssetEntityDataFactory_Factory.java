package id.dana.data.payasset.source;

import dagger.internal.Factory;
import id.dana.data.payasset.source.network.NetworkPayAssetEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PayAssetEntityDataFactory_Factory implements Factory<PayAssetEntityDataFactory> {
    private final Provider<NetworkPayAssetEntityData> networkPayAssetEntityDataProvider;

    public PayAssetEntityDataFactory_Factory(Provider<NetworkPayAssetEntityData> provider) {
        this.networkPayAssetEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PayAssetEntityDataFactory get() {
        return newInstance(this.networkPayAssetEntityDataProvider.get());
    }

    public static PayAssetEntityDataFactory_Factory create(Provider<NetworkPayAssetEntityData> provider) {
        return new PayAssetEntityDataFactory_Factory(provider);
    }

    public static PayAssetEntityDataFactory newInstance(NetworkPayAssetEntityData networkPayAssetEntityData) {
        return new PayAssetEntityDataFactory(networkPayAssetEntityData);
    }
}

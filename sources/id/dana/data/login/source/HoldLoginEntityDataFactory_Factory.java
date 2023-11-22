package id.dana.data.login.source;

import dagger.internal.Factory;
import id.dana.data.login.source.network.NetworkHoldLoginEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginEntityDataFactory_Factory implements Factory<HoldLoginEntityDataFactory> {
    private final Provider<NetworkHoldLoginEntityData> networkHoldLoginEntityDataProvider;

    public HoldLoginEntityDataFactory_Factory(Provider<NetworkHoldLoginEntityData> provider) {
        this.networkHoldLoginEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HoldLoginEntityDataFactory get() {
        return newInstance(this.networkHoldLoginEntityDataProvider.get());
    }

    public static HoldLoginEntityDataFactory_Factory create(Provider<NetworkHoldLoginEntityData> provider) {
        return new HoldLoginEntityDataFactory_Factory(provider);
    }

    public static HoldLoginEntityDataFactory newInstance(NetworkHoldLoginEntityData networkHoldLoginEntityData) {
        return new HoldLoginEntityDataFactory(networkHoldLoginEntityData);
    }
}

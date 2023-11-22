package id.dana.data.ipg.repository.source;

import dagger.internal.Factory;
import id.dana.data.ipg.repository.source.network.NetworkIpgRegistrationUrlEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class IpgRegistrationUrlEntityDataFactory_Factory implements Factory<IpgRegistrationUrlEntityDataFactory> {
    private final Provider<NetworkIpgRegistrationUrlEntityData> networkIpgRegistrationUrlEntityDataProvider;

    public IpgRegistrationUrlEntityDataFactory_Factory(Provider<NetworkIpgRegistrationUrlEntityData> provider) {
        this.networkIpgRegistrationUrlEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IpgRegistrationUrlEntityDataFactory get() {
        return newInstance(this.networkIpgRegistrationUrlEntityDataProvider.get());
    }

    public static IpgRegistrationUrlEntityDataFactory_Factory create(Provider<NetworkIpgRegistrationUrlEntityData> provider) {
        return new IpgRegistrationUrlEntityDataFactory_Factory(provider);
    }

    public static IpgRegistrationUrlEntityDataFactory newInstance(NetworkIpgRegistrationUrlEntityData networkIpgRegistrationUrlEntityData) {
        return new IpgRegistrationUrlEntityDataFactory(networkIpgRegistrationUrlEntityData);
    }
}

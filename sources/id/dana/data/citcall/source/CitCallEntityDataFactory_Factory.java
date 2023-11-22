package id.dana.data.citcall.source;

import dagger.internal.Factory;
import id.dana.data.citcall.source.network.NetworkCitCallEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CitCallEntityDataFactory_Factory implements Factory<CitCallEntityDataFactory> {
    private final Provider<NetworkCitCallEntityData> networkCitcallEntityDataProvider;

    public CitCallEntityDataFactory_Factory(Provider<NetworkCitCallEntityData> provider) {
        this.networkCitcallEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CitCallEntityDataFactory get() {
        return newInstance(this.networkCitcallEntityDataProvider.get());
    }

    public static CitCallEntityDataFactory_Factory create(Provider<NetworkCitCallEntityData> provider) {
        return new CitCallEntityDataFactory_Factory(provider);
    }

    public static CitCallEntityDataFactory newInstance(NetworkCitCallEntityData networkCitCallEntityData) {
        return new CitCallEntityDataFactory(networkCitCallEntityData);
    }
}

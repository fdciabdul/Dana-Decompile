package id.dana.data.globalnetwork.source;

import dagger.internal.Factory;
import id.dana.data.globalnetwork.source.local.GlobalNetworkPreference;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GnPaymentDataFactory_Factory implements Factory<GnPaymentDataFactory> {
    private final Provider<GlobalNetworkPreference> globalNetworkPreferenceProvider;
    private final Provider<RemoteGnPaymentEntityData> remoteGnPaymentEntityDataProvider;

    public GnPaymentDataFactory_Factory(Provider<GlobalNetworkPreference> provider, Provider<RemoteGnPaymentEntityData> provider2) {
        this.globalNetworkPreferenceProvider = provider;
        this.remoteGnPaymentEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GnPaymentDataFactory get() {
        GnPaymentDataFactory newInstance = newInstance(this.globalNetworkPreferenceProvider.get());
        GnPaymentDataFactory_MembersInjector.injectRemoteGnPaymentEntityData(newInstance, this.remoteGnPaymentEntityDataProvider.get());
        return newInstance;
    }

    public static GnPaymentDataFactory_Factory create(Provider<GlobalNetworkPreference> provider, Provider<RemoteGnPaymentEntityData> provider2) {
        return new GnPaymentDataFactory_Factory(provider, provider2);
    }

    public static GnPaymentDataFactory newInstance(GlobalNetworkPreference globalNetworkPreference) {
        return new GnPaymentDataFactory(globalNetworkPreference);
    }
}

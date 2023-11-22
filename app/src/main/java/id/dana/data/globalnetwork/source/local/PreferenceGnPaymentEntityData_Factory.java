package id.dana.data.globalnetwork.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceGnPaymentEntityData_Factory implements Factory<PreferenceGnPaymentEntityData> {
    private final Provider<GlobalNetworkPreference> globalNetworkPreferenceProvider;

    public PreferenceGnPaymentEntityData_Factory(Provider<GlobalNetworkPreference> provider) {
        this.globalNetworkPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceGnPaymentEntityData get() {
        return newInstance(this.globalNetworkPreferenceProvider.get());
    }

    public static PreferenceGnPaymentEntityData_Factory create(Provider<GlobalNetworkPreference> provider) {
        return new PreferenceGnPaymentEntityData_Factory(provider);
    }

    public static PreferenceGnPaymentEntityData newInstance(GlobalNetworkPreference globalNetworkPreference) {
        return new PreferenceGnPaymentEntityData(globalNetworkPreference);
    }
}

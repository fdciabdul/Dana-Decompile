package id.dana.data.globalnetwork.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceGnConfigEntityData_Factory implements Factory<PreferenceGnConfigEntityData> {
    private final Provider<GlobalNetworkPreference> globalNetworkPreferenceProvider;

    public PreferenceGnConfigEntityData_Factory(Provider<GlobalNetworkPreference> provider) {
        this.globalNetworkPreferenceProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceGnConfigEntityData get() {
        return newInstance(this.globalNetworkPreferenceProvider.get());
    }

    public static PreferenceGnConfigEntityData_Factory create(Provider<GlobalNetworkPreference> provider) {
        return new PreferenceGnConfigEntityData_Factory(provider);
    }

    public static PreferenceGnConfigEntityData newInstance(GlobalNetworkPreference globalNetworkPreference) {
        return new PreferenceGnConfigEntityData(globalNetworkPreference);
    }
}

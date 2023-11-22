package id.dana.data.promodiscovery.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPromoDiscoveryEntityData_Factory implements Factory<LocalPromoDiscoveryEntityData> {
    private final Provider<FourKingsDiscoveryPreferences> fourKingsDiscoveryPreferencesProvider;

    public LocalPromoDiscoveryEntityData_Factory(Provider<FourKingsDiscoveryPreferences> provider) {
        this.fourKingsDiscoveryPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalPromoDiscoveryEntityData get() {
        return newInstance(this.fourKingsDiscoveryPreferencesProvider.get());
    }

    public static LocalPromoDiscoveryEntityData_Factory create(Provider<FourKingsDiscoveryPreferences> provider) {
        return new LocalPromoDiscoveryEntityData_Factory(provider);
    }

    public static LocalPromoDiscoveryEntityData newInstance(FourKingsDiscoveryPreferences fourKingsDiscoveryPreferences) {
        return new LocalPromoDiscoveryEntityData(fourKingsDiscoveryPreferences);
    }
}

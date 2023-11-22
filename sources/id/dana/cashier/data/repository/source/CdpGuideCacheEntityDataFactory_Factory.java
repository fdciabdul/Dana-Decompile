package id.dana.cashier.data.repository.source;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CdpGuideCacheEntityDataFactory_Factory<T> implements Factory<CdpGuideCacheEntityDataFactory<T>> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public CdpGuideCacheEntityDataFactory_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CdpGuideCacheEntityDataFactory<T> get() {
        return newInstance(this.generalPreferencesProvider.get());
    }

    public static <T> CdpGuideCacheEntityDataFactory_Factory<T> create(Provider<GeneralPreferences> provider) {
        return new CdpGuideCacheEntityDataFactory_Factory<>(provider);
    }

    public static <T> CdpGuideCacheEntityDataFactory<T> newInstance(GeneralPreferences generalPreferences) {
        return new CdpGuideCacheEntityDataFactory<>(generalPreferences);
    }
}

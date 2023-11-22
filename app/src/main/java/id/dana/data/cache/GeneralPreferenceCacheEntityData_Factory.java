package id.dana.data.cache;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GeneralPreferenceCacheEntityData_Factory implements Factory<GeneralPreferenceCacheEntityData> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public GeneralPreferenceCacheEntityData_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GeneralPreferenceCacheEntityData get() {
        return newInstance(this.generalPreferencesProvider.get());
    }

    public static GeneralPreferenceCacheEntityData_Factory create(Provider<GeneralPreferences> provider) {
        return new GeneralPreferenceCacheEntityData_Factory(provider);
    }

    public static GeneralPreferenceCacheEntityData newInstance(GeneralPreferences generalPreferences) {
        return new GeneralPreferenceCacheEntityData(generalPreferences);
    }
}

package id.dana.data.synccontact.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferencesSyncContactEntityData_Factory implements Factory<PreferencesSyncContactEntityData> {
    private final Provider<SyncContactPreferences> syncContactPreferencesProvider;

    public PreferencesSyncContactEntityData_Factory(Provider<SyncContactPreferences> provider) {
        this.syncContactPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferencesSyncContactEntityData get() {
        return newInstance(this.syncContactPreferencesProvider.get());
    }

    public static PreferencesSyncContactEntityData_Factory create(Provider<SyncContactPreferences> provider) {
        return new PreferencesSyncContactEntityData_Factory(provider);
    }

    public static PreferencesSyncContactEntityData newInstance(SyncContactPreferences syncContactPreferences) {
        return new PreferencesSyncContactEntityData(syncContactPreferences);
    }
}

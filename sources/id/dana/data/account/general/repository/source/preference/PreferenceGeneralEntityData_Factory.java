package id.dana.data.account.general.repository.source.preference;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceGeneralEntityData_Factory implements Factory<PreferenceGeneralEntityData> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public PreferenceGeneralEntityData_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferenceGeneralEntityData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesProvider));
    }

    public static PreferenceGeneralEntityData_Factory create(Provider<GeneralPreferences> provider) {
        return new PreferenceGeneralEntityData_Factory(provider);
    }

    public static PreferenceGeneralEntityData newInstance(Lazy<GeneralPreferences> lazy) {
        return new PreferenceGeneralEntityData(lazy);
    }
}

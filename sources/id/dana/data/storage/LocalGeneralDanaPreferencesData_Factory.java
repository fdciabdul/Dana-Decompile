package id.dana.data.storage;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalGeneralDanaPreferencesData_Factory implements Factory<LocalGeneralDanaPreferencesData> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public LocalGeneralDanaPreferencesData_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalGeneralDanaPreferencesData get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesProvider));
    }

    public static LocalGeneralDanaPreferencesData_Factory create(Provider<GeneralPreferences> provider) {
        return new LocalGeneralDanaPreferencesData_Factory(provider);
    }

    public static LocalGeneralDanaPreferencesData newInstance(Lazy<GeneralPreferences> lazy) {
        return new LocalGeneralDanaPreferencesData(lazy);
    }
}

package id.dana.data.storage;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GeneralPreferencesDataFactory_Factory implements Factory<GeneralPreferencesDataFactory> {
    private final Provider<LocalGeneralDanaPreferencesData> localGeneralDanaPreferencesDataProvider;

    public GeneralPreferencesDataFactory_Factory(Provider<LocalGeneralDanaPreferencesData> provider) {
        this.localGeneralDanaPreferencesDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GeneralPreferencesDataFactory get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.localGeneralDanaPreferencesDataProvider));
    }

    public static GeneralPreferencesDataFactory_Factory create(Provider<LocalGeneralDanaPreferencesData> provider) {
        return new GeneralPreferencesDataFactory_Factory(provider);
    }

    public static GeneralPreferencesDataFactory newInstance(Lazy<LocalGeneralDanaPreferencesData> lazy) {
        return new GeneralPreferencesDataFactory(lazy);
    }
}

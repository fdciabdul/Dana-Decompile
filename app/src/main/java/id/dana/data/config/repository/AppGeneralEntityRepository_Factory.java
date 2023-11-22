package id.dana.data.config.repository;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AppGeneralEntityRepository_Factory implements Factory<AppGeneralEntityRepository> {
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;

    public AppGeneralEntityRepository_Factory(Provider<GeneralPreferencesDataFactory> provider) {
        this.generalPreferencesDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AppGeneralEntityRepository get() {
        return newInstance(this.generalPreferencesDataFactoryProvider.get());
    }

    public static AppGeneralEntityRepository_Factory create(Provider<GeneralPreferencesDataFactory> provider) {
        return new AppGeneralEntityRepository_Factory(provider);
    }

    public static AppGeneralEntityRepository newInstance(GeneralPreferencesDataFactory generalPreferencesDataFactory) {
        return new AppGeneralEntityRepository(generalPreferencesDataFactory);
    }
}

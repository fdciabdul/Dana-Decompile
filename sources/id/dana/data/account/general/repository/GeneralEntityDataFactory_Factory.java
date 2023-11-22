package id.dana.data.account.general.repository;

import dagger.internal.Factory;
import id.dana.data.account.general.repository.source.preference.PreferenceGeneralEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class GeneralEntityDataFactory_Factory implements Factory<GeneralEntityDataFactory> {
    private final Provider<PreferenceGeneralEntityData> preferenceGeneralEntityDataProvider;

    public GeneralEntityDataFactory_Factory(Provider<PreferenceGeneralEntityData> provider) {
        this.preferenceGeneralEntityDataProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GeneralEntityDataFactory get() {
        return newInstance(this.preferenceGeneralEntityDataProvider.get());
    }

    public static GeneralEntityDataFactory_Factory create(Provider<PreferenceGeneralEntityData> provider) {
        return new GeneralEntityDataFactory_Factory(provider);
    }

    public static GeneralEntityDataFactory newInstance(PreferenceGeneralEntityData preferenceGeneralEntityData) {
        return new GeneralEntityDataFactory(preferenceGeneralEntityData);
    }
}

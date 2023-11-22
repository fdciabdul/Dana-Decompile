package id.dana.data.profilemenu.repository.source;

import dagger.internal.Factory;
import id.dana.data.profilemenu.repository.source.local.DefaultSettingsEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SettingsEntityDataFactory_Factory implements Factory<SettingsEntityDataFactory> {
    private final Provider<DefaultSettingsEntityData> defaultSettingsEntityDataProvider;
    private final Provider<SplitSettingsEntityData> splitSettingsEntityDataProvider;

    public SettingsEntityDataFactory_Factory(Provider<DefaultSettingsEntityData> provider, Provider<SplitSettingsEntityData> provider2) {
        this.defaultSettingsEntityDataProvider = provider;
        this.splitSettingsEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SettingsEntityDataFactory get() {
        return newInstance(this.defaultSettingsEntityDataProvider.get(), this.splitSettingsEntityDataProvider.get());
    }

    public static SettingsEntityDataFactory_Factory create(Provider<DefaultSettingsEntityData> provider, Provider<SplitSettingsEntityData> provider2) {
        return new SettingsEntityDataFactory_Factory(provider, provider2);
    }

    public static SettingsEntityDataFactory newInstance(DefaultSettingsEntityData defaultSettingsEntityData, SplitSettingsEntityData splitSettingsEntityData) {
        return new SettingsEntityDataFactory(defaultSettingsEntityData, splitSettingsEntityData);
    }
}

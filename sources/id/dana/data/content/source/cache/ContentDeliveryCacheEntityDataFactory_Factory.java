package id.dana.data.content.source.cache;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContentDeliveryCacheEntityDataFactory_Factory implements Factory<ContentDeliveryCacheEntityDataFactory> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public ContentDeliveryCacheEntityDataFactory_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ContentDeliveryCacheEntityDataFactory get() {
        return newInstance(this.generalPreferencesProvider.get());
    }

    public static ContentDeliveryCacheEntityDataFactory_Factory create(Provider<GeneralPreferences> provider) {
        return new ContentDeliveryCacheEntityDataFactory_Factory(provider);
    }

    public static ContentDeliveryCacheEntityDataFactory newInstance(GeneralPreferences generalPreferences) {
        return new ContentDeliveryCacheEntityDataFactory(generalPreferences);
    }
}

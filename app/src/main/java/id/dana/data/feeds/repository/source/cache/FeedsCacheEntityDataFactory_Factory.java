package id.dana.data.feeds.repository.source.cache;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsCacheEntityDataFactory_Factory implements Factory<FeedsCacheEntityDataFactory> {
    private final Provider<GeneralPreferences> generalPreferencesProvider;

    public FeedsCacheEntityDataFactory_Factory(Provider<GeneralPreferences> provider) {
        this.generalPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FeedsCacheEntityDataFactory get() {
        return newInstance(this.generalPreferencesProvider.get());
    }

    public static FeedsCacheEntityDataFactory_Factory create(Provider<GeneralPreferences> provider) {
        return new FeedsCacheEntityDataFactory_Factory(provider);
    }

    public static FeedsCacheEntityDataFactory newInstance(GeneralPreferences generalPreferences) {
        return new FeedsCacheEntityDataFactory(generalPreferences);
    }
}

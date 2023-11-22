package id.dana.data.exploredana.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExploreDanaPreferencesDataFactory_Factory implements Factory<ExploreDanaPreferencesDataFactory> {
    private final Provider<ExploreDanaPreferences> exploreDanaPreferencesProvider;

    public ExploreDanaPreferencesDataFactory_Factory(Provider<ExploreDanaPreferences> provider) {
        this.exploreDanaPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ExploreDanaPreferencesDataFactory get() {
        return newInstance(this.exploreDanaPreferencesProvider.get());
    }

    public static ExploreDanaPreferencesDataFactory_Factory create(Provider<ExploreDanaPreferences> provider) {
        return new ExploreDanaPreferencesDataFactory_Factory(provider);
    }

    public static ExploreDanaPreferencesDataFactory newInstance(ExploreDanaPreferences exploreDanaPreferences) {
        return new ExploreDanaPreferencesDataFactory(exploreDanaPreferences);
    }
}

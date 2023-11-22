package id.dana.data.deeplink.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferencesGenerateLinkEntityData_Factory implements Factory<PreferencesGenerateLinkEntityData> {
    private final Provider<DeepLinkPreferences> deepLinkPreferencesProvider;

    public PreferencesGenerateLinkEntityData_Factory(Provider<DeepLinkPreferences> provider) {
        this.deepLinkPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PreferencesGenerateLinkEntityData get() {
        return newInstance(this.deepLinkPreferencesProvider.get());
    }

    public static PreferencesGenerateLinkEntityData_Factory create(Provider<DeepLinkPreferences> provider) {
        return new PreferencesGenerateLinkEntityData_Factory(provider);
    }

    public static PreferencesGenerateLinkEntityData newInstance(DeepLinkPreferences deepLinkPreferences) {
        return new PreferencesGenerateLinkEntityData(deepLinkPreferences);
    }
}

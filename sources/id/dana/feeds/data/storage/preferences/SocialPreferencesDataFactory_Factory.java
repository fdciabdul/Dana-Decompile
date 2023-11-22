package id.dana.feeds.data.storage.preferences;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SocialPreferencesDataFactory_Factory implements Factory<SocialPreferencesDataFactory> {
    private final Provider<SocialPreferences> PlaceComponentResult;

    private SocialPreferencesDataFactory_Factory(Provider<SocialPreferences> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SocialPreferencesDataFactory_Factory PlaceComponentResult(Provider<SocialPreferences> provider) {
        return new SocialPreferencesDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SocialPreferencesDataFactory(this.PlaceComponentResult.get());
    }
}

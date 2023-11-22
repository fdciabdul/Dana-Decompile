package id.dana.data.banner.repository.source;

import dagger.internal.Factory;
import id.dana.data.storage.GeneralPreferences;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BannerCacheEntityDataFactory_Factory implements Factory<BannerCacheEntityDataFactory> {
    private final Provider<GeneralPreferences> getAuthRequestContext;

    private BannerCacheEntityDataFactory_Factory(Provider<GeneralPreferences> provider) {
        this.getAuthRequestContext = provider;
    }

    public static BannerCacheEntityDataFactory_Factory getAuthRequestContext(Provider<GeneralPreferences> provider) {
        return new BannerCacheEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BannerCacheEntityDataFactory(this.getAuthRequestContext.get());
    }
}

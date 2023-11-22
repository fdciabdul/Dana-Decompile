package id.dana.explore.data.globalsearch.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchCacheEntityDataFactory_Factory implements Factory<GlobalSearchCacheEntityDataFactory> {
    private final Provider<GlobalSearchPreferenceCacheEntityData> BuiltInFictitiousFunctionClassFactory;

    private GlobalSearchCacheEntityDataFactory_Factory(Provider<GlobalSearchPreferenceCacheEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GlobalSearchCacheEntityDataFactory_Factory PlaceComponentResult(Provider<GlobalSearchPreferenceCacheEntityData> provider) {
        return new GlobalSearchCacheEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchCacheEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

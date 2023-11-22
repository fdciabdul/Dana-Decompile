package id.dana.explore.data.globalsearch.source;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchPreferenceCacheEntityData_Factory implements Factory<GlobalSearchPreferenceCacheEntityData> {
    private final Provider<GlobalSearchPreference> PlaceComponentResult;

    private GlobalSearchPreferenceCacheEntityData_Factory(Provider<GlobalSearchPreference> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GlobalSearchPreferenceCacheEntityData_Factory getAuthRequestContext(Provider<GlobalSearchPreference> provider) {
        return new GlobalSearchPreferenceCacheEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchPreferenceCacheEntityData(this.PlaceComponentResult.get());
    }
}

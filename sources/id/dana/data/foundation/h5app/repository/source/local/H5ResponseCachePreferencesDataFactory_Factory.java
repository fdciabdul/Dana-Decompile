package id.dana.data.foundation.h5app.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class H5ResponseCachePreferencesDataFactory_Factory implements Factory<H5ResponseCachePreferencesDataFactory> {
    private final Provider<LocalH5ResponseCachePreferencesData> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new H5ResponseCachePreferencesDataFactory(this.PlaceComponentResult.get());
    }
}

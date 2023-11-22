package id.dana.data.foundation.h5app.repository;

import dagger.internal.Factory;
import id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class H5ResponseH5ResponseCacheEntityRepository_Factory implements Factory<H5ResponseH5ResponseCacheEntityRepository> {
    private final Provider<H5ResponseCachePreferencesDataFactory> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new H5ResponseH5ResponseCacheEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}

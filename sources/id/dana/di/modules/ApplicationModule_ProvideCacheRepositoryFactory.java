package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.foundation.h5app.repository.H5ResponseH5ResponseCacheEntityRepository;
import id.dana.domain.foundation.h5app.repository.H5ResponseCacheRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ApplicationModule_ProvideCacheRepositoryFactory implements Factory<H5ResponseCacheRepository> {
    private final Provider<H5ResponseH5ResponseCacheEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (H5ResponseCacheRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}

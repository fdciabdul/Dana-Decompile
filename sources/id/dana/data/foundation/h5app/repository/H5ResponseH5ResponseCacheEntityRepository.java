package id.dana.data.foundation.h5app.repository;

import id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferencesDataFactory;
import id.dana.domain.foundation.h5app.model.H5CacheHttpResponse;
import id.dana.domain.foundation.h5app.repository.H5ResponseCacheRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class H5ResponseH5ResponseCacheEntityRepository implements H5ResponseCacheRepository {
    private final H5ResponseCachePreferencesDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public H5ResponseH5ResponseCacheEntityRepository(H5ResponseCachePreferencesDataFactory h5ResponseCachePreferencesDataFactory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = h5ResponseCachePreferencesDataFactory;
    }

    @Override // id.dana.domain.foundation.h5app.repository.H5ResponseCacheRepository
    public H5CacheHttpResponse getCache(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getAuthRequestContext(str);
    }

    @Override // id.dana.domain.foundation.h5app.repository.H5ResponseCacheRepository
    public Boolean saveCache(String str, H5CacheHttpResponse h5CacheHttpResponse) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.PlaceComponentResult(str, h5CacheHttpResponse);
    }
}

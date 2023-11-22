package id.dana.data.foundation.h5app.repository.source.local;

import id.dana.domain.foundation.h5app.model.H5CacheHttpResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes8.dex */
public class LocalH5ResponseCachePreferencesData implements H5ResponseCachePreferencesData {
    private final H5ResponseCachePreferences MyBillsEntityDataFactory;

    @Inject
    public LocalH5ResponseCachePreferencesData(H5ResponseCachePreferences h5ResponseCachePreferences) {
        this.MyBillsEntityDataFactory = h5ResponseCachePreferences;
    }

    @Override // id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferencesData
    public final Boolean PlaceComponentResult(String str, H5CacheHttpResponse h5CacheHttpResponse) {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(str, h5CacheHttpResponse);
    }

    @Override // id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferencesData
    public final H5CacheHttpResponse getAuthRequestContext(String str) {
        return this.MyBillsEntityDataFactory.PlaceComponentResult(str);
    }
}

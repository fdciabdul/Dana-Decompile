package id.dana.data.foundation.h5app.repository.source.local;

import id.dana.domain.foundation.h5app.model.H5CacheHttpResponse;

/* loaded from: classes8.dex */
public interface H5ResponseCachePreferencesData {
    Boolean PlaceComponentResult(String str, H5CacheHttpResponse h5CacheHttpResponse);

    H5CacheHttpResponse getAuthRequestContext(String str);
}

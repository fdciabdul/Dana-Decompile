package id.dana.domain.foundation.h5app.repository;

import id.dana.domain.foundation.h5app.model.H5CacheHttpResponse;

/* loaded from: classes2.dex */
public interface H5ResponseCacheRepository {
    H5CacheHttpResponse getCache(String str);

    Boolean saveCache(String str, H5CacheHttpResponse h5CacheHttpResponse);
}

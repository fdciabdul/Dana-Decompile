package com.alibaba.griver.base.resource.cache;

/* loaded from: classes3.dex */
class GriverDiskCache {

    /* renamed from: a  reason: collision with root package name */
    private String f6359a;
    private long b;

    public GriverDiskCache(String str, long j) {
        this.f6359a = str;
        this.b = j;
        clearCache();
    }

    public boolean containsObjectForKey(String str) {
        return GriverCacheStorage.getCacheDaoByKey(this.f6359a, str) != null;
    }

    public String objectForKey(String str) {
        GriverCacheDao cacheDaoByKey = GriverCacheStorage.getCacheDaoByKey(this.f6359a, str);
        if (isExpired(cacheDaoByKey)) {
            return null;
        }
        return cacheDaoByKey.getCacheValue();
    }

    public GriverCacheDao daoForKey(String str) {
        GriverCacheDao cacheDaoByKey = GriverCacheStorage.getCacheDaoByKey(this.f6359a, str);
        if (isExpired(cacheDaoByKey)) {
            return null;
        }
        return cacheDaoByKey;
    }

    public boolean setObject(String str, String str2, long j) {
        return GriverCacheStorage.insertOrUpdateCache(this.f6359a, str, CacheTypeDef.CACHE_TYPE_STRING, str2, Long.valueOf(j), null);
    }

    public boolean removeObjectForKey(String str) {
        return GriverCacheStorage.removeByKey(this.f6359a, str);
    }

    public boolean removeAllObjects() {
        return GriverCacheStorage.removeAll(this.f6359a);
    }

    public boolean isExpired(GriverCacheDao griverCacheDao) {
        if (griverCacheDao == null) {
            return true;
        }
        boolean z = griverCacheDao.getExpiredTimeStamp().longValue() >= 0 ? System.currentTimeMillis() - griverCacheDao.getExpiredTimeStamp().longValue() > 0 : false;
        if (z) {
            removeObjectForKey(griverCacheDao.getCacheKey());
        }
        return z;
    }

    public void clearExpiredCache() {
        GriverCacheStorage.removeExpiredCache(this.f6359a);
    }

    public void clearCache() {
        clearExpiredCache();
        while (GriverCacheStorage.getCacheCount(this.f6359a) > this.b) {
            GriverCacheStorage.removeOldestCache(this.f6359a);
        }
    }
}

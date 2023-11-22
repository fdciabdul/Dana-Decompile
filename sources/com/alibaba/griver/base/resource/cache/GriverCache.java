package com.alibaba.griver.base.resource.cache;

import androidx.collection.LruCache;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class GriverCache {

    /* renamed from: a  reason: collision with root package name */
    private String f6354a;
    private int b;
    private boolean c;
    private LruCache<String, MemoryCacheBean> d;
    private GriverDiskCache e;

    public GriverCache(String str, int i, long j, boolean z) {
        this.f6354a = str;
        this.b = i;
        this.c = z;
        if (z) {
            this.d = new LruCache<>(i);
        }
        this.e = new GriverDiskCache(str, j);
    }

    public boolean containsObjectForKey(String str) {
        LruCache<String, MemoryCacheBean> lruCache;
        synchronized (this) {
            if (this.c && (lruCache = this.d) != null) {
                if (lruCache.get(str) != null && this.d.get(str).getExpiredTime() > System.currentTimeMillis()) {
                    return true;
                }
            }
            GriverDiskCache griverDiskCache = this.e;
            if (griverDiskCache != null) {
                return griverDiskCache.containsObjectForKey(str);
            }
            return false;
        }
    }

    public String objectForKey(String str) {
        LruCache<String, MemoryCacheBean> lruCache;
        LruCache<String, MemoryCacheBean> lruCache2;
        MemoryCacheBean memoryCacheBean;
        synchronized (this) {
            if (this.c && (lruCache2 = this.d) != null && (memoryCacheBean = lruCache2.get(str)) != null && memoryCacheBean.getExpiredTime() > System.currentTimeMillis()) {
                StringBuilder sb = new StringBuilder();
                sb.append("get cache from memory name = ");
                sb.append(this.f6354a);
                sb.append(" key = ");
                sb.append(str);
                GriverLogger.d("GriverCache", sb.toString());
                return memoryCacheBean.getValue();
            } else if (this.e != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get cache from disk name = ");
                sb2.append(this.f6354a);
                sb2.append(" key = ");
                sb2.append(str);
                GriverLogger.d("GriverCache", sb2.toString());
                GriverCacheDao daoForKey = this.e.daoForKey(str);
                if (daoForKey == null) {
                    return null;
                }
                if (this.c && (lruCache = this.d) != null) {
                    lruCache.put(str, new MemoryCacheBean(daoForKey.getCacheValue(), daoForKey.getExpiredTimeStamp().longValue()));
                }
                return daoForKey.getCacheValue();
            } else {
                return null;
            }
        }
    }

    public boolean setObject(String str, String str2, long j) {
        LruCache<String, MemoryCacheBean> lruCache;
        synchronized (this) {
            if (this.c && (lruCache = this.d) != null) {
                lruCache.put(str, new MemoryCacheBean(str2, System.currentTimeMillis() + j));
            }
            GriverDiskCache griverDiskCache = this.e;
            if (griverDiskCache != null) {
                return griverDiskCache.setObject(str, str2, j);
            }
            return false;
        }
    }

    public boolean removeObjectForKey(String str) {
        LruCache<String, MemoryCacheBean> lruCache;
        synchronized (this) {
            if (this.c && (lruCache = this.d) != null) {
                lruCache.remove(str);
            }
            GriverDiskCache griverDiskCache = this.e;
            if (griverDiskCache != null) {
                return griverDiskCache.removeObjectForKey(str);
            }
            return false;
        }
    }

    public boolean removeAllObjects() {
        LruCache<String, MemoryCacheBean> lruCache;
        synchronized (this) {
            if (this.c && (lruCache = this.d) != null) {
                lruCache.evictAll();
            }
            GriverDiskCache griverDiskCache = this.e;
            if (griverDiskCache != null) {
                return griverDiskCache.removeAllObjects();
            }
            return false;
        }
    }
}

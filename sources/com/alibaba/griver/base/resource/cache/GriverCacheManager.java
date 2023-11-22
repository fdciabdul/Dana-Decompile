package com.alibaba.griver.base.resource.cache;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class GriverCacheManager {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, GriverCache> f6357a = new ConcurrentHashMap<>();
    public static volatile GriverCacheManager instance;
    private int b = 100;
    private int c = 100;
    private boolean d = false;

    public static GriverCacheManager getInstance() {
        if (instance == null) {
            synchronized (GriverCacheManager.class) {
                if (instance == null) {
                    instance = new GriverCacheManager();
                }
            }
        }
        return instance;
    }

    public GriverCache getCache(String str) {
        GriverCache griverCache;
        synchronized (this) {
            griverCache = f6357a.get(str);
            if (griverCache == null) {
                griverCache = new GriverCache(str, this.b, this.c, this.d);
                f6357a.put(str, griverCache);
            }
        }
        return griverCache;
    }
}

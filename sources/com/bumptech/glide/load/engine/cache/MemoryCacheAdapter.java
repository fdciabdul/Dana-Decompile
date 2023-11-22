package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

/* loaded from: classes7.dex */
public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener PlaceComponentResult;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final long BuiltInFictitiousFunctionClassFactory() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final Resource<?> BuiltInFictitiousFunctionClassFactory(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final void MyBillsEntityDataFactory() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final void PlaceComponentResult(int i) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final long getAuthRequestContext() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final Resource<?> MyBillsEntityDataFactory(Key key, Resource<?> resource) {
        if (resource != null) {
            this.PlaceComponentResult.PlaceComponentResult(resource);
            return null;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final void BuiltInFictitiousFunctionClassFactory(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.PlaceComponentResult = resourceRemovedListener;
    }
}

package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

/* loaded from: classes3.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.util.LruCache
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(Resource<?> resource) {
        Resource<?> resource2 = resource;
        if (resource2 == null) {
            return super.BuiltInFictitiousFunctionClassFactory((LruResourceCache) null);
        }
        return resource2.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final /* synthetic */ Resource BuiltInFictitiousFunctionClassFactory(Key key) {
        return (Resource) super.KClassImpl$Data$declaredNonStaticMembers$2(key);
    }

    @Override // com.bumptech.glide.util.LruCache
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Key key, Resource<?> resource) {
        Resource<?> resource2 = resource;
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.MyBillsEntityDataFactory;
        if (resourceRemovedListener == null || resource2 == null) {
            return;
        }
        resourceRemovedListener.PlaceComponentResult(resource2);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final /* synthetic */ Resource MyBillsEntityDataFactory(Key key, Resource resource) {
        return (Resource) super.getAuthRequestContext(key, resource);
    }

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final void BuiltInFictitiousFunctionClassFactory(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.MyBillsEntityDataFactory = resourceRemovedListener;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public final void PlaceComponentResult(int i) {
        if (i >= 40) {
            MyBillsEntityDataFactory();
        } else if (i >= 20 || i == 15) {
            MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory() / 2);
        }
    }
}

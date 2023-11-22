package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
public class DiskCacheAdapter implements DiskCache {
    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void MyBillsEntityDataFactory(Key key, DiskCache.Writer writer) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File getAuthRequestContext(Key key) {
        return null;
    }

    /* loaded from: classes7.dex */
    public static final class Factory implements DiskCache.Factory {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public final DiskCache BuiltInFictitiousFunctionClassFactory() {
            return new DiskCacheAdapter();
        }
    }
}

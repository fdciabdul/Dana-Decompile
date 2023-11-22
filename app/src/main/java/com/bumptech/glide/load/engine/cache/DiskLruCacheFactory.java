package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final long BuiltInFictitiousFunctionClassFactory = 262144000;
    private final CacheDirectoryGetter PlaceComponentResult;

    /* loaded from: classes3.dex */
    public interface CacheDirectoryGetter {
        File MyBillsEntityDataFactory();
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements CacheDirectoryGetter {
        final /* synthetic */ String PlaceComponentResult;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public final File MyBillsEntityDataFactory() {
            return new File(this.PlaceComponentResult);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements CacheDirectoryGetter {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public final File MyBillsEntityDataFactory() {
            return new File(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter) {
        this.PlaceComponentResult = cacheDirectoryGetter;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public final DiskCache BuiltInFictitiousFunctionClassFactory() {
        File MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == null) {
            return null;
        }
        if (MyBillsEntityDataFactory.isDirectory() || MyBillsEntityDataFactory.mkdirs()) {
            return DiskLruCacheWrapper.PlaceComponentResult(MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
        return null;
    }
}

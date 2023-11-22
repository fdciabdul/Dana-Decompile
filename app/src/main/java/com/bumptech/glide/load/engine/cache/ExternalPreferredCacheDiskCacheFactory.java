package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes7.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Context MyBillsEntityDataFactory;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public final File MyBillsEntityDataFactory() {
            File externalCacheDir;
            File cacheDir = this.MyBillsEntityDataFactory.getCacheDir();
            if (cacheDir == null) {
                cacheDir = null;
            } else if (this.BuiltInFictitiousFunctionClassFactory != null) {
                cacheDir = new File(cacheDir, this.BuiltInFictitiousFunctionClassFactory);
            }
            return ((cacheDir == null || !cacheDir.exists()) && (externalCacheDir = this.MyBillsEntityDataFactory.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.BuiltInFictitiousFunctionClassFactory != null ? new File(externalCacheDir, this.BuiltInFictitiousFunctionClassFactory) : externalCacheDir : cacheDir;
        }
    }
}

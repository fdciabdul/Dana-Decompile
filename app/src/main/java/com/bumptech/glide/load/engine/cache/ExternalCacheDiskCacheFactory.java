package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* loaded from: classes7.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Context getAuthRequestContext;

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public final File MyBillsEntityDataFactory() {
            File externalCacheDir = this.getAuthRequestContext.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2 != null ? new File(externalCacheDir, this.KClassImpl$Data$declaredNonStaticMembers$2) : externalCacheDir;
        }
    }
}

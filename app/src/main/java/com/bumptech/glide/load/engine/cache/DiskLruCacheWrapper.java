package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private DiskLruCache KClassImpl$Data$declaredNonStaticMembers$2;
    private final File MyBillsEntityDataFactory;
    private final long getAuthRequestContext;
    private final DiskCacheWriteLocker PlaceComponentResult = new DiskCacheWriteLocker();
    private final SafeKeyGenerator BuiltInFictitiousFunctionClassFactory = new SafeKeyGenerator();

    public static DiskCache PlaceComponentResult(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    private DiskLruCacheWrapper(File file, long j) {
        this.MyBillsEntityDataFactory = file;
        this.getAuthRequestContext = j;
    }

    private DiskLruCache KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        DiskLruCache diskLruCache;
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = DiskLruCache.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
            }
            diskLruCache = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return diskLruCache;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final File getAuthRequestContext(Key key) {
        String MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Get: Obtained: ");
            sb.append(MyBillsEntityDataFactory);
            sb.append(" for for Key: ");
            sb.append(key);
            InstrumentInjector.log_v("DiskLruCacheWrapper", sb.toString());
        }
        try {
            DiskLruCache.Value MyBillsEntityDataFactory2 = KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(MyBillsEntityDataFactory);
            if (MyBillsEntityDataFactory2 != null) {
                return MyBillsEntityDataFactory2.PlaceComponentResult[0];
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                InstrumentInjector.log_w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public final void MyBillsEntityDataFactory(Key key, DiskCache.Writer writer) {
        DiskCacheWriteLocker.WriteLock writeLock;
        boolean z;
        String MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(key);
        DiskCacheWriteLocker diskCacheWriteLocker = this.PlaceComponentResult;
        synchronized (diskCacheWriteLocker) {
            writeLock = diskCacheWriteLocker.PlaceComponentResult.get(MyBillsEntityDataFactory);
            if (writeLock == null) {
                writeLock = diskCacheWriteLocker.getAuthRequestContext.MyBillsEntityDataFactory();
                diskCacheWriteLocker.PlaceComponentResult.put(MyBillsEntityDataFactory, writeLock);
            }
            writeLock.MyBillsEntityDataFactory++;
        }
        writeLock.PlaceComponentResult.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Put: Obtained: ");
                sb.append(MyBillsEntityDataFactory);
                sb.append(" for for Key: ");
                sb.append(key);
                InstrumentInjector.log_v("DiskLruCacheWrapper", sb.toString());
            }
            try {
                DiskLruCache KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(MyBillsEntityDataFactory) == null) {
                    DiskLruCache.Editor authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(MyBillsEntityDataFactory);
                    if (authRequestContext == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Had two simultaneous puts for: ");
                        sb2.append(MyBillsEntityDataFactory);
                        throw new IllegalStateException(sb2.toString());
                    }
                    try {
                        if (writer.BuiltInFictitiousFunctionClassFactory(authRequestContext.PlaceComponentResult())) {
                            DiskLruCache.MyBillsEntityDataFactory(DiskLruCache.this, authRequestContext, true);
                            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                        }
                        if (!z) {
                            try {
                                DiskLruCache.MyBillsEntityDataFactory(DiskLruCache.this, authRequestContext, false);
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) {
                            try {
                                DiskLruCache.MyBillsEntityDataFactory(DiskLruCache.this, authRequestContext, false);
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    InstrumentInjector.log_w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.PlaceComponentResult.getAuthRequestContext(MyBillsEntityDataFactory);
        }
    }
}

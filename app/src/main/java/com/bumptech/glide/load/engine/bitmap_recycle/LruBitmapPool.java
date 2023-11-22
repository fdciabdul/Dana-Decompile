package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config getAuthRequestContext = Bitmap.Config.ARGB_8888;
    private final Set<Bitmap.Config> BuiltInFictitiousFunctionClassFactory;
    private final BitmapTracker GetContactSyncConfig;
    private long KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getErrorConfigVersion;
    private final LruPoolStrategy lookAheadTest;
    private long moveToNextValue;
    private final long scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface BitmapTracker {
        void MyBillsEntityDataFactory(Bitmap bitmap);

        void PlaceComponentResult(Bitmap bitmap);
    }

    private LruBitmapPool(long j, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.scheduleImpl = j;
        this.moveToNextValue = j;
        this.lookAheadTest = lruPoolStrategy;
        this.BuiltInFictitiousFunctionClassFactory = set;
        this.GetContactSyncConfig = new NullBitmapTracker();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final void PlaceComponentResult(Bitmap bitmap) {
        synchronized (this) {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.lookAheadTest.PlaceComponentResult(bitmap) <= this.moveToNextValue && this.BuiltInFictitiousFunctionClassFactory.contains(bitmap.getConfig())) {
                int PlaceComponentResult = this.lookAheadTest.PlaceComponentResult(bitmap);
                this.lookAheadTest.MyBillsEntityDataFactory(bitmap);
                this.GetContactSyncConfig.MyBillsEntityDataFactory(bitmap);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
                this.KClassImpl$Data$declaredNonStaticMembers$2 += PlaceComponentResult;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Put bitmap in pool=");
                    sb.append(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(bitmap));
                    InstrumentInjector.log_v("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
                KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue);
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Reject bitmap from pool, bitmap: ");
                sb2.append(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(bitmap));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.BuiltInFictitiousFunctionClassFactory.contains(bitmap.getConfig()));
                InstrumentInjector.log_v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, Bitmap.Config config) {
        Bitmap PlaceComponentResult = PlaceComponentResult(i, i2, config);
        if (PlaceComponentResult != null) {
            PlaceComponentResult.eraseColor(0);
            return PlaceComponentResult;
        }
        if (config == null) {
            config = getAuthRequestContext;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final Bitmap MyBillsEntityDataFactory(int i, int i2, Bitmap.Config config) {
        Bitmap PlaceComponentResult = PlaceComponentResult(i, i2, config);
        if (PlaceComponentResult == null) {
            if (config == null) {
                config = getAuthRequestContext;
            }
            return Bitmap.createBitmap(i, i2, config);
        }
        return PlaceComponentResult;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final void MyBillsEntityDataFactory() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            InstrumentInjector.log_d("LruBitmapPool", "clearMemory");
        }
        KClassImpl$Data$declaredNonStaticMembers$2(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public final void PlaceComponentResult(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i);
            InstrumentInjector.log_d("LruBitmapPool", sb.toString());
        }
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                InstrumentInjector.log_d("LruBitmapPool", "clearMemory");
            }
            KClassImpl$Data$declaredNonStaticMembers$2(0L);
        } else if (i >= 20 || i == 15) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue / 2);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        synchronized (this) {
            while (this.KClassImpl$Data$declaredNonStaticMembers$2 > j) {
                Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        InstrumentInjector.log_w("LruBitmapPool", "Size mismatch, resetting");
                        KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
                    return;
                }
                this.GetContactSyncConfig.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 -= this.lookAheadTest.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                this.MyBillsEntityDataFactory++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    sb.append(this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2));
                    InstrumentInjector.log_d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
                KClassImpl$Data$declaredNonStaticMembers$2.recycle();
            }
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.PlaceComponentResult);
        sb.append(", misses=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", puts=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", evictions=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", currentSize=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", maxSize=");
        sb.append(this.moveToNextValue);
        sb.append("\nStrategy=");
        sb.append(this.lookAheadTest);
        InstrumentInjector.log_v("LruBitmapPool", sb.toString());
    }

    /* loaded from: classes7.dex */
    static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> getAuthRequestContext = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public final void MyBillsEntityDataFactory(Bitmap bitmap) {
            if (this.getAuthRequestContext.contains(bitmap)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't add already added bitmap: ");
                sb.append(bitmap);
                sb.append(" [");
                sb.append(bitmap.getWidth());
                sb.append("x");
                sb.append(bitmap.getHeight());
                sb.append("]");
                throw new IllegalStateException(sb.toString());
            }
            this.getAuthRequestContext.add(bitmap);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public final void PlaceComponentResult(Bitmap bitmap) {
            if (!this.getAuthRequestContext.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.getAuthRequestContext.remove(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    static final class NullBitmapTracker implements BitmapTracker {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public final void MyBillsEntityDataFactory(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public final void PlaceComponentResult(Bitmap bitmap) {
        }

        NullBitmapTracker() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LruBitmapPool(long r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto Lc
            com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy r0 = new com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy
            r0.<init>()
            goto L11
        Lc:
            com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy r0 = new com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy
            r0.<init>()
        L11:
            java.util.HashSet r2 = new java.util.HashSet
            android.graphics.Bitmap$Config[] r3 = android.graphics.Bitmap.Config.values()
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r1) goto L26
            r1 = 0
            r2.add(r1)
        L26:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r1 < r3) goto L31
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            r2.remove(r1)
        L31:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r2)
            r4.<init>(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.<init>(long):void");
    }

    private Bitmap PlaceComponentResult(int i, int i2, Bitmap.Config config) {
        Bitmap authRequestContext;
        synchronized (this) {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot create a mutable Bitmap with config: ");
                sb.append(config);
                sb.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                throw new IllegalArgumentException(sb.toString());
            }
            authRequestContext = this.lookAheadTest.getAuthRequestContext(i, i2, config != null ? config : getAuthRequestContext);
            if (authRequestContext == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Missing bitmap=");
                    sb2.append(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(i, i2, config));
                    InstrumentInjector.log_d("LruBitmapPool", sb2.toString());
                }
                this.getErrorConfigVersion++;
            } else {
                this.PlaceComponentResult++;
                this.KClassImpl$Data$declaredNonStaticMembers$2 -= this.lookAheadTest.PlaceComponentResult(authRequestContext);
                this.GetContactSyncConfig.PlaceComponentResult(authRequestContext);
                authRequestContext.setHasAlpha(true);
                if (Build.VERSION.SDK_INT >= 19) {
                    authRequestContext.setPremultiplied(true);
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Get bitmap=");
                sb3.append(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(i, i2, config));
                InstrumentInjector.log_v("LruBitmapPool", sb3.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        return authRequestContext;
    }
}

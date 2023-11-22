package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import com.fullstory.instrumentation.InstrumentInjector;
import java.security.MessageDigest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
final class BitmapPreFillRunner implements Runnable {
    private static final Clock BuiltInFictitiousFunctionClassFactory = new Clock();
    static final long KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.SECONDS.toMillis(1);
    private long MyBillsEntityDataFactory;
    private final Set<PreFillType> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Clock PlaceComponentResult;
    private final BitmapPool getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private final PreFillQueue lookAheadTest;
    private final Handler moveToNextValue;
    private final MemoryCache scheduleImpl;

    private boolean BuiltInFictitiousFunctionClassFactory() {
        Bitmap createBitmap;
        long MyBillsEntityDataFactory = Clock.MyBillsEntityDataFactory();
        while (true) {
            if (this.lookAheadTest.PlaceComponentResult() || PlaceComponentResult(MyBillsEntityDataFactory)) {
                break;
            }
            PreFillQueue preFillQueue = this.lookAheadTest;
            PreFillType preFillType = preFillQueue.MyBillsEntityDataFactory.get(preFillQueue.PlaceComponentResult);
            Integer num = preFillQueue.BuiltInFictitiousFunctionClassFactory.get(preFillType);
            if (num.intValue() == 1) {
                preFillQueue.BuiltInFictitiousFunctionClassFactory.remove(preFillType);
                preFillQueue.MyBillsEntityDataFactory.remove(preFillQueue.PlaceComponentResult);
            } else {
                preFillQueue.BuiltInFictitiousFunctionClassFactory.put(preFillType, Integer.valueOf(num.intValue() - 1));
            }
            preFillQueue.getAuthRequestContext--;
            preFillQueue.PlaceComponentResult = preFillQueue.MyBillsEntityDataFactory.isEmpty() ? 0 : (preFillQueue.PlaceComponentResult + 1) % preFillQueue.MyBillsEntityDataFactory.size();
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(preFillType)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(preFillType);
                createBitmap = this.getAuthRequestContext.MyBillsEntityDataFactory(preFillType.getAuthRequestContext, preFillType.PlaceComponentResult, preFillType.BuiltInFictitiousFunctionClassFactory);
            } else {
                createBitmap = Bitmap.createBitmap(preFillType.getAuthRequestContext, preFillType.PlaceComponentResult, preFillType.BuiltInFictitiousFunctionClassFactory);
            }
            int authRequestContext = Util.getAuthRequestContext(createBitmap);
            if (this.scheduleImpl.BuiltInFictitiousFunctionClassFactory() - this.scheduleImpl.getAuthRequestContext() >= authRequestContext) {
                this.scheduleImpl.MyBillsEntityDataFactory(new UniqueKey(), BitmapResource.MyBillsEntityDataFactory(createBitmap, this.getAuthRequestContext));
            } else {
                this.getAuthRequestContext.PlaceComponentResult(createBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("allocated [");
                sb.append(preFillType.getAuthRequestContext);
                sb.append("x");
                sb.append(preFillType.PlaceComponentResult);
                sb.append("] ");
                sb.append(preFillType.BuiltInFictitiousFunctionClassFactory);
                sb.append(" size: ");
                sb.append(authRequestContext);
                InstrumentInjector.log_d("PreFillRunner", sb.toString());
            }
        }
        return (this.getErrorConfigVersion || this.lookAheadTest.PlaceComponentResult()) ? false : true;
    }

    private boolean PlaceComponentResult(long j) {
        return Clock.MyBillsEntityDataFactory() - j >= 32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (BuiltInFictitiousFunctionClassFactory()) {
            Handler handler = this.moveToNextValue;
            long j = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = Math.min(4 * j, KClassImpl$Data$declaredNonStaticMembers$2);
            handler.postDelayed(this, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class UniqueKey implements Key {
        UniqueKey() {
        }

        @Override // com.bumptech.glide.load.Key
        public final void getAuthRequestContext(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class Clock {
        Clock() {
        }

        static long MyBillsEntityDataFactory() {
            return SystemClock.currentThreadTimeMillis();
        }
    }
}

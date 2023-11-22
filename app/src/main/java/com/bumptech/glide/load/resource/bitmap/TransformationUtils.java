package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class TransformationUtils {
    private static final Set<String> BuiltInFictitiousFunctionClassFactory;
    private static final Paint KClassImpl$Data$declaredNonStaticMembers$2 = new Paint(6);
    private static final Paint MyBillsEntityDataFactory = new Paint(7);
    private static final Paint PlaceComponentResult;
    private static final Lock getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface DrawRoundedCornerFn {
        void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, Paint paint, RectF rectF);
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean PlaceComponentResult(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        BuiltInFictitiousFunctionClassFactory = hashSet;
        getAuthRequestContext = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new NoLock();
        Paint paint = new Paint(7);
        PlaceComponentResult = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    public static Lock MyBillsEntityDataFactory() {
        return getAuthRequestContext;
    }

    public static Bitmap MyBillsEntityDataFactory(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            f = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        KClassImpl$Data$declaredNonStaticMembers$22.setHasAlpha(bitmap.hasAlpha());
        getAuthRequestContext(bitmap, KClassImpl$Data$declaredNonStaticMembers$22, matrix);
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public static Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                InstrumentInjector.log_v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                InstrumentInjector.log_v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        KClassImpl$Data$declaredNonStaticMembers$22.setHasAlpha(bitmap.hasAlpha());
        if (Log.isLoggable("TransformationUtils", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            InstrumentInjector.log_v("TransformationUtils", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmap.getHeight());
            InstrumentInjector.log_v("TransformationUtils", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(KClassImpl$Data$declaredNonStaticMembers$22.getWidth());
            sb3.append("x");
            sb3.append(KClassImpl$Data$declaredNonStaticMembers$22.getHeight());
            InstrumentInjector.log_v("TransformationUtils", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            InstrumentInjector.log_v("TransformationUtils", sb4.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        getAuthRequestContext(bitmap, KClassImpl$Data$declaredNonStaticMembers$22, matrix);
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                InstrumentInjector.log_v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            InstrumentInjector.log_v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return getAuthRequestContext(bitmapPool, bitmap, i, i2);
    }

    public static Bitmap MyBillsEntityDataFactory(Bitmap bitmap, int i) {
        if (i != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                if (Log.isLoggable("TransformationUtils", 6)) {
                    InstrumentInjector.log_e("TransformationUtils", "Exception when trying to orient image", e);
                    return bitmap;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap BuiltInFictitiousFunctionClassFactory(BitmapPool bitmapPool, Bitmap bitmap, int i) {
        if (PlaceComponentResult(i)) {
            Matrix matrix = new Matrix();
            switch (i) {
                case 2:
                    matrix.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                    matrix.setRotate(180.0f);
                    break;
                case 4:
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 5:
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 6:
                    matrix.setRotate(90.0f);
                    break;
                case 7:
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                    break;
                case 8:
                    matrix.setRotate(-90.0f);
                    break;
            }
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(Math.round(rectF.width()), Math.round(rectF.height()), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            matrix.postTranslate(-rectF.left, -rectF.top);
            KClassImpl$Data$declaredNonStaticMembers$22.setHasAlpha(bitmap.hasAlpha());
            getAuthRequestContext(bitmap, KClassImpl$Data$declaredNonStaticMembers$22, matrix);
            return KClassImpl$Data$declaredNonStaticMembers$22;
        }
        return bitmap;
    }

    public static Bitmap PlaceComponentResult(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap.Config config;
        int min = Math.min(i, i2);
        float f = min;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f / height);
        float f3 = width * max;
        float f4 = max * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool, bitmap);
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            config = Bitmap.Config.RGBA_F16;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap KClassImpl$Data$declaredNonStaticMembers$23 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(min, min, config);
        KClassImpl$Data$declaredNonStaticMembers$23.setHasAlpha(true);
        Lock lock = getAuthRequestContext;
        lock.lock();
        try {
            Canvas canvas = new Canvas(KClassImpl$Data$declaredNonStaticMembers$23);
            canvas.drawCircle(f2, f2, f2, MyBillsEntityDataFactory);
            canvas.drawBitmap(KClassImpl$Data$declaredNonStaticMembers$22, (Rect) null, rectF, PlaceComponentResult);
            canvas.setBitmap(null);
            lock.unlock();
            if (!KClassImpl$Data$declaredNonStaticMembers$22.equals(bitmap)) {
                bitmapPool.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22);
            }
            return KClassImpl$Data$declaredNonStaticMembers$23;
        } catch (Throwable th) {
            getAuthRequestContext.unlock();
            throw th;
        }
    }

    public static Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, final int i) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(i > 0, "roundingRadius must be greater than 0.");
        return KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool, bitmap, new DrawRoundedCornerFn() { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.1
            @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, Paint paint, RectF rectF) {
                float f = i;
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        });
    }

    public static Bitmap BuiltInFictitiousFunctionClassFactory(BitmapPool bitmapPool, Bitmap bitmap, final float f, final float f2, final float f3, final float f4) {
        return KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool, bitmap, new DrawRoundedCornerFn() { // from class: com.bumptech.glide.load.resource.bitmap.TransformationUtils.2
            @Override // com.bumptech.glide.load.resource.bitmap.TransformationUtils.DrawRoundedCornerFn
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Canvas canvas, Paint paint, RectF rectF) {
                Path path = new Path();
                float f5 = f;
                float f6 = f2;
                float f7 = f3;
                float f8 = f4;
                path.addRoundRect(rectF, new float[]{f5, f5, f6, f6, f7, f7, f8, f8}, Path.Direction.CW);
                canvas.drawPath(path, paint);
            }
        });
    }

    private static void getAuthRequestContext(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = getAuthRequestContext;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, KClassImpl$Data$declaredNonStaticMembers$2);
            canvas.setBitmap(null);
            lock.unlock();
        } catch (Throwable th) {
            getAuthRequestContext.unlock();
            throw th;
        }
    }

    /* loaded from: classes3.dex */
    static final class NoLock implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public final void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public final boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public final boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public final void unlock() {
        }

        NoLock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }

    private static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapPool bitmapPool, Bitmap bitmap) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            config = Bitmap.Config.RGBA_F16;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        if (config.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(bitmap.getWidth(), bitmap.getHeight(), config);
        new Canvas(KClassImpl$Data$declaredNonStaticMembers$22).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapPool bitmapPool, Bitmap bitmap, DrawRoundedCornerFn drawRoundedCornerFn) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            config = Bitmap.Config.RGBA_F16;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool, bitmap);
        Bitmap KClassImpl$Data$declaredNonStaticMembers$23 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getWidth(), KClassImpl$Data$declaredNonStaticMembers$22.getHeight(), config);
        KClassImpl$Data$declaredNonStaticMembers$23.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(KClassImpl$Data$declaredNonStaticMembers$22, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, KClassImpl$Data$declaredNonStaticMembers$23.getWidth(), KClassImpl$Data$declaredNonStaticMembers$23.getHeight());
        Lock lock = getAuthRequestContext;
        lock.lock();
        try {
            Canvas canvas = new Canvas(KClassImpl$Data$declaredNonStaticMembers$23);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            drawRoundedCornerFn.KClassImpl$Data$declaredNonStaticMembers$2(canvas, paint, rectF);
            canvas.setBitmap(null);
            lock.unlock();
            if (!KClassImpl$Data$declaredNonStaticMembers$22.equals(bitmap)) {
                bitmapPool.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22);
            }
            return KClassImpl$Data$declaredNonStaticMembers$23;
        } catch (Throwable th) {
            getAuthRequestContext.unlock();
            throw th;
        }
    }
}

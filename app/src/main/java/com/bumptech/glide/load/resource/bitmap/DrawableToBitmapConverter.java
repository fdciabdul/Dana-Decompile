package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
final class DrawableToBitmapConverter {
    private static final BitmapPool getAuthRequestContext = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public final void PlaceComponentResult(Bitmap bitmap) {
        }
    };

    private DrawableToBitmapConverter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resource<Bitmap> KClassImpl$Data$declaredNonStaticMembers$2(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = BuiltInFictitiousFunctionClassFactory(bitmapPool, current, i, i2);
            z = true;
        }
        if (!z) {
            bitmapPool = getAuthRequestContext;
        }
        return BitmapResource.MyBillsEntityDataFactory(bitmap, bitmapPool);
    }

    private static Bitmap BuiltInFictitiousFunctionClassFactory(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to draw ");
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                InstrumentInjector.log_w("DrawableToBitmap", sb.toString());
            }
            return null;
        } else if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to draw ");
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                InstrumentInjector.log_w("DrawableToBitmap", sb2.toString());
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock MyBillsEntityDataFactory = TransformationUtils.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.lock();
            Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = bitmapPool.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(KClassImpl$Data$declaredNonStaticMembers$2);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            } finally {
                MyBillsEntityDataFactory.unlock();
            }
        }
    }
}

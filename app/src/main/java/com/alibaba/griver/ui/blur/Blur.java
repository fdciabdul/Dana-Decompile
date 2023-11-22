package com.alibaba.griver.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class Blur {
    public static Bitmap of(Context context, Bitmap bitmap, BlurFactor blurFactor) {
        Bitmap a2;
        synchronized (Blur.class) {
            int i = blurFactor.width / blurFactor.sampling;
            int i2 = blurFactor.height / blurFactor.sampling;
            if (Helper.hasZero(i, i2)) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(1.0f / blurFactor.sampling, 1.0f / blurFactor.sampling);
            Paint paint = new Paint();
            paint.setFlags(3);
            paint.setColorFilter(new PorterDuffColorFilter(blurFactor.color, PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    a2 = a(context, createBitmap, blurFactor.radius);
                } catch (Throwable unused) {
                    a2 = a(createBitmap);
                }
            } else {
                a2 = a(createBitmap);
            }
            if (blurFactor.sampling == 1) {
                return a2;
            }
            if (a2 != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, blurFactor.width, blurFactor.height, true);
                a2.recycle();
                return createScaledBitmap;
            }
            return null;
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        try {
            return new StackBlurManager(bitmap).process(5);
        } catch (Throwable th) {
            RVLogger.e("blur", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(android.content.Context r5, android.graphics.Bitmap r6, int r7) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 0
            android.renderscript.RenderScript r5 = android.renderscript.RenderScript.create(r5)     // Catch: java.lang.Throwable -> L53
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L4d
            r1.<init>()     // Catch: java.lang.Throwable -> L4d
            r5.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L4d
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L4d
            r2 = 1
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r5, r6, r1, r2)     // Catch: java.lang.Throwable -> L4d
            android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L4b
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r5, r2)     // Catch: java.lang.Throwable -> L4b
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r5)     // Catch: java.lang.Throwable -> L46
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r5, r3)     // Catch: java.lang.Throwable -> L46
            r0.setInput(r1)     // Catch: java.lang.Throwable -> L46
            float r7 = (float) r7     // Catch: java.lang.Throwable -> L46
            r0.setRadius(r7)     // Catch: java.lang.Throwable -> L46
            r0.forEach(r2)     // Catch: java.lang.Throwable -> L46
            r2.copyTo(r6)     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L36
            r5.destroy()
        L36:
            if (r1 == 0) goto L3b
            r1.destroy()
        L3b:
            if (r2 == 0) goto L40
            r2.destroy()
        L40:
            if (r0 == 0) goto L45
            r0.destroy()
        L45:
            return r6
        L46:
            r6 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L57
        L4b:
            r6 = move-exception
            goto L4f
        L4d:
            r6 = move-exception
            r1 = r0
        L4f:
            r2 = r0
            r0 = r5
            r5 = r2
            goto L57
        L53:
            r6 = move-exception
            r5 = r0
            r1 = r5
            r2 = r1
        L57:
            if (r0 == 0) goto L5c
            r0.destroy()
        L5c:
            if (r1 == 0) goto L61
            r1.destroy()
        L61:
            if (r2 == 0) goto L66
            r2.destroy()
        L66:
            if (r5 == 0) goto L6b
            r5.destroy()
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.blur.Blur.a(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}

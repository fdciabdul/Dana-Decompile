package com.alibaba.griver.lottie.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.lottie.L;
import com.alibaba.griver.lottie.animation.content.TrimPathContent;
import com.alibaba.griver.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;

/* loaded from: classes6.dex */
public final class Utils {
    private static int PlaceComponentResult = 1;
    public static final int SECOND_IN_NANOS = 1000000000;
    private static DisplayMetrics displayMetrics;
    private static int getAuthRequestContext;
    public static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_FIFO, -88, 36, -123, -13, -7, -8, 10, 65, -73, -23, 17, -6, -15, -8, 7, -10, -3, 74};
    public static final int BuiltInFictitiousFunctionClassFactory = 115;
    private static final PathMeasure pathMeasure = new PathMeasure();
    private static final Path tempPath = new Path();
    private static final Path tempPath2 = new Path();
    private static final float[] points = new float[4];
    private static final float SQRT_2 = (float) Math.sqrt(2.0d);
    private static float dpScale = -1.0f;

    public static int hashFor(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static boolean isAtLeastVersion(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    private Utils() {
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004b -> B:15:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void closeQuietly(java.io.Closeable r10) {
        /*
            if (r10 == 0) goto L5a
            r10.close()     // Catch: java.lang.Exception -> L6 java.lang.RuntimeException -> L58
            return
        L6:
            r10 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            byte[] r1 = com.alibaba.griver.lottie.utils.Utils.MyBillsEntityDataFactory
            r2 = 99
            r3 = -1
            r4 = 16
            byte[] r4 = new byte[r4]
            r5 = 15
            r6 = 3
            r2 = r1
            if (r1 != 0) goto L22
            r3 = r4
            r4 = -1
            r7 = 3
            r8 = 15
            r1 = r0
            goto L50
        L22:
            r6 = r4
            r3 = 99
            r4 = -1
            r7 = 3
            r1 = r0
        L28:
            int r7 = r7 + 1
            int r4 = r4 + 1
            byte r8 = (byte) r3
            r6[r4] = r8
            if (r4 != r5) goto L4b
            java.lang.String r2 = new java.lang.String
            r3 = 0
            r2.<init>(r6, r3)
            r0.append(r2)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.String r0 = "LottieUtils"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r0, r10)
            return
        L4b:
            r8 = r2[r7]
            r9 = r6
            r6 = r3
            r3 = r9
        L50:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r9 = r6
            r6 = r3
            r3 = r9
            goto L28
        L58:
            r10 = move-exception
            throw r10
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.utils.Utils.closeQuietly(java.io.Closeable):void");
    }

    public static int getScreenWidth(Context context) {
        if (displayMetrics == null) {
            displayMetrics = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (displayMetrics == null) {
            displayMetrics = new DisplayMetrics();
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = SQRT_2;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return ((float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1])) / 2.0f;
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        float[] fArr = points;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void applyTrimPathIfNeeded(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((FloatKeyframeAnimation) trimPathContent.getStart()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getEnd()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getOffset()).getFloatValue() / 360.0f);
    }

    public static void applyTrimPathIfNeeded(Path path, float f, float f2, float f3) {
        L.beginSection("applyTrimPathIfNeeded");
        PathMeasure pathMeasure2 = pathMeasure;
        pathMeasure2.setPath(path, false);
        float length = pathMeasure2.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.endSection("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            L.endSection("applyTrimPathIfNeeded");
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = MiscUtils.floorMod(min, length);
                max = MiscUtils.floorMod(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.floorMod(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.floorMod(max, length);
            }
            if (min == max) {
                path.reset();
                L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            Path path2 = tempPath;
            path2.reset();
            pathMeasure2.getSegment(min, max, path2, true);
            if (max > length) {
                Path path3 = tempPath2;
                path3.reset();
                pathMeasure2.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                Path path4 = tempPath2;
                path4.reset();
                pathMeasure2.getSegment(min + length, length, path4, true);
                path2.addPath(path4);
            }
            path.set(path2);
            L.endSection("applyTrimPathIfNeeded");
        }
    }

    public static float dpScale() {
        if (dpScale == -1.0f) {
            dpScale = Resources.getSystem().getDisplayMetrics().density;
        }
        return dpScale;
    }

    public static float getAnimationScale(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void setAnimatorsEnabled() {
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                declaredField.set(null, Float.valueOf(1.0f));
                InstrumentInjector.log_i("[Utils]", "setAnimatorsEnabled: Animators are enabled now!");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0089, code lost:
    
        if ((((java.lang.Integer) java.lang.String.class.getMethod("indexOf", java.lang.String.class).invoke(r2, "base64,")).intValue() <= 0) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015d, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("startsWith", java.lang.String.class).invoke(r14, "/")).booleanValue() != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0205 A[Catch: IOException -> 0x020f, TryCatch #7 {IOException -> 0x020f, blocks: (B:55:0x010a, B:68:0x015f, B:69:0x0174, B:78:0x01f6, B:80:0x01fc, B:81:0x01fd, B:83:0x01ff, B:85:0x0205, B:86:0x0206, B:87:0x0207, B:88:0x020e, B:70:0x0187, B:74:0x01db, B:73:0x019d, B:63:0x0126, B:66:0x0143), top: B:110:0x010a, inners: #3, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0206 A[Catch: IOException -> 0x020f, TryCatch #7 {IOException -> 0x020f, blocks: (B:55:0x010a, B:68:0x015f, B:69:0x0174, B:78:0x01f6, B:80:0x01fc, B:81:0x01fd, B:83:0x01ff, B:85:0x0205, B:86:0x0206, B:87:0x0207, B:88:0x020e, B:70:0x0187, B:74:0x01db, B:73:0x019d, B:63:0x0126, B:66:0x0143), top: B:110:0x010a, inners: #3, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap fetchBitmapDefault(android.content.Context r12, com.alibaba.griver.lottie.LottieImageAsset r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.utils.Utils.fetchBitmapDefault(android.content.Context, com.alibaba.griver.lottie.LottieImageAsset, java.lang.String):android.graphics.Bitmap");
    }
}

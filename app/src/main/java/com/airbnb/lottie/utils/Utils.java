package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: classes3.dex */
public final class Utils {
    private static final ThreadLocal<PathMeasure> BuiltInFictitiousFunctionClassFactory = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.utils.Utils.1
        @Override // java.lang.ThreadLocal
        protected /* synthetic */ PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    private static final ThreadLocal<Path> MyBillsEntityDataFactory = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.2
        @Override // java.lang.ThreadLocal
        protected /* synthetic */ Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<Path> getAuthRequestContext = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.3
        @Override // java.lang.ThreadLocal
        protected /* synthetic */ Path initialValue() {
            return new Path();
        }
    };
    private static final ThreadLocal<float[]> PlaceComponentResult = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.utils.Utils.4
        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ float[] initialValue() {
            return new float[4];
        }
    };
    private static final float KClassImpl$Data$declaredNonStaticMembers$2 = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int getAuthRequestContext(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static boolean getAuthRequestContext(int i, int i2, int i3) {
        if (i < 4) {
            return false;
        }
        if (i > 4) {
            return true;
        }
        if (i2 < 4) {
            return false;
        }
        return i2 > 4 || i3 >= 0;
    }

    private Utils() {
    }

    public static Path KClassImpl$Data$declaredNonStaticMembers$2(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void getAuthRequestContext(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float PlaceComponentResult(Matrix matrix) {
        float[] fArr = PlaceComponentResult.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = KClassImpl$Data$declaredNonStaticMembers$2;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Matrix matrix) {
        float[] fArr = PlaceComponentResult.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent == null || trimPathContent.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        getAuthRequestContext(path, ((FloatKeyframeAnimation) trimPathContent.getAuthRequestContext).lookAheadTest() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.KClassImpl$Data$declaredNonStaticMembers$2).lookAheadTest() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.MyBillsEntityDataFactory).lookAheadTest() / 360.0f);
    }

    public static void getAuthRequestContext(Path path, float f, float f2, float f3) {
        L.getAuthRequestContext("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = BuiltInFictitiousFunctionClassFactory.get();
        Path path2 = MyBillsEntityDataFactory.get();
        Path path3 = getAuthRequestContext.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.MyBillsEntityDataFactory("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            L.MyBillsEntityDataFactory("applyTrimPathIfNeeded");
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = MiscUtils.MyBillsEntityDataFactory(min, length);
                max = MiscUtils.MyBillsEntityDataFactory(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.MyBillsEntityDataFactory(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.MyBillsEntityDataFactory(max, length);
            }
            if (min == max) {
                path.reset();
                L.MyBillsEntityDataFactory("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.MyBillsEntityDataFactory("applyTrimPathIfNeeded");
        }
    }

    public static float getAuthRequestContext() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float BuiltInFictitiousFunctionClassFactory(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void getAuthRequestContext(Canvas canvas, RectF rectF, Paint paint) {
        getAuthRequestContext(canvas, rectF, paint, 31);
    }

    public static void getAuthRequestContext(Canvas canvas, RectF rectF, Paint paint, int i) {
        L.getAuthRequestContext("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.MyBillsEntityDataFactory("Utils#saveLayer");
    }
}

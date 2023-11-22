package androidx.core.graphics;

import android.graphics.Color;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes.dex */
public final class ColorUtils {
    private static final ThreadLocal<double[]> PlaceComponentResult = new ThreadLocal<>();

    private ColorUtils() {
    }

    public static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - alpha2;
        int i4 = 255 - (((255 - alpha) * i3) / 255);
        return Color.argb(i4, i4 == 0 ? 0 : (((Color.red(i) * 255) * alpha2) + ((Color.red(i2) * alpha) * i3)) / (i4 * 255), i4 == 0 ? 0 : (((Color.green(i) * 255) * alpha2) + ((Color.green(i2) * alpha) * i3)) / (i4 * 255), i4 != 0 ? (((Color.blue(i) * 255) * alpha2) + ((Color.blue(i2) * alpha) * i3)) / (i4 * 255) : 0);
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        private Api26Impl() {
        }
    }

    private static double PlaceComponentResult(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            StringBuilder sb = new StringBuilder();
            sb.append("background can not be translucent: #");
            sb.append(Integer.toHexString(i2));
            throw new IllegalArgumentException(sb.toString());
        }
        if (Color.alpha(i) < 255) {
            i = BuiltInFictitiousFunctionClassFactory(i, i2);
        }
        ThreadLocal<double[]> threadLocal = PlaceComponentResult;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        PlaceComponentResult(Color.red(i), Color.green(i), Color.blue(i), dArr);
        double d = (dArr[1] / 100.0d) + 0.05d;
        ThreadLocal<double[]> threadLocal2 = PlaceComponentResult;
        double[] dArr2 = threadLocal2.get();
        if (dArr2 == null) {
            dArr2 = new double[3];
            threadLocal2.set(dArr2);
        }
        PlaceComponentResult(Color.red(i2), Color.green(i2), Color.blue(i2), dArr2);
        double d2 = (dArr2[1] / 100.0d) + 0.05d;
        return Math.max(d, d2) / Math.min(d, d2);
    }

    public static int MyBillsEntityDataFactory(int i, int i2, float f) {
        if (Color.alpha(i2) != 255) {
            StringBuilder sb = new StringBuilder();
            sb.append("background can not be translucent: #");
            sb.append(Integer.toHexString(i2));
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i & FlexItem.MAX_SIZE;
        double d = f;
        if (PlaceComponentResult((-16777216) | i3, i2) < d) {
            return -1;
        }
        int i4 = 0;
        int i5 = 255;
        for (int i6 = 0; i6 <= 10 && i5 - i4 > 1; i6++) {
            int i7 = (i4 + i5) / 2;
            if (i7 < 0 || i7 > 255) {
                throw new IllegalArgumentException("alpha must be between 0 and 255.");
            }
            if (PlaceComponentResult((i7 << 24) | i3, i2) < d) {
                i4 = i7;
            } else {
                i5 = i7;
            }
        }
        return i5;
    }

    public static void PlaceComponentResult(int i, int i2, int i3, float[] fArr) {
        float f;
        float abs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float max = Math.max(f2, Math.max(f3, f4));
        float min = Math.min(f2, Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            abs = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? ((f4 - f2) / f5) + 2.0f : ((f2 - f3) / f5) + 4.0f;
            abs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = f7 >= 0.0f ? Math.min(f7, 360.0f) : 0.0f;
        fArr[1] = abs >= 0.0f ? Math.min(abs, 1.0f) : 0.0f;
        fArr[2] = f6 >= 0.0f ? Math.min(f6, 1.0f) : 0.0f;
    }

    public static void MyBillsEntityDataFactory(int i, float[] fArr) {
        PlaceComponentResult(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static int MyBillsEntityDataFactory(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & FlexItem.MAX_SIZE) | (i2 << 24);
    }

    private static void PlaceComponentResult(int i, int i2, int i3, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = i;
        Double.isNaN(d);
        double d2 = d / 255.0d;
        double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = i2;
        Double.isNaN(d3);
        double d4 = d3 / 255.0d;
        double pow2 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        double d5 = i3;
        Double.isNaN(d5);
        double d6 = d5 / 255.0d;
        double pow3 = d6 < 0.04045d ? d6 / 12.92d : Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
    }

    public static int MyBillsEntityDataFactory(double d, double d2, double d3) {
        double d4 = (((3.2406d * d) + ((-1.5372d) * d2)) + ((-0.4986d) * d3)) / 100.0d;
        double d5 = ((((-0.9689d) * d) + (1.8758d * d2)) + (0.0415d * d3)) / 100.0d;
        double d6 = (((0.0557d * d) + ((-0.204d) * d2)) + (1.057d * d3)) / 100.0d;
        double pow = d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d;
        double pow2 = d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d;
        double pow3 = d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d;
        int round = (int) Math.round(pow * 255.0d);
        int min = round >= 0 ? Math.min(round, 255) : 0;
        int round2 = (int) Math.round(pow2 * 255.0d);
        int min2 = round2 >= 0 ? Math.min(round2, 255) : 0;
        int round3 = (int) Math.round(pow3 * 255.0d);
        return Color.rgb(min, min2, round3 >= 0 ? Math.min(round3, 255) : 0);
    }

    public static double MyBillsEntityDataFactory(int i) {
        ThreadLocal<double[]> threadLocal = PlaceComponentResult;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        PlaceComponentResult(Color.red(i), Color.green(i), Color.blue(i), dArr);
        return dArr[1] / 100.0d;
    }
}

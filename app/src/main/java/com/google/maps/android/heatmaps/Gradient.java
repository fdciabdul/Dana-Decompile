package com.google.maps.android.heatmaps;

import android.graphics.Color;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class ColorInterval {
        private final int color1;
        private final int color2;
        private final float duration;

        private ColorInterval(int i, int i2, float f) {
            this.color1 = i;
            this.color2 = i2;
            this.duration = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        }
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (fArr[i2] <= fArr[i2 - 1]) {
                throw new IllegalArgumentException("startPoints should be in increasing order");
            }
        }
        this.mColorMapSize = i;
        int[] iArr2 = new int[iArr.length];
        this.mColors = iArr2;
        this.mStartPoints = new float[fArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
    }

    private HashMap<Integer, ColorInterval> generateColorIntervals() {
        int[] iArr;
        HashMap<Integer, ColorInterval> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new ColorInterval(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
        }
        int i = 1;
        while (true) {
            iArr = this.mColors;
            if (i >= iArr.length) {
                break;
            }
            int i2 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            int i3 = i - 1;
            hashMap.put(Integer.valueOf((int) (i2 * fArr[i3])), new ColorInterval(iArr[i3], iArr[i], (fArr[i] - fArr[i3]) * i2));
            i++;
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            int i4 = (int) (this.mColorMapSize * fArr2[length]);
            int i5 = iArr[length];
            hashMap.put(Integer.valueOf(i4), new ColorInterval(i5, i5, this.mColorMapSize * (1.0f - this.mStartPoints[length])));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] generateColorMap(double d) {
        HashMap<Integer, ColorInterval> generateColorIntervals = generateColorIntervals();
        int[] iArr = new int[this.mColorMapSize];
        ColorInterval colorInterval = generateColorIntervals.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (generateColorIntervals.containsKey(Integer.valueOf(i2))) {
                colorInterval = generateColorIntervals.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = interpolateColor(colorInterval.color1, colorInterval.color2, (i2 - i) / colorInterval.duration);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
                int i4 = iArr[i3];
                double alpha = Color.alpha(i4);
                Double.isNaN(alpha);
                iArr[i3] = Color.argb((int) (alpha * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }

    static int interpolateColor(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        float f2 = fArr[0];
        float f3 = fArr2[0];
        if (f2 - f3 > 180.0f) {
            fArr2[0] = f3 + 360.0f;
        } else if (f3 - f2 > 180.0f) {
            fArr[0] = f2 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            float f4 = fArr2[i3];
            float f5 = fArr[i3];
            fArr3[i3] = ((f4 - f5) * f) + f5;
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}

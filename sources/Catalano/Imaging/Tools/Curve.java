package Catalano.Imaging.Tools;

import Catalano.Core.FloatPoint;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class Curve implements Serializable {
    public float[] x;
    public float[] y;

    public float[] getX() {
        return this.x;
    }

    public void setX(float[] fArr) {
        this.x = fArr;
    }

    public float[] getY() {
        return this.y;
    }

    public void setY(float[] fArr) {
        this.y = fArr;
    }

    public void setXY(float[] fArr, float[] fArr2) {
        this.x = fArr;
        this.y = fArr2;
    }

    public Curve() {
        this.x = new float[0];
        this.y = new float[0];
    }

    public Curve(Curve curve) {
        this.x = (float[]) curve.x.clone();
        this.y = (float[]) curve.y.clone();
    }

    public Curve(float[] fArr, float[] fArr2) {
        this.x = fArr;
        this.y = fArr2;
    }

    public void addPoint(List<FloatPoint> list) {
        Iterator<FloatPoint> it = list.iterator();
        while (it.hasNext()) {
            addPoint(it.next());
        }
    }

    public void addPoint(FloatPoint floatPoint) {
        addPoint(floatPoint.BuiltInFictitiousFunctionClassFactory, floatPoint.MyBillsEntityDataFactory);
    }

    public void addPoint(float f, float f2) {
        int length = this.x.length;
        int i = length + 1;
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (i3 == -1 && this.x[i4] > f) {
                fArr[i2] = f;
                fArr2[i2] = f2;
                i3 = i2;
                i2++;
            }
            fArr[i2] = this.x[i4];
            fArr2[i2] = this.y[i4];
            i2++;
        }
        if (i3 == -1) {
            fArr[i2] = f;
            fArr2[i2] = f2;
        }
        this.x = fArr;
        this.y = fArr2;
    }

    public void removePoint(int i) {
        int length = this.x.length;
        if (length <= 2) {
            return;
        }
        int i2 = length - 1;
        float[] fArr = new float[i2];
        float[] fArr2 = new float[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                i3++;
            }
            fArr[i4] = this.x[i3];
            fArr2[i4] = this.y[i3];
            i3++;
        }
        this.x = fArr;
        this.y = fArr2;
    }

    public void clear() {
        this.y = null;
        this.x = null;
    }

    public int[] makeLut() {
        float[] fArr = this.x;
        int length = fArr.length;
        int i = length + 2;
        float[] fArr2 = new float[i];
        float[] fArr3 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 1, length);
        System.arraycopy(this.y, 0, fArr3, 1, length);
        fArr2[0] = fArr2[1];
        fArr3[0] = fArr3[1];
        int i2 = length + 1;
        fArr2[i2] = fArr2[length];
        fArr3[i2] = fArr3[length];
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 1024; i3++) {
            float f = i3 / 1024.0f;
            int Spline = (int) ((Spline(f, i, fArr2) * 255.0f) + 0.5f);
            int Spline2 = (int) ((Spline(f, i, fArr3) * 255.0f) + 0.5f);
            if (Spline > 255) {
                Spline = 255;
            }
            if (Spline < 0) {
                Spline = 0;
            }
            if (Spline2 > 255) {
                Spline2 = 255;
            }
            if (Spline2 < 0) {
                Spline2 = 0;
            }
            iArr[Spline] = Spline2;
        }
        return iArr;
    }

    public static float Spline(float f, int i, float[] fArr) {
        int i2 = i - 3;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Too few knots in spline");
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = f * i2;
        int i3 = (int) f2;
        int i4 = i - 4;
        if (i3 > i4) {
            i3 = i4;
        }
        float f3 = f2 - i3;
        float f4 = fArr[i3];
        float f5 = fArr[i3 + 1];
        float f6 = fArr[i3 + 2];
        float f7 = fArr[i3 + 3];
        float f8 = f4 * (-0.5f);
        float f9 = f7 * 0.0f;
        return (((((((1.5f * f5) + f8 + ((-1.5f) * f6) + (f7 * 0.5f)) * f3) + (f4 * 1.0f) + ((-2.5f) * f5) + (2.0f * f6) + (f7 * (-0.5f))) * f3) + f8 + (f5 * 0.0f) + (0.5f * f6) + f9) * f3) + (f4 * 0.0f) + (f5 * 1.0f) + (f6 * 0.0f) + f9;
    }

    public static float Spline(float f, int i, int[] iArr, int[] iArr2) {
        int i2 = i - 3;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Too few knots in spline");
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i4 + 1;
            if (iArr[i5] > f) {
                break;
            }
            i4 = i5;
        }
        if (i4 <= i2) {
            i2 = i4;
        }
        float f2 = (f - iArr[i2]) / (iArr[i2 + 1] - r1);
        int i6 = i2 - 1;
        if (i6 < 0) {
            f2 = 0.0f;
        } else {
            i3 = i6;
        }
        float f3 = iArr2[i3];
        float f4 = iArr2[i3 + 1];
        float f5 = iArr2[i3 + 2];
        float f6 = iArr2[i3 + 3];
        float f7 = f3 * (-0.5f);
        float f8 = f6 * 0.0f;
        return (((((((1.5f * f4) + f7 + ((-1.5f) * f5) + (f6 * 0.5f)) * f2) + (f3 * 1.0f) + ((-2.5f) * f4) + (2.0f * f5) + (f6 * (-0.5f))) * f2) + f7 + (f4 * 0.0f) + (0.5f * f5) + f8) * f2) + (f3 * 0.0f) + (f4 * 1.0f) + (f5 * 0.0f) + f8;
    }
}

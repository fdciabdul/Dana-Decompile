package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PathInterpolatorApi14 implements Interpolator {
    private final float[] KClassImpl$Data$declaredNonStaticMembers$2;
    private final float[] MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new float[i];
        this.MyBillsEntityDataFactory = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / ((float) (i - 1)), fArr, null);
            this.KClassImpl$Data$declaredNonStaticMembers$2[i2] = fArr[0];
            this.MyBillsEntityDataFactory[i2] = fArr[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(KClassImpl$Data$declaredNonStaticMembers$2(f, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.KClassImpl$Data$declaredNonStaticMembers$2.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.KClassImpl$Data$declaredNonStaticMembers$2[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.MyBillsEntityDataFactory[i];
        }
        float[] fArr2 = this.MyBillsEntityDataFactory;
        float f5 = fArr2[i];
        return f5 + (((f - f3) / f4) * (fArr2[length] - f5));
    }

    private static Path KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}

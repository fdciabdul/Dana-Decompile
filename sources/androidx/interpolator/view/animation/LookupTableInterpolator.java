package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float BuiltInFictitiousFunctionClassFactory;
    private final float[] MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: protected */
    public LookupTableInterpolator(float[] fArr) {
        this.MyBillsEntityDataFactory = fArr;
        this.BuiltInFictitiousFunctionClassFactory = 1.0f / ((float) (fArr.length - 1));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.MyBillsEntityDataFactory;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.BuiltInFictitiousFunctionClassFactory;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.MyBillsEntityDataFactory;
        float f4 = fArr2[min];
        return f4 + (f3 * (fArr2[min + 1] - f4));
    }
}

package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes6.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] getAuthRequestContext;

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float[] fArr5 = this.getAuthRequestContext;
        if (fArr5 == null) {
            fArr5 = new float[fArr3.length];
        }
        for (int i = 0; i < fArr5.length; i++) {
            float f2 = fArr3[i];
            fArr5[i] = f2 + ((fArr4[i] - f2) * f);
        }
        return fArr5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayEvaluator(float[] fArr) {
        this.getAuthRequestContext = fArr;
    }
}

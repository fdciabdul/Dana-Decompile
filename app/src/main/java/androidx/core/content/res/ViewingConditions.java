package androidx.core.content.res;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ViewingConditions {
    static final ViewingConditions BuiltInFictitiousFunctionClassFactory;
    final float KClassImpl$Data$declaredNonStaticMembers$2;
    final float MyBillsEntityDataFactory;
    final float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    final float NetworkUserEntityData$$ExternalSyntheticLambda1;
    final float PlaceComponentResult;
    final float getAuthRequestContext;
    final float getErrorConfigVersion;
    final float lookAheadTest;
    final float moveToNextValue;
    final float scheduleImpl = 1.0f;

    static {
        float[] fArr = CamUtils.getAuthRequestContext;
        double BuiltInFictitiousFunctionClassFactory2 = CamUtils.BuiltInFictitiousFunctionClassFactory();
        Double.isNaN(BuiltInFictitiousFunctionClassFactory2);
        float f = (float) ((BuiltInFictitiousFunctionClassFactory2 * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = CamUtils.PlaceComponentResult;
        float f2 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f3 = fArr3[0];
        float f4 = fArr[1];
        float f5 = fArr3[1];
        float f6 = fArr[2];
        float f7 = (f3 * f2) + (f5 * f4) + (fArr3[2] * f6);
        float[] fArr4 = fArr2[1];
        float f8 = (fArr4[0] * f2) + (fArr4[1] * f4) + (fArr4[2] * f6);
        float[] fArr5 = fArr2[2];
        float f9 = (f2 * fArr5[0]) + (f4 * fArr5[1]) + (f6 * fArr5[2]);
        CamUtils.KClassImpl$Data$declaredNonStaticMembers$2();
        float exp = (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f7) * exp) + 1.0f) - exp, (((100.0f / f8) * exp) + 1.0f) - exp, (((100.0f / f9) * exp) + 1.0f) - exp};
        float f10 = 1.0f / ((5.0f * f) + 1.0f);
        float f11 = f10 * f10 * f10 * f10;
        float f12 = 1.0f - f11;
        double d2 = f;
        Double.isNaN(d2);
        float cbrt = (0.1f * f12 * f12 * ((float) Math.cbrt(d2 * 5.0d))) + (f11 * f);
        float BuiltInFictitiousFunctionClassFactory3 = CamUtils.BuiltInFictitiousFunctionClassFactory() / fArr[1];
        double d3 = BuiltInFictitiousFunctionClassFactory3;
        float sqrt = (float) Math.sqrt(d3);
        float pow = 0.725f / ((float) Math.pow(d3, 0.2d));
        double d4 = fArr6[0] * cbrt * f7;
        Double.isNaN(d4);
        double d5 = fArr6[1] * cbrt * f8;
        Double.isNaN(d5);
        double d6 = fArr6[2] * cbrt * f9;
        Double.isNaN(d6);
        float pow2 = (float) Math.pow(d6 / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(d4 / 100.0d, 0.42d), (float) Math.pow(d5 / 100.0d, 0.42d), pow2};
        float f13 = fArr7[0];
        float f14 = (f13 * 400.0f) / (f13 + 27.13f);
        float f15 = fArr7[1];
        BuiltInFictitiousFunctionClassFactory = new ViewingConditions(BuiltInFictitiousFunctionClassFactory3, ((f14 * 2.0f) + ((f15 * 400.0f) / (f15 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, 0.69f, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt + 1.48f);
    }

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float[] fArr, float f6, float f7, float f8) {
        this.moveToNextValue = f;
        this.PlaceComponentResult = f2;
        this.lookAheadTest = f3;
        this.getErrorConfigVersion = f4;
        this.MyBillsEntityDataFactory = f5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f6;
        this.getAuthRequestContext = f7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f8;
    }
}

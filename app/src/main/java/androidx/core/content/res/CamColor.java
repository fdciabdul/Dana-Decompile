package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CamColor {
    private final float BuiltInFictitiousFunctionClassFactory;
    private final float KClassImpl$Data$declaredNonStaticMembers$2;
    final float MyBillsEntityDataFactory;
    private final float NetworkUserEntityData$$ExternalSyntheticLambda0;
    final float PlaceComponentResult;
    private final float getAuthRequestContext;
    private final float getErrorConfigVersion;
    private final float lookAheadTest;
    private final float scheduleImpl;

    private CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.PlaceComponentResult = f;
        this.MyBillsEntityDataFactory = f2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f3;
        this.getErrorConfigVersion = f4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f5;
        this.scheduleImpl = f6;
        this.lookAheadTest = f7;
        this.BuiltInFictitiousFunctionClassFactory = f8;
        this.getAuthRequestContext = f9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        ViewingConditions viewingConditions = ViewingConditions.BuiltInFictitiousFunctionClassFactory;
        float f7 = f2;
        if (f7 >= 1.0d && Math.round(f3) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && Math.round(f3) < 100.0d) {
            float min = f < 0.0f ? 0.0f : Math.min(360.0f, f);
            float f8 = f7;
            boolean z = true;
            float f9 = 0.0f;
            CamColor camColor = null;
            while (Math.abs(f9 - f7) >= 0.4f) {
                float f10 = 100.0f;
                float f11 = 1000.0f;
                float f12 = 1000.0f;
                CamColor camColor2 = null;
                float f13 = 0.0f;
                while (true) {
                    if (Math.abs(f13 - f10) <= 0.01f) {
                        f4 = min;
                        f5 = f7;
                        f6 = f8;
                        break;
                    }
                    float f14 = ((f10 - f13) / 2.0f) + f13;
                    int BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory(f14, f8, min, ViewingConditions.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(ViewingConditions.BuiltInFictitiousFunctionClassFactory);
                    float PlaceComponentResult = CamUtils.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                    float abs = Math.abs(f3 - PlaceComponentResult);
                    if (abs < 0.2f) {
                        CamColor BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, ViewingConditions.BuiltInFictitiousFunctionClassFactory);
                        f5 = f7;
                        f6 = f8;
                        CamColor MyBillsEntityDataFactory = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory, min, ViewingConditions.BuiltInFictitiousFunctionClassFactory);
                        float f15 = BuiltInFictitiousFunctionClassFactory2.lookAheadTest - MyBillsEntityDataFactory.lookAheadTest;
                        f4 = min;
                        float f16 = BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory - MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                        float f17 = BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext - MyBillsEntityDataFactory.getAuthRequestContext;
                        float pow = (float) (Math.pow(Math.sqrt((f15 * f15) + (f16 * f16) + (f17 * f17)), 0.63d) * 1.41d);
                        if (pow <= 1.0f) {
                            camColor2 = BuiltInFictitiousFunctionClassFactory2;
                            f12 = pow;
                            f11 = abs;
                        }
                    } else {
                        f4 = min;
                        f5 = f7;
                        f6 = f8;
                    }
                    if (f11 == 0.0f && f12 == 0.0f) {
                        break;
                    }
                    if (PlaceComponentResult < f3) {
                        f7 = f5;
                        f13 = f14;
                    } else {
                        f7 = f5;
                        f10 = f14;
                    }
                    f8 = f6;
                    min = f4;
                }
                if (z) {
                    if (camColor2 != null) {
                        return camColor2.BuiltInFictitiousFunctionClassFactory(viewingConditions);
                    }
                    f7 = f5;
                    z = false;
                } else if (camColor2 == null) {
                    f7 = f6;
                } else {
                    f7 = f5;
                    camColor = camColor2;
                    f9 = f6;
                }
                f8 = ((f7 - f9) / 2.0f) + f9;
                min = f4;
            }
            if (camColor != null) {
                return camColor.BuiltInFictitiousFunctionClassFactory(viewingConditions);
            }
        }
        return CamUtils.BuiltInFictitiousFunctionClassFactory(f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CamColor getAuthRequestContext(int i) {
        return BuiltInFictitiousFunctionClassFactory(i, ViewingConditions.BuiltInFictitiousFunctionClassFactory);
    }

    private static CamColor BuiltInFictitiousFunctionClassFactory(int i, ViewingConditions viewingConditions) {
        float[] BuiltInFictitiousFunctionClassFactory = CamUtils.BuiltInFictitiousFunctionClassFactory(i);
        float[][] fArr = CamUtils.PlaceComponentResult;
        float f = BuiltInFictitiousFunctionClassFactory[0];
        float[] fArr2 = fArr[0];
        float f2 = fArr2[0];
        float f3 = BuiltInFictitiousFunctionClassFactory[1];
        float f4 = fArr2[1];
        float f5 = BuiltInFictitiousFunctionClassFactory[2];
        float f6 = fArr2[2];
        float[] fArr3 = fArr[1];
        float f7 = fArr3[0];
        float f8 = fArr3[1];
        float f9 = fArr3[2];
        float[] fArr4 = fArr[2];
        float f10 = fArr4[0];
        float f11 = fArr4[1];
        float f12 = fArr4[2];
        float f13 = viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[0] * ((f2 * f) + (f4 * f3) + (f6 * f5));
        float f14 = viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[1] * ((f7 * f) + (f8 * f3) + (f9 * f5));
        float f15 = viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[2] * ((f * f10) + (f3 * f11) + (f5 * f12));
        double abs = viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2 * Math.abs(f13);
        Double.isNaN(abs);
        float pow = (float) Math.pow(abs / 100.0d, 0.42d);
        double abs2 = viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2 * Math.abs(f14);
        Double.isNaN(abs2);
        float pow2 = (float) Math.pow(abs2 / 100.0d, 0.42d);
        double abs3 = viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2 * Math.abs(f15);
        Double.isNaN(abs3);
        float pow3 = (float) Math.pow(abs3 / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d = signum;
        double d2 = signum2;
        double d3 = signum3;
        Double.isNaN(d);
        Double.isNaN(d2);
        Double.isNaN(d3);
        float f16 = ((float) (((d * 11.0d) + (d2 * (-12.0d))) + d3)) / 11.0f;
        double d4 = signum + signum2;
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f17 = ((float) (d4 - (d3 * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = (((signum * 20.0f) + f18) + (21.0f * signum3)) / 20.0f;
        float f20 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f21 = atan2;
        float f22 = (3.1415927f * f21) / 180.0f;
        float pow4 = ((float) Math.pow((f20 * viewingConditions.lookAheadTest) / viewingConditions.PlaceComponentResult, viewingConditions.MyBillsEntityDataFactory * viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda1)) * 100.0f;
        float f23 = 4.0f / viewingConditions.MyBillsEntityDataFactory;
        float sqrt = (float) Math.sqrt(pow4 / 100.0f);
        float f24 = viewingConditions.PlaceComponentResult;
        float f25 = viewingConditions.getAuthRequestContext;
        Double.isNaN(((double) f21) < 20.14d ? 360.0f + f21 : f21);
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.moveToNextValue), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((r9 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.scheduleImpl) * viewingConditions.getErrorConfigVersion) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d));
        double d5 = pow4;
        Double.isNaN(d5);
        float sqrt2 = pow5 * ((float) Math.sqrt(d5 / 100.0d));
        float f26 = sqrt2 * viewingConditions.getAuthRequestContext;
        float sqrt3 = (float) Math.sqrt((pow5 * viewingConditions.MyBillsEntityDataFactory) / (viewingConditions.PlaceComponentResult + 4.0f));
        float f27 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * f26) + 1.0f)) * 43.85965f;
        double d6 = f22;
        return new CamColor(f21, sqrt2, pow4, f25 * f23 * sqrt * (f24 + 4.0f), f26, sqrt3 * 50.0f, f27, log * ((float) Math.cos(d6)), log * ((float) Math.sin(d6)));
    }

    private static CamColor MyBillsEntityDataFactory(float f, float f2, float f3, ViewingConditions viewingConditions) {
        float f4 = 4.0f / viewingConditions.MyBillsEntityDataFactory;
        double d = f;
        Double.isNaN(d);
        float sqrt = (float) Math.sqrt(d / 100.0d);
        float f5 = viewingConditions.PlaceComponentResult;
        float f6 = viewingConditions.getAuthRequestContext;
        float f7 = viewingConditions.getAuthRequestContext * f2;
        float sqrt2 = (float) Math.sqrt(((f2 / ((float) Math.sqrt(r4))) * viewingConditions.MyBillsEntityDataFactory) / (viewingConditions.PlaceComponentResult + 4.0f));
        float f8 = (1.7f * f) / ((0.007f * f) + 1.0f);
        double d2 = f7;
        Double.isNaN(d2);
        float log = ((float) Math.log((d2 * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, f4 * sqrt * (f5 + 4.0f) * f6, f7, sqrt2 * 50.0f, f8, log * ((float) Math.cos(d3)), ((float) Math.sin(d3)) * log);
    }

    private int BuiltInFictitiousFunctionClassFactory(ViewingConditions viewingConditions) {
        float f;
        float f2 = this.MyBillsEntityDataFactory;
        if (f2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            float f3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (f3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d = f3;
                Double.isNaN(d);
                f = f2 / ((float) Math.sqrt(d / 100.0d));
                double d2 = f;
                double pow = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.moveToNextValue), 0.73d);
                Double.isNaN(d2);
                float pow2 = (float) Math.pow(d2 / pow, 1.1111111111111112d);
                double d3 = (this.PlaceComponentResult * 3.1415927f) / 180.0f;
                Double.isNaN(d3);
                float cos = (float) (Math.cos(2.0d + d3) + 3.8d);
                float f4 = viewingConditions.PlaceComponentResult;
                double d4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Double.isNaN(d4);
                double d5 = viewingConditions.MyBillsEntityDataFactory;
                Double.isNaN(d5);
                double d6 = 1.0d / d5;
                double d7 = viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda1;
                Double.isNaN(d7);
                float pow3 = (float) Math.pow(d4 / 100.0d, d6 / d7);
                float f5 = viewingConditions.scheduleImpl;
                float f6 = viewingConditions.getErrorConfigVersion;
                float f7 = (f4 * pow3) / viewingConditions.lookAheadTest;
                float sin = (float) Math.sin(d3);
                float cos2 = (float) Math.cos(d3);
                float f8 = (((0.305f + f7) * 23.0f) * pow2) / (((((((cos * 0.25f) * 3846.1538f) * f5) * f6) * 23.0f) + ((11.0f * pow2) * cos2)) + ((pow2 * 108.0f) * sin));
                float f9 = cos2 * f8;
                float f10 = f8 * sin;
                float f11 = f7 * 460.0f;
                float f12 = (((451.0f * f9) + f11) + (288.0f * f10)) / 1403.0f;
                float f13 = ((f11 - (891.0f * f9)) - (261.0f * f10)) / 1403.0f;
                float f14 = ((f11 - (f9 * 220.0f)) - (f10 * 6300.0f)) / 1403.0f;
                double abs = Math.abs(f12);
                double abs2 = Math.abs(f12);
                Double.isNaN(abs);
                Double.isNaN(abs2);
                float max = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs * 27.13d) / (400.0d - abs2));
                float signum = Math.signum(f12);
                float f15 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
                float pow4 = (float) Math.pow(max, 2.380952380952381d);
                double abs3 = Math.abs(f13);
                double abs4 = Math.abs(f13);
                Double.isNaN(abs3);
                Double.isNaN(abs4);
                float max2 = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs3 * 27.13d) / (400.0d - abs4));
                float signum2 = Math.signum(f13);
                float f16 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
                float pow5 = (float) Math.pow(max2, 2.380952380952381d);
                double abs5 = Math.abs(f14);
                double abs6 = Math.abs(f14);
                Double.isNaN(abs5);
                Double.isNaN(abs6);
                float max3 = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs5 * 27.13d) / (400.0d - abs6));
                float signum3 = Math.signum(f14);
                float f17 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
                float pow6 = (float) Math.pow(max3, 2.380952380952381d);
                float f18 = ((signum * f15) * pow4) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[0];
                float f19 = ((signum2 * f16) * pow5) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[1];
                float f20 = ((signum3 * f17) * pow6) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[2];
                float[][] fArr = CamUtils.BuiltInFictitiousFunctionClassFactory;
                float[] fArr2 = fArr[0];
                float f21 = fArr2[0];
                float f22 = fArr2[1];
                float f23 = fArr2[2];
                float[] fArr3 = fArr[1];
                float f24 = fArr3[0];
                float f25 = fArr3[1];
                float f26 = fArr3[2];
                float[] fArr4 = fArr[2];
                return ColorUtils.MyBillsEntityDataFactory((f21 * f18) + (f22 * f19) + (f23 * f20), (f24 * f18) + (f25 * f19) + (f26 * f20), (f18 * fArr4[0]) + (f19 * fArr4[1]) + (f20 * fArr4[2]));
            }
        }
        f = 0.0f;
        double d22 = f;
        double pow7 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.moveToNextValue), 0.73d);
        Double.isNaN(d22);
        float pow22 = (float) Math.pow(d22 / pow7, 1.1111111111111112d);
        double d32 = (this.PlaceComponentResult * 3.1415927f) / 180.0f;
        Double.isNaN(d32);
        float cos3 = (float) (Math.cos(2.0d + d32) + 3.8d);
        float f42 = viewingConditions.PlaceComponentResult;
        double d42 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Double.isNaN(d42);
        double d52 = viewingConditions.MyBillsEntityDataFactory;
        Double.isNaN(d52);
        double d62 = 1.0d / d52;
        double d72 = viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Double.isNaN(d72);
        float pow32 = (float) Math.pow(d42 / 100.0d, d62 / d72);
        float f52 = viewingConditions.scheduleImpl;
        float f62 = viewingConditions.getErrorConfigVersion;
        float f72 = (f42 * pow32) / viewingConditions.lookAheadTest;
        float sin2 = (float) Math.sin(d32);
        float cos22 = (float) Math.cos(d32);
        float f82 = (((0.305f + f72) * 23.0f) * pow22) / (((((((cos3 * 0.25f) * 3846.1538f) * f52) * f62) * 23.0f) + ((11.0f * pow22) * cos22)) + ((pow22 * 108.0f) * sin2));
        float f92 = cos22 * f82;
        float f102 = f82 * sin2;
        float f112 = f72 * 460.0f;
        float f122 = (((451.0f * f92) + f112) + (288.0f * f102)) / 1403.0f;
        float f132 = ((f112 - (891.0f * f92)) - (261.0f * f102)) / 1403.0f;
        float f142 = ((f112 - (f92 * 220.0f)) - (f102 * 6300.0f)) / 1403.0f;
        double abs7 = Math.abs(f122);
        double abs22 = Math.abs(f122);
        Double.isNaN(abs7);
        Double.isNaN(abs22);
        float max4 = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs7 * 27.13d) / (400.0d - abs22));
        float signum4 = Math.signum(f122);
        float f152 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
        float pow42 = (float) Math.pow(max4, 2.380952380952381d);
        double abs32 = Math.abs(f132);
        double abs42 = Math.abs(f132);
        Double.isNaN(abs32);
        Double.isNaN(abs42);
        float max22 = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs32 * 27.13d) / (400.0d - abs42));
        float signum22 = Math.signum(f132);
        float f162 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
        float pow52 = (float) Math.pow(max22, 2.380952380952381d);
        double abs52 = Math.abs(f142);
        double abs62 = Math.abs(f142);
        Double.isNaN(abs52);
        Double.isNaN(abs62);
        float max32 = (float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (abs52 * 27.13d) / (400.0d - abs62));
        float signum32 = Math.signum(f142);
        float f172 = 100.0f / viewingConditions.KClassImpl$Data$declaredNonStaticMembers$2;
        float pow62 = (float) Math.pow(max32, 2.380952380952381d);
        float f182 = ((signum4 * f152) * pow42) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[0];
        float f192 = ((signum22 * f162) * pow52) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[1];
        float f202 = ((signum32 * f172) * pow62) / viewingConditions.NetworkUserEntityData$$ExternalSyntheticLambda0[2];
        float[][] fArr5 = CamUtils.BuiltInFictitiousFunctionClassFactory;
        float[] fArr22 = fArr5[0];
        float f212 = fArr22[0];
        float f222 = fArr22[1];
        float f232 = fArr22[2];
        float[] fArr32 = fArr5[1];
        float f242 = fArr32[0];
        float f252 = fArr32[1];
        float f262 = fArr32[2];
        float[] fArr42 = fArr5[2];
        return ColorUtils.MyBillsEntityDataFactory((f212 * f182) + (f222 * f192) + (f232 * f202), (f242 * f182) + (f252 * f192) + (f262 * f202), (f182 * fArr42[0]) + (f192 * fArr42[1]) + (f202 * fArr42[2]));
    }
}

package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CamUtils {
    static final float[][] PlaceComponentResult = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] BuiltInFictitiousFunctionClassFactory = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[] getAuthRequestContext = {95.047f, 100.0f, 108.883f};
    static final float[][] MyBillsEntityDataFactory = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float KClassImpl$Data$declaredNonStaticMembers$2() {
        return 0.69f;
    }

    private CamUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f2 = (f + 16.0f) / 116.0f;
        float f3 = (f > 8.0f ? 1 : (f == 8.0f ? 0 : -1)) > 0 ? f2 * f2 * f2 : f / 903.2963f;
        float f4 = f2 * f2 * f2;
        boolean z = f4 > 0.008856452f;
        float f5 = z ? f4 : ((f2 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f4 = ((f2 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = getAuthRequestContext;
        return ColorUtils.MyBillsEntityDataFactory(f5 * fArr[0], f3 * fArr[1], f4 * fArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] BuiltInFictitiousFunctionClassFactory(int i) {
        float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(Color.red(i));
        float MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(Color.green(i));
        float MyBillsEntityDataFactory4 = MyBillsEntityDataFactory(Color.blue(i));
        float[][] fArr = MyBillsEntityDataFactory;
        float[] fArr2 = fArr[0];
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float[] fArr3 = fArr[1];
        float f4 = fArr3[0];
        float f5 = fArr3[1];
        float f6 = fArr3[2];
        float[] fArr4 = fArr[2];
        return new float[]{(f * MyBillsEntityDataFactory2) + (f2 * MyBillsEntityDataFactory3) + (f3 * MyBillsEntityDataFactory4), (f4 * MyBillsEntityDataFactory2) + (f5 * MyBillsEntityDataFactory3) + (f6 * MyBillsEntityDataFactory4), (MyBillsEntityDataFactory2 * fArr4[0]) + (MyBillsEntityDataFactory3 * fArr4[1]) + (MyBillsEntityDataFactory4 * fArr4[2])};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float BuiltInFictitiousFunctionClassFactory() {
        return ((float) Math.pow(0.5689655172413793d, 3.0d)) * 100.0f;
    }

    private static float MyBillsEntityDataFactory(int i) {
        float f = i / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float PlaceComponentResult(int i) {
        float MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(Color.red(i));
        float MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(Color.green(i));
        float MyBillsEntityDataFactory4 = MyBillsEntityDataFactory(Color.blue(i));
        float[] fArr = MyBillsEntityDataFactory[1];
        float f = (((MyBillsEntityDataFactory2 * fArr[0]) + (MyBillsEntityDataFactory3 * fArr[1])) + (MyBillsEntityDataFactory4 * fArr[2])) / 100.0f;
        return f <= 0.008856452f ? f * 903.2963f : (((float) Math.cbrt(f)) * 116.0f) - 16.0f;
    }
}

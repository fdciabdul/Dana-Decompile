package Catalano.Imaging.Filters;

import Catalano.Core.IntRange;
import Catalano.Imaging.IApplyInPlace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class LevelsLinear implements IApplyInPlace {
    public IntRange KClassImpl$Data$declaredNonStaticMembers$2 = new IntRange(0, 255);
    public IntRange MyBillsEntityDataFactory = new IntRange(0, 255);
    public IntRange getAuthRequestContext = new IntRange(0, 255);
    public IntRange BuiltInFictitiousFunctionClassFactory = new IntRange(0, 255);
    public IntRange DatabaseTableConfigUtil = new IntRange(0, 255);
    public IntRange NetworkUserEntityData$$ExternalSyntheticLambda1 = new IntRange(0, 255);
    public IntRange scheduleImpl = new IntRange(0, 255);
    public IntRange NetworkUserEntityData$$ExternalSyntheticLambda0 = new IntRange(0, 255);
    public int[] getErrorConfigVersion = new int[256];
    public int[] moveToNextValue = new int[256];
    public int[] PlaceComponentResult = new int[256];
    public int[] lookAheadTest = new int[256];

    public static void getAuthRequestContext(IntRange intRange, IntRange intRange2, int[] iArr) {
        double d;
        int i;
        int max = intRange.getMax();
        int min = intRange.getMin();
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (max != min) {
            double max2 = intRange2.getMax() - intRange2.getMin();
            double max3 = intRange.getMax() - intRange.getMin();
            Double.isNaN(max2);
            Double.isNaN(max3);
            double d3 = max2 / max3;
            double min2 = intRange2.getMin();
            double min3 = intRange.getMin();
            Double.isNaN(min3);
            Double.isNaN(min2);
            double d4 = min2 - (min3 * d3);
            d = d3;
            d2 = d4;
        } else {
            d = 0.0d;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 >= intRange.getMax()) {
                i = intRange2.getMax();
            } else if (i2 <= intRange.getMin()) {
                i = intRange2.getMin();
            } else {
                double d5 = i2;
                Double.isNaN(d5);
                i = (int) ((d5 * d) + d2);
            }
            iArr[i2] = i;
        }
    }
}

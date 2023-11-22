package Catalano.Math.Random;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class UniversalGenerator implements IRandomNumberGenerator {
    private double BuiltInFictitiousFunctionClassFactory;
    private double KClassImpl$Data$declaredNonStaticMembers$2;
    private double MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private double[] getErrorConfigVersion = new double[97];

    public UniversalGenerator() {
        int i = 12;
        int i2 = 34;
        int i3 = 78;
        int i4 = 56;
        int i5 = 0;
        for (int i6 = 97; i5 < i6; i6 = 97) {
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d2 = 0.5d;
            int i7 = 0;
            while (i7 < 24) {
                int i8 = (((i * i2) % 179) * i4) % 179;
                i3 = ((i3 * 53) + 1) % 169;
                if ((i3 * i8) % 64 >= 32) {
                    d += d2;
                }
                d2 *= 0.5d;
                i7++;
                int i9 = i4;
                i4 = i8;
                i = i2;
                i2 = i9;
            }
            this.getErrorConfigVersion[i5] = d;
            i5++;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.021602869033813477d;
        this.BuiltInFictitiousFunctionClassFactory = 0.45623308420181274d;
        this.MyBillsEntityDataFactory = 0.9999998211860657d;
        this.PlaceComponentResult = 96;
        this.getAuthRequestContext = 32;
    }
}

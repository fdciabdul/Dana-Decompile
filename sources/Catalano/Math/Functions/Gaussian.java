package Catalano.Math.Functions;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
public class Gaussian {
    public double KClassImpl$Data$declaredNonStaticMembers$2;
    public double PlaceComponentResult;

    public Gaussian(double d) {
        this.PlaceComponentResult = 1.0d;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 1.0d;
        this.PlaceComponentResult = Math.max(1.0E-8d, d);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d * d;
    }

    public final double[] MyBillsEntityDataFactory(int i) {
        if (i % 2 == 0 || i < 3 || i > 101) {
            try {
                throw new Exception("Wrong size");
            } catch (Exception unused) {
            }
        }
        double[] dArr = new double[i];
        int i2 = -(i / 2);
        for (int i3 = 0; i3 < i; i3++) {
            double d = i2;
            Double.isNaN(d);
            Double.isNaN(d);
            dArr[i3] = Math.exp((d * d) / (this.KClassImpl$Data$declaredNonStaticMembers$2 * (-2.0d))) / (Math.sqrt(6.283185307179586d) * this.PlaceComponentResult);
            i2++;
        }
        return dArr;
    }

    public final double[][] KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i % 2 == 0 || i < 3 || i > 101) {
            try {
                throw new Exception("Wrong size");
            } catch (Exception unused) {
            }
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i, i);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i2 = -(i / 2);
        int i3 = i2;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i2;
            for (int i6 = 0; i6 < i; i6++) {
                double[] dArr2 = dArr[i4];
                double d2 = i5;
                double d3 = i3;
                Double.isNaN(d2);
                Double.isNaN(d2);
                Double.isNaN(d3);
                Double.isNaN(d3);
                dArr2[i6] = Math.exp((-((d2 * d2) + (d3 * d3))) / (this.KClassImpl$Data$declaredNonStaticMembers$2 * 2.0d)) / (this.KClassImpl$Data$declaredNonStaticMembers$2 * 6.283185307179586d);
                d += dArr[i4][i6];
                i5++;
            }
            i3++;
        }
        for (double[] dArr3 : dArr) {
            for (int i7 = 0; i7 < dArr[0].length; i7++) {
                dArr3[i7] = dArr3[i7] / d;
            }
        }
        return dArr;
    }
}

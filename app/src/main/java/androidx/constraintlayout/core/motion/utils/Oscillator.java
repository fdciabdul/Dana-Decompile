package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class Oscillator {
    public double[] BuiltInFictitiousFunctionClassFactory;
    MonotonicCurveFit KClassImpl$Data$declaredNonStaticMembers$2;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    String getAuthRequestContext;
    public float[] scheduleImpl = new float[0];
    public double[] moveToNextValue = new double[0];
    double PlaceComponentResult = 6.283185307179586d;
    public boolean MyBillsEntityDataFactory = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos =");
        sb.append(Arrays.toString(this.moveToNextValue));
        sb.append(" period=");
        sb.append(Arrays.toString(this.scheduleImpl));
        return sb.toString();
    }

    public final void BuiltInFictitiousFunctionClassFactory(double d, float f) {
        int length = this.scheduleImpl.length + 1;
        int binarySearch = Arrays.binarySearch(this.moveToNextValue, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.moveToNextValue = Arrays.copyOf(this.moveToNextValue, length);
        this.scheduleImpl = Arrays.copyOf(this.scheduleImpl, length);
        this.BuiltInFictitiousFunctionClassFactory = new double[length];
        double[] dArr = this.moveToNextValue;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.moveToNextValue[binarySearch] = d;
        this.scheduleImpl[binarySearch] = f;
        this.MyBillsEntityDataFactory = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double BuiltInFictitiousFunctionClassFactory(double d) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.moveToNextValue, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.scheduleImpl;
            float f = fArr[i];
            int i2 = i - 1;
            float f2 = fArr[i2];
            double d2 = f - f2;
            double[] dArr = this.moveToNextValue;
            double d3 = dArr[i];
            double d4 = dArr[i2];
            Double.isNaN(d2);
            double d5 = d2 / (d3 - d4);
            double d6 = this.BuiltInFictitiousFunctionClassFactory[i2];
            double d7 = f2;
            Double.isNaN(d7);
            return d6 + ((d7 - (d5 * d4)) * (d - d4)) + ((d5 * ((d * d) - (d4 * d4))) / 2.0d);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final double KClassImpl$Data$declaredNonStaticMembers$2(double d, double d2) {
        double abs;
        double BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(d) + d2;
        switch (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            case 1:
                return Math.signum(0.5d - (BuiltInFictitiousFunctionClassFactory % 1.0d));
            case 2:
                abs = Math.abs((((BuiltInFictitiousFunctionClassFactory * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((BuiltInFictitiousFunctionClassFactory * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((BuiltInFictitiousFunctionClassFactory * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PlaceComponentResult * (d2 + BuiltInFictitiousFunctionClassFactory));
            case 6:
                double abs2 = 1.0d - Math.abs(((BuiltInFictitiousFunctionClassFactory * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory % 1.0d);
            default:
                return Math.sin(this.PlaceComponentResult * BuiltInFictitiousFunctionClassFactory);
        }
        return 1.0d - abs;
    }
}

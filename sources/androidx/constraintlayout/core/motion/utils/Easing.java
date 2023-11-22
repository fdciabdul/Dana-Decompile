package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class Easing {
    static Easing BuiltInFictitiousFunctionClassFactory = new Easing();
    public static String[] PlaceComponentResult = {"standard", "accelerate", "decelerate", "linear"};
    String getAuthRequestContext = "identity";

    public double BuiltInFictitiousFunctionClassFactory(double d) {
        return 1.0d;
    }

    public double getAuthRequestContext(double d) {
        return d;
    }

    public static Easing PlaceComponentResult(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals("anticipate")) {
                    c = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals("overshoot")) {
                    c = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 5;
                    break;
                }
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c != 4) {
                            if (c == 5) {
                                return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
                            }
                            PrintStream printStream = System.err;
                            StringBuilder sb = new StringBuilder();
                            sb.append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
                            sb.append(Arrays.toString(PlaceComponentResult));
                            printStream.println(sb.toString());
                            return BuiltInFictitiousFunctionClassFactory;
                        }
                        return new CubicEasing("cubic(0.34, 1.56, 0.64, 1)");
                    }
                    return new CubicEasing("cubic(1, 1, 0, 0)");
                }
                return new CubicEasing("cubic(0.36, 0, 0.66, -0.56)");
            }
            return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
        }
        return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
    }

    public String toString() {
        return this.getAuthRequestContext;
    }

    /* loaded from: classes3.dex */
    static class CubicEasing extends Easing {
        private static double NetworkUserEntityData$$ExternalSyntheticLambda0 = 1.0E-4d;
        private static double moveToNextValue = 0.01d;
        double KClassImpl$Data$declaredNonStaticMembers$2;
        double MyBillsEntityDataFactory;
        double getErrorConfigVersion;
        double scheduleImpl;

        CubicEasing(String str) {
            this.getAuthRequestContext = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.getErrorConfigVersion = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.MyBillsEntityDataFactory = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.scheduleImpl = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        private double MyBillsEntityDataFactory(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.KClassImpl$Data$declaredNonStaticMembers$2 * d2 * d3 * d) + (this.MyBillsEntityDataFactory * d3 * d * d) + (d * d * d);
        }

        private double KClassImpl$Data$declaredNonStaticMembers$2(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.getErrorConfigVersion * d2 * d3 * d) + (this.scheduleImpl * d3 * d * d) + (d * d * d);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public final double BuiltInFictitiousFunctionClassFactory(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > NetworkUserEntityData$$ExternalSyntheticLambda0) {
                d2 *= 0.5d;
                d3 = MyBillsEntityDataFactory(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (KClassImpl$Data$declaredNonStaticMembers$2(d5) - KClassImpl$Data$declaredNonStaticMembers$2(d4)) / (MyBillsEntityDataFactory(d5) - MyBillsEntityDataFactory(d4));
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public final double getAuthRequestContext(double d) {
            if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > moveToNextValue) {
                d2 *= 0.5d;
                d3 = MyBillsEntityDataFactory(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double MyBillsEntityDataFactory = MyBillsEntityDataFactory(d4);
            double d5 = d3 + d2;
            double MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(d5);
            double KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(d4);
            return (((KClassImpl$Data$declaredNonStaticMembers$2(d5) - KClassImpl$Data$declaredNonStaticMembers$2) * (d - MyBillsEntityDataFactory)) / (MyBillsEntityDataFactory2 - MyBillsEntityDataFactory)) + KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}

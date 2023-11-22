package Catalano.Math.Distances;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public final class Distance {
    private Distance() {
    }

    public static double getAuthRequestContext(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            double d3 = dArr2[i];
            double d4 = d2 * d3;
            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d5 = d2 + d3;
                d += (d5 / 2.0d) * Math.log(d5 / (Math.sqrt(d4) * 2.0d));
            }
        }
        return d;
    }

    public static double KClassImpl$Data$declaredNonStaticMembers$2(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < length; i++) {
            d += Math.sqrt(dArr[i]) * Math.sqrt(dArr2[i]);
        }
        return Math.sqrt(1.0d - d);
    }

    public static double PlaceComponentResult(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.abs(dArr[i] - dArr2[i]);
            d2 += Math.abs(dArr[i] + dArr2[i]);
        }
        return d / d2;
    }

    public static double MyBillsEntityDataFactory(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.abs(dArr[i] - dArr2[i]) / (Math.abs(dArr[i]) + Math.abs(dArr2[i]));
        }
        return d;
    }

    public static double BuiltInFictitiousFunctionClassFactory(double[] dArr, double[] dArr2) {
        double abs = Math.abs(dArr[0] - dArr2[0]);
        for (int i = 1; i < dArr.length; i++) {
            double abs2 = Math.abs(dArr[i] - dArr2[i]);
            if (abs2 > abs) {
                abs = abs2;
            }
        }
        return abs;
    }

    public static double moveToNextValue(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 0;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i2 = 0; i2 < dArr3.length; i2++) {
            d2 += -dArr3[i2];
            d3 += -dArr4[i2];
        }
        double length = dArr3.length;
        Double.isNaN(length);
        double d4 = d2 / length;
        double length2 = dArr4.length;
        Double.isNaN(length2);
        double d5 = d3 / length2;
        double d6 = 0.0d;
        double d7 = 0.0d;
        while (i < dArr3.length) {
            double d8 = dArr3[i];
            double d9 = dArr4[i];
            double d10 = d8 + d4;
            d6 += Math.abs(Math.pow(d10, 2.0d));
            d7 += Math.abs(Math.pow(dArr4[i] + d4, 2.0d));
            i++;
            d += d10 * (d9 + d5);
            dArr3 = dArr;
            dArr4 = dArr2;
        }
        return 1.0d - (d / (Math.sqrt(d6) * Math.sqrt(d7)));
    }

    public static double scheduleImpl(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d4 = dArr[i];
            d2 += dArr2[i] * d4;
            d += Math.pow(Math.abs(d4), 2.0d);
            d3 += Math.pow(Math.abs(dArr2[i]), 2.0d);
        }
        return 1.0d - (d2 / (Math.sqrt(d) * Math.sqrt(d3)));
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (str.length() != str2.length()) {
            throw new IllegalArgumentException("The size of string must be the same.");
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) != str2.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    public static double lookAheadTest(double[] dArr, double[] dArr2) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            double d = dArr[i3];
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr2[i3] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                if (d == dArr2[i3]) {
                    i2++;
                }
                i++;
            }
        }
        if (i != 0) {
            double d2 = i2;
            double d3 = i;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return 1.0d - (d2 / d3);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static double getErrorConfigVersion(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        boolean z = false;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d += (d2 - d3) * Math.log(d2 / d3);
                    z = true;
                }
            }
        }
        if (z) {
            return d;
        }
        return Double.POSITIVE_INFINITY;
    }

    public static double GetContactSyncConfig(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        boolean z = false;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double log = Math.log(d2);
                    double d4 = dArr2[i];
                    double d5 = (d3 + d2) / 2.0d;
                    d += (((log * d2) + (d4 * Math.log(d4))) / 2.0d) - (d5 * Math.log(d5));
                    z = true;
                }
            }
        }
        if (z) {
            return d;
        }
        return Double.POSITIVE_INFINITY;
    }

    public static double NetworkUserEntityData$$ExternalSyntheticLambda1(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        for (int i = 0; i < length; i++) {
            dArr3[i] = (dArr[i] + dArr2[i]) / 2.0d;
        }
        return (initRecordTimeStamp(dArr, dArr3) + initRecordTimeStamp(dArr2, dArr3)) / 2.0d;
    }

    public static double DatabaseTableConfigUtil(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            double d3 = dArr2[i] + d2;
            if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                d += d2 * Math.log((2.0d * d2) / d3);
            }
        }
        return d;
    }

    public static double NetworkUserEntityData$$ExternalSyntheticLambda2(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d += (Math.pow((d2 * d2) - (d3 * d3), 2.0d) / 2.0d) * Math.pow(dArr[i] * dArr2[i], 1.5d);
                }
            }
        }
        return d;
    }

    public static double initRecordTimeStamp(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        boolean z = false;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    d += d2 * Math.log(d2 / d3);
                    z = true;
                }
            }
        }
        if (z) {
            return d;
        }
        return Double.POSITIVE_INFINITY;
    }

    public static double isLayoutRequested(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d += Math.abs(dArr[i] - dArr2[i]);
        }
        return d;
    }

    public static double PlaceComponentResult(double[] dArr, double[] dArr2, double d) {
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            d2 += Math.pow(Math.abs(dArr[i] - dArr2[i]), d);
        }
        return Math.pow(d2, 1.0d / d);
    }

    public static double newProxyInstance(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i] - dArr2[i];
            d += d2 * d2;
        }
        return d;
    }

    public static double PrepareContext(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            double d3 = dArr2[i];
            double d4 = d2 * d3;
            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d5 = d2 - d3;
                d += ((d5 * d5) * (d2 + d3)) / d4;
            }
        }
        return d;
    }

    public static double NetworkUserEntityData$$ExternalSyntheticLambda7(double[] dArr, double[] dArr2) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            d += (d2 - dArr2[i]) * (Math.log(d2) - Math.log(dArr2[i]));
        }
        return d;
    }

    public static double NetworkUserEntityData$$ExternalSyntheticLambda8(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double d4 = d2 + d3;
                    d += (d4 / 2.0d) * Math.log(d4 / (Math.sqrt(d2 * d3) * 2.0d));
                }
            }
        }
        return d;
    }

    public static double FragmentBottomSheetPaymentSettingBinding(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d3 = dArr2[i];
                if (d3 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    double d4 = d3 + d2;
                    double log = Math.log((d2 * 2.0d) / d4);
                    double d5 = dArr2[i];
                    d += (d2 * log) + (d5 * Math.log((2.0d * d5) / d4));
                }
            }
        }
        return d;
    }
}

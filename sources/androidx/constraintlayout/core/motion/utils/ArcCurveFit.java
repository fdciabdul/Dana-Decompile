package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ArcCurveFit extends CurveFit {
    private final double[] BuiltInFictitiousFunctionClassFactory;
    Arc[] KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult = true;

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void getAuthRequestContext(double d, double[] dArr) {
        if (!this.PlaceComponentResult) {
            if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
                d = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
            }
            Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (d > arcArr[arcArr.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Arc[] arcArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                d = arcArr2[arcArr2.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        } else if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
            double d2 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
            double d3 = d - this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2) {
                dArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2[0].getAuthRequestContext(d2) + (this.KClassImpl$Data$declaredNonStaticMembers$2[0].NetworkUserEntityData$$ExternalSyntheticLambda0 * d3);
                dArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2[0].PlaceComponentResult(d2) + (d3 * this.KClassImpl$Data$declaredNonStaticMembers$2[0].getErrorConfigVersion);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2(d2);
            Arc arc = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
            dArr[0] = arc.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc.getAuthRequestContext * arc.GetContactSyncConfig) + (this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2() * d3);
            Arc arc2 = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
            dArr[1] = arc2.getErrorConfigVersion + (arc2.BuiltInFictitiousFunctionClassFactory * arc2.initRecordTimeStamp) + (d3 * this.KClassImpl$Data$declaredNonStaticMembers$2[0].MyBillsEntityDataFactory());
            return;
        } else {
            Arc[] arcArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (d > arcArr3[arcArr3.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Arc[] arcArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                double d4 = arcArr4[arcArr4.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
                double d5 = d - d4;
                Arc[] arcArr5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int length = arcArr5.length - 1;
                if (arcArr5[length].KClassImpl$Data$declaredNonStaticMembers$2) {
                    dArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2[length].getAuthRequestContext(d4) + (this.KClassImpl$Data$declaredNonStaticMembers$2[length].NetworkUserEntityData$$ExternalSyntheticLambda0 * d5);
                    dArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2[length].PlaceComponentResult(d4) + (d5 * this.KClassImpl$Data$declaredNonStaticMembers$2[length].getErrorConfigVersion);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[length].KClassImpl$Data$declaredNonStaticMembers$2(d);
                Arc arc3 = this.KClassImpl$Data$declaredNonStaticMembers$2[length];
                dArr[0] = arc3.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc3.getAuthRequestContext * arc3.GetContactSyncConfig) + (this.KClassImpl$Data$declaredNonStaticMembers$2[length].KClassImpl$Data$declaredNonStaticMembers$2() * d5);
                Arc arc4 = this.KClassImpl$Data$declaredNonStaticMembers$2[length];
                dArr[1] = arc4.getErrorConfigVersion + (arc4.BuiltInFictitiousFunctionClassFactory * arc4.initRecordTimeStamp) + (d5 * this.KClassImpl$Data$declaredNonStaticMembers$2[length].MyBillsEntityDataFactory());
                return;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr6.length) {
                return;
            }
            if (d <= arcArr6[i].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2) {
                    dArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].getAuthRequestContext(d);
                    dArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].PlaceComponentResult(d);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2(d);
                Arc arc5 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
                dArr[0] = arc5.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc5.getAuthRequestContext * arc5.GetContactSyncConfig);
                Arc arc6 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
                dArr[1] = arc6.getErrorConfigVersion + (arc6.BuiltInFictitiousFunctionClassFactory * arc6.initRecordTimeStamp);
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void KClassImpl$Data$declaredNonStaticMembers$2(double d, float[] fArr) {
        if (this.PlaceComponentResult) {
            if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
                double d2 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
                double d3 = d - this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2) {
                    fArr[0] = (float) (this.KClassImpl$Data$declaredNonStaticMembers$2[0].getAuthRequestContext(d2) + (this.KClassImpl$Data$declaredNonStaticMembers$2[0].NetworkUserEntityData$$ExternalSyntheticLambda0 * d3));
                    fArr[1] = (float) (this.KClassImpl$Data$declaredNonStaticMembers$2[0].PlaceComponentResult(d2) + (d3 * this.KClassImpl$Data$declaredNonStaticMembers$2[0].getErrorConfigVersion));
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2(d2);
                Arc arc = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
                fArr[0] = (float) (arc.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc.getAuthRequestContext * arc.GetContactSyncConfig) + (this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2() * d3));
                Arc arc2 = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
                fArr[1] = (float) (arc2.getErrorConfigVersion + (arc2.BuiltInFictitiousFunctionClassFactory * arc2.initRecordTimeStamp) + (d3 * this.KClassImpl$Data$declaredNonStaticMembers$2[0].MyBillsEntityDataFactory()));
                return;
            }
            Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (d > arcArr[arcArr.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Arc[] arcArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                double d4 = arcArr2[arcArr2.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
                double d5 = d - d4;
                Arc[] arcArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int length = arcArr3.length - 1;
                if (arcArr3[length].KClassImpl$Data$declaredNonStaticMembers$2) {
                    fArr[0] = (float) (this.KClassImpl$Data$declaredNonStaticMembers$2[length].getAuthRequestContext(d4) + (this.KClassImpl$Data$declaredNonStaticMembers$2[length].NetworkUserEntityData$$ExternalSyntheticLambda0 * d5));
                    fArr[1] = (float) (this.KClassImpl$Data$declaredNonStaticMembers$2[length].PlaceComponentResult(d4) + (d5 * this.KClassImpl$Data$declaredNonStaticMembers$2[length].getErrorConfigVersion));
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[length].KClassImpl$Data$declaredNonStaticMembers$2(d);
                Arc arc3 = this.KClassImpl$Data$declaredNonStaticMembers$2[length];
                fArr[0] = (float) (arc3.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc3.getAuthRequestContext * arc3.GetContactSyncConfig));
                Arc arc4 = this.KClassImpl$Data$declaredNonStaticMembers$2[length];
                fArr[1] = (float) (arc4.getErrorConfigVersion + (arc4.BuiltInFictitiousFunctionClassFactory * arc4.initRecordTimeStamp));
                return;
            }
        } else if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
        } else {
            Arc[] arcArr4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (d > arcArr4[arcArr4.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Arc[] arcArr5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                d = arcArr5[arcArr5.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr6.length) {
                return;
            }
            if (d <= arcArr6[i].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2) {
                    fArr[0] = (float) this.KClassImpl$Data$declaredNonStaticMembers$2[i].getAuthRequestContext(d);
                    fArr[1] = (float) this.KClassImpl$Data$declaredNonStaticMembers$2[i].PlaceComponentResult(d);
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2(d);
                Arc arc5 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
                fArr[0] = (float) (arc5.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc5.getAuthRequestContext * arc5.GetContactSyncConfig));
                Arc arc6 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
                fArr[1] = (float) (arc6.getErrorConfigVersion + (arc6.BuiltInFictitiousFunctionClassFactory * arc6.initRecordTimeStamp));
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void PlaceComponentResult(double d, double[] dArr) {
        if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
        } else {
            Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (d > arcArr[arcArr.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                Arc[] arcArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                d = arcArr2[arcArr2.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr3.length) {
                return;
            }
            if (d <= arcArr3[i].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2) {
                    dArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].NetworkUserEntityData$$ExternalSyntheticLambda0;
                    dArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].getErrorConfigVersion;
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2(d);
                dArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2();
                dArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2[i].MyBillsEntityDataFactory();
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double getAuthRequestContext(double d) {
        double d2;
        double d3;
        double d4;
        int i = 0;
        if (this.PlaceComponentResult) {
            if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
                double d5 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
                d2 = d - this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2) {
                    d4 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].getAuthRequestContext(d5);
                    d3 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].NetworkUserEntityData$$ExternalSyntheticLambda0;
                } else {
                    this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2(d5);
                    Arc arc = this.KClassImpl$Data$declaredNonStaticMembers$2[0];
                    d4 = arc.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc.getAuthRequestContext * arc.GetContactSyncConfig);
                    d3 = this.KClassImpl$Data$declaredNonStaticMembers$2[0].KClassImpl$Data$declaredNonStaticMembers$2();
                }
            } else {
                if (d > this.KClassImpl$Data$declaredNonStaticMembers$2[r0.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    double d6 = this.KClassImpl$Data$declaredNonStaticMembers$2[r0.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
                    d2 = d - d6;
                    Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    int length = arcArr.length - 1;
                    double authRequestContext = arcArr[length].getAuthRequestContext(d6);
                    d3 = this.KClassImpl$Data$declaredNonStaticMembers$2[length].NetworkUserEntityData$$ExternalSyntheticLambda0;
                    d4 = authRequestContext;
                }
            }
            return d4 + (d2 * d3);
        } else if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
        } else {
            if (d > this.KClassImpl$Data$declaredNonStaticMembers$2[r0.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                d = this.KClassImpl$Data$declaredNonStaticMembers$2[r11.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }
        while (true) {
            Arc[] arcArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr2.length) {
                return Double.NaN;
            }
            if (d <= arcArr2[i].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2) {
                    return this.KClassImpl$Data$declaredNonStaticMembers$2[i].getAuthRequestContext(d);
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2(d);
                Arc arc2 = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
                return arc2.NetworkUserEntityData$$ExternalSyntheticLambda0 + (arc2.getAuthRequestContext * arc2.GetContactSyncConfig);
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double MyBillsEntityDataFactory(double d) {
        int i = 0;
        if (d < this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl) {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2[0].scheduleImpl;
        }
        if (d > this.KClassImpl$Data$declaredNonStaticMembers$2[r0.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2) {
            d = this.KClassImpl$Data$declaredNonStaticMembers$2[r5.length - 1].NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        while (true) {
            Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr.length) {
                return Double.NaN;
            }
            if (d <= arcArr[i].NetworkUserEntityData$$ExternalSyntheticLambda2) {
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2(d);
                    return this.KClassImpl$Data$declaredNonStaticMembers$2[i].KClassImpl$Data$declaredNonStaticMembers$2();
                }
                return this.KClassImpl$Data$declaredNonStaticMembers$2[i].NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.BuiltInFictitiousFunctionClassFactory = dArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Arc[dArr.length - 1];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            Arc[] arcArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= arcArr.length) {
                return;
            }
            int i4 = iArr[i];
            if (i4 == 0) {
                i3 = 3;
            } else if (i4 == 1) {
                i2 = 1;
                i3 = 1;
            } else if (i4 == 2) {
                i2 = 2;
                i3 = 2;
            } else if (i4 == 3) {
                i2 = i2 == 1 ? 2 : 1;
                i3 = i2;
            }
            double d = dArr[i];
            int i5 = i + 1;
            double d2 = dArr[i5];
            double[] dArr3 = dArr2[i];
            double d3 = dArr3[0];
            double d4 = dArr3[1];
            double[] dArr4 = dArr2[i5];
            arcArr[i] = new Arc(i3, d, d2, d3, d4, dArr4[0], dArr4[1]);
            i = i5;
        }
    }

    /* loaded from: classes3.dex */
    static class Arc {
        private static double[] newProxyInstance = new double[91];
        double BuiltInFictitiousFunctionClassFactory;
        boolean DatabaseTableConfigUtil;
        double GetContactSyncConfig;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        double MyBillsEntityDataFactory;
        double NetworkUserEntityData$$ExternalSyntheticLambda0;
        double NetworkUserEntityData$$ExternalSyntheticLambda1;
        double NetworkUserEntityData$$ExternalSyntheticLambda2;
        double NetworkUserEntityData$$ExternalSyntheticLambda7;
        double PlaceComponentResult;
        double PrepareContext;
        double getAuthRequestContext;
        double getErrorConfigVersion;
        double initRecordTimeStamp;
        double isLayoutRequested;
        double[] lookAheadTest;
        double moveToNextValue;
        double scheduleImpl;

        Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            double d7;
            double d8 = d3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            int i2 = 1;
            this.DatabaseTableConfigUtil = i == 1;
            this.scheduleImpl = d;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = d2;
            this.moveToNextValue = 1.0d / (d2 - d);
            if (3 == i) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            double d9 = d5 - d8;
            double d10 = d6 - d4;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 || Math.abs(d9) < 0.001d || Math.abs(d10) < 0.001d) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = d8;
                this.isLayoutRequested = d5;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = d4;
                this.PrepareContext = d6;
                double hypot = Math.hypot(d10, d9);
                this.PlaceComponentResult = hypot;
                this.MyBillsEntityDataFactory = hypot * this.moveToNextValue;
                double d11 = this.NetworkUserEntityData$$ExternalSyntheticLambda2 - this.scheduleImpl;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = d9 / d11;
                this.getErrorConfigVersion = d10 / d11;
                return;
            }
            this.lookAheadTest = new double[101];
            boolean z = this.DatabaseTableConfigUtil;
            double d12 = z ? -1 : 1;
            Double.isNaN(d12);
            this.getAuthRequestContext = d12 * d9;
            double d13 = z ? 1 : -1;
            Double.isNaN(d13);
            this.BuiltInFictitiousFunctionClassFactory = d10 * d13;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z ? d5 : d8;
            this.getErrorConfigVersion = z ? d4 : d6;
            int i3 = 0;
            double d14 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d15 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d16 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            while (true) {
                double[] dArr = newProxyInstance;
                if (i3 >= dArr.length) {
                    break;
                }
                double d17 = i3;
                double length = dArr.length - i2;
                Double.isNaN(d17);
                Double.isNaN(length);
                double radians = Math.toRadians((d17 * 90.0d) / length);
                double sin = Math.sin(radians) * d9;
                double cos = Math.cos(radians) * (d4 - d6);
                if (i3 > 0) {
                    d7 = sin;
                    d14 += Math.hypot(sin - d15, cos - d16);
                    newProxyInstance[i3] = d14;
                } else {
                    d7 = sin;
                }
                i3++;
                d15 = d7;
                d16 = cos;
                i2 = 1;
            }
            this.PlaceComponentResult = d14;
            int i4 = 0;
            while (true) {
                double[] dArr2 = newProxyInstance;
                if (i4 >= dArr2.length) {
                    break;
                }
                dArr2[i4] = dArr2[i4] / d14;
                i4++;
            }
            int i5 = 0;
            while (true) {
                double[] dArr3 = this.lookAheadTest;
                if (i5 >= dArr3.length) {
                    this.MyBillsEntityDataFactory = this.PlaceComponentResult * this.moveToNextValue;
                    return;
                }
                double d18 = i5;
                double length2 = dArr3.length - 1;
                Double.isNaN(d18);
                Double.isNaN(length2);
                double d19 = d18 / length2;
                int binarySearch = Arrays.binarySearch(newProxyInstance, d19);
                if (binarySearch >= 0) {
                    double[] dArr4 = this.lookAheadTest;
                    double d20 = binarySearch;
                    double length3 = newProxyInstance.length - 1;
                    Double.isNaN(d20);
                    Double.isNaN(length3);
                    dArr4[i5] = d20 / length3;
                } else if (binarySearch == -1) {
                    this.lookAheadTest[i5] = 0.0d;
                } else {
                    int i6 = -binarySearch;
                    int i7 = i6 - 2;
                    double d21 = i7;
                    double[] dArr5 = newProxyInstance;
                    double d22 = dArr5[i7];
                    double d23 = (d19 - d22) / (dArr5[i6 - 1] - d22);
                    double length4 = dArr5.length - 1;
                    Double.isNaN(d21);
                    Double.isNaN(length4);
                    this.lookAheadTest[i5] = (d21 + d23) / length4;
                }
                i5++;
            }
        }

        final void KClassImpl$Data$declaredNonStaticMembers$2(double d) {
            double MyBillsEntityDataFactory = MyBillsEntityDataFactory((this.DatabaseTableConfigUtil ? this.NetworkUserEntityData$$ExternalSyntheticLambda2 - d : d - this.scheduleImpl) * this.moveToNextValue) * 1.5707963267948966d;
            this.GetContactSyncConfig = Math.sin(MyBillsEntityDataFactory);
            this.initRecordTimeStamp = Math.cos(MyBillsEntityDataFactory);
        }

        final double KClassImpl$Data$declaredNonStaticMembers$2() {
            double d = this.getAuthRequestContext * this.initRecordTimeStamp;
            double hypot = this.MyBillsEntityDataFactory / Math.hypot(d, (-this.BuiltInFictitiousFunctionClassFactory) * this.GetContactSyncConfig);
            if (this.DatabaseTableConfigUtil) {
                d = -d;
            }
            return d * hypot;
        }

        final double MyBillsEntityDataFactory() {
            double d = this.getAuthRequestContext;
            double d2 = this.initRecordTimeStamp;
            double d3 = (-this.BuiltInFictitiousFunctionClassFactory) * this.GetContactSyncConfig;
            double hypot = this.MyBillsEntityDataFactory / Math.hypot(d * d2, d3);
            return this.DatabaseTableConfigUtil ? (-d3) * hypot : d3 * hypot;
        }

        public final double getAuthRequestContext(double d) {
            double d2 = this.scheduleImpl;
            double d3 = this.moveToNextValue;
            double d4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            return d4 + ((d - d2) * d3 * (this.isLayoutRequested - d4));
        }

        public final double PlaceComponentResult(double d) {
            double d2 = this.scheduleImpl;
            double d3 = this.moveToNextValue;
            double d4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            return d4 + ((d - d2) * d3 * (this.PrepareContext - d4));
        }

        private double MyBillsEntityDataFactory(double d) {
            if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.lookAheadTest;
            double length = (double) (dArr.length - 1);
            Double.isNaN(length);
            double d2 = d * length;
            int i = (int) d2;
            double d3 = i;
            double d4 = dArr[i];
            Double.isNaN(d3);
            return d4 + ((d2 - d3) * (dArr[i + 1] - d4));
        }
    }
}

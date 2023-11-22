package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.alipay.mobile.zebra.data.ZebraData;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static String[] MyBillsEntityDataFactory = {"position", "x", "y", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> BuiltInFictitiousFunctionClassFactory;
    float DatabaseTableConfigUtil;
    float GetContactSyncConfig;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    float NetworkUserEntityData$$ExternalSyntheticLambda0;
    double[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    MotionController NetworkUserEntityData$$ExternalSyntheticLambda2;
    public float NetworkUserEntityData$$ExternalSyntheticLambda7;
    public float NetworkUserEntityData$$ExternalSyntheticLambda8;
    float PlaceComponentResult;
    float PrepareContext;
    int getAuthRequestContext;
    int getErrorConfigVersion;
    double[] initRecordTimeStamp;
    float isLayoutRequested;
    int lookAheadTest;
    Easing moveToNextValue;
    float newProxyInstance;
    int scheduleImpl;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.PrepareContext, motionPaths.PrepareContext);
    }

    public MotionPaths() {
        this.getErrorConfigVersion = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.NaN;
        this.DatabaseTableConfigUtil = Float.NaN;
        this.scheduleImpl = Key.PlaceComponentResult;
        this.getAuthRequestContext = Key.PlaceComponentResult;
        this.GetContactSyncConfig = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap<>();
        this.lookAheadTest = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new double[18];
        this.initRecordTimeStamp = new double[18];
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f;
        this.getErrorConfigVersion = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.NaN;
        this.DatabaseTableConfigUtil = Float.NaN;
        this.scheduleImpl = Key.PlaceComponentResult;
        this.getAuthRequestContext = Key.PlaceComponentResult;
        this.GetContactSyncConfig = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap<>();
        this.lookAheadTest = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new double[18];
        this.initRecordTimeStamp = new double[18];
        if (motionPaths.getAuthRequestContext == Key.PlaceComponentResult) {
            int i3 = keyPosition.GetContactSyncConfig;
            if (i3 == 1) {
                float f2 = keyPosition.BuiltInFictitiousFunctionClassFactory / 100.0f;
                this.isLayoutRequested = f2;
                this.getErrorConfigVersion = keyPosition.getErrorConfigVersion;
                float f3 = Float.isNaN(keyPosition.initRecordTimeStamp) ? f2 : keyPosition.initRecordTimeStamp;
                float f4 = Float.isNaN(keyPosition.DatabaseTableConfigUtil) ? f2 : keyPosition.DatabaseTableConfigUtil;
                float f5 = motionPaths2.newProxyInstance;
                float f6 = motionPaths.newProxyInstance;
                float f7 = motionPaths2.PlaceComponentResult;
                float f8 = motionPaths.PlaceComponentResult;
                this.PrepareContext = this.isLayoutRequested;
                f2 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2) ? f2 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
                float f9 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f10 = motionPaths.newProxyInstance;
                float f11 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f12 = motionPaths.PlaceComponentResult;
                float f13 = (motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7 + (motionPaths2.newProxyInstance / 2.0f)) - ((f10 / 2.0f) + f9);
                float f14 = (motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8 + (motionPaths2.PlaceComponentResult / 2.0f)) - ((f12 / 2.0f) + f11);
                float f15 = f13 * f2;
                float f16 = ((f5 - f6) * f3) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (int) ((f9 + f15) - f16);
                float f17 = f2 * f14;
                float f18 = ((f7 - f8) * f4) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) ((f11 + f17) - f18);
                this.newProxyInstance = (int) (f10 + r7);
                this.PlaceComponentResult = (int) (f12 + r11);
                float f19 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1) ? 0.0f : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
                this.lookAheadTest = 1;
                float f20 = (int) ((motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 + f15) - f16);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = f20;
                float f21 = (int) ((motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 + f17) - f18);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = f20 + ((-f14) * f19);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = f21 + (f13 * f19);
                this.getAuthRequestContext = this.getAuthRequestContext;
                this.moveToNextValue = Easing.PlaceComponentResult(keyPosition.isLayoutRequested);
                this.scheduleImpl = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return;
            } else if (i3 != 2) {
                float f22 = keyPosition.BuiltInFictitiousFunctionClassFactory / 100.0f;
                this.isLayoutRequested = f22;
                this.getErrorConfigVersion = keyPosition.getErrorConfigVersion;
                float f23 = Float.isNaN(keyPosition.initRecordTimeStamp) ? f22 : keyPosition.initRecordTimeStamp;
                float f24 = Float.isNaN(keyPosition.DatabaseTableConfigUtil) ? f22 : keyPosition.DatabaseTableConfigUtil;
                float f25 = motionPaths2.newProxyInstance;
                float f26 = motionPaths.newProxyInstance;
                float f27 = motionPaths2.PlaceComponentResult;
                float f28 = motionPaths.PlaceComponentResult;
                this.PrepareContext = this.isLayoutRequested;
                float f29 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f30 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f31 = (motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7 + (f25 / 2.0f)) - ((f26 / 2.0f) + f29);
                float f32 = (motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8 + (f27 / 2.0f)) - (f30 + (f28 / 2.0f));
                float f33 = ((f25 - f26) * f23) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (int) ((f29 + (f31 * f22)) - f33);
                float f34 = ((f27 - f28) * f24) / 2.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) ((f30 + (f32 * f22)) - f34);
                this.newProxyInstance = (int) (f26 + r9);
                this.PlaceComponentResult = (int) (f28 + r12);
                float f35 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2) ? f22 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
                float f36 = Float.isNaN(keyPosition.lookAheadTest) ? 0.0f : keyPosition.lookAheadTest;
                f22 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1) ? f22 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
                float f37 = !Float.isNaN(keyPosition.moveToNextValue) ? keyPosition.moveToNextValue : 0.0f;
                this.lookAheadTest = 0;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (int) (((motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7 + (f35 * f31)) + (f37 * f32)) - f33);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) (((motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8 + (f31 * f36)) + (f32 * f22)) - f34);
                this.moveToNextValue = Easing.PlaceComponentResult(keyPosition.isLayoutRequested);
                this.scheduleImpl = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return;
            } else {
                float f38 = keyPosition.BuiltInFictitiousFunctionClassFactory / 100.0f;
                this.isLayoutRequested = f38;
                this.getErrorConfigVersion = keyPosition.getErrorConfigVersion;
                float f39 = Float.isNaN(keyPosition.initRecordTimeStamp) ? f38 : keyPosition.initRecordTimeStamp;
                float f40 = Float.isNaN(keyPosition.DatabaseTableConfigUtil) ? f38 : keyPosition.DatabaseTableConfigUtil;
                float f41 = motionPaths2.newProxyInstance;
                float f42 = motionPaths.newProxyInstance;
                float f43 = motionPaths2.PlaceComponentResult;
                float f44 = motionPaths.PlaceComponentResult;
                this.PrepareContext = this.isLayoutRequested;
                float f45 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f46 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f47 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f48 = f41 / 2.0f;
                float f49 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f50 = f43 / 2.0f;
                float f51 = (f41 - f42) * f39;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (int) ((f45 + (((f47 + f48) - ((f42 / 2.0f) + f45)) * f38)) - (f51 / 2.0f));
                float f52 = (f43 - f44) * f40;
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) ((f46 + (((f49 + f50) - ((f44 / 2.0f) + f46)) * f38)) - (f52 / 2.0f));
                this.newProxyInstance = (int) (f42 + f51);
                this.PlaceComponentResult = (int) (f44 + f52);
                this.lookAheadTest = 2;
                if (!Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (int) (keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2 * ((int) (i - this.newProxyInstance)));
                }
                if (!Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (int) (keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1 * ((int) (i2 - this.PlaceComponentResult)));
                }
                this.getAuthRequestContext = this.getAuthRequestContext;
                this.moveToNextValue = Easing.PlaceComponentResult(keyPosition.isLayoutRequested);
                this.scheduleImpl = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return;
            }
        }
        float f53 = keyPosition.BuiltInFictitiousFunctionClassFactory / 100.0f;
        this.isLayoutRequested = f53;
        this.getErrorConfigVersion = keyPosition.getErrorConfigVersion;
        this.lookAheadTest = keyPosition.GetContactSyncConfig;
        float f54 = Float.isNaN(keyPosition.initRecordTimeStamp) ? f53 : keyPosition.initRecordTimeStamp;
        float f55 = Float.isNaN(keyPosition.DatabaseTableConfigUtil) ? f53 : keyPosition.DatabaseTableConfigUtil;
        float f56 = motionPaths2.newProxyInstance;
        float f57 = motionPaths.newProxyInstance;
        float f58 = motionPaths2.PlaceComponentResult;
        float f59 = motionPaths.PlaceComponentResult;
        this.PrepareContext = this.isLayoutRequested;
        this.newProxyInstance = (int) (f57 + ((f56 - f57) * f54));
        this.PlaceComponentResult = (int) (f59 + ((f58 - f59) * f55));
        int i4 = keyPosition.GetContactSyncConfig;
        if (i4 == 1) {
            float f60 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2) ? f53 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float f61 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7;
            float f62 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (f60 * (f61 - f62)) + f62;
            f53 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1) ? f53 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
            float f63 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            float f64 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (f53 * (f63 - f64)) + f64;
        } else if (i4 == 2) {
            if (Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                float f65 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                float f66 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
                min = ((f65 - f66) * f53) + f66;
            } else {
                min = Math.min(f55, f54) * keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = min;
            if (Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                float f67 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                float f68 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
                f = (f53 * (f67 - f68)) + f68;
            } else {
                f = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = f;
        } else {
            float f69 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2) ? f53 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float f70 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda7;
            float f71 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (f69 * (f70 - f71)) + f71;
            f53 = Float.isNaN(keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1) ? f53 : keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
            float f72 = motionPaths2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            float f73 = motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (f53 * (f72 - f73)) + f73;
        }
        this.getAuthRequestContext = motionPaths.getAuthRequestContext;
        this.moveToNextValue = Easing.PlaceComponentResult(keyPosition.isLayoutRequested);
        this.scheduleImpl = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final void PlaceComponentResult(MotionController motionController, MotionPaths motionPaths) {
        double d = ((this.NetworkUserEntityData$$ExternalSyntheticLambda7 + (this.newProxyInstance / 2.0f)) - motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda7) - (motionPaths.newProxyInstance / 2.0f);
        double d2 = ((this.NetworkUserEntityData$$ExternalSyntheticLambda8 + (this.PlaceComponentResult / 2.0f)) - motionPaths.NetworkUserEntityData$$ExternalSyntheticLambda8) - (motionPaths.PlaceComponentResult / 2.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = motionController;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.GetContactSyncConfig)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (float) Math.toRadians(this.GetContactSyncConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        float f3 = this.newProxyInstance;
        float f4 = this.PlaceComponentResult;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        MotionController motionController = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.MyBillsEntityDataFactory(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            double sin = Math.sin(d4);
            double d5 = f3 / 2.0f;
            Double.isNaN(d3);
            Double.isNaN(d2);
            Double.isNaN(d5);
            float f8 = (float) ((d2 + (sin * d3)) - d5);
            double d6 = f7;
            double cos = Math.cos(d4);
            double d7 = f4 / 2.0f;
            Double.isNaN(d3);
            Double.isNaN(d6);
            Double.isNaN(d7);
            f = f8;
            f2 = (float) ((d6 - (d3 * cos)) - d7);
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((f4 * 0.0f) / 2.0f);
        float f9 = f5 - ((f6 * 0.0f) / 2.0f);
        fArr[0] = ((1.0f - f) * f8) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = ((1.0f - f2) * f9) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return this.BuiltInFictitiousFunctionClassFactory.containsKey(str);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ConstraintSet.Constraint constraint) {
        this.moveToNextValue = Easing.PlaceComponentResult(constraint.getErrorConfigVersion.DatabaseTableConfigUtil);
        this.scheduleImpl = constraint.getErrorConfigVersion.moveToNextValue;
        this.getAuthRequestContext = constraint.getErrorConfigVersion.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraint.getErrorConfigVersion.lookAheadTest;
        this.getErrorConfigVersion = constraint.getErrorConfigVersion.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraint.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
        this.DatabaseTableConfigUtil = constraint.scheduleImpl.getAuthRequestContext;
        this.GetContactSyncConfig = constraint.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
        for (String str : constraint.PlaceComponentResult.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.PlaceComponentResult.get(str);
            if (constraintAttribute != null && constraintAttribute.MyBillsEntityDataFactory()) {
                this.BuiltInFictitiousFunctionClassFactory.put(str, constraintAttribute);
            }
        }
    }
}

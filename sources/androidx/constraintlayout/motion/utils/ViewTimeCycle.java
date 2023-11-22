package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    public abstract boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache);

    public final float PlaceComponentResult(float f, long j, View view, KeyCache keyCache) {
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(f, this.getAuthRequestContext);
        boolean z = true;
        float f2 = this.getAuthRequestContext[1];
        if (f2 == 0.0f) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            return this.getAuthRequestContext[2];
        }
        if (Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
            this.BuiltInFictitiousFunctionClassFactory = keyCache.BuiltInFictitiousFunctionClassFactory(view, this.moveToNextValue);
            if (Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
                this.BuiltInFictitiousFunctionClassFactory = 0.0f;
            }
        }
        long j2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        double d = this.BuiltInFictitiousFunctionClassFactory;
        double d2 = j - j2;
        double d3 = f2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d);
        this.BuiltInFictitiousFunctionClassFactory = (float) ((d + ((d2 * 1.0E-9d) * d3)) % 1.0d);
        String str = this.moveToNextValue;
        float f3 = this.BuiltInFictitiousFunctionClassFactory;
        if (!keyCache.MyBillsEntityDataFactory.containsKey(view)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            hashMap.put(str, new float[]{f3});
            keyCache.MyBillsEntityDataFactory.put(view, hashMap);
        } else {
            HashMap<String, float[]> hashMap2 = keyCache.MyBillsEntityDataFactory.get(view);
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>();
            }
            if (!hashMap2.containsKey(str)) {
                hashMap2.put(str, new float[]{f3});
                keyCache.MyBillsEntityDataFactory.put(view, hashMap2);
            } else {
                float[] fArr = hashMap2.get(str);
                if (fArr == null) {
                    fArr = new float[0];
                }
                if (fArr.length <= 0) {
                    fArr = Arrays.copyOf(fArr, 1);
                }
                fArr[0] = f3;
                hashMap2.put(str, fArr);
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        float f4 = this.getAuthRequestContext[0];
        float BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        float f5 = this.getAuthRequestContext[2];
        if (f4 == 0.0f && f2 == 0.0f) {
            z = false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        return (BuiltInFictitiousFunctionClassFactory * f4) + f5;
    }

    public static ViewTimeCycle getAuthRequestContext(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ViewTimeCycle MyBillsEntityDataFactory(String str, long j) {
        char c;
        ViewTimeCycle rotationXset;
        str.hashCode();
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.getAuthRequestContext(j);
        return rotationXset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(PlaceComponentResult(f, j, view, keyCache));
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* loaded from: classes3.dex */
    public static class PathRotate extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(PlaceComponentResult(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(PlaceComponentResult(f, j, view, keyCache));
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(PlaceComponentResult(f, j, view, keyCache));
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* loaded from: classes3.dex */
    public static class CustomSet extends ViewTimeCycle {
        SparseArray<ConstraintAttribute> GetContactSyncConfig;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        String NetworkUserEntityData$$ExternalSyntheticLambda2;
        float[] initRecordTimeStamp;
        SparseArray<float[]> newProxyInstance = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str.split(",")[1];
            this.GetContactSyncConfig = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void PlaceComponentResult(int i) {
            int size = this.GetContactSyncConfig.size();
            int i2 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[this.GetContactSyncConfig.valueAt(0).NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
            int i3 = 4;
            if (i2 != 4 && i2 != 5) {
                i3 = 1;
            }
            double[] dArr = new double[size];
            int i4 = i3 + 2;
            this.initRecordTimeStamp = new float[i4];
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[i3];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i4);
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.GetContactSyncConfig.keyAt(i5);
                ConstraintAttribute valueAt = this.GetContactSyncConfig.valueAt(i5);
                float[] valueAt2 = this.newProxyInstance.valueAt(i5);
                double d = keyAt;
                Double.isNaN(d);
                dArr[i5] = d * 0.01d;
                valueAt.getAuthRequestContext(this.initRecordTimeStamp);
                int i6 = 0;
                while (true) {
                    if (i6 < this.initRecordTimeStamp.length) {
                        dArr2[i5][i6] = r8[i6];
                        i6++;
                    }
                }
                double[] dArr3 = dArr2[i5];
                dArr3[i3] = valueAt2[0];
                dArr3[i3 + 1] = valueAt2[1];
            }
            this.lookAheadTest = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void MyBillsEntityDataFactory(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public final void getAuthRequestContext(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.GetContactSyncConfig.append(i, constraintAttribute);
            this.newProxyInstance.append(i, new float[]{f, f2});
            this.DatabaseTableConfigUtil = Math.max(this.DatabaseTableConfigUtil, i2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(f, this.initRecordTimeStamp);
            float[] fArr = this.initRecordTimeStamp;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
                this.BuiltInFictitiousFunctionClassFactory = keyCache.BuiltInFictitiousFunctionClassFactory(view, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                if (Float.isNaN(this.BuiltInFictitiousFunctionClassFactory)) {
                    this.BuiltInFictitiousFunctionClassFactory = 0.0f;
                }
            }
            double d = this.BuiltInFictitiousFunctionClassFactory;
            double d2 = j - j2;
            double d3 = f2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d);
            this.BuiltInFictitiousFunctionClassFactory = (float) ((d + ((d2 * 1.0E-9d) * d3)) % 1.0d);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            float BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda1.length; i++) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 |= ((double) this.initRecordTimeStamp[i]) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1[i] = (this.initRecordTimeStamp[i] * BuiltInFictitiousFunctionClassFactory) + f3;
            }
            CustomSupport.getAuthRequestContext(this.GetContactSyncConfig.valueAt(0), view, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            if (f2 != 0.0f) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ProgressSet extends ViewTimeCycle {
        boolean GetContactSyncConfig = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean MyBillsEntityDataFactory(View view, float f, long j, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(PlaceComponentResult(f, j, view, keyCache));
            } else if (this.GetContactSyncConfig) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.GetContactSyncConfig = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(PlaceComponentResult(f, j, view, keyCache)));
                    } catch (IllegalAccessException e) {
                        InstrumentInjector.log_e("ViewTimeCycle", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        InstrumentInjector.log_e("ViewTimeCycle", "unable to setProgress", e2);
                    }
                }
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
    }
}

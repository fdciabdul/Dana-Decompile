package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class ViewSpline extends SplineSet {

    /* loaded from: classes3.dex */
    public static class PathRotate extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
        }
    }

    public abstract void MyBillsEntityDataFactory(View view, float f);

    public static ViewSpline PlaceComponentResult(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ViewSpline KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        char c;
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
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
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case '\b':
                return new AlphaSet();
            case '\t':
                return new PivotXset();
            case '\n':
                return new PivotYset();
            case 11:
                return new RotationSet();
            case '\f':
                return new ElevationSet();
            case '\r':
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(PlaceComponentResult(f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setAlpha(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotation(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotationX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotationY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setPivotX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setPivotY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setScaleX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setScaleY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setTranslationX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setTranslationY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(PlaceComponentResult(f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class CustomSet extends ViewSpline {
        String BuiltInFictitiousFunctionClassFactory;
        float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        public SparseArray<ConstraintAttribute> moveToNextValue;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.BuiltInFictitiousFunctionClassFactory = str.split(",")[1];
            this.moveToNextValue = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i) {
            int size = this.moveToNextValue.size();
            int i2 = ConstraintAttribute.AnonymousClass1.PlaceComponentResult[this.moveToNextValue.valueAt(0).NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
            int i3 = 4;
            if (i2 != 4 && i2 != 5) {
                i3 = 1;
            }
            double[] dArr = new double[size];
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[i3];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.moveToNextValue.keyAt(i4);
                ConstraintAttribute valueAt = this.moveToNextValue.valueAt(i4);
                double d = keyAt;
                Double.isNaN(d);
                dArr[i4] = d * 0.01d;
                valueAt.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                int i5 = 0;
                while (true) {
                    if (i5 < this.NetworkUserEntityData$$ExternalSyntheticLambda0.length) {
                        dArr2[i4][i5] = r6[i5];
                        i5++;
                    }
                }
            }
            this.getAuthRequestContext = CurveFit.PlaceComponentResult(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void MyBillsEntityDataFactory(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(f, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            CustomSupport.getAuthRequestContext(this.moveToNextValue.valueAt(0), view, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ProgressSet extends ViewSpline {
        boolean BuiltInFictitiousFunctionClassFactory = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(PlaceComponentResult(f));
            } else if (this.BuiltInFictitiousFunctionClassFactory) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.BuiltInFictitiousFunctionClassFactory = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(PlaceComponentResult(f)));
                    } catch (IllegalAccessException e) {
                        InstrumentInjector.log_e("ViewSpline", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        InstrumentInjector.log_e("ViewSpline", "unable to setProgress", e2);
                    }
                }
            }
        }
    }
}

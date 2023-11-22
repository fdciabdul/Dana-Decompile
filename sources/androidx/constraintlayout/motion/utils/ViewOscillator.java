package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {

    /* loaded from: classes3.dex */
    public static class PathRotateSet extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
        }
    }

    public abstract void MyBillsEntityDataFactory(View view, float f);

    public static ViewOscillator BuiltInFictitiousFunctionClassFactory(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c = '\b';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\r';
                    break;
                }
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
                return new RotationSet();
            case '\n':
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case '\f':
                return new AlphaSet();
            case '\r':
                return new AlphaSet();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(PlaceComponentResult(f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setAlpha(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotation(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotationX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setRotationY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setScaleX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setScaleY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setTranslationX(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            view.setTranslationY(PlaceComponentResult(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(PlaceComponentResult(f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CustomSet extends ViewOscillator {
        protected ConstraintAttribute lookAheadTest;
        float[] scheduleImpl = new float[1];

        CustomSet() {
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
            this.lookAheadTest = (ConstraintAttribute) obj;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            this.scheduleImpl[0] = PlaceComponentResult(f);
            CustomSupport.getAuthRequestContext(this.lookAheadTest, view, this.scheduleImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ProgressSet extends ViewOscillator {
        boolean lookAheadTest = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void MyBillsEntityDataFactory(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(PlaceComponentResult(f));
            } else if (this.lookAheadTest) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.lookAheadTest = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(PlaceComponentResult(f)));
                    } catch (IllegalAccessException e) {
                        InstrumentInjector.log_e("ViewOscillator", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        InstrumentInjector.log_e("ViewOscillator", "unable to setProgress", e2);
                    }
                }
            }
        }
    }
}

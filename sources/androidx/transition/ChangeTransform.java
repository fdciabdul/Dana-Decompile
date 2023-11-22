package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public class ChangeTransform extends Transition {
    private static final boolean PlaceComponentResult;
    boolean MyBillsEntityDataFactory;
    private Matrix lookAheadTest;
    private boolean scheduleImpl;
    private static final String[] BuiltInFictitiousFunctionClassFactory = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<PathAnimatorMatrix, float[]> getAuthRequestContext = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public /* synthetic */ void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            PathAnimatorMatrix pathAnimatorMatrix2 = pathAnimatorMatrix;
            float[] fArr2 = fArr;
            System.arraycopy(fArr2, 0, pathAnimatorMatrix2.KClassImpl$Data$declaredNonStaticMembers$2, 0, fArr2.length);
            pathAnimatorMatrix2.BuiltInFictitiousFunctionClassFactory();
        }
    };
    private static final Property<PathAnimatorMatrix, PointF> KClassImpl$Data$declaredNonStaticMembers$2 = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public /* synthetic */ void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            PathAnimatorMatrix pathAnimatorMatrix2 = pathAnimatorMatrix;
            PointF pointF2 = pointF;
            pathAnimatorMatrix2.MyBillsEntityDataFactory = pointF2.x;
            pathAnimatorMatrix2.PlaceComponentResult = pointF2.y;
            pathAnimatorMatrix2.BuiltInFictitiousFunctionClassFactory();
        }
    };

    static {
        PlaceComponentResult = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.MyBillsEntityDataFactory = true;
        this.scheduleImpl = true;
        this.lookAheadTest = new Matrix();
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = true;
        this.scheduleImpl = true;
        this.lookAheadTest = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.MyBillsEntityDataFactory);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.MyBillsEntityDataFactory = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.scheduleImpl = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TransitionValues transitionValues) {
        View view = transitionValues.MyBillsEntityDataFactory;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.getAuthRequestContext.put("android:changeTransform:parent", view.getParent());
        transitionValues.getAuthRequestContext.put("android:changeTransform:transforms", new Transforms(view));
        Matrix matrix = view.getMatrix();
        transitionValues.getAuthRequestContext.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.scheduleImpl) {
            Matrix matrix2 = new Matrix();
            ViewUtils.MyBillsEntityDataFactory((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            transitionValues.getAuthRequestContext.put("android:changeTransform:parentMatrix", matrix2);
            transitionValues.getAuthRequestContext.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.getErrorConfigVersion));
            transitionValues.getAuthRequestContext.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.BuiltInFictitiousFunctionClassFactory));
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
        if (PlaceComponentResult) {
            return;
        }
        ((ViewGroup) transitionValues.MyBillsEntityDataFactory.getParent()).startViewTransition(transitionValues.MyBillsEntityDataFactory);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewGroup viewGroup2;
        Object obj;
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && transitionValues.getAuthRequestContext.containsKey("android:changeTransform:parent") && transitionValues2.getAuthRequestContext.containsKey("android:changeTransform:parent")) {
            ViewGroup viewGroup3 = (ViewGroup) transitionValues.getAuthRequestContext.get("android:changeTransform:parent");
            boolean z = this.scheduleImpl && !BuiltInFictitiousFunctionClassFactory(viewGroup3, (ViewGroup) transitionValues2.getAuthRequestContext.get("android:changeTransform:parent"));
            Matrix matrix = (Matrix) transitionValues.getAuthRequestContext.get("android:changeTransform:intermediateMatrix");
            if (matrix != null) {
                transitionValues.getAuthRequestContext.put("android:changeTransform:matrix", matrix);
            }
            Matrix matrix2 = (Matrix) transitionValues.getAuthRequestContext.get("android:changeTransform:intermediateParentMatrix");
            if (matrix2 != null) {
                transitionValues.getAuthRequestContext.put("android:changeTransform:parentMatrix", matrix2);
            }
            if (z) {
                Matrix matrix3 = (Matrix) transitionValues2.getAuthRequestContext.get("android:changeTransform:parentMatrix");
                transitionValues2.MyBillsEntityDataFactory.setTag(R.id.BuiltInFictitiousFunctionClassFactory, matrix3);
                Matrix matrix4 = this.lookAheadTest;
                matrix4.reset();
                matrix3.invert(matrix4);
                Matrix matrix5 = (Matrix) transitionValues.getAuthRequestContext.get("android:changeTransform:matrix");
                if (matrix5 == null) {
                    matrix5 = new Matrix();
                    transitionValues.getAuthRequestContext.put("android:changeTransform:matrix", matrix5);
                }
                matrix5.postConcat((Matrix) transitionValues.getAuthRequestContext.get("android:changeTransform:parentMatrix"));
                matrix5.postConcat(matrix4);
            }
            Matrix matrix6 = (Matrix) transitionValues.getAuthRequestContext.get("android:changeTransform:matrix");
            Matrix matrix7 = (Matrix) transitionValues2.getAuthRequestContext.get("android:changeTransform:matrix");
            if (matrix6 == null) {
                matrix6 = MatrixUtils.getAuthRequestContext;
            }
            if (matrix7 == null) {
                matrix7 = MatrixUtils.getAuthRequestContext;
            }
            final Matrix matrix8 = matrix7;
            if (matrix6.equals(matrix8)) {
                obj = "android:changeTransform:parent";
                viewGroup2 = viewGroup3;
            } else {
                final Transforms transforms = (Transforms) transitionValues2.getAuthRequestContext.get("android:changeTransform:transforms");
                final View view = transitionValues2.MyBillsEntityDataFactory;
                BuiltInFictitiousFunctionClassFactory(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
                float[] fArr = new float[9];
                matrix6.getValues(fArr);
                float[] fArr2 = new float[9];
                matrix8.getValues(fArr2);
                final PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
                viewGroup2 = viewGroup3;
                obj = "android:changeTransform:parent";
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(getAuthRequestContext, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
                final boolean z2 = z;
                AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeTransform.3
                    private boolean moveToNextValue;
                    private Matrix scheduleImpl = new Matrix();

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.moveToNextValue = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.moveToNextValue) {
                            if (z2 && ChangeTransform.this.MyBillsEntityDataFactory) {
                                getAuthRequestContext(matrix8);
                            } else {
                                view.setTag(R.id.getErrorConfigVersion, null);
                                view.setTag(R.id.BuiltInFictitiousFunctionClassFactory, null);
                            }
                        }
                        ViewUtils.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(view, null);
                        transforms.BuiltInFictitiousFunctionClassFactory(view);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                    public void onAnimationPause(Animator animator) {
                        getAuthRequestContext(pathAnimatorMatrix.getAuthRequestContext);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                    public void onAnimationResume(Animator animator) {
                        ChangeTransform.MyBillsEntityDataFactory(view);
                    }

                    private void getAuthRequestContext(Matrix matrix9) {
                        this.scheduleImpl.set(matrix9);
                        view.setTag(R.id.getErrorConfigVersion, this.scheduleImpl);
                        transforms.BuiltInFictitiousFunctionClassFactory(view);
                    }
                };
                ofPropertyValuesHolder.addListener(animatorListenerAdapter);
                AnimatorUtils.KClassImpl$Data$declaredNonStaticMembers$2(ofPropertyValuesHolder, animatorListenerAdapter);
                objectAnimator = ofPropertyValuesHolder;
            }
            if (!z || objectAnimator == null || !this.MyBillsEntityDataFactory) {
                if (!PlaceComponentResult) {
                    viewGroup2.endViewTransition(transitionValues.MyBillsEntityDataFactory);
                }
            } else {
                View view2 = transitionValues2.MyBillsEntityDataFactory;
                Matrix matrix9 = new Matrix((Matrix) transitionValues2.getAuthRequestContext.get("android:changeTransform:parentMatrix"));
                ViewUtils.BuiltInFictitiousFunctionClassFactory(viewGroup, matrix9);
                GhostView KClassImpl$Data$declaredNonStaticMembers$22 = GhostViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(view2, viewGroup, matrix9);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory((ViewGroup) transitionValues.getAuthRequestContext.get(obj), transitionValues.MyBillsEntityDataFactory);
                    Transition transition = this;
                    while (transition.mParent != null) {
                        transition = transition.mParent;
                    }
                    transition.addListener(new GhostListener(view2, KClassImpl$Data$declaredNonStaticMembers$22));
                    if (PlaceComponentResult) {
                        if (transitionValues.MyBillsEntityDataFactory != transitionValues2.MyBillsEntityDataFactory) {
                            ViewUtils.MyBillsEntityDataFactory(transitionValues.MyBillsEntityDataFactory, 0.0f);
                        }
                        ViewUtils.MyBillsEntityDataFactory(view2, 1.0f);
                    }
                }
            }
        }
        return objectAnimator;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            TransitionValues matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null || viewGroup2 != matchedTransitionValues.MyBillsEntityDataFactory) {
                return false;
            }
        } else if (viewGroup != viewGroup2) {
            return false;
        }
        return true;
    }

    static void MyBillsEntityDataFactory(View view) {
        BuiltInFictitiousFunctionClassFactory(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void BuiltInFictitiousFunctionClassFactory(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.getAuthRequestContext(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Transforms {
        final float BuiltInFictitiousFunctionClassFactory;
        final float KClassImpl$Data$declaredNonStaticMembers$2;
        final float MyBillsEntityDataFactory;
        final float NetworkUserEntityData$$ExternalSyntheticLambda0;
        final float PlaceComponentResult;
        final float getAuthRequestContext;
        final float lookAheadTest;
        final float moveToNextValue;

        Transforms(View view) {
            this.lookAheadTest = view.getTranslationX();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view.getTranslationY();
            this.moveToNextValue = ViewCompat.readMicros(view);
            this.BuiltInFictitiousFunctionClassFactory = view.getScaleX();
            this.getAuthRequestContext = view.getScaleY();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = view.getRotationX();
            this.PlaceComponentResult = view.getRotationY();
            this.MyBillsEntityDataFactory = view.getRotation();
        }

        public final void BuiltInFictitiousFunctionClassFactory(View view) {
            ChangeTransform.BuiltInFictitiousFunctionClassFactory(view, this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Transforms) {
                Transforms transforms = (Transforms) obj;
                return transforms.lookAheadTest == this.lookAheadTest && transforms.NetworkUserEntityData$$ExternalSyntheticLambda0 == this.NetworkUserEntityData$$ExternalSyntheticLambda0 && transforms.moveToNextValue == this.moveToNextValue && transforms.BuiltInFictitiousFunctionClassFactory == this.BuiltInFictitiousFunctionClassFactory && transforms.getAuthRequestContext == this.getAuthRequestContext && transforms.KClassImpl$Data$declaredNonStaticMembers$2 == this.KClassImpl$Data$declaredNonStaticMembers$2 && transforms.PlaceComponentResult == this.PlaceComponentResult && transforms.MyBillsEntityDataFactory == this.MyBillsEntityDataFactory;
            }
            return false;
        }

        public int hashCode() {
            float f = this.lookAheadTest;
            int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int floatToIntBits2 = f2 != 0.0f ? Float.floatToIntBits(f2) : 0;
            float f3 = this.moveToNextValue;
            int floatToIntBits3 = f3 != 0.0f ? Float.floatToIntBits(f3) : 0;
            float f4 = this.BuiltInFictitiousFunctionClassFactory;
            int floatToIntBits4 = f4 != 0.0f ? Float.floatToIntBits(f4) : 0;
            float f5 = this.getAuthRequestContext;
            int floatToIntBits5 = f5 != 0.0f ? Float.floatToIntBits(f5) : 0;
            float f6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int floatToIntBits6 = f6 != 0.0f ? Float.floatToIntBits(f6) : 0;
            float f7 = this.PlaceComponentResult;
            int floatToIntBits7 = f7 != 0.0f ? Float.floatToIntBits(f7) : 0;
            float f8 = this.MyBillsEntityDataFactory;
            return (((((((((((((floatToIntBits * 31) + floatToIntBits2) * 31) + floatToIntBits3) * 31) + floatToIntBits4) * 31) + floatToIntBits5) * 31) + floatToIntBits6) * 31) + floatToIntBits7) * 31) + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    /* loaded from: classes6.dex */
    static class GhostListener extends TransitionListenerAdapter {
        private GhostView MyBillsEntityDataFactory;
        private View getAuthRequestContext;

        GhostListener(View view, GhostView ghostView) {
            this.getAuthRequestContext = view;
            this.MyBillsEntityDataFactory = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            this.getAuthRequestContext.setTag(R.id.getErrorConfigVersion, null);
            this.getAuthRequestContext.setTag(R.id.BuiltInFictitiousFunctionClassFactory, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            this.MyBillsEntityDataFactory.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            this.MyBillsEntityDataFactory.setVisibility(0);
        }
    }

    /* loaded from: classes6.dex */
    static class PathAnimatorMatrix {
        private final View BuiltInFictitiousFunctionClassFactory;
        final float[] KClassImpl$Data$declaredNonStaticMembers$2;
        float MyBillsEntityDataFactory;
        float PlaceComponentResult;
        final Matrix getAuthRequestContext = new Matrix();

        PathAnimatorMatrix(View view, float[] fArr) {
            this.BuiltInFictitiousFunctionClassFactory = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = fArr2;
            this.MyBillsEntityDataFactory = fArr2[2];
            this.PlaceComponentResult = fArr2[5];
            BuiltInFictitiousFunctionClassFactory();
        }

        final void BuiltInFictitiousFunctionClassFactory() {
            float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            fArr[2] = this.MyBillsEntityDataFactory;
            fArr[5] = this.PlaceComponentResult;
            this.getAuthRequestContext.setValues(fArr);
            ViewUtils.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
        }
    }
}

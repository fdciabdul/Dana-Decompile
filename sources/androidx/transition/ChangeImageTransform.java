package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.TransitionUtils;
import java.util.Map;

/* loaded from: classes6.dex */
public class ChangeImageTransform extends Transition {
    private static final String[] BuiltInFictitiousFunctionClassFactory = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> getAuthRequestContext = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> MyBillsEntityDataFactory = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public /* synthetic */ void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.MyBillsEntityDataFactory(imageView, matrix);
        }
    };

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void BuiltInFictitiousFunctionClassFactory(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.MyBillsEntityDataFactory;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = transitionValues.getAuthRequestContext;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                int i = AnonymousClass3.MyBillsEntityDataFactory[imageView.getScaleType().ordinal()];
                if (i == 1) {
                    Drawable drawable2 = imageView.getDrawable();
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(imageView.getWidth() / drawable2.getIntrinsicWidth(), imageView.getHeight() / drawable2.getIntrinsicHeight());
                    matrix = matrix2;
                } else if (i != 2) {
                    matrix = new Matrix(imageView.getImageMatrix());
                } else {
                    Drawable drawable3 = imageView.getDrawable();
                    int intrinsicWidth = drawable3.getIntrinsicWidth();
                    float width = imageView.getWidth();
                    float f = intrinsicWidth;
                    int intrinsicHeight = drawable3.getIntrinsicHeight();
                    float height = imageView.getHeight();
                    float f2 = intrinsicHeight;
                    float max = Math.max(width / f, height / f2);
                    int round = Math.round((width - (f * max)) / 2.0f);
                    int round2 = Math.round((height - (f2 * max)) / 2.0f);
                    Matrix matrix3 = new Matrix();
                    matrix3.postScale(max, max);
                    matrix3.postTranslate(round, round2);
                    matrix = matrix3;
                }
            } else {
                matrix = new Matrix(imageView.getImageMatrix());
            }
            map.put("android:changeImageTransform:matrix", matrix);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        BuiltInFictitiousFunctionClassFactory(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        BuiltInFictitiousFunctionClassFactory(transitionValues);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.getAuthRequestContext.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) transitionValues2.getAuthRequestContext.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.getAuthRequestContext.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) transitionValues2.getAuthRequestContext.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.MyBillsEntityDataFactory;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) MyBillsEntityDataFactory, (TypeEvaluator) getAuthRequestContext, (Object[]) new Matrix[]{MatrixUtils.getAuthRequestContext, MatrixUtils.getAuthRequestContext});
        }
        if (matrix == null) {
            matrix = MatrixUtils.getAuthRequestContext;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.getAuthRequestContext;
        }
        MyBillsEntityDataFactory.set(imageView, matrix);
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) MyBillsEntityDataFactory, (TypeEvaluator) new TransitionUtils.MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}

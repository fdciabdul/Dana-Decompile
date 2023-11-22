package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.os.Build;

/* loaded from: classes.dex */
class TransitionUtils {
    private static final boolean BuiltInFictitiousFunctionClassFactory;
    private static final boolean MyBillsEntityDataFactory;
    private static final boolean PlaceComponentResult;

    static {
        MyBillsEntityDataFactory = Build.VERSION.SDK_INT >= 19;
        PlaceComponentResult = Build.VERSION.SDK_INT >= 18;
        BuiltInFictitiousFunctionClassFactory = Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View KClassImpl$Data$declaredNonStaticMembers$2(android.view.ViewGroup r17, android.view.View r18, android.view.View r19) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionUtils.KClassImpl$Data$declaredNonStaticMembers$2(android.view.ViewGroup, android.view.View, android.view.View):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator BuiltInFictitiousFunctionClassFactory(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    /* loaded from: classes6.dex */
    static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        final float[] getAuthRequestContext = new float[9];
        final float[] KClassImpl$Data$declaredNonStaticMembers$2 = new float[9];
        final Matrix MyBillsEntityDataFactory = new Matrix();

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.getAuthRequestContext);
            matrix2.getValues(this.KClassImpl$Data$declaredNonStaticMembers$2);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                float f2 = fArr[i];
                float f3 = this.getAuthRequestContext[i];
                fArr[i] = f3 + ((f2 - f3) * f);
            }
            this.MyBillsEntityDataFactory.setValues(this.KClassImpl$Data$declaredNonStaticMembers$2);
            return this.MyBillsEntityDataFactory;
        }
    }

    private TransitionUtils() {
    }
}

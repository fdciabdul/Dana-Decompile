package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean BuiltInFictitiousFunctionClassFactory = true;
    private static boolean MyBillsEntityDataFactory = true;
    private static boolean getAuthRequestContext = true;

    @Override // androidx.transition.ViewUtilsBase
    public void getAuthRequestContext(View view, Matrix matrix) {
        if (getAuthRequestContext) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                getAuthRequestContext = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void KClassImpl$Data$declaredNonStaticMembers$2(View view, Matrix matrix) {
        if (MyBillsEntityDataFactory) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                MyBillsEntityDataFactory = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void PlaceComponentResult(View view, Matrix matrix) {
        if (BuiltInFictitiousFunctionClassFactory) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                BuiltInFictitiousFunctionClassFactory = false;
            }
        }
    }
}

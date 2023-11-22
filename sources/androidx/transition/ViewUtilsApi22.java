package androidx.transition;

import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean BuiltInFictitiousFunctionClassFactory = true;

    @Override // androidx.transition.ViewUtilsBase
    public void BuiltInFictitiousFunctionClassFactory(View view, int i, int i2, int i3, int i4) {
        if (BuiltInFictitiousFunctionClassFactory) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                BuiltInFictitiousFunctionClassFactory = false;
            }
        }
    }
}

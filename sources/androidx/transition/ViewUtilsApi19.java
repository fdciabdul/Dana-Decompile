package androidx.transition;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean MyBillsEntityDataFactory = true;

    @Override // androidx.transition.ViewUtilsBase
    public void BuiltInFictitiousFunctionClassFactory(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f) {
        if (MyBillsEntityDataFactory) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                MyBillsEntityDataFactory = false;
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getAuthRequestContext(View view) {
        if (MyBillsEntityDataFactory) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                MyBillsEntityDataFactory = false;
            }
        }
        return view.getAlpha();
    }
}

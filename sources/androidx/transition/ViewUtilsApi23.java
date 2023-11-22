package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean MyBillsEntityDataFactory = true;

    @Override // androidx.transition.ViewUtilsBase
    public void MyBillsEntityDataFactory(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.MyBillsEntityDataFactory(view, i);
        } else if (MyBillsEntityDataFactory) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                MyBillsEntityDataFactory = false;
            }
        }
    }
}

package id.dana.core.ui.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewBottomInfoSnackbarBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final ConstraintLayout getAuthRequestContext;

    private ViewBottomInfoSnackbarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatTextView;
    }

    public static ViewBottomInfoSnackbarBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.N;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatTextView != null) {
            return new ViewBottomInfoSnackbarBinding(constraintLayout, constraintLayout, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

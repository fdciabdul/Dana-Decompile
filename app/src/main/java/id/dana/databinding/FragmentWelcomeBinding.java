package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class FragmentWelcomeBinding implements ViewBinding {
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private FragmentWelcomeBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static FragmentWelcomeBinding getAuthRequestContext(View view) {
        int i = R.id.iv_dana_logo;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_logo);
        if (appCompatTextView != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_welcome);
            if (appCompatTextView2 != null) {
                return new FragmentWelcomeBinding((ConstraintLayout) view, appCompatTextView, appCompatTextView2);
            }
            i = R.id.tv_welcome;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

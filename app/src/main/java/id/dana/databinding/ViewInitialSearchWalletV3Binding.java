package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewInitialSearchWalletV3Binding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ViewInitialSearchWalletV3Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ViewInitialSearchWalletV3Binding getAuthRequestContext(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_init_state;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_init_state);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc_init_state);
            if (appCompatTextView != null) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_init_state);
                if (appCompatTextView2 != null) {
                    return new ViewInitialSearchWalletV3Binding(constraintLayout, constraintLayout, appCompatImageView, appCompatTextView, appCompatTextView2);
                }
                i = R.id.tv_title_init_state;
            } else {
                i = R.id.tv_desc_init_state;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

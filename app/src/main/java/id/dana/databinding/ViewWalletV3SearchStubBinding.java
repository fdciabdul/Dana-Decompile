package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewWalletV3SearchStubBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ViewWalletV3SearchStubBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
    }

    public static ViewWalletV3SearchStubBinding getAuthRequestContext(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.et_wallet_search_toolbar;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.et_wallet_search_toolbar);
        if (appCompatTextView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear_toolbar_wallet_search);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_search_toolbar_wallet_search);
                if (appCompatImageView2 != null) {
                    return new ViewWalletV3SearchStubBinding(constraintLayout, constraintLayout, appCompatTextView, appCompatImageView, appCompatImageView2);
                }
                i = R.id.iv_search_toolbar_wallet_search;
            } else {
                i = R.id.iv_clear_toolbar_wallet_search;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

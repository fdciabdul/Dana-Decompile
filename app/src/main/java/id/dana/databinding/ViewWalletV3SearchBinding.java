package id.dana.databinding;

import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewWalletV3SearchBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final EditText KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ViewWalletV3SearchBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editText;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
    }

    public static ViewWalletV3SearchBinding MyBillsEntityDataFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.et_wallet_search_toolbar;
        EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.et_wallet_search_toolbar);
        if (editText != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear_toolbar_wallet_search);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_search_toolbar_wallet_search);
                if (appCompatImageView2 != null) {
                    return new ViewWalletV3SearchBinding(constraintLayout, constraintLayout, editText, appCompatImageView, appCompatImageView2);
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
        return this.MyBillsEntityDataFactory;
    }
}

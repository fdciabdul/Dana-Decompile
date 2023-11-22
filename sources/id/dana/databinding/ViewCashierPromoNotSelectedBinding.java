package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierPromoNotSelectedBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;

    private ViewCashierPromoNotSelectedBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = constraintLayout2;
        this.getAuthRequestContext = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
    }

    public static ViewCashierPromoNotSelectedBinding PlaceComponentResult(View view) {
        int i = R.id.appCompatImageView2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.appCompatImageView2);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivArrowChangePromo);
            if (appCompatImageView2 != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter);
                if (appCompatTextView != null) {
                    return new ViewCashierPromoNotSelectedBinding(constraintLayout, appCompatImageView, constraintLayout, appCompatImageView2, appCompatTextView);
                }
                i = R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter;
            } else {
                i = R.id.ivArrowChangePromo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

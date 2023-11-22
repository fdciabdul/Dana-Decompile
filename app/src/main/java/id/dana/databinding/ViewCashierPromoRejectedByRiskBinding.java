package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierPromoRejectedByRiskBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatTextView getAuthRequestContext;

    private ViewCashierPromoRejectedByRiskBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatTextView;
    }

    public static ViewCashierPromoRejectedByRiskBinding BuiltInFictitiousFunctionClassFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivPromoImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivPromoImage);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter);
            if (appCompatTextView != null) {
                return new ViewCashierPromoRejectedByRiskBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatTextView);
            }
            i = R.id.f4307res_0x7f0a1523_internal_mapadapter_setadapter;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}

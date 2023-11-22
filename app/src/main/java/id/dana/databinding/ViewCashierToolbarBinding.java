package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierToolbarBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ViewCashierToolbarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView) {
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatTextView;
    }

    public static ViewCashierToolbarBinding getAuthRequestContext(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.f3832res_0x7f0a093d_property_propertytype_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3832res_0x7f0a093d_property_propertytype_1);
        if (appCompatImageView != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitlePage);
            if (appCompatTextView != null) {
                return new ViewCashierToolbarBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatTextView);
            }
            i = R.id.tvTitlePage;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

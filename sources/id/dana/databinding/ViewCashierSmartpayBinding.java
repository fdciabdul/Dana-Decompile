package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewCashierSmartpayBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;

    private ViewCashierSmartpayBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static ViewCashierSmartpayBinding MyBillsEntityDataFactory(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivIconAsset;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconAsset);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivInfo);
            if (appCompatImageView2 != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.isHelperTextDisplayed);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                    if (appCompatTextView2 != null) {
                        return new ViewCashierSmartpayBinding(constraintLayout, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                    }
                    i = R.id.tvTitle;
                } else {
                    i = R.id.isHelperTextDisplayed;
                }
            } else {
                i = R.id.ivInfo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

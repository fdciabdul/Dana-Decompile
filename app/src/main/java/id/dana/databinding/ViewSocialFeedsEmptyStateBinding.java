package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewSocialFeedsEmptyStateBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final TextView moveToNextValue;

    private ViewSocialFeedsEmptyStateBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = textView;
        this.moveToNextValue = textView2;
    }

    public static ViewSocialFeedsEmptyStateBinding getAuthRequestContext(View view) {
        int i = R.id.f3454FragmentBottomSheetPaymentSettingBinding_res_0x7f0a0127;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3454FragmentBottomSheetPaymentSettingBinding_res_0x7f0a0127);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getCustomAttributesOrThrow);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_desc_empty_state);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4519xde312118);
                    if (textView2 != null) {
                        return new ViewSocialFeedsEmptyStateBinding(constraintLayout, danaButtonPrimaryView, constraintLayout, appCompatImageView, textView, textView2);
                    }
                    i = R.id.f4519xde312118;
                } else {
                    i = R.id.tv_desc_empty_state;
                }
            } else {
                i = R.id.getCustomAttributesOrThrow;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

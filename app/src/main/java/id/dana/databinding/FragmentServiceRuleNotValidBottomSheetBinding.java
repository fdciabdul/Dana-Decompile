package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class FragmentServiceRuleNotValidBottomSheetBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final View getErrorConfigVersion;
    public final TextView scheduleImpl;

    private FragmentServiceRuleNotValidBottomSheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coordinatorLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = textView;
        this.scheduleImpl = textView2;
        this.getErrorConfigVersion = view;
    }

    public static FragmentServiceRuleNotValidBottomSheetBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_service_rule_not_valid_bottom_sheet, (ViewGroup) null, false);
        int i = R.id.PlaceComponentResult_res_0x7f0a01e4;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.PlaceComponentResult_res_0x7f0a01e4);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_bottom_container);
            if (constraintLayout != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fl_container);
                if (frameLayout != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_service_rule_not_valid_bs_icon);
                    if (appCompatImageView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_service_rule_not_valid_bs_description);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_service_rule_not_valid_bs_title);
                            if (textView2 != null) {
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_bottom_sheet_indicator);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    return new FragmentServiceRuleNotValidBottomSheetBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, constraintLayout, frameLayout, appCompatImageView, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                                }
                                i = R.id.view_bottom_sheet_indicator;
                            } else {
                                i = R.id.tv_service_rule_not_valid_bs_title;
                            }
                        } else {
                            i = R.id.tv_service_rule_not_valid_bs_description;
                        }
                    } else {
                        i = R.id.iv_service_rule_not_valid_bs_icon;
                    }
                } else {
                    i = R.id.fl_container;
                }
            } else {
                i = R.id.cl_bottom_container;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}

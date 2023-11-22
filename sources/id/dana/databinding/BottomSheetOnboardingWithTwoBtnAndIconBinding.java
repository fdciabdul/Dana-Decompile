package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetOnboardingWithTwoBtnAndIconBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final FrameLayout MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView lookAheadTest;
    private final CoordinatorLayout scheduleImpl;

    private BottomSheetOnboardingWithTwoBtnAndIconBinding(CoordinatorLayout coordinatorLayout, AppCompatTextView appCompatTextView, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.scheduleImpl = coordinatorLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.MyBillsEntityDataFactory = frameLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.lookAheadTest = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView3;
    }

    public static BottomSheetOnboardingWithTwoBtnAndIconBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_onboarding_with_two_btn_and_icon, viewGroup, false);
        int i = R.id.btnNegative;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnNegative);
        if (appCompatTextView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnPositive);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3589onTooManyRedirects_res_0x7f0a0352);
                if (constraintLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.flContainer);
                    if (frameLayout != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivIcon);
                        if (appCompatImageView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDesc);
                            if (appCompatTextView2 != null) {
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                                if (appCompatTextView3 != null) {
                                    return new BottomSheetOnboardingWithTwoBtnAndIconBinding((CoordinatorLayout) inflate, appCompatTextView, danaButtonPrimaryView, constraintLayout, frameLayout, appCompatImageView, appCompatTextView2, appCompatTextView3);
                                }
                                i = R.id.tvTitle;
                            } else {
                                i = R.id.tvDesc;
                            }
                        } else {
                            i = R.id.ivIcon;
                        }
                    } else {
                        i = R.id.flContainer;
                    }
                } else {
                    i = R.id.f3589onTooManyRedirects_res_0x7f0a0352;
                }
            } else {
                i = R.id.btnPositive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}

package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.NumpadView;
import id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView;
import id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView;

/* loaded from: classes4.dex */
public final class ViewSetMemberLimitSheetBinding implements ViewBinding {
    public final NumpadView BuiltInFictitiousFunctionClassFactory;
    public final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final FrameLayout PlaceComponentResult;
    public final FamilySetMemberLimitInputAmountView getAuthRequestContext;
    public final FamilySetMemberLimitSliderView getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewSetMemberLimitSheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout, FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView, CoordinatorLayout coordinatorLayout2, NumpadView numpadView, FamilySetMemberLimitSliderView familySetMemberLimitSliderView, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coordinatorLayout;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.PlaceComponentResult = frameLayout;
        this.getAuthRequestContext = familySetMemberLimitInputAmountView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout2;
        this.BuiltInFictitiousFunctionClassFactory = numpadView;
        this.getErrorConfigVersion = familySetMemberLimitSliderView;
        this.scheduleImpl = textView;
        this.moveToNextValue = textView2;
    }

    public static ViewSetMemberLimitSheetBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_set_member_limit_sheet, viewGroup, false);
        int i = R.id.btnSaveChanges;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnSaveChanges);
        if (danaButtonPrimaryView != null) {
            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view);
            if (frameLayout != null) {
                FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView = (FamilySetMemberLimitInputAmountView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.inputAmountView);
                if (familySetMemberLimitInputAmountView != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                    NumpadView numpadView = (NumpadView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.numpadView);
                    if (numpadView != null) {
                        FamilySetMemberLimitSliderView familySetMemberLimitSliderView = (FamilySetMemberLimitSliderView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.sliderLimit);
                        if (familySetMemberLimitSliderView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMaxLabel);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMinLabel);
                                if (textView2 != null) {
                                    return new ViewSetMemberLimitSheetBinding(coordinatorLayout, danaButtonPrimaryView, frameLayout, familySetMemberLimitInputAmountView, coordinatorLayout, numpadView, familySetMemberLimitSliderView, textView, textView2);
                                }
                                i = R.id.tvMinLabel;
                            } else {
                                i = R.id.tvMaxLabel;
                            }
                        } else {
                            i = R.id.sliderLimit;
                        }
                    } else {
                        i = R.id.numpadView;
                    }
                } else {
                    i = R.id.inputAmountView;
                }
            } else {
                i = R.id.f3772res_0x7f0a0717_mutedfragmentcontract_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}

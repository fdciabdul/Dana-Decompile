package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.richview.NumpadView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.summary.view.GroupSendInputAmountView;

/* loaded from: classes5.dex */
public final class BottomSheetInputAmountDialogBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaCheckboxButtonView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final GroupSendInputAmountView getErrorConfigVersion;
    public final NumpadView lookAheadTest;
    public final LinearLayout moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private BottomSheetInputAmountDialogBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaCheckboxButtonView danaCheckboxButtonView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView, GroupSendInputAmountView groupSendInputAmountView, NumpadView numpadView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = coordinatorLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaCheckboxButtonView;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.moveToNextValue = linearLayout;
        this.scheduleImpl = appCompatTextView;
        this.getErrorConfigVersion = groupSendInputAmountView;
        this.lookAheadTest = numpadView;
    }

    public static BottomSheetInputAmountDialogBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_input_amount_dialog, viewGroup, false);
        int i = R.id.DatabaseTableConfigUtil_res_0x7f0a0186;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a02b1_networkuserentitydata_externalsyntheticlambda5;
            DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaCheckboxButtonView != null) {
                i = R.id.res_0x7f0a072a_daggeruserbankcardcomponent_userbankcardcomponentimpl_postexecutionthreadprovider;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (frameLayout != null) {
                    i = R.id.ReferralMapper_Factory;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.containsObjectForKey_res_0x7f0a0a3d;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.MultiLanguageHttpClient_res_0x7f0a0d2e;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (linearLayout != null) {
                                i = R.id.setValue;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView != null) {
                                    i = R.id.validateScopes;
                                    GroupSendInputAmountView groupSendInputAmountView = (GroupSendInputAmountView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (groupSendInputAmountView != null) {
                                        i = R.id.getOnCreateTime;
                                        NumpadView numpadView = (NumpadView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (numpadView != null) {
                                            return new BottomSheetInputAmountDialogBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, danaCheckboxButtonView, frameLayout, appCompatImageView, appCompatImageView2, linearLayout, appCompatTextView, groupSendInputAmountView, numpadView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}

package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.view.GlobalSendDynamicFormView;

/* loaded from: classes5.dex */
public final class FragmentReceiverFormBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final EmptyStateView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final GlobalSendDynamicFormView getErrorConfigVersion;
    public final View lookAheadTest;
    public final NestedScrollView moveToNextValue;
    public final GlobalSendDynamicFormView scheduleImpl;

    private FragmentReceiverFormBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view, EmptyStateView emptyStateView, NestedScrollView nestedScrollView, View view2, GlobalSendDynamicFormView globalSendDynamicFormView, GlobalSendDynamicFormView globalSendDynamicFormView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.PlaceComponentResult = view;
        this.MyBillsEntityDataFactory = emptyStateView;
        this.moveToNextValue = nestedScrollView;
        this.lookAheadTest = view2;
        this.getErrorConfigVersion = globalSendDynamicFormView;
        this.scheduleImpl = globalSendDynamicFormView2;
    }

    public static FragmentReceiverFormBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.fragment_receiver_form, viewGroup, false);
        int i = R.id.getErrorConfigVersion_res_0x7f0a0141;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0345_bottomsheetcardbindingview_watchercardnumberview_1;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout != null) {
                i = R.id.res_0x7f0a0354_verifypinstatemanager_executeriskchallenge_2_2;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (constraintLayout2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.K))) != null) {
                    i = R.id.errorStateView;
                    EmptyStateView emptyStateView = (EmptyStateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (emptyStateView != null) {
                        i = R.id.SplitSavingConfigEntityData_res_0x7f0a0f43;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (nestedScrollView != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.viewDividerButton))) != null) {
                            i = R.id.res_0x7f0a1ad5_r8_lambda_7v3kt_ajfljz89nrm_iclzm3mwc;
                            GlobalSendDynamicFormView globalSendDynamicFormView = (GlobalSendDynamicFormView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (globalSendDynamicFormView != null) {
                                i = R.id.res_0x7f0a1af8_spansuppressionstrategy_2;
                                GlobalSendDynamicFormView globalSendDynamicFormView2 = (GlobalSendDynamicFormView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (globalSendDynamicFormView2 != null) {
                                    return new FragmentReceiverFormBinding((ConstraintLayout) inflate, danaButtonPrimaryView, constraintLayout, constraintLayout2, BuiltInFictitiousFunctionClassFactory, emptyStateView, nestedScrollView, BuiltInFictitiousFunctionClassFactory2, globalSendDynamicFormView, globalSendDynamicFormView2);
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

package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;

/* loaded from: classes9.dex */
public final class ViewSinglePayBodyBinding implements ViewBinding {
    public final CustomEditTextView BuiltInFictitiousFunctionClassFactory;
    public final CustomDropdownView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final CustomEditTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CustomDropdownView PlaceComponentResult;
    public final CustomDropdownView getAuthRequestContext;
    public final LinearLayoutCompat getErrorConfigVersion;
    public final LinearLayoutCompat lookAheadTest;
    public final View moveToNextValue;
    public final ViewHeaderDetailBillsBinding scheduleImpl;

    private ViewSinglePayBodyBinding(LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout, CustomDropdownView customDropdownView, CustomDropdownView customDropdownView2, CustomDropdownView customDropdownView3, CustomEditTextView customEditTextView, CustomEditTextView customEditTextView2, LinearLayoutCompat linearLayoutCompat2, ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding, View view) {
        this.getErrorConfigVersion = linearLayoutCompat;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = customDropdownView;
        this.PlaceComponentResult = customDropdownView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = customDropdownView3;
        this.BuiltInFictitiousFunctionClassFactory = customEditTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = customEditTextView2;
        this.lookAheadTest = linearLayoutCompat2;
        this.scheduleImpl = viewHeaderDetailBillsBinding;
        this.moveToNextValue = view;
    }

    public static ViewSinglePayBodyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.view_single_pay_body, (ViewGroup) null, false);
        int i = R.id.clTopDetailSection;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.dropdownBillAmount;
            CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (customDropdownView != null) {
                i = R.id.dropdownBillType;
                CustomDropdownView customDropdownView2 = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (customDropdownView2 != null) {
                    i = R.id.dropdownProduct;
                    CustomDropdownView customDropdownView3 = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (customDropdownView3 != null) {
                        i = R.id.etBillName;
                        CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (customEditTextView != null) {
                            i = R.id.etBillingDate;
                            CustomEditTextView customEditTextView2 = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (customEditTextView2 != null) {
                                i = R.id.secondaryHash_res_0x7f0a0d23;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (linearLayoutCompat != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.vHeaderDetailBills))) != null) {
                                    ViewHeaderDetailBillsBinding BuiltInFictitiousFunctionClassFactory2 = ViewHeaderDetailBillsBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                                    i = R.id.getSavingConfigPresenter_res_0x7f0a1a56;
                                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                        return new ViewSinglePayBodyBinding((LinearLayoutCompat) inflate, constraintLayout, customDropdownView, customDropdownView2, customDropdownView3, customEditTextView, customEditTextView2, linearLayoutCompat, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3);
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
        return this.getErrorConfigVersion;
    }
}

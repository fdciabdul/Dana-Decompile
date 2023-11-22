package id.dana.mybills.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;
import id.dana.mybills.ui.customview.CustomerIDProviderView;

/* loaded from: classes9.dex */
public final class ViewBodyElectricityMyBillsBinding implements ViewBinding {
    public final CustomDropdownView BuiltInFictitiousFunctionClassFactory;
    public final CustomEditTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CustomDropdownView MyBillsEntityDataFactory;
    public final CustomEditTextView PlaceComponentResult;
    public final CustomerIDProviderView getAuthRequestContext;
    private final LinearLayoutCompat moveToNextValue;

    private ViewBodyElectricityMyBillsBinding(LinearLayoutCompat linearLayoutCompat, CustomDropdownView customDropdownView, CustomDropdownView customDropdownView2, CustomEditTextView customEditTextView, CustomerIDProviderView customerIDProviderView, CustomEditTextView customEditTextView2) {
        this.moveToNextValue = linearLayoutCompat;
        this.MyBillsEntityDataFactory = customDropdownView;
        this.BuiltInFictitiousFunctionClassFactory = customDropdownView2;
        this.PlaceComponentResult = customEditTextView;
        this.getAuthRequestContext = customerIDProviderView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = customEditTextView2;
    }

    public static ViewBodyElectricityMyBillsBinding getAuthRequestContext(View view) {
        int i = R.id.dropdownAmount;
        CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (customDropdownView != null) {
            i = R.id.dropdownServiceType;
            CustomDropdownView customDropdownView2 = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (customDropdownView2 != null) {
                i = R.id.etBillsAmount;
                CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (customEditTextView != null) {
                    i = R.id.etCustomerID;
                    CustomerIDProviderView customerIDProviderView = (CustomerIDProviderView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (customerIDProviderView != null) {
                        i = R.id.etCustomerName;
                        CustomEditTextView customEditTextView2 = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (customEditTextView2 != null) {
                            return new ViewBodyElectricityMyBillsBinding((LinearLayoutCompat) view, customDropdownView, customDropdownView2, customEditTextView, customerIDProviderView, customEditTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}

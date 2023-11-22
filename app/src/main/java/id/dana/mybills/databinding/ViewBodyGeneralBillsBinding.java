package id.dana.mybills.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;
import id.dana.mybills.ui.customview.CustomerIDProviderView;
import id.dana.mybills.ui.customview.PhoneNumberView;

/* loaded from: classes9.dex */
public final class ViewBodyGeneralBillsBinding implements ViewBinding {
    public final CustomEditTextView BuiltInFictitiousFunctionClassFactory;
    public final PhoneNumberView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CustomEditTextView MyBillsEntityDataFactory;
    public final CustomerIDProviderView PlaceComponentResult;
    public final CustomDropdownView getAuthRequestContext;
    private final LinearLayoutCompat lookAheadTest;

    private ViewBodyGeneralBillsBinding(LinearLayoutCompat linearLayoutCompat, CustomDropdownView customDropdownView, CustomEditTextView customEditTextView, CustomerIDProviderView customerIDProviderView, CustomEditTextView customEditTextView2, PhoneNumberView phoneNumberView) {
        this.lookAheadTest = linearLayoutCompat;
        this.getAuthRequestContext = customDropdownView;
        this.BuiltInFictitiousFunctionClassFactory = customEditTextView;
        this.PlaceComponentResult = customerIDProviderView;
        this.MyBillsEntityDataFactory = customEditTextView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = phoneNumberView;
    }

    public static ViewBodyGeneralBillsBinding getAuthRequestContext(View view) {
        int i = R.id.dropdownProvider;
        CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (customDropdownView != null) {
            i = R.id.etBillsAmount;
            CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (customEditTextView != null) {
                i = R.id.etCustomerID;
                CustomerIDProviderView customerIDProviderView = (CustomerIDProviderView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (customerIDProviderView != null) {
                    i = R.id.etCustomerName;
                    CustomEditTextView customEditTextView2 = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (customEditTextView2 != null) {
                        i = R.id.etPhoneNumber;
                        PhoneNumberView phoneNumberView = (PhoneNumberView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (phoneNumberView != null) {
                            return new ViewBodyGeneralBillsBinding((LinearLayoutCompat) view, customDropdownView, customEditTextView, customerIDProviderView, customEditTextView2, phoneNumberView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}

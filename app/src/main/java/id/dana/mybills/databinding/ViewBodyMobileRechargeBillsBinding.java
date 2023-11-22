package id.dana.mybills.databinding;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.PhoneNumberView;

/* loaded from: classes9.dex */
public final class ViewBodyMobileRechargeBillsBinding implements ViewBinding {
    public final PhoneNumberView BuiltInFictitiousFunctionClassFactory;
    public final CustomDropdownView KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayoutCompat PlaceComponentResult;
    public final CustomDropdownView getAuthRequestContext;

    private ViewBodyMobileRechargeBillsBinding(LinearLayoutCompat linearLayoutCompat, CustomDropdownView customDropdownView, CustomDropdownView customDropdownView2, PhoneNumberView phoneNumberView) {
        this.PlaceComponentResult = linearLayoutCompat;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = customDropdownView;
        this.getAuthRequestContext = customDropdownView2;
        this.BuiltInFictitiousFunctionClassFactory = phoneNumberView;
    }

    public static ViewBodyMobileRechargeBillsBinding getAuthRequestContext(View view) {
        int i = R.id.dropdownProduct;
        CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (customDropdownView != null) {
            i = R.id.dropdownService;
            CustomDropdownView customDropdownView2 = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (customDropdownView2 != null) {
                i = R.id.etPhoneNumber;
                PhoneNumberView phoneNumberView = (PhoneNumberView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (phoneNumberView != null) {
                    return new ViewBodyMobileRechargeBillsBinding((LinearLayoutCompat) view, customDropdownView, customDropdownView2, phoneNumberView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

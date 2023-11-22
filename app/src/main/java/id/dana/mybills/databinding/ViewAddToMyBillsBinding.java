package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.CustomEditTextView;

/* loaded from: classes9.dex */
public final class ViewAddToMyBillsBinding implements ViewBinding {
    public final CustomEditTextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CustomDropdownView MyBillsEntityDataFactory;
    public final SwitchMaterial NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImageView PlaceComponentResult;
    public final CustomEditTextView getAuthRequestContext;
    public final TextView moveToNextValue;
    public final LinearLayoutCompat scheduleImpl;

    private ViewAddToMyBillsBinding(LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout, CustomDropdownView customDropdownView, CustomEditTextView customEditTextView, CustomEditTextView customEditTextView2, ImageView imageView, SwitchMaterial switchMaterial, TextView textView) {
        this.scheduleImpl = linearLayoutCompat;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = customDropdownView;
        this.BuiltInFictitiousFunctionClassFactory = customEditTextView;
        this.getAuthRequestContext = customEditTextView2;
        this.PlaceComponentResult = imageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = switchMaterial;
        this.moveToNextValue = textView;
    }

    public static ViewAddToMyBillsBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d0470_networkuserentitydata_externalsyntheticlambda7, (ViewGroup) null, false);
        int i = R.id.clAddToMyBills;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.dropdownPaymentType;
            CustomDropdownView customDropdownView = (CustomDropdownView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (customDropdownView != null) {
                i = R.id.etBillingDate;
                CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (customEditTextView != null) {
                    i = R.id.QrExpiredActivity_res_0x7f0a066f;
                    CustomEditTextView customEditTextView2 = (CustomEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (customEditTextView2 != null) {
                        i = R.id.w;
                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (imageView != null) {
                            i = R.id.res_0x7f0a12bb_securitysettingsactivity_createpinlauncher_2_2;
                            SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (switchMaterial != null) {
                                i = R.id.res_0x7f0a13aa_splitmerchantconfigentity_getmerchantdetailconfig_2_invokesuspend_lambda_0_inlined_getconfigsonceready_default_1_1;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    return new ViewAddToMyBillsBinding((LinearLayoutCompat) inflate, constraintLayout, customDropdownView, customEditTextView, customEditTextView2, imageView, switchMaterial, textView);
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
        return this.scheduleImpl;
    }
}

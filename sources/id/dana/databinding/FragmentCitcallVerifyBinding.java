package id.dana.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import id.dana.R;
import id.dana.core.ui.richview.InputPhoneView;

/* loaded from: classes4.dex */
public final class FragmentCitcallVerifyBinding implements ViewBinding {
    public final MaterialTextView BuiltInFictitiousFunctionClassFactory;
    public final InputPhoneView KClassImpl$Data$declaredNonStaticMembers$2;
    public final MaterialTextView MyBillsEntityDataFactory;
    public final LayoutToolbarBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final ScrollView getAuthRequestContext;
    public final MaterialTextView getErrorConfigVersion;
    private final ScrollView lookAheadTest;

    private FragmentCitcallVerifyBinding(ScrollView scrollView, InputPhoneView inputPhoneView, AppCompatImageView appCompatImageView, ScrollView scrollView2, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, LayoutToolbarBinding layoutToolbarBinding) {
        this.lookAheadTest = scrollView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = inputPhoneView;
        this.PlaceComponentResult = appCompatImageView;
        this.getAuthRequestContext = scrollView2;
        this.MyBillsEntityDataFactory = materialTextView;
        this.BuiltInFictitiousFunctionClassFactory = materialTextView2;
        this.getErrorConfigVersion = materialTextView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = layoutToolbarBinding;
    }

    public static FragmentCitcallVerifyBinding getAuthRequestContext(View view) {
        int i = R.id.res_0x7f0a090d_networkuserentitydata_externalsyntheticlambda4;
        InputPhoneView inputPhoneView = (InputPhoneView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a090d_networkuserentitydata_externalsyntheticlambda4);
        if (inputPhoneView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0ab8_networkuserentitydata_externalsyntheticlambda6);
            if (appCompatImageView != null) {
                ScrollView scrollView = (ScrollView) view;
                MaterialTextView materialTextView = (MaterialTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_missed_call_info);
                if (materialTextView != null) {
                    MaterialTextView materialTextView2 = (MaterialTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_resend);
                    if (materialTextView2 != null) {
                        MaterialTextView materialTextView3 = (MaterialTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_subtitle);
                        if (materialTextView3 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new FragmentCitcallVerifyBinding(scrollView, inputPhoneView, appCompatImageView, scrollView, materialTextView, materialTextView2, materialTextView3, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                            }
                            i = R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a1b9e;
                        } else {
                            i = R.id.tv_subtitle;
                        }
                    } else {
                        i = R.id.tv_resend;
                    }
                } else {
                    i = R.id.tv_missed_call_info;
                }
            } else {
                i = R.id.res_0x7f0a0ab8_networkuserentitydata_externalsyntheticlambda6;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}

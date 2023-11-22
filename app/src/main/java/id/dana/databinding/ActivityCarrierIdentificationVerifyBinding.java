package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.InputPhoneView;

/* loaded from: classes4.dex */
public final class ActivityCarrierIdentificationVerifyBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final LayoutToolbarBinding NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final InputPhoneView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final ViewCarrierIdentificationVerifyLoadingBinding lookAheadTest;
    public final ViewPopupInputBinding moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private ActivityCarrierIdentificationVerifyBinding(LinearLayout linearLayout, Button button, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, InputPhoneView inputPhoneView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ViewCarrierIdentificationVerifyLoadingBinding viewCarrierIdentificationVerifyLoadingBinding, ViewPopupInputBinding viewPopupInputBinding, LayoutToolbarBinding layoutToolbarBinding) {
        this.GetContactSyncConfig = linearLayout;
        this.MyBillsEntityDataFactory = button;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.getAuthRequestContext = inputPhoneView;
        this.PlaceComponentResult = appCompatTextView;
        this.getErrorConfigVersion = appCompatTextView2;
        this.scheduleImpl = appCompatTextView3;
        this.lookAheadTest = viewCarrierIdentificationVerifyLoadingBinding;
        this.moveToNextValue = viewPopupInputBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = layoutToolbarBinding;
    }

    public static ActivityCarrierIdentificationVerifyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_carrier_identification_verify, (ViewGroup) null, false);
        int i = R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2);
        if (button != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ic_content_desc_1);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ic_content_desc_2);
                if (appCompatImageView2 != null) {
                    InputPhoneView inputPhoneView = (InputPhoneView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ipv_phone);
                    if (inputPhoneView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_content_desc_1);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_content_desc_2);
                            if (appCompatTextView2 != null) {
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4415tv_header);
                                if (appCompatTextView3 != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewCIVerifyLoading);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        ViewCarrierIdentificationVerifyLoadingBinding MyBillsEntityDataFactory = ViewCarrierIdentificationVerifyLoadingBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                                        View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_popup_input);
                                        if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                            ViewPopupInputBinding BuiltInFictitiousFunctionClassFactory3 = ViewPopupInputBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2);
                                            View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a1aef_abstractmapbasedmultimap_asmap);
                                            if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                return new ActivityCarrierIdentificationVerifyBinding((LinearLayout) inflate, button, appCompatImageView, appCompatImageView2, inputPhoneView, appCompatTextView, appCompatTextView2, appCompatTextView3, MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory3, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory4));
                                            }
                                            i = R.id.res_0x7f0a1aef_abstractmapbasedmultimap_asmap;
                                        } else {
                                            i = R.id.view_popup_input;
                                        }
                                    } else {
                                        i = R.id.viewCIVerifyLoading;
                                    }
                                } else {
                                    i = R.id.f4415tv_header;
                                }
                            } else {
                                i = R.id.tv_content_desc_2;
                            }
                        } else {
                            i = R.id.tv_content_desc_1;
                        }
                    } else {
                        i = R.id.ipv_phone;
                    }
                } else {
                    i = R.id.ic_content_desc_2;
                }
            } else {
                i = R.id.ic_content_desc_1;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}

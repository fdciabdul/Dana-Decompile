package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetFaceOnlyConfirmationBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final FrameLayout getErrorConfigVersion;
    public final TextView moveToNextValue;
    public final View scheduleImpl;

    private BottomSheetFaceOnlyConfirmationBinding(FrameLayout frameLayout, Button button, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, FrameLayout frameLayout2, ImageView imageView, View view, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = frameLayout;
        this.MyBillsEntityDataFactory = button;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.scheduleImpl = view;
        this.moveToNextValue = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
    }

    public static BottomSheetFaceOnlyConfirmationBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_face_only_confirmation, viewGroup, false);
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_cancel);
        if (button != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback);
                if (constraintLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivInfo);
                    if (imageView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rectangle);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4277res_0x7f0a149f_appmeasurement_conditionaluserproperty);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.GetPureRepPrice);
                                if (textView2 != null) {
                                    return new BottomSheetFaceOnlyConfirmationBinding(frameLayout, button, danaButtonPrimaryView, constraintLayout, frameLayout, imageView, BuiltInFictitiousFunctionClassFactory, textView, textView2);
                                }
                                i = R.id.GetPureRepPrice;
                            } else {
                                i = R.id.f4277res_0x7f0a149f_appmeasurement_conditionaluserproperty;
                            }
                        } else {
                            i = R.id.rectangle;
                        }
                    } else {
                        i = R.id.ivInfo;
                    }
                } else {
                    i = R.id.f3647res_0x7f0a041b_fontscontractcompat_fontrequestcallback;
                }
            } else {
                i = R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}

package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;

/* loaded from: classes4.dex */
public final class ActivityInputPinOrFaceBinding implements ViewBinding {
    public final PinEntryEditText BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final LottieAnimationView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    private final LinearLayout getErrorConfigVersion;
    public final ViewPopupInputBinding lookAheadTest;
    public final AppCompatTextView moveToNextValue;

    private ActivityInputPinOrFaceBinding(LinearLayout linearLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, PinEntryEditText pinEntryEditText, TextView textView, LottieAnimationView lottieAnimationView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ViewPopupInputBinding viewPopupInputBinding) {
        this.getErrorConfigVersion = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.getAuthRequestContext = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = pinEntryEditText;
        this.PlaceComponentResult = textView;
        this.MyBillsEntityDataFactory = lottieAnimationView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.lookAheadTest = viewPopupInputBinding;
    }

    public static ActivityInputPinOrFaceBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_input_pin_or_face, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0);
        if (appCompatTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_two_button);
            if (constraintLayout != null) {
                PinEntryEditText pinEntryEditText = (PinEntryEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8);
                if (pinEntryEditText != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7);
                    if (textView != null) {
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.lav_face_scan);
                        if (lottieAnimationView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.other_action);
                            if (appCompatTextView2 != null) {
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_help);
                                if (appCompatTextView3 != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_popup_input);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        return new ActivityInputPinOrFaceBinding((LinearLayout) inflate, appCompatTextView, constraintLayout, pinEntryEditText, textView, lottieAnimationView, appCompatTextView2, appCompatTextView3, ViewPopupInputBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
                                    }
                                    i = R.id.view_popup_input;
                                } else {
                                    i = R.id.tv_help;
                                }
                            } else {
                                i = R.id.other_action;
                            }
                        } else {
                            i = R.id.lav_face_scan;
                        }
                    } else {
                        i = R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7;
                    }
                } else {
                    i = R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8;
                }
            } else {
                i = R.id.cl_two_button;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}

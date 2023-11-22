package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.InputPhoneView;

/* loaded from: classes4.dex */
public final class FragmentVerifyNumberBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout DatabaseTableConfigUtil;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final FrameLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final InputPhoneView PlaceComponentResult;
    public final Button getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final FrameLayout moveToNextValue;
    public final ScrollView scheduleImpl;

    private FragmentVerifyNumberBinding(FrameLayout frameLayout, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, InputPhoneView inputPhoneView, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, ScrollView scrollView, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, FrameLayout frameLayout3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = frameLayout;
        this.getAuthRequestContext = button;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.PlaceComponentResult = inputPhoneView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.moveToNextValue = frameLayout2;
        this.scheduleImpl = scrollView;
        this.getErrorConfigVersion = textView;
        this.lookAheadTest = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.DatabaseTableConfigUtil = frameLayout3;
    }

    public static FragmentVerifyNumberBinding getAuthRequestContext(View view) {
        int i = R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3510res_0x7f0a01c7_otpregistrationpresenter_input_2);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_verify_number);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cv_warning_dialog);
                if (constraintLayout2 != null) {
                    InputPhoneView inputPhoneView = (InputPhoneView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ipv_phone);
                    if (inputPhoneView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.newSslSocketFactory);
                        if (appCompatImageView != null) {
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_continue);
                            if (frameLayout != null) {
                                ScrollView scrollView = (ScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.scroll_view_verify_number_root);
                                if (scrollView != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4415tv_header);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_tnc_and_privacy_policy);
                                        if (textView2 != null) {
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_warning_desc);
                                            if (appCompatTextView != null) {
                                                FrameLayout frameLayout2 = (FrameLayout) view;
                                                return new FragmentVerifyNumberBinding(frameLayout2, button, constraintLayout, constraintLayout2, inputPhoneView, appCompatImageView, frameLayout, scrollView, textView, textView2, appCompatTextView, frameLayout2);
                                            }
                                            i = R.id.tv_warning_desc;
                                        } else {
                                            i = R.id.tv_tnc_and_privacy_policy;
                                        }
                                    } else {
                                        i = R.id.f4415tv_header;
                                    }
                                } else {
                                    i = R.id.scroll_view_verify_number_root;
                                }
                            } else {
                                i = R.id.ll_continue;
                            }
                        } else {
                            i = R.id.newSslSocketFactory;
                        }
                    } else {
                        i = R.id.ipv_phone;
                    }
                } else {
                    i = R.id.cv_warning_dialog;
                }
            } else {
                i = R.id.cl_verify_number;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}

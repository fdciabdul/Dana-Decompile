package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentPasskeyEnrollmentMainBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatCheckBox PlaceComponentResult;
    public final LottieAnimationView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final ViewBaseToolbarBinding scheduleImpl;

    private FragmentPasskeyEnrollmentMainBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, AppCompatCheckBox appCompatCheckBox, LottieAnimationView lottieAnimationView, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView, TextView textView2, TextView textView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
        this.PlaceComponentResult = appCompatCheckBox;
        this.getAuthRequestContext = lottieAnimationView;
        this.scheduleImpl = viewBaseToolbarBinding;
        this.getErrorConfigVersion = textView;
        this.moveToNextValue = textView2;
        this.lookAheadTest = textView3;
    }

    public static FragmentPasskeyEnrollmentMainBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_passkey_enrollment_main, (ViewGroup) null, false);
        int i = R.id.MyBillsEntityDataFactory_res_0x7f0a0172;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonSecondaryView != null) {
            i = R.id.res_0x7f0a0173_kclassimpl_data_declarednonstaticmembers_2;
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaButtonPrimaryView != null) {
                i = R.id.clContentPasskey;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (constraintLayout != null) {
                    i = R.id.danaCheckboxButtonView;
                    AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatCheckBox != null) {
                        i = R.id.getSupportButtonTintMode_res_0x7f0a0e11;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (lottieAnimationView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbarPasskeyEnrollmentMain))) != null) {
                            ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                            i = R.id.tvDescPasskeyEnrollmentMain;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null) {
                                i = R.id.tv_title_passkey_enrollment_main;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView2 != null) {
                                    i = R.id.AppCompatEmojiTextHelper_res_0x7f0a15c5;
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView3 != null) {
                                        return new FragmentPasskeyEnrollmentMainBinding((ConstraintLayout) inflate, danaButtonSecondaryView, danaButtonPrimaryView, constraintLayout, appCompatCheckBox, lottieAnimationView, MyBillsEntityDataFactory, textView, textView2, textView3);
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}

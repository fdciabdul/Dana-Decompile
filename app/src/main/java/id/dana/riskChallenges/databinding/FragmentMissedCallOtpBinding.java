package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentMissedCallOtpBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final MaterialTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final InputPhoneView PlaceComponentResult;
    public final ScrollView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;
    public final ViewToolbarBinding moveToNextValue;
    public final RetryAndTimerView scheduleImpl;

    private FragmentMissedCallOtpBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, InputPhoneView inputPhoneView, AppCompatImageView appCompatImageView, ScrollView scrollView, MaterialTextView materialTextView, RetryAndTimerView retryAndTimerView, ViewToolbarBinding viewToolbarBinding) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = inputPhoneView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = scrollView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = materialTextView;
        this.scheduleImpl = retryAndTimerView;
        this.moveToNextValue = viewToolbarBinding;
    }

    public static FragmentMissedCallOtpBinding getAuthRequestContext(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d01e3_networkuserentitydata_externalsyntheticlambda0, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.res_0x7f0a090d_networkuserentitydata_externalsyntheticlambda4;
        InputPhoneView inputPhoneView = (InputPhoneView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (inputPhoneView != null) {
            i = R.id.res_0x7f0a0ab8_networkuserentitydata_externalsyntheticlambda6;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.res_0x7f0a12b7_bottomsheetcardbindingview_watchercardnumberview_1;
                ScrollView scrollView = (ScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (scrollView != null) {
                    i = R.id.L;
                    MaterialTextView materialTextView = (MaterialTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (materialTextView != null) {
                        i = R.id.v_retry_and_timer;
                        RetryAndTimerView retryAndTimerView = (RetryAndTimerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (retryAndTimerView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.v_toolbar))) != null) {
                            return new FragmentMissedCallOtpBinding(constraintLayout, constraintLayout, inputPhoneView, appCompatImageView, scrollView, materialTextView, retryAndTimerView, ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}

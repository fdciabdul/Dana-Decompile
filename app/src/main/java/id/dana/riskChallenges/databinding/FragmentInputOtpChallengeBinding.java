package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentInputOtpChallengeBinding implements ViewBinding {
    private final LinearLayoutCompat BuiltInFictitiousFunctionClassFactory;
    public final LayoutOtpVerifyBinding MyBillsEntityDataFactory;
    public final ViewToolbarBinding PlaceComponentResult;
    public final LinearLayoutCompat getAuthRequestContext;

    private FragmentInputOtpChallengeBinding(LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LayoutOtpVerifyBinding layoutOtpVerifyBinding, ViewToolbarBinding viewToolbarBinding) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayoutCompat;
        this.getAuthRequestContext = linearLayoutCompat2;
        this.MyBillsEntityDataFactory = layoutOtpVerifyBinding;
        this.PlaceComponentResult = viewToolbarBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FragmentInputOtpChallengeBinding MyBillsEntityDataFactory(View view) {
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
        int i = R.id.layout_otp;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutOtpVerifyBinding authRequestContext = LayoutOtpVerifyBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            int i2 = R.id.E;
            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i2);
            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                return new FragmentInputOtpChallengeBinding(linearLayoutCompat, linearLayoutCompat, authRequestContext, ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentInputOtpChallengeBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        return MyBillsEntityDataFactory(layoutInflater.inflate(R.layout.fragment_input_otp_challenge, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

package id.dana.riskChallenges.ui.passkey;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPasskeyEnrollmentSuccessBinding;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/EnrollmentSuccessFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPasskeyEnrollmentSuccessBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "FragmentBottomSheetPaymentSettingBinding", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollmentSuccessFragment extends BaseViewBindingFragment<FragmentPasskeyEnrollmentSuccessBinding> {
    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPasskeyEnrollmentSuccessBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPasskeyEnrollmentSuccessBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentPasskeyEnrollmentSuccessBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        super.KClassImpl$Data$declaredNonStaticMembers$2();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyEnrollmentSuccessBinding) vb).getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.res_0x7f1310d4_verifypinstatemanager_executeriskchallenge_2_2));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        super.FragmentBottomSheetPaymentSettingBinding();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.riskChallenges.ui.passkey.EnrollmentSuccessFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EnrollmentSuccessFragment.KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentSuccessFragment.this);
            }
        }, 3000L);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentSuccessFragment enrollmentSuccessFragment) {
        Intrinsics.checkNotNullParameter(enrollmentSuccessFragment, "");
        enrollmentSuccessFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", -1)));
    }
}

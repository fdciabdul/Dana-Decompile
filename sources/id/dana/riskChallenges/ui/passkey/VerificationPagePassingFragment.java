package id.dana.riskChallenges.ui.passkey;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPasskeyVerificationBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/VerificationPagePassingFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPasskeyVerificationBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationPagePassingFragment extends BaseViewBindingFragment<FragmentPasskeyVerificationBinding> {
    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPasskeyVerificationBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPasskeyVerificationBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentPasskeyVerificationBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        super.KClassImpl$Data$declaredNonStaticMembers$2();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyVerificationBinding) vb).BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.res_0x7f1310d4_verifypinstatemanager_executeriskchallenge_2_2));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

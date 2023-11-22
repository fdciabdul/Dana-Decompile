package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class ActivityRiskChallengeBinding implements ViewBinding {
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final FragmentContainerView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ActivityRiskChallengeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = fragmentContainerView;
    }

    public static ActivityRiskChallengeBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_risk_challenge, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.initRecordTimeStamp;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (fragmentContainerView != null) {
            return new ActivityRiskChallengeBinding(constraintLayout, constraintLayout, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentMicFaceBinding implements ViewBinding {
    public final ViewToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout PlaceComponentResult;

    private FragmentMicFaceBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ViewToolbarBinding viewToolbarBinding) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = viewToolbarBinding;
    }

    public static FragmentMicFaceBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mic_face, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.res_0x7f0a0f0e_verifypinstatemanager_executeriskchallenge_2_1;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new FragmentMicFaceBinding(constraintLayout, constraintLayout, ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

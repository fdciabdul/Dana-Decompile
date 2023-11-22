package id.dana.riskChallenges.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.riskChallenges.R;

/* loaded from: classes5.dex */
public final class FragmentCallCsOrDianaBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final ViewToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;
    public final AppCompatTextView moveToNextValue;

    private FragmentCallCsOrDianaBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, ViewToolbarBinding viewToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.lookAheadTest = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = constraintLayout3;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewToolbarBinding;
        this.getErrorConfigVersion = appCompatTextView;
        this.moveToNextValue = appCompatTextView2;
    }

    public static FragmentCallCsOrDianaBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.fragment_call_cs_or_diana, (ViewGroup) null, false);
        int i = R.id.getAuthRequestContext_res_0x7f0a01e6;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.cl_content_wrapper;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
                i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda3;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.res_0x7f0a0f0e_verifypinstatemanager_executeriskchallenge_2_1))) != null) {
                    ViewToolbarBinding MyBillsEntityDataFactory = ViewToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    i = R.id.K;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatTextView != null) {
                        i = R.id.getNameOrBuilderList;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatTextView2 != null) {
                            return new FragmentCallCsOrDianaBinding(constraintLayout2, danaButtonPrimaryView, constraintLayout, constraintLayout2, appCompatImageView, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2);
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

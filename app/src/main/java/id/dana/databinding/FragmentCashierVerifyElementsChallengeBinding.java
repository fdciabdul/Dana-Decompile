package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class FragmentCashierVerifyElementsChallengeBinding implements ViewBinding {
    public final ViewCashierToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    private final ConstraintLayout moveToNextValue;

    private FragmentCashierVerifyElementsChallengeBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, ViewCashierToolbarBinding viewCashierToolbarBinding, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.moveToNextValue = constraintLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.BuiltInFictitiousFunctionClassFactory = viewCashierToolbarBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.PlaceComponentResult = appCompatTextView;
        this.MyBillsEntityDataFactory = appCompatTextView2;
    }

    public static FragmentCashierVerifyElementsChallengeBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_verify_elements_challenge, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0166_networkuserentitydata_externalsyntheticlambda2;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0166_networkuserentitydata_externalsyntheticlambda2);
        if (danaButtonSecondaryView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.include_toolbar);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewCashierToolbarBinding authRequestContext = ViewCashierToolbarBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4132res_0x7f0a112b_protoserializer_externalsyntheticlambda1);
                if (recyclerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle2);
                        if (appCompatTextView2 != null) {
                            return new FragmentCashierVerifyElementsChallengeBinding((ConstraintLayout) inflate, danaButtonSecondaryView, authRequestContext, recyclerView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tvTitle2;
                    } else {
                        i = R.id.tvTitle;
                    }
                } else {
                    i = R.id.f4132res_0x7f0a112b_protoserializer_externalsyntheticlambda1;
                }
            } else {
                i = R.id.include_toolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}

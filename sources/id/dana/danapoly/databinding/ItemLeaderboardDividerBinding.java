package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ItemLeaderboardDividerBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final Guideline KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ItemLeaderboardDividerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, AppCompatTextView appCompatTextView, View view) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = guideline;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.MyBillsEntityDataFactory = view;
    }

    public static ItemLeaderboardDividerBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d02e5_networkuserentitydata_externalsyntheticlambda2, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.res_0x7f0a0606_summaryvoucherview_externalsyntheticlambda0;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (guideline != null) {
            i = R.id.res_0x7f0a152d_submitreceiptresultmodel_creator;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatTextView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.access$getFeaturedBankListAdapter$p))) != null) {
                return new ItemLeaderboardDividerBinding(constraintLayout, constraintLayout, guideline, appCompatTextView, BuiltInFictitiousFunctionClassFactory);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

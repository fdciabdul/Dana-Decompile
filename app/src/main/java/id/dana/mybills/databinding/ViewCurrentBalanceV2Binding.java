package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes5.dex */
public final class ViewCurrentBalanceV2Binding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final View PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ViewCurrentBalanceV2Binding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, View view, View view2) {
        this.scheduleImpl = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
        this.PlaceComponentResult = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view2;
    }

    public static ViewCurrentBalanceV2Binding PlaceComponentResult(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View BuiltInFictitiousFunctionClassFactory2;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d04cd_networkuserentitydata_externalsyntheticlambda6, (ViewGroup) null, false);
        int i = R.id.iv_balance;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.getStackFromEnd;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                i = R.id.FamilyDashboardPresenter_Factory_res_0x7f0a1791;
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView2 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.TwilioRepository_res_0x7f0a1a6a))) != null && (BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.setAkuEntranceOpen_res_0x7f0a1af1))) != null) {
                    return new ViewCurrentBalanceV2Binding((ConstraintLayout) inflate, appCompatImageView, textView, textView2, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}

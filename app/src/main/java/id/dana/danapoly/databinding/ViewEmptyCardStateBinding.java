package id.dana.danapoly.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewEmptyCardStateBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;

    private ViewEmptyCardStateBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
        this.PlaceComponentResult = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
    }

    public static ViewEmptyCardStateBinding PlaceComponentResult(View view) {
        int i = R.id.res_0x7f0a0aa0_flowablecreate_bufferasyncemitter;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.FamilyDashboardPresenter_Factory;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatTextView != null) {
                i = R.id.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatTextView2 != null) {
                    return new ViewEmptyCardStateBinding(linearLayout, appCompatImageView, linearLayout, appCompatTextView, appCompatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

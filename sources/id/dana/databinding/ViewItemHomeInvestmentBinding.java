package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.investment.view.HomeInvestmentView;

/* loaded from: classes2.dex */
public final class ViewItemHomeInvestmentBinding implements ViewBinding {
    public final HomeInvestmentView KClassImpl$Data$declaredNonStaticMembers$2;
    public final HomeInvestmentView getAuthRequestContext;

    private ViewItemHomeInvestmentBinding(HomeInvestmentView homeInvestmentView, HomeInvestmentView homeInvestmentView2) {
        this.getAuthRequestContext = homeInvestmentView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = homeInvestmentView2;
    }

    public static ViewItemHomeInvestmentBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_home_investment, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        HomeInvestmentView homeInvestmentView = (HomeInvestmentView) inflate;
        return new ViewItemHomeInvestmentBinding(homeInvestmentView, homeInvestmentView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

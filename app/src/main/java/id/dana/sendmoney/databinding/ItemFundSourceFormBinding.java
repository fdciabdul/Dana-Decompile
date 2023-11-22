package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.sendmoney.R;

/* loaded from: classes9.dex */
public final class ItemFundSourceFormBinding implements ViewBinding {
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    private final LinearLayout PlaceComponentResult;

    private ItemFundSourceFormBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.PlaceComponentResult = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout2;
        this.MyBillsEntityDataFactory = recyclerView;
    }

    public static ItemFundSourceFormBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_fund_source_form, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        int i = R.id.rvFundSource;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (recyclerView != null) {
            return new ItemFundSourceFormBinding(linearLayout, linearLayout, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

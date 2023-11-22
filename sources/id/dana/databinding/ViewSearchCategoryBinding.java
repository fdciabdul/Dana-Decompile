package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSearchCategoryBinding implements ViewBinding {
    private final FrameLayout MyBillsEntityDataFactory;
    public final RecyclerView PlaceComponentResult;

    private ViewSearchCategoryBinding(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.MyBillsEntityDataFactory = frameLayout;
        this.PlaceComponentResult = recyclerView;
    }

    public static ViewSearchCategoryBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1);
        if (recyclerView != null) {
            return new ViewSearchCategoryBinding((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}

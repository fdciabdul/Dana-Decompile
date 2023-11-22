package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSortCategoryBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final FrameLayout PlaceComponentResult;

    private ViewSortCategoryBinding(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.PlaceComponentResult = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
    }

    public static ViewSortCategoryBinding PlaceComponentResult(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1);
        if (recyclerView != null) {
            return new ViewSortCategoryBinding((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f4138res_0x7f0a1144_rxconvertkt_ascompletable_1)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

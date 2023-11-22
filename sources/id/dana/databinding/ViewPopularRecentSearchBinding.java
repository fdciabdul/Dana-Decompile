package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewPopularRecentSearchBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final LinearLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;

    private ViewPopularRecentSearchBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.getAuthRequestContext = linearLayout2;
        this.PlaceComponentResult = linearLayout3;
        this.MyBillsEntityDataFactory = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView2;
    }

    public static ViewPopularRecentSearchBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.llContainerPopular;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llContainerPopular);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llContainerRecent);
            if (linearLayout2 != null) {
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvPopularSearch);
                if (recyclerView != null) {
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rvRecentSearch);
                    if (recyclerView2 != null) {
                        return new ViewPopularRecentSearchBinding((LinearLayout) view, linearLayout, linearLayout2, recyclerView, recyclerView2);
                    }
                    i = R.id.rvRecentSearch;
                } else {
                    i = R.id.rvPopularSearch;
                }
            } else {
                i = R.id.llContainerRecent;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

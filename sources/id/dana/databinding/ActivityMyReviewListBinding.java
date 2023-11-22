package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.core.ui.richview.DanaDefaultPullToRefresh;

/* loaded from: classes4.dex */
public final class ActivityMyReviewListBinding implements ViewBinding {
    public final DanaDefaultPullToRefresh KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView PlaceComponentResult;
    private final LinearLayout getAuthRequestContext;

    private ActivityMyReviewListBinding(LinearLayout linearLayout, DanaDefaultPullToRefresh danaDefaultPullToRefresh, RecyclerView recyclerView) {
        this.getAuthRequestContext = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaDefaultPullToRefresh;
        this.PlaceComponentResult = recyclerView;
    }

    public static ActivityMyReviewListBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_review_list, (ViewGroup) null, false);
        int i = R.id.ptrMerchantReviews;
        DanaDefaultPullToRefresh danaDefaultPullToRefresh = (DanaDefaultPullToRefresh) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptrMerchantReviews);
        if (danaDefaultPullToRefresh != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvMerchantReviews);
            if (recyclerView != null) {
                return new ActivityMyReviewListBinding((LinearLayout) inflate, danaDefaultPullToRefresh, recyclerView);
            }
            i = R.id.rvMerchantReviews;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

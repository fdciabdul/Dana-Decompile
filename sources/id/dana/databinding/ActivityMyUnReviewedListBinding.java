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
public final class ActivityMyUnReviewedListBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView MyBillsEntityDataFactory;
    public final DanaDefaultPullToRefresh getAuthRequestContext;

    private ActivityMyUnReviewedListBinding(LinearLayout linearLayout, DanaDefaultPullToRefresh danaDefaultPullToRefresh, RecyclerView recyclerView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getAuthRequestContext = danaDefaultPullToRefresh;
        this.MyBillsEntityDataFactory = recyclerView;
    }

    public static ActivityMyUnReviewedListBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_un_reviewed_list, (ViewGroup) null, false);
        int i = R.id.ptrUnreviewedMerchant;
        DanaDefaultPullToRefresh danaDefaultPullToRefresh = (DanaDefaultPullToRefresh) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptrUnreviewedMerchant);
        if (danaDefaultPullToRefresh != null) {
            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvUnReviewedMerchant);
            if (recyclerView != null) {
                return new ActivityMyUnReviewedListBinding((LinearLayout) inflate, danaDefaultPullToRefresh, recyclerView);
            }
            i = R.id.rvUnReviewedMerchant;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

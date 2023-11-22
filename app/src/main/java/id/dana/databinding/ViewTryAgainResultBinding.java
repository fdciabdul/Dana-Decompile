package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewTryAgainResultBinding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final LinearLayout getAuthRequestContext;

    private ViewTryAgainResultBinding(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.getAuthRequestContext = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    public static ViewTryAgainResultBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_try_again_result, (ViewGroup) null, false);
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvTryAgainPaymentMethod);
        if (recyclerView != null) {
            return new ViewTryAgainResultBinding((LinearLayout) inflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.rvTryAgainPaymentMethod)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

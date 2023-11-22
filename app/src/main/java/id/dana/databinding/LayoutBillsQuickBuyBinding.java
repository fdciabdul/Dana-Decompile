package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class LayoutBillsQuickBuyBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private LayoutBillsQuickBuyBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = view;
    }

    public static LayoutBillsQuickBuyBinding PlaceComponentResult(View view) {
        int i = R.id.rv_quick_buy;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_quick_buy);
        if (recyclerView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
            if (textView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    return new LayoutBillsQuickBuyBinding((ConstraintLayout) view, recyclerView, textView, BuiltInFictitiousFunctionClassFactory);
                }
                i = R.id.view_divider;
            } else {
                i = R.id.tv_title;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

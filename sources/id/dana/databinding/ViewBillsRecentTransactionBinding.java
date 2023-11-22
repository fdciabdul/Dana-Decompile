package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewBillsRecentTransactionBinding implements ViewBinding {
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    private final ConstraintLayout PlaceComponentResult;

    private ViewBillsRecentTransactionBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
    }

    public static ViewBillsRecentTransactionBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.WrappedDrawableState_res_0x7f0a111b;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.WrappedDrawableState_res_0x7f0a111b);
        if (recyclerView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getGnBenefitEntityDanaProtection_res_0x7f0a1535);
            if (textView != null) {
                return new ViewBillsRecentTransactionBinding((ConstraintLayout) view, recyclerView, textView);
            }
            i = R.id.getGnBenefitEntityDanaProtection_res_0x7f0a1535;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

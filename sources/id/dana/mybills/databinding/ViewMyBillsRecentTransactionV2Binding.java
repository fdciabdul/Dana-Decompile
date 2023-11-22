package id.dana.mybills.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class ViewMyBillsRecentTransactionV2Binding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;

    private ViewMyBillsRecentTransactionV2Binding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ViewMyBillsRecentTransactionV2Binding getAuthRequestContext(View view) {
        int i = R.id.WrappedDrawableState_res_0x7f0a111b;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (recyclerView != null) {
            i = R.id.getGnBenefitEntityDanaProtection_res_0x7f0a1535;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (textView != null) {
                return new ViewMyBillsRecentTransactionV2Binding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

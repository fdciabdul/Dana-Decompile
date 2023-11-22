package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes5.dex */
public final class ViewholderBillShimmerBinding implements ViewBinding {
    private final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;

    private ViewholderBillShimmerBinding(LinearLayout linearLayout, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.MyBillsEntityDataFactory = view;
    }

    public static ViewholderBillShimmerBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.viewholder_bill_shimmer, viewGroup, false);
        int i = R.id.ISO8601Utils;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new ViewholderBillShimmerBinding((LinearLayout) inflate, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

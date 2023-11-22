package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewDiscoverBillsServiceBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConstraintLayout PlaceComponentResult;

    private ViewDiscoverBillsServiceBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ViewDiscoverBillsServiceBinding getAuthRequestContext(View view) {
        int i = R.id.FlowableConcatMapEagerPublisher_res_0x7f0a10e3;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.FlowableConcatMapEagerPublisher_res_0x7f0a10e3);
        if (recyclerView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.containsObjectForKey_res_0x7f0a13b0);
            if (textView != null) {
                return new ViewDiscoverBillsServiceBinding((ConstraintLayout) view, recyclerView, textView);
            }
            i = R.id.containsObjectForKey_res_0x7f0a13b0;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

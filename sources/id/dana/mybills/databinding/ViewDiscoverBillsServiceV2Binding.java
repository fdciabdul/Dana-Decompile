package id.dana.mybills.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class ViewDiscoverBillsServiceV2Binding implements ViewBinding {
    private final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;

    private ViewDiscoverBillsServiceV2Binding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = recyclerView;
        this.PlaceComponentResult = textView;
    }

    public static ViewDiscoverBillsServiceV2Binding getAuthRequestContext(View view) {
        int i = R.id.FlowableConcatMapEagerPublisher_res_0x7f0a10e3;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (recyclerView != null) {
            i = R.id.containsObjectForKey_res_0x7f0a13b0;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (textView != null) {
                return new ViewDiscoverBillsServiceV2Binding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

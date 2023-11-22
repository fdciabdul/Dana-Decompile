package id.dana.databinding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewSendToLinkSelectorBinding implements ViewBinding {
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final MaterialCardView MyBillsEntityDataFactory;

    private ViewSendToLinkSelectorBinding(MaterialCardView materialCardView, RecyclerView recyclerView) {
        this.MyBillsEntityDataFactory = materialCardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    public static ViewSendToLinkSelectorBinding getAuthRequestContext(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        if (recyclerView != null) {
            return new ViewSendToLinkSelectorBinding((MaterialCardView) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}

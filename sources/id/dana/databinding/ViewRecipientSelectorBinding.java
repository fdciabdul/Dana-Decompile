package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.landing.view.ShowMoreView;

/* loaded from: classes4.dex */
public final class ViewRecipientSelectorBinding implements ViewBinding {
    private final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ShowMoreView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView PlaceComponentResult;

    private ViewRecipientSelectorBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ShowMoreView showMoreView) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.PlaceComponentResult = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = showMoreView;
    }

    public static ViewRecipientSelectorBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_recipient_selector, (ViewGroup) null, false);
        int i = R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4096res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        if (recyclerView != null) {
            ShowMoreView showMoreView = (ShowMoreView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.showMoreItem);
            if (showMoreView != null) {
                return new ViewRecipientSelectorBinding((ConstraintLayout) inflate, recyclerView, showMoreView);
            }
            i = R.id.showMoreItem;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}

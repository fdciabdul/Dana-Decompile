package id.dana.databinding;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.base.NestedScrollableHost;

/* loaded from: classes4.dex */
public final class ViewFriendsFeedsHeaderBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final NestedScrollableHost getAuthRequestContext;

    private ViewFriendsFeedsHeaderBinding(NestedScrollableHost nestedScrollableHost, RecyclerView recyclerView) {
        this.getAuthRequestContext = nestedScrollableHost;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
    }

    public static ViewFriendsFeedsHeaderBinding BuiltInFictitiousFunctionClassFactory(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_friends_feeds);
        if (recyclerView != null) {
            return new ViewFriendsFeedsHeaderBinding((NestedScrollableHost) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv_friends_feeds)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

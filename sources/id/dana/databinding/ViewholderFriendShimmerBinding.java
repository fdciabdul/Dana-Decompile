package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewholderFriendShimmerBinding implements ViewBinding {
    public final View BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout KClassImpl$Data$declaredNonStaticMembers$2;

    private ViewholderFriendShimmerBinding(LinearLayout linearLayout, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    public static ViewholderFriendShimmerBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.vShimmer);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new ViewholderFriendShimmerBinding((LinearLayout) view, BuiltInFictitiousFunctionClassFactory);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.vShimmer)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

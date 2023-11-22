package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class FragmentMeFeedBinding implements ViewBinding {
    public final ViewSocialMeFeedBinding BuiltInFictitiousFunctionClassFactory;
    private final LinearLayout MyBillsEntityDataFactory;

    private FragmentMeFeedBinding(LinearLayout linearLayout, ViewSocialMeFeedBinding viewSocialMeFeedBinding) {
        this.MyBillsEntityDataFactory = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = viewSocialMeFeedBinding;
    }

    public static FragmentMeFeedBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_social_feed);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return new FragmentMeFeedBinding((LinearLayout) view, ViewSocialMeFeedBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.view_social_feed)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}

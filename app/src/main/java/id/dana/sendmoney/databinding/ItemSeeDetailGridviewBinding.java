package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemSeeDetailGridviewBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;

    private ItemSeeDetailGridviewBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, TextView textView) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = circleImageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
    }

    public static ItemSeeDetailGridviewBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_see_detail_gridview, viewGroup, false);
        int i = R.id.getReadyFragment;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.PromoExploreModule_ProvidesPresenterFactory_res_0x7f0a14e2;
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (textView != null) {
                return new ItemSeeDetailGridviewBinding((ConstraintLayout) inflate, circleImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

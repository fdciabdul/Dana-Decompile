package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ItemMemberGridviewBinding implements ViewBinding {
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final CircleImageView PlaceComponentResult;
    private final ConstraintLayout getAuthRequestContext;

    private ItemMemberGridviewBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, AppCompatImageView appCompatImageView, TextView textView) {
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = circleImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = textView;
    }

    public static ItemMemberGridviewBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_member_gridview, viewGroup, false);
        int i = R.id.ApiStatus$AvailableSince;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (circleImageView != null) {
            i = R.id.res_0x7f0a0995_access_setshowcaseshowing_p;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.PromoExploreModule_ProvidesPresenterFactory_res_0x7f0a14e2;
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (textView != null) {
                    return new ItemMemberGridviewBinding((ConstraintLayout) inflate, circleImageView, appCompatImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

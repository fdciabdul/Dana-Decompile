package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemMemberAvailableServicesBinding implements ViewBinding {
    public final CardView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView getAuthRequestContext;

    private ItemMemberAvailableServicesBinding(CardView cardView, CardView cardView2, ImageView imageView) {
        this.getAuthRequestContext = cardView;
        this.BuiltInFictitiousFunctionClassFactory = cardView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
    }

    public static ItemMemberAvailableServicesBinding PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_member_available_services, viewGroup, false);
        CardView cardView = (CardView) inflate;
        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivService);
        if (imageView != null) {
            return new ItemMemberAvailableServicesBinding(cardView, cardView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.ivService)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

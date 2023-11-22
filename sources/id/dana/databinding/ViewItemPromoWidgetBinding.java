package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import id.dana.R;
import id.dana.richview.NewPromoBannerView;

/* loaded from: classes2.dex */
public final class ViewItemPromoWidgetBinding implements ViewBinding {
    public final NewPromoBannerView PlaceComponentResult;
    public final NewPromoBannerView getAuthRequestContext;

    private ViewItemPromoWidgetBinding(NewPromoBannerView newPromoBannerView, NewPromoBannerView newPromoBannerView2) {
        this.getAuthRequestContext = newPromoBannerView;
        this.PlaceComponentResult = newPromoBannerView2;
    }

    public static ViewItemPromoWidgetBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_item_promo_widget, viewGroup, false);
        if (inflate == null) {
            throw new NullPointerException("rootView");
        }
        NewPromoBannerView newPromoBannerView = (NewPromoBannerView) inflate;
        return new ViewItemPromoWidgetBinding(newPromoBannerView, newPromoBannerView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}

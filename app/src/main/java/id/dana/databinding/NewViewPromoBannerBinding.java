package id.dana.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import id.dana.richview.NewBannerView;

/* loaded from: classes4.dex */
public final class NewViewPromoBannerBinding implements ViewBinding {
    public final NewBannerView KClassImpl$Data$declaredNonStaticMembers$2;
    private final NewBannerView PlaceComponentResult;

    private NewViewPromoBannerBinding(NewBannerView newBannerView, NewBannerView newBannerView2) {
        this.PlaceComponentResult = newBannerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newBannerView2;
    }

    public static NewViewPromoBannerBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        NewBannerView newBannerView = (NewBannerView) view;
        return new NewViewPromoBannerBinding(newBannerView, newBannerView);
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}

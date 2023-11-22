package id.dana.promocenter.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes9.dex */
public class PromoView_ViewBinding implements Unbinder {
    private PromoView KClassImpl$Data$declaredNonStaticMembers$2;

    public PromoView_ViewBinding(PromoView promoView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoView;
        promoView.btnFirstPromoAction = (DanaButtonSecondaryView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_first_promo_action, "field 'btnFirstPromoAction'", DanaButtonSecondaryView.class);
        promoView.btnSecondPromoAction = (DanaButtonPrimaryView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_second_promo_action, "field 'btnSecondPromoAction'", DanaButtonPrimaryView.class);
        promoView.ivHotPromoRibbon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_hot_promo_ribbon, "field 'ivHotPromoRibbon'", ImageView.class);
        promoView.ivPromoBanner = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_promo_banner, "field 'ivPromoBanner'", ImageView.class);
        promoView.tvPromoExpiryDate = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_promo_expiry_date, "field 'tvPromoExpiryDate'", TextView.class);
        promoView.tvPromoTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4482tv_promo_title, "field 'tvPromoTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PromoView promoView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (promoView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        promoView.btnFirstPromoAction = null;
        promoView.btnSecondPromoAction = null;
        promoView.ivHotPromoRibbon = null;
        promoView.ivPromoBanner = null;
        promoView.tvPromoExpiryDate = null;
        promoView.tvPromoTitle = null;
    }
}

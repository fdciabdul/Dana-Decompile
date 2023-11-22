package id.dana.nearbyme.merchantdetail.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MerchantDanaDealsShimmerViewHolder_ViewBinding implements Unbinder {
    private MerchantDanaDealsShimmerViewHolder BuiltInFictitiousFunctionClassFactory;

    public MerchantDanaDealsShimmerViewHolder_ViewBinding(MerchantDanaDealsShimmerViewHolder merchantDanaDealsShimmerViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = merchantDanaDealsShimmerViewHolder;
        merchantDanaDealsShimmerViewHolder.voucherPercentageValue = (FrameLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.fl_voucher_value, "field 'voucherPercentageValue'", FrameLayout.class);
        merchantDanaDealsShimmerViewHolder.merchantLogo = (FrameLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.fl_merchant_logo, "field 'merchantLogo'", FrameLayout.class);
        merchantDanaDealsShimmerViewHolder.voucherPriceValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_price_value, "field 'voucherPriceValue'", TextView.class);
        merchantDanaDealsShimmerViewHolder.voucherPriceLabel = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_price_label, "field 'voucherPriceLabel'", TextView.class);
        merchantDanaDealsShimmerViewHolder.danaDealVoucherImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_dana_deals_image, "field 'danaDealVoucherImage'", ImageView.class);
        merchantDanaDealsShimmerViewHolder.buyNowButton = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_buy_now, "field 'buyNowButton'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        MerchantDanaDealsShimmerViewHolder merchantDanaDealsShimmerViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (merchantDanaDealsShimmerViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        merchantDanaDealsShimmerViewHolder.voucherPercentageValue = null;
        merchantDanaDealsShimmerViewHolder.merchantLogo = null;
        merchantDanaDealsShimmerViewHolder.voucherPriceValue = null;
        merchantDanaDealsShimmerViewHolder.voucherPriceLabel = null;
        merchantDanaDealsShimmerViewHolder.danaDealVoucherImage = null;
        merchantDanaDealsShimmerViewHolder.buyNowButton = null;
    }
}

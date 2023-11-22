package id.dana.nearbyme.merchantdetail.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public final class MerchantDanaDealsViewHolder_ViewBinding implements Unbinder {
    private MerchantDanaDealsViewHolder BuiltInFictitiousFunctionClassFactory;

    public MerchantDanaDealsViewHolder_ViewBinding(MerchantDanaDealsViewHolder merchantDanaDealsViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = merchantDanaDealsViewHolder;
        merchantDanaDealsViewHolder.voucherPercentageValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_percentage_value, "field 'voucherPercentageValue'", TextView.class);
        merchantDanaDealsViewHolder.merchantLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3916iv_merchant_logo, "field 'merchantLogo'", ImageView.class);
        merchantDanaDealsViewHolder.voucherPriceValue = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_price_value, "field 'voucherPriceValue'", TextView.class);
        merchantDanaDealsViewHolder.danaDealVoucherImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_dana_deals_image, "field 'danaDealVoucherImage'", ImageView.class);
        merchantDanaDealsViewHolder.buyNowButton = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_buy_now, "field 'buyNowButton'", Button.class);
        merchantDanaDealsViewHolder.voucherTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_title, "field 'voucherTitle'", TextView.class);
        merchantDanaDealsViewHolder.voucherPrice = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4539tv_voucher_price, "field 'voucherPrice'", TextView.class);
        merchantDanaDealsViewHolder.voucherDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_voucher_description, "field 'voucherDescription'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        MerchantDanaDealsViewHolder merchantDanaDealsViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (merchantDanaDealsViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        merchantDanaDealsViewHolder.voucherPercentageValue = null;
        merchantDanaDealsViewHolder.merchantLogo = null;
        merchantDanaDealsViewHolder.voucherPriceValue = null;
        merchantDanaDealsViewHolder.danaDealVoucherImage = null;
        merchantDanaDealsViewHolder.buyNowButton = null;
        merchantDanaDealsViewHolder.voucherTitle = null;
        merchantDanaDealsViewHolder.voucherPrice = null;
        merchantDanaDealsViewHolder.voucherDescription = null;
    }
}

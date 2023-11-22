package id.dana.nearbyme.merchantdetail.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantVoucherInfoModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001c\u0010\u001dR\u0012\u0010\u0004\u001a\u00020\u0003X\u0087\"¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0006X\u0087\"¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X\u0087\"¢\u0006\u0006\n\u0004\b\t\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000fX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0012\u0010\u0017\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0012\u0010\u0019\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantDanaDealsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "Landroid/widget/Button;", "buyNowButton", "Landroid/widget/Button;", "Landroid/widget/ImageView;", "danaDealVoucherImage", "Landroid/widget/ImageView;", "merchantLogo", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/widget/TextView;", "voucherDescription", "Landroid/widget/TextView;", "voucherPercentageValue", "voucherPrice", "voucherPriceValue", "voucherTitle", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsViewHolder extends BaseRecyclerViewHolder<MerchantProductInfoModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<MerchantProductInfoModel, Unit> MyBillsEntityDataFactory;
    @BindView(R.id.btn_buy_now)
    public Button buyNowButton;
    @BindView(R.id.iv_dana_deals_image)
    public ImageView danaDealVoucherImage;
    @BindView(R.id.f3916iv_merchant_logo)
    public ImageView merchantLogo;
    @BindView(R.id.tv_voucher_description)
    public TextView voucherDescription;
    @BindView(R.id.tv_voucher_percentage_value)
    public TextView voucherPercentageValue;
    @BindView(R.id.f4539tv_voucher_price)
    public TextView voucherPrice;
    @BindView(R.id.tv_voucher_price_value)
    public TextView voucherPriceValue;
    @BindView(R.id.tv_voucher_title)
    public TextView voucherTitle;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantProductInfoModel merchantProductInfoModel) {
        String authRequestContext;
        final MerchantProductInfoModel merchantProductInfoModel2 = merchantProductInfoModel;
        if (merchantProductInfoModel2 != null) {
            TextView textView = this.voucherPriceValue;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setText(merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            TextView textView3 = this.voucherTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView3 = null;
            }
            textView3.setText(merchantProductInfoModel2.moveToNextValue);
            TextView textView4 = this.voucherDescription;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView4 = null;
            }
            textView4.setText(merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil);
            RequestBuilder<Bitmap> MyBillsEntityDataFactory = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).PlaceComponentResult().PlaceComponentResult(merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1.moveToNextValue).MyBillsEntityDataFactory((BaseRequestOptions<?>) new RequestOptions().getAuthRequestContext(new RoundedCornersTransformation(8, 0, RoundedCornersTransformation.CornerType.TOP)));
            ImageView imageView = this.danaDealVoucherImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView = null;
            }
            MyBillsEntityDataFactory.MyBillsEntityDataFactory(imageView);
            Button button = this.buyNowButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                button = null;
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewholder.MerchantDanaDealsViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDanaDealsViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(MerchantDanaDealsViewHolder.this, merchantProductInfoModel2);
                }
            });
            RequestBuilder<Drawable> authRequestContext2 = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion);
            ImageView imageView2 = this.merchantLogo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView2 = null;
            }
            authRequestContext2.MyBillsEntityDataFactory(imageView2);
            String valueOf = String.valueOf((int) merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            TextView textView5 = this.voucherPercentageValue;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView5 = null;
            }
            textView5.setText(getContext().getResources().getString(R.string.nearby_dana_deals_save_up_to, valueOf));
            MerchantVoucherInfoModel merchantVoucherInfoModel = merchantProductInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda1;
            TextView textView6 = this.voucherPrice;
            if (textView6 != null) {
                textView2 = textView6;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (merchantVoucherInfoModel.PlaceComponentResult.length() > 0) {
                authRequestContext = getContext().getResources().getString(R.string.nearby_dana_deals_voucher_price_percent, Integer.valueOf((int) (Double.parseDouble(merchantVoucherInfoModel.PlaceComponentResult) * 100.0d)));
            } else {
                authRequestContext = merchantVoucherInfoModel.getAuthRequestContext.getAuthRequestContext();
            }
            textView2.setText(authRequestContext);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MerchantDanaDealsViewHolder(ViewGroup viewGroup, Function1<? super MerchantProductInfoModel, Unit> function1) {
        super(viewGroup.getContext(), R.layout.view_merchant_dana_deal_card, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.MyBillsEntityDataFactory = function1;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDanaDealsViewHolder merchantDanaDealsViewHolder, MerchantProductInfoModel merchantProductInfoModel) {
        Intrinsics.checkNotNullParameter(merchantDanaDealsViewHolder, "");
        Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
        merchantDanaDealsViewHolder.MyBillsEntityDataFactory.invoke(merchantProductInfoModel);
    }
}

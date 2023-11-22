package id.dana.nearbyme.merchantdetail.viewholder;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.utils.ShimmeringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0004\u001a\u00020\u0003X\u0087\"¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\n\u001a\u00020\tX\u0087\"¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0012\u0010\u000f\u001a\u00020\u000eX\u0087\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0012\u0010\u0012\u001a\u00020\u000eX\u0087\"¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0013X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewholder/MerchantDanaDealsShimmerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "Landroid/widget/Button;", "buyNowButton", "Landroid/widget/Button;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/widget/ImageView;", "danaDealVoucherImage", "Landroid/widget/ImageView;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Landroid/widget/FrameLayout;", "merchantLogo", "Landroid/widget/FrameLayout;", "getAuthRequestContext", "voucherPercentageValue", "Landroid/widget/TextView;", "voucherPriceLabel", "Landroid/widget/TextView;", "voucherPriceValue", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsShimmerViewHolder extends BaseRecyclerViewHolder<MerchantProductInfoModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public SkeletonScreen MyBillsEntityDataFactory;
    public SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.btn_buy_now)
    public Button buyNowButton;
    @BindView(R.id.iv_dana_deals_image)
    public ImageView danaDealVoucherImage;
    public SkeletonScreen getAuthRequestContext;
    @BindView(R.id.fl_merchant_logo)
    public FrameLayout merchantLogo;
    @BindView(R.id.fl_voucher_value)
    public FrameLayout voucherPercentageValue;
    @BindView(R.id.tv_voucher_price_label)
    public TextView voucherPriceLabel;
    @BindView(R.id.tv_voucher_price_value)
    public TextView voucherPriceValue;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantProductInfoModel merchantProductInfoModel) {
        FrameLayout frameLayout = this.voucherPercentageValue;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.merchantLogo;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            frameLayout2 = null;
        }
        frameLayout2.setVisibility(8);
        ImageView imageView = this.danaDealVoucherImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageView = null;
        }
        this.MyBillsEntityDataFactory = ShimmeringUtil.PlaceComponentResult(imageView, R.layout.view_skeleton_voucher_image);
        Button button = this.buyNowButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            button = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.PlaceComponentResult(button, R.layout.view_skeleton_buy_now_button);
        TextView textView2 = this.voucherPriceValue;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView2 = null;
        }
        this.getAuthRequestContext = ShimmeringUtil.PlaceComponentResult(textView2, R.layout.view_skeleton_voucher_price_value);
        TextView textView3 = this.voucherPriceLabel;
        if (textView3 != null) {
            textView = textView3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult(textView, R.layout.view_skeleton_voucher_price_label);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDanaDealsShimmerViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_merchant_dana_deal_card, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.glidetransformations.MaskTransformation;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.utils.ImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promodiscovery/viewholder/DanaDealsItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "getAuthRequestContext", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDealsItemViewHolder extends BaseRecyclerViewHolder<ProductInfoDiscoveryModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PromoDiscoveryListItemListener<ProductInfoDiscoveryModel> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ProductInfoDiscoveryModel productInfoDiscoveryModel) {
        final ProductInfoDiscoveryModel productInfoDiscoveryModel2 = productInfoDiscoveryModel;
        super.bindData(productInfoDiscoveryModel2);
        if (productInfoDiscoveryModel2 != null) {
            View view = this.itemView;
            view.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.DanaDealsItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DanaDealsItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(DanaDealsItemViewHolder.this, productInfoDiscoveryModel2);
                }
            });
            TextView textView = (TextView) view.findViewById(R.id.tvVoucherTitle);
            if (textView != null) {
                textView.setText(productInfoDiscoveryModel2.getGoodsTitle());
            }
            VoucherInfo voucherInfo = productInfoDiscoveryModel2.getVoucherInfo();
            MoneyView displayVoucherValue = voucherInfo.getDisplayVoucherValue();
            TextView textView2 = (TextView) view.findViewById(R.id.res_0x7f0a15ef_merchantdetailcontract_presenter);
            if (textView2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(displayVoucherValue.getCurrency());
                sb.append(displayVoucherValue.getAmount());
                textView2.setText(sb.toString());
            }
            TextView textView3 = (TextView) view.findViewById(R.id.res_0x7f0a15ea_discretescrollview_scrollstatelistener_1);
            if (textView3 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(displayVoucherValue.getCurrency());
                sb2.append(displayVoucherValue.getAmount());
                textView3.setText(sb2.toString());
            }
            ((TextView) view.findViewById(R.id.res_0x7f0a15ea_discretescrollview_scrollstatelistener_1)).setPaintFlags(((TextView) view.findViewById(R.id.res_0x7f0a15ea_discretescrollview_scrollstatelistener_1)).getPaintFlags() | 16);
            MoneyView displayVoucherPrice = voucherInfo.getDisplayVoucherPrice();
            TextView textView4 = (TextView) view.findViewById(R.id.tvVoucherPrice);
            if (textView4 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(displayVoucherPrice.getCurrency());
                sb3.append(displayVoucherPrice.getAmount());
                textView4.setText(sb3.toString());
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.ivLogoMerchant);
            if (appCompatImageView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                String voucherIcon = productInfoDiscoveryModel2.getVoucherInfo().getVoucherIcon();
                if (voucherIcon.length() == 0) {
                    appCompatImageView.setBackground(null);
                } else {
                    appCompatImageView.setBackground(ContextCompat.PlaceComponentResult(appCompatImageView.getContext(), (int) R.drawable.bg_rounded_white_6dp));
                }
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView.getContext()).getAuthRequestContext(voucherIcon).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.res_0x7f0a0a16_sortdescending_qwzrm1k);
            if (appCompatImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(ImageUtil.BuiltInFictitiousFunctionClassFactory(productInfoDiscoveryModel2.getVoucherInfo().getVoucherBackground())).MyBillsEntityDataFactory((int) R.drawable.dana_deals_bg_tinder).PlaceComponentResult(view.getContext().getResources().getDimensionPixelSize(R.dimen.f28532131165355), view.getContext().getResources().getDimensionPixelSize(R.dimen.f28522131165354)).KClassImpl$Data$declaredNonStaticMembers$2(new CenterCrop(), new MaskTransformation(R.drawable.voucher_cutoff)).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DanaDealsItemViewHolder(ViewGroup viewGroup, PromoDiscoveryListItemListener<? super ProductInfoDiscoveryModel> promoDiscoveryListItemListener) {
        super(viewGroup.getContext(), R.layout.layout_dana_deals_item, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.BuiltInFictitiousFunctionClassFactory = promoDiscoveryListItemListener;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DanaDealsItemViewHolder danaDealsItemViewHolder, ProductInfoDiscoveryModel productInfoDiscoveryModel) {
        Intrinsics.checkNotNullParameter(danaDealsItemViewHolder, "");
        Intrinsics.checkNotNullParameter(productInfoDiscoveryModel, "");
        danaDealsItemViewHolder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(productInfoDiscoveryModel);
    }
}

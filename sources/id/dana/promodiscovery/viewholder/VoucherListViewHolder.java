package id.dana.promodiscovery.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.ImageAttacher;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.utils.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promodiscovery/viewholder/VoucherListViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "PlaceComponentResult", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoucherListViewHolder extends BaseRecyclerViewHolder<PromoModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PromoModel promoModel) {
        final PromoModel promoModel2 = promoModel;
        if (promoModel2 != null) {
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.VoucherListViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoucherListViewHolder.getAuthRequestContext(VoucherListViewHolder.this, promoModel2);
                }
            });
        }
        if (getLayoutPosition() == 0) {
            if (LocaleUtil.BuiltInFictitiousFunctionClassFactory()) {
                InstrumentInjector.Resources_setImageResource((ImageView) this.itemView.findViewById(R.id.SaveNumberOfLocationPermissionShownData), R.drawable.voucher_banner_in);
                return;
            } else {
                InstrumentInjector.Resources_setImageResource((ImageView) this.itemView.findViewById(R.id.SaveNumberOfLocationPermissionShownData), R.drawable.voucher_banner_en);
                return;
            }
        }
        String str = promoModel2 != null ? promoModel2.getAuthRequestContext : null;
        if (str != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            View findViewById = this.itemView.findViewById(R.id.SaveNumberOfLocationPermissionShownData);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            ImageAttacher.PlaceComponentResult(context, str, R.color.f22912131099753, (ImageView) findViewById);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VoucherListViewHolder(ViewGroup viewGroup, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        super(viewGroup.getContext(), R.layout.voucher_list_item_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoDiscoveryListItemListener;
    }

    public static /* synthetic */ void getAuthRequestContext(VoucherListViewHolder voucherListViewHolder, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(voucherListViewHolder, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        voucherListViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(promoModel);
    }
}

package id.dana.promodiscovery.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/promodiscovery/viewholder/BankPromoItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankPromoItemViewHolder extends BaseRecyclerViewHolder<PromoModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PromoModel promoModel) {
        final PromoModel promoModel2 = promoModel;
        String str = promoModel2 != null ? promoModel2.getAuthRequestContext : null;
        Context context = getContext();
        if (context != null) {
            new ImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(context, (AppCompatImageView) this.itemView.findViewById(R.id.MerchantPhotoViewerComponent), str, R.color.f22912131099753);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.BankPromoItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankPromoItemViewHolder.BuiltInFictitiousFunctionClassFactory(PromoModel.this, this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BankPromoItemViewHolder(ViewGroup viewGroup, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        super(viewGroup.getContext(), R.layout.bank_promo_item_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.getAuthRequestContext = promoDiscoveryListItemListener;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoModel promoModel, BankPromoItemViewHolder bankPromoItemViewHolder) {
        Intrinsics.checkNotNullParameter(bankPromoItemViewHolder, "");
        if (promoModel != null) {
            bankPromoItemViewHolder.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(promoModel);
        }
    }
}

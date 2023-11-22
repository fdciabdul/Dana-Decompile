package id.dana.nearbyme.merchantdetail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantLabelModel;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLabelBisnisViewHolder;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLabelHomeShoppingViewHolder;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLabelPromoViewHolder;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLabelQrisViewHolder;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLabelTopUpViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantLabelAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantLabelModel;", "", "p0", "getItemViewType", "(I)I", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "getAuthRequestContext", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLabelAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantLabelModel>, MerchantLabelModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantLabelPromoViewHolder merchantLabelQrisViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == MerchantLabelType.BISNIS.getValue()) {
            merchantLabelQrisViewHolder = new MerchantLabelBisnisViewHolder(viewGroup);
        } else if (i == MerchantLabelType.ORDER_ONLINE.getValue()) {
            merchantLabelQrisViewHolder = new MerchantLabelHomeShoppingViewHolder(viewGroup);
        } else if (i == MerchantLabelType.PROMO.getValue()) {
            merchantLabelQrisViewHolder = new MerchantLabelPromoViewHolder(viewGroup);
        } else if (i == MerchantLabelType.TOP_UP.getValue()) {
            merchantLabelQrisViewHolder = new MerchantLabelTopUpViewHolder(viewGroup);
        } else {
            merchantLabelQrisViewHolder = i == MerchantLabelType.QRIS.getValue() ? new MerchantLabelQrisViewHolder(viewGroup) : new MerchantLabelPromoViewHolder(viewGroup);
        }
        return merchantLabelQrisViewHolder;
    }

    public MerchantLabelAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItem(p0).KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

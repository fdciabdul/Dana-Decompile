package id.dana.promocenter.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocenter.viewholders.PromoSpecialAdsViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoSpecialAdsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoModel>, PromoModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    public PromoSpecialAdsAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PromoSpecialAdsViewHolder(this.KClassImpl$Data$declaredNonStaticMembers$2, viewGroup);
    }
}

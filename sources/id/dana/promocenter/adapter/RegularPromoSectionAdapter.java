package id.dana.promocenter.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.promocenter.model.PromoSectionModel;
import id.dana.promocenter.viewholders.RegularPromoSectionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/promocenter/adapter/RegularPromoSectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/promocenter/viewholders/RegularPromoSectionViewHolder;", "", "getItemCount", "()I", "Lid/dana/promocenter/model/PromoSectionModel;", "getAuthRequestContext", "Lid/dana/promocenter/model/PromoSectionModel;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/promocenter/model/PromoSectionModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegularPromoSectionAdapter extends RecyclerView.Adapter<RegularPromoSectionViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PromoSectionModel PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RegularPromoSectionViewHolder regularPromoSectionViewHolder, int i) {
        RegularPromoSectionViewHolder regularPromoSectionViewHolder2 = regularPromoSectionViewHolder;
        Intrinsics.checkNotNullParameter(regularPromoSectionViewHolder2, "");
        regularPromoSectionViewHolder2.bindData(this.PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RegularPromoSectionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new RegularPromoSectionViewHolder(viewGroup);
    }

    public RegularPromoSectionAdapter(PromoSectionModel promoSectionModel) {
        Intrinsics.checkNotNullParameter(promoSectionModel, "");
        this.PlaceComponentResult = promoSectionModel;
    }
}

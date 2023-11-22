package id.dana.promodiscovery.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.adapter.ActionButtonAdapter;
import id.dana.promodiscovery.model.ActionButtonModel;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/promodiscovery/viewholder/ReferralAndPromoCodeSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "Lid/dana/promodiscovery/model/ActionButtonModel;", "Lid/dana/promodiscovery/adapter/ActionButtonAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promodiscovery/adapter/ActionButtonAdapter;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralAndPromoCodeSectionViewHolder extends BaseRecyclerViewHolder<DiscoverySectionModel<ActionButtonModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private ActionButtonAdapter PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ViewGroup MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(DiscoverySectionModel<ActionButtonModel> discoverySectionModel) {
        DiscoverySectionModel<ActionButtonModel> discoverySectionModel2 = discoverySectionModel;
        super.bindData(discoverySectionModel2);
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_action_button_list);
        if (recyclerView != null) {
            recyclerView.setAdapter(this.PlaceComponentResult);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
        }
        this.PlaceComponentResult.setItems(discoverySectionModel2 != null ? discoverySectionModel2.KClassImpl$Data$declaredNonStaticMembers$2 : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralAndPromoCodeSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.referral_and_promo_code_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.MyBillsEntityDataFactory = viewGroup;
        this.PlaceComponentResult = new ActionButtonAdapter();
    }
}

package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter;
import id.dana.promodiscovery.adapter.VoucherListAdapter;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionHeaderView;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0004\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u0004\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0012\u0010\u0011\u001a\u00020\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u001aX\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u001b"}, d2 = {"Lid/dana/promodiscovery/viewholder/VoucherListSectionViewHolder;", "Lid/dana/promodiscovery/viewholder/BaseDiscoverySectionViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "MyBillsEntityDataFactory", "()Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "", "PlaceComponentResult", "()I", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "", "p0", "", "(Ljava/util/List;)V", "Lid/dana/promodiscovery/model/SectionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promodiscovery/model/SectionState;)V", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promodiscovery/adapter/VoucherListAdapter;", "Lid/dana/promodiscovery/adapter/VoucherListAdapter;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoucherListSectionViewHolder extends BaseDiscoverySectionViewHolder<PromoModel> {
    public ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PromoDiscoverySectionListener PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private VoucherListAdapter MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final int PlaceComponentResult() {
        return R.layout.voucher_list_skeleton_layout;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VoucherListSectionViewHolder(ViewGroup viewGroup, PromoDiscoverySectionListener promoDiscoverySectionListener, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        super(R.layout.voucher_list_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoverySectionListener, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.PlaceComponentResult = promoDiscoverySectionListener;
        this.BuiltInFictitiousFunctionClassFactory = promoDiscoveryListItemListener;
        this.MyBillsEntityDataFactory = new VoucherListAdapter(promoDiscoveryListItemListener);
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.setSectionListener(promoDiscoverySectionListener);
        }
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView2 = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView2 != null) {
            promoDiscoverySectionHeaderView2.setSortOption("NEW");
        }
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_voucher_list);
        if (recyclerView != null) {
            recyclerView.setAdapter(this.MyBillsEntityDataFactory);
            recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        }
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final void MyBillsEntityDataFactory(List<? extends PromoModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.renderSeeAllButton(true);
        }
        this.MyBillsEntityDataFactory.setItems(p0);
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SectionState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.renderSeeAllButton(false);
        }
        this.MyBillsEntityDataFactory.setItems(CollectionsKt.listOf(new PromoModel()));
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final View getAuthRequestContext() {
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.rv_voucher_list);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        return recyclerView;
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final BaseDiscoveryItemAdapter<PromoModel> MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}

package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.adapter.BankPromoItemAdapter;
import id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionHeaderView;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0004\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u0004\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u001aX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u001b"}, d2 = {"Lid/dana/promodiscovery/viewholder/BankPromoSectionViewHolder;", "Lid/dana/promodiscovery/viewholder/BaseDiscoverySectionViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "MyBillsEntityDataFactory", "()Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "", "PlaceComponentResult", "()I", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "", "p0", "", "(Ljava/util/List;)V", "Lid/dana/promodiscovery/model/SectionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promodiscovery/model/SectionState;)V", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/adapter/BankPromoItemAdapter;", "Lid/dana/promodiscovery/adapter/BankPromoItemAdapter;", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankPromoSectionViewHolder extends BaseDiscoverySectionViewHolder<PromoModel> {
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;
    private BankPromoItemAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PromoDiscoverySectionListener MyBillsEntityDataFactory;

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final int PlaceComponentResult() {
        return R.layout.voucher_list_skeleton_layout;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BankPromoSectionViewHolder(ViewGroup viewGroup, PromoDiscoverySectionListener promoDiscoverySectionListener, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        super(R.layout.bank_promo_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoverySectionListener, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
        this.MyBillsEntityDataFactory = promoDiscoverySectionListener;
        this.getAuthRequestContext = promoDiscoveryListItemListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new BankPromoItemAdapter(promoDiscoveryListItemListener);
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.getMissionTitle);
        recyclerView.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        ((PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable)).setSectionListener(promoDiscoverySectionListener);
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.setCategory("promocenter_category_bank");
        }
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final View getAuthRequestContext() {
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.getMissionTitle);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        return recyclerView;
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final void MyBillsEntityDataFactory(List<? extends PromoModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.renderSeeAllButton(true);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setItems(p0);
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SectionState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) this.itemView.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.renderSeeAllButton(false);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setItems(CollectionsKt.listOf(new PromoModel()));
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final BaseDiscoveryItemAdapter<PromoModel> MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}

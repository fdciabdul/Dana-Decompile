package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter;
import id.dana.promodiscovery.adapter.DanaDealsItemAdapter;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionHeaderView;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0004\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u0004\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016"}, d2 = {"Lid/dana/promodiscovery/viewholder/DanaDealsSectionViewHolder;", "Lid/dana/promodiscovery/viewholder/BaseDiscoverySectionViewHolder;", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "MyBillsEntityDataFactory", "()Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "", "PlaceComponentResult", "()I", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "", "p0", "", "(Ljava/util/List;)V", "Lid/dana/promodiscovery/model/SectionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promodiscovery/model/SectionState;)V", "Lid/dana/promodiscovery/adapter/DanaDealsItemAdapter;", "Lid/dana/promodiscovery/adapter/DanaDealsItemAdapter;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "Landroid/view/ViewGroup;", "p1", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDealsSectionViewHolder extends BaseDiscoverySectionViewHolder<ProductInfoDiscoveryModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PromoDiscoverySectionListener PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanaDealsItemAdapter MyBillsEntityDataFactory;

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final int PlaceComponentResult() {
        return R.layout.layout_dana_deals_skeleton;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaDealsSectionViewHolder(ViewGroup viewGroup, PromoDiscoverySectionListener promoDiscoverySectionListener, PromoDiscoveryListItemListener<? super ProductInfoDiscoveryModel> promoDiscoveryListItemListener) {
        super(R.layout.layout_dana_deals_section, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoverySectionListener, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.PlaceComponentResult = promoDiscoverySectionListener;
        DanaDealsItemAdapter danaDealsItemAdapter = new DanaDealsItemAdapter(promoDiscoveryListItemListener);
        this.MyBillsEntityDataFactory = danaDealsItemAdapter;
        View view = this.itemView;
        PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView = (PromoDiscoverySectionHeaderView) view.findViewById(R.id.res_0x7f0a11fc_observablepublishalt_innerdisposable);
        if (promoDiscoverySectionHeaderView != null) {
            promoDiscoverySectionHeaderView.setSectionListener(promoDiscoverySectionListener);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.res_0x7f0a10ee_random_2d5oskm);
        if (recyclerView != null) {
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setAdapter(danaDealsItemAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext(), 0, false));
        }
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final View getAuthRequestContext() {
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.res_0x7f0a10ee_random_2d5oskm);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        return recyclerView;
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final void MyBillsEntityDataFactory(List<? extends ProductInfoDiscoveryModel> p0) {
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
        this.MyBillsEntityDataFactory.setItems(CollectionsKt.listOf(new ProductInfoDiscoveryModel(null, null, null, null, null, null, null, null, false, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null)));
    }

    @Override // id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder
    public final BaseDiscoveryItemAdapter<ProductInfoDiscoveryModel> MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}

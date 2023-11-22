package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import id.dana.promodiscovery.viewholder.DanaDealsSectionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/promodiscovery/adapter/DanaDealsSectionAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "PlaceComponentResult", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "p1", "<init>", "(Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDealsSectionAdapter extends BaseDiscoverySectionAdapters<ProductInfoDiscoveryModel> {
    public final PromoDiscoverySectionListener PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PromoDiscoveryListItemListener<ProductInfoDiscoveryModel> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public DanaDealsSectionAdapter(PromoDiscoverySectionListener promoDiscoverySectionListener, PromoDiscoveryListItemListener<? super ProductInfoDiscoveryModel> promoDiscoveryListItemListener) {
        Intrinsics.checkNotNullParameter(promoDiscoverySectionListener, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.PlaceComponentResult = promoDiscoverySectionListener;
        this.BuiltInFictitiousFunctionClassFactory = promoDiscoveryListItemListener;
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters
    public final BaseRecyclerViewHolder<DiscoverySectionModel<ProductInfoDiscoveryModel>> getAuthRequestContext(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new DanaDealsSectionViewHolder(p0, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
    }
}

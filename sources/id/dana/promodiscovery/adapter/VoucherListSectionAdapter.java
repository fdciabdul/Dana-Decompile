package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import id.dana.promodiscovery.viewholder.VoucherListSectionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\r"}, d2 = {"Lid/dana/promodiscovery/adapter/VoucherListSectionAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "Lid/dana/promocenter/model/PromoModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "PlaceComponentResult", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoucherListSectionAdapter extends BaseDiscoverySectionAdapters<PromoModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PromoDiscoverySectionListener BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public VoucherListSectionAdapter(PromoDiscoverySectionListener promoDiscoverySectionListener, PromoDiscoveryListItemListener<? super PromoModel> promoDiscoveryListItemListener) {
        Intrinsics.checkNotNullParameter(promoDiscoverySectionListener, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.BuiltInFictitiousFunctionClassFactory = promoDiscoverySectionListener;
        this.getAuthRequestContext = promoDiscoveryListItemListener;
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters
    public final BaseRecyclerViewHolder<DiscoverySectionModel<PromoModel>> getAuthRequestContext(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new VoucherListSectionViewHolder(p0, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
    }
}

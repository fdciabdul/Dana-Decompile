package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.model.FourKingModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.viewholder.FourKingSectionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0012\u0010\f\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/promodiscovery/adapter/FourKingSectionAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "Lid/dana/promodiscovery/model/FourKingModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Lid/dana/promodiscovery/adapter/FourKingSectionAdapter$PromoQuestStatus;", "PlaceComponentResult", "Lid/dana/promodiscovery/adapter/FourKingSectionAdapter$PromoQuestStatus;", "<init>", "(Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V", "PromoQuestStatus"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FourKingSectionAdapter extends BaseDiscoverySectionAdapters<FourKingModel> {
    public PromoQuestStatus PlaceComponentResult;
    public final PromoDiscoveryListItemListener<FourKingModel> getAuthRequestContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/promodiscovery/adapter/FourKingSectionAdapter$PromoQuestStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "MAINTENANCE", NewSwitchFaceAuthenticationView.DISABLED}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum PromoQuestStatus {
        ENABLED,
        MAINTENANCE,
        DISABLED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FourKingSectionAdapter(PromoDiscoveryListItemListener<? super FourKingModel> promoDiscoveryListItemListener) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.getAuthRequestContext = promoDiscoveryListItemListener;
        this.PlaceComponentResult = PromoQuestStatus.DISABLED;
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters
    public final BaseRecyclerViewHolder<DiscoverySectionModel<FourKingModel>> getAuthRequestContext(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new FourKingSectionViewHolder(p0, this.getAuthRequestContext);
    }
}

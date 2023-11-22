package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.ActionButtonModel;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.viewholder.ReferralAndPromoCodeSectionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/promodiscovery/adapter/ReferralAndPromoCodeSectionAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "Lid/dana/promodiscovery/model/ActionButtonModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralAndPromoCodeSectionAdapter extends BaseDiscoverySectionAdapters<ActionButtonModel> {
    @Override // id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters
    public final BaseRecyclerViewHolder<DiscoverySectionModel<ActionButtonModel>> getAuthRequestContext(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new ReferralAndPromoCodeSectionViewHolder(p0);
    }
}

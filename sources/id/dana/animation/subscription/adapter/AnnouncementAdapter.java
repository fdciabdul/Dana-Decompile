package id.dana.animation.subscription.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.animation.subscription.viewholder.AnnouncementInfoViewHolder;
import id.dana.animation.subscription.viewholder.AnnouncementViewHolder;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.CdpContentModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \f2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/home/subscription/adapter/AnnouncementAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/CdpContentModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnnouncementAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<CdpContentModel>, CdpContentModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AnnouncementViewHolder announcementViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 2) {
            announcementViewHolder = new AnnouncementInfoViewHolder(viewGroup);
        } else {
            announcementViewHolder = new AnnouncementViewHolder(viewGroup);
        }
        return announcementViewHolder;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getGetAuthRequestContext() {
        int getAuthRequestContext = super.getGetAuthRequestContext();
        boolean z = false;
        if (getAuthRequestContext > 0 && getAuthRequestContext < 3) {
            z = true;
        }
        return z ? getAuthRequestContext + 1 : getAuthRequestContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        List<CdpContentModel> items = getItems();
        boolean z = false;
        int size = items != null ? items.size() : 0;
        if (size > 0 && size < 3) {
            z = true;
        }
        return (z && p0 == size) ? 2 : 1;
    }
}

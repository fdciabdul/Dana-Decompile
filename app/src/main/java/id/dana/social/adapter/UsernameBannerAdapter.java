package id.dana.social.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.viewholder.UsernameBannerViewHolder;
import id.dana.social.v2.viewholder.FeedUsernameBannerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/social/adapter/UsernameBannerAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function0;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UsernameBannerAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<Integer>, Integer> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        UsernameBannerViewHolder usernameBannerViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            usernameBannerViewHolder = new UsernameBannerViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 2) {
            usernameBannerViewHolder = new FeedUsernameBannerViewHolder(viewGroup, this.getAuthRequestContext);
        } else {
            throw new IllegalStateException();
        }
        return usernameBannerViewHolder;
    }

    public UsernameBannerAdapter(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.getAuthRequestContext = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        Integer num = getItems().get(p0);
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num.intValue();
    }
}

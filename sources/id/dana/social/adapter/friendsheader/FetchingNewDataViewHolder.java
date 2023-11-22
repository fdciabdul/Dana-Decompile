package id.dana.social.adapter.friendsheader;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/social/adapter/friendsheader/FetchingNewDataViewHolder;", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchingNewDataViewHolder<T> extends BaseRecyclerViewHolder<T> {
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchingNewDataViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_fetching_new_data, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
    }
}

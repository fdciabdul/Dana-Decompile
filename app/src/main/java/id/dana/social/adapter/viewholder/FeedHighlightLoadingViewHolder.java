package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.social.model.FeedHighlightModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedHighlightLoadingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedHighlightModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHighlightLoadingViewHolder extends BaseRecyclerViewHolder<FeedHighlightModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHighlightLoadingViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_feed_highlight_loading, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0b56_windowinsetscompat_builderimpl20);
        if (appCompatImageView != null) {
            ViewExtKt.getAuthRequestContext((View) appCompatImageView);
        }
    }
}

package id.dana.news.viewholders;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.feeds.views.FeedsWrapperViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/news/viewholders/NewsLoadingViewHolder;", "Lid/dana/feeds/views/FeedsWrapperViewHolder;", "Landroid/content/Context;", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsLoadingViewHolder extends FeedsWrapperViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsLoadingViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.news_loading_viewholder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

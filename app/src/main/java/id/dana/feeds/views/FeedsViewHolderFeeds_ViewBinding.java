package id.dana.feeds.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class FeedsViewHolderFeeds_ViewBinding implements Unbinder {
    private FeedsViewHolderFeeds getAuthRequestContext;

    public FeedsViewHolderFeeds_ViewBinding(FeedsViewHolderFeeds feedsViewHolderFeeds, View view) {
        this.getAuthRequestContext = feedsViewHolderFeeds;
        feedsViewHolderFeeds.content = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feed_content, "field 'content'", TextView.class);
        feedsViewHolderFeeds.delete = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feed_delete, "field 'delete'", TextView.class);
        feedsViewHolderFeeds.feedWrapper = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feed_wrapper, "field 'feedWrapper'", RelativeLayout.class);
        feedsViewHolderFeeds.iconFeeds = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feed_icon, "field 'iconFeeds'", ImageView.class);
        feedsViewHolderFeeds.time = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.feed_time, "field 'time'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        FeedsViewHolderFeeds feedsViewHolderFeeds = this.getAuthRequestContext;
        if (feedsViewHolderFeeds == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        feedsViewHolderFeeds.content = null;
        feedsViewHolderFeeds.delete = null;
        feedsViewHolderFeeds.feedWrapper = null;
        feedsViewHolderFeeds.iconFeeds = null;
        feedsViewHolderFeeds.time = null;
    }
}

package id.dana.feeds.views;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class FeedsFooterViewHolderFeeds_ViewBinding implements Unbinder {
    private FeedsFooterViewHolderFeeds MyBillsEntityDataFactory;

    public FeedsFooterViewHolderFeeds_ViewBinding(FeedsFooterViewHolderFeeds feedsFooterViewHolderFeeds, View view) {
        this.MyBillsEntityDataFactory = feedsFooterViewHolderFeeds;
        feedsFooterViewHolderFeeds.btnFeedFooter = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_feed_footer, "field 'btnFeedFooter'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        FeedsFooterViewHolderFeeds feedsFooterViewHolderFeeds = this.MyBillsEntityDataFactory;
        if (feedsFooterViewHolderFeeds == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        feedsFooterViewHolderFeeds.btnFeedFooter = null;
    }
}

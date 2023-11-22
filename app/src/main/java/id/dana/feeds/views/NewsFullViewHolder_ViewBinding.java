package id.dana.feeds.views;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class NewsFullViewHolder_ViewBinding implements Unbinder {
    private NewsFullViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

    public NewsFullViewHolder_ViewBinding(NewsFullViewHolder newsFullViewHolder, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newsFullViewHolder;
        newsFullViewHolder.ivFullNewsFeed = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_full_news_feeds, "field 'ivFullNewsFeed'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NewsFullViewHolder newsFullViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (newsFullViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        newsFullViewHolder.ivFullNewsFeed = null;
    }
}

package id.dana.news.viewholders;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class NewsFullViewHolder_ViewBinding implements Unbinder {
    private NewsFullViewHolder MyBillsEntityDataFactory;

    public NewsFullViewHolder_ViewBinding(NewsFullViewHolder newsFullViewHolder, View view) {
        this.MyBillsEntityDataFactory = newsFullViewHolder;
        newsFullViewHolder.ivFullNewsFeed = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_full_news_feeds, "field 'ivFullNewsFeed'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NewsFullViewHolder newsFullViewHolder = this.MyBillsEntityDataFactory;
        if (newsFullViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        newsFullViewHolder.ivFullNewsFeed = null;
    }
}

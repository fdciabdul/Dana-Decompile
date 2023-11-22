package id.dana.news.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class NewsViewHolderNews_ViewBinding implements Unbinder {
    private NewsViewHolderNews MyBillsEntityDataFactory;

    public NewsViewHolderNews_ViewBinding(NewsViewHolderNews newsViewHolderNews, View view) {
        this.MyBillsEntityDataFactory = newsViewHolderNews;
        newsViewHolderNews.content = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.news_content, "field 'content'", TextView.class);
        newsViewHolderNews.feedWrapper = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.news_wrapper, "field 'feedWrapper'", RelativeLayout.class);
        newsViewHolderNews.iconFeeds = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.news_icon, "field 'iconFeeds'", ImageView.class);
        newsViewHolderNews.title = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.news_title, "field 'title'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NewsViewHolderNews newsViewHolderNews = this.MyBillsEntityDataFactory;
        if (newsViewHolderNews == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        newsViewHolderNews.content = null;
        newsViewHolderNews.feedWrapper = null;
        newsViewHolderNews.iconFeeds = null;
        newsViewHolderNews.title = null;
    }
}

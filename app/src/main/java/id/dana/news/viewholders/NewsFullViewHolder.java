package id.dana.news.viewholders;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.model.ActivityModel;
import id.dana.feeds.views.FeedsWrapperViewHolder;
import id.dana.utils.ImageOss;

/* loaded from: classes5.dex */
public class NewsFullViewHolder extends FeedsWrapperViewHolder {
    @BindView(R.id.iv_full_news_feeds)
    ImageView ivFullNewsFeed;

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ActivityModel activityModel) {
        bindData(activityModel);
    }

    public NewsFullViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_full_news_feed, viewGroup);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder
    /* renamed from: PlaceComponentResult */
    public final void bindData(ActivityModel activityModel) {
        if (activityModel == null || TextUtils.isEmpty(activityModel.getErrorConfigVersion)) {
            return;
        }
        ImageOss.MyBillsEntityDataFactory(activityModel.getErrorConfigVersion, this.ivFullNewsFeed, new ImageOss.EventListener() { // from class: id.dana.news.viewholders.NewsFullViewHolder$$ExternalSyntheticLambda0
            @Override // id.dana.utils.ImageOss.EventListener
            public final void PlaceComponentResult(String str, ImageView imageView) {
                GlideApp.getAuthRequestContext(NewsFullViewHolder.this.getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.square_rounded_skeleton).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).PlaceComponentResult((int) R.drawable.square_rounded_skeleton).MyBillsEntityDataFactory(imageView);
            }
        });
    }
}

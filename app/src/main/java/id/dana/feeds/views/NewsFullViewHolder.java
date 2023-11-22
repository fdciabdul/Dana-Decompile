package id.dana.feeds.views;

import android.text.TextUtils;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.model.ActivityModel;
import id.dana.utils.ImageOss;

/* loaded from: classes8.dex */
public class NewsFullViewHolder extends FeedsWrapperViewHolder {
    @BindView(R.id.iv_full_news_feeds)
    ImageView ivFullNewsFeed;

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ActivityModel activityModel) {
        bindData(activityModel);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder
    /* renamed from: PlaceComponentResult */
    public final void bindData(ActivityModel activityModel) {
        if (activityModel == null || TextUtils.isEmpty(activityModel.getErrorConfigVersion)) {
            return;
        }
        ImageOss.MyBillsEntityDataFactory(activityModel.getErrorConfigVersion, this.ivFullNewsFeed, new ImageOss.EventListener() { // from class: id.dana.feeds.views.NewsFullViewHolder$$ExternalSyntheticLambda0
            @Override // id.dana.utils.ImageOss.EventListener
            public final void PlaceComponentResult(String str, ImageView imageView) {
                GlideApp.getAuthRequestContext(NewsFullViewHolder.this.getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.square_rounded_skeleton).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).PlaceComponentResult((int) R.drawable.square_rounded_skeleton).MyBillsEntityDataFactory(imageView);
            }
        });
    }
}

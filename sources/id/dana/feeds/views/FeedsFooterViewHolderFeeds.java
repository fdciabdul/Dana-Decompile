package id.dana.feeds.views;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import id.dana.R;
import id.dana.feeds.model.ActivityModel;

/* loaded from: classes8.dex */
public class FeedsFooterViewHolderFeeds extends FeedsWrapperViewHolder {
    public FooterFeedsViewHolderActions PlaceComponentResult;
    @BindView(R.id.btn_feed_footer)
    Button btnFeedFooter;

    /* loaded from: classes8.dex */
    public interface FooterFeedsViewHolderActions {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ActivityModel activityModel) {
        this.btnFeedFooter.setOnClickListener(new FeedsFooterViewHolderFeeds$$ExternalSyntheticLambda0(this));
    }

    public FeedsFooterViewHolderFeeds(Context context, ViewGroup viewGroup) {
        super(context, R.layout.cardview_feed_footer, viewGroup);
    }

    @Override // id.dana.feeds.views.FeedsWrapperViewHolder
    /* renamed from: PlaceComponentResult */
    public final void bindData(ActivityModel activityModel) {
        this.btnFeedFooter.setOnClickListener(new FeedsFooterViewHolderFeeds$$ExternalSyntheticLambda0(this));
    }
}

package id.dana.social.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/FeedNotificationSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNotificationSectionViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel;
        TextView textView;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 == null || (feedModel = feedViewHolderModel2.MyBillsEntityDataFactory) == null || (textView = (TextView) this.itemView.findViewById(R.id.res_0x7f0a18bd_getstaticqrpresenter_getdynamicprofileqr_2_1)) == null) {
            return;
        }
        textView.setText(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNotificationSectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_feed_notification_section, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

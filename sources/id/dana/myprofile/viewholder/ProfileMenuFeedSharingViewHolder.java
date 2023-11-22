package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.model.InitFeed;
import id.dana.social.state.InitFeedState;
import id.dana.social.view.FeedSharingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuFeedSharingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuFeedSharingViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        super.bindData(settingModel2);
        if (settingModel2 != null) {
            FeedSharingView feedSharingView = (FeedSharingView) this.itemView.findViewById(R.id.view_feed_sharing);
            if (feedSharingView != null) {
                InitFeedState.Companion companion = InitFeedState.INSTANCE;
                InitFeed initFeedStatus = settingModel2.getInitFeedStatus();
                Intrinsics.checkNotNullExpressionValue(initFeedStatus, "");
                feedSharingView.render(InitFeedState.Companion.BuiltInFictitiousFunctionClassFactory(initFeedStatus));
            }
            boolean isFromFeeds = settingModel2.isFromFeeds();
            FeedSharingView feedSharingView2 = (FeedSharingView) this.itemView.findViewById(R.id.view_feed_sharing);
            if (feedSharingView2 != null) {
                feedSharingView2.setFromFeeds(isFromFeeds);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuFeedSharingViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_profile_feed_sharing, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}

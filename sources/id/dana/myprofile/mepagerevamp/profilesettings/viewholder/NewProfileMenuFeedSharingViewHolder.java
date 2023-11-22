package id.dana.myprofile.mepagerevamp.profilesettings.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.model.InitFeed;
import id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView;
import id.dana.nearbyme.OnRedirectListener;
import id.dana.social.state.InitFeedState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/viewholder/NewProfileMenuFeedSharingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/nearbyme/OnRedirectListener;", "PlaceComponentResult", "Lid/dana/nearbyme/OnRedirectListener;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/nearbyme/OnRedirectListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuFeedSharingViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    private final OnRedirectListener PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        super.bindData(settingModel2);
        if (settingModel2 != null) {
            NewFeedSharingView newFeedSharingView = (NewFeedSharingView) this.itemView.findViewById(R.id.view_feed_sharing);
            if (newFeedSharingView != null) {
                newFeedSharingView.setOnRedirectListener(this.PlaceComponentResult);
            }
            NewFeedSharingView newFeedSharingView2 = (NewFeedSharingView) this.itemView.findViewById(R.id.view_feed_sharing);
            if (newFeedSharingView2 != null) {
                InitFeedState.Companion companion = InitFeedState.INSTANCE;
                InitFeed initFeedStatus = settingModel2.getInitFeedStatus();
                Intrinsics.checkNotNullExpressionValue(initFeedStatus, "");
                newFeedSharingView2.render(InitFeedState.Companion.BuiltInFictitiousFunctionClassFactory(initFeedStatus));
            }
            boolean isFromFeeds = settingModel2.isFromFeeds();
            NewFeedSharingView newFeedSharingView3 = (NewFeedSharingView) this.itemView.findViewById(R.id.view_feed_sharing);
            if (newFeedSharingView3 != null) {
                newFeedSharingView3.setFromFeedsSettingIcon(isFromFeeds);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileMenuFeedSharingViewHolder(ViewGroup viewGroup, OnRedirectListener onRedirectListener) {
        super(viewGroup.getContext(), R.layout.new_item_profile_feed_sharing, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.PlaceComponentResult = onRedirectListener;
    }
}

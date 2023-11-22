package id.dana.social.adapter;

import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.utils.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Lid/dana/social/adapter/SocialFeedClickListener;", "", "approveFriendRequestButtonClicked", "", "targetUserId", "", "username", "declineFriendRequestButtonClicked", "onActivateFeed", "onActivityWidgetClicked", "activityWidgetModel", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "onAddFeedReaction", "feedModel", "Lid/dana/social/model/FeedModel;", "onAddFriendButtonClicked", "userId", "onCancelFriendButtonClicked", "onClickCtaButton", "cta", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "phoneNumber", "onDealsUniqueValueWidgetClicked", "contentType", "dealsPayloadModel", "Lid/dana/feeds/ui/model/DealsPayloadModel;", "onDeleteCreateActivity", "itemPosition", "", "onEditProfileClicked", "onFeedAvatarImageClicked", "friendModel", "Lid/dana/feeds/ui/model/FriendModel;", "onFriendListClicked", "onGroupedContentClicked", "onItemClicked", "onLoadMoreClicked", "onMoreFeedReactionClicked", "onProfileHeaderNameSectionClicked", "onReactionClicked", "reactionCountModel", "Lid/dana/social/model/ReactionCountModel;", "onRetryCreateActivity", "onSeeAllButtonClick", "onSocialFeedSpanClicked", "content", "Lid/dana/social/utils/Content;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SocialFeedClickListener {

    /* renamed from: id.dana.social.adapter.SocialFeedClickListener$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(FriendModel friendModel) {
            Intrinsics.checkNotNullParameter(friendModel, "");
        }

        public static void BuiltInFictitiousFunctionClassFactory(ReactionCountModel reactionCountModel) {
            Intrinsics.checkNotNullParameter(reactionCountModel, "");
        }

        public static void MyBillsEntityDataFactory() {
        }

        public static void MyBillsEntityDataFactory(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
        }

        public static void PlaceComponentResult() {
        }

        public static void PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        public static void getAuthRequestContext() {
        }

        public static void getAuthRequestContext(ProfileCtaConfig profileCtaConfig, String str, String str2) {
            Intrinsics.checkNotNullParameter(profileCtaConfig, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
        }

        public static void getAuthRequestContext(ActivityWidgetModel activityWidgetModel) {
            Intrinsics.checkNotNullParameter(activityWidgetModel, "");
        }

        public static void getAuthRequestContext(String str, DealsPayloadModel dealsPayloadModel) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(dealsPayloadModel, "");
        }

        public static void getAuthRequestContext(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
        }
    }

    void BuiltInFictitiousFunctionClassFactory(int i);

    void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel activityWidgetModel);

    void BuiltInFictitiousFunctionClassFactory(FriendModel friendModel);

    void BuiltInFictitiousFunctionClassFactory(ReactionCountModel reactionCountModel);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(int i);

    void KClassImpl$Data$declaredNonStaticMembers$2(ProfileCtaConfig profileCtaConfig, String str, String str2);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str);

    void MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(int i);

    void PlaceComponentResult();

    void PlaceComponentResult(int i);

    void PlaceComponentResult(String str);

    void PlaceComponentResult(String str, String str2);

    void getAuthRequestContext();

    void getAuthRequestContext(int i);

    void getAuthRequestContext(Content content);

    void getAuthRequestContext(String str, DealsPayloadModel dealsPayloadModel);

    void getAuthRequestContext(String str, String str2);
}

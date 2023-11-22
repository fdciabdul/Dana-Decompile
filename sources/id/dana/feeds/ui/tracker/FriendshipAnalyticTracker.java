package id.dana.feeds.ui.tracker;

import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.feeds.ui.model.FeedTrackerModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J:\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000eH&J\u0012\u0010'\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0005H&J\b\u0010,\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0001"}, d2 = {"Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "", "trackAcceptFriendRequest", "", "source", "", "trackDeclineFriendRequest", "trackDisplayedError", "throwable", "", "operationType", "displayedMessage", "trackFeedActivation", "isFirstTime", "", "trackFeedActivityOpen", "trackFeedCommentAdd", "contentType", "trackFeedDeactivation", "trackFeedRead", "notificationId", "redirectType", ShareToFeedBridge.REDIRECT_VALUE, IpcMessageConstants.EXTRA_EVENT, "usecaseType", "trackFeedReplyCommentAdd", "trackFriendFeedOpen", "trackFriendProfileOpen", "trackFriendshipEmojiAdd", "emojiType", "trackFriendshipFeedActivitySubmit", "trackFriendshipFeedsRead", "feedTrackerModel", "Lid/dana/feeds/ui/model/FeedTrackerModel;", "trackFriendshipFriendAdd", "trackFriendshipFriendSearchOpen", "trackFriendshipNotificationOpen", "trackFriendshipSetPrivacy", "isSharedToFriend", "trackInboxOpen", "trackNotificationInboxRead", "trackOnFollowerModifyRelationship", "active", "trackOnFollowingModifyRelationship", "trackOnFriendshipBottomSheetShow", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendshipAnalyticTracker {
    void BuiltInFictitiousFunctionClassFactory();

    void BuiltInFictitiousFunctionClassFactory(String str);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(FeedTrackerModel feedTrackerModel);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

    void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

    void MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(String str);

    void MyBillsEntityDataFactory(Throwable th, String str, String str2, String str3);

    void NetworkUserEntityData$$ExternalSyntheticLambda0(String str);

    void PlaceComponentResult();

    void PlaceComponentResult(String str);

    void PlaceComponentResult(boolean z);

    void getAuthRequestContext();

    void getAuthRequestContext(FeedTrackerModel feedTrackerModel);

    void getAuthRequestContext(String str);

    void getErrorConfigVersion(String str);

    void lookAheadTest(String str);

    void moveToNextValue(String str);

    void scheduleImpl(String str);
}

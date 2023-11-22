package id.dana.social.mapper;

import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.ui.model.FriendModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/feeds/ui/model/FriendModel;", "PlaceComponentResult", "(Lid/dana/feeds/domain/timeline/model/ActivityResponse;)Lid/dana/feeds/ui/model/FriendModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentFriendsShareFeedsMapperKt {
    public static final FriendModel PlaceComponentResult(ActivityResponse activityResponse) {
        Intrinsics.checkNotNullParameter(activityResponse, "");
        HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
        String nickName = extendInfo != null ? ExtendInfoUtilKt.getNickName(extendInfo) : null;
        String str = nickName == null ? "" : nickName;
        HashMap<String, String> extendInfo2 = activityResponse.getExtendInfo();
        String profileAvatar = extendInfo2 != null ? ExtendInfoUtilKt.getProfileAvatar(extendInfo2) : null;
        String str2 = profileAvatar == null ? "" : profileAvatar;
        HashMap<String, String> extendInfo3 = activityResponse.getExtendInfo();
        String userId = extendInfo3 != null ? ExtendInfoUtilKt.getUserId(extendInfo3) : null;
        return new FriendModel(str, str2, userId == null ? "" : userId, false, null, null, null, 0, false, 0L, false, 2040, null);
    }
}

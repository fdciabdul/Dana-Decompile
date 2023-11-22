package id.dana.feeds.data.friend.source.network.mapper;

import id.dana.feeds.data.friend.source.network.response.FriendResponse;
import id.dana.feeds.data.friend.source.network.response.IncomingFriendRequestResponse;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.domain.friend.model.FriendRequestList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/data/friend/source/network/response/FriendResponse;", "", "p0", "Lid/dana/feeds/domain/friend/model/Friend;", "getAuthRequestContext", "(Lid/dana/feeds/data/friend/source/network/response/FriendResponse;Ljava/lang/String;)Lid/dana/feeds/domain/friend/model/Friend;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendResponseMapperKt {
    public static final Friend getAuthRequestContext(FriendResponse friendResponse, String str) {
        Intrinsics.checkNotNullParameter(friendResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        String avatarUrl = friendResponse.getAvatarUrl();
        String str2 = avatarUrl == null ? "" : avatarUrl;
        String userId = friendResponse.getUserId();
        String str3 = userId == null ? "" : userId;
        String username = friendResponse.getUsername();
        String str4 = username == null ? "" : username;
        String userKYCName = friendResponse.getUserKYCName();
        String str5 = userKYCName == null ? "" : userKYCName;
        String status = friendResponse.getStatus();
        String str6 = status == null ? "" : status;
        Boolean defaultUsername = friendResponse.getDefaultUsername();
        boolean booleanValue = defaultUsername != null ? defaultUsername.booleanValue() : false;
        Long requestDate = friendResponse.getRequestDate();
        long longValue = requestDate != null ? requestDate.longValue() : 0L;
        String requesterUserId = friendResponse.getRequesterUserId();
        return new Friend(str2, str3, str4, str5, str6, booleanValue, longValue, !(requesterUserId == null || requesterUserId.length() == 0) && Intrinsics.areEqual(friendResponse.getRequesterUserId(), str));
    }

    public static /* synthetic */ FriendRequestList PlaceComponentResult(IncomingFriendRequestResponse incomingFriendRequestResponse) {
        ArrayList emptyList;
        Intrinsics.checkNotNullParameter(incomingFriendRequestResponse, "");
        Intrinsics.checkNotNullParameter("", "");
        List<FriendResponse> friendList = incomingFriendRequestResponse.getFriendList();
        if (friendList == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<FriendResponse> list = friendList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getAuthRequestContext((FriendResponse) it.next(), ""));
            }
            emptyList = arrayList;
        }
        Integer totalCount = incomingFriendRequestResponse.getTotalCount();
        int intValue = totalCount != null ? totalCount.intValue() : 0;
        String minId = incomingFriendRequestResponse.getMinId();
        String str = minId != null ? minId : "";
        Boolean hasMore = incomingFriendRequestResponse.getHasMore();
        return new FriendRequestList(emptyList, intValue, str, hasMore != null ? hasMore.booleanValue() : false);
    }
}

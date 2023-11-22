package id.dana.feeds.data.friend.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.friend.source.network.request.AddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.CancelAddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.FriendListRequest;
import id.dana.feeds.data.friend.source.network.request.IncomingFriendRequest;
import id.dana.feeds.data.friend.source.network.response.FriendListResponse;
import id.dana.feeds.data.friend.source.network.response.IncomingFriendRequestResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/friend/source/network/FriendFacade;", "", "Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;", "addFriendRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "addFriend", "(Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;", "cancelAddFriendRequest", "cancelAddFriend", "(Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;", "incomingFriendRequest", "Lid/dana/feeds/data/friend/source/network/response/IncomingFriendRequestResponse;", "fetchFriendRequest", "(Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;)Lid/dana/feeds/data/friend/source/network/response/IncomingFriendRequestResponse;", "Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;", "friendListRequest", "Lid/dana/feeds/data/friend/source/network/response/FriendListResponse;", "findFriends", "(Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;)Lid/dana/feeds/data/friend/source/network/response/FriendListResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.PlaceComponentResult;

    @OperationType("id.dana.feedengine.friendship.addFriend")
    @SignCheck
    BaseRpcResult addFriend(AddFriendRequest addFriendRequest);

    @OperationType("id.dana.feedengine.friendship.cancelRequest")
    @SignCheck
    BaseRpcResult cancelAddFriend(CancelAddFriendRequest cancelAddFriendRequest);

    @OperationType("id.dana.feedengine.friendship.incomingRequestList")
    @SignCheck
    IncomingFriendRequestResponse fetchFriendRequest(IncomingFriendRequest incomingFriendRequest);

    @OperationType("id.dana.feedengine.friendship.findFriends")
    @SignCheck
    FriendListResponse findFriends(FriendListRequest friendListRequest);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/friend/source/network/FriendFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion PlaceComponentResult = new Companion();

        private Companion() {
        }
    }
}

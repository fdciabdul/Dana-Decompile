package id.dana.feeds.data.friend.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.friend.source.network.request.AddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.CancelAddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.FriendListRequest;
import id.dana.feeds.data.friend.source.network.request.IncomingFriendRequest;
import id.dana.feeds.data.friend.source.network.response.FriendListResponse;
import id.dana.feeds.data.friend.source.network.response.IncomingFriendRequestResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/friend/source/FriendEntityData;", "", "Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;", "Lid/dana/feeds/data/friend/source/network/response/IncomingFriendRequestResponse;", "PlaceComponentResult", "(Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;", "Lid/dana/feeds/data/friend/source/network/response/FriendListResponse;", "getAuthRequestContext", "(Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FriendEntityData {
    Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(AddFriendRequest p0);

    Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(CancelAddFriendRequest p0);

    Observable<IncomingFriendRequestResponse> PlaceComponentResult(IncomingFriendRequest p0);

    Observable<FriendListResponse> getAuthRequestContext(FriendListRequest p0);
}

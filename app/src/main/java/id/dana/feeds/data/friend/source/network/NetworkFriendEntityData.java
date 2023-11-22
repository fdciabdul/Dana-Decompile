package id.dana.feeds.data.friend.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.friend.source.FriendEntityData;
import id.dana.feeds.data.friend.source.network.request.AddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.CancelAddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.FriendListRequest;
import id.dana.feeds.data.friend.source.network.request.IncomingFriendRequest;
import id.dana.feeds.data.friend.source.network.response.FriendListResponse;
import id.dana.feeds.data.friend.source.network.response.IncomingFriendRequestResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/feeds/data/friend/source/network/NetworkFriendEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/friend/source/network/FriendFacade;", "Lid/dana/feeds/data/friend/source/FriendEntityData;", "Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/friend/source/network/request/AddFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/data/friend/source/network/request/CancelAddFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;", "Lid/dana/feeds/data/friend/source/network/response/IncomingFriendRequestResponse;", "PlaceComponentResult", "(Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;", "Lid/dana/feeds/data/friend/source/network/response/FriendListResponse;", "getAuthRequestContext", "(Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkFriendEntityData extends SecureBaseNetwork<FriendFacade> implements FriendEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FriendFacade> getFacadeClass() {
        return FriendFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFriendEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.friend.source.FriendEntityData
    public final Observable<FriendListResponse> getAuthRequestContext(final FriendListRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.friend.source.network.NetworkFriendEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFriendEntityData.MyBillsEntityDataFactory(FriendListRequest.this, this, (FriendFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.friend.source.FriendEntityData
    public final Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(final AddFriendRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.friend.source.network.NetworkFriendEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFriendEntityData.PlaceComponentResult(AddFriendRequest.this, this, (FriendFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.friend.source.FriendEntityData
    public final Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(final CancelAddFriendRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.friend.source.network.NetworkFriendEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFriendEntityData.KClassImpl$Data$declaredNonStaticMembers$2(CancelAddFriendRequest.this, this, (FriendFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.friend.source.FriendEntityData
    public final Observable<IncomingFriendRequestResponse> PlaceComponentResult(final IncomingFriendRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.friend.source.network.NetworkFriendEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFriendEntityData.KClassImpl$Data$declaredNonStaticMembers$2(IncomingFriendRequest.this, this, (FriendFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ IncomingFriendRequestResponse KClassImpl$Data$declaredNonStaticMembers$2(IncomingFriendRequest incomingFriendRequest, NetworkFriendEntityData networkFriendEntityData, FriendFacade friendFacade) {
        Intrinsics.checkNotNullParameter(incomingFriendRequest, "");
        Intrinsics.checkNotNullParameter(networkFriendEntityData, "");
        incomingFriendRequest.envInfo = networkFriendEntityData.generateMobileEnvInfo();
        return friendFacade.fetchFriendRequest(incomingFriendRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(CancelAddFriendRequest cancelAddFriendRequest, NetworkFriendEntityData networkFriendEntityData, FriendFacade friendFacade) {
        Intrinsics.checkNotNullParameter(cancelAddFriendRequest, "");
        Intrinsics.checkNotNullParameter(networkFriendEntityData, "");
        cancelAddFriendRequest.envInfo = networkFriendEntityData.generateMobileEnvInfo();
        return friendFacade.cancelAddFriend(cancelAddFriendRequest);
    }

    public static /* synthetic */ FriendListResponse MyBillsEntityDataFactory(FriendListRequest friendListRequest, NetworkFriendEntityData networkFriendEntityData, FriendFacade friendFacade) {
        Intrinsics.checkNotNullParameter(friendListRequest, "");
        Intrinsics.checkNotNullParameter(networkFriendEntityData, "");
        friendListRequest.envInfo = networkFriendEntityData.generateMobileEnvInfo();
        return friendFacade.findFriends(friendListRequest);
    }

    public static /* synthetic */ BaseRpcResult PlaceComponentResult(AddFriendRequest addFriendRequest, NetworkFriendEntityData networkFriendEntityData, FriendFacade friendFacade) {
        Intrinsics.checkNotNullParameter(addFriendRequest, "");
        Intrinsics.checkNotNullParameter(networkFriendEntityData, "");
        addFriendRequest.envInfo = networkFriendEntityData.generateMobileEnvInfo();
        return friendFacade.addFriend(addFriendRequest);
    }
}

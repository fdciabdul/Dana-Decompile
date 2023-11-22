package id.dana.feeds.data.relationship.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData;
import id.dana.feeds.data.relationship.source.network.request.FriendRequestApprovalRequest;
import id.dana.feeds.data.relationship.source.network.request.FriendRequestDeclineRequest;
import id.dana.feeds.data.relationship.source.network.request.ModifyRelationRequest;
import id.dana.feeds.data.relationship.source.network.request.RelationshipRequest;
import id.dana.feeds.data.relationship.source.network.response.FollowerResponse;
import id.dana.feeds.data.relationship.source.network.response.FollowingResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u001c\u0012\u0006\u0010\u0012\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0016J#\u0010\u0018\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\b\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\b\u0010\u001aJ%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u001b"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/NetworkRelationshipEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/relationship/source/network/NetworkRelationshipFacade;", "Lid/dana/feeds/data/relationship/source/RemoteRelationshipEntityData;", "", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getAuthRequestContext", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "PlaceComponentResult", "(I)Lio/reactivex/Observable;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/Integer;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "", "(JI)Lio/reactivex/Observable;", "Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Integer;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "(JI)Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkRelationshipEntityData extends SecureBaseNetwork<NetworkRelationshipFacade> implements RemoteRelationshipEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<NetworkRelationshipFacade> getFacadeClass() {
        return NetworkRelationshipFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkRelationshipEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final FollowingResponse KClassImpl$Data$declaredNonStaticMembers$2(final Integer p0, final String p1) {
        Object blockingFirst = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.getAuthRequestContext(p0, p1, this, (NetworkRelationshipFacade) obj);
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (FollowingResponse) blockingFirst;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final FollowingResponse BuiltInFictitiousFunctionClassFactory(final long p0, final int p1) {
        Object blockingFirst = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.getAuthRequestContext(p0, p1, this, (NetworkRelationshipFacade) obj);
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (FollowingResponse) blockingFirst;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, this, (NetworkRelationshipFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final Observable<BaseRpcResult> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, this, (NetworkRelationshipFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.MyBillsEntityDataFactory(p0, this, (NetworkRelationshipFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final Observable<FollowerResponse> MyBillsEntityDataFactory(final long p0, final int p1) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.MyBillsEntityDataFactory(p0, p1, this, (NetworkRelationshipFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final Observable<FollowerResponse> PlaceComponentResult(final int p0) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.BuiltInFictitiousFunctionClassFactory(p0, this, (NetworkRelationshipFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.relationship.source.RemoteRelationshipEntityData
    public final FollowerResponse MyBillsEntityDataFactory(final Integer p0, final String p1) {
        Object blockingFirst = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkRelationshipEntityData.BuiltInFictitiousFunctionClassFactory(p0, p1, this, (NetworkRelationshipFacade) obj);
            }
        }).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (FollowerResponse) blockingFirst;
    }

    public static /* synthetic */ BaseRpcResult MyBillsEntityDataFactory(String str, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        FriendRequestApprovalRequest friendRequestApprovalRequest = new FriendRequestApprovalRequest(str);
        friendRequestApprovalRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.approveFriendRequest(friendRequestApprovalRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(String str, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        FriendRequestDeclineRequest friendRequestDeclineRequest = new FriendRequestDeclineRequest(str);
        friendRequestDeclineRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.declineFriendRequest(friendRequestDeclineRequest);
    }

    public static /* synthetic */ FollowerResponse BuiltInFictitiousFunctionClassFactory(Integer num, String str, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        RelationshipRequest relationshipRequest = new RelationshipRequest(null, null, num, null, null, str, 27, null);
        relationshipRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.getNextFollowers(relationshipRequest);
    }

    public static /* synthetic */ FollowingResponse getAuthRequestContext(Integer num, String str, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        RelationshipRequest relationshipRequest = new RelationshipRequest(null, null, num, null, str, null, 43, null);
        relationshipRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.getNextFollowing(relationshipRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        ModifyRelationRequest modifyRelationRequest = new ModifyRelationRequest(str, str2);
        modifyRelationRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.modifyRelationship(modifyRelationRequest);
    }

    public static /* synthetic */ FollowerResponse MyBillsEntityDataFactory(long j, int i, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        RelationshipRequest relationshipRequest = new RelationshipRequest(null, Long.valueOf(j), Integer.valueOf(i), null, null, null, 57, null);
        relationshipRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.getNextFollowers(relationshipRequest);
    }

    public static /* synthetic */ FollowingResponse getAuthRequestContext(long j, int i, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        RelationshipRequest relationshipRequest = new RelationshipRequest(null, Long.valueOf(j), Integer.valueOf(i), null, null, null, 57, null);
        relationshipRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.getNextFollowing(relationshipRequest);
    }

    public static /* synthetic */ FollowerResponse BuiltInFictitiousFunctionClassFactory(int i, NetworkRelationshipEntityData networkRelationshipEntityData, NetworkRelationshipFacade networkRelationshipFacade) {
        Intrinsics.checkNotNullParameter(networkRelationshipEntityData, "");
        RelationshipRequest relationshipRequest = new RelationshipRequest(null, null, Integer.valueOf(i), null, null, null, 59, null);
        relationshipRequest.envInfo = networkRelationshipEntityData.generateMobileEnvInfo();
        return networkRelationshipFacade.getNextFollowers(relationshipRequest);
    }
}

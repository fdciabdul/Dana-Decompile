package id.dana.feeds.data.relationship.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.relationship.source.network.request.FriendRequestApprovalRequest;
import id.dana.feeds.data.relationship.source.network.request.FriendRequestDeclineRequest;
import id.dana.feeds.data.relationship.source.network.request.ModifyRelationRequest;
import id.dana.feeds.data.relationship.source.network.request.RelationshipRequest;
import id.dana.feeds.data.relationship.source.network.response.FollowerResponse;
import id.dana.feeds.data.relationship.source.network.response.FollowingResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/NetworkRelationshipFacade;", "", "Lid/dana/feeds/data/relationship/source/network/request/FriendRequestApprovalRequest;", "request", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "approveFriendRequest", "(Lid/dana/feeds/data/relationship/source/network/request/FriendRequestApprovalRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/relationship/source/network/request/FriendRequestDeclineRequest;", "declineFriendRequest", "(Lid/dana/feeds/data/relationship/source/network/request/FriendRequestDeclineRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/data/relationship/source/network/request/RelationshipRequest;", "Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "getNextFollowers", "(Lid/dana/feeds/data/relationship/source/network/request/RelationshipRequest;)Lid/dana/feeds/data/relationship/source/network/response/FollowerResponse;", "Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "getNextFollowing", "(Lid/dana/feeds/data/relationship/source/network/request/RelationshipRequest;)Lid/dana/feeds/data/relationship/source/network/response/FollowingResponse;", "Lid/dana/feeds/data/relationship/source/network/request/ModifyRelationRequest;", "modifyRelationship", "(Lid/dana/feeds/data/relationship/source/network/request/ModifyRelationRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NetworkRelationshipFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;

    @OperationType("id.dana.feedengine.friendship.approveRequest")
    @SignCheck
    BaseRpcResult approveFriendRequest(FriendRequestApprovalRequest request);

    @OperationType("id.dana.feedengine.friendship.rejectRequest")
    @SignCheck
    BaseRpcResult declineFriendRequest(FriendRequestDeclineRequest request);

    @OperationType("alipayplus.mobilewallet.socialmedia.queryfollowers")
    @SignCheck
    FollowerResponse getNextFollowers(RelationshipRequest request);

    @OperationType("alipayplus.mobilewallet.socialmedia.queryfollowing")
    @SignCheck
    FollowingResponse getNextFollowing(RelationshipRequest request);

    @OperationType("alipayplus.mobilewallet.socialmedia.modifyRelation")
    @SignCheck
    BaseRpcResult modifyRelationship(ModifyRelationRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/NetworkRelationshipFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}

package id.dana.feeds.data.notification.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.notification.source.FeedsNotificationData;
import id.dana.feeds.data.notification.source.network.request.MarkAsReadNotificationRequest;
import id.dana.feeds.data.notification.source.network.response.FetchFeedNotificationCountResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B+\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/feeds/data/notification/source/network/NetworkFeedsNotificationEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/feeds/data/notification/source/network/FeedsNotificationFacade;", "Lid/dana/feeds/data/notification/source/FeedsNotificationData;", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/notification/source/network/response/FetchFeedNotificationCountResponse;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "", "p0", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkFeedsNotificationEntityData extends SecureBaseNetwork<FeedsNotificationFacade> implements FeedsNotificationData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<FeedsNotificationFacade> getFacadeClass() {
        return FeedsNotificationFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFeedsNotificationEntityData(RpcConnector rpcConnector, @Named("friendshipthreadexecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.notification.source.FeedsNotificationData
    public final Observable<FetchFeedNotificationCountResponse> PlaceComponentResult() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.notification.source.network.NetworkFeedsNotificationEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsNotificationEntityData.KClassImpl$Data$declaredNonStaticMembers$2(NetworkFeedsNotificationEntityData.this, (FeedsNotificationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.feeds.data.notification.source.FeedsNotificationData
    public final Observable<BaseRpcResult> MyBillsEntityDataFactory(final List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.feeds.data.notification.source.network.NetworkFeedsNotificationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkFeedsNotificationEntityData.PlaceComponentResult(p0, this, (FeedsNotificationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ FetchFeedNotificationCountResponse KClassImpl$Data$declaredNonStaticMembers$2(NetworkFeedsNotificationEntityData networkFeedsNotificationEntityData, FeedsNotificationFacade feedsNotificationFacade) {
        Intrinsics.checkNotNullParameter(networkFeedsNotificationEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkFeedsNotificationEntityData.generateMobileEnvInfo();
        return feedsNotificationFacade.fetchFeedNotificationCount(baseRpcRequest);
    }

    public static /* synthetic */ BaseRpcResult PlaceComponentResult(List list, NetworkFeedsNotificationEntityData networkFeedsNotificationEntityData, FeedsNotificationFacade feedsNotificationFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(networkFeedsNotificationEntityData, "");
        MarkAsReadNotificationRequest markAsReadNotificationRequest = new MarkAsReadNotificationRequest(list);
        markAsReadNotificationRequest.envInfo = networkFeedsNotificationEntityData.generateMobileEnvInfo();
        return feedsNotificationFacade.markNotificationAsRead(markAsReadNotificationRequest);
    }
}

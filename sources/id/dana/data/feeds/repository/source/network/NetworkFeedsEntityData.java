package id.dana.data.feeds.repository.source.network;

import android.content.Context;
import id.dana.data.feeds.repository.source.FeedsEntityData;
import id.dana.data.feeds.repository.source.network.request.DeleteFeedsEntityRequest;
import id.dana.data.feeds.repository.source.network.request.FeedsEntityRequest;
import id.dana.data.feeds.repository.source.network.result.DeleteFeedResult;
import id.dana.data.feeds.repository.source.network.result.FeedsResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class NetworkFeedsEntityData extends SecureBaseNetwork<FeedsFacade> implements FeedsEntityData {
    public NetworkFeedsEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<FeedsFacade> getFacadeClass() {
        return FeedsFacade.class;
    }

    @Override // id.dana.data.feeds.repository.source.FeedsEntityData
    public Observable<FeedsResult> getFeeds(String str, int i, String str2) {
        final FeedsEntityRequest feedsEntityRequest = new FeedsEntityRequest();
        feedsEntityRequest.envInfo = generateMobileEnvInfo();
        feedsEntityRequest.setFeedSourceId(str);
        feedsEntityRequest.setPageSize(i);
        feedsEntityRequest.setMaxId(str2);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.feeds.repository.source.network.NetworkFeedsEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                FeedsResult fetchActivity;
                fetchActivity = ((FeedsFacade) obj).fetchActivity(FeedsEntityRequest.this);
                return fetchActivity;
            }
        });
    }

    @Override // id.dana.data.feeds.repository.source.FeedsEntityData
    public Observable<DeleteFeedResult> deleteFeeds(String str) {
        final DeleteFeedsEntityRequest deleteFeedsEntityRequest = new DeleteFeedsEntityRequest();
        deleteFeedsEntityRequest.envInfo = generateMobileEnvInfo();
        deleteFeedsEntityRequest.setActivityId(str);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.feeds.repository.source.network.NetworkFeedsEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DeleteFeedResult deleteActivity;
                deleteActivity = ((FeedsFacade) obj).deleteActivity(DeleteFeedsEntityRequest.this);
                return deleteActivity;
            }
        });
    }
}

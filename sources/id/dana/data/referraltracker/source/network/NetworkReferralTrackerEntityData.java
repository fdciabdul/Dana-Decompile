package id.dana.data.referraltracker.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.referraltracker.source.ReferralTrackerEntityData;
import id.dana.data.referraltracker.source.network.request.ReferralTrackerRpcRequest;
import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkReferralTrackerEntityData extends SecureBaseNetwork<ReferralTrackerRpcFacade> implements ReferralTrackerEntityData {
    @Inject
    public NetworkReferralTrackerEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<ReferralTrackerRpcFacade> getFacadeClass() {
        return ReferralTrackerRpcFacade.class;
    }

    @Override // id.dana.data.referraltracker.source.ReferralTrackerEntityData
    public Observable<ReferralTrackerRpcResult> getReferralTracker(int i, int i2) {
        final ReferralTrackerRpcRequest referralTrackerRpcRequest = new ReferralTrackerRpcRequest();
        referralTrackerRpcRequest.envInfo = generateMobileEnvInfo();
        referralTrackerRpcRequest.pageNum = i;
        referralTrackerRpcRequest.pageSize = i2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.referraltracker.source.network.NetworkReferralTrackerEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ReferralTrackerRpcResult referralTracker;
                referralTracker = ((ReferralTrackerRpcFacade) obj).getReferralTracker(ReferralTrackerRpcRequest.this);
                return referralTracker;
            }
        });
    }
}

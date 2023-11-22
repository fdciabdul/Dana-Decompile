package id.dana.data.content.source.network;

import android.content.Context;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.network.request.SpaceRpcRequest;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class NetworkContentDeliveryEntityData extends SecureBaseNetwork<CdpSpaceFacade> implements ContentDeliveryEntityData {
    public NetworkContentDeliveryEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<CdpSpaceFacade> getFacadeClass() {
        return CdpSpaceFacade.class;
    }

    @Override // id.dana.data.content.source.ContentDeliveryEntityData
    public Observable<SpaceRpcResult> get(String str) {
        final SpaceRpcRequest spaceRpcRequest = new SpaceRpcRequest();
        spaceRpcRequest.envInfo = generateMobileEnvInfo();
        spaceRpcRequest.setSpaceCode(str);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.content.source.network.NetworkContentDeliveryEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SpaceRpcResult spaceRpcResult;
                spaceRpcResult = ((CdpSpaceFacade) obj).get(SpaceRpcRequest.this);
                return spaceRpcResult;
            }
        });
    }
}

package id.dana.data.globalnetwork.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.globalnetwork.model.UniPaymentEntityRequest;
import id.dana.data.globalnetwork.model.UniPaymentEntityResult;
import id.dana.data.globalnetwork.source.UniPaymentEntityData;
import id.dana.data.globalnetwork.source.network.facade.UniPaymentFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public class NetworkUniPaymentEntityData extends SecureBaseNetwork<UniPaymentFacade> implements UniPaymentEntityData {
    public NetworkUniPaymentEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UniPaymentFacade> getFacadeClass() {
        return UniPaymentFacade.class;
    }

    @Override // id.dana.data.globalnetwork.source.UniPaymentEntityData
    public Observable<UniPaymentEntityResult> getUniPaymentResult(List<String> list, String str, String str2) {
        final UniPaymentEntityRequest uniPaymentEntityRequest = new UniPaymentEntityRequest(list, str, str2);
        uniPaymentEntityRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.globalnetwork.source.network.NetworkUniPaymentEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UniPaymentEntityResult uniResultQuery;
                uniResultQuery = ((UniPaymentFacade) obj).uniResultQuery(UniPaymentEntityRequest.this);
                return uniResultQuery;
            }
        });
    }
}

package id.dana.data.verifytoken.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.verifytoken.repository.source.VerifyTokenEntityData;
import id.dana.data.verifytoken.repository.source.network.request.VerifyTokenRequest;
import id.dana.data.verifytoken.repository.source.network.result.VerifyTokenResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NetworkVerifyTokenEntityData extends SecureBaseNetwork<VerifyTokenFacade> implements VerifyTokenEntityData {
    @Inject
    public NetworkVerifyTokenEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<VerifyTokenFacade> getFacadeClass() {
        return VerifyTokenFacade.class;
    }

    @Override // id.dana.data.verifytoken.repository.source.VerifyTokenEntityData
    public Observable<VerifyTokenResult> getVerifyToken(String str, String str2) {
        final VerifyTokenRequest verifyTokenRequest = new VerifyTokenRequest();
        verifyTokenRequest.setTokenScene(str);
        verifyTokenRequest.setPhoneNumber(str2);
        verifyTokenRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.verifytoken.repository.source.network.NetworkVerifyTokenEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                VerifyTokenResult verifyToken;
                verifyToken = ((VerifyTokenFacade) obj).getVerifyToken(VerifyTokenRequest.this);
                return verifyToken;
            }
        });
    }
}

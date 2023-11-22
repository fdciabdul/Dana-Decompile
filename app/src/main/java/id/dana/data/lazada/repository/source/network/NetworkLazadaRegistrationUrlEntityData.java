package id.dana.data.lazada.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.lazada.repository.source.LazadaRegistrationUrlEntityData;
import id.dana.data.lazada.repository.source.network.request.LazadaRegistrationUrlRequest;
import id.dana.data.lazada.repository.source.network.response.LazadaRegistrationUrlResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkLazadaRegistrationUrlEntityData extends SecureBaseNetwork<LazadaRegistrationUrlApi> implements LazadaRegistrationUrlEntityData {
    @Inject
    public NetworkLazadaRegistrationUrlEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.data.lazada.repository.source.LazadaRegistrationUrlEntityData
    public Observable<LazadaRegistrationUrlResult> getLazadaRegistrationUrl(String str, String str2) {
        final LazadaRegistrationUrlRequest lazadaRegistrationUrlRequest = new LazadaRegistrationUrlRequest();
        lazadaRegistrationUrlRequest.setBizType(str2);
        lazadaRegistrationUrlRequest.setDeviceId(str);
        lazadaRegistrationUrlRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.lazada.repository.source.network.NetworkLazadaRegistrationUrlEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LazadaRegistrationUrlResult registrationUrl;
                registrationUrl = ((LazadaRegistrationUrlApi) obj).getRegistrationUrl(LazadaRegistrationUrlRequest.this);
                return registrationUrl;
            }
        });
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<LazadaRegistrationUrlApi> getFacadeClass() {
        return LazadaRegistrationUrlApi.class;
    }
}

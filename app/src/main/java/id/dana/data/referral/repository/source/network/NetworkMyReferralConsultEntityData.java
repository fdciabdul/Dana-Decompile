package id.dana.data.referral.repository.source.network;

import android.content.Context;
import id.dana.data.deeplink.repository.GenerateLinkEntityRepository$$ExternalSyntheticLambda2;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.referral.repository.source.MyReferralConsultEntityData;
import id.dana.data.referral.repository.source.network.request.MyReferralConsultEntityRequest;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkMyReferralConsultEntityData extends SecureBaseNetwork<MyReferralConsultFacade> implements MyReferralConsultEntityData {
    @Inject
    public NetworkMyReferralConsultEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<MyReferralConsultFacade> getFacadeClass() {
        return MyReferralConsultFacade.class;
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public Observable<MyReferralConsultEntityResult> getMyReferralConsult() {
        final MyReferralConsultEntityRequest myReferralConsultEntityRequest = new MyReferralConsultEntityRequest();
        myReferralConsultEntityRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.referral.repository.source.network.NetworkMyReferralConsultEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                MyReferralConsultEntityResult myReferralConsultEntityData;
                myReferralConsultEntityData = ((MyReferralConsultFacade) obj).myReferralConsultEntityData(MyReferralConsultEntityRequest.this);
                return myReferralConsultEntityData;
            }
        });
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public void saveReferralCode(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public Observable<String> getReferralCode() {
        return getMyReferralConsult().map(new GenerateLinkEntityRepository$$ExternalSyntheticLambda2());
    }
}

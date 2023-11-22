package id.dana.data.referral.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promocode.PromoAndReferralCodeUtilKt;
import id.dana.data.referral.source.ReferralEntityData;
import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.referral.source.network.request.ReferralConsultRpcRequest;
import id.dana.data.referral.source.network.request.VerifyReferralCodeRpcRequest;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.NotImplementedError;

/* loaded from: classes2.dex */
public class NetworkReferralEntityData extends SecureBaseNetwork<ReferralRpcFacade> implements ReferralEntityData {
    @Inject
    public NetworkReferralEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public Observable<ReferralConsultRpcResult> consult() {
        final ReferralConsultRpcRequest referralConsultRpcRequest = new ReferralConsultRpcRequest();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.referral.source.network.NetworkReferralEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ReferralConsultRpcResult consult;
                consult = ((ReferralRpcFacade) obj).consult(ReferralConsultRpcRequest.this);
                return consult;
            }
        });
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public Observable<ReferralVerifyRpcResult> verify(String str, String str2) {
        final VerifyReferralCodeRpcRequest verifyReferralCodeRpcRequest = new VerifyReferralCodeRpcRequest();
        verifyReferralCodeRpcRequest.envInfo = generateMobileEnvInfo();
        PromoAndReferralCodeUtilKt.setUserCity(verifyReferralCodeRpcRequest.envInfo.extendInfo, str2);
        verifyReferralCodeRpcRequest.referralCode = str;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.referral.source.network.NetworkReferralEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ReferralVerifyRpcResult verify;
                verify = ((ReferralRpcFacade) obj).verify(VerifyReferralCodeRpcRequest.this);
                return verify;
            }
        });
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public Observable<ReferralStatusConsultRpcResult> statusConsult() {
        final BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.referral.source.network.NetworkReferralEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ReferralStatusConsultRpcResult statusConsult;
                statusConsult = ((ReferralRpcFacade) obj).statusConsult(BaseRpcRequest.this);
                return statusConsult;
            }
        });
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public Observable<Boolean> saveReferralEngagementDialogCache(List<ReferralEngagementDialogCacheEntity> list) {
        return Observable.error(new NotImplementedError());
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<ReferralRpcFacade> getFacadeClass() {
        return ReferralRpcFacade.class;
    }

    @Override // id.dana.data.referral.source.ReferralEntityData
    public Observable<List<ReferralEngagementDialogCacheEntity>> getDialogCaches() {
        return Observable.error(new NotImplementedError());
    }
}

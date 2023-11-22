package id.dana.data.risk.riskevent;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.risk.riskevent.request.SendRiskEventRpcRequest;
import id.dana.data.risk.riskevent.result.SendRiskEventRpcResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkSendRiskEventEntityData extends SecureBaseNetwork<SendRiskEventRpcFacade> implements SendRiskEventEntityData {
    private static final String ACTION_GN_SHARE_ENV_INFO = "SHARE_ENV_INFO";
    private static final String ACTION_SHARE_URL = "SHARE_URL";
    private static final String BIZ_TYPE_DANA_KAGET = "DANA_KAGET";
    private static final String BIZ_TYPE_RISK_PURPOSE = "RISK_PURPOSE";
    public static final String TAG = "NetworkSendRiskEventEntityData";

    @Inject
    public NetworkSendRiskEventEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<SendRiskEventRpcFacade> getFacadeClass() {
        return SendRiskEventRpcFacade.class;
    }

    @Override // id.dana.data.risk.riskevent.SendRiskEventEntityData
    public Observable sendRiskEvent(String str, String str2, String str3) {
        final SendRiskEventRpcRequest createRequest = createRequest(ACTION_SHARE_URL, BIZ_TYPE_DANA_KAGET, str3);
        HashMap hashMap = new HashMap();
        hashMap.put("shareChannel", str);
        hashMap.put("shareLink", str2);
        createRequest.extendInfo = hashMap;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.risk.riskevent.NetworkSendRiskEventEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SendRiskEventRpcResult sendRiskEvent;
                sendRiskEvent = ((SendRiskEventRpcFacade) obj).sendRiskEvent(SendRiskEventRpcRequest.this);
                return sendRiskEvent;
            }
        });
    }

    @Override // id.dana.data.risk.riskevent.SendRiskEventEntityData
    public Observable<BaseRpcResult> sendRiskEvent(String str, String str2) {
        final SendRiskEventRpcRequest createRequest = createRequest(ACTION_GN_SHARE_ENV_INFO, BIZ_TYPE_RISK_PURPOSE, "");
        createRequest.extendInfo.put("bizScene", "UPDATE_USER_COUNTRY");
        addLocationInfo(createRequest, str, str2);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.risk.riskevent.NetworkSendRiskEventEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult sendRiskEvent;
                sendRiskEvent = ((SendRiskEventRpcFacade) obj).sendRiskEvent(SendRiskEventRpcRequest.this);
                return sendRiskEvent;
            }
        });
    }

    private void addLocationInfo(SendRiskEventRpcRequest sendRiskEventRpcRequest, String str, String str2) {
        if (sendRiskEventRpcRequest.envInfo == null || sendRiskEventRpcRequest.envInfo.extendInfo == null) {
            return;
        }
        sendRiskEventRpcRequest.envInfo.extendInfo.put("userCountryCurrent", str);
        sendRiskEventRpcRequest.envInfo.extendInfo.put("userCountryOrigin", str2);
    }

    private SendRiskEventRpcRequest createRequest(String str, String str2, String str3) {
        SendRiskEventRpcRequest sendRiskEventRpcRequest = new SendRiskEventRpcRequest();
        sendRiskEventRpcRequest.action = str;
        sendRiskEventRpcRequest.bizType = str2;
        sendRiskEventRpcRequest.bizOrderId = str3;
        sendRiskEventRpcRequest.envInfo = generateMobileEnvInfo();
        return sendRiskEventRpcRequest;
    }
}

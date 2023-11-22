package id.dana.data.profilemenu.repository.source.network;

import android.content.Context;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.profilemenu.repository.source.PaymentAuthenticationEntityData;
import id.dana.data.profilemenu.repository.source.network.request.PaymentSecuritySwitchRequest;
import id.dana.data.profilemenu.repository.source.network.result.PaymentSecurityInitResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkPaymentAuthenticationEntityData extends SecureBaseNetwork<PaymentSecurityControlFacade> implements PaymentAuthenticationEntityData {
    @Inject
    public NetworkPaymentAuthenticationEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<PaymentSecurityControlFacade> getFacadeClass() {
        return PaymentSecurityControlFacade.class;
    }

    @Override // id.dana.data.profilemenu.repository.source.PaymentAuthenticationEntityData
    public Observable<PaymentSecurityInitResult> getPaymentSecurityInitResult() {
        final BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.profilemenu.repository.source.network.NetworkPaymentAuthenticationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PaymentSecurityInitResult paymentSecurity;
                paymentSecurity = ((PaymentSecurityControlFacade) obj).getPaymentSecurity(BaseRpcRequest.this);
                return paymentSecurity;
            }
        });
    }

    @Override // id.dana.data.profilemenu.repository.source.PaymentAuthenticationEntityData
    public Observable<PaymentSecuritySwitchResult> getSecuritySwitchResult(boolean z, String str, String str2, String str3, String str4) {
        final PaymentSecuritySwitchRequest paymentSecuritySwitchRequest = new PaymentSecuritySwitchRequest();
        paymentSecuritySwitchRequest.envInfo = generateMobileEnvInfo();
        paymentSecuritySwitchRequest.authenticationStatus = z;
        paymentSecuritySwitchRequest.authenticationType = str;
        paymentSecuritySwitchRequest.securityId = str2;
        paymentSecuritySwitchRequest.validateData = RSAHelper.encrypt(str3, str4);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.profilemenu.repository.source.network.NetworkPaymentAuthenticationEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PaymentSecuritySwitchResult paymentSecuritySwitch;
                paymentSecuritySwitch = ((PaymentSecurityControlFacade) obj).getPaymentSecuritySwitch(PaymentSecuritySwitchRequest.this);
                return paymentSecuritySwitch;
            }
        });
    }
}

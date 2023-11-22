package id.dana.data.profilemenu.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.profilemenu.repository.source.network.result.PaymentSecurityInitResult;
import id.dana.network.response.profilemenu.PaymentSecuritySwitchResult;

/* loaded from: classes4.dex */
public interface PaymentSecurityControlFacade {
    @OperationType("alipayplus.mobilewallet.user.paymentcontrol.init")
    @SignCheck
    PaymentSecurityInitResult getPaymentSecurity(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.user.paymentcontrol.switch")
    @SignCheck
    PaymentSecuritySwitchResult getPaymentSecuritySwitch(BaseRpcRequest baseRpcRequest);
}

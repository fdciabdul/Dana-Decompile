package id.dana.data.referral.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.referral.source.network.request.ReferralConsultRpcRequest;
import id.dana.data.referral.source.network.request.VerifyReferralCodeRpcRequest;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;

/* loaded from: classes4.dex */
public interface ReferralRpcFacade {
    @OperationType("alipayplus.mobilewallet.referral.consult.referrer")
    @SignCheck
    ReferralConsultRpcResult consult(ReferralConsultRpcRequest referralConsultRpcRequest);

    @OperationType("alipayplus.mobilewallet.referral.status.consult")
    @SignCheck
    ReferralStatusConsultRpcResult statusConsult(BaseRpcRequest baseRpcRequest);

    @OperationType("alipayplus.mobilewallet.referral.verify")
    @SignCheck
    ReferralVerifyRpcResult verify(VerifyReferralCodeRpcRequest verifyReferralCodeRpcRequest);
}

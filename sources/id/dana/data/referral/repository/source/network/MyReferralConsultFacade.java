package id.dana.data.referral.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.referral.repository.source.network.request.MyReferralConsultEntityRequest;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;

/* loaded from: classes4.dex */
public interface MyReferralConsultFacade {
    @OperationType("alipayplus.mobilewallet.referral.consult")
    @SignCheck
    MyReferralConsultEntityResult myReferralConsultEntityData(MyReferralConsultEntityRequest myReferralConsultEntityRequest);
}

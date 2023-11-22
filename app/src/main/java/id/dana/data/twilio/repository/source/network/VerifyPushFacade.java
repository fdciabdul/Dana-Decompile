package id.dana.data.twilio.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.twilio.repository.source.network.request.VerifyPushBindEnrollmentRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushConsultRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushDerollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushEnrollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushRequestChallengeRequest;
import id.dana.data.twilio.repository.source.network.result.VerifyPushBindEnrollmentResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushConsultResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushEnrollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushRequestChallengeResult;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/twilio/repository/source/network/VerifyPushFacade;", "", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;", "request", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;", "bindEnrollment", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;", "consult", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", DanaLogConstants.BizType.REGISTER, "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "requestChallenge", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "unregister", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "verifySecurityProduct", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;)Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface VerifyPushFacade {
    @OperationType("alipayplus.mobilewallet.user.verifypush.bindEnrollment")
    @SignCheck
    VerifyPushBindEnrollmentResult bindEnrollment(VerifyPushBindEnrollmentRequest request);

    @OperationType("alipayplus.mobilewallet.user.verifypush.consult")
    @SignCheck
    VerifyPushConsultResult consult(VerifyPushConsultRequest request);

    @OperationType("alipayplus.mobilewallet.user.verifypush.register")
    @SignCheck
    VerifyPushEnrollResult register(VerifyPushEnrollRequest request);

    @OperationType("alipayplus.mobilewallet.user.verifypush.requestChallenge")
    @SignCheck
    VerifyPushRequestChallengeResult requestChallenge(VerifyPushRequestChallengeRequest request);

    @OperationType("alipayplus.mobilewallet.user.verifypush.unregister")
    @SignCheck
    VerifyPushDerollResult unregister(VerifyPushDerollRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_OTP_RISK)
    @SignCheck
    VerifySecurityProductResult verifySecurityProduct(VerifySecurityProductRequest request);
}

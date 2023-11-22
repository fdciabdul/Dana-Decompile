package id.dana.data.twilio.mapper;

import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushBindEnrollmentRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushConsultRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushDerollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushEnrollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushRequestChallengeRequest;
import id.dana.domain.otp.model.SendStrategy;
import id.dana.domain.twilio.model.TwilioBindEnroll;
import id.dana.domain.twilio.model.TwilioChallenge;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioDeroll;
import id.dana.domain.twilio.model.TwilioEnroll;
import id.dana.domain.twilio.model.TwilioVerify;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u000e\u001a\u00020\u0011*\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0011\u0010\u000e\u001a\u00020\u0014*\u00020\u0013¢\u0006\u0004\b\u000e\u0010\u0015"}, d2 = {"Lid/dana/domain/twilio/model/TwilioBindEnroll;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/twilio/model/TwilioBindEnroll;)Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;", "Lid/dana/domain/twilio/model/TwilioConsult;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;", "PlaceComponentResult", "(Lid/dana/domain/twilio/model/TwilioConsult;)Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;", "Lid/dana/domain/twilio/model/TwilioDeroll;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/twilio/model/TwilioDeroll;)Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;", "Lid/dana/domain/twilio/model/TwilioEnroll;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;", "getAuthRequestContext", "(Lid/dana/domain/twilio/model/TwilioEnroll;)Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;", "Lid/dana/domain/twilio/model/TwilioChallenge;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;", "(Lid/dana/domain/twilio/model/TwilioChallenge;)Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;", "Lid/dana/domain/twilio/model/TwilioVerify;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "(Lid/dana/domain/twilio/model/TwilioVerify;)Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TwilioMapperKt {
    public static final VerifyPushConsultRequest PlaceComponentResult(TwilioConsult twilioConsult) {
        Intrinsics.checkNotNullParameter(twilioConsult, "");
        return new VerifyPushConsultRequest(twilioConsult.getSource());
    }

    public static final VerifyPushEnrollRequest getAuthRequestContext(TwilioEnroll twilioEnroll) {
        Intrinsics.checkNotNullParameter(twilioEnroll, "");
        return new VerifyPushEnrollRequest(twilioEnroll.getSecurityId(), twilioEnroll.getSource());
    }

    public static final VerifyPushBindEnrollmentRequest KClassImpl$Data$declaredNonStaticMembers$2(TwilioBindEnroll twilioBindEnroll) {
        Intrinsics.checkNotNullParameter(twilioBindEnroll, "");
        return new VerifyPushBindEnrollmentRequest(twilioBindEnroll.getFactorId(), twilioBindEnroll.getIdentity());
    }

    public static final VerifyPushDerollRequest BuiltInFictitiousFunctionClassFactory(TwilioDeroll twilioDeroll) {
        Intrinsics.checkNotNullParameter(twilioDeroll, "");
        return new VerifyPushDerollRequest(twilioDeroll.getSource());
    }

    public static final VerifyPushRequestChallengeRequest getAuthRequestContext(TwilioChallenge twilioChallenge) {
        Intrinsics.checkNotNullParameter(twilioChallenge, "");
        return new VerifyPushRequestChallengeRequest(twilioChallenge.getScene(), twilioChallenge.getChallengeInfo(), twilioChallenge.getChallengeSid());
    }

    public static final VerifySecurityProductRequest getAuthRequestContext(TwilioVerify twilioVerify) {
        Intrinsics.checkNotNullParameter(twilioVerify, "");
        String securityId = twilioVerify.getSecurityId();
        String verificationMethod = twilioVerify.getVerificationMethod();
        String validateData = twilioVerify.getValidateData();
        String sendOtpStrategy = twilioVerify.getSendOtpStrategy();
        if (Intrinsics.areEqual(sendOtpStrategy, SendStrategy.AUTH_AGREEMENT)) {
            sendOtpStrategy = "AP_LOGIN";
        }
        return new VerifySecurityProductRequest(null, securityId, verificationMethod, validateData, null, sendOtpStrategy, null, null, null, 465, null);
    }
}

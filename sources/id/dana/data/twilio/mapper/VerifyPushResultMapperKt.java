package id.dana.data.twilio.mapper;

import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushBindEnrollmentResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushConsultResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushEnrollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushRequestChallengeResult;
import id.dana.domain.twilio.model.BindEnrollInfo;
import id.dana.domain.twilio.model.DerollInfo;
import id.dana.domain.twilio.model.EnrollInfo;
import id.dana.domain.twilio.model.RequestChallengeInfo;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u000e\u001a\u00020\u0011*\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0011\u0010\u0002\u001a\u00020\u0014*\u00020\u0013¢\u0006\u0004\b\u0002\u0010\u0015"}, d2 = {"Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;", "Lid/dana/domain/twilio/model/BindEnrollInfo;", "PlaceComponentResult", "(Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;)Lid/dana/domain/twilio/model/BindEnrollInfo;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "Lid/dana/domain/twilio/model/DerollInfo;", "getAuthRequestContext", "(Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;)Lid/dana/domain/twilio/model/DerollInfo;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "Lid/dana/domain/twilio/model/EnrollInfo;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;)Lid/dana/domain/twilio/model/EnrollInfo;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "Lid/dana/domain/twilio/model/RequestChallengeInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;)Lid/dana/domain/twilio/model/RequestChallengeInfo;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;", "Lid/dana/domain/twilio/model/TwilioInfo;", "(Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;)Lid/dana/domain/twilio/model/TwilioInfo;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;)Lid/dana/domain/twilio/model/VerifySecurityInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPushResultMapperKt {
    public static final TwilioInfo KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushConsultResult verifyPushConsultResult) {
        Intrinsics.checkNotNullParameter(verifyPushConsultResult, "");
        return new TwilioInfo(verifyPushConsultResult.getRegistered(), verifyPushConsultResult.getRegisterAllowed(), verifyPushConsultResult.getSecurityId(), verifyPushConsultResult.getVerificationMethodInfos());
    }

    public static final EnrollInfo BuiltInFictitiousFunctionClassFactory(VerifyPushEnrollResult verifyPushEnrollResult) {
        Intrinsics.checkNotNullParameter(verifyPushEnrollResult, "");
        return new EnrollInfo(verifyPushEnrollResult.getSucces(), verifyPushEnrollResult.getAccessToken(), verifyPushEnrollResult.getIdentity(), verifyPushEnrollResult.getServiceSid());
    }

    public static final BindEnrollInfo PlaceComponentResult(VerifyPushBindEnrollmentResult verifyPushBindEnrollmentResult) {
        Intrinsics.checkNotNullParameter(verifyPushBindEnrollmentResult, "");
        return new BindEnrollInfo(verifyPushBindEnrollmentResult.getStatus());
    }

    public static final DerollInfo getAuthRequestContext(VerifyPushDerollResult verifyPushDerollResult) {
        Intrinsics.checkNotNullParameter(verifyPushDerollResult, "");
        return new DerollInfo(verifyPushDerollResult.getSecurityId(), verifyPushDerollResult.getVerificationMethodInfos(), verifyPushDerollResult.success);
    }

    public static final RequestChallengeInfo KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushRequestChallengeResult verifyPushRequestChallengeResult) {
        Intrinsics.checkNotNullParameter(verifyPushRequestChallengeResult, "");
        return new RequestChallengeInfo(verifyPushRequestChallengeResult.getChallengeSid(), verifyPushRequestChallengeResult.getTimer(), verifyPushRequestChallengeResult.getAction());
    }

    public static final VerifySecurityInfo PlaceComponentResult(VerifySecurityProductResult verifySecurityProductResult) {
        Intrinsics.checkNotNullParameter(verifySecurityProductResult, "");
        int identFailedCount = verifySecurityProductResult.getIdentFailedCount();
        int maxFailedLimit = verifySecurityProductResult.getMaxFailedLimit();
        int lockedExpireMins = verifySecurityProductResult.getLockedExpireMins();
        boolean z = verifySecurityProductResult.success;
        String str = verifySecurityProductResult.errorCode;
        String str2 = verifySecurityProductResult.errorMessage;
        Map<String, String> map = verifySecurityProductResult.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        return new VerifySecurityInfo(identFailedCount, maxFailedLimit, lockedExpireMins, z, str, str2, map);
    }
}

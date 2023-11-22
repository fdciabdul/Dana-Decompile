package id.dana.pushverify.mapper;

import id.dana.domain.pushverify.model.PushVerificationDetail;
import id.dana.domain.pushverify.model.PushVerifyAnnouncement;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.VerifyPushChallengeParam;
import id.dana.pushverify.model.PushVerifyChallengeModel;
import id.dana.pushverify.model.PushVerifyParamsModel;
import id.dana.pushverify.model.VerifyPushChallengeParamModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/pushverify/model/PushVerifyChallenge;", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/pushverify/model/PushVerifyChallenge;)Lid/dana/pushverify/model/PushVerifyChallengeModel;", "Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "Lid/dana/pushverify/model/PushVerifyParamsModel;", "(Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;)Lid/dana/pushverify/model/PushVerifyParamsModel;", "Lid/dana/pushverify/model/VerifyPushChallengeParamModel;", "", "p0", "Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "PlaceComponentResult", "(Lid/dana/pushverify/model/VerifyPushChallengeParamModel;Ljava/lang/String;)Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyModelMapperKt {
    public static final PushVerifyChallengeModel BuiltInFictitiousFunctionClassFactory(PushVerifyChallenge pushVerifyChallenge) {
        Intrinsics.checkNotNullParameter(pushVerifyChallenge, "");
        PushVerificationDetail verificationDetail = pushVerifyChallenge.getVerificationDetail();
        String merchantId = verificationDetail != null ? verificationDetail.getMerchantId() : null;
        String str = merchantId == null ? "" : merchantId;
        PushVerificationDetail verificationDetail2 = pushVerifyChallenge.getVerificationDetail();
        String merchantName = verificationDetail2 != null ? verificationDetail2.getMerchantName() : null;
        String str2 = merchantName == null ? "" : merchantName;
        PushVerificationDetail verificationDetail3 = pushVerifyChallenge.getVerificationDetail();
        String device = verificationDetail3 != null ? verificationDetail3.getDevice() : null;
        String str3 = device == null ? "" : device;
        PushVerificationDetail verificationDetail4 = pushVerifyChallenge.getVerificationDetail();
        String requestTime = verificationDetail4 != null ? verificationDetail4.getRequestTime() : null;
        String str4 = requestTime == null ? "" : requestTime;
        PushVerificationDetail verificationDetail5 = pushVerifyChallenge.getVerificationDetail();
        String requestType = verificationDetail5 != null ? verificationDetail5.getRequestType() : null;
        String str5 = requestType == null ? "" : requestType;
        PushVerificationDetail verificationDetail6 = pushVerifyChallenge.getVerificationDetail();
        String logoUrl = verificationDetail6 != null ? verificationDetail6.getLogoUrl() : null;
        String str6 = logoUrl == null ? "" : logoUrl;
        PushVerificationDetail verificationDetail7 = pushVerifyChallenge.getVerificationDetail();
        return new PushVerifyChallengeModel(null, str, str2, str3, str4, str5, str6, verificationDetail7 != null ? verificationDetail7.getExpiryTime() : 0, 1, null);
    }

    public static final PushVerifyParamsModel BuiltInFictitiousFunctionClassFactory(PushVerifyAnnouncement pushVerifyAnnouncement) {
        Intrinsics.checkNotNullParameter(pushVerifyAnnouncement, "");
        return new PushVerifyParamsModel(pushVerifyAnnouncement.getToken(), pushVerifyAnnouncement.getTrxId(), pushVerifyAnnouncement.getCacheKey());
    }

    public static final VerifyPushChallengeParam PlaceComponentResult(VerifyPushChallengeParamModel verifyPushChallengeParamModel, String str) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeParamModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new VerifyPushChallengeParam(verifyPushChallengeParamModel.KClassImpl$Data$declaredNonStaticMembers$2, str, verifyPushChallengeParamModel.getPlaceComponentResult(), verifyPushChallengeParamModel.MyBillsEntityDataFactory, verifyPushChallengeParamModel.BuiltInFictitiousFunctionClassFactory);
    }
}

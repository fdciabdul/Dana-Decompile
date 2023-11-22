package id.dana.data.carrieridentification.mapper;

import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.domain.carrieridentification.model.VerifySecurityProduct;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "getAuthRequestContext", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;)Lid/dana/domain/twilio/model/VerifySecurityInfo;", "Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "MyBillsEntityDataFactory", "(Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;)Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CarrierIdentificationDataMapperKt {
    public static final VerifySecurityProductRequest MyBillsEntityDataFactory(VerifySecurityProduct verifySecurityProduct) {
        Intrinsics.checkNotNullParameter(verifySecurityProduct, "");
        return new VerifySecurityProductRequest(verifySecurityProduct.getToken(), verifySecurityProduct.getSecurityId(), verifySecurityProduct.getVerificationMethod(), verifySecurityProduct.getValidateData(), null, verifySecurityProduct.getSendOtpStrategy(), null, null, verifySecurityProduct.getPhoneNumber(), 208, null);
    }

    public static final VerifySecurityInfo getAuthRequestContext(VerifySecurityProductResult verifySecurityProductResult) {
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

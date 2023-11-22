package id.dana.pushverify.mapper;

import id.dana.domain.pushverify.model.VerificationDetailItem;
import id.dana.pushverify.model.VerificationDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/pushverify/model/VerificationDetailItem;", "Lid/dana/pushverify/model/VerificationDetailModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/pushverify/model/VerificationDetailItem;)Lid/dana/pushverify/model/VerificationDetailModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyListModelMapperKt {
    public static final VerificationDetailModel BuiltInFictitiousFunctionClassFactory(VerificationDetailItem verificationDetailItem) {
        Intrinsics.checkNotNullParameter(verificationDetailItem, "");
        return new VerificationDetailModel(verificationDetailItem.getMerchantName(), StringsKt.replace$default(verificationDetailItem.getRequestTime(), ",", " •", false, 4, (Object) null), verificationDetailItem.getRequestType(), verificationDetailItem.getLogoUrl(), verificationDetailItem.getVerificationStatus(), verificationDetailItem.getExpiryTime(), verificationDetailItem.getTrxId(), verificationDetailItem.getToken(), verificationDetailItem.getCacheKey(), !Intrinsics.areEqual(verificationDetailItem.getVerificationStatus(), "INIT") ? 1 : 0);
    }
}

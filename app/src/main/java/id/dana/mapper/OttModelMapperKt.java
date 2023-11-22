package id.dana.mapper;

import id.dana.domain.ott.OttVerifyResult;
import id.dana.model.OttVerifyModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/ott/OttVerifyResult;", "Lid/dana/model/OttVerifyModel;", "getAuthRequestContext", "(Lid/dana/domain/ott/OttVerifyResult;)Lid/dana/model/OttVerifyModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OttModelMapperKt {
    public static final OttVerifyModel getAuthRequestContext(OttVerifyResult ottVerifyResult) {
        Intrinsics.checkNotNullParameter(ottVerifyResult, "");
        String userId = ottVerifyResult.getUserId();
        if (userId == null) {
            userId = "";
        }
        String merchantId = ottVerifyResult.getMerchantId();
        if (merchantId == null) {
            merchantId = "";
        }
        Boolean needLogout = ottVerifyResult.getNeedLogout();
        boolean booleanValue = needLogout != null ? needLogout.booleanValue() : false;
        String phoneNumber = ottVerifyResult.getPhoneNumber();
        return new OttVerifyModel(userId, merchantId, booleanValue, phoneNumber != null ? phoneNumber : "");
    }
}

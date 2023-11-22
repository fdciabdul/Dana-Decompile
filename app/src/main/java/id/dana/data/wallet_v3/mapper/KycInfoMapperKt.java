package id.dana.data.wallet_v3.mapper;

import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.domain.wallet_v3.model.KycInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "Lid/dana/domain/wallet_v3/model/KycInfo;", "toKycInfo", "(Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;)Lid/dana/domain/wallet_v3/model/KycInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KycInfoMapperKt {
    public static final KycInfo toKycInfo(KycStatusResult kycStatusResult) {
        Intrinsics.checkNotNullParameter(kycStatusResult, "");
        Map<String, String> errorContext = kycStatusResult.getErrorContext();
        Intrinsics.checkNotNullExpressionValue(errorContext, "");
        Map<String, String> map = kycStatusResult.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        return new KycInfo(errorContext, map);
    }
}

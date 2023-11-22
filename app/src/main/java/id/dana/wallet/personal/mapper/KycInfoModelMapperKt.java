package id.dana.wallet.personal.mapper;

import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.wallet_v3.model.KycInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/wallet_v3/model/KycInfo;", "Lid/dana/wallet_v3/model/KycInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/wallet_v3/model/KycInfo;)Lid/dana/wallet_v3/model/KycInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KycInfoModelMapperKt {
    public static final KycInfoModel KClassImpl$Data$declaredNonStaticMembers$2(KycInfo kycInfo) {
        Intrinsics.checkNotNullParameter(kycInfo, "");
        return new KycInfoModel(kycInfo.getErrorContext(), kycInfo.getExtendInfo());
    }
}

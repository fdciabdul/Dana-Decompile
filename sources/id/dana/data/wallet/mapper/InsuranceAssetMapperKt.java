package id.dana.data.wallet.mapper;

import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "MyBillsEntityDataFactory", "(Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;)Lid/dana/domain/wallet_v3/model/InsuranceAsset;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsuranceAssetMapperKt {
    public static final InsuranceAsset MyBillsEntityDataFactory(InsuranceResult insuranceResult) {
        Intrinsics.checkNotNullParameter(insuranceResult, "");
        return new InsuranceAsset(insuranceResult.getBackgroundUrl(), insuranceResult.getCreatedDate(), insuranceResult.getIconUrl(), insuranceResult.getLogoUrl(), insuranceResult.getPocketId(), insuranceResult.getPocketStatus(), insuranceResult.getPocketType());
    }
}

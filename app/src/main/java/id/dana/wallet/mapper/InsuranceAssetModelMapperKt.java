package id.dana.wallet.mapper;

import id.dana.domain.wallet_v3.model.InsuranceAsset;
import id.dana.wallet_v3.model.InsuranceAssetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "Lid/dana/wallet_v3/model/InsuranceAssetModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/wallet_v3/model/InsuranceAsset;)Lid/dana/wallet_v3/model/InsuranceAssetModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class InsuranceAssetModelMapperKt {
    public static final InsuranceAssetModel KClassImpl$Data$declaredNonStaticMembers$2(InsuranceAsset insuranceAsset) {
        Intrinsics.checkNotNullParameter(insuranceAsset, "");
        return new InsuranceAssetModel(insuranceAsset.getBackgroundUrl(), insuranceAsset.getCreatedDate(), insuranceAsset.getIconUrl(), insuranceAsset.getLogoUrl(), insuranceAsset.getPocketId(), insuranceAsset.getPocketStatus(), insuranceAsset.getPocketType());
    }
}

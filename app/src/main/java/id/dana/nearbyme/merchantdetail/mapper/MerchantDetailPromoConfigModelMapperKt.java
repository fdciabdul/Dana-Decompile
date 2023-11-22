package id.dana.nearbyme.merchantdetail.mapper;

import id.dana.domain.nearbyme.model.MerchantDetailPromoConfig;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailPromoConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;)Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailPromoConfigModelMapperKt {
    public static final MerchantDetailPromoConfigModel KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailPromoConfig merchantDetailPromoConfig) {
        Intrinsics.checkNotNullParameter(merchantDetailPromoConfig, "");
        return new MerchantDetailPromoConfigModel(merchantDetailPromoConfig.getDealsSectionEnable(), merchantDetailPromoConfig.getDealsLimit());
    }
}

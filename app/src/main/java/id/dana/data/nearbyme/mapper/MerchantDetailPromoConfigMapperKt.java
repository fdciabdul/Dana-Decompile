package id.dana.data.nearbyme.mapper;

import id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity;
import id.dana.domain.nearbyme.model.MerchantDetailPromoConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;", "Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;", "toMerchantDetailPromoConfig", "(Lid/dana/data/nearbyme/model/MerchantDetailPromoConfigEntity;)Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MerchantDetailPromoConfigMapperKt {
    public static final MerchantDetailPromoConfig toMerchantDetailPromoConfig(MerchantDetailPromoConfigEntity merchantDetailPromoConfigEntity) {
        Intrinsics.checkNotNullParameter(merchantDetailPromoConfigEntity, "");
        return new MerchantDetailPromoConfig(merchantDetailPromoConfigEntity.getDealsSectionEnable(), merchantDetailPromoConfigEntity.getDealsLimit());
    }
}

package id.dana.data.promodiscovery.repository.mapper;

import id.dana.data.promodiscovery.repository.source.split.model.DiscoverySectionEntity;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryEntity;
import id.dana.domain.promodiscovery.model.DiscoverySectionConfig;
import id.dana.domain.promodiscovery.model.PromoDiscoverySectionConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;", "Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "toDiscoverySectionConfig", "(Lid/dana/data/promodiscovery/repository/source/split/model/DiscoverySectionEntity;)Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;", "toPromoDiscoverySectionConfig", "(Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;)Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoDiscoveryEntityMapperKt {
    public static final PromoDiscoverySectionConfig toPromoDiscoverySectionConfig(PromoDiscoveryEntity promoDiscoveryEntity) {
        Intrinsics.checkNotNullParameter(promoDiscoveryEntity, "");
        return new PromoDiscoverySectionConfig(toDiscoverySectionConfig(promoDiscoveryEntity.getVoucherBannerEntity()), toDiscoverySectionConfig(promoDiscoveryEntity.getNearExpiredPromoBannerEntity()), toDiscoverySectionConfig(promoDiscoveryEntity.getSpecialPromoEntity()), toDiscoverySectionConfig(promoDiscoveryEntity.getDanaDealsEntity()), toDiscoverySectionConfig(promoDiscoveryEntity.getBankPromoBannerEntity()));
    }

    public static final DiscoverySectionConfig toDiscoverySectionConfig(DiscoverySectionEntity discoverySectionEntity) {
        Intrinsics.checkNotNullParameter(discoverySectionEntity, "");
        return new DiscoverySectionConfig(discoverySectionEntity.getItemCount(), discoverySectionEntity.getVisible(), discoverySectionEntity.getSortBy());
    }
}

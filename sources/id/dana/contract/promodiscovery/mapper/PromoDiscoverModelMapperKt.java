package id.dana.contract.promodiscovery.mapper;

import id.dana.domain.promodiscovery.model.DiscoverySectionConfig;
import id.dana.domain.promodiscovery.model.PromoDiscoverySectionConfig;
import id.dana.promodiscovery.model.DiscoverySectionConfigModel;
import id.dana.promodiscovery.model.PromoDiscoverySectionConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;", "Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;", "PlaceComponentResult", "(Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;)Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoDiscoverModelMapperKt {
    public static final PromoDiscoverySectionConfigModel PlaceComponentResult(PromoDiscoverySectionConfig promoDiscoverySectionConfig) {
        Intrinsics.checkNotNullParameter(promoDiscoverySectionConfig, "");
        DiscoverySectionConfig voucherBanner = promoDiscoverySectionConfig.getVoucherBanner();
        Intrinsics.checkNotNullParameter(voucherBanner, "");
        DiscoverySectionConfigModel discoverySectionConfigModel = new DiscoverySectionConfigModel(voucherBanner.getItemCount(), voucherBanner.getVisible(), voucherBanner.getSortBy());
        DiscoverySectionConfig nearExpiredPromoBannerConfig = promoDiscoverySectionConfig.getNearExpiredPromoBannerConfig();
        Intrinsics.checkNotNullParameter(nearExpiredPromoBannerConfig, "");
        DiscoverySectionConfigModel discoverySectionConfigModel2 = new DiscoverySectionConfigModel(nearExpiredPromoBannerConfig.getItemCount(), nearExpiredPromoBannerConfig.getVisible(), nearExpiredPromoBannerConfig.getSortBy());
        DiscoverySectionConfig specialPromo = promoDiscoverySectionConfig.getSpecialPromo();
        Intrinsics.checkNotNullParameter(specialPromo, "");
        DiscoverySectionConfigModel discoverySectionConfigModel3 = new DiscoverySectionConfigModel(specialPromo.getItemCount(), specialPromo.getVisible(), specialPromo.getSortBy());
        DiscoverySectionConfig danaDeals = promoDiscoverySectionConfig.getDanaDeals();
        Intrinsics.checkNotNullParameter(danaDeals, "");
        DiscoverySectionConfigModel discoverySectionConfigModel4 = new DiscoverySectionConfigModel(danaDeals.getItemCount(), danaDeals.getVisible(), danaDeals.getSortBy());
        DiscoverySectionConfig bankPromoBanner = promoDiscoverySectionConfig.getBankPromoBanner();
        Intrinsics.checkNotNullParameter(bankPromoBanner, "");
        return new PromoDiscoverySectionConfigModel(discoverySectionConfigModel, discoverySectionConfigModel2, discoverySectionConfigModel3, discoverySectionConfigModel4, new DiscoverySectionConfigModel(bankPromoBanner.getItemCount(), bankPromoBanner.getVisible(), bankPromoBanner.getSortBy()));
    }
}

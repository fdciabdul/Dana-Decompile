package id.dana.data.nearbyme.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyQueryOtherShopListRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyQueryRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyRadiusRequest;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;

/* loaded from: classes4.dex */
public interface NearbyMeFacade {
    @OperationType("id.dana.discovery.nearby.queryList")
    @SignCheck
    NearbyShopsResult getDiscoveryNearbyMeShops(NearbyQueryRequest nearbyQueryRequest);

    @OperationType(GetNearbyShopsWithRadius.QUERY_RADIUS_DISCOVERY)
    @SignCheck
    NearbyShopsResult getDiscoveryNearbyRadius(NearbyRadiusRequest nearbyRadiusRequest);

    @OperationType(GetNearbyShopsWithRadius.QUERY_RADIUS_MOBILEWALLET)
    @SignCheck
    NearbyShopsResult getNearbyMeByRadius(NearbyRadiusRequest nearbyRadiusRequest);

    @OperationType("alipayplus.mobilewallet.nearby.querylist")
    @SignCheck
    NearbyShopsResult getNearbyMeShops(NearbyQueryRequest nearbyQueryRequest);

    @OperationType("alipayplus.mobilewallet.nearby.querypromo")
    @SignCheck
    NearbyShopsPromoResult getNearbyPromo(NearbyPromoRequest nearbyPromoRequest);

    @OperationType("id.dana.discovery.nearby.queryPromo")
    @SignCheck
    NearbyShopsPromoResult getNearbyPromoFromMigratedApi(NearbyPromoRequest nearbyPromoRequest);

    @OperationType("alipayplus.mobilewallet.nearby.queryShop")
    @SignCheck
    NearbyQueryOtherShopListResult getOtherShopList(NearbyQueryOtherShopListRequest nearbyQueryOtherShopListRequest);

    @OperationType("id.dana.promotionprod.nearby.queryShop")
    @SignCheck
    NearbyQueryOtherShopListResult getOtherShopListFromMigratedApi(NearbyQueryOtherShopListRequest nearbyQueryOtherShopListRequest);
}

package id.dana.data.nearbyme;

import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface NearbyMeEntityData {
    Observable<ShopsPage> getCachedNearbyShops();

    Observable<UserCoordinateEntityData> getCachedNearbyWidgetLocation();

    Observable<NearbyRankingConfig> getDefaultNearbyConfig(String str);

    Observable<NearbyShopsResult> getNearbyMeWithPagination(double d, double d2, int i, int i2, String str, boolean z, boolean z2);

    Observable<NearbyShopsResult> getNearbyMeWithPagination(ShopListRequest shopListRequest);

    Observable<NearbyShopsResult> getNearbyMeWithRadius(boolean z, double d, double d2, int i, int i2, int i3, String str, String str2);

    Observable<NearbyShopsPromoResult> getNearbyMerchantPromo(boolean z, List<NearbyPromoShopEntity> list);

    Observable<NearbyQueryOtherShopListResult> getOtherShopList(boolean z, String str, double d, double d2, int i, int i2, String str2, String str3);

    Observable<Boolean> isNeedToShowOnboardingTooltip(String str);

    Observable<ShopsPage> saveNearbyShops(ShopsPage shopsPage, UserCoordinateEntityData userCoordinateEntityData);

    Observable<Boolean> saveShowOnboardingTooltip(String str);
}

package id.dana.domain.nearbyme;

import android.location.Location;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\fJU\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&¢\u0006\u0004\b%\u0010&JU\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00022\u0006\u0010'\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0015H&¢\u0006\u0004\b,\u0010-J\u001b\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0 0\u0002H&¢\u0006\u0004\b/\u0010\u0005J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H&¢\u0006\u0004\b0\u0010\u0005J\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H&¢\u0006\u0004\b1\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/nearbyme/NearbyMeRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/nearbyme/model/ShopsPage;", "getCachedNearbyShops", "()Lio/reactivex/Observable;", "Landroid/location/Location;", "getCachedNearbyWidgetLocation", "", "nearbyVersion", "Lid/dana/domain/nearbyme/model/NearbyRankingConfig;", "getDefaultNearbyRankingConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyme/model/NearbyAutoSearchConfig;", "getNearbyAutoSearchConfig", "getNearbyRankingConfig", "currentLocation", "", "radius", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "", "onInit", "useNewMerchantCategory", "searchKeyword", "searchType", "getNearbyShopByRadius", "(Landroid/location/Location;IIIZZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyme/model/ShopListRequest;", "shopListRequest", "getNearbyShops", "(Lid/dana/domain/nearbyme/model/ShopListRequest;)Lio/reactivex/Observable;", "", "Lid/dana/domain/nearbyme/model/MerchantInfo;", "merchantInfos", "", "Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "getNearbyShopsPromo", "(Ljava/util/List;)Lio/reactivex/Observable;", "merchantId", "", "latitude", "longitude", "Lid/dana/domain/nearbyme/model/OtherStoreListResult;", "getOtherStoreList", "(Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lid/dana/domain/nearbysearch/model/NearbyTrendingKeyword;", "getTrendingKeyword", "isNeedToShowOnboardingTooltip", "saveShowOnboardingTooltip"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NearbyMeRepository {
    Observable<ShopsPage> getCachedNearbyShops();

    Observable<Location> getCachedNearbyWidgetLocation();

    Observable<NearbyRankingConfig> getDefaultNearbyRankingConfig(String nearbyVersion);

    Observable<NearbyAutoSearchConfig> getNearbyAutoSearchConfig();

    Observable<NearbyRankingConfig> getNearbyRankingConfig(String nearbyVersion);

    Observable<ShopsPage> getNearbyShopByRadius(Location currentLocation, int radius, int pageNum, int pageSize, boolean onInit, boolean useNewMerchantCategory, String searchKeyword, String searchType);

    Observable<ShopsPage> getNearbyShops(ShopListRequest shopListRequest);

    Observable<List<NearbyShopsPromo>> getNearbyShopsPromo(List<MerchantInfo> merchantInfos);

    Observable<OtherStoreListResult> getOtherStoreList(String merchantId, double latitude, double longitude, int pageNum, int pageSize, String searchKeyword, String searchType, boolean useNewMerchantCategory);

    Observable<List<NearbyTrendingKeyword>> getTrendingKeyword();

    Observable<Boolean> isNeedToShowOnboardingTooltip();

    Observable<Boolean> saveShowOnboardingTooltip();
}

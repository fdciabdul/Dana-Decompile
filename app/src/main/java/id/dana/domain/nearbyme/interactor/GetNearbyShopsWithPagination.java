package id.dana.domain.nearbyme.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.NearbyWidgetConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.domain.util.LocationUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002&'B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR.\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "Lid/dana/domain/nearbyme/model/ShopsPage;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination$Params;)Lio/reactivex/Observable;", "getNearbyShopsFromBackend", "", "getOperationType", "()Ljava/lang/String;", "Landroid/location/Location;", "lastLocation", "currentLocation", "", "maxDistance", "", "isDistanceMoreThanRadiusConfig", "(Landroid/location/Location;Landroid/location/Location;J)Z", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "mixpanelRepository", "Lid/dana/domain/tracker/MixpanelRepository;", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "nearbyMeRepository", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "<set-?>", "useDiscoveryApi", "Ljava/lang/Boolean;", "getUseDiscoveryApi", "()Ljava/lang/Boolean;", "setUseDiscoveryApi", "(Ljava/lang/Boolean;)V", "<init>", "(Lid/dana/domain/nearbyme/NearbyMeRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNearbyShopsWithPagination extends BaseUseCaseWithAnalytics<ShopsPage, Params> {
    private static final String QUERY_LIST_DISCOVERY = "id.dana.discovery.nearby.queryList";
    private static final String QUERY_LIST_MOBILEWALLET = "alipayplus.mobilewallet.nearby.querylist";
    private final FeatureConfigRepository featureConfigRepository;
    private final MixpanelRepository mixpanelRepository;
    private final NearbyMeRepository nearbyMeRepository;
    private Boolean useDiscoveryApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetNearbyShopsWithPagination(NearbyMeRepository nearbyMeRepository, FeatureConfigRepository featureConfigRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(nearbyMeRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.nearbyMeRepository = nearbyMeRepository;
        this.featureConfigRepository = featureConfigRepository;
        this.mixpanelRepository = mixpanelRepository;
    }

    @JvmName(name = "getUseDiscoveryApi")
    public final Boolean getUseDiscoveryApi() {
        return this.useDiscoveryApi;
    }

    @JvmName(name = "setUseDiscoveryApi")
    public final void setUseDiscoveryApi(Boolean bool) {
        this.useDiscoveryApi = bool;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ShopsPage> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (Intrinsics.areEqual(params.getShopListRequest().getSource(), "home")) {
            Observable<ShopsPage> flatMap = this.featureConfigRepository.getNearbyWidgetConfig().zipWith(this.nearbyMeRepository.getCachedNearbyWidgetLocation(), new BiFunction() { // from class: id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    ShopListRequest m2374buildUseCase$lambda1;
                    m2374buildUseCase$lambda1 = GetNearbyShopsWithPagination.m2374buildUseCase$lambda1(GetNearbyShopsWithPagination.this, params, (NearbyWidgetConfig) obj, (Location) obj2);
                    return m2374buildUseCase$lambda1;
                }
            }).flatMap(new Function() { // from class: id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2375buildUseCase$lambda2;
                    m2375buildUseCase$lambda2 = GetNearbyShopsWithPagination.m2375buildUseCase$lambda2(GetNearbyShopsWithPagination.this, params, (ShopListRequest) obj);
                    return m2375buildUseCase$lambda2;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        } else if (Intrinsics.areEqual(params.getShopListRequest().getSource(), "search")) {
            Observable flatMap2 = this.featureConfigRepository.getNearbyConfig().flatMap(new Function() { // from class: id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2376buildUseCase$lambda3;
                    m2376buildUseCase$lambda3 = GetNearbyShopsWithPagination.m2376buildUseCase$lambda3(GetNearbyShopsWithPagination.this, params, (NearbyConfig) obj);
                    return m2376buildUseCase$lambda3;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap2, "");
            return flatMap2;
        } else {
            Observable<ShopsPage> error = Observable.error(new UnsupportedOperationException("Unsupported query list source"));
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
    }

    /* renamed from: buildUseCase$lambda-1 */
    public static final ShopListRequest m2374buildUseCase$lambda1(GetNearbyShopsWithPagination getNearbyShopsWithPagination, Params params, NearbyWidgetConfig nearbyWidgetConfig, Location location) {
        Intrinsics.checkNotNullParameter(getNearbyShopsWithPagination, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(nearbyWidgetConfig, "");
        Intrinsics.checkNotNullParameter(location, "");
        getNearbyShopsWithPagination.useDiscoveryApi = Boolean.valueOf(nearbyWidgetConfig.getMigrateApiHome());
        ShopListRequest shopListRequest = params.getShopListRequest();
        shopListRequest.setShouldFetchFromBackend(getNearbyShopsWithPagination.isDistanceMoreThanRadiusConfig(location, LocationUtil.latLonToLocation(shopListRequest.getLatitude(), shopListRequest.getLongitude()), nearbyWidgetConfig.getRadius()));
        shopListRequest.setUseDiscoveryApi(nearbyWidgetConfig.getMigrateApiHome());
        shopListRequest.setFilterByKybKa(nearbyWidgetConfig.getKybKaFilter());
        return shopListRequest;
    }

    /* renamed from: buildUseCase$lambda-2 */
    public static final ObservableSource m2375buildUseCase$lambda2(GetNearbyShopsWithPagination getNearbyShopsWithPagination, Params params, ShopListRequest shopListRequest) {
        Observable<ShopsPage> cachedNearbyShops;
        Intrinsics.checkNotNullParameter(getNearbyShopsWithPagination, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(shopListRequest, "");
        if (shopListRequest.getShouldFetchFromBackend()) {
            cachedNearbyShops = getNearbyShopsWithPagination.getNearbyShopsFromBackend(params);
        } else {
            cachedNearbyShops = getNearbyShopsWithPagination.nearbyMeRepository.getCachedNearbyShops();
        }
        return cachedNearbyShops;
    }

    /* renamed from: buildUseCase$lambda-3 */
    public static final ObservableSource m2376buildUseCase$lambda3(GetNearbyShopsWithPagination getNearbyShopsWithPagination, Params params, NearbyConfig nearbyConfig) {
        Intrinsics.checkNotNullParameter(getNearbyShopsWithPagination, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(nearbyConfig, "");
        getNearbyShopsWithPagination.useDiscoveryApi = Boolean.valueOf(nearbyConfig.getUseQueryListDiscoveryApi());
        params.getShopListRequest().setUseDiscoveryApi(nearbyConfig.getUseQueryListDiscoveryApi());
        return getNearbyShopsWithPagination.getNearbyShopsFromBackend(params);
    }

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        Boolean bool = this.useDiscoveryApi;
        return bool != null ? bool.booleanValue() ? QUERY_LIST_DISCOVERY : QUERY_LIST_MOBILEWALLET : "";
    }

    private final boolean isDistanceMoreThanRadiusConfig(Location lastLocation, Location currentLocation, long maxDistance) {
        return lastLocation.distanceTo(currentLocation) > ((float) maxDistance);
    }

    private final Observable<ShopsPage> getNearbyShopsFromBackend(Params params) {
        return this.nearbyMeRepository.getNearbyShops(params.getShopListRequest());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsWithPagination$Params;", "", "Lid/dana/domain/nearbyme/model/ShopListRequest;", "shopListRequest", "Lid/dana/domain/nearbyme/model/ShopListRequest;", "getShopListRequest", "()Lid/dana/domain/nearbyme/model/ShopListRequest;", "<init>", "(Lid/dana/domain/nearbyme/model/ShopListRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final ShopListRequest shopListRequest;

        public Params(ShopListRequest shopListRequest) {
            Intrinsics.checkNotNullParameter(shopListRequest, "");
            this.shopListRequest = shopListRequest;
        }

        @JvmName(name = "getShopListRequest")
        public final ShopListRequest getShopListRequest() {
            return this.shopListRequest;
        }
    }
}

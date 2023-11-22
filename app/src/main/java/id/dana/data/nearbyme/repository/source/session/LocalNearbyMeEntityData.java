package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import android.text.TextUtils;
import id.dana.data.nearbyme.CacheNearbyPromoEntityData;
import id.dana.data.nearbyme.NearbyMeEntityData;
import id.dana.data.nearbyme.model.NearbyPromoResult;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.storage.Serializer;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class LocalNearbyMeEntityData implements NearbyMeEntityData, CacheNearbyPromoEntityData {
    private static final String NEARBY_RADIUS = "radius";
    private static final String NEARBY_RATING = "rating";
    private static final String NEARBY_REVIEW = "review";
    public static final String NEARBY_V2_RANKING_DEFAULT = "json/amcs-nearby-ranking-default.json";
    private static final HashMap<String, NearbyPromoResult> nearbyPromoCache = new HashMap<>();
    private final Context context;
    private final NearbyMePreferences nearbyMePreferences;
    private final Serializer serializer;

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyQueryOtherShopListResult> getOtherShopList(boolean z, String str, double d, double d2, int i, int i2, String str2, String str3) {
        return null;
    }

    @Inject
    public LocalNearbyMeEntityData(Context context, NearbyMePreferences nearbyMePreferences, Serializer serializer) {
        this.context = context;
        this.nearbyMePreferences = nearbyMePreferences;
        this.serializer = serializer;
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(double d, double d2, int i, int i2, String str, boolean z, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithRadius(boolean z, double d, double d2, int i, int i2, int i3, String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(ShopListRequest shopListRequest) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> saveNearbyShops(ShopsPage shopsPage, UserCoordinateEntityData userCoordinateEntityData) {
        if (shopsPage == null) {
            return Observable.just(ShopsPage.empty());
        }
        this.nearbyMePreferences.setNearbyShopsWithPagination(this.serializer.serialize(shopsPage));
        this.nearbyMePreferences.setNearbyWidgetLastLocation(userCoordinateEntityData);
        return Observable.just(shopsPage);
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> getCachedNearbyShops() {
        String nearbyShopsWithPagination = this.nearbyMePreferences.getNearbyShopsWithPagination();
        if (TextUtils.isEmpty(nearbyShopsWithPagination)) {
            return Observable.just(new ShopsPage());
        }
        return Observable.just((ShopsPage) this.serializer.deserialize(nearbyShopsWithPagination, ShopsPage.class));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<UserCoordinateEntityData> getCachedNearbyWidgetLocation() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.nearbyme.repository.source.session.LocalNearbyMeEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalNearbyMeEntityData.this.m1533x12335206();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCachedNearbyWidgetLocation$0$id-dana-data-nearbyme-repository-source-session-LocalNearbyMeEntityData  reason: not valid java name */
    public /* synthetic */ UserCoordinateEntityData m1533x12335206() throws Exception {
        UserCoordinateEntityData nearbyWidgetLastLocation = this.nearbyMePreferences.getNearbyWidgetLastLocation();
        if (nearbyWidgetLastLocation != null) {
            return nearbyWidgetLastLocation;
        }
        throw new CallableReturnNullError("LocalNearbyMeEntityData#getCachedNearbyWidgetLocation");
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsPromoResult> getNearbyMerchantPromo(boolean z, List<NearbyPromoShopEntity> list) {
        NearbyShopsPromoResult nearbyShopsPromoResult = new NearbyShopsPromoResult();
        if (list != null) {
            Iterator<NearbyPromoShopEntity> it = list.iterator();
            while (it.hasNext()) {
                NearbyPromoResult nearbyPromoResult = nearbyPromoCache.get(it.next().merchantId);
                if (nearbyPromoResult != null) {
                    nearbyShopsPromoResult.getShops().add(nearbyPromoResult);
                }
            }
        }
        return Observable.just(nearbyShopsPromoResult);
    }

    @Override // id.dana.data.nearbyme.CacheNearbyPromoEntityData
    public void saveNearbyPromoResult(NearbyShopsPromoResult nearbyShopsPromoResult) {
        if (nearbyShopsPromoResult.getShops() == null || nearbyShopsPromoResult.getShops().isEmpty()) {
            return;
        }
        for (NearbyPromoResult nearbyPromoResult : nearbyShopsPromoResult.getShops()) {
            nearbyPromoCache.put(nearbyPromoResult.getMerchantId(), nearbyPromoResult);
        }
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<Boolean> isNeedToShowOnboardingTooltip(String str) {
        return Observable.just(Boolean.valueOf(!this.nearbyMePreferences.getToolTipShow(str)));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<Boolean> saveShowOnboardingTooltip(String str) {
        return Observable.just(Boolean.valueOf(this.nearbyMePreferences.saveToolTipShow(str)));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyRankingConfig> getDefaultNearbyConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new UnsupportedOperationException();
        }
        return Observable.just(new NearbyRankingConfig());
    }
}

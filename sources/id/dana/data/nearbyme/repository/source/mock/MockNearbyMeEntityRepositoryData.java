package id.dana.data.nearbyme.repository.source.mock;

import android.content.Context;
import id.dana.data.R;
import id.dana.data.nearbyme.NearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.NotImplementedError;

@Singleton
/* loaded from: classes2.dex */
public class MockNearbyMeEntityRepositoryData implements NearbyMeEntityData {
    private final Context context;
    private final Serializer serializer;

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyQueryOtherShopListResult> getOtherShopList(boolean z, String str, double d, double d2, int i, int i2, String str2, String str3) {
        return null;
    }

    @Inject
    public MockNearbyMeEntityRepositoryData(Serializer serializer, Context context) {
        this.serializer = serializer;
        this.context = context;
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(ShopListRequest shopListRequest) {
        return Observable.just((NearbyShopsResult) this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.lookAheadTest), NearbyShopsResult.class));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(double d, double d2, int i, int i2, String str, boolean z, boolean z2) {
        return Observable.just((NearbyShopsResult) this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.lookAheadTest), NearbyShopsResult.class));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithRadius(boolean z, double d, double d2, int i, int i2, int i3, String str, String str2) {
        return Observable.just((NearbyShopsResult) this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.lookAheadTest), NearbyShopsResult.class));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> saveNearbyShops(ShopsPage shopsPage, UserCoordinateEntityData userCoordinateEntityData) {
        return Observable.just(ShopsPage.empty());
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsPromoResult> getNearbyMerchantPromo(boolean z, List<NearbyPromoShopEntity> list) {
        return Observable.error(new NotImplementedError());
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<Boolean> isNeedToShowOnboardingTooltip(String str) {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<Boolean> saveShowOnboardingTooltip(String str) {
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyRankingConfig> getDefaultNearbyConfig(String str) {
        return Observable.just((NearbyRankingConfig) this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.res_0x7f120024_networkuserentitydata_externalsyntheticlambda0), NearbyRankingConfig.class));
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> getCachedNearbyShops() {
        return Observable.just(new ShopsPage());
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<UserCoordinateEntityData> getCachedNearbyWidgetLocation() {
        return Observable.just(new UserCoordinateEntityData());
    }
}

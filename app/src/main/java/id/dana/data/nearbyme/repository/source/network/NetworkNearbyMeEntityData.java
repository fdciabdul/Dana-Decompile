package id.dana.data.nearbyme.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.nearbyme.NearbyMeEntityData;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.request.NearbyQueryOtherShopListRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyQueryRequest;
import id.dana.data.nearbyme.repository.source.network.request.NearbyRadiusRequest;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkNearbyMeEntityData extends SecureBaseNetwork<NearbyMeFacade> implements NearbyMeEntityData {
    @Inject
    public NetworkNearbyMeEntityData(RpcConnector rpcConnector, @Named("nearbyExecutor") ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<NearbyMeFacade> getFacadeClass() {
        return NearbyMeFacade.class;
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(double d, double d2, int i, int i2, String str, boolean z, boolean z2) {
        final NearbyQueryRequest nearbyQueryRequest = new NearbyQueryRequest(d, d2, i, i2, str, "", 5000, z2);
        nearbyQueryRequest.envInfo = generateMobileEnvInfo();
        if (z) {
            return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda0
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    NearbyShopsResult discoveryNearbyMeShops;
                    discoveryNearbyMeShops = ((NearbyMeFacade) obj).getDiscoveryNearbyMeShops(NearbyQueryRequest.this);
                    return discoveryNearbyMeShops;
                }
            });
        }
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                NearbyShopsResult nearbyMeShops;
                nearbyMeShops = ((NearbyMeFacade) obj).getNearbyMeShops(NearbyQueryRequest.this);
                return nearbyMeShops;
            }
        });
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithPagination(ShopListRequest shopListRequest) {
        final NearbyQueryRequest nearbyQueryRequest = new NearbyQueryRequest(shopListRequest.getLatitude(), shopListRequest.getLongitude(), shopListRequest.getPageNum(), shopListRequest.getPageSize(), shopListRequest.getSearchKeyword(), "", 5000, shopListRequest.getIsFilterByKybKa());
        nearbyQueryRequest.envInfo = generateMobileEnvInfo();
        if (shopListRequest.getUseDiscoveryApi()) {
            return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda2
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    NearbyShopsResult discoveryNearbyMeShops;
                    discoveryNearbyMeShops = ((NearbyMeFacade) obj).getDiscoveryNearbyMeShops(NearbyQueryRequest.this);
                    return discoveryNearbyMeShops;
                }
            });
        }
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                NearbyShopsResult nearbyMeShops;
                nearbyMeShops = ((NearbyMeFacade) obj).getNearbyMeShops(NearbyQueryRequest.this);
                return nearbyMeShops;
            }
        });
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsResult> getNearbyMeWithRadius(boolean z, double d, double d2, int i, int i2, int i3, String str, String str2) {
        final NearbyRadiusRequest nearbyRadiusRequest = new NearbyRadiusRequest(d, d2, i, i2, i3, str, str2);
        nearbyRadiusRequest.envInfo = generateMobileEnvInfo();
        if (z) {
            return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda4
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    NearbyShopsResult discoveryNearbyRadius;
                    discoveryNearbyRadius = ((NearbyMeFacade) obj).getDiscoveryNearbyRadius(NearbyRadiusRequest.this);
                    return discoveryNearbyRadius;
                }
            });
        }
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                NearbyShopsResult nearbyMeByRadius;
                nearbyMeByRadius = ((NearbyMeFacade) obj).getNearbyMeByRadius(NearbyRadiusRequest.this);
                return nearbyMeByRadius;
            }
        });
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> saveNearbyShops(ShopsPage shopsPage, UserCoordinateEntityData userCoordinateEntityData) {
        return Observable.just(ShopsPage.empty());
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyShopsPromoResult> getNearbyMerchantPromo(final boolean z, List<NearbyPromoShopEntity> list) {
        final NearbyPromoRequest nearbyPromoRequest = new NearbyPromoRequest();
        nearbyPromoRequest.envInfo = generateMobileEnvInfo();
        nearbyPromoRequest.shopInfos = list;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkNearbyMeEntityData.lambda$getNearbyMerchantPromo$6(z, nearbyPromoRequest, (NearbyMeFacade) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ NearbyShopsPromoResult lambda$getNearbyMerchantPromo$6(boolean z, NearbyPromoRequest nearbyPromoRequest, NearbyMeFacade nearbyMeFacade) {
        if (z) {
            return nearbyMeFacade.getNearbyPromoFromMigratedApi(nearbyPromoRequest);
        }
        return nearbyMeFacade.getNearbyPromo(nearbyPromoRequest);
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<NearbyQueryOtherShopListResult> getOtherShopList(boolean z, String str, double d, double d2, int i, int i2, String str2, String str3) {
        final NearbyQueryOtherShopListRequest nearbyQueryOtherShopListRequest = new NearbyQueryOtherShopListRequest(str, d, d2, i, i2, str2, str3);
        nearbyQueryOtherShopListRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.nearbyme.repository.source.network.NetworkNearbyMeEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                NearbyQueryOtherShopListResult otherShopList;
                otherShopList = ((NearbyMeFacade) obj).getOtherShopList(NearbyQueryOtherShopListRequest.this);
                return otherShopList;
            }
        });
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
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<ShopsPage> getCachedNearbyShops() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.nearbyme.NearbyMeEntityData
    public Observable<UserCoordinateEntityData> getCachedNearbyWidgetLocation() {
        throw new UnsupportedOperationException();
    }
}

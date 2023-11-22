package id.dana.data.nearbyme.repository;

import android.location.Location;
import android.text.TextUtils;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.merchant.MerchantCategoriesEntityDataFactory;
import id.dana.data.merchant.model.MerchantSubcategoryEntity;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityData;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository;
import id.dana.data.nearbyme.CacheNearbyPromoEntityData;
import id.dana.data.nearbyme.NearbyMeEntityData;
import id.dana.data.nearbyme.mapper.MerchantInfoMapper;
import id.dana.data.nearbyme.mapper.NearbyPromoResultMapper;
import id.dana.data.nearbyme.mapper.NearbyShopsResultMapper;
import id.dana.data.nearbyme.mapper.OtherStoreListResultMapper;
import id.dana.data.nearbyme.model.NearbyPromoResult;
import id.dana.data.nearbyme.model.ShopEntity;
import id.dana.data.nearbyme.repository.source.CacheNearbyPromoFactory;
import id.dana.data.nearbyme.repository.source.NearbyMeDataFactory;
import id.dana.data.nearbyme.repository.source.network.request.NearbyPromoShopEntity;
import id.dana.data.nearbyme.repository.source.network.result.NearbyQueryOtherShopListResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsPromoResult;
import id.dana.data.nearbyme.repository.source.network.result.NearbyShopsResult;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.NearbyRankingRuleVersion;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.OtherStoreListResult;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.nearbysearch.model.NearbyTrendingKeyword;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NearbyMeEntityRepository implements NearbyMeRepository {
    private final CacheNearbyPromoFactory cacheNearbyPromoFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final MerchantCategoriesEntityRepository merchantCategoriesEntityRepository;
    private final MerchantCategoriesEntityDataFactory merchantCategoryDataFactory;
    private final MerchantInfoMapper merchantInfoMapper;
    private final NearbyMeDataFactory nearbyMeDataFactory;
    private final NearbyPromoResultMapper nearbyPromoResultMapper;
    private final OtherStoreListResultMapper otherStoreListResultMapper;
    private final NearbyShopsResultMapper shopsResultMapper;
    private final SplitConfigEntityData splitConfigEntityData;

    @Inject
    public NearbyMeEntityRepository(NearbyMeDataFactory nearbyMeDataFactory, NearbyShopsResultMapper nearbyShopsResultMapper, MerchantInfoMapper merchantInfoMapper, NearbyPromoResultMapper nearbyPromoResultMapper, OtherStoreListResultMapper otherStoreListResultMapper, MerchantCategoriesEntityRepository merchantCategoriesEntityRepository, MerchantCategoriesEntityDataFactory merchantCategoriesEntityDataFactory, SplitConfigEntityData splitConfigEntityData, CacheNearbyPromoFactory cacheNearbyPromoFactory, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.nearbyMeDataFactory = nearbyMeDataFactory;
        this.shopsResultMapper = nearbyShopsResultMapper;
        this.merchantCategoryDataFactory = merchantCategoriesEntityDataFactory;
        this.merchantInfoMapper = merchantInfoMapper;
        this.nearbyPromoResultMapper = nearbyPromoResultMapper;
        this.otherStoreListResultMapper = otherStoreListResultMapper;
        this.splitConfigEntityData = splitConfigEntityData;
        this.cacheNearbyPromoFactory = cacheNearbyPromoFactory;
        this.merchantCategoriesEntityRepository = merchantCategoriesEntityRepository;
        this.configEntityDataFactory = configEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<NearbyRankingConfig> getNearbyRankingConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new UnsupportedOperationException();
        }
        if (NearbyRankingRuleVersion.RANKING_RULE_V1.equals(str)) {
            return this.holdLoginV1EntityRepository.authenticatedRequest(createNearbyMeLocalFactory().getDefaultNearbyConfig(NearbyRankingRuleVersion.RANKING_RULE_V1));
        }
        return this.splitConfigEntityData.getNearbyRankingConfigV2().startWith(createNearbyMeLocalFactory().getDefaultNearbyConfig(str));
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<NearbyRankingConfig> getDefaultNearbyRankingConfig(String str) {
        return createNearbyMeLocalFactory().getDefaultNearbyConfig(str);
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<ShopsPage> getCachedNearbyShops() {
        return createNearbyMeLocalFactory().getCachedNearbyShops();
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<Location> getCachedNearbyWidgetLocation() {
        return createNearbyMeLocalFactory().getCachedNearbyWidgetLocation().onErrorReturnItem(new UserCoordinateEntityData()).map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((UserCoordinateEntityData) obj).toLocation();
            }
        });
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<ShopsPage> getNearbyShops(final ShopListRequest shopListRequest) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createNearbyMeDataFactory().getNearbyMeWithPagination(shopListRequest).zipWith(getMerchantSubcategories(shopListRequest.getUseNewMerchantCategory()), new BiFunction() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return NearbyMeEntityRepository.this.m1519xd340d836((NearbyShopsResult) obj, (Map) obj2);
            }
        }).zipWith(getMerchantTopupAgent(), new BiFunction() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return NearbyMeEntityRepository.this.m1520xe3f6a4f7((NearbyShopsResult) obj, (Map) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1521xf4ac71b8(shopListRequest, (NearbyShopsResult) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyMeEntityRepository.this.m1522x5623e79(shopListRequest, (ShopsPage) obj);
            }
        }));
    }

    /* renamed from: lambda$getNearbyShops$0$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyShopsResult m1519xd340d836(NearbyShopsResult nearbyShopsResult, Map map) throws Exception {
        this.shopsResultMapper.setMerchantSubcategory(map);
        return nearbyShopsResult;
    }

    /* renamed from: lambda$getNearbyShops$1$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyShopsResult m1520xe3f6a4f7(NearbyShopsResult nearbyShopsResult, Map map) throws Exception {
        this.shopsResultMapper.setMerchantInstId(map);
        return nearbyShopsResult;
    }

    /* renamed from: lambda$getNearbyShops$2$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1521xf4ac71b8(ShopListRequest shopListRequest, NearbyShopsResult nearbyShopsResult) throws Exception {
        this.shopsResultMapper.setUsingNewMerchantCategories(shopListRequest.getUseNewMerchantCategory());
        ShopsPage apply = this.shopsResultMapper.apply(shopListRequest.getLatitude(), shopListRequest.getLongitude(), nearbyShopsResult);
        if (!TextUtils.isEmpty(shopListRequest.getSource()) && shopListRequest.getSource().equals("home")) {
            return Observable.just(apply);
        }
        return Observable.just(sortByDistance(apply));
    }

    /* renamed from: lambda$getNearbyShops$3$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ void m1522x5623e79(ShopListRequest shopListRequest, ShopsPage shopsPage) throws Exception {
        if ("home".equals(shopListRequest.getSource())) {
            createNearbyMeLocalFactory().saveNearbyShops(shopsPage, new UserCoordinateEntityData(shopListRequest.getLatitude(), shopListRequest.getLongitude()));
        }
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<ShopsPage> getNearbyShopByRadius(final Location location, final int i, final int i2, final int i3, final boolean z, final boolean z2, final String str, final String str2) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createConfigSplitEntityData().getNearbyConfig().switchMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1514x1d39f3cc(location, i, i3, i2, str, str2, (NearbyConfigResult) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1515x2defc08d(z, location, i2, i3, (NearbyShopsResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1516x3ea58d4e(location, i, (NearbyShopsResult) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1518x601126d0(z2, location, (NearbyShopsResult) obj);
            }
        }));
    }

    /* renamed from: lambda$getNearbyShopByRadius$4$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1514x1d39f3cc(Location location, int i, int i2, int i3, String str, String str2, NearbyConfigResult nearbyConfigResult) throws Exception {
        return createNearbyMeDataFactory().getNearbyMeWithRadius((nearbyConfigResult.getMigrateApi() == null || nearbyConfigResult.getMigrateApi().getQueryRadius() == null) ? false : nearbyConfigResult.getMigrateApi().getQueryRadius().booleanValue(), location.getLatitude(), location.getLongitude(), i, i2, i3, str, str2);
    }

    /* renamed from: lambda$getNearbyShopByRadius$5$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1515x2defc08d(boolean z, Location location, int i, int i2, NearbyShopsResult nearbyShopsResult) throws Exception {
        if ((nearbyShopsResult.getShops() == null || nearbyShopsResult.getShops().isEmpty()) && z) {
            return createNearbyMeLocalFactory().getNearbyMeWithPagination(location.getLatitude(), location.getLongitude(), i, i2, "", false, false);
        }
        return Observable.just(nearbyShopsResult);
    }

    /* renamed from: lambda$getNearbyShopByRadius$6$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyShopsResult m1516x3ea58d4e(Location location, int i, NearbyShopsResult nearbyShopsResult) throws Exception {
        nearbyShopsResult.setShops(getFilteredShopEntities(nearbyShopsResult.getShops(), location, i));
        return nearbyShopsResult;
    }

    /* renamed from: lambda$getNearbyShopByRadius$8$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ Observable m1518x601126d0(final boolean z, final Location location, final NearbyShopsResult nearbyShopsResult) throws Exception {
        return Observable.zip(getMerchantSubcategories(z), getMerchantTopupAgent(), new BiFunction() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return NearbyMeEntityRepository.this.m1517x4f5b5a0f(z, location, nearbyShopsResult, (Map) obj, (Map) obj2);
            }
        });
    }

    /* renamed from: lambda$getNearbyShopByRadius$7$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ShopsPage m1517x4f5b5a0f(boolean z, Location location, NearbyShopsResult nearbyShopsResult, Map map, Map map2) throws Exception {
        this.shopsResultMapper.setUsingNewMerchantCategories(z);
        this.shopsResultMapper.setMerchantSubcategory(map);
        this.shopsResultMapper.setMerchantInstId(map2);
        return sortByDistance(this.shopsResultMapper.apply(location.getLatitude(), location.getLongitude(), nearbyShopsResult));
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<List<NearbyShopsPromo>> getNearbyShopsPromo(List<MerchantInfo> list) {
        final ArrayList arrayList = new ArrayList();
        final List<NearbyPromoShopEntity> apply = this.merchantInfoMapper.apply(list);
        return this.holdLoginV1EntityRepository.authenticatedRequest(createConfigSplitEntityData().isMigratePromoOperationType().switchMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1525x809cad04(apply, (Boolean) obj);
            }
        }).map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1523xdfbcb3de(arrayList, (NearbyShopsPromoResult) obj);
            }
        }).map(removeMerchantInfoFoundInCache(apply)).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1524x1284d60(apply, arrayList, (List) obj);
            }
        }));
    }

    /* renamed from: lambda$getNearbyShopsPromo$9$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1525x809cad04(List list, Boolean bool) throws Exception {
        return createNearbyMeLocalFactory().getNearbyMerchantPromo(bool.booleanValue(), list);
    }

    /* renamed from: lambda$getNearbyShopsPromo$10$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyShopsPromoResult m1523xdfbcb3de(List list, NearbyShopsPromoResult nearbyShopsPromoResult) throws Exception {
        list.addAll(this.nearbyPromoResultMapper.apply(nearbyShopsPromoResult));
        return nearbyShopsPromoResult;
    }

    /* renamed from: lambda$getNearbyShopsPromo$12$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1524x1284d60(List list, final List list2, List list3) throws Exception {
        if (!list.isEmpty()) {
            Observable<R> map = getMerchantPromoFromBackend(list).map(saveMerchantPromoToCache());
            final NearbyPromoResultMapper nearbyPromoResultMapper = this.nearbyPromoResultMapper;
            Objects.requireNonNull(nearbyPromoResultMapper);
            return map.map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return NearbyPromoResultMapper.this.apply((NearbyShopsPromoResult) obj);
                }
            }).map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda4
                /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                    jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.nearbyme.repository.NearbyMeEntityRepository.lambda$getNearbyShopsPromo$11(java.util.List, java.util.List):java.util.List
                    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                    Caused by: java.lang.NullPointerException
                    */
                @Override // io.reactivex.functions.Function
                public final java.lang.Object apply(java.lang.Object r2) {
                    /*
                        r1 = this;
                        java.util.List r0 = r1
                        java.util.List r2 = (java.util.List) r2
                        java.util.List r2 = id.dana.data.nearbyme.repository.NearbyMeEntityRepository.lambda$getNearbyShopsPromo$11(r0, r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda4.apply(java.lang.Object):java.lang.Object");
                }
            });
        }
        return Observable.just(list2);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static /* synthetic */ java.util.List lambda$getNearbyShopsPromo$11(java.util.List r0, java.util.List r1) throws java.lang.Exception {
        /*
            r0.addAll(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.NearbyMeEntityRepository.lambda$getNearbyShopsPromo$11(java.util.List, java.util.List):java.util.List");
    }

    private Function<NearbyShopsPromoResult, List<NearbyPromoShopEntity>> removeMerchantInfoFoundInCache(final List<NearbyPromoShopEntity> list) {
        return new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.lambda$removeMerchantInfoFoundInCache$13(list, (NearbyShopsPromoResult) obj);
            }
        };
    }

    public static /* synthetic */ List lambda$removeMerchantInfoFoundInCache$13(List list, NearbyShopsPromoResult nearbyShopsPromoResult) throws Exception {
        for (NearbyPromoResult nearbyPromoResult : nearbyShopsPromoResult.getShops()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NearbyPromoShopEntity nearbyPromoShopEntity = (NearbyPromoShopEntity) it.next();
                if (nearbyPromoShopEntity.isMerchantIdEqual(nearbyPromoResult) && nearbyPromoShopEntity.isShopIdEqual(nearbyPromoResult)) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private Observable<NearbyShopsPromoResult> getMerchantPromoFromBackend(final List<NearbyPromoShopEntity> list) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createConfigSplitEntityData().isMigratePromoOperationType().switchMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1512x4bda42f0(list, (Boolean) obj);
            }
        }));
    }

    /* renamed from: lambda$getMerchantPromoFromBackend$14$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1512x4bda42f0(List list, Boolean bool) throws Exception {
        return createNearbyMeDataFactory().getNearbyMerchantPromo(bool.booleanValue(), list);
    }

    private Function<NearbyShopsPromoResult, NearbyShopsPromoResult> saveMerchantPromoToCache() {
        return new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1531x32be4473((NearbyShopsPromoResult) obj);
            }
        };
    }

    /* renamed from: lambda$saveMerchantPromoToCache$15$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyShopsPromoResult m1531x32be4473(NearbyShopsPromoResult nearbyShopsPromoResult) throws Exception {
        createCacheNearbyPromo().saveNearbyPromoResult(nearbyShopsPromoResult);
        return nearbyShopsPromoResult;
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<OtherStoreListResult> getOtherStoreList(final String str, final double d, final double d2, final int i, final int i2, final String str2, final String str3, final boolean z) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createConfigSplitEntityData().isMigratePromoOperationType().switchMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1526xe4aada6(str, d, d2, i2, i, str2, str3, (Boolean) obj);
            }
        }).zipWith(getMerchantSubcategories(z), new BiFunction() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return NearbyMeEntityRepository.this.m1527x1f007a67(z, (NearbyQueryOtherShopListResult) obj, (Map) obj2);
            }
        }).zipWith(getMerchantTopupAgent(), new BiFunction() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return NearbyMeEntityRepository.this.m1528x2fb64728((NearbyQueryOtherShopListResult) obj, (Map) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1529x406c13e9(d, d2, (NearbyQueryOtherShopListResult) obj);
            }
        }));
    }

    /* renamed from: lambda$getOtherStoreList$16$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1526xe4aada6(String str, double d, double d2, int i, int i2, String str2, String str3, Boolean bool) throws Exception {
        return createNearbyMeDataFactory().getOtherShopList(bool.booleanValue(), str, d, d2, i, i2, str2, str3);
    }

    /* renamed from: lambda$getOtherStoreList$17$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyQueryOtherShopListResult m1527x1f007a67(boolean z, NearbyQueryOtherShopListResult nearbyQueryOtherShopListResult, Map map) throws Exception {
        this.shopsResultMapper.setUsingNewMerchantCategories(z);
        this.shopsResultMapper.setMerchantSubcategory(map);
        return nearbyQueryOtherShopListResult;
    }

    /* renamed from: lambda$getOtherStoreList$18$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ NearbyQueryOtherShopListResult m1528x2fb64728(NearbyQueryOtherShopListResult nearbyQueryOtherShopListResult, Map map) throws Exception {
        this.shopsResultMapper.setMerchantInstId(map);
        return nearbyQueryOtherShopListResult;
    }

    /* renamed from: lambda$getOtherStoreList$19$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1529x406c13e9(double d, double d2, NearbyQueryOtherShopListResult nearbyQueryOtherShopListResult) throws Exception {
        this.shopsResultMapper.setCurrentMarkerLocation(d, d2);
        OtherStoreListResult apply = this.otherStoreListResultMapper.apply(d, d2, nearbyQueryOtherShopListResult);
        apply.setShops(this.shopsResultMapper.transform(nearbyQueryOtherShopListResult.getShops()));
        return Observable.just(apply);
    }

    private ConfigEntityData createConfigSplitEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<Boolean> isNeedToShowOnboardingTooltip() {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1530x94b60294((String) obj);
            }
        });
    }

    /* renamed from: lambda$isNeedToShowOnboardingTooltip$20$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1530x94b60294(String str) throws Exception {
        return createNearbyMeLocalFactory().isNeedToShowOnboardingTooltip(str);
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<Boolean> saveShowOnboardingTooltip() {
        return getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1532x2e811357((String) obj);
            }
        });
    }

    /* renamed from: lambda$saveShowOnboardingTooltip$21$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ ObservableSource m1532x2e811357(String str) throws Exception {
        return createNearbyMeLocalFactory().saveShowOnboardingTooltip(str);
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<NearbyAutoSearchConfig> getNearbyAutoSearchConfig() {
        return this.splitConfigEntityData.getNearbyAutoSearchConfig();
    }

    @Override // id.dana.domain.nearbyme.NearbyMeRepository
    public Observable<List<NearbyTrendingKeyword>> getTrendingKeyword() {
        return createConfigSplitEntityData().getNearbyConfig().map(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List trendingKeyword;
                trendingKeyword = ((NearbyConfigResult) obj).toNearbyConfig().getTrendingKeyword();
                return trendingKeyword;
            }
        });
    }

    private Observable<String> getPhoneNumber() {
        return this.holdLoginV1EntityRepository.createAccountData().getAccount().map(new NearbyMeEntityRepository$$ExternalSyntheticLambda1());
    }

    private List<ShopEntity> getFilteredShopEntities(List<ShopEntity> list, Location location, int i) {
        ArrayList arrayList = new ArrayList();
        for (ShopEntity shopEntity : list) {
            if (isWithinRadius(shopEntity, location, i)) {
                arrayList.add(shopEntity);
            }
        }
        return arrayList;
    }

    private boolean isWithinRadius(ShopEntity shopEntity, Location location, float f) {
        Location location2 = new Location("");
        location2.setLatitude(shopEntity.getLatitude());
        location2.setLongitude(shopEntity.getLongtitude());
        return location.distanceTo(location2) <= f;
    }

    private CacheNearbyPromoEntityData createCacheNearbyPromo() {
        return this.cacheNearbyPromoFactory.createData2("local");
    }

    private NearbyMeEntityData createNearbyMeDataFactory() {
        return this.nearbyMeDataFactory.createData2("network");
    }

    public Observable<Map<String, MerchantSubcategoryEntity>> getMerchantSubcategories(boolean z) {
        if (z) {
            return this.merchantCategoriesEntityRepository.getNewMerchantSubCategoriesMap();
        }
        return this.holdLoginV1EntityRepository.authenticatedRequest(createMerchantCategoryDataFactory().getMerchantSubcategories()).onErrorResumeNext(createDefaultMerchantCategories().getMerchantSubcategories());
    }

    public Observable<Map<String, String>> getMerchantTopupAgent() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createMerchantCategoryDataFactory().getMerchantTopups()).onErrorResumeNext(createDefaultMerchantCategories().getMerchantTopups()).flatMap(new Function() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyMeEntityRepository.this.m1513x3bacffd4((Map) obj);
            }
        });
    }

    /* renamed from: lambda$getMerchantTopupAgent$23$id-dana-data-nearbyme-repository-NearbyMeEntityRepository */
    public /* synthetic */ Observable m1513x3bacffd4(Map map) throws Exception {
        if (map.isEmpty()) {
            return createDefaultMerchantCategories().getMerchantTopups();
        }
        return Observable.just(map);
    }

    private ShopsPage sortByDistance(ShopsPage shopsPage) {
        if (shopsPage != null) {
            Collections.sort(shopsPage.getShops(), new Comparator() { // from class: id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda13
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compareTo;
                    compareTo = BigDecimal.valueOf(((Shop) obj).getDistance()).compareTo(BigDecimal.valueOf(((Shop) obj2).getDistance()));
                    return compareTo;
                }
            });
        }
        return shopsPage;
    }

    private MerchantCategoriesEntityData createMerchantCategoryDataFactory() {
        return this.merchantCategoryDataFactory.createData2("network");
    }

    private MerchantCategoriesEntityData createDefaultMerchantCategories() {
        return this.merchantCategoryDataFactory.createData2("local");
    }

    private NearbyMeEntityData createNearbyMeLocalFactory() {
        return this.nearbyMeDataFactory.createData2("local");
    }
}

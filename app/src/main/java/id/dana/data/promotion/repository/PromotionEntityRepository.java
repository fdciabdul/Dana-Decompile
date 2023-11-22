package id.dana.data.promotion.repository;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.reflect.TypeToken;
import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.data.account.general.repository.GeneralEntityData;
import id.dana.data.account.general.repository.GeneralEntityDataFactory;
import id.dana.data.banner.model.BannerEntity;
import id.dana.data.banner.model.BannerListEntity;
import id.dana.data.banner.repository.source.BannerCacheEntityDataFactory;
import id.dana.data.banner.repository.source.BannerEntityDataFactory;
import id.dana.data.banner.repository.source.BannerPlacement;
import id.dana.data.banner.repository.source.network.response.BannerListEntityResponse;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.cache.GeneralPreferencesCacheEntityData;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.BannerConfigResult;
import id.dana.data.config.source.amcs.result.InterstitialBannerConfigResult;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.BannerListEntityMapper;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.promotion.NoHomeBannerSplitException;
import id.dana.data.promotion.repository.source.PromoEntityData;
import id.dana.data.promotion.repository.source.persistence.PromoEntityDataFactory;
import id.dana.data.sendmoney.SendMoneyEntityData;
import id.dana.data.sendmoney.repository.source.SendMoneyDataFactory;
import id.dana.data.sendmoney.repository.source.network.request.TransferInitRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferInitResult;
import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PromotionEntityRepository implements PromotionRepository {
    private final BannerCacheEntityDataFactory bannerCacheEntityDataFactory;
    private final BannerEntityDataFactory bannerEntityDataFactory;
    private final BannerListEntityMapper bannerListEntityMapper;
    private CacheEntityData<BannerListEntity> bannerPreferencesEntityData;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory;
    private final ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private final GeneralEntityDataFactory generalEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final SpaceResultMapper mapper;
    private final PromoEntityDataFactory promoEntityDataFactory;
    private final SendMoneyDataFactory sendMoneyDataFactory;

    @Inject
    public PromotionEntityRepository(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, BannerCacheEntityDataFactory bannerCacheEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, SpaceResultMapper spaceResultMapper, PromoEntityDataFactory promoEntityDataFactory, SendMoneyDataFactory sendMoneyDataFactory, GeneralEntityDataFactory generalEntityDataFactory, BannerEntityDataFactory bannerEntityDataFactory, BannerListEntityMapper bannerListEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.contentDeliveryCacheEntityDataFactory = contentDeliveryCacheEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
        this.bannerCacheEntityDataFactory = bannerCacheEntityDataFactory;
        this.mapper = spaceResultMapper;
        this.promoEntityDataFactory = promoEntityDataFactory;
        this.sendMoneyDataFactory = sendMoneyDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.generalEntityDataFactory = generalEntityDataFactory;
        this.bannerEntityDataFactory = bannerEntityDataFactory;
        this.bannerListEntityMapper = bannerListEntityMapper;
        this.bannerPreferencesEntityData = new GeneralPreferencesCacheEntityData(bannerCacheEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<BannerCollection> getHomePromotionBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(getHomeBannerDefaultContent().timeout(5L, TimeUnit.SECONDS)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1662xa029c1ae((BannerListEntity) obj);
            }
        }).startWith((ObservableSource) this.bannerPreferencesEntityData.getObject(CacheKey.HOME.CDP_BANNER, BannerListEntity.class));
        BannerListEntityMapper bannerListEntityMapper = this.bannerListEntityMapper;
        Objects.requireNonNull(bannerListEntityMapper);
        return startWith.map(new PromotionEntityRepository$$ExternalSyntheticLambda1(bannerListEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomePromotionBanner$0$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1662xa029c1ae(BannerListEntity bannerListEntity) throws Exception {
        this.bannerPreferencesEntityData.saveData(CacheKey.HOME.CDP_BANNER, bannerListEntity);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<BannerCollection> getInterstitialPromotionBanner() {
        Observable flatMap = getInterstitialBanner().map(checkGapAndResetTime(createSplitEntityData().getInterstitialBannerConfig().blockingFirst())).flatMap(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1668x6e5a0704((BannerListEntity) obj);
            }
        });
        BannerListEntityMapper bannerListEntityMapper = this.bannerListEntityMapper;
        Objects.requireNonNull(bannerListEntityMapper);
        return flatMap.map(new PromotionEntityRepository$$ExternalSyntheticLambda1(bannerListEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getInterstitialPromotionBanner$3$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1668x6e5a0704(final BannerListEntity bannerListEntity) throws Exception {
        Single list = Observable.fromIterable(bannerListEntity.getContents()).filter(new Predicate() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return PromotionEntityRepository.this.m1667xf96ec602((BannerEntity) obj);
            }
        }).toList();
        Function function = new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.lambda$getInterstitialPromotionBanner$2(BannerListEntity.this, (List) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMapObservable(list, function));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getInterstitialPromotionBanner$1$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ boolean m1667xf96ec602(BannerEntity bannerEntity) throws Exception {
        return !createGeneralEntityData().checkReadInterstitialBanner(bannerEntity.getContentId()).blockingSingle().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getInterstitialPromotionBanner$2(BannerListEntity bannerListEntity, List list) throws Exception {
        bannerListEntity.setContents(list);
        return Observable.just(bannerListEntity);
    }

    private Observable<BannerListEntity> getInterstitialBanner() {
        return createSplitEntityData().getBannerConfig().flatMap(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1666x37639f6c((BannerConfigResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getInterstitialBanner$4$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1666x37639f6c(BannerConfigResult bannerConfigResult) throws Exception {
        if (bannerConfigResult != null && bannerConfigResult.isHomeInterstitialEnabled()) {
            return getBannerFromBannerManagement(BannerPlacement.INTERSTITIAL_BANNER);
        }
        return getBannerFromCdp(SpaceCode.INTERSTITIAL_BANNER);
    }

    private ObservableSource<BannerListEntity> getBannerFromCdp(String str) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<SpaceRpcResult> observable = createContentDelivery().get(str);
        final BannerListEntityMapper bannerListEntityMapper = this.bannerListEntityMapper;
        Objects.requireNonNull(bannerListEntityMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(observable.map(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BannerListEntityMapper.this.transformToBannerListEntity((SpaceRpcResult) obj);
            }
        }));
    }

    private ObservableSource<BannerListEntity> getHomeBannerFromBannerManagement() {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<BannerListEntityResponse> allBanner = this.bannerEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getAllBanner(BannerPlacement.HOME_BANNER.getType(), 1, 5);
        BannerListEntityMapper bannerListEntityMapper = this.bannerListEntityMapper;
        Objects.requireNonNull(bannerListEntityMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(allBanner.map(new PromotionEntityRepository$$ExternalSyntheticLambda12(bannerListEntityMapper)));
    }

    private ObservableSource<BannerListEntity> getBannerFromBannerManagement(BannerPlacement bannerPlacement) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<BannerListEntityResponse> allBanner = this.bannerEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getAllBanner(bannerPlacement.getType(), 1, 5);
        BannerListEntityMapper bannerListEntityMapper = this.bannerListEntityMapper;
        Objects.requireNonNull(bannerListEntityMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(allBanner.map(new PromotionEntityRepository$$ExternalSyntheticLambda12(bannerListEntityMapper)));
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Boolean> readInterstitialPromotionBanner(String str) {
        return createGeneralEntityData().setReadInterstitialBanner(str).map(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean bool;
                String str2 = (String) obj;
                bool = Boolean.TRUE;
                return bool;
            }
        });
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getLeaderboardEntryBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.LEADERBOARD_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1669x795d4737((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_LEADERBOARD, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getLeaderboardEntryBanner$6$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1669x795d4737(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_LEADERBOARD, spaceRpcResult);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getReferralTrackerEmptyPlaceholder() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.REFERRAL_TRACKER_EMPTY_PLACEHOLDER));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return authenticatedRequest.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Boolean> saveInterstitialBannerGapTime(Long l) {
        return createGeneralEntityData().saveInterstitialBannerNextGapTime(l.longValue());
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Boolean> saveInterstitialBannerResetTime(Long l) {
        return createGeneralEntityData().saveInterstitialBannerNextResetTime(l.longValue());
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getPromoClaimBannerConfiguration() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.PROMO_CLAIM_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1670xa48b862((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_PROMO_CLAIM, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPromoClaimBannerConfiguration$7$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1670xa48b862(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_PROMO_CLAIM, spaceRpcResult);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getHomeReferralP2PEntryBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.HOME_REFERRAL_P2P_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1664x2251f344((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_HOME_REFERRAL_P2P, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeReferralP2PEntryBanner$8$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1664x2251f344(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_HOME_REFERRAL_P2P, spaceRpcResult);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getHomeReferralEntryBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.HOME_REFERRAL_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1663x2ccd369((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_HOME_REFERRAL, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeReferralEntryBanner$9$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1663x2ccd369(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_HOME_REFERRAL, spaceRpcResult);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Space> getHomeShoppingBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.HOME_SHOPPING_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromotionEntityRepository.this.m1665xd4718742((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_HOME_SHOPPING_BANNER, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.mapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeShoppingBanner$10$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1665xd4718742(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_HOME_SHOPPING_BANNER, spaceRpcResult);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Observable<Integer> getFreeTransferCount(String str) {
        return getFreeTransferCountFromNetwork(str);
    }

    @Override // id.dana.domain.promotion.repository.PromotionRepository
    public Completable decrementFreeTransferCount(String str) {
        return getLocalPromoDataEntity().decrementFreeTransferCount(str);
    }

    private Observable<BannerListEntity> getHomeBannerDefaultContent() {
        return createSplitEntityData().getHomeBannerDefaultContent().map(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1661xd4352d33((List) obj);
            }
        }).onErrorResumeNext(getHomeBanner());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeBannerDefaultContent$11$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ BannerListEntity m1661xd4352d33(List list) throws Exception {
        if (list.isEmpty()) {
            throw NoHomeBannerSplitException.INSTANCE.getNEW_INSTANCE();
        }
        List<BannerEntity> convertJsonStringToListOfSpaceRpcResult = convertJsonStringToListOfSpaceRpcResult(list);
        BannerListEntity bannerListEntity = new BannerListEntity();
        bannerListEntity.setContents(convertJsonStringToListOfSpaceRpcResult);
        return bannerListEntity;
    }

    private ObservableSource<BannerListEntity> getHomeBanner() {
        return createSplitEntityData().getBannerConfig().flatMap(new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1660x7afcb0cc((BannerConfigResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeBanner$12$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1660x7afcb0cc(BannerConfigResult bannerConfigResult) throws Exception {
        if (bannerConfigResult != null && bannerConfigResult.isHomeBannerEnabled()) {
            return getBannerFromBannerManagement(BannerPlacement.HOME_BANNER);
        }
        return getBannerFromCdp(SpaceCode.HOME_PROMO_BANNER);
    }

    private List<BannerEntity> convertJsonStringToListOfSpaceRpcResult(List<JSONObject> list) {
        return (List) JSONExtKt.PlaceComponentResult().fromJson(list.toString(), new TypeToken<List<BannerEntity>>() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository.1
        }.getType());
    }

    private PromoEntityData getLocalPromoDataEntity() {
        return this.promoEntityDataFactory.createData2("local");
    }

    private GeneralEntityData createGeneralEntityData() {
        return this.generalEntityDataFactory.createData2("local");
    }

    private Observable<Integer> getFreeTransferCountFromNetwork(String str) {
        TransferInitRequest transferInitRequest = new TransferInitRequest();
        transferInitRequest.setNeedTransferMethod(true);
        return getSendMoneyNetworkEntityData().bizInit(transferInitRequest).flatMap(saveMonthOfFreeTransferCheck()).map(getFreeBankTransferCount(str)).flatMap(saveFreeTransferCountFromBackend(str));
    }

    private SendMoneyEntityData getSendMoneyNetworkEntityData() {
        return this.sendMoneyDataFactory.createData2("network");
    }

    private Function<BizTransferInitResult, ObservableSource<BizTransferInitResult>> saveMonthOfFreeTransferCheck() {
        return new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1672xad00ee9d((BizTransferInitResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveMonthOfFreeTransferCheck$13$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1672xad00ee9d(BizTransferInitResult bizTransferInitResult) throws Exception {
        Completable saveMonthOfFetchFreeTransfer = getLocalPromoDataEntity().saveMonthOfFetchFreeTransfer(Integer.valueOf(Calendar.getInstance().get(2)));
        Observable just = Observable.just(bizTransferInitResult);
        ObjectHelper.PlaceComponentResult(just, "next is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new CompletableAndThenObservable(saveMonthOfFetchFreeTransfer, just));
    }

    private Function<BizTransferInitResult, Integer> getFreeBankTransferCount(final String str) {
        return new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((BizTransferInitResult) obj).getFreeBankTransferCount(str));
                return valueOf;
            }
        };
    }

    private Function<Integer, ObservableSource<Integer>> saveFreeTransferCountFromBackend(final String str) {
        return new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1671xc815f727(str, (Integer) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveFreeTransferCountFromBackend$15$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1671xc815f727(String str, Integer num) throws Exception {
        Completable freeTransferCount = getLocalPromoDataEntity().setFreeTransferCount(str, num.intValue());
        Observable just = Observable.just(num);
        ObjectHelper.PlaceComponentResult(just, "next is null");
        return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new CompletableAndThenObservable(freeTransferCount, just));
    }

    private Function<BannerListEntity, BannerListEntity> checkGapAndResetTime(final InterstitialBannerConfigResult interstitialBannerConfigResult) {
        return new Function() { // from class: id.dana.data.promotion.repository.PromotionEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PromotionEntityRepository.this.m1659x43694ae4(interstitialBannerConfigResult, (BannerListEntity) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkGapAndResetTime$16$id-dana-data-promotion-repository-PromotionEntityRepository  reason: not valid java name */
    public /* synthetic */ BannerListEntity m1659x43694ae4(InterstitialBannerConfigResult interstitialBannerConfigResult, BannerListEntity bannerListEntity) throws Exception {
        if (!createGeneralEntityData().checkShouldShowInterstitialBanner(interstitialBannerConfigResult.getGapTime()).blockingSingle().booleanValue()) {
            bannerListEntity.setContents(new ArrayList());
        } else {
            createGeneralEntityData().checkResetInterstitialBannerReadList(interstitialBannerConfigResult.getResetTime()).blockingSingle();
        }
        return bannerListEntity;
    }

    private ConfigEntityData createSplitEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }

    private ContentDeliveryEntityData createContentDelivery() {
        return this.contentDeliveryEntityDataFactory.createData2("network");
    }

    private CacheEntityData<SpaceRpcResult> createCacheContentDelivery() {
        return this.contentDeliveryCacheEntityDataFactory.createData2("local");
    }
}

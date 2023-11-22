package id.dana.data.promocenter;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipay.mobile.map.model.MapConstant;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.promocenter.mapper.CategorizedPromoEntityMapper;
import id.dana.data.promocenter.mapper.CategoryEntityMapper;
import id.dana.data.promocenter.mapper.PromoEntityMapper;
import id.dana.data.promocenter.repository.PromoCenterEntityData;
import id.dana.data.promocenter.repository.PromoCenterEntityDataFactory;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterAdsQueryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategorizedResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterCategoryResult;
import id.dana.data.promocenter.repository.source.network.result.PromoCenterFetchResult;
import id.dana.domain.promocenter.model.CategoryPromo;
import id.dana.domain.promocenter.model.PromoAds;
import id.dana.domain.promocenter.model.PromoCategoryInfo;
import id.dana.domain.promocenter.model.PromoCategoryRequest;
import id.dana.domain.promocenter.model.PromoResult;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.domain.util.LocationUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB9\b\u0001\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010U\u001a\u00020T¢\u0006\u0004\b_\u0010`J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#J5\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00042\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010,JU\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010-\u001a\u00020(2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b3\u00104JE\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010-\u001a\u00020(2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b5\u00106J5\u00108\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010$\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e2\u0006\u00107\u001a\u00020.2\u0006\u00101\u001a\u00020\u001eH\u0002¢\u0006\u0004\b8\u00109J\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u00042\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b=\u0010>J/\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\bC\u0010DJ\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020.0\u00042\u0006\u0010-\u001a\u00020(H\u0002¢\u0006\u0004\bE\u0010FJ/\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00042\u0006\u0010-\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\bG\u0010HJ-\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010-\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002¢\u0006\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020(0\u00048G¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020Y8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b]\u0010^"}, d2 = {"Lid/dana/data/promocenter/PromoCenterEntityRepository;", "Lid/dana/domain/promocenter/repository/PromoCenterRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "Lid/dana/data/promocenter/repository/PromoCenterEntityData;", "createLocalPromoCenterEntityData", "()Lid/dana/data/promocenter/repository/PromoCenterEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "createNetworkPromoCenterEntityData", "", "loadMore", "Lid/dana/data/promocenter/repository/source/network/result/PromoCenterCategoryResult;", "getCachedCategories", "(Z)Lid/dana/data/promocenter/repository/source/network/result/PromoCenterCategoryResult;", "", SecurityConstants.KEY_PAGE_SIZE, ZdocRecordService.PAGE_NUMBER, "Lid/dana/domain/promocenter/model/PromoCategoryInfo;", "getCategories", "(IIZ)Lio/reactivex/Observable;", GriverMonitorConstants.KEY_SIZE, "", "lat", MapConstant.EXTRA_LON, "", "source", "Lid/dana/domain/promocenter/model/PromoAds;", "getPromoAds", "(IDDLjava/lang/String;)Lio/reactivex/Observable;", "phoneNumber", "Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;", "lastCoordinate", "page", "minRadius", "Lid/dana/data/promocenter/repository/source/network/result/PromoCenterAdsQueryResult;", "getPromoAdsObservableBasedOnDistanceThreshold", "(Ljava/lang/String;Lid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;IDDIILjava/lang/String;)Lio/reactivex/Observable;", "getPromoAdsWithComparedCoordinate", "(Ljava/lang/String;IIDDLjava/lang/String;)Lio/reactivex/Observable;", "userCoordinateEntityData", "getPromoAdsWithGivenCoordinate", "(IILid/dana/data/promocenter/repository/source/local/model/UserCoordinateEntityData;I)Lio/reactivex/Observable;", "Lid/dana/domain/promocenter/model/PromoCategoryRequest;", "request", "Lid/dana/domain/promocenter/model/CategoryPromo;", "getPromoCategorizedList", "(Lid/dana/domain/promocenter/model/PromoCategoryRequest;)Lio/reactivex/Observable;", "sortBy", "Lid/dana/domain/promocenter/model/PromoResult;", "getPromoList", "(IILjava/lang/String;)Lio/reactivex/Observable;", "getUserCurrentAdsPageNumber", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getUserLastSavedCoordinate", "(Ljava/lang/String;)Lio/reactivex/Observable;", "saveAdsPageNumber", "(Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/Observable;", "saveUserLastSavedCoordinate", "(Ljava/lang/String;DD)Lio/reactivex/Observable;", "Lid/dana/data/promocenter/mapper/CategorizedPromoEntityMapper;", "categorizedPromoEntityMapper", "Lid/dana/data/promocenter/mapper/CategorizedPromoEntityMapper;", "Lid/dana/data/promocenter/mapper/CategoryEntityMapper;", "categoryEntityMapper", "Lid/dana/data/promocenter/mapper/CategoryEntityMapper;", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "featureConfigEntityRepository", "Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getPhoneNumber", "()Lio/reactivex/Observable;", "Lid/dana/data/promocenter/repository/PromoCenterEntityDataFactory;", "promoCenterEntityDataFactory", "Lid/dana/data/promocenter/repository/PromoCenterEntityDataFactory;", "Lid/dana/data/promocenter/mapper/PromoEntityMapper;", "promoEntityMapper", "Lid/dana/data/promocenter/mapper/PromoEntityMapper;", "<init>", "(Lid/dana/data/promocenter/repository/PromoCenterEntityDataFactory;Lid/dana/data/config/repository/FeatureConfigEntityRepository;Lid/dana/data/promocenter/mapper/CategorizedPromoEntityMapper;Lid/dana/data/promocenter/mapper/CategoryEntityMapper;Lid/dana/data/promocenter/mapper/PromoEntityMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoCenterEntityRepository implements PromoCenterRepository, HoldLoginV1Repository {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CategorizedPromoEntityMapper categorizedPromoEntityMapper;
    private final CategoryEntityMapper categoryEntityMapper;
    private final FeatureConfigEntityRepository featureConfigEntityRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PromoCenterEntityDataFactory promoCenterEntityDataFactory;
    private final PromoEntityMapper promoEntityMapper;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public PromoCenterEntityRepository(PromoCenterEntityDataFactory promoCenterEntityDataFactory, FeatureConfigEntityRepository featureConfigEntityRepository, CategorizedPromoEntityMapper categorizedPromoEntityMapper, CategoryEntityMapper categoryEntityMapper, PromoEntityMapper promoEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(promoCenterEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(categorizedPromoEntityMapper, "");
        Intrinsics.checkNotNullParameter(categoryEntityMapper, "");
        Intrinsics.checkNotNullParameter(promoEntityMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.promoCenterEntityDataFactory = promoCenterEntityDataFactory;
        this.featureConfigEntityRepository = featureConfigEntityRepository;
        this.categorizedPromoEntityMapper = categorizedPromoEntityMapper;
        this.categoryEntityMapper = categoryEntityMapper;
        this.promoEntityMapper = promoEntityMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.promocenter.repository.PromoCenterRepository
    public final Observable<PromoCategoryInfo> getCategories(int pageSize, int pageNumber, final boolean loadMore) {
        Observable<PromoCenterCategoryResult> categories = createNetworkPromoCenterEntityData().getCategories(pageSize, pageNumber);
        Intrinsics.checkNotNullExpressionValue(categories, "");
        Observable<PromoCategoryInfo> map = authenticatedRequest(categories).doOnNext(new Consumer() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromoCenterEntityRepository.m1613getCategories$lambda0(PromoCenterEntityRepository.this, (PromoCenterCategoryResult) obj);
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoCenterCategoryResult m1614getCategories$lambda1;
                m1614getCategories$lambda1 = PromoCenterEntityRepository.m1614getCategories$lambda1(PromoCenterEntityRepository.this, loadMore, (Throwable) obj);
                return m1614getCategories$lambda1;
            }
        }).map(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoCategoryInfo m1615getCategories$lambda2;
                m1615getCategories$lambda2 = PromoCenterEntityRepository.m1615getCategories$lambda2(PromoCenterEntityRepository.this, (PromoCenterCategoryResult) obj);
                return m1615getCategories$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategories$lambda-0  reason: not valid java name */
    public static final void m1613getCategories$lambda0(PromoCenterEntityRepository promoCenterEntityRepository, PromoCenterCategoryResult promoCenterCategoryResult) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        promoCenterEntityRepository.createLocalPromoCenterEntityData().saveCategories(promoCenterCategoryResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategories$lambda-1  reason: not valid java name */
    public static final PromoCenterCategoryResult m1614getCategories$lambda1(PromoCenterEntityRepository promoCenterEntityRepository, boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        return promoCenterEntityRepository.getCachedCategories(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCategories$lambda-2  reason: not valid java name */
    public static final PromoCategoryInfo m1615getCategories$lambda2(PromoCenterEntityRepository promoCenterEntityRepository, PromoCenterCategoryResult promoCenterCategoryResult) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(promoCenterCategoryResult, "");
        return promoCenterEntityRepository.categoryEntityMapper.apply(promoCenterCategoryResult);
    }

    @Override // id.dana.domain.promocenter.repository.PromoCenterRepository
    public final Observable<PromoResult> getPromoList(int pageSize, int pageNumber, String sortBy) {
        Observable<PromoCenterFetchResult> queryAllPromo = createNetworkPromoCenterEntityData().queryAllPromo(pageSize, pageNumber, sortBy);
        Intrinsics.checkNotNullExpressionValue(queryAllPromo, "");
        Observable<PromoResult> map = authenticatedRequest(queryAllPromo).map(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoResult m1627getPromoList$lambda3;
                m1627getPromoList$lambda3 = PromoCenterEntityRepository.m1627getPromoList$lambda3(PromoCenterEntityRepository.this, (PromoCenterFetchResult) obj);
                return m1627getPromoList$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoList$lambda-3  reason: not valid java name */
    public static final PromoResult m1627getPromoList$lambda3(PromoCenterEntityRepository promoCenterEntityRepository, PromoCenterFetchResult promoCenterFetchResult) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(promoCenterFetchResult, "");
        return promoCenterEntityRepository.promoEntityMapper.apply(promoCenterFetchResult);
    }

    @Override // id.dana.domain.promocenter.repository.PromoCenterRepository
    public final Observable<CategoryPromo> getPromoCategorizedList(PromoCategoryRequest request) {
        Intrinsics.checkNotNullParameter(request, "");
        Observable<PromoCenterCategorizedResult> queryCategorizedPromo = createNetworkPromoCenterEntityData().queryCategorizedPromo(request.getCategories(), request.getPageSize(), request.getPageNumber(), request.getSortBy(), request.getFilters(), request.getLat(), request.getLon());
        Intrinsics.checkNotNullExpressionValue(queryCategorizedPromo, "");
        Observable<CategoryPromo> map = authenticatedRequest(queryCategorizedPromo).map(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CategoryPromo m1626getPromoCategorizedList$lambda4;
                m1626getPromoCategorizedList$lambda4 = PromoCenterEntityRepository.m1626getPromoCategorizedList$lambda4(PromoCenterEntityRepository.this, (PromoCenterCategorizedResult) obj);
                return m1626getPromoCategorizedList$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoCategorizedList$lambda-4  reason: not valid java name */
    public static final CategoryPromo m1626getPromoCategorizedList$lambda4(PromoCenterEntityRepository promoCenterEntityRepository, PromoCenterCategorizedResult promoCenterCategorizedResult) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(promoCenterCategorizedResult, "");
        return promoCenterEntityRepository.categorizedPromoEntityMapper.apply(promoCenterCategorizedResult);
    }

    @Override // id.dana.domain.promocenter.repository.PromoCenterRepository
    public final Observable<PromoAds> getPromoAds(final int size, final double lat, final double lon, final String source) {
        Intrinsics.checkNotNullParameter(source, "");
        Observable<PromoAds> map = Observable.zip(getPhoneNumber(), this.featureConfigEntityRepository.getMinimumRadiusInMeter(), new BiFunction() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair m1616getPromoAds$lambda5;
                m1616getPromoAds$lambda5 = PromoCenterEntityRepository.m1616getPromoAds$lambda5((String) obj, (Integer) obj2);
                return m1616getPromoAds$lambda5;
            }
        }).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1617getPromoAds$lambda6;
                m1617getPromoAds$lambda6 = PromoCenterEntityRepository.m1617getPromoAds$lambda6(PromoCenterEntityRepository.this, size, lat, lon, source, (Pair) obj);
                return m1617getPromoAds$lambda6;
            }
        }).map(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoAds m1618getPromoAds$lambda7;
                m1618getPromoAds$lambda7 = PromoCenterEntityRepository.m1618getPromoAds$lambda7((PromoCenterAdsQueryResult) obj);
                return m1618getPromoAds$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAds$lambda-5  reason: not valid java name */
    public static final Pair m1616getPromoAds$lambda5(String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(num, "");
        return new Pair(str, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAds$lambda-6  reason: not valid java name */
    public static final ObservableSource m1617getPromoAds$lambda6(PromoCenterEntityRepository promoCenterEntityRepository, int i, double d, double d2, String str, Pair pair) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(pair, "");
        String str2 = (String) pair.component1();
        Integer num = (Integer) pair.component2();
        Intrinsics.checkNotNullExpressionValue(str2, "");
        Intrinsics.checkNotNullExpressionValue(num, "");
        return promoCenterEntityRepository.getPromoAdsWithComparedCoordinate(str2, num.intValue(), i, d, d2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAds$lambda-7  reason: not valid java name */
    public static final PromoAds m1618getPromoAds$lambda7(PromoCenterAdsQueryResult promoCenterAdsQueryResult) {
        Intrinsics.checkNotNullParameter(promoCenterAdsQueryResult, "");
        return promoCenterAdsQueryResult.toPromoAds();
    }

    @JvmName(name = "getPhoneNumber")
    public final Observable<String> getPhoneNumber() {
        Observable<String> phoneNumber = createAccountData().getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        return phoneNumber;
    }

    private final Observable<PromoCenterAdsQueryResult> getPromoAdsWithComparedCoordinate(final String phoneNumber, final int minRadius, final int size, final double lat, final double lon, final String source) {
        Observable<PromoCenterAdsQueryResult> switchMap = Observable.zip(getUserLastSavedCoordinate(phoneNumber), getUserCurrentAdsPageNumber(phoneNumber, source), new BiFunction() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair m1624getPromoAdsWithComparedCoordinate$lambda8;
                m1624getPromoAdsWithComparedCoordinate$lambda8 = PromoCenterEntityRepository.m1624getPromoAdsWithComparedCoordinate$lambda8((UserCoordinateEntityData) obj, (Integer) obj2);
                return m1624getPromoAdsWithComparedCoordinate$lambda8;
            }
        }).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1625getPromoAdsWithComparedCoordinate$lambda9;
                m1625getPromoAdsWithComparedCoordinate$lambda9 = PromoCenterEntityRepository.m1625getPromoAdsWithComparedCoordinate$lambda9(PromoCenterEntityRepository.this, phoneNumber, lat, lon, minRadius, size, source, (Pair) obj);
                return m1625getPromoAdsWithComparedCoordinate$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsWithComparedCoordinate$lambda-8  reason: not valid java name */
    public static final Pair m1624getPromoAdsWithComparedCoordinate$lambda8(UserCoordinateEntityData userCoordinateEntityData, Integer num) {
        Intrinsics.checkNotNullParameter(userCoordinateEntityData, "");
        Intrinsics.checkNotNullParameter(num, "");
        return new Pair(userCoordinateEntityData, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsWithComparedCoordinate$lambda-9  reason: not valid java name */
    public static final ObservableSource m1625getPromoAdsWithComparedCoordinate$lambda9(PromoCenterEntityRepository promoCenterEntityRepository, String str, double d, double d2, int i, int i2, String str2, Pair pair) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(pair, "");
        UserCoordinateEntityData userCoordinateEntityData = (UserCoordinateEntityData) pair.component1();
        Integer num = (Integer) pair.component2();
        Intrinsics.checkNotNullExpressionValue(userCoordinateEntityData, "");
        Intrinsics.checkNotNullExpressionValue(num, "");
        return promoCenterEntityRepository.getPromoAdsObservableBasedOnDistanceThreshold(str, userCoordinateEntityData, num.intValue(), d, d2, i, i2, str2);
    }

    private final Observable<UserCoordinateEntityData> getUserLastSavedCoordinate(String phoneNumber) {
        Observable<UserCoordinateEntityData> userLastCoordinate = createLocalPromoCenterEntityData().getUserLastCoordinate(phoneNumber);
        Intrinsics.checkNotNullExpressionValue(userLastCoordinate, "");
        return userLastCoordinate;
    }

    private final Observable<Integer> getUserCurrentAdsPageNumber(String phoneNumber, String source) {
        Observable<Integer> currentAdsPageNumber = createLocalPromoCenterEntityData().getCurrentAdsPageNumber(phoneNumber, source);
        Intrinsics.checkNotNullExpressionValue(currentAdsPageNumber, "");
        return currentAdsPageNumber;
    }

    private final Observable<PromoCenterAdsQueryResult> getPromoAdsObservableBasedOnDistanceThreshold(final String phoneNumber, UserCoordinateEntityData lastCoordinate, int page, final double lat, final double lon, final int minRadius, final int size, final String source) {
        if (INSTANCE.isDistanceExceedMinimum(minRadius, LocationUtil.getDistance(lastCoordinate.getLat(), lastCoordinate.getLon(), lat, lon))) {
            Observable<PromoCenterAdsQueryResult> switchMap = saveUserLastSavedCoordinate(phoneNumber, lat, lon).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m1619getPromoAdsObservableBasedOnDistanceThreshold$lambda10;
                    m1619getPromoAdsObservableBasedOnDistanceThreshold$lambda10 = PromoCenterEntityRepository.m1619getPromoAdsObservableBasedOnDistanceThreshold$lambda10(PromoCenterEntityRepository.this, phoneNumber, source, (Boolean) obj);
                    return m1619getPromoAdsObservableBasedOnDistanceThreshold$lambda10;
                }
            }).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m1620getPromoAdsObservableBasedOnDistanceThreshold$lambda11;
                    m1620getPromoAdsObservableBasedOnDistanceThreshold$lambda11 = PromoCenterEntityRepository.m1620getPromoAdsObservableBasedOnDistanceThreshold$lambda11(source, this, phoneNumber, (Boolean) obj);
                    return m1620getPromoAdsObservableBasedOnDistanceThreshold$lambda11;
                }
            }).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m1621getPromoAdsObservableBasedOnDistanceThreshold$lambda12;
                    m1621getPromoAdsObservableBasedOnDistanceThreshold$lambda12 = PromoCenterEntityRepository.m1621getPromoAdsObservableBasedOnDistanceThreshold$lambda12(PromoCenterEntityRepository.this, size, lat, lon, minRadius, (Boolean) obj);
                    return m1621getPromoAdsObservableBasedOnDistanceThreshold$lambda12;
                }
            });
            Intrinsics.checkNotNullExpressionValue(switchMap, "");
            return switchMap;
        }
        final int i = page + 1;
        Observable switchMap2 = getPromoAdsWithGivenCoordinate(size, i, lastCoordinate, minRadius).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1622getPromoAdsObservableBasedOnDistanceThreshold$lambda14;
                m1622getPromoAdsObservableBasedOnDistanceThreshold$lambda14 = PromoCenterEntityRepository.m1622getPromoAdsObservableBasedOnDistanceThreshold$lambda14(PromoCenterEntityRepository.this, phoneNumber, i, source, (PromoCenterAdsQueryResult) obj);
                return m1622getPromoAdsObservableBasedOnDistanceThreshold$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap2, "");
        return switchMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsObservableBasedOnDistanceThreshold$lambda-10  reason: not valid java name */
    public static final ObservableSource m1619getPromoAdsObservableBasedOnDistanceThreshold$lambda10(PromoCenterEntityRepository promoCenterEntityRepository, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return promoCenterEntityRepository.saveAdsPageNumber(str, 1, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsObservableBasedOnDistanceThreshold$lambda-11  reason: not valid java name */
    public static final ObservableSource m1620getPromoAdsObservableBasedOnDistanceThreshold$lambda11(String str, PromoCenterEntityRepository promoCenterEntityRepository, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return promoCenterEntityRepository.saveAdsPageNumber(str2, 0, str.length() == 0 ? PromoCenterSource.PROMO_CENTER_EXPLORE_PAGE : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsObservableBasedOnDistanceThreshold$lambda-12  reason: not valid java name */
    public static final ObservableSource m1621getPromoAdsObservableBasedOnDistanceThreshold$lambda12(PromoCenterEntityRepository promoCenterEntityRepository, int i, double d, double d2, int i2, Boolean bool) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return promoCenterEntityRepository.getPromoAdsWithGivenCoordinate(i, 1, new UserCoordinateEntityData(d, d2), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsObservableBasedOnDistanceThreshold$lambda-14  reason: not valid java name */
    public static final ObservableSource m1622getPromoAdsObservableBasedOnDistanceThreshold$lambda14(PromoCenterEntityRepository promoCenterEntityRepository, String str, int i, String str2, final PromoCenterAdsQueryResult promoCenterAdsQueryResult) {
        Intrinsics.checkNotNullParameter(promoCenterEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(promoCenterAdsQueryResult, "");
        if (promoCenterAdsQueryResult.getHasMore() || !promoCenterAdsQueryResult.getListOfAdsPromo().isEmpty()) {
            return promoCenterEntityRepository.saveAdsPageNumber(str, i, str2).switchMap(new Function() { // from class: id.dana.data.promocenter.PromoCenterEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m1623xdad215c7;
                    m1623xdad215c7 = PromoCenterEntityRepository.m1623xdad215c7(PromoCenterAdsQueryResult.this, (Boolean) obj);
                    return m1623xdad215c7;
                }
            });
        }
        return Observable.just(promoCenterAdsQueryResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoAdsObservableBasedOnDistanceThreshold$lambda-14$lambda-13  reason: not valid java name */
    public static final ObservableSource m1623xdad215c7(PromoCenterAdsQueryResult promoCenterAdsQueryResult, Boolean bool) {
        Intrinsics.checkNotNullParameter(promoCenterAdsQueryResult, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return Observable.just(promoCenterAdsQueryResult);
    }

    private final Observable<Boolean> saveUserLastSavedCoordinate(String phoneNumber, double lat, double lon) {
        Observable<Boolean> saveUserLastCoordinate = createLocalPromoCenterEntityData().saveUserLastCoordinate(phoneNumber, new UserCoordinateEntityData(lat, lon));
        Intrinsics.checkNotNullExpressionValue(saveUserLastCoordinate, "");
        return saveUserLastCoordinate;
    }

    private final Observable<Boolean> saveAdsPageNumber(String phoneNumber, int pageNumber, String source) {
        Observable<Boolean> saveCurrentAdsPageNumber = createLocalPromoCenterEntityData().saveCurrentAdsPageNumber(phoneNumber, pageNumber, source);
        Intrinsics.checkNotNullExpressionValue(saveCurrentAdsPageNumber, "");
        return saveCurrentAdsPageNumber;
    }

    private final Observable<PromoCenterAdsQueryResult> getPromoAdsWithGivenCoordinate(int size, int page, UserCoordinateEntityData userCoordinateEntityData, int minRadius) {
        Observable<PromoCenterAdsQueryResult> promoAds = createNetworkPromoCenterEntityData().getPromoAds(size, page, userCoordinateEntityData.getLat(), userCoordinateEntityData.getLon(), minRadius);
        Intrinsics.checkNotNullExpressionValue(promoAds, "");
        return authenticatedRequest(promoAds);
    }

    private final PromoCenterEntityData createNetworkPromoCenterEntityData() {
        PromoCenterEntityData createData2 = this.promoCenterEntityDataFactory.createData2("network");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    private final PromoCenterCategoryResult getCachedCategories(boolean loadMore) {
        if (!loadMore) {
            PromoCenterCategoryResult cachedCategories = createLocalPromoCenterEntityData().getCachedCategories();
            Intrinsics.checkNotNullExpressionValue(cachedCategories, "");
            return cachedCategories;
        }
        return new PromoCenterCategoryResult();
    }

    private final PromoCenterEntityData createLocalPromoCenterEntityData() {
        PromoCenterEntityData createData2 = this.promoCenterEntityDataFactory.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/promocenter/PromoCenterEntityRepository$Companion;", "", "", "minimumRadius", "distance", "", "isDistanceExceedMinimum", "(FF)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDistanceExceedMinimum(float minimumRadius, float distance) {
            return distance > minimumRadius;
        }

        private Companion() {
        }
    }
}

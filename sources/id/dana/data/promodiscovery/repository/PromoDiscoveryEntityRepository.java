package id.dana.data.promodiscovery.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.promodiscovery.repository.mapper.PromoDiscoveryEntityMapperKt;
import id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse;
import id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryEntity;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.domain.promodiscovery.model.PromoDiscoverySectionConfig;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bD\u0010EJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0016¢\u0006\u0004\b#\u0010\"JS\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001c0\u00042\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001aH\u0016¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0004H\u0016¢\u0006\u0004\b1\u00102J9\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b5\u00106J%\u00109\u001a\u0002082\u0006\u0010\u001b\u001a\u00020\u001a2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002¢\u0006\u0004\b9\u0010:J#\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00042\u0006\u0010;\u001a\u00020\u001aH\u0016¢\u0006\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C"}, d2 = {"Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityRepository;", "Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "createLocalEntityData", "()Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkEntityData", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "createSplitConfigEntityData", "", "userId", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getFourKingsLocal", "(Ljava/lang/String;)Ljava/util/List;", "fourKingsTypes", "getFourKingsNetwork", "(Ljava/util/List;)Lio/reactivex/Observable;", "getFourKingsPromo", "type", "filterBy", "", "latitude", "longitude", "", "start", SecurityConstants.KEY_PAGE_SIZE, "sortBy", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "getPromoDanaDeals", "(Ljava/lang/String;Ljava/lang/String;DDIILjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/promodiscovery/model/PromoDiscoverySectionConfig;", "getPromoDiscovery", "()Lio/reactivex/Observable;", "previousFourKings", "newFourKings", "setFourKingsDiscoveryUpdatedRedDot", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "fourKingsPromo", "", "setFourKingsLocal", "(Ljava/lang/String;Ljava/util/List;)V", "pillarType", "switchFourKingsPromoRedDot", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityDataFactory;", "promoDiscoveryEntityDataFactory", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityDataFactory;", "<init>", "(Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoDiscoveryEntityRepository implements PromoDiscoveryRepository, HoldLoginV1Repository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PromoDiscoveryEntityDataFactory promoDiscoveryEntityDataFactory;

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
    public PromoDiscoveryEntityRepository(PromoDiscoveryEntityDataFactory promoDiscoveryEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(promoDiscoveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.promoDiscoveryEntityDataFactory = promoDiscoveryEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository
    public final Observable<PromoDiscoverySectionConfig> getPromoDiscovery() {
        Observable map = createSplitConfigEntityData().getPromoDiscoveryConfig().map(new Function() { // from class: id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoDiscoverySectionConfig m1640getPromoDiscovery$lambda0;
                m1640getPromoDiscovery$lambda0 = PromoDiscoveryEntityRepository.m1640getPromoDiscovery$lambda0((PromoDiscoveryEntity) obj);
                return m1640getPromoDiscovery$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoDiscovery$lambda-0  reason: not valid java name */
    public static final PromoDiscoverySectionConfig m1640getPromoDiscovery$lambda0(PromoDiscoveryEntity promoDiscoveryEntity) {
        Intrinsics.checkNotNullParameter(promoDiscoveryEntity, "");
        return PromoDiscoveryEntityMapperKt.toPromoDiscoverySectionConfig(promoDiscoveryEntity);
    }

    @Override // id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository
    public final Observable<List<ProductInfoDiscoveryModel>> getPromoDanaDeals(String type, String filterBy, double latitude, double longitude, int start, int pageSize, String sortBy) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(filterBy, "");
        Intrinsics.checkNotNullParameter(sortBy, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("TYPE", type);
        linkedHashMap.put("FILTER_BY", filterBy);
        linkedHashMap.put("LATITUDE", String.valueOf(latitude));
        linkedHashMap.put("LONGITUDE", String.valueOf(longitude));
        linkedHashMap.put("START", String.valueOf(start));
        linkedHashMap.put("PAGESIZE", String.valueOf(pageSize));
        linkedHashMap.put("SORTING_BY", sortBy);
        Observable map = createNetworkEntityData().getPromoDanaDeals(linkedHashMap).map(new Function() { // from class: id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1639getPromoDanaDeals$lambda2;
                m1639getPromoDanaDeals$lambda2 = PromoDiscoveryEntityRepository.m1639getPromoDanaDeals$lambda2((ProductInfoResponse) obj);
                return m1639getPromoDanaDeals$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPromoDanaDeals$lambda-2  reason: not valid java name */
    public static final List m1639getPromoDanaDeals$lambda2(ProductInfoResponse productInfoResponse) {
        Intrinsics.checkNotNullParameter(productInfoResponse, "");
        return productInfoResponse.toProductInfoList();
    }

    @Override // id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository
    public final Observable<List<FourKingsPromoModel>> getFourKingsPromo(List<String> fourKingsTypes) {
        Intrinsics.checkNotNullParameter(fourKingsTypes, "");
        final String blockingFirst = createAccountData().getUserId().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        final List<FourKingsPromoModel> fourKingsLocal = getFourKingsLocal(blockingFirst);
        Observable<List<FourKingsPromoModel>> onErrorReturnItem = getFourKingsNetwork(fourKingsTypes).doOnNext(new Consumer() { // from class: id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromoDiscoveryEntityRepository.m1637getFourKingsPromo$lambda3(PromoDiscoveryEntityRepository.this, blockingFirst, (List) obj);
            }
        }).map(new Function() { // from class: id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1638getFourKingsPromo$lambda4;
                m1638getFourKingsPromo$lambda4 = PromoDiscoveryEntityRepository.m1638getFourKingsPromo$lambda4(PromoDiscoveryEntityRepository.this, blockingFirst, fourKingsLocal, (List) obj);
                return m1638getFourKingsPromo$lambda4;
            }
        }).onErrorReturnItem(getFourKingsLocal(blockingFirst));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFourKingsPromo$lambda-3  reason: not valid java name */
    public static final void m1637getFourKingsPromo$lambda3(PromoDiscoveryEntityRepository promoDiscoveryEntityRepository, String str, List list) {
        Intrinsics.checkNotNullParameter(promoDiscoveryEntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        Intrinsics.checkNotNullExpressionValue(list, "");
        promoDiscoveryEntityRepository.setFourKingsLocal(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFourKingsPromo$lambda-4  reason: not valid java name */
    public static final List m1638getFourKingsPromo$lambda4(PromoDiscoveryEntityRepository promoDiscoveryEntityRepository, String str, List list, List list2) {
        Intrinsics.checkNotNullParameter(promoDiscoveryEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        return promoDiscoveryEntityRepository.setFourKingsDiscoveryUpdatedRedDot(str, list, list2);
    }

    @Override // id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository
    public final Observable<List<FourKingsPromoModel>> switchFourKingsPromoRedDot(String pillarType) {
        Intrinsics.checkNotNullParameter(pillarType, "");
        String blockingFirst = createAccountData().getUserId().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        List<FourKingsPromoModel> fourKingsLocal = getFourKingsLocal(blockingFirst);
        for (FourKingsPromoModel fourKingsPromoModel : fourKingsLocal) {
            if (Intrinsics.areEqual(fourKingsPromoModel.getPillarType(), pillarType)) {
                fourKingsPromoModel.setNewlyUpdated(false);
            }
        }
        setFourKingsLocal(blockingFirst, fourKingsLocal);
        Observable<List<FourKingsPromoModel>> just = Observable.just(fourKingsLocal);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final List<FourKingsPromoModel> setFourKingsDiscoveryUpdatedRedDot(String userId, List<FourKingsPromoModel> previousFourKings, List<FourKingsPromoModel> newFourKings) {
        Object obj;
        for (FourKingsPromoModel fourKingsPromoModel : newFourKings) {
            Iterator<T> it = previousFourKings.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((FourKingsPromoModel) obj).getPillarType(), fourKingsPromoModel.getPillarType())) {
                    break;
                }
            }
            FourKingsPromoModel fourKingsPromoModel2 = (FourKingsPromoModel) obj;
            if (fourKingsPromoModel2 != null) {
                if (fourKingsPromoModel.getPillarAmount() != 0 && fourKingsPromoModel.getPillarAmount() != fourKingsPromoModel2.getPillarAmount()) {
                    fourKingsPromoModel.setNewlyUpdated(true);
                } else {
                    fourKingsPromoModel.setNewlyUpdated(fourKingsPromoModel2.isNewlyUpdated());
                }
            }
        }
        setFourKingsLocal(userId, newFourKings);
        return newFourKings;
    }

    private final Observable<List<FourKingsPromoModel>> getFourKingsNetwork(List<String> fourKingsTypes) {
        Observable map = createNetworkEntityData().getFourKingsPromo(fourKingsTypes).map(new Function() { // from class: id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1636getFourKingsNetwork$lambda9;
                m1636getFourKingsNetwork$lambda9 = PromoDiscoveryEntityRepository.m1636getFourKingsNetwork$lambda9((PromoFourKingsResponse) obj);
                return m1636getFourKingsNetwork$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFourKingsNetwork$lambda-9  reason: not valid java name */
    public static final List m1636getFourKingsNetwork$lambda9(PromoFourKingsResponse promoFourKingsResponse) {
        Intrinsics.checkNotNullParameter(promoFourKingsResponse, "");
        return promoFourKingsResponse.toListFourKingsPromoModel();
    }

    private final List<FourKingsPromoModel> getFourKingsLocal(String userId) {
        List<FourKingsPromoModel> blockingFirst = createLocalEntityData().getFourKingsLocal(userId).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return blockingFirst;
    }

    private final void setFourKingsLocal(String userId, List<FourKingsPromoModel> fourKingsPromo) {
        createLocalEntityData().setFourKingsLocal(userId, fourKingsPromo);
    }

    private final PromoDiscoveryEntityData createSplitConfigEntityData() {
        return this.promoDiscoveryEntityDataFactory.createData2("split");
    }

    private final PromoDiscoveryEntityData createNetworkEntityData() {
        return this.promoDiscoveryEntityDataFactory.createData2("network");
    }

    private final PromoDiscoveryEntityData createLocalEntityData() {
        return this.promoDiscoveryEntityDataFactory.createData2("local");
    }
}

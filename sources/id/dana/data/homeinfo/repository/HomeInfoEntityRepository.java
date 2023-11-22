package id.dana.data.homeinfo.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.homeinfo.mapper.HomeDataResultMapper;
import id.dana.data.homeinfo.mapper.HomeInfoResultMapper;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.homeinfo.repository.source.HomeEntityData;
import id.dana.data.homeinfo.repository.source.HomeInfoEntityDataFactory;
import id.dana.data.homeinfo.repository.source.network.result.HomeDataResult;
import id.dana.data.homeinfo.repository.source.network.result.HomeInfoResult;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import id.dana.domain.homeinfo.HomeData;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class HomeInfoEntityRepository implements HomeInfoRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final HomeDataResultMapper homeDataResultMapper;
    private final HomeInfoEntityDataFactory homeInfoEntityDataFactory;
    private final HomeInfoResultMapper mapper;
    private final SSLQuakeInterceptor sslQuakeInterceptor;

    @Inject
    public HomeInfoEntityRepository(HomeInfoEntityDataFactory homeInfoEntityDataFactory, HomeInfoResultMapper homeInfoResultMapper, HomeDataResultMapper homeDataResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository, SSLQuakeInterceptor sSLQuakeInterceptor) {
        this.homeInfoEntityDataFactory = homeInfoEntityDataFactory;
        this.mapper = homeInfoResultMapper;
        this.homeDataResultMapper = homeDataResultMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.sslQuakeInterceptor = sSLQuakeInterceptor;
    }

    @Override // id.dana.domain.homeinfo.repository.HomeInfoRepository
    public Observable<HomeInfoResponse> getHomeInfo(final List<String> list) {
        return this.sslQuakeInterceptor.sslWatchRequest(this.holdLoginV1EntityRepository.authenticatedRequest(createHomeInfoData().getHomeInfo()).flatMap(new Function() { // from class: id.dana.data.homeinfo.repository.HomeInfoEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeInfoEntityRepository.this.m1368xaa813ea5(list, (HomeInfoResult) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeInfo$2$id-dana-data-homeinfo-repository-HomeInfoEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1368xaa813ea5(final List list, final HomeInfoResult homeInfoResult) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        if (list == null || list.isEmpty()) {
            return Observable.just(this.mapper.transform(homeInfoResult));
        }
        Single list2 = Observable.fromIterable(homeInfoResult.getThirdPartyLinks()).filter(new Predicate() { // from class: id.dana.data.homeinfo.repository.HomeInfoEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return HomeInfoEntityRepository.this.m1366x8915a523(list, (ThirdPartyEntity) obj);
            }
        }).toList();
        if (list2 instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list2).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.homeinfo.repository.HomeInfoEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeInfoEntityRepository.this.m1367x99cb71e4(homeInfoResult, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHomeInfo$1$id-dana-data-homeinfo-repository-HomeInfoEntityRepository  reason: not valid java name */
    public /* synthetic */ HomeInfoResponse m1367x99cb71e4(HomeInfoResult homeInfoResult, List list) throws Exception {
        homeInfoResult.setThirdPartyLinks(list);
        return this.mapper.transform(homeInfoResult);
    }

    @Override // id.dana.domain.homeinfo.repository.HomeInfoRepository
    public Observable<HomeData> getUpdatedHomeData() {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<HomeDataResult> updatedHomeData = createHomeInfoData().getUpdatedHomeData();
        final HomeDataResultMapper homeDataResultMapper = this.homeDataResultMapper;
        Objects.requireNonNull(homeDataResultMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(updatedHomeData.map(new Function() { // from class: id.dana.data.homeinfo.repository.HomeInfoEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeDataResultMapper.this.apply((HomeDataResult) obj);
            }
        }));
    }

    private HomeEntityData createHomeInfoData() {
        return this.homeInfoEntityDataFactory.createData2("network");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: isThirdPartyOnListed  reason: merged with bridge method [inline-methods] */
    public boolean m1366x8915a523(ThirdPartyEntity thirdPartyEntity, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(thirdPartyEntity.getName())) {
                return true;
            }
        }
        return false;
    }
}

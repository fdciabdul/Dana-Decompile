package id.dana.data.referral.repository;

import android.text.TextUtils;
import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.referral.mapper.MyReferralConsultEntityMapper;
import id.dana.data.referral.repository.source.MyReferralConsultEntityData;
import id.dana.data.referral.repository.source.MyReferralConsultEntityDataFactory;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import id.dana.data.storage.GeneralPreferences;
import id.dana.domain.promotion.Space;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class MyReferralConsultEntityRepository implements MyReferralConsultRepository {
    private final ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory;
    private final ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private final MyReferralConsultEntityDataFactory factory;
    private final GeneralPreferences generalPreferences;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final MyReferralConsultEntityMapper mapper;
    private final SpaceResultMapper spaceResultMapper;

    @Inject
    public MyReferralConsultEntityRepository(MyReferralConsultEntityDataFactory myReferralConsultEntityDataFactory, MyReferralConsultEntityMapper myReferralConsultEntityMapper, GeneralPreferences generalPreferences, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.factory = myReferralConsultEntityDataFactory;
        this.mapper = myReferralConsultEntityMapper;
        this.generalPreferences = generalPreferences;
        this.contentDeliveryCacheEntityDataFactory = contentDeliveryCacheEntityDataFactory;
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.spaceResultMapper = spaceResultMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.referral.MyReferralConsultRepository
    public Observable<MyReferralConsultRpcResponse> getReferralConsult() {
        Observable<MyReferralConsultEntityResult> myReferralConsult = getMyReferralConsult();
        MyReferralConsultEntityMapper myReferralConsultEntityMapper = this.mapper;
        Objects.requireNonNull(myReferralConsultEntityMapper);
        return myReferralConsult.map(new MyReferralConsultEntityRepository$$ExternalSyntheticLambda2(myReferralConsultEntityMapper));
    }

    @Override // id.dana.domain.referral.MyReferralConsultRepository
    public Observable<String> getReferralCode() {
        return createLocalMyReferralEntityData().getReferralCode().onErrorResumeNext(defaultIfReferralCodeNull());
    }

    @Override // id.dana.domain.referral.MyReferralConsultRepository
    public Observable<Boolean> saveLastSeenReferralCampaignId(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MyReferralConsultEntityRepository.this.m1779x6bb7d5ea(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveLastSeenReferralCampaignId$0$id-dana-data-referral-repository-MyReferralConsultEntityRepository  reason: not valid java name */
    public /* synthetic */ Boolean m1779x6bb7d5ea(String str) throws Exception {
        return this.generalPreferences.saveLatestSeenReferralCampaign(str);
    }

    @Override // id.dana.domain.referral.MyReferralConsultRepository
    public Observable<MyReferralConsultRpcResponse> getLatestReferralCampaign() {
        Observable<R> flatMap = getMyReferralConsult().flatMap(new Function() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyReferralConsultEntityRepository.this.m1777x479a3a6f((MyReferralConsultEntityResult) obj);
            }
        });
        MyReferralConsultEntityMapper myReferralConsultEntityMapper = this.mapper;
        Objects.requireNonNull(myReferralConsultEntityMapper);
        return flatMap.map(new MyReferralConsultEntityRepository$$ExternalSyntheticLambda2(myReferralConsultEntityMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getLatestReferralCampaign$1$id-dana-data-referral-repository-MyReferralConsultEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1777x479a3a6f(MyReferralConsultEntityResult myReferralConsultEntityResult) throws Exception {
        myReferralConsultEntityResult.setCampaignUpdated(isCampaignUpdated(myReferralConsultEntityResult.getReferrerCampaignInfo().getActivityId()));
        return Observable.just(myReferralConsultEntityResult);
    }

    @Override // id.dana.domain.referral.MyReferralConsultRepository
    public Observable<Space> getReferralBanner() {
        Observable startWith = this.holdLoginV1EntityRepository.authenticatedRequest(createContentDelivery().get(SpaceCode.REFERRAL_BANNER)).doOnNext(new Consumer() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyReferralConsultEntityRepository.this.m1778xfe247b39((SpaceRpcResult) obj);
            }
        }).startWith((ObservableSource) createCacheContentDelivery().getObject(CacheKey.HOME.CDP_REFERRAL_BANNER, SpaceRpcResult.class));
        SpaceResultMapper spaceResultMapper = this.spaceResultMapper;
        Objects.requireNonNull(spaceResultMapper);
        return startWith.map(new CashierEntityRepository$$ExternalSyntheticLambda10(spaceResultMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralBanner$2$id-dana-data-referral-repository-MyReferralConsultEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1778xfe247b39(SpaceRpcResult spaceRpcResult) throws Exception {
        createCacheContentDelivery().saveData(CacheKey.HOME.CDP_REFERRAL_BANNER, spaceRpcResult);
    }

    private Observable<MyReferralConsultEntityResult> getMyReferralConsult() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createMyReferralEntityData().getMyReferralConsult()).doOnNext(saveReferralCode());
    }

    private boolean isCampaignUpdated(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase(getLastSeenCampaignId())) ? false : true;
    }

    private String getLastSeenCampaignId() {
        return this.generalPreferences.getLatestSeenReferralCampaignId();
    }

    private Function<Throwable, ObservableSource<String>> defaultIfReferralCodeNull() {
        return new Function() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MyReferralConsultEntityRepository.this.m1776x44882788((Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$defaultIfReferralCodeNull$3$id-dana-data-referral-repository-MyReferralConsultEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1776x44882788(Throwable th) throws Exception {
        return referralCode();
    }

    private Observable<String> referralCode() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createMyReferralEntityData().getReferralCode());
        final MyReferralConsultEntityData createLocalMyReferralEntityData = createLocalMyReferralEntityData();
        Objects.requireNonNull(createLocalMyReferralEntityData);
        return authenticatedRequest.doOnNext(new Consumer() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyReferralConsultEntityData.this.saveReferralCode((String) obj);
            }
        }).onErrorResumeNext(Observable.just(""));
    }

    private MyReferralConsultEntityData createMyReferralEntityData() {
        return this.factory.createData2("network");
    }

    private ContentDeliveryEntityData createContentDelivery() {
        return this.contentDeliveryEntityDataFactory.createData2("network");
    }

    private CacheEntityData<SpaceRpcResult> createCacheContentDelivery() {
        return this.contentDeliveryCacheEntityDataFactory.createData2("local");
    }

    private Consumer<MyReferralConsultEntityResult> saveReferralCode() {
        return new Consumer() { // from class: id.dana.data.referral.repository.MyReferralConsultEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyReferralConsultEntityRepository.this.m1780x4490c735((MyReferralConsultEntityResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveReferralCode$4$id-dana-data-referral-repository-MyReferralConsultEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1780x4490c735(MyReferralConsultEntityResult myReferralConsultEntityResult) throws Exception {
        createLocalMyReferralEntityData().saveReferralCode(myReferralConsultEntityResult.getReferralCode());
    }

    private MyReferralConsultEntityData createLocalMyReferralEntityData() {
        return this.factory.createData2("local");
    }
}

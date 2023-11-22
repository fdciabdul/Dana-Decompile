package id.dana.data.referral;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.network.exception.MockGpsDetectedException;
import id.dana.data.referral.mapper.ReferralMapper;
import id.dana.data.referral.source.ReferralEntityData;
import id.dana.data.referral.source.ReferralEntityDataFactory;
import id.dana.data.referral.source.local.model.ReferralEngagementDialogCacheEntity;
import id.dana.data.referral.source.network.result.ReferralConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralEngagementDialogConfigEntity;
import id.dana.data.referral.source.network.result.ReferralStatusConsultRpcResult;
import id.dana.data.referral.source.network.result.ReferralVerifyRpcResult;
import id.dana.domain.geocode.model.IndoSubdivisions;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.ReferralConsultResponse;
import id.dana.domain.referral.model.ReferralEngagementDialogCache;
import id.dana.domain.referral.model.ReferralEngagementDialogConfig;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.domain.referral.model.VerifyReferralCodeResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralEntityRepository implements ReferralRepository {
    private ConfigEntityDataFactory configEntityDataFactory;
    private GeocodeEntityRepository geocodeEntityRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final ReferralMapper mapper;
    private ReferralEntityDataFactory referralEntityDataFactory;

    @Inject
    public ReferralEntityRepository(ReferralMapper referralMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.mapper = referralMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Inject
    public void injectDataFactory(GeocodeEntityRepository geocodeEntityRepository, ReferralEntityDataFactory referralEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory) {
        this.geocodeEntityRepository = geocodeEntityRepository;
        this.referralEntityDataFactory = referralEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
    }

    private ReferralEntityData createNetworkReferralData() {
        return this.referralEntityDataFactory.createData2("network");
    }

    private ReferralEntityData createLocalReferralData() {
        return this.referralEntityDataFactory.createData2("local");
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<ReferralConsultResponse> consult() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNetworkReferralData().consult());
        final ReferralMapper referralMapper = this.mapper;
        Objects.requireNonNull(referralMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralMapper.this.transform((ReferralConsultRpcResult) obj);
            }
        });
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<VerifyReferralCodeResponse> verify(final String str) {
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.holdLoginV1EntityRepository;
        Observable<R> switchMap = this.geocodeEntityRepository.getLatestSubdivisions().switchMap(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralEntityRepository.this.m1775lambda$verify$0$iddanadatareferralReferralEntityRepository(str, (LocationSubdisivision) obj);
            }
        });
        final ReferralMapper referralMapper = this.mapper;
        Objects.requireNonNull(referralMapper);
        return holdLoginV1EntityRepository.authenticatedRequest(switchMap.map(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralMapper.this.transform((ReferralVerifyRpcResult) obj);
            }
        }));
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<ReferralStatusConsultResponse> statusConsult() {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNetworkReferralData().statusConsult());
        final ReferralMapper referralMapper = this.mapper;
        Objects.requireNonNull(referralMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralMapper.this.transform((ReferralStatusConsultRpcResult) obj);
            }
        });
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<ReferralEngagementDialogConfig> getReferralEngagementDialogConfig() {
        return createSplitConfigData().getFeatureReferralEngagementDialogConfig().map(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((ReferralEngagementDialogConfigEntity) obj).toReferralEngagementDialog();
            }
        });
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<Boolean> saveDialogCache(List<ReferralEngagementDialogCache> list) {
        return createLocalReferralData().saveReferralEngagementDialogCache(this.mapper.toDialogCacheEntities(list));
    }

    @Override // id.dana.domain.referral.ReferralRepository
    public Observable<List<ReferralEngagementDialogCache>> getDialogCaches() {
        Observable<List<ReferralEngagementDialogCacheEntity>> dialogCaches = createLocalReferralData().getDialogCaches();
        final ReferralMapper referralMapper = this.mapper;
        Objects.requireNonNull(referralMapper);
        return dialogCaches.map(new Function() { // from class: id.dana.data.referral.ReferralEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralMapper.this.transform((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleIfLocationIsMock  reason: merged with bridge method [inline-methods] */
    public Observable<ReferralVerifyRpcResult> m1775lambda$verify$0$iddanadatareferralReferralEntityRepository(String str, LocationSubdisivision locationSubdisivision) throws MockGpsDetectedException {
        IndoSubdivisions indoSubdivisions = locationSubdisivision.getIndoSubdivisions();
        if (indoSubdivisions.isMockLocation()) {
            throw new MockGpsDetectedException();
        }
        return createNetworkReferralData().verify(str, indoSubdivisions.getCityName());
    }

    private ConfigEntityData createSplitConfigData() {
        return this.configEntityDataFactory.createData2("split");
    }
}

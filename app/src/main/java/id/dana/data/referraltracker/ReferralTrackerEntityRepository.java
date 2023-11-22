package id.dana.data.referraltracker;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.referraltracker.mapper.ReferralTrackerResultMapper;
import id.dana.data.referraltracker.source.ReferralTrackerEntityData;
import id.dana.data.referraltracker.source.ReferralTrackerEntityDataFactory;
import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.model.ReferralTracker;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralTrackerEntityRepository implements ReferralTrackerRepository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final ReferralTrackerResultMapper mapper;
    private final ReferralTrackerEntityDataFactory referralTrackerEntityDataFactory;

    @Inject
    public ReferralTrackerEntityRepository(ReferralTrackerEntityDataFactory referralTrackerEntityDataFactory, ReferralTrackerResultMapper referralTrackerResultMapper, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.referralTrackerEntityDataFactory = referralTrackerEntityDataFactory;
        this.mapper = referralTrackerResultMapper;
        this.configEntityDataFactory = configEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.referraltracker.ReferralTrackerRepository
    public Observable<ReferralTracker> getReferralTracker(final int i, final int i2) {
        return isReferredUserEnable().flatMap(new Function() { // from class: id.dana.data.referraltracker.ReferralTrackerEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ReferralTrackerEntityRepository.this.m1789xa083b434(i, i2, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralTracker$0$id-dana-data-referraltracker-ReferralTrackerEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1789xa083b434(int i, int i2, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createReferralTrackerData().getReferralTracker(i, i2));
            final ReferralTrackerResultMapper referralTrackerResultMapper = this.mapper;
            Objects.requireNonNull(referralTrackerResultMapper);
            return authenticatedRequest.map(new Function() { // from class: id.dana.data.referraltracker.ReferralTrackerEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ReferralTrackerResultMapper.this.apply((ReferralTrackerRpcResult) obj);
                }
            });
        }
        return Observable.error(new ReferredUserFalseException());
    }

    private Observable<Boolean> isReferredUserEnable() {
        return createSplitConfigEntityData().isReferredUserEnabled().onErrorResumeNext(createAMCSConfigEntityData().isReferredUserEnabled());
    }

    private ReferralTrackerEntityData createReferralTrackerData() {
        return this.referralTrackerEntityDataFactory.createData2("network");
    }

    private ConfigEntityData createAMCSConfigEntityData() {
        return this.configEntityDataFactory.createData2("network");
    }

    private ConfigEntityData createSplitConfigEntityData() {
        return this.configEntityDataFactory.createData2("split");
    }
}

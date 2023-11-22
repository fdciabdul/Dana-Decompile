package id.dana.domain.featureconfig.interactor;

import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/featureconfig/interactor/GetDonationCampaignConfig;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/featureconfig/model/DonationCampaignConfig;", "", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lkotlin/Unit;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetDonationCampaignConfig extends UseCase<DonationCampaignConfig, Unit> {
    private final FeatureConfigRepository featureConfigRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetDonationCampaignConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeatureConfigRepository featureConfigRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<DonationCampaignConfig> buildUseCaseObservable(Unit unit) {
        Observable<DonationCampaignConfig> donationCampaignConfig = this.featureConfigRepository.getDonationCampaignConfig();
        Intrinsics.checkNotNullExpressionValue(donationCampaignConfig, "");
        return donationCampaignConfig;
    }
}

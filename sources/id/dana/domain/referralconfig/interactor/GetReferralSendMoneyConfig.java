package id.dana.domain.referralconfig.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referralconfig.model.ReferralConfig;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetReferralSendMoneyConfig extends UseCase<ReferralConfig, Void> {
    private final ReferralConfigRepository referralConfigRepository;

    @Inject
    public GetReferralSendMoneyConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralConfigRepository referralConfigRepository) {
        super(threadExecutor, postExecutionThread);
        this.referralConfigRepository = referralConfigRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ReferralConfig> buildUseCaseObservable(Void r1) {
        return this.referralConfigRepository.getReferralSendMoneyConfig();
    }
}

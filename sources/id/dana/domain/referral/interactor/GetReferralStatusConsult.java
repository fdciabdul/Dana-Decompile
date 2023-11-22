package id.dana.domain.referral.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetReferralStatusConsult extends UseCase<ReferralStatusConsultResponse, Void> {
    private final ReferralRepository referralRepository;

    @Inject
    public GetReferralStatusConsult(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralRepository referralRepository) {
        super(threadExecutor, postExecutionThread);
        this.referralRepository = referralRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ReferralStatusConsultResponse> buildUseCaseObservable(Void r1) {
        return this.referralRepository.statusConsult();
    }
}

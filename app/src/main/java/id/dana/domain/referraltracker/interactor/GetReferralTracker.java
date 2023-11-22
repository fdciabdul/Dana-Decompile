package id.dana.domain.referraltracker.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referraltracker.model.ReferralTracker;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetReferralTracker extends UseCase<ReferralTracker, Params> {
    private final ReferralTrackerRepository referralTrackerRepository;

    @Inject
    public GetReferralTracker(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralTrackerRepository referralTrackerRepository) {
        super(threadExecutor, postExecutionThread);
        this.referralTrackerRepository = referralTrackerRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ReferralTracker> buildUseCaseObservable(Params params) {
        return this.referralTrackerRepository.getReferralTracker(params.pageNum, params.pageSize);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private int pageNum;
        private int pageSize;

        private Params(int i, int i2) {
            this.pageNum = i;
            this.pageSize = i2;
        }

        public static Params forReferralTracker(int i, int i2) {
            return new Params(i, i2);
        }
    }
}

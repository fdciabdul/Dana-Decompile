package id.dana.domain.referral.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.VerifyReferralCodeResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class VerifyReferralCode extends UseCase<VerifyReferralCodeResponse, Params> {
    private ReferralRepository referralRepository;

    @Inject
    public VerifyReferralCode(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, ReferralRepository referralRepository) {
        super(threadExecutor, postExecutionThread);
        this.referralRepository = referralRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<VerifyReferralCodeResponse> buildUseCaseObservable(Params params) {
        return this.referralRepository.verify(params.referralCode);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private String referralCode;

        private Params(String str) {
            this.referralCode = str;
        }

        public static Params forReferralVerify(String str) {
            return new Params(str);
        }
    }
}

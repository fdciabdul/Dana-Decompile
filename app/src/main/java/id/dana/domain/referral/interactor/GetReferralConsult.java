package id.dana.domain.referral.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class GetReferralConsult extends UseCase<MyReferralConsultRpcResponse, Void> {
    private final MyReferralConsultRepository myReferralConsultRepository;

    @Inject
    public GetReferralConsult(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MyReferralConsultRepository myReferralConsultRepository) {
        super(threadExecutor, postExecutionThread);
        this.myReferralConsultRepository = myReferralConsultRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<MyReferralConsultRpcResponse> buildUseCaseObservable(Void r1) {
        return this.myReferralConsultRepository.getReferralConsult();
    }
}

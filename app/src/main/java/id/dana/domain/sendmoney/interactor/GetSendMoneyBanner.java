package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes8.dex */
public class GetSendMoneyBanner extends UseCase<CdpContent, Void> {
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public GetSendMoneyBanner(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<CdpContent> buildUseCaseObservable(Void r1) {
        return this.sendMoneyRepository.getSendMoneyBanner();
    }
}

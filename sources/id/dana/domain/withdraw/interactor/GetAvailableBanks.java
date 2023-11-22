package id.dana.domain.withdraw.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class GetAvailableBanks extends UseCase<TransferInit, Void> {
    private static String BANK = "BANK_TRANSFER";
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public GetAvailableBanks(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<TransferInit> buildUseCaseObservable(Void r2) {
        return this.sendMoneyRepository.getTransferOption(BANK);
    }
}

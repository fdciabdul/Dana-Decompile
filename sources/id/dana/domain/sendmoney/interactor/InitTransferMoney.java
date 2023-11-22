package id.dana.domain.sendmoney.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class InitTransferMoney extends UseCase<TransferInit, Params> {
    private final SendMoneyRepository sendMoneyRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public InitTransferMoney(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SendMoneyRepository sendMoneyRepository) {
        super(threadExecutor, postExecutionThread);
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<TransferInit> buildUseCaseObservable(Params params) {
        return this.sendMoneyRepository.transferInit(params.transferInitParam);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private static final String BALANCE = "BALANCE";
        private TransferInitParam transferInitParam;

        private Params(TransferInitParam transferInitParam) {
            this.transferInitParam = transferInitParam;
        }

        public static Params forSendMoneyInit(TransferInitParam transferInitParam) {
            return new Params(transferInitParam);
        }

        public static Params forTransferMethodOnly() {
            TransferInitParam transferInitParam = new TransferInitParam();
            transferInitParam.setTransferMethod("BALANCE");
            transferInitParam.setNeedTransferMethod(true);
            return new Params(transferInitParam);
        }
    }
}
